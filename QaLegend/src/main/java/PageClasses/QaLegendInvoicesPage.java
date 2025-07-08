package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendInvoicesPage {
	WebDriver driver;
	
	@FindBy(xpath = "(//a[@class='btn btn-default mb0'])[2]")
	WebElement addInvoiceButton;
	@FindBy(id = "invoice_due_date")
	WebElement dueDateField;
	@FindBy(xpath = "//td[@class='today active day']")
	WebElement currentDay;
	
	@FindBy(id = "select2-chosen-12")
	WebElement clientDropdown;
	@FindBy(xpath = "(//span[@class='select2-match'])[3]")
	WebElement clickClientToBeSelected;
	@FindBy(xpath = "//div[@id='s2id_autogen7']")
	WebElement taxField;
	@FindBy(id = "invoice_note")
	WebElement noteField;
	@FindBy(xpath = "//button[@class='btn btn-primary']") //save button
	WebElement invoiceSaveButton;
	@FindBy(xpath = "//div[@class='page-title clearfix mt15']//child::h1")
	WebElement invoiceNumber;
	@FindBy(xpath = "//span[@class='invoice-info-title']")
	WebElement newInvoiceTitle;
	
	
	
	@FindBy(xpath = "(//div[@class='title-button-group']//child::a)[1]")
	WebElement addPaymentButton;
	
	@FindBy(id = "select2-chosen-7")
	WebElement selectInvoiceDropdownField; ////???????
	
	@FindBy(id = "invoice_payment_date")
	WebElement paymentDateField;
	@FindBy(id = "//td[@class='today day']")
	WebElement selectCurrentDay;
	@FindBy(id = "invoice_payment_amount")
	WebElement amountField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement paymentSaveButton;
	@FindBy(xpath = "(//span[@class='mt0 label label-success large'])[1]")
	WebElement paymentStatusField;
	
	
	
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")  // (//i[@class='fa fa-plus-circle']//parent::a)[2]
	WebElement addItemButton;
	@FindBy(id = "select2-chosen-3")
	WebElement selectItemField;
	
	@FindBy(id="s2id_autogen3_search")
	WebElement searchItemList;
	@FindBy(xpath = "//div[@class='select2-result-label']//child::span")
	WebElement newItemSelected;
	@FindBy(id = "invoice_item_quantity")
	WebElement itemQuantityField;
	@FindBy(id = "invoice_item_rate")
	WebElement itemRateField;
	@FindBy(xpath = "//div[@class='item-row strong mb5']")
	WebElement itemCellValue;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement itemSaveButton;
	
	

	
	
	
	
	
	
	
	
	public QaLegendInvoicesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
//TC--to add a new invoice
	
	public QaLegendInvoicesPage createInvoice(String note) {
		addInvoiceButton.click();
		PageUtilities.clickOnAnElement(dueDateField);
		//PageUtilities.clickOnAnElement(currentDay);
		PageUtilities.sendEnterKey(driver);
		clientDropdown.click();
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendEnterKey(driver);
		WaitUtility.waitForElementToBeVisible(driver, clientDropdown);
		//PageUtilities.clickOnAnElement(clickClientToBeSelected);
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendEnterKey(driver);
		taxField.click();
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendEnterKey(driver);
		PageUtilities.enterText(noteField, note);
		return this;	
	}
	
	public QaLegendInvoicesPage clickOnInvoiceSaveButton() {
		PageUtilities.clickOnAnElement(invoiceSaveButton);
		return this;	
	}
	
	public boolean getInvoiceNumber() {
		return (newInvoiceTitle.isDisplayed());	
	}
	
	public QaLegendInvoicesPage createPayment(String amount) {
		PageUtilities.clickOnAnElement(addPaymentButton);
		selectInvoiceDropdownField.click();
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendEnterKey(driver);
		PageUtilities.clickOnAnElement(paymentDateField);
		//selectCurrentDay.click();
		PageUtilities.sendEnterKey(driver);
		PageUtilities.enterText(amountField, amount);
		return this;
	}
	public QaLegendInvoicesPage clickOnSaveButton() {
		PageUtilities.clickOnAnElement(paymentSaveButton);
		return this;	
	}
	
//TC-to add item to a new invoice created
	
	public QaLegendInvoicesPage addingItemToAnInvoiceCreated(String note) {
		addInvoiceButton.click();
		PageUtilities.clickOnAnElement(dueDateField);
		PageUtilities.sendEnterKey(driver);
		clientDropdown.click();
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendEnterKey(driver);
		WaitUtility.waitForElementToBeVisible(driver, clientDropdown);
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendEnterKey(driver);
		PageUtilities.enterText(noteField, note);
		PageUtilities.clickOnAnElement(invoiceSaveButton);
		WaitUtility.waitForElementToBeInVisible(driver, invoiceSaveButton);
		addItemButton.click();
		return this;
	}
	public QaLegendInvoicesPage fillingItemForm(String value, String number, String rate) {
		
		selectItemField.click();
		PageUtilities.enterText(searchItemList, value );
		newItemSelected.click();
		PageUtilities.enterText(itemQuantityField,number );
		PageUtilities.enterText(itemRateField, rate);
		PageUtilities.clickOnAnElement(itemSaveButton);
		return this;	
	}
	public Boolean checkIfItemIsAdded() {
		return(PageUtilities.checkIsElementDisplayed(itemCellValue));	
	}	
		
	


	


}

