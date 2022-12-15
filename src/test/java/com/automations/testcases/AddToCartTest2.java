package com.automations.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.StarterPackagesPage;

//clicking again on the cart to cart button should remove the product from the cart. 

public class AddToCartTest2 extends Base {
	Logger log =Logger.getLogger(AddToCartTest2.class);

	
	@Test
	
	public void validateCart1() throws InterruptedException
	{
		AddToCartPage addtocartpage = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage attractiveofferpage = PageFactory.initElements(driver, AttractiveOfferPage.class);
		
		StarterPackagesPage starterpackagespage = PageFactory.initElements(driver, StarterPackagesPage.class);

		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		passwordpage.enterPassword("Flp@2022#$"); 
		
		letsgopage.clickOnTheLetsGoButton();
		
		attractiveofferpage.ClickonContinuebtn();
		//Storing the initial text present on the add to cart button. 
		String initialText = addtocartpage.getBtntextof1stProduct();
		log.info("=======The text is: "+ initialText);
		
		//adding 1st product to the cart. 
		addtocartpage.addFirstProduct();
		Thread.sleep(2000); 
		//Storing the text after clicking on the add to cart button once.

		String textAfter1stclick= addtocartpage.getBtntextof1stProduct();
		log.info("=======The text is: "+ textAfter1stclick);

		//clicking on the same added product's add to cart button again. 
		addtocartpage.addFirstProduct();
		Thread.sleep(2000);

		// Storing the text of the button ater 2nd click on the add to cart button of the same products.
		String textAfter2ndclick = addtocartpage.getBtntextof1stProduct();
		log.info("=======The text is: "+ textAfter2ndclick);

		//Comparing the button label matched with the initial text and after 2nd click on the button.
		Assert.assertEquals(initialText, textAfter2ndclick);
		log.info("--------------Test case passed-----------------");
		
		Thread.sleep(5000);

		

		
	}

}
