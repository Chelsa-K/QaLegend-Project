package Utilities;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	//click element
	public static void clickOnAnElement(WebElement element) {
		element.click();	
	}
	
	//enter text sendkey
	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	//action double-click 
	public static void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	//selectByVisibleText
	public static void selectDropdownByVisibleText(WebElement element,String value) {
		Select obj = new Select(element);
		obj.selectByVisibleText(value);
	}
	
	//to get a Text
	public static String getTextFromAnElement(WebElement element) {
		return(element.getText());
	}
	
	//Drag&Drop
	public static void dragAndDrop(WebDriver driver,WebElement source, WebElement destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}
	
	//backspace/clear texts
	public static void clearText(WebElement element) {
		element.clear();	
	}
	
	//scroll using JS
	public static void scrollTillElementVisible(WebDriver driver,WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor)driver; //to convert Java compiler to JavaScript compiler
		 js.executeScript("arguments[0].scrollIntoView(true);", element );
	}
	
	//selectByValue
	public static void selectDropdownByValue(WebElement element,String value) {
		Select drop2 = new Select(element);
		drop2.selectByValue(value);	
	}
	
	//selectByIndex
	public static void selectDropdownByIndex(WebElement element,int index) { //int ??
		Select drop3 = new Select(element);
		drop3.selectByIndex(index);	
	}
	
	//to get attribute value
	public static String getAttributeValueOfAnElement(WebElement element,String value) {
		
		return(element.getAttribute(value)); 
	}
	
	//Rightclick- Mouse action
	public static void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	//Keyboard-Enter key
	public static void sendEnterKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public static void sendReturnKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.RETURN).perform();
	}
	
	//Control key
	public static void sendCtrlKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.CONTROL).perform();
	}
	//Command key
	public static void sendCommandKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.COMMAND).perform();
	}
	//Escape key
	public static void sendEscapeKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
	}
	
	public static void sendArrowKeyDown(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
	}
	
	public static void sendArrowKeyUp(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_UP).perform();
	}
	
	//JS| click HiddenElement
	public static void clickWithJavascript(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element); 
	}
	
	//isEnabled
	public static boolean checkIsElementEnabled(WebElement element) {
		return element.isEnabled() ;
		
	}
	//isDisplayed
	public static boolean checkIsElementDisplayed(WebElement element) {
		return element.isDisplayed();
		
	}
	//Alert accept
	public static void acceptAnAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	//Alert dismiss
	public static void dismissAnAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}
	//Fetch alert message
	public static String getTextFromAnAlert(WebDriver driver, String value) {
		value=driver.switchTo().alert().getText();
		return value;
	}
	
	public static String getTextUsingClipBoard(WebDriver driver, WebElement element) throws InterruptedException, UnsupportedFlavorException, IOException {
		
		Actions actions = new Actions(driver);
		WaitUtility.waitForElementToBeVisible(driver, element);
		
		element.click();
		
		actions.doubleClick(element).build().perform();

        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
     
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        

        // Small delay to ensure clipboard is populated
     

        // Read from clipboard
        Clipboard clipboard = toolkit.getSystemClipboard(); //toolkit is in Clipboard Class
        String copiedText = (String) clipboard.getData(DataFlavor.stringFlavor);
        System.out.println("Clipboard Data" +copiedText);
        return copiedText;
		
	}

	

		
	

}
