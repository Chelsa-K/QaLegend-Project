
package TestScripts;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import AutomationCore.BaseClass;
import Utilities.FakerUtility;
import Utilities.RetryAnalyzer;

public class QaLegendProductInvoiceTest extends BaseClass {
	
	
	
@Test(retryAnalyzer = RetryAnalyzer.class)	
public void addInvoice() {
	
	SoftAssert softAssert = new SoftAssert();
	loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
	dashboard.clickOnInvoicesOptionButton();
	invoicesPage.createInvoice(prop.getProperty("note") + FakerUtility.getRandomNumber());
	invoicesPage.clickOnInvoiceSaveButton();
	softAssert.assertEquals(invoicesPage.getInvoiceNumber(), true);
	softAssert.assertAll();   
		
}


@Test (retryAnalyzer = RetryAnalyzer.class)
public void addItemToNewInvoice() {
	
	loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
	dashboard.clickOnInvoicesOptionButton();
	invoicesPage.addingItemToAnInvoiceCreated(prop.getProperty("itemnote") + FakerUtility.getRandomNumber());
	invoicesPage.fillingItemForm(prop.getProperty("item"),prop.getProperty("quantity"),prop.getProperty("itemrate"));
	Assert.assertEquals(invoicesPage.checkIfItemIsAdded(), true);   
}

}
