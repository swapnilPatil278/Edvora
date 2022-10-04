package com.edvora.TestingAssessment.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src=new File(".\\src\\test\\resources\\config.properties");
	
		try
		{
		FileInputStream fis=new FileInputStream(src);
		
		prop= new Properties();
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getAppUrl()
	{
		String url=prop.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername()
	{
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	public String getChromepath()
	{
		String Chromepath=prop.getProperty("Chromepath");
		return Chromepath;
	}
	public String getMEdriverpath()
	{
		String MEdriverpath=prop.getProperty("MEdriverpath");
		return MEdriverpath;
	}
	public String getIEdriverpath()
	{
		String IEdriverpath=prop.getProperty("IEdriverpath");
		return IEdriverpath;
	}
}
