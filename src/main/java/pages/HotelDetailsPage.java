package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelDetailsPage extends PageBase {

	WebDriverWait wait ;
	public HotelDetailsPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 30);
	}
	@FindBy(id="room_type_id_229193801")
	WebElement deluxeRoomButton; 
	@FindBy(id="room_type_id_229193807")
	WebElement suiteRoomButton;
	@FindBy(id="room_type_id_229193806")
	WebElement room;
	@FindBy(id="blocktoggleRD229193801")
	WebElement deluxeRoomPopup; 
	@FindBy(id="blocktoggleRD229193807")
	WebElement suiteRoomPopup; 
	@FindBy(id="blocktoggleRD229193806")
	public WebElement roomPopup; 


	public boolean checkDeluxeRoomAvailability() {
		try {
			if(deluxeRoomButton.isDisplayed()) {
				System.out.println("The Deluxe Room is avaliable");
				deluxeRoomButton.click();
				wait.until(ExpectedConditions.visibilityOf(deluxeRoomPopup));
				if(deluxeRoomPopup.isDisplayed()) {
					System.out.println("The room details popup appears");
					return true;  }
				else 
					return false;
			}
			else {
				System.out.println("The Deluxe Room is not avaliable");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("The Deluxe Room is not avaliable");
			return false;
		}
	}
	public boolean checkSuiteRoomAvailability() {
		try {
			if(suiteRoomButton.isDisplayed()) {
				System.out.println("The Suite Room is avaliable");
				suiteRoomButton.click();
				wait.until(ExpectedConditions.visibilityOf(suiteRoomPopup));
				if(suiteRoomPopup.isDisplayed()) {
					System.out.println("The room details popup appears");
					return true;  
				}
				else 
					return false;
			}
			else {
				System.out.println("The Suite Room is not avaliable");
				return false;
			}
		}catch (Exception e) {
			System.out.println("The Suite Room is not avaliable");
			return false;
		}
	}
	public boolean checkRoomAvailability() {
		try {
			if(room.isDisplayed()) {
				System.out.println("The room is avaliable");
				room.click();
				wait.until(ExpectedConditions.visibilityOf(roomPopup));
				if(roomPopup.isDisplayed()) {
					System.out.println("The room details popup appears");
					return true; 
				}
				else 
					return false;
			}
			else {
				System.out.println("The room is not avaliable");
				return false;
			}
		}catch (Exception e) {
			System.out.println("The room is not avaliable");
			return false;
		}
	}
}
