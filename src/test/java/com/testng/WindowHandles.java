package com.testng;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandles {

	static WebDriver driver;

	@Test
	public void windowHandling() {

		driver = new ChromeDriver();
		
		
	String parentWinow=	driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();

		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String s = itr.next();
			if(!parentWinow.equalsIgnoreCase(s)) {
				driver.switchTo().window(s);
				driver.getTitle();
				
			}

		}
		
		driver.switchTo().defaultContent();

	}
}
