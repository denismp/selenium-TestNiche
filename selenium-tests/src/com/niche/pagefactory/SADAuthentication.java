package com.niche.pagefactory;
/**
 * @author denisputnam
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SADAuthentication {
	private WebDriver driver;
	
	@FindBy(id = "userNameInput")
	private WebElement userTextField;
	
	@FindBy(id = "passwordInput")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement submitButton;

	public SADAuthentication(WebDriver driver) {
		// The web driver is set up in the com.feis.test package, via the setUp() method.
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
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
	 * @return the userTextField
	 */
	public WebElement getUserTextField() {
		return userTextField;
	}


	/**
	 * @return the passwordTextField
	 */
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	
	/**
	 * 
	 * @param userName
	 * @throws InterruptedException 
	 */
	public void setUserName( String userName ) {
		this.userTextField.click();
		this.userTextField.clear();
		this.userTextField.sendKeys(userName);
	}
	
	/**
	 * 
	 * @param password
	 * @throws InterruptedException 
	 */
	public void setPassword( String password ) {
		this.passwordTextField.click();
		this.passwordTextField.clear();
		this.passwordTextField.sendKeys(password);
	}

	/**
	 * @return the submitButton
	 * @throws InterruptedException 
	 */
	public WebElement getSubmitButton() {
		return submitButton;
	}
}
