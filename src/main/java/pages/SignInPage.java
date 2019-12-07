package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends PageBase {

	public SignInPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 30);
	}
	WebDriverWait wait ;
	@FindBy(id="username")
	WebElement usernameTextField ; 
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/div[3]/button")
	WebElement nextButton ; 
	@FindBy(id="password")
	WebElement passwordTextField;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/div[2]/div/div/div/form/button")
	WebElement signInButton ;
	
	
	public void login(String username , String password) {
		wait.until(ExpectedConditions.visibilityOf(usernameTextField));
		addTextToElement(usernameTextField, username);
		click(nextButton);
		wait.until(ExpectedConditions.visibilityOf(usernameTextField));
		addTextToElement(passwordTextField, password);
		click(signInButton);
	}
	

}
