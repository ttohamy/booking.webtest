package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.HotelDetailsPage;

public class SearchTest extends TestBase {

	HomePage homeObject ;
	HotelDetailsPage hotelPage;
	String hotelName = "Albatros Aqua Park Sharm El Sheikh - Families and Couples Only";
	@Test
	public void userCanSearchByLocation() throws InterruptedException {
		SoftAssert softAssertion= new SoftAssert();
		homeObject = new HomePage(driver);
		hotelPage = new HotelDetailsPage(driver);
		homeObject.selectLocation();
		homeObject.selectDate();
		homeObject.selectRoomGuests();
		Thread.sleep(2000);
		boolean isHotelFinded = homeObject.isHotelAppears(driver,hotelName);
		assertTrue(isHotelFinded);
		moveToWindow(driver);
		softAssertion.assertTrue(hotelPage.checkDeluxeRoomAvailability());
		softAssertion.assertTrue(hotelPage.checkSuiteRoomAvailability());
		softAssertion.assertTrue(hotelPage.checkRoomAvailability());
		
		
		
	}
	
}
