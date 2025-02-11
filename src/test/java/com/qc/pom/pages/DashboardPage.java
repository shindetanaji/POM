package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "hlogout")
	WebElement logout;
	
	public void doLogout() {
		logout.click();
	}
	
	public boolean verifyHomePage() {
		String actResult = driver.getTitle();
		String expResult = "Queue Codes | Dashboard";
		return actResult.equals(expResult);
	}
}
