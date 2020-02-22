/**
 * 
 */
package com.feis.pagefactory;

/**
 * @author denis.putnam.ctr
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	private WebDriver driver;
	
//	@FindBy(xpath = "//*[@id=\"bottomButtons\"]/div[1]/button")
	@FindBy(xpath = "/html/body/app-root/app-privavy/div/div/button")
	private WebElement acceptAndLoginButton;
	
//	@FindBy(xpath = "//*[@id=\"bottomButtons\"]/div[2]/a/button")
	@FindBy(xpath = "/html/body/app-root/app-privavy/div/div/a/button")
	private WebElement declineAndExitButton;
	
//	@FindBy(id = "warningText")
	@FindBy(xpath = "/html/body/app-root/app-privavy/div/p")
	private WebElement warningText;
	
	@FindBy(id = "atfLogo")
	private WebElement atfLogo;

	public Login(WebDriver driver) {
		// The web driver is set up in the com.feis.test package, via the setUp() method.
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAcceptAndLoginButton() {
		return acceptAndLoginButton;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the declineAndExitButton
	 */
	public WebElement getDeclineAndExitButton() {
		return declineAndExitButton;
	}

	/**
	 * @return the warningText
	 */
	public WebElement getWarningText() {
		return warningText;
	}

	/**
	 * @return the atfLogo
	 */
	public WebElement getAtfLogo() {
		return atfLogo;
	}
}
