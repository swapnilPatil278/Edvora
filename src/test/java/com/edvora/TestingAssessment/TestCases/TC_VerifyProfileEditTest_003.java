package com.edvora.TestingAssessment.TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edvora.TestingAssessment.Pages.ProfilePage;

public class TC_VerifyProfileEditTest_003 extends BaseClass {
	
	@Test
	public void ProfileEdit() throws InterruptedException 
	{
	
	driver.get(BaseURL);

	logger.info("Entered URL");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();

	ProfilePage pp = new ProfilePage(driver);

	pp.EnterUsername("xyz");
	logger.info("Entered Username");
	pp.EnterPassword("xyz");
	logger.info("Entered password");

	pp.ClickLoginButton();
	logger.info("Clicked on Login Button");
	
	pp.ClickEditButton();
	logger.info("Clicked on Edit Button");
	
	pp.EnterFullname("abcabc");
	logger.info("Entered fullname");
	
	pp.EnterDateOfBirth("05121995");
	logger.info("Entered date of birth");
	
	pp.EnterAddress("13th Street, ABC");
	logger.info("Entered Address");
	
	pp.EnterMobNumber("1234543674");
	logger.info("Entered Mobile number");
	
	pp.SelectGender("male");
	logger.info("Gender selected");
	
	pp.ClickOnSave();
	logger.info("Clicked on save button");
	
	String name=pp.getFullname();
	System.out.println("name is "+name);
	if(name.equals("xyz"))
	{
		Assert.assertTrue(true);
	} else
		Assert.assertTrue(false);
	
	
	
	Thread.sleep(10000);
	
	}
}
