package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import utilities.PropertyManager;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;

public class RegistrationTest extends TestBase {
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	SignInPage signInObject ; 
	Faker faker = new Faker();
	String email = faker.internet().safeEmailAddress();
	String phoneNumber = "0111"+faker.phoneNumber().subscriberNumber(8);
	String password = PropertyManager.getInstance().getPassword();
	String firstname= PropertyManager.getInstance().getFirstname();
	String lastname= PropertyManager.getInstance().getLastname();

	@Test(priority=0)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		registerObject = new RegistrationPage(driver);
		homeObject.openRegisterPage();
		registerObject.fillEmail(email);
		registerObject.fillPasswordAndConfirmedPassword(password);
		registerObject.fillFirstAndLastName(firstname,lastname);
		registerObject.fillPhoneNumber(phoneNumber);
		registerObject.finishRegistration();
		assertTrue(homeObject.currentAccountIcon.isDisplayed());
		System.out.println("You registered successfully!");
	}
	@Test(priority=1)
	public void registeredUserCanLogout() {
		homeObject = new HomePage(driver);
		homeObject.logout();
		clearCookies();
		refresh();
		assertTrue(homeObject.signInButton.isDisplayed());
		System.out.println("You Logged out successfully!");
	}
	@Test(priority=2)
	public void userCanLoginSuccessfully() {
		homeObject = new HomePage(driver);
		signInObject = new SignInPage(driver);
		homeObject.openSignInPage();
		signInObject.login(email, password);
		assertTrue(homeObject.currentAccountIcon.isDisplayed());
		System.out.println("You Logged in successfully!");
	}

}
