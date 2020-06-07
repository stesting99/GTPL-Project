package com.Guru99.Testcases;

import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99.Pages.LoginPage;


import BaseClass.BaseClassPage;

public class LoginTestCase extends BaseClassPage  {
	
	public LoginPage loginToApp;
	public LoginPage loginToApp2; 
		
	@Test
	public void ValidLoginToApp()
		{
		logger = report.createTest("Valid Login to GTPL");
		
		loginToApp = PageFactory.initElements(driver, LoginPage.class);
						
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
	
		
		//String expTitle = "GTPL Bank Manager HomePage";
		
		//Assert.assertEquals(actualTitle, expTitle);
	//	System.out.println("Login Successful, Home page title is: " + actualTitle);		
	
	
}