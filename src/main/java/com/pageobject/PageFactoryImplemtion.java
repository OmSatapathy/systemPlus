package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryImplemtion {
	
	WebDriver driver;
	
	@FindBy(id="")
	private WebElement username;
	
	@FindBy(id="")
	private WebElement password;
	
	@FindBy(id="")
	private WebElement login;
	
	
	public PageFactoryImplemtion(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
