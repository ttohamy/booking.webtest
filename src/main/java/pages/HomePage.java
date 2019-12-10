package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 30);

	}
	WebDriverWait wait ;
	@FindBy(xpath = "/html/body/div[1]/div/div/ul/li[4]/a/div")
	WebElement registerButton ; 
	@FindBy(id="current_account")
	public WebElement currentAccountIcon;
	@FindBy(css="input.profile-menu__link.profile-menu__link")
	WebElement logoutButton ; 
	@FindBy(xpath="/html/body/div[1]/div/div/ul/li[5]/a")
	public WebElement signInButton;
	@FindBy(id="ss")
	WebElement locationSearchTextField ; 
	@FindBy(css="li.c-autocomplete__item.sb-autocomplete__item.sb-autocomplete__item-with_photo.sb-autocomplete__item__item--elipsis.sb-autocomplete__item--icon_revamp.sb-autocomplete__item--city")
	WebElement sharmButton ; 
	@FindBy(xpath="/html/body/div[3]/div/div/div[2]/form/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[3]")
	WebElement calenderRow ; 
	@FindBy(id="xp__guests__toggle")
	WebElement roomGuests;
	@FindBy(xpath="/html/body/div[3]/div/div/div[2]/form/div[1]/div[3]/div[2]/div/div/div[2]/div/div[2]/button[2]")
	WebElement addChildButton;
	@FindBy(css="button.sb-searchbox__button")
	WebElement searchButton;
	@FindBy(css="li.bui-pagination__item.bui-pagination__next-arrow")
	WebElement paginationNextButton; 
	@FindBy(css="ul.bui-pagination__list")
	WebElement paginationPages; 
    @FindBy(css="div.sr-cta-button-row")
    WebElement seeAvButton ;

    public void openRegisterPage() {
		click(registerButton);
	}
    
	public void logout() {
		wait.until(ExpectedConditions.visibilityOf(currentAccountIcon));
		click(currentAccountIcon);
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		click(logoutButton);
	}
	
	public void openSignInPage() {
		click(signInButton);
	}
	
	public void selectLocation() {
		wait.until(ExpectedConditions.elementToBeClickable(locationSearchTextField));
		addTextToElement(locationSearchTextField,"sharm");
		wait.until(ExpectedConditions.elementToBeClickable(sharmButton));
		click(sharmButton);
	}
	public void selectDate() {
		wait.until(ExpectedConditions.elementToBeClickable(calenderRow));
		
		List<WebElement> columns = calenderRow.findElements(By.tagName("td"));
		wait.until(ExpectedConditions.elementToBeClickable(columns.get(0)));
		columns.get(0).click();
		columns.get(3).click();	
	}
	public void selectRoomGuests() {
		wait.until(ExpectedConditions.elementToBeClickable(roomGuests));
		click(roomGuests);
		wait.until(ExpectedConditions.elementToBeClickable(addChildButton));
		click(addChildButton);
		click(searchButton);
	}
	
	public boolean isHotelAppears(WebDriver currentDriver , String hotelName) throws InterruptedException {
		boolean finded = false;
		wait.until(ExpectedConditions.elementToBeClickable(paginationNextButton));
		while(!paginationNextButton.getAttribute("class").contains("bui-pagination__item--disabled")) {
			wait.until(ExpectedConditions.elementToBeClickable(paginationNextButton));
			if(currentDriver.getPageSource().contains(hotelName)) {
				wait.until(ExpectedConditions.elementToBeClickable(paginationNextButton));
				clickLinkByHref(currentDriver , "sunrise-arabian-beach-resort");
				finded = true;
				break;
			}
			click(paginationNextButton);
			
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(paginationNextButton));
		return finded;

	}
	
	


}
