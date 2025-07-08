package AutomationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PageClasses.QaLegendClientPage;
import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendInvoicesPage;
import PageClasses.QaLegendItemsPage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendProjectPage;
import Utilities.ScreenShotUtility;

public class BaseClass {
	
public WebDriver driver;

 public QaLegendLoginPage loginPage;
 public QaLegendHomePage dashboard;
 public QaLegendClientPage clientPage;
 public QaLegendInvoicesPage invoicesPage;
 public QaLegendItemsPage itemsPage;
 public QaLegendProjectPage projectsPage;
	public Properties prop;
	public FileInputStream fis;
	
	public WebDriver browserInitialisation (String browserName) throws Exception {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}
		
		else {
			throw new Exception("Invalid Name Exception");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
	}

@BeforeMethod 
@Parameters({"browser"})
 

public void initialisation  (String browserName) throws Exception {
	System.out.println("before method");
	driver= browserInitialisation (browserName);
	
	fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//TestData//ApplicationData.properties");
	prop=new Properties();
	prop.load(fis);
	
	 loginPage = new QaLegendLoginPage(driver);
	 dashboard = new QaLegendHomePage(driver);
	 clientPage = new QaLegendClientPage(driver);
	 invoicesPage = new QaLegendInvoicesPage(driver);
	 itemsPage = new QaLegendItemsPage(driver);
	 projectsPage = new QaLegendProjectPage(driver);
	 
	 
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
}


@AfterMethod
public void afterMethod(ITestResult itresult) throws IOException {  //screenshot
	
	if(itresult.getStatus()==ITestResult.FAILURE) {
		ScreenShotUtility ss = new ScreenShotUtility();
		ss.captureFailureScreenShot(driver, itresult.getName());
	}
	
	if(driver!=null) {
		//driver.quit();
	}
	
	
	
}

}
