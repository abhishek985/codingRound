package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BrowserFactory;
import util.Wait;

public class Flights {
	WebDriver driver = BrowserFactory.instance;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "OneWay")
	private WebElement oneWay;

	@FindBy(id = "FromTag")
	private WebElement fromTag;

	@FindBy(linkText = "Your trips")
	private WebElement yourtrips;

	@FindBy(id = "SignIn")
	private WebElement SignIn;

	@FindBy(id = "signInButton")
	private WebElement signInButton;

	@FindBy(id = "errors1")
	private WebElement errors;

	@FindBy(id = "ui-id-2")
	private WebElement uiid2;

	@FindBy(id = "ui-id-1")
	private WebElement uiid1;


	public Flights(WebDriver driver) {
		System.out.println("Flights Page initialized");
		PageFactory.initElements(driver, this);
	}

	public void signIn() {
		yourtrips.click();
		SignIn.click();
		Wait.waitFor(3);
		driver.switchTo().frame(1);
		System.out.println("Switched frame");
		Wait.waitFor(2);
		signInButton.click();
		String errors1 = errors.getText();
		//System.out.println(errors1);
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}

	public void clickHotels() {
		Wait.waitFor(2);
		hotelLink.click();
	}

	public void assertHotelBooking() {	
		oneWay.click();
		fromTag.clear();
		fromTag.sendKeys("Bangalore");
		Wait.explicitWaitForVisibility(driver, 4, uiid1);
		List<WebElement> originOptions = uiid1.findElements(By.tagName("li"));
		originOptions.get(0).click();
		Wait.waitFor(2);
		WebElement To= driver.findElement(By.xpath("//*[@id='ToTag']"));
		To.clear();
		To.sendKeys("Delhi");
		//wait for the auto complete options to appear for the destination
		Wait.explicitWaitForVisibility(driver, 4, uiid2);
		//select the first item from the destination auto complete list
		List<WebElement> destinationOptions = uiid2.findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();
		//all fields filled in. Now click on search
		driver.findElement(By.id("SearchBtn")).click();
		Wait.waitFor(5);
		//verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
