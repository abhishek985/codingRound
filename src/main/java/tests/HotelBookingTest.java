package tests;
import org.testng.annotations.Test;
import base.BrowserFactory;
import pages.Flights;
import pages.Hotels;

public class HotelBookingTest {

//	@BeforeTest
//	public void setUp() {	
//		BrowserFactory.initialize();
//		BrowserFactory.instance.get("https://www.cleartrip.com/");
//	}

	@Test
	public void shouldBeAbleToSearchForHotels() {
		BrowserFactory.initialize();
		BrowserFactory.instance.get("https://www.cleartrip.com/");
		Flights fl = new Flights(BrowserFactory.instance);
		Hotels ht = new Hotels(BrowserFactory.instance);

		fl.clickHotels();
		ht.searchHotels();
		BrowserFactory.instance.quit();
	}
}
