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

import com.edvora.TestingAssessment.Pages.LoginPage;
public class TC_LoginTest_002 extends BaseClass {

	@Test(dataProvider = "loginData")
	public void LoginTest(String user, String pass, String status) throws InterruptedException {
		driver.get(BaseURL);

		logger.info("Entered URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		LoginPage lp = new LoginPage(driver);

		lp.EnterUsername(user);
		logger.info("Entered Username");
		lp.EnterPassword(pass);
		logger.info("Entered password");

		lp.ClickLoginButton();
		logger.info("Clicked on Login Button");
		
		Thread.sleep(4000);

		if (status.equals("Valid")) {

			if (driver.getCurrentUrl().equals("https://testing-assessment-foh15kew9-edvora.vercel.app/s")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		if (status.equals("Invalid")) {
			if (driver.getCurrentUrl().equals("https://testing-assessment-foh15kew9-edvora.vercel.app/s")) {
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
		driver.navigate().refresh();
	}
	
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	@DataProvider(name="loginData")
	public String[][] getLoginData() throws IOException {
		file = new FileInputStream(".\\src\\test\\resources\\loginData.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet1");
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

	
	

}
