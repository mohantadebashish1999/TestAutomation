package com.automations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PasswordPage extends Base {

	WebDriver driver;

	@FindBy(xpath = "//input[contains(@type,'password')]")
	WebElement Password;

	@FindBy(xpath = "//span[contains(text(),'Weiter')]")
	WebElement continueButton;

	

	public PasswordPage() {

		PageFactory.initElements(driver, this);
	}

	public void enterPassword(String pass) throws InterruptedException {
		Password.sendKeys(pass);
		Thread.sleep(2000);
		continueButton.click();
		

	}
	
}
