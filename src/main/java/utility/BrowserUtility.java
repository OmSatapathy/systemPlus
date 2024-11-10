package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {

	public static WebDriver initializeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		return new ChromeDriver(options);
	}

	public static void quitDriver(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}
}
