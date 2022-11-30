package com.automations.testcases;

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


/**
 * @author user
 * Users can skip the add to cart page. 
 */

public class AddToCart6 extends Base {
	
	//Logger log = Logger
	
	@Test
	
	public void SkipAddingProducts() throws InterruptedException
	{
		//AddToCartPage ac = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage lgp = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		AddToCartPage atc = PageFactory.initElements(driver, AddToCartPage.class);
		//StarterPackagesPage spp = PageFactory.initElements(driver, StarterPackagesPage.class);
		//AddToCartPopupPage acp = PageFactory.initElements(driver, AddToCartPopupPage.class);

		pp.EnterPassword("Flp@2022#$");
		
		lgp.clickOnTheLetsGoButton();
		boolean val=atc.validateAdd();
		Assert.assertFalse(val);
		
		
		afp.ClickonContinuebtn();
		atc.clickOnTheContinueButton();
		String actualURL = driver.getCurrentUrl();
		String expectedURL ="https://flp-de-sponsoring-dev.disellco.cloud/register/termcondition";
		Assert.assertEquals(actualURL, expectedURL);
	}

}
