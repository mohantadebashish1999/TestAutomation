
package com.automations.testcases;

import org.apache.log4j.Logger;
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

/*
 * clicking on the change selection button from the popup will change the previously selected item
 */
public class AddToCart5 extends Base{
	Logger log =Logger.getLogger(AddToCart5.class);

	
	@Test
	public void ChangeSelection() throws InterruptedException
	{
		AddToCartPage addtocartpage = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage attractiveofferpage = PageFactory.initElements(driver, AttractiveOfferPage.class);
		StarterPackagesPage starterpackagespage = PageFactory.initElements(driver, StarterPackagesPage.class);
		AddToCartPopupPage addtocartpopuppage = PageFactory.initElements(driver, AddToCartPopupPage.class);

		passwordpage.enterPassword("Flp@2022#$");
		
		letsgopage.clickOnTheLetsGoButton();
		
		attractiveofferpage.ClickonContinuebtn();
		
		addtocartpage.addFirstProduct();
		Thread.sleep(3000);
		String txt= addtocartpage.getBtntextof1stProduct();
		System.out.println("The text after adding the porduct: "+ txt);
		addtocartpage.addSecondProduct();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//clicking on the proceed button from the popup.
		addtocartpopuppage.clickOnChangeSelectionButton();
		Thread.sleep(3000);
		String buttonText1stProd = addtocartpage.getBtntextof1stProduct();
		System.out.println("Text of product1 after clicking on the change selection button: "+ buttonText1stProd);
		String buttonText2ndProd = addtocartpage.getBtntextof2ndProduct();
		System.out.println("Text of product2 after clicking on the change selection button: "+ buttonText2ndProd);
		
		int elementCounts= addtocartpage.countElement();
		System.out.println("count is: " + elementCounts);
		if (elementCounts==1)
		{
			
			Assert.assertEquals (buttonText2ndProd, "✔ Im Warenkorb");
			log.info("---------Test case passed-----------");

		}
		else
			log.info("--------Test case failed.-------------");
		Thread.sleep(2000);

		
	}

}
