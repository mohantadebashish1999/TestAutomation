/**
 * 
 */
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
 * Adding 2nd items in the cart is opening a popup.
 */
public class AddToCartTest3 extends Base {

	@Test
	public void Openingpopup() throws InterruptedException
	{
		AddToCartPage ac = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage lgp = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		AddToCartPage atc = PageFactory.initElements(driver, AddToCartPage.class);
		StarterPackagesPage spp = PageFactory.initElements(driver, StarterPackagesPage.class);
		AddToCartPopupPage acp = PageFactory.initElements(driver, AddToCartPopupPage.class);

		
		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		pp.EnterPassword("Flp@2022#$");
		
		lgp.clickOnTheLetsGoButton();
		
		afp.ClickonContinuebtn();
		//ac.ClickOnAddTOCart();
		//System.out.println("clicked");
		atc.AddProduct1();
		Thread.sleep(3000);
		atc.AddProduct2();
		boolean result= acp.validatePage();
		Assert.assertTrue(result);
		Thread.sleep(5000);
		
	}
}
