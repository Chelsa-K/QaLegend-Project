package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendLoginPage {
	WebDriver driver;
	
	@FindBy(id = "email")
	WebElement usernameField;
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block mt15']")
	WebElement loginButton;
	
	
	
	
	
	
	
	public QaLegendLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}







	public void loginToQaLegend(String username, String password ) {
		PageUtilities.enterText(usernameField, username);
		PageUtilities.enterText(passwordField, password);
		PageUtilities.clickOnAnElement(loginButton);
		
	}

}
