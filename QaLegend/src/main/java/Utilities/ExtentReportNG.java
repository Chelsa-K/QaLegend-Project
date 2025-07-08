package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	 static ExtentReports extent;  //extent- object, ExtentReports - return type  //static ExtentReports extent = new ExtentReports(); 
	 
	 public static ExtentReports getReportObject() {   //ExtentReports-- return type
		 
		 String path = System.getProperty("user.dir")+"//test-output//reports.html"; //dynamically finds path -user.dir //location to store the report
		 System.out.println("REPORT PATH"+ path);
		 ExtentSparkReporter reporter = new ExtentSparkReporter(path);  //ExtentSparkReporter
		 reporter.config().setReportName("Web Automation Result");
		 reporter.config().setDocumentTitle("Test Results");
		 extent= new ExtentReports();
		 extent.attachReporter(reporter);    
		 extent.setSystemInfo("Tester", "Chelsa");
		 return extent;
		
	}
	 
	 
	
	}
	
	

	
	

