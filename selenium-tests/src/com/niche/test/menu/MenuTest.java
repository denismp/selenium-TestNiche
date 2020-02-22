package com.niche.test.menu;

/**
 * @author denisputnam
 */

import static org.testng.Assert.fail;

import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.niche.pagefactory.menu.MenuPOM;

import com.niche.test.ApplicationTest;
import com.utility.TestReporter;

public class MenuTest extends ApplicationTest {
	private static Logger Log = Logger.getLogger(MenuTest.class.getName());

	private String excelInputPath = "./resources/data/menu-test.xlsx";

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser", "local", "userName", "password" })
	public void setUp(String browser, Boolean local, String userName, String password) throws Exception {
		this.setLocal(local);
		this.setUserName(userName);
		this.setPassword(password);
		super.setUp(browser, local, this.getClass().getSimpleName());
		super.openExcelInput(this.excelInputPath, "OverviewTC1.0.0");
		super.getExcelInput().addCurrentDataToReport();
	}

	@BeforeTest(alwaysRun = true)
	public void setLogger() {
		TestReporter.setLogger(Log);
		TestReporter.startTestCase();
	}

	/*
	 * Closes the browser after Tests have finished
	 */
	@Override
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
		int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			verificationErrors.append(caller + ":" + callersLineNumber + "\n");
			fail(verificationErrorString);
		}
	}


	@Test(priority = 0)
	public void testMenu() throws Exception {
		this.getExcelInput().readNewWorkSheet("TC1.0.0");

		this.stepNum = 1;

		this.getExcelReporter().addTestId("NICHE-TC-1.0.0");
		this.getExcelReporter().addRowData(new String[] { "STEP", "WHAT", "RESULT" });
		TestReporter.step("INFO", this.getExcelReporter(), this.stepNum++, "Testing Menu on spash page");
		//this.login();
		
		// After the login, create all the web pages used within this test.
		MenuPOM objMainMenu = new MenuPOM(this.driver);

		//Thread.sleep(5000);
		
		//this.click(objMainMenu.getForm6SearchButton(), "Search Form");
		
//		try {
//			Actions actions = new Actions(driver);
//			WebElement elementLocator = objForm6Search.getFirstTableRecord();
////			WebElement elementLocator = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Country of Export'])[2]/following::td[2]"));
//			actions.doubleClick(elementLocator).perform();
//			TestReporter.step("SUCCESS", this.getExcelReporter(), this.stepNum++, "double click record in p-table");
//		} catch (Exception e) {
//			verificationErrors.append(e.toString());
//			TestReporter.step(e.getMessage(), this.getExcelReporter(), this.stepNum++, "double click record in p-table");
//		}
		
		TestReporter.step("COMPLETE", this.getExcelReporter(), this.stepNum++, this.getExcelReporter().getTestId());
	}
}

