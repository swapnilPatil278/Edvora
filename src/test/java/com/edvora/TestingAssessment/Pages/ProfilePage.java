package com.edvora.TestingAssessment.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="//html/body/div/div/main/div/div[1]/div/div/div/button")
	WebElement EditButton;
	
	@FindBy(xpath="//input[@name='fullname']")
	WebElement fullName;
	
	@FindBy(xpath="//input[@name='dateOfBirth']")
	WebElement birthDate;
	
	@FindBy(xpath="//input[@name='mobileNumber']")
	WebElement mobNumber;
	
	@FindBy(xpath="//input[@name='address']")
	WebElement address;
	
	@FindBy(xpath="//select[@class='chakra-select css-ibs81u']")
	WebElement gender;
	
	@FindBy(xpath="//html/body/div/div/main/div/div[1]/div/div/div/button[2]")
	WebElement saveButton;
	
	public void EnterUsername(String username)
	{
		Username.sendKeys(username);
	}
	
	public void EnterPassword(String password)
	{
		Password.sendKeys(password);
	}
	public void ClickLoginButton()
	{
		LoginButton.click();
	}
	
	public void ClickEditButton()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(EditButton));
		EditButton.click();
	}
	
	public void EnterFullname(String name)
	{
		fullName.clear();
		fullName.sendKeys(name);
	}
	
	public String getFullname()
	{
		String Name=fullName.getText();
		return Name;
	}
	
	public void EnterDateOfBirth(String DOB)
	{
		birthDate.sendKeys(DOB);
	}
	
	public void EnterMobNumber(String mobNo)
	{
		mobNumber.clear();
		mobNumber.sendKeys(mobNo);
	}
	
	public void EnterAddress(String Add)
	{
		address.clear();
		address.sendKeys(Add);
	}
	
	public void SelectGender(String gen)
	{
		Select select=new Select(gender);
		select.selectByVisibleText(gen);
	}
	
	public void ClickOnSave()
	{
		saveButton.click();
	}
}
