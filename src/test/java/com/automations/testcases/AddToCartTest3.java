/**
 * 
 */
package com.automations.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.AddToCartPopupPage;
import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.StarterPackagesPage;

/*
 * Adding 2nd items in the cart is opening a popup.
 */
public class AddToCartTest3 extends Base {
	Logger log =Logger.getLogger(AddToCartTest3.class);


	@Test
	public void Openingpopup() throws InterruptedException
	{
		AddToCartPage addtocartpage = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage attractiveofferpage = PageFactory.initElements(driver, AttractiveOfferPage.class);
	
		StarterPackagesPage starterpackagespage = PageFactory.initElements(driver, StarterPackagesPage.class);
		AddToCartPopupPage addtocartpopuppage = PageFactory.initElements(driver, AddToCartPopupPage.class);

		
		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		passwordpage.enterPassword("Flp@2022#$");
		
		letsgopage.clickOnTheLetsGoButton();
		
		attractiveofferpage.ClickonContinuebtn();
		//ac.ClickOnAddTOCart();
		//System.out.println("clicked");
		addtocartpage.addFirstProduct();
		Thread.sleep(3000);
		addtocartpage.addSecondProduct();
		boolean result= addtocartpopuppage.validatePage();
		Assert.assertTrue(result);
		log.info("---------------Test case passed.-------------");
		Thread.sleep(5000);
		
	}
}
