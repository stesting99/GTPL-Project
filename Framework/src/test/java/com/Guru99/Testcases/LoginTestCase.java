package com.Guru99.Testcases;

import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99.Pages.LoginPage;
import com.Guru99.Utility.Helper;

import BaseClass.BaseClassPage;

public class LoginTestCase extends BaseClassPage  
{
		
	@Test
	public void LoginApp()
		{
		logger = report.createTest("Valid Login to GTPL");
				
		LoginPage loginToApp = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Login with valid credentials");
		
		loginToApp.Login2App(xldata.getStringData("Login", 1, 0), xldata.getStringData("Login", 1, 1));
		
		logger.pass("Login Successful");
		
		String actualTitle= driver.getTitle();
		
		if (actualTitle.contains("GTPL")) 
		{
			System.out.println("Login Successful, Home page title is: " + actualTitle);	
		}
		else 
			System.out.println("Login not Successful");	
		
		}
		
		
		@Test
		public void InvalidLoginApp() throws Exception
			{
			logger = report.createTest("inValid Login with wrong user name to GTPL");
					
			LoginPage loginToApp = PageFactory.initElements(driver, LoginPage.class);
			
			logger.info("Login with invalid credentials");
			
			loginToApp.Login2App(xldata.getStringData("Login", 2, 0), xldata.getStringData("Login", 2, 1));
			
			String actualText= Helper.getAlerttext(driver);
			
			Thread.sleep(5000);
			
			Helper.accepttAlert(driver);
			
			logger.pass("Login unSuccessful");
			
			if (actualText.contains("valid")) 
			{
				System.out.println("Login unSuccessful, text is: " + actualText);	
			}
			else 
				System.out.println("Login Successful");	
			}
		
		
		@Test
		public void InvalidLoginApp1() throws Exception
			{
			logger = report.createTest("inValid Login with wrong password to GTPL");
					
			LoginPage loginToApp = PageFactory.initElements(driver, LoginPage.class);
			
			logger.info("Login with invalid password credentials");
			
			loginToApp.Login2App(xldata.getStringData("Login", 3, 0), xldata.getStringData("Login", 3, 1));
			
			String actualText= Helper.getAlerttext(driver);
			
			Thread.sleep(5000);
			
			Helper.accepttAlert(driver);
			
			logger.pass("Login unSuccessful");
			
			if (actualText.contains("valid")) 
			{
				System.out.println("Login Successful , text is: " + actualText);	
			}
			else 
				System.out.println("Login unSuccessful");	
			}
		
		
		//String expTitle = "GTPL Bank Manager HomePage";
		
		//Assert.assertEquals(actualTitle, expTitle);
	//	System.out.println("Login Successful, Home page title is: " + actualTitle);		

	
}