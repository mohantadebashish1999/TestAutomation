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
 * clicking on the Procced with the selection button from the popup will keeps the previous item selected.
 */
public class AddToCartTest4 extends Base{
	@Test
	public void Proceed() throws InterruptedException
	{
		AddToCartPage ac = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage lgp = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		AddToCartPage atc = PageFactory.initElements(driver, AddToCartPage.class);
		StarterPackagesPage spp = PageFactory.initElements(driver, StarterPackagesPage.class);
		AddToCartPopupPage acp = PageFactory.initElements(driver, AddToCartPopupPage.class);

		pp.EnterPassword("Flp@2022#$");
		
		lgp.clickOnTheLetsGoButton();
		
		afp.ClickonContinuebtn();
		
		atc.AddProduct1();
		Thread.sleep(3000);
		String txt= atc.gettext();
		System.out.println("The text after adding the porduct: "+ txt);
		atc.AddProduct2();
		Thread.sleep(3000);
		acp.clickOnTheProceedButton();
		Thread.sleep(3000);
		String textAfterClickingOnPopUp = atc.gettext();
		System.out.println("The text after clicking on the popup :" + textAfterClickingOnPopUp);
		Assert.assertEquals(txt, textAfterClickingOnPopUp);
		System.out.println("passed");
		Thread.sleep(5000);

		
	}

}
