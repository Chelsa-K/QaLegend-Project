package TestScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.asserts.SoftAssert;

import AutomationCore.BaseClass;
import Constants.Constant;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.RetryAnalyzer;

public class QaLegendProjectTest extends BaseClass{
	
	
	
@Test	(retryAnalyzer = RetryAnalyzer.class)
public void addProject() throws IOException {
		
	SoftAssert softAssert = new SoftAssert();
	
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		dashboard.clickOnProjectsButton();
		String title= ExcelUtility.readStringData(1, 0, Constant.CLIENTDATAEXCELFILEPATH, "ProjectDetails")+ FakerUtility.getRandomNumber();
		String projDescription= ExcelUtility.readStringData(1, 1, Constant.CLIENTDATAEXCELFILEPATH, "ProjectDetails")+ FakerUtility.getRandomNumber();
		projectsPage.createProject(title, projDescription);
		projectsPage.searchProject(title);
		softAssert.assertEquals(projectsPage.getTitleCellValue(), title);
		softAssert.assertAll(); 
		
	}
	

}
