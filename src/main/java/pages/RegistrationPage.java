package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 30);

	}
	WebDriverWait wait ;
	@FindBy(id="login_name_register")
	WebElement emailTextFiled; 
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/button")
	WebElement getStartedButton ; 
	@FindBy(id="password")
	WebElement passwordTextField ; 
	@FindBy(id="confirmed_password")
	WebElement confirmedPasswordTextField ;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/button")
	WebElement createAccountButton ; 
	@FindBy(id="wl252-firstname")
	WebElement firstnameTextField ; 
	@FindBy(id="wl252-lastname")
	WebElement lastnameTextField; 
	@FindBy(xpath="/html/body/div[12]/div[1]/div/form/div[2]/button")
	WebElement continueButton ; 
	@FindBy(name="phone")
	WebElement phoneNumberTextField ; 
	@FindBy(css="button.wl252-btn.wl252-btn_continue")
	WebElement phoneNumberContinueButton;
	@FindBy(css="a.wl252-btn.wl252-btn-done")		   
	WebElement finishRegistrationButton ;
	
	
	public void fillEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(emailTextFiled));
		addTextToElement(emailTextFiled, email);
		click(getStartedButton);
	}
	public void fillPasswordAndConfirmedPassword(String password)
	{
		wait.until(ExpectedConditions.visibilityOf(passwordTextField));
		addTextToElement(passwordTextField, password);	
		wait.until(ExpectedConditions.visibilityOf(confirmedPasswordTextField));
		addTextToElement(confirmedPasswordTextField, password);
		click(createAccountButton);
	}
	
	public void fillFirstAndLastName(String firstname, String lastname) {
		wait.until(ExpectedConditions.visibilityOf(firstnameTextField));
		addTextToElement(firstnameTextField, firstname);
		addTextToElement(lastnameTextField, lastname);
		click(continueButton);
	}
	public void fillPhoneNumber(String phoneNumber) {
		wait.until(ExpectedConditions.visibilityOf(phoneNumberTextField));
		addTextToElement(phoneNumberTextField,phoneNumber );
		wait.until(ExpectedConditions.visibilityOf(phoneNumberContinueButton));
		click(phoneNumberContinueButton);
	}
	public void finishRegistration() {
		wait.until(ExpectedConditions.visibilityOf(finishRegistrationButton));
		click(finishRegistrationButton);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
