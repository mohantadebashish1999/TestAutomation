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
	//public PasswordPage(WebDriver ldriver)
	//{
	
	//this.driver=ldriver;
		
	//}
	
	@FindBy(xpath="//input[contains(@type,'password')]") WebElement Password1;
	
	@FindBy(xpath="//span[contains(text(),'Weiter')]") WebElement ClickOnSubmit;
	
	@FindBy(id="letsgo") WebElement letsGoButton;
	
	@FindBy(xpath="//span[contains(text(),'Weiter')]") WebElement Continue;
	
	public PasswordPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void EnterPassword(String pass) throws InterruptedException
	{
		Password1.sendKeys(pass);
		Thread.sleep(2000);
		ClickOnSubmit.click();
		//return new LetsGoPage();
		
	}
/*	
public void EnterPassword1(String pas) throws InterruptedException 
{
	
	Password1.sendKeys(pas);
	Thread.sleep(3000);
	
}
public void clickonbutton()
{
	ClickOnSubmit.click();
}

public void CLickOnTheLetsGoButton()
{
	letsGoButton.click();
}

public void clickOnTheContinueButton()
{	
	Continue.click();

}
*/
}
