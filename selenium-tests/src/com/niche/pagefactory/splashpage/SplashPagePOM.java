/**
 * 
 */
package com.niche.pagefactory.splashpage;

import org.openqa.selenium.By;
/**
 * @author denisputnam
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SplashPagePOM {
	private WebDriver driver;
	
	@FindBy(id = "user_login")
	private WebElement userLogin;
			
	public WebElement getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(WebElement userLogin) {
		this.userLogin = userLogin;
	}

	public SplashPagePOM(WebDriver driver) {
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

}

//driver.findElement(By.id("user_login")).click();
//driver.findElement(By.id("user_login")).clear();
//driver.findElement(By.id("user_login")).sendKeys("denis putnam");
//driver.findElement(By.id("user_email")).clear();
//driver.findElement(By.id("user_email")).sendKeys("my@mail.com");
//driver.findElement(By.id("user_pass")).clear();
//driver.findElement(By.id("user_pass")).sendKeys("dummy");
