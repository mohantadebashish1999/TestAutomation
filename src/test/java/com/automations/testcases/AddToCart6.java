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
import com.aventstack.extentreports.reporter.configuration.Theme;


/*
 * Users can skip the add to cart page. 
 */

public class AddToCart6 extends Base {
	
	Logger log =Logger.getLogger(AddToCart6.class);

	
	@Test
	
	public void SkipAddingProducts() throws InterruptedException
	{
		
		PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage attractiveofferpage = PageFactory.initElements(driver, AttractiveOfferPage.class);
		AddToCartPage addtocartpage = PageFactory.initElements(driver, AddToCartPage.class);
		

		passwordpage.enterPassword("Flp@2022#$");
		
		letsgopage.clickOnTheLetsGoButton();
		

		attractiveofferpage.ClickonContinuebtn();

		//validate if any products are added to cart before.
		try{
		boolean result=addtocartpage.validateAdd();
		Assert.assertFalse(result);
		log.info("--------products are already added to cart---------");
		log.info("-----test case failed----------");
		driver.close();
		}
		catch(Exception e)
		{
		addtocartpage.clickOnTheContinueButton();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL ="https://flp-de-sponsoring-dev.disellco.cloud/register/termcondition";
		Assert.assertEquals(actualURL, expectedURL);
		log.info("-----------Test case passed------------");
		Thread.sleep(3000);
		}
	
		
	}

}
