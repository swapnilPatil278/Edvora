package com.edvora.TestingAssessment.TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public static String BaseURL="https://testing-assessment-foh15kew9-edvora.vercel.app/";
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		
		if(br.equals("Chrome"))
		{
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		}
		else if(br.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("You entered wrong parameters");
		}
		logger=Logger.getLogger("Edvora");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
