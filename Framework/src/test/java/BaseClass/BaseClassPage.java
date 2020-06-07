package BaseClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Parameters;

import com.Guru99.Utility.BrowserFactory;
import com.Guru99.Utility.ConfigDataProvider;
import com.Guru99.Utility.ExcelDataProvider;
import com.Guru99.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClassPage 
{
	public WebDriver driver;
	public ExcelDataProvider xldata;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() 
	{
		Reporter.log("Setting Up Report Config and data providers", true);
		xldata = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Guru99_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("All Config setting Up and data providers done", true);
		
	}
	
	@Parameters({"browser", "BaseUrl"})
	@BeforeClass
	public void setUp(String browser, String BaseUrl) 
	{
		Reporter.log("Setting up browser and app Url", true);
		
		//driver =BrowserFactory.StartApp(driver, config.getBrowser(), config.getAppUrl());
		
		driver =BrowserFactory.StartApp(driver,browser, BaseUrl);
		
		Reporter.log("browser and app Url up and running", true);
	}
	
	@AfterClass
	public void tearDown() 
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		Reporter.log("Test about to end and result generated", true);
		
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			try {
				logger.fail("Login Failed").addScreenCaptureFromPath(Helper.CaptureScrshot(driver));
			
			} 
			catch (Exception e) 
			{
				System.out.println("Unable to attach Failed screenshot "+e.getMessage());
			}
			
		}
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{
			try {
				logger.pass("Test passed").addScreenCaptureFromPath(Helper.CaptureScrshot(driver));
			} 
			catch (Exception e) 
			{
				System.out.println("Unable to attach Passed screenshot "+e.getMessage());
			}
			}
				report.flush();
				
				Reporter.log("Test completed >>> Report ready", true);
		}
	
}


