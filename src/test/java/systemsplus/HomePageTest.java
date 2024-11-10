package systemsplus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobject.HomePage;

public class HomePageTest extends BaseTest {

	String inputtitle = "Employee Education in 2018: Strategies to Watch";
	String expectedUrl = "https://www.brighthorizons.com/child-care-locator";
	String secondLoction = "Bright Horizons at 20 Pine";

	@Test(priority = 1)
	public void testSearchFunctionality() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.cokkiesAccept();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement closeButton = driver.findElement(By.xpath("//button[@class='close']"));
		closeButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement secondLink = driver
				.findElement(By.xpath("(//a[@class='nav-link-search track_nav_interact collapsed'])[2]"));
		secondLink.getAttribute("href");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(secondLink)).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		homePage.clickSearch();
		homePage.enterSearchTerm(inputtitle);
		homePage.seachingtext();

		List<WebElement> titles = driver.findElements(By.xpath("//*[@class='title']"));

		boolean titleFound = false;

		for (WebElement title : titles) {
			if (title.getText().contains(inputtitle)) {
				System.out.println("Title found: " + title.getText());
				titleFound = true;
				break;
			}

		}

		Assert.assertTrue(titleFound, "Title '" + inputtitle + "' was not found in the list.");

	}

	@Test(priority = 2)
	public void testLocationFuctionality() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.cokkiesAccept();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement closeButton = driver.findElement(By.xpath("//button[@class='close']"));
		closeButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//a[contains(text(),'Find a Center')])[4]")).click();
		String actualUrl = driver.getCurrentUrl();

		if (actualUrl.contains("/child-care-locator")) {
			AssertJUnit.assertEquals(actualUrl, expectedUrl);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='addressInput']")).click();
		driver.findElement(By.xpath("//input[@name='addressInput']")).sendKeys("New York");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pac-item']")));

		// Select the first suggestion (or choose based on exact text match)
		WebElement firstSuggestion = driver.findElement(By.xpath("//div[@class='pac-item'][contains(., 'New York')]"));
		Thread.sleep(3000);
		firstSuggestion.click();
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> doctorlist = driver.findElements(By.xpath("//*[@class='centerResult__name']"));

		for (int i = 0; i <= doctorlist.size() - 1; i++) {
			String secondValue = doctorlist.get(i).getText();

			if (doctorlist.get(1).getText().contains(secondValue)) {
				String secondActalvalue = doctorlist.get(1).getText();
				AssertJUnit.assertEquals(secondActalvalue, secondLoction);
			}

		}

		doctorlist.get(0).click();

		List<WebElement> doctorLocationlist = driver.findElements(By.xpath("//*[@class='centerResult__address']"));

		String actualLocation = doctorLocationlist.get(0).getText();
		if (actualLocation.equalsIgnoreCase("129 Hudson Street  New York, NY 10013 ")) {
			AssertJUnit.assertEquals(actualLocation, "129 Hudson Street  New York, NY 10013 ");
		}

	}
}
