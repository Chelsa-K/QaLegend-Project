package TestScripts;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AutomationCore.BaseClass;
import Utilities.ExtentReportNG;

public class Listeners extends BaseClass implements ITestListener{
	
	ExtentTest test;     // ExtentTest - Class file; test- object
	
	ExtentReports extent = ExtentReportNG.getReportObject(); 
	
/* in order to hold the 'extent' returned from the ExtentReportNG class in this Listeners class,
we create a similar 'ExtentReports typed', 'extent object' in here; getReportObject() method in the ExtentReportNG class 
is a 'static method', so to access it, class name.methodname-- ExtentReportNG.getReportObject() */
	
	ThreadLocal<ExtentTest>extenttest = new ThreadLocal<ExtentTest>(); 
	
//prevent overlapping of reports while multiple tasks are performed by processor (parallel testing)- thread mngt in java 
	
	@Override
	public void onTestStart(ITestResult result) {   //to generate a field or title in the generated report, we give testcase name 
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());   //result- parameter in listener which has the entire data of the execution
		extenttest.set(test);  // to set the field in the generated report
	}

	@Override
	public void onTestSuccess(ITestResult result) {		//on test case pass
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		extenttest.get().log(Status.PASS, "Test Case Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {		//on test case failure
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		extenttest.get().log(Status.FAIL, "Test Case Failed");
		extenttest.get().fail(result.getThrowable());   //to get the reason of failure in the console

	}

	@Override
	public void onTestSkipped(ITestResult result) {		//on test case skipped
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		extenttest.get().log(Status.SKIP, "Test Case Skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();   //to close existing listener inorder to prevent unwanted memory usage. Listeners keep running background
	}
	
	
	


}
