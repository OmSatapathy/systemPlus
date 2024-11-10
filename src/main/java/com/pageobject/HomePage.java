package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']") 
    private WebElement acceptCokkies;
	
	
	@FindBy(xpath = "//a[@href='#subnav-search-desktop-top']//span[@class='icon-search bhc-icon-search-rounded']") 
    private WebElement searchbutton;

    @FindBy(xpath = "(//input[@id='search-field'])[2]") 
    private WebElement searchField;
    
    @FindBy(xpath = "(//button[text()='Search'])[2]") 
    private WebElement buttonforSearch;
    
   
    

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void cokkiesAccept() {
    	acceptCokkies.click();
    }
    

    public void clickSearch() {
    	searchField.click();
    }

    public void enterSearchTerm(String term) {
        searchField.sendKeys(term);
    }
    
    
    public void seachingtext() {
    	buttonforSearch.click();
    }
    
}
