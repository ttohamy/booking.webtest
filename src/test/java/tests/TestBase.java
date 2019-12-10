package tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;

public class TestBase {
	public static WebDriver driver ; 
	@BeforeTest
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) {	
		if(browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browserName.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browserName.equalsIgnoreCase("chrome-headless")) {
			System.out.println("Headless is perfect");
			ChromeOptions option = new  ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=2000,3000");
			driver = new ChromeDriver(option);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.navigate().to("https://www.booking.com/");
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
	    if (testResult.getStatus() == ITestResult.FAILURE) { 
	    	String currentDir = System.getProperty("user.dir")+"/screenshots/" ;
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
	        FileUtils.copyFile(scrFile, new File(currentDir+ testResult.getName() + "-"+ ".jpg"));
	    } 
	}
	@AfterTest
	@Parameters({"browser"})
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
