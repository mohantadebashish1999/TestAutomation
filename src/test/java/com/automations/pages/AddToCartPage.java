package com.automations.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends Base {
	
	
	@FindBy(xpath="(//span[@class=\"p-button-label\"])[1]") WebElement firstProduct;
	
	@FindBy(xpath="(//span[@class=\"p-button-label\"])[2]") WebElement secondProduct;
	
	@FindBy(xpath="//span[contains(text(),'Weiter')]") WebElement continueButton;
	
	@FindBy(xpath="//span[contains(text(),'✔ Im Warenkorb')]") WebElement Added;
	
	
	//on the 1st product 
	@FindBy(xpath="(//span[contains(text(),'In den Warenkorb')])[1]") WebElement AddTOCart;


	public AddToCartPage()
	{
	PageFactory.initElements(driver, this);  
	}
	
	public void addFirstProduct()
	{
		firstProduct.click();
	}
	
	public void addSecondProduct()
	{
		secondProduct.click();
	}
	public void clickOnTheContinueButton()
	{
		continueButton.click();
	}
	
	public boolean validateAdd()
	{
		return Added.isDisplayed();
		
	}
	
	
	public String getBtntextof1stProduct()
	{
		return firstProduct.getText();
	}
	
	public String getBtntextof2ndProduct()
	{
		return secondProduct.getText();
	}
	
	public int countElement()
	{
		List<WebElement> elementsid = driver.findElements(By.xpath("//span[contains(text(),'✔ Im Warenkorb')]"));
		return elementsid.size();

	}
	
	
}
