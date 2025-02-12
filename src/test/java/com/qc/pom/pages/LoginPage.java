package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(id = "submit")
	WebElement signin;
	
	@FindBy(linkText = "Register a new membership")
	WebElement regPageLink;
	
	public void enterEmail(String uName) {
		email.clear();
		email.sendKeys(uName);
	}
	
	public void enterPass(String uPass) {
		pass.clear();
		pass.sendKeys(uPass);
	}
	
	public void clickOnSubmit() {
		signin.click();
	}
	
	public void clickOnRegPageLink() {
		regPageLink.click();
	}
	
	public DashboardPage loginWithValidData(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickOnSubmit();
		return new DashboardPage(driver);
	}
	
	public void loginWithInvalidData(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickOnSubmit();
	}
	
	public boolean verifyLoginPage() {
		String actResult = driver.getTitle();
		String expResult = "Queue Codes | Log in";
		return actResult.equals(expResult);
	}
}
