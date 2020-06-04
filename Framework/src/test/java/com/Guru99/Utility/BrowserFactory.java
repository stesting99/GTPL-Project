package com.Guru99.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	static DesiredCapabilities cap;
		
	@SuppressWarnings("deprecation")
	public static WebDriver StartApp(WebDriver driver, String browserName, String AppUrl) 
	{
		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			cap =new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(cap);
		}
		else if (browserName.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("This browser is not supported");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(AppUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) 
	{
		driver.close();
	}
	

}
