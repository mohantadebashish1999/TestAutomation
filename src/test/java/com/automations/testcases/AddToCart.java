package com.automations.testcases;

//clicking on the add to cart button and continue button

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.StarterPackagesPage;

public class AddToCart extends Base {
	
	@Test 
	public void AddCart() throws InterruptedException
	{
		
		//AddToCartPage ac = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage lgp = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		AddToCartPage atc = PageFactory.initElements(driver, AddToCartPage.class);
		StarterPackagesPage spp = PageFactory.initElements(driver, StarterPackagesPage.class);

		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		pp.EnterPassword("Flp@2022#$");
		
		lgp.clickOnTheLetsGoButton();
		
		afp.ClickonContinuebtn();
		//ac.ClickOnAddTOCart();
		//System.out.println("clicked");
		atc.AddProduct1();
		boolean added= atc.validateAdd();
		Assert.assertTrue(added);
		atc.clickOnTheContinueButton();
		boolean hpyact= spp.validatePage();
		Assert.assertTrue(hpyact);
		System.out.println("passed");
		
		
		
		
		Thread.sleep(5000); 
	 }
	
 
}
