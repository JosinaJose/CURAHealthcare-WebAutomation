package com.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest test;
	//ThreadLocal<ExtentTest> extentTest;

	
	
	public void onStart(ITestContext testContext)
	{
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html"; // Report name and time stamp in html format
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "\\test-output\\"+repName);//specify location of the report
		
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report - given by the user
		htmlReporter.config().setReportName("Functional Testing"); // name of the report - given by the user
		htmlReporter.config().setTheme(Theme.DARK); //
	//	htmlReporter.config().setTheme(Theme.STANDARD); 
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		// System info can be any info defined by the User that comes in the report
		// populate the common details
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("OS","Windows10");
		extent.setSystemInfo("Language: ", "Java");
		extent.setSystemInfo("Browser name","Chrome");
		extent.setSystemInfo("Tools used: ","Maven & TestNG");
		extent.setSystemInfo("Josina","busyQA");
		extent.setSystemInfo("Client: ","freshii");
		
		
		
		
	}
	
	

	
	public void onTestFailure (ITestResult result)
	{
		// test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
		 
		test=extent.createTest(result.getName().toUpperCase()); // create new entry in the report
		test.log(Status.FAIL, "Test Case FAILED IS " + result.getName().toUpperCase());
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
		
		//String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";
	    
		
		try {
			test.addScreenCaptureFromPath(screenshotPath );// adding screen shot	
			//test.addScreenCaptureFromPath(captureScreen(screenshotPath));2
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}    

	public void onTestSkipped (ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP, "Test Case SKIIPED  IS " + result.getName().toUpperCase());
          
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		
		extent.flush();
		
	}
	
}
