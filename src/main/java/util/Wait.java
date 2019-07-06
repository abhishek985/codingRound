package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	public static void implicitWaitForSecond(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public static void implicitWaitForMinute(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}
	public static void explicitWaitForVisibility(WebDriver driver, int time, WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitFor(int timeInSec){
		try {
			Thread.sleep(timeInSec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
