package TestScripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AutomationCore.BaseClass;
import Constants.Constant;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QaLegendProductItemsTest extends BaseClass {
	
	
	
	@Test
	public void addAnItem() {  
		
		SoftAssert softAssert = new SoftAssert();
		
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnItemsButton();
		String title = prop.getProperty("title") + FakerUtility.getRandomNumber();
		String description = prop.getProperty("description") + FakerUtility.getRandomNumber();
		CharSequence rate = prop.getProperty("rate");
		itemsPage.createNewItem(title, description, rate);
		itemsPage.searchItemCreated(title);
		System.out.println(title);
		System.out.println(itemsPage.getTitleCellValue());
		
		softAssert.assertEquals(title, itemsPage.getTitleCellValue());
		softAssert.assertAll();	
		
	}
	
@Test	
public void deleteAnItem() throws IOException {  
		
		SoftAssert softAssert = new SoftAssert();
		
		loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnItemsButton();
		String title = ExcelUtility.readStringData(1, 0, Constant.ITEMDATAEXCELFILEPATH, "ItemDetails") + FakerUtility.getRandomNumber();
		String description = ExcelUtility.readStringData(1, 1, Constant.ITEMDATAEXCELFILEPATH, "ItemDetails") + FakerUtility.getRandomNumber();
		CharSequence rate = ExcelUtility.readIntegerData(1, 2, Constant.ITEMDATAEXCELFILEPATH, "ItemDetails");
		itemsPage.createNewItem(title, description, rate);
		itemsPage.searchItemCreated(title);
		itemsPage.clickOnDeleteButton();
		itemsPage.checkMessageDisplayed();
		System.out.println(itemsPage.checkMessageDisplayed());
		
		softAssert.assertEquals(itemsPage.checkMessageDisplayed(), true);
		softAssert.assertAll();	
}

	
}
	
	

