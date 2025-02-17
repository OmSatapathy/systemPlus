package Demo;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakingSingleTon {
	static WebDriver driver;

	public static WebDriver getDriver() {

		try {
			if (driver == null) {
				driver = new FirefoxDriver();

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

				Wait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
						.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return driver;
	}

	private MakingSingleTon() {

	}

}
