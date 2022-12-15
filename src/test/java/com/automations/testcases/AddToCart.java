package com.automations.testcases;

import org.apache.log4j.Logger;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.StarterPackagesPage;


// Adding 1st product to the cart. 

public class AddToCart extends Base {
	Logger log =Logger.getLogger(AddToCart.class);
	
	@Test 
	public void add1stProductToCart() throws InterruptedException
	{
		
		//AddToCartPage ac = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage attractiveofferpage = PageFactory.initElements(driver, AttractiveOfferPage.class);
		AddToCartPage addtocartpage = PageFactory.initElements(driver, AddToCartPage.class);
		StarterPackagesPage starterpackagespage = PageFactory.initElements(driver, StarterPackagesPage.class);

		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		passwordpage.enterPassword("Flp@2022#$");
		
		letsgopage.clickOnTheLetsGoButton();
		
		attractiveofferpage.ClickonContinuebtn();
		//ac.ClickOnAddTOCart();
		//System.out.println("clicked");
		addtocartpage.addFirstProduct();
		boolean addedProductToCart= addtocartpage.validateAdd();
		Assert.assertTrue(addedProductToCart);
		addtocartpage.clickOnTheContinueButton();
		boolean verifyPage= starterpackagespage.validatePage();
		Assert.assertTrue(verifyPage);
		log.info("------------Test case passed.---------------");
		
		
		
		
		Thread.sleep(5000); 
	 }
	
 
}
