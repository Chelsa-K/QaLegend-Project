package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendProjectPage {
	
	WebDriver driver;
	
	@FindBy(xpath ="//div[@class='title-button-group']//child::a" )
	WebElement addProjectButton;
	@FindBy(id = "title")
	WebElement titleField;
	@FindBy(id="description")
	WebElement descriptionField;
	
	@FindBy (id = "start_date")
	WebElement startDateField;
	@FindBy(xpath = "//td[@class='today day']")
	WebElement selectCurrentDay;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement projectSaveButton;
	@FindBy(xpath = "//div[@id='project-table_filter']//descendant::input")
	WebElement searchBox;
	@FindBy(xpath = "(//tr[@class='odd' or @class='even']//child::td)[2]")
	WebElement titleCell;
	
	
		
	
	
	
	public QaLegendProjectPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	

	
	public QaLegendProjectPage createProject(String title, String description) {
		addProjectButton.click();
		PageUtilities.enterText(titleField, title);
		PageUtilities.enterText(descriptionField, description);
		startDateField.click();
		PageUtilities.clickOnAnElement(selectCurrentDay);
		
		PageUtilities.clickOnAnElement(projectSaveButton);	
		return this;
	}
	
	public String searchProject(String title) {
		WaitUtility.waitForElementToBeInVisible(driver,projectSaveButton );

		PageUtilities.clearText(searchBox);
		PageUtilities.clickOnAnElement(searchBox);
		PageUtilities.enterText(searchBox, title);
		return title;
		
	}
	
	
	public String getTitleCellValue() {
		String titleCellValue = PageUtilities.getTextFromAnElement(titleCell);
		return titleCellValue;
	}
	
	
	
	

}
