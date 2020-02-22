/**
 * 
 */
package com.niche.pagefactory.menu;

import org.openqa.selenium.By;
/**
 * @author denisputnam
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPOM {
	private WebDriver driver;
	
	@FindBy(xpath = "//p-menu[@id='itemsId']/div/ul/li[2]/a/span")
	WebElement menu;

	public MenuPOM(WebDriver driver) {
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

	public WebElement getMenu() {
		return menu;
	}

	public void setMenu(WebElement menu) {
		this.menu = menu;
	}

}
