package TestScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
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


@Test(retryAnalyzer = RetryAnalyzer.class)
public void addPayment() {
	
	loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
	dashboard.clickOnInvoicesOptionButton();
	invoicesPage.createPayment(prop.getProperty("payment"));
	invoicesPage.clickOnSaveButton();
	
	//Assert.
}


@Test //(retryAnalyzer = RetryAnalyzer.class)
public void addItemToNewInvoice() {
	
	loginPage.loginToQaLegend(prop.getProperty("username"), prop.getProperty("password"));
	dashboard.clickOnInvoicesOptionButton();
	invoicesPage.addingItemToAnInvoiceCreated(prop.getProperty("itemnote") + FakerUtility.getRandomNumber());
	invoicesPage.fillingItemForm("Dotty", "23", "18000");
	invoicesPage.checkIfItemIsAdded();
	Assert.assertEquals(invoicesPage.checkIfItemIsAdded(), true);   ///correct ?
}

}
