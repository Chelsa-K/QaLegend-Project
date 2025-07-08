package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendHomePage {
WebDriver driver;
@FindBy (xpath = "//span[text()='Clients']")
WebElement clientOptionButton;
//
@FindBy (xpath = "//span[text()='Invoices']")
WebElement invoicesOptionButton;
//
@FindBy(xpath = "//span[text()='Items']")
WebElement itemsOptionButton;
//
@FindBy(xpath = "//span[text()='Projects']")
WebElement projectsOptionButton;
@FindBy(xpath = "//span[text()='All Projects']")
WebElement allProjectsButton;





public QaLegendHomePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}







public QaLegendHomePage  clickOnClientOptionButton() {
	PageUtilities.clickOnAnElement(clientOptionButton);
	return this;   //if we do not return anything in a method but performing an action-chaining of pages
	
}

public QaLegendHomePage clickOnInvoicesOptionButton() {
	PageUtilities.clickOnAnElement(invoicesOptionButton);
	return this;
}

public QaLegendHomePage clickOnItemsButton() {
	PageUtilities.clickOnAnElement(itemsOptionButton);
	return this;
	
}
public QaLegendHomePage clickOnProjectsButton() {
	PageUtilities.clickOnAnElement(projectsOptionButton);
	PageUtilities.clickOnAnElement(allProjectsButton);
	return this;
	
}
}
