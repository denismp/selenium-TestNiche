/**
 * 
 */
package com.niche.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author denisputnam
 *
 */
public class AECARegistration {
	private WebDriver driver;
	
	@FindBy(id = "registrationNum")
	private WebElement registrationNumTextField;
	
	@FindBy(name = "expirationDate")
	private WebElement expirationDateTextField;
	
	@FindBy(id = "registrantName")
	private WebElement registrantNameTextField;
	
	@FindBy(id = "companyName")
	private WebElement companyNameTextField;
	
	@FindBy(name = "companyPhone")
	private WebElement companyPhoneTextField;
	
	@FindBy(id = "streetAddress")
	private WebElement streetAddressTextField;
	
	@FindBy(id = "city")
	private WebElement cityTextField;
	
	@FindBy(id = "state")
	private WebElement stateTextField;
	
	@FindBy(id = "zip")
	private WebElement zipTextField;
	
	@FindBy(id = "zipPlus4")
	private WebElement zipPlus4TextField;
	
	@FindBy(id = "aecaAddressStreet2")
	private WebElement aecaAddressStreet2TextField;
	
	@FindBy(id = "mailingAddressCounty")
	private WebElement mailingAddressCountyTextField;
	
	@FindBy(xpath = "//*[@id=\"statusLookupTable\"]/div/div/div/div[2]/table/tbody/tr[1]/td[2]/button")
	private WebElement addAIRCRAFTButton;
	
	@FindBy(xpath = "//*[@id=\"statusLookupTable\"]/div/div/div/div[2]/table/tbody/tr[2]/td[2]/button")
	private WebElement addAMMODDButton;
	
	@FindBy(xpath = "//*[@id=\"statusLookupTable\"]/div/div/div/div[2]/table/tbody/tr[3]/td[2]/button")
	private WebElement addAMMUNITIONButton;
	
	@FindBy(xpath = "//*[@id=\"statusLookupTable\"]/div/div/div/div[2]/table/tbody/tr[4]/td[2]/button")
	private WebElement addARTILLERYPROJECTORSButton;
	
	@FindBy(xpath = "//*[@id=\"statusLookupTable\"]/div/div/div/div[2]/table/tbody/tr[5]/td[2]/button")
	private WebElement addCATEGORYMACHINEGUNButton;
	
	@FindBy(xpath = "//*[@id=\"statusLookupTable\"]/div/div/div/div[2]/table/tbody/tr/td[1]/button")
	private WebElement removeAIRCRAFTButton;
	
	@FindBy(id = "label")
	private WebElement aecaLabelReportButton;
	
	@FindBy(id = "Registration")
	private WebElement aecaRegistrationReportButton;
	
	@FindBy(xpath = "/html/body/app-root/app-aeca-registration/p-dialog[1]/div/div[1]/a")
	private WebElement dialogCloseButton;
	
	@FindBy(xpath = "/html/body/app-root/app-aeca-registration/p-dialog[3]/div/div[3]/p-footer/button")
	private WebElement unableToSaveOkButton;
	
	public AECARegistration(WebDriver driver) {
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
	 * @return the registrationNumTextField
	 */
	public WebElement getRegistrationNumTextField() {
		return registrationNumTextField;
	}

	/**
	 * @return the expirationDateTextField
	 */
	public WebElement getExpirationDateTextField() {
		return expirationDateTextField;
	}

	/**
	 * @return the registrantNameTextField
	 */
	public WebElement getRegistrantNameTextField() {
		return registrantNameTextField;
	}

	/**
	 * @return the companyNameTextField
	 */
	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	/**
	 * @return the companyPhoneTextField
	 */
	public WebElement getCompanyPhoneTextField() {
		return companyPhoneTextField;
	}

	/**
	 * @return the streetAddressTextField
	 */
	public WebElement getStreetAddressTextField() {
		return streetAddressTextField;
	}

	/**
	 * @return the cityTextField
	 */
	public WebElement getCityTextField() {
		return cityTextField;
	}

	/**
	 * @return the stateTextField
	 */
	public WebElement getStateTextField() {
		return stateTextField;
	}

	/**
	 * @return the zipTextField
	 */
	public WebElement getZipTextField() {
		return zipTextField;
	}

	/**
	 * @return the zipPlus4TextField
	 */
	public WebElement getZipPlus4TextField() {
		return zipPlus4TextField;
	}

	/**
	 * @return the aecaAddressStreet2TextField
	 */
	public WebElement getAecaAddressStreet2TextField() {
		return aecaAddressStreet2TextField;
	}

	/**
	 * @return the mailingAddressCountyTextField
	 */
	public WebElement getMailingAddressCountyTextField() {
		return mailingAddressCountyTextField;
	}

	/**
	 * @return the addAIRCRAFTButton
	 */
	public WebElement getAddAIRCRAFTButton() {
		return addAIRCRAFTButton;
	}

	/**
	 * @return the addAMMODDButton
	 */
	public WebElement getAddAMMODDButton() {
		return addAMMODDButton;
	}

	/**
	 * @return the addAMMUNITIONButton
	 */
	public WebElement getAddAMMUNITIONButton() {
		return addAMMUNITIONButton;
	}

	/**
	 * @return the addARTILLERYPROJECTORSButton
	 */
	public WebElement getAddARTILLERYPROJECTORSButton() {
		return addARTILLERYPROJECTORSButton;
	}

	/**
	 * @return the addCATEGORYMACHINEGUNButton
	 */
	public WebElement getAddCATEGORYMACHINEGUNButton() {
		return addCATEGORYMACHINEGUNButton;
	}

	/**
	 * @return the removeAIRCRAFTButton
	 */
	public WebElement getRemoveAIRCRAFTButton() {
		return removeAIRCRAFTButton;
	}

	/**
	 * @return the aecaLabelReportButton
	 */
	public WebElement getAecaLabelReportButton() {
		return aecaLabelReportButton;
	}

	/**
	 * @return the aecaRegistrationReportButton
	 */
	public WebElement getAecaRegistrationReportButton() {
		return aecaRegistrationReportButton;
	}

	/**
	 * @return the dialogCloseButton
	 */
	public WebElement getDialogCloseButton() {
		return dialogCloseButton;
	}

	/**
	 * @return the unableToSaveOkButton
	 */
	public WebElement getUnableToSaveOkButton() {
		return unableToSaveOkButton;
	}

}
