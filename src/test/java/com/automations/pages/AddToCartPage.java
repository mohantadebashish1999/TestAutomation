package com.automations.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends Base {
	
	
	@FindBy(xpath="(//span[@class=\"p-button-label\"])[1]") WebElement AddToCart1st;
	
	@FindBy(xpath="(//span[@class=\"p-button-label\"])[2]") WebElement AddToCart2;
	
	@FindBy(xpath="//span[contains(text(),'Weiter')]") WebElement Continuebtn;
	
	@FindBy(xpath="//span[contains(text(),'✔ Im Warenkorb')]") WebElement Added;
	
	
	//on the 1st product 
	@FindBy(xpath="(//span[contains(text(),'In den Warenkorb')])[1]") WebElement AddTOCart;


	public AddToCartPage()
	{
	PageFactory.initElements(driver, this);  
	}
	
	public void AddProduct1()
	{
		AddToCart1st.click();
	}
	
	public void AddProduct2()
	{
		AddToCart2.click();
	}
	public void clickOnTheContinueButton()
	{
		Continuebtn.click();
	}
	
	public boolean validateAdd()
	{
		return Added.isDisplayed();
		
	}
	
	
	public String gettext()
	{
		return AddToCart1st.getText();
	}
	
	public String gettext2()
	{
		return AddToCart2.getText();
	}
	
	public int countElement()
	{
		List<WebElement> elementsid = driver.findElements(By.xpath("//span[contains(text(),'✔ Im Warenkorb')]"));
		return elementsid.size();

	}
	
	
}
