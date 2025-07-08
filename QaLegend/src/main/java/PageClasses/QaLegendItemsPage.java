package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendItemsPage {

	WebDriver driver;
	
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addItemButton;
	
	@FindBy(id = "title")
	WebElement titleField;
	@FindBy(id = "description")
	WebElement descriptionField;
	@FindBy(id = "item_rate")
	WebElement rateField;
	@FindBy(xpath = "(//div[@class='modal-footer']//descendant ::button)[2]")
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@id='item-table_filter']//descendant ::input")
	WebElement searchbox;
	
	@FindBy(xpath = "(//tr[@class='odd' or @class='even']//descendant ::td)[1]")
	WebElement titleCell;
	
	@FindBy(xpath = "//i[@class='fa fa-times fa-fw']//parent::a")
	WebElement deleteButton;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement displayMessageCell;
	
	
	
	
	
	
	
	
	
	
	
	
	

	public QaLegendItemsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public QaLegendItemsPage createNewItem(String title, String description, CharSequence rate) {
		PageUtilities.clickOnAnElement(addItemButton);
		PageUtilities.enterText(titleField, title);
		PageUtilities.enterText(descriptionField, description);
		rateField.sendKeys(rate);
		PageUtilities.clickOnAnElement(saveButton);
		return this;
		
	}
	
	public void searchItemCreated(String itemName) {
		WaitUtility.waitForElementToBeInVisible(driver, saveButton);
		PageUtilities.enterText(searchbox, itemName);	
	}
	
	public String getTitleCellValue() {
		String titleCellValue = PageUtilities.getTextFromAnElement(titleCell);
		return titleCellValue;
	}
	
	public QaLegendItemsPage clickOnDeleteButton() {
		PageUtilities.clickOnAnElement(deleteButton);
		return this;
	}
	
	public boolean checkMessageDisplayed() {
		boolean messageDisplayed = PageUtilities.checkIsElementDisplayed(displayMessageCell);
		return messageDisplayed;	
	}
	
	

	






}
