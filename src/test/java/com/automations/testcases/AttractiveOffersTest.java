package com.automations.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.WelcomeForeverCommunityPage;

public class AttractiveOffersTest extends Base { 
Logger log = Logger.getLogger(AttractiveOffersTest.class);
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	@Test 
	public void Community() throws InterruptedException
	{
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage lgp = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		pp.EnterPassword("Flp@2022#$");
		
		lgp.clickOnTheLetsGoButton();
		
		afp.ClickOnregistration();
		String expectedurl = "https://flp-de-sponsoring-dev.disellco.cloud/register/termcondition";
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, expectedurl);
		log.info("============test case passed ==============");
		
		
		
	}
	
	
	/*
	@Test 
	
	public void clickcontinue() throws InterruptedException
	{
		
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage lgp = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		pp.EnterPassword("Flp@2022#$");
		
		lgp.clickOnTheLetsGoButton();
		afp.ClickonContinuebtn();
		String expectedurl = "https://flp-de-sponsoring-dev.disellco.cloud/register/starter";
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, expectedurl);
		System.out.println("passes");
		
		
		
	}*/
}
