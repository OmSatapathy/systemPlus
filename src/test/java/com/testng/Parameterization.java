package com.testng;

import java.awt.Desktop.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameterization {

	static WebDriver driver;
	@Test(dataProvider = "data" )
	public void testInput(int a, int b) {


		int c= a+b;
		System.out.println(c);
		

		
	}

	@DataProvider(name="data")
	public Object[][] enterDetails() {
		return new Object[][] { {2, 3 }, {5, 7},
		{12, 3 }, {15, 7},
		{22, 3 }, {45, 7}

		};

	}
	
	@Test
	public void keyHandles() {
		driver = new ChromeDriver();
		driver.get("https://www.linkedin.com/feed/update/urn:li:activity:7274326531261251584/");
		Actions act= new Actions(driver);
		act.sendKeys(Keys.F5);
	}

}
