package com.edvora.TestingAssessment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

WebDriver driver;
	
	public ProfilePage(WebDriver Rdriver) {
	
		driver=Rdriver;
		PageFactory.initElements(Rdriver,this);
	}
	@FindBy(xpath="//button[@class='chakra-button css-8h0nsd']")
	WebElement LoginButton;
	
	@FindBy(xpath="//input[@autocomplete='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@autocomplete='current-password']")
	WebElement Password;
}
