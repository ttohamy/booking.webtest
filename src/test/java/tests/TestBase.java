package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;


public class TestBase {
	public static WebDriver driver ; 
	@BeforeTest
	public void startDriver(@Optional("chrome") String browserName) {	
		if(browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browserName.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.navigate().to("https://www.booking.com/");
	}
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}

	public void clearCookies() {
		driver.manage().deleteAllCookies();
	}
	protected static void moveToWindow(WebDriver driver) {

		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));

	}


}
