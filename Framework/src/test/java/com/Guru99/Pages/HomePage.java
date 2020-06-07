package com.Guru99.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		this.driver= driver;
	}
	
			
	@FindBy(how=How.TAG_NAME, using="marquee")
	WebElement homePageText;
	
	public String homePagetxt() 
	{
		return homePageText.getText();
	}
	
		
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	
	public void logout() 
	{
		logout.click();
	}


}
