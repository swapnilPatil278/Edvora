package com.edvora.TestingAssessment.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edvora.TestingAssessment.Pages.RegistrationPage;

public class TC_RegistrationTest_001 extends BaseClass {
	
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	@DataProvider(name="registrationData")
	public String[][] getLoginData() throws IOException {
		file = new FileInputStream(".\\src\\test\\resources\\loginData.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet2");
		DataFormatter formater = new DataFormatter();
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();
		
		String data[][] = new String[rc - 1][cc];
		for (int i = 1; i < rc; i++) {
			for (int j = 0; j < cc; j++) {

				cell = sheet.getRow(i).getCell(j);
				data[i - 1][j] = formater.formatCellValue(cell);

			}
		}
		return data;
	}
	

	@Test(dataProvider="registrationData")
	public void Registration(String username,String password) throws InterruptedException {
		driver.get(BaseURL);
		logger.info("Entered URL");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		RegistrationPage rp = new RegistrationPage(driver);

		rp.ClickSignInButton();
		logger.info("Clicked on Sign In button");

		rp.EnterUsername(username);
		logger.info("Entered Username");

		rp.EnterPassword(password);
		logger.info("Entered password");

		rp.ClickCreateAccountButton();
		logger.info("Clicked on Create account button");
		
		Thread.sleep(5000);
				
		try {
			driver.switchTo().alert().accept();
			logger.info("Pop-up accepted");	
		} catch(Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		if (driver.getCurrentUrl().equals("https://testing-assessment-foh15kew9-edvora.vercel.app/s")) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}

}
