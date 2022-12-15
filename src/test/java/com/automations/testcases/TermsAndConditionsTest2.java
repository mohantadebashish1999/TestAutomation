package com.automations.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.TermsAndConditionsPage;

public class TermsAndConditionsTest2 extends Base{
	@Test
	public void ValidateError() throws InterruptedException
	{
		AddToCartPage ac = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage lgp = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		AddToCartPage atc = PageFactory.initElements(driver, AddToCartPage.class);
		//StarterPackagesPage spp = PageFactory.initElements(driver, StarterPackagesPage.class);
		//AddToCartPopupPage acp = PageFactory.initElements(driver, AddToCartPopupPage.class);
		TermsAndConditionsPage tac = PageFactory.initElements(driver, TermsAndConditionsPage.class);


		pp.enterPassword("Flp@2022#$");
		
		lgp.clickOnTheLetsGoButton();
		
		afp.ClickonContinuebtn();
		atc.clickOnTheContinueButton();
		tac.NotClickedonAlltheCheckBoxes();
		String errorMessage = tac.showErrorMessage();
		System.out.println("Error message: " + errorMessage);
		Thread.sleep(4000);
		String actualURL = driver.getCurrentUrl();
		String expectedURL ="https://flp-de-sponsoring-dev.disellco.cloud/register/sponsorselection";
		//Assert.assertEquals(actualURL, expectedURL);
		Assert.assertNotEquals(actualURL, expectedURL);
		
		
	}
	
}
