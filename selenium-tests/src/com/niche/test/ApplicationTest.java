/**
 * @author denisputnam
 */
package com.niche.test;

import static org.testng.Assert.fail;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import com.niche.pagefactory.Login;
import com.niche.pagefactory.SADAuthentication;
import com.utility.ExcelTestReporter;
import com.utility.TestReporter;
import com.web.TestBase;

/**
 * @author denis.putnam.ctr
 *
 */
public class ApplicationTest extends TestBase {
	private static Logger Log = Logger.getLogger(ApplicationTest.class.getName());
	protected StringBuffer verificationErrors = new StringBuffer();
	protected Integer stepNum = 1;
	private boolean local = false;
	private boolean sessionActiveFlag = false;
	private Login objLogin;

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		TestReporter.endTestCase();
//		this.getExcelInput().addCurrentDataToReport();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			this.getExcelReporter().addRowData(new String[] { "COMPLETE", "Overall test", "FAILED" });
		} else {
			this.getExcelReporter().addRowData(new String[] { "COMPLETE", "Overall test", "SUCCEEDED" });
		}
		try {
			this.getExcelReporter().write();
			this.getExcelInput().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		verificationErrors = new StringBuffer();
	}

	/*
	 * Closes the browser after Tests have finished
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	protected void failStep(String error, String what) {
		String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
		int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();
		verificationErrors.append(caller + ":" + callersLineNumber + ":" + error + "\n");
		TestReporter.fail(error, this.getExcelReporter(), this.stepNum++, caller + ":" + callersLineNumber + ":" + what);
	}

	protected void failStep(String error, ExcelTestReporter rp, int stepNum, String what) {
//		verificationErrors.append(error + "\n");
//		TestReporter.fail(error, rp, this.stepNum, what);	
		String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
		int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();
		verificationErrors.append(caller + ":" + callersLineNumber + ":" + error + "\n");
		TestReporter.fail(error, rp, this.stepNum, caller + ":" + callersLineNumber + ":" + what);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.web.TestBase#login()
	 */
	@Override
	public void login() {
		driver.get("https://niche-niche.openshift39.sandbox.group.com/logon");
		objLogin = new Login(driver);

		try {
			SADAuthentication objSADAuthentication = new SADAuthentication(driver);
			WebElement acceptAndLoginButton = objLogin.getAcceptAndLoginButton();
			if (this.sessionActiveFlag == false) {
//				Thread.sleep(5000);
				validateTextEquals(this.getObjLogin().getWarningText().getText(), "WARNING! The computer system is the property of the United States Department of Justice.\nThe Department may monitor any activity on the system and search and retrieve any information\nstored within the system. By accessing and using this computer, you are consenting to such\nmonitoring and information retrieval for law enforcement and other purposes. Users should\nhave no expectation and privacy as to any communication on or information stored within the\nsystem, including information stored on the network and stored locally on the hard drive or\nother media in use with this unit (e.g. floppy drives, CD-ROMS, etc..).");

				try {
					this.getObjLogin().getSomeLogo();
					TestReporter.step("SUCCESS", getExcelReporter(), stepNum++, "someLogo is present.");
				} catch (Error e) {
					verificationErrors.append(e.toString());
					TestReporter.fail(e.getMessage(), getExcelReporter(), stepNum++, "atfLogo is NOT present.");
				}
//				acceptAndLoginButton.click();
				click(acceptAndLoginButton, "Accept & Login");
				objSADAuthentication.setUserName(this.getUserName());
				objSADAuthentication.setPassword(this.getPassword());
				objSADAuthentication.getSubmitButton().click();
				this.sessionActiveFlag = true;
			} else {
//				acceptAndLoginButton.click();
//				if( acceptAndLoginButton.isDisplayed()) {
//					click(acceptAndLoginButton, "Accept & Login");
//				}
			}
			TestReporter.step("SUCCESS", getExcelReporter(), stepNum++, "Login was successful.");
		} catch (Exception e) {
			e.printStackTrace();
			this.failStep(e.getMessage(), this.getExcelReporter(), stepNum++, "Unable to login to the application");
		}
	}
	
	/**
	 * 
	 * @param el
	 * @throws InterruptedException
	 * @throws WebDriverException
	 */
	public void clickWithWait(WebElement el) throws InterruptedException, WebDriverException {
		long sleepTime = 5000;
		try {
			el.click();
		} catch (ElementNotInteractableException e) {
			Thread.sleep(sleepTime);
			el.click();
		} catch (WebDriverException e) {
			Thread.sleep(sleepTime);
			el.click();
		} catch (Exception e) {
			Thread.sleep(sleepTime);
			el.click();
		}
	}

	
	// org.openqa.selenium.ElementNotInteractableException
	/**
	 * 
	 * @param el
	 * @param sleepTime
	 * @throws WebDriverException
	 * @throws ElementNotInteractableException
	 * @throws InterruptedException
	 */
	public void clickWithWait(WebElement el, long sleepTime) throws WebDriverException, ElementNotInteractableException, InterruptedException {
		try {
			el.click();
		} catch (ElementNotInteractableException e) {
			Thread.sleep(sleepTime);
			el.click();
		} catch (WebDriverException e) {
			Thread.sleep(sleepTime);
			el.click();
		} catch (Exception e) {
			Thread.sleep(sleepTime);
			el.click();
		}
	}
	
	public void click(WebElement el, String name) {
		try {
			clickWithWait(el);
			TestReporter.step("SUCCESS", getExcelReporter(), stepNum++, "Click " + name);
		} catch (Exception e) {
			e.printStackTrace();
			TestReporter.fail(e.getMessage(), getExcelReporter(), stepNum++, "Click " + name);
		}
	}

	public void validateTextEquals(String actualText, String text) {
		super.validateTextEquals(actualText, text, verificationErrors, stepNum++);
	}

	protected void enterText(WebElement el, String name, String value) {
		try {
//			Thread.sleep(5000);
			el.clear();
			el.sendKeys(value);
			TestReporter.step("SUCCESS", this.getExcelReporter(), this.stepNum++, "Enter " + name);
		} catch (Error e) {
			e.printStackTrace();
			verificationErrors.append(e.toString());
			TestReporter.fail(e.getMessage(), this.getExcelReporter(), this.stepNum++, "Enter " + name);
		}
	}
	
	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
	}

	/**
	 * @return the objLogin
	 */
	public Login getObjLogin() {
		return objLogin;
	}
}
