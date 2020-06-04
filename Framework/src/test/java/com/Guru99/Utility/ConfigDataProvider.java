package com.Guru99.Utility;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() 
	{
		File src = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			// create a properties class to lead the property file
			pro = new Properties();
			pro.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Config file not loading "+e.getMessage());
		} 
	}
	
	public String getDatafromConfig(String KeytoSearch) 
	{
		return pro.getProperty("KeytoSearch");
	}
	
	public String getBrowser() 
	{
		return pro.getProperty("Browser");
	}
	
	public String getAppUrl() 
	{
		return pro.getProperty("AppUrl");
	}

}
