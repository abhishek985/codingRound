package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

import base.BrowserFactory;

public class SignInTest {

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		WebDriver driver;
		driver = BrowserFactory.initialize();
		WebDriverWait wait = new  WebDriverWait(driver, 3);

		driver.get("https://www.cleartrip.com/");
		waitFor(2000);

		driver.findElement(By.linkText("Your trips")).click();
		driver.findElement(By.id("SignIn")).click();

		waitFor(2000);
		driver.switchTo().frame(1);
		System.out.println("Switched frame");


		// wait.until()
		driver.findElement(By.id("signInButton")).click();

		String errors1 = driver.findElement(By.id("errors1")).getText();
		System.out.println(errors1);
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		driver.quit();
	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}
}
