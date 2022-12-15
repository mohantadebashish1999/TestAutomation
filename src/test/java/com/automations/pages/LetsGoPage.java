package com.automations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetsGoPage extends Base{
	
	

	@FindBy(id="letsgo") WebElement LetsgoButton;
	
	
	public LetsGoPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateLetsGoPage()
	{
		return  LetsgoButton.isDisplayed();
	}
	
	public void clickOnTheLetsGoButton()
	{
		LetsgoButton.click();
		
	}
}
