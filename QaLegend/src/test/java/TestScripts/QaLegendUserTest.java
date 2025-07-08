package TestScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import AutomationCore.BaseClass;
import Constants.Constant;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.WaitUtility;

public class QaLegendUserTest extends BaseClass{
	
	
	@Test
	public void addClient() throws IOException {     //tc01
		
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password")); //fetching data using property file
		dashboard.clickOnClientOptionButton();
		//read data from excel file
		String companyName = ExcelUtility.readStringData(1, 0, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails")+ FakerUtility.getRandomNumber(); //to generate company name with random suffix ranges bet 1- 100000
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), ExcelUtility.readIntegerData(1, 1, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails"));
		clientPage.searchClient(companyName);
		Assert.assertEquals(clientPage.getCompanyCellValue(), companyName);  //hard assertion
	}
	
	
	
	@Test
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

		System.out.println(cityCellValue);
		System.out.println(newcityName);
		
		softAssert.assertEquals(cityCellValue, newcityName); //soft assertion
		softAssert.assertAll();   
	}
	
	
	
	@Test  
	public void deleteAClient() throws IOException, InterruptedException {   //tc03- to delete a client using delete button
		
		SoftAssert softAssert = new SoftAssert();

		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String companyName = ExcelUtility.readStringData(3, 0, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails") + FakerUtility.getRandomNumber();
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), ExcelUtility.readIntegerData(3, 1, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails"));
		clientPage.searchClient(companyName);
		clientPage.clickOnDeleteButton();
		
		clientPage.searchClient(companyName);
		clientPage.displayMessageCellValue();
		System.out.println(clientPage.displayMessageCellValue());

		softAssert.assertEquals(clientPage.displayMessageCellValue(),"No record found.");         
		softAssert.assertAll();   	
	}
	
	
	
	@Test
	public void selectClientsToDisplayUsingDropdown() { ///---------------FAIL
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		clientPage.selectNumOfClientsToDisplay();
		clientPage.numberOfClientsDisplayedInFirstPage();
		
		Assert.assertEquals(clientPage.numberOfClientsDisplayedInFirstPage(), "50");
		
	}
	
	@Test
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
	
	@Test
	public void searchForAnUnlistedClient() {
		
		SoftAssert softAssert = new SoftAssert();
 
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		clientPage.enterUnlistedClientNameInSearchbox(prop.getProperty("NonExistingClient")+FakerUtility.getRandomNumber());  
		clientPage.messageDisplayed();
		softAssert.assertEquals(clientPage.messageDisplayed(), "No record found."); 
		softAssert.assertAll();   		
	}

}
