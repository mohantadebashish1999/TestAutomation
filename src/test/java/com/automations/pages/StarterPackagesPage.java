package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StarterPackagesPage extends Base {

	@FindBy(xpath="//span[contains(text(),'Ja, ich nehme das Angebot gerne an')]") WebElement AcceptOffer;
	
	
	
	
	public StarterPackagesPage() 
	{
	PageFactory.initElements(driver, this); 
	}
	
	public boolean validatePage()
	{
		return AcceptOffer.isDisplayed();
	}
}
