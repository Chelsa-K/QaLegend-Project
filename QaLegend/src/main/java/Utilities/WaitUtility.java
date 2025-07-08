package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constant;

public class WaitUtility {
	public static void waitForElementToBeClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT)); //since static, class name is enough\
		wait.until(ExpectedConditions.elementToBeClickable(target));  //until target is clickable
			
	}

	public static void waitForElementToBePresent(WebDriver driver, WebElement target, String value) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT)); //since static, class name is enough\
		wait.until(ExpectedConditions.textToBePresentInElement(target, value));  //until target is present
		
	}
	public static void waitForElementToBeVisible(WebDriver driver, WebElement target) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT)); //since static, class name is enough\
		wait.until(ExpectedConditions.visibilityOf(target));  //until target is present
	}

	public static void waitForElementToBeInVisible(WebDriver driver, WebElement target) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT)); //since static, class name is enough\
		wait.until(ExpectedConditions.invisibilityOf(target));  //until target is present
	}
	public static void waitForAnAlert(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT)); //since static, class name is enough\
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
}
