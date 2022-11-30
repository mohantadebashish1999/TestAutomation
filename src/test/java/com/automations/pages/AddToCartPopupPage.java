package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPopupPage extends Base {

	
	
	@FindBy(xpath="//div[@class=\"modal-popup\"]") WebElement popup;
	 @FindBy(xpath="//span[contains(text(),'Mit Auswahl fortfahren')]") WebElement ProceedSelection;
	 
	 @FindBy(xpath="//span[contains(text(),'Auswahl ändern')]") WebElement changeSelection;
	
	

	public AddToCartPopupPage()
	{
	PageFactory.initElements(driver, this);  
	}
	
	public boolean validatePage()
	{
		return popup.isDisplayed();
	}
	
	public void clickOnTheProceedButton()
	{
		ProceedSelection.click();
	}
	
	public void clickOnChangeSelectionButton()
	{
		changeSelection.click();
	}
}
