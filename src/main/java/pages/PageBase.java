package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class PageBase {
	protected WebDriver driver ; 
	JavascriptExecutor excuter ;


	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver ,this);
	}
	protected static void click(WebElement element) {
		element.click();
	}
	protected static void addTextToElement(WebElement element , String value) {
		element.sendKeys(value);
	}
	protected void clickEnter() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
	protected static void clickLinkByHref(WebDriver driver ,String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        java.util.Iterator<WebElement> i = anchors.iterator();
        while(i.hasNext()) {
			WebElement anchor = i.next();
			if(anchor.getAttribute("href").contains(href)) {
				anchor.click();
                break;
            }
        }
    }
	
	
}
