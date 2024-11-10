package systemsplus;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import config.Config;
import utility.BrowserUtility;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod

	public void setUp() {
		driver = BrowserUtility.initializeDriver();
		driver.get(Config.BASE_URL);
	}

	@AfterMethod

	public void tearDown() {
		BrowserUtility.quitDriver(driver);
	}
}
