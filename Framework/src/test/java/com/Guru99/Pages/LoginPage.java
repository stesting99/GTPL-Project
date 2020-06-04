package com.Guru99.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver= driver;
	}
	
	@FindBy(how=How.NAME, using = "uid")  
	WebElement username;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']") 
	WebElement pWord;
	
	@FindBy(how=How.NAME, using="btnLogin")
	WebElement loginButton;
	
	@FindBy(name="btnReset")
	WebElement resetButton;
	
	public void Login2App(String AppUname, String AppPwd) 
	{
		username.sendKeys(AppUname);
		pWord.sendKeys(AppPwd);
		loginButton.click();
	}
	
	public void resetAppPwd(String AppUname) 
	{
		username.sendKeys(AppUname);
		resetButton.click();
	}

	
		

}
