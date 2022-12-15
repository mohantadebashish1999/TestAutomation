package com.automations.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;

// clikcing on the continue button

public class AttractiveOffersTest02 extends Base {
	Logger log =Logger.getLogger(AttractiveOffersTest02.class);

	
@Test 
	
	public void clickOnContinueButton() throws InterruptedException
	{
		
		PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage attractiveofferpage = PageFactory.initElements(driver, AttractiveOfferPage.class);
		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		passwordpage.enterPassword("Flp@2022#$");
		
		letsgopage.clickOnTheLetsGoButton();
		attractiveofferpage.ClickonContinuebtn();

		//Verifying after clicking on the continue button , user is redirecting to the next page. comparing with both the URLs.
		String expectedurl = "https://flp-de-sponsoring-dev.disellco.cloud/register/starter";
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, expectedurl);
		System.out.println("passes");
		
		
		
	}

}
