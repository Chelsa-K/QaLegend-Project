package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public static void fileUploadUsingRobotClass(String path) throws AWTException {
		StringSelection ss = new StringSelection(path);     //edit clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot =new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void fileUploadUsingSendKeys(WebElement element, String path) {
		element.sendKeys(path);	
	}

}
