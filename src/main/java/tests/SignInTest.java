package tests;
import org.testng.annotations.Test;

import base.BrowserFactory;
import pages.Flights;

public class SignInTest {

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		BrowserFactory.initialize();
		BrowserFactory.instance.get("https://www.cleartrip.com/");
		Flights fl = new Flights(BrowserFactory.instance);
		fl.signIn();
		BrowserFactory.instance.quit();

	}
}
