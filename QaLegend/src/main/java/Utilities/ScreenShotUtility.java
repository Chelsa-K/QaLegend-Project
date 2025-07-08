package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {
	
	public void captureFailureScreenShot(WebDriver driver, String testcaseName) throws IOException {
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File screenshot = scrshot.getScreenshotAs(OutputType.FILE);
		File f1 = new File(System.getProperty("user.dir")+"//OutputScreenShots");
		
		if(!f1.exists())
		{
			f1.mkdirs();
		}
		String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date(0));  //MM- month, mm-minute, ss-seconds
		File finalDestination = new File(System.getProperty("user.dir")+"//OutputScreenShots//"+testcaseName+"_"+timestamp+".png");
		org.openqa.selenium.io.FileHandler.copy(screenshot, finalDestination);
		
	}

}
