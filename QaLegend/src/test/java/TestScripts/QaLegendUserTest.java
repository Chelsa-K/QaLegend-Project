package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import org.testng.Assert;
import AutomationCore.BaseClass;
import Constants.Constant;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.RetryAnalyzer;

public class QaLegendUserTest extends BaseClass{
	
	
	@Test(groups = {"smoke", "regression"}, retryAnalyzer = RetryAnalyzer.class)
	public void addClient() throws IOException {     //tc01
		
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password")); //fetching data using property file
		dashboard.clickOnClientOptionButton();
		//read data from excel file
		String companyName = ExcelUtility.readStringData(1, 0, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails")+ FakerUtility.getRandomNumber(); //to generate company name with random suffix ranges bet 1- 100000
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), ExcelUtility.readIntegerData(1, 1, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails"));
		clientPage.searchClient(companyName);
		Assert.assertEquals(clientPage.getCompanyCellValue(), companyName);  //hard assertion
	}
	
	
	
	@Test(groups = {"smoke", "regression"},retryAnalyzer = RetryAnalyzer.class)
	public void editClient() throws IOException {  

		SoftAssert softAssert = new SoftAssert(); //instantiate softAssert class
		
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String companyName =ExcelUtility.readStringData(2, 0, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails")+ FakerUtility.getRandomNumber();
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), ExcelUtility.readIntegerData(2, 1, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails"));
		clientPage.searchClient(companyName);
		
		clientPage.editClientButtonClick();       				//edit a client' data field using edit button
		String newcityName= FakerUtility.getFakerCityName();
		clientPage.editCityName(newcityName);
		clientPage.searchClient(companyName);
		clientPage.clickOnEditIcon();
		String cityCellValue=clientPage.getCityCellValue();     
		softAssert.assertEquals(cityCellValue, newcityName); //soft assertion
		softAssert.assertAll();   
	}
	
	
	
	@Test (groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
	public void deleteAClient() throws IOException, InterruptedException {   //tc03- to delete a client using delete button
		
		SoftAssert softAssert = new SoftAssert();

		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String companyName = ExcelUtility.readStringData(3, 0, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails") + FakerUtility.getRandomNumber();
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), ExcelUtility.readIntegerData(3, 1, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails"));
		clientPage.searchClient(companyName);
		clientPage.clickOnDeleteButton();
		clientPage.searchClient(companyName);
		softAssert.assertEquals(clientPage.displayMessageCellValue(),"No record found.");         
		softAssert.assertAll();   	
	}
	
	
	
	@Test(groups = {"smoke", "regression"},retryAnalyzer = RetryAnalyzer.class)
	public void selectClientsToDisplayUsingDropdown() {
		SoftAssert softAssert = new SoftAssert();
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		clientPage.selectNumOfClientsToDisplay();
		softAssert.assertEquals(clientPage.numberOfClientsDisplayedInFirstPage(), 50);
		softAssert.assertAll();
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void addClientContactInDetailsPage() throws IOException {
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String companyName ="Falcon"+ FakerUtility.getRandomNumber();
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), "618365836");
		clientPage.searchClient(companyName);
		String emailID = ExcelUtility.readStringData(1, 2, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails")+FakerUtility.getRandomNumber()+prop.getProperty("email");
		clientPage.clientContactDeatails(FakerUtility.getFakerFirstName(), FakerUtility.getFakerLastName(),emailID);
		Assert.assertEquals(clientPage.contactVerification(), true);
		
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void searchForAnUnlistedClient() {
		
		SoftAssert softAssert = new SoftAssert();
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		clientPage.enterUnlistedClientNameInSearchbox(prop.getProperty("NonExistingClient")+FakerUtility.getRandomNumber());  
		softAssert.assertEquals(clientPage.messageDisplayed(), "No record found."); 
		softAssert.assertAll();   		
	}

}
