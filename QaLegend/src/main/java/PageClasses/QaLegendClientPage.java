package PageClasses;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendClientPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addClientButton;  // create a new client
	@FindBy(id = "company_name")
	WebElement companyNameField;
	@FindBy(id = "address")
	WebElement addressField;
	@FindBy(id = "city")
	WebElement cityFieldTextBox;
	@FindBy(id = "state")
	WebElement stateField;
	@FindBy(id = "phone")
	WebElement phoneField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@id='client-table_filter']//descendant ::input")
	WebElement searchBox;   //search box the new client created
	
	@FindBy(xpath = "(//tr[@class='odd' or@class='even']//descendant ::a)[1]")
	WebElement clientCell;
	
	@FindBy(xpath = "(//table[@id='client-table']//descendant ::i)[2]")
	WebElement editButton;	//edit button
	@FindBy(xpath = "//input[@id='city']")
	WebElement cityField;
	@FindBy(xpath = "(//div[@id='ajaxModalContent']//descendant ::button)[2]")
	WebElement saveButtonInEditPage;
	@FindBy(xpath = "//i[@class='fa fa-pencil']//parent::a")
	WebElement clientEditButton;
	
	@FindBy(xpath = "(//tr[@class='odd' or @class='even']//descendant ::a)[1]")
	WebElement clientNameCell;	//client cell
	
	@FindBy(xpath = "//a[text()=' Client info']")
	WebElement clientInfoButton;	//client info 
	@FindBy(xpath = "//input[@id='city']")
	WebElement getCityName;
	
	@FindBy(xpath = "(//table[@id='client-table']//descendant ::a)[3]")
	WebElement deleteButton;	//delete button
	@FindBy(id = "confirmDeleteButton")
	WebElement deleteConfirmationButton;
	@FindBy(xpath = "//table[@id='client-table']//descendant ::td")
	WebElement displayMessageCell;
	
	@FindBy(xpath = "(//a[@class='select2-choice'])[1]")
	WebElement idDropdown;
	@FindBy(xpath = "(//div[@class='select2-container']")
	WebElement numberOfClientsDisplayed;
	
	@FindBy(xpath = "//tr[@class='odd' or @class='even']")
	List<WebElement>cellRows;
	
	@FindBy(xpath = " (//i[@class='fa fa-plus-circle']//parent ::a)[2]") //add contact details
	WebElement addContactButton;
	@FindBy(id = "first_name")
	WebElement firstNameField;
	@FindBy(id = "last_name")
	WebElement lastNameField;
	@FindBy(id = "email")
	WebElement emailField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement addContactSaveButton;
	@FindBy(xpath = "(//table[@id='contact-table']//descendant::a)[1]")
	WebElement contactNameCell;
	
	
	@FindBy(xpath = "//tr[@class='odd' or @class='even']//child::td")
	WebElement displayMessage;
	
	
	
	
	
	public QaLegendClientPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCityNameValue() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		return (PageUtilities.getTextUsingClipBoard(driver, getCityName));
		
	}

//to create a new client
	public QaLegendClientPage createClient(String companyName, String address, String phone) {
		PageUtilities.clickOnAnElement(addClientButton);
		PageUtilities.enterText(companyNameField, companyName);
		PageUtilities.enterText(addressField, address);
		phoneField.sendKeys(phone);
		saveButton.click();
		return this;
	}
	
	//to search a client 
	public void searchClient(String clientName) {     
		
		WaitUtility.waitForElementToBeInVisible(driver, saveButton);
		
		PageUtilities.clearText(searchBox);
		PageUtilities.enterText(searchBox, clientName);
	}
	
	//to get text from a cell
	public String getCompanyCellValue() {
		
		String companyCellValue = PageUtilities.getTextFromAnElement(clientCell);
		return companyCellValue;
	}
	
 //to click edit button
	public QaLegendClientPage editClientButtonClick() {
		PageUtilities.clickOnAnElement(editButton);
		return this;
	}
	
	//to edit a field
	public QaLegendClientPage editCityName(String cityName) {
		PageUtilities.clearText(cityField);
		PageUtilities.enterText(cityField, cityName);
		saveButtonInEditPage.click();

		return this;	
	}
	public QaLegendClientPage clickOnEditIcon() {
		PageUtilities.clickOnAnElement(clientEditButton);
		return this;
	}
	
	public String getCityCellValue() {
		PageUtilities.clickOnAnElement(cityField);
		String cityCellValue = PageUtilities.getAttributeValueOfAnElement(cityField,"value");
		return cityCellValue;	 
	}

	
//to delete a client
	public QaLegendClientPage clickOnDeleteButton() throws InterruptedException {
		PageUtilities.clickOnAnElement(deleteButton);
		WaitUtility.waitForElementToBeClickable(driver, deleteConfirmationButton);
		deleteConfirmationButton.click();
		return this;
		
	}
	public String displayMessageCellValue() {
		
		return (displayMessageCell.getText()); 
	}
	
//select no of clients to display using dropdown
	public QaLegendClientPage selectNumOfClientsToDisplay() {
		
		PageUtilities.clickOnAnElement(idDropdown);
		
		PageUtilities.sendEnterKey(driver);
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendArrowKeyDown(driver);
		PageUtilities.sendEnterKey(driver);
		
		return this;
		
	}
	public int numberOfClientsDisplayedInFirstPage() {
		
		return cellRows.size();
		
	}
	
//add contact details to a client
	public void clientContactDeatails(String firstName, String lastName, String email) {
		PageUtilities.clickOnAnElement(clientNameCell);
		PageUtilities.clickOnAnElement(addContactButton);
		PageUtilities.enterText(firstNameField, firstName);
		PageUtilities.enterText(lastNameField, lastName);
		PageUtilities.enterText(emailField, email);
		addContactSaveButton.click();
			
	}

	
	public boolean contactVerification() {
		return (PageUtilities.checkIsElementDisplayed(contactNameCell));
		
	}
	
//search unlisted client
	
	public void enterUnlistedClientNameInSearchbox(String unlistedClientName) {     
		PageUtilities.clearText(searchBox);
		PageUtilities.enterText(searchBox, unlistedClientName);
	}
	public String messageDisplayed() {
		
		return (displayMessage.getText());
	}

}
