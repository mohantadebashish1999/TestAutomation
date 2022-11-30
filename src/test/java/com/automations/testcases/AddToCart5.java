/**
 * 
 */
package com.automations.testcases;

import org.openqa.selenium.JavascriptExecutor;
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
 * clicking on the change selection button from the popup will change the previously selected item
 */
public class AddToCart5 extends Base{
	
	@Test
	public void ChangeSelection() throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		

		acp.clickOnChangeSelectionButton();
		Thread.sleep(3000);
		String txt1 = atc.gettext();
		System.out.println("Text of product1 after clicking on the change selection button: "+ txt1);
		String txt2 = atc.gettext2();
		System.out.println("Text of product2 after clicking on the change selection button: "+ txt2);
		
		int elementCounts= atc.countElement();
		System.out.println("count is: " + elementCounts);
		if (elementCounts==1)
		{
			
			Assert.assertEquals (txt2, "✔ Im Warenkorb");
			System.out.println("passed");

		}
		else
			System.out.println("failed");
		Thread.sleep(2000);

		
	}

}
