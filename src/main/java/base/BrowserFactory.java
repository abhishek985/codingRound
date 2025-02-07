package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.javafx.PlatformUtil;

public class BrowserFactory {

	public static WebDriver instance = null;
	private BrowserFactory()
	{	
	}

	public static void initialize()
	{
		setDriverPath();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		instance = new ChromeDriver(options);
		instance.manage().window().maximize();
		System.out.println("Driver launched : CHROME");
	}

	@SuppressWarnings("restriction")
	private static void setDriverPath() {
		final String driver_path ="webdriver.chrome.driver";
		if (PlatformUtil.isMac()) {
			System.setProperty(driver_path, "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty(driver_path, "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty(driver_path, "chromedriver_linux");
		}
	}

}
