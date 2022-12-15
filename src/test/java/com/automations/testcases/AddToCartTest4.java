/**
 * 
 */
package com.automations.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
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
 * clicking on the Procced with the selection button from the popup will keeps the previous item selected.
 */
public class AddToCartTest4 extends Base{
	Logger log =Logger.getLogger(AddToCartTest4.class);

	@Test
	public void ClickingOnProceed() throws InterruptedException
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

		//add 1st product to the cart
		addtocartpage.addFirstProduct();
		Thread.sleep(3000);

		//getting the button label of the 1st product after added into the cart.
		String initialBtnTxtof1stProduct= addtocartpage.getBtntextof1stProduct();
		System.out.println("The text after adding the porduct: "+  initialBtnTxtof1stProduct);

		//Trying to add 2nd product into the cart.
		String initialBtnTextof2ndproduct= addtocartpage.getBtntextof2ndProduct();
		System.out.println("The button label present on the 2nd product before added to cart: "+ initialBtnTextof2ndproduct);
		addtocartpage.addSecondProduct();
		Thread.sleep(3000);

		//clicking proceed button from the popup.
		addtocartpopuppage.clickOnTheProceedButton();
		Thread.sleep(3000);
		String finalBtnTxtof2ndProduct= addtocartpage.getBtntextof2ndProduct();
		System.out.println("The button label present on the 2nd product after clicking on the proceed button from the popup: "+ finalBtnTxtof2ndProduct);


		//Getting the text of the 1st added product after clicking on the proceed button from the popup.
		String finalBtnTxtof1stProduct  = addtocartpage.getBtntextof1stProduct();
		System.out.println("The text after clicking on the popup :" + finalBtnTxtof1stProduct);
		
		//Comparing the 1st product's button text after adding to cart and after clicking on the proceed button from the popup, They should be same.
		Assert.assertEquals(initialBtnTxtof1stProduct, finalBtnTxtof1stProduct);

		//comparing the 2nd product's button text before adding to the cart and after clicking on the proceed button from the popup, They should be same.
		Assert.assertEquals(initialBtnTextof2ndproduct, finalBtnTxtof2ndProduct);

		//checking if there are multiple added to cart button present. 
		int elementCounts= addtocartpage.countElement();
		System.out.println("count is: " + elementCounts);
		if (elementCounts==1)
		{	
			log.info("----------Test case passed.----------");

		}
		else
			log.info("----------Test case failed-------------");
		Thread.sleep(2000);

		
	}

		

		
	}


