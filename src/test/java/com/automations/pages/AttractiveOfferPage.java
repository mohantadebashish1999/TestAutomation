package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AttractiveOfferPage extends Base {
	
	@FindBy(xpath="//span[contains(text(),'Weiter')]") WebElement continuebtn;
	
	@FindBy(xpath="//span[contains(text(),'Direkt zur Registrierung')]") WebElement GoToRegistration;
	
	public AttractiveOfferPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonContinuebtn() throws InterruptedException
	{
		Thread.sleep(4000);

		continuebtn.click();
		//return new AddToCartPage();
	}
	
	public void ClickOnregistration() throws InterruptedException
	{	
		Thread.sleep(4000);
		GoToRegistration.click(); 
		//return new WelcomeForeverCommunityPage();
		
	}
	
	
}
