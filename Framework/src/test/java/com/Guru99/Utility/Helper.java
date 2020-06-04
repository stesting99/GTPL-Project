package com.Guru99.Utility;

import java.io.File;
//import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
			
	
	public static String CaptureScrshot(WebDriver driver) 
	{
		File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String scrnshtpath = System.getProperty("user.dir")+ "/Screenshot/GTPL" + getCurrentDateTime()+ ".png";
		try 
		{
			FileHandler.copy(scrnsht, new File (scrnshtpath));
			System.out.println("ScreenShot Captured");
			
		} catch (Exception e) {
			System.out.println("Unable to capture ScreenShot "+e.getMessage());
		}
		return scrnshtpath;
	}
	
	public static String getCurrentDateTime() 
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}

	public static String getAlerttext(WebDriver driver)
	{
		String getAlerttext = driver.switchTo().alert().getText();
		return getAlerttext;
	}
	
	public static void accepttAlert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
		
	}
	
}
