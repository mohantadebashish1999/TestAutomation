package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsAndConditionsPage extends Base{
	
	@FindBy(xpath="(//span[@class=\"checkmark-checkbox\"])[1]") WebElement checkbox1;
	@FindBy(xpath="(//span[@class=\"checkmark-checkbox\"])[2]") WebElement checkbox2;

	@FindBy(xpath="(//span[@class=\"checkmark-checkbox\"])[3]") WebElement checkbox3;
	@FindBy(xpath="//span[contains(text(),'Weiter')]") WebElement continuebutton;
	@FindBy(xpath="//p[@class=\"error-msg\"]") WebElement errormsg;
	
	
	
	public TermsAndConditionsPage()
	{
	PageFactory.initElements(driver, this);  
	}
	
	public void clickOnAllTheCheckBoxes()
	{
		checkbox1.click();
		checkbox2.click();
		checkbox3.click();
		continuebutton.click();
	}
	
	public void NotClickedonAlltheCheckBoxes()
	{
		checkbox1.click();
		checkbox2.click();
		continuebutton.click();
	}
	public String showErrorMessage()
	{
		return errormsg.getText();
	}

}
