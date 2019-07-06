package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import util.Wait;

public class Hotels {

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	public Hotels(WebDriver driver) {
        System.out.println("Hotels Page initialized");
        PageFactory.initElements(driver, this);
    }

	public void searchHotels() {
		Wait.waitFor(2);
		localityTextBox.sendKeys("Indiranagar, Bangalore");
		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		searchButton.click();
		Wait.waitFor(2);
	}
}
