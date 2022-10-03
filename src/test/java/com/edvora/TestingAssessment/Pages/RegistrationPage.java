package com.edvora.TestingAssessment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	
	public RegistrationPage(WebDriver Rdriver) {
	
		driver=Rdriver;
		PageFactory.initElements(Rdriver,this);
	}
	@FindBy(xpath="//button[@class='chakra-button css-d509a4']")
	WebElement SignInButton;
	
	@FindBy(xpath="//input[@autocomplete='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@autocomplete='current-password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@class='chakra-button css-8h0nsd']")
	WebElement CreateAccount;
	
	public void ClickSignInButton() {
		SignInButton.click();	
	}
	
	public void EnterUsername(String username)
	{
		Username.sendKeys(username);
	}
	
	public void EnterPassword(String password)
	{
		Password.sendKeys(password);
	}
	
	public void ClickCreateAccountButton()
	{
		CreateAccount.click();
	}
}
