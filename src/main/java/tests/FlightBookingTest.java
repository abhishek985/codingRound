package tests;
import org.testng.annotations.Test;

import base.BrowserFactory;
import pages.Flights;

public class FlightBookingTest {
	@Test
	public void shouldBeAbleToSearchForHotels() {
		BrowserFactory.initialize();
		BrowserFactory.instance.get("https://www.cleartrip.com/");
		Flights fl = new Flights(BrowserFactory.instance);
		fl.assertHotelBooking();
		BrowserFactory.instance.quit();
	}
}
