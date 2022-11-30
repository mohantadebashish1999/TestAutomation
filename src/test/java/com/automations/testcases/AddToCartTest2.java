/**
 * 
 */
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

/**
 * @author user
 * clicking on the button again will remove the item.
 *
 */
public class AddToCartTest2 extends Base {
	Logger log =Logger.getLogger(AddToCartTest2.class);

	
	@Test
	
	public void validateCart1() throws InterruptedException
	{
		AddToCartPage ac = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage lgp = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		AddToCartPage atc = PageFactory.initElements(driver, AddToCartPage.class);
		StarterPackagesPage spp = PageFactory.initElements(driver, StarterPackagesPage.class);

		
		//WelcomeForeverCommunityPage wfcp = PageFactory.initElements(driver, WelcomeForeverCommunityPage.class);

		
		pp.EnterPassword("Flp@2022#$"); 
		
		lgp.clickOnTheLetsGoButton();
		
		afp.ClickonContinuebtn();
		//ac.ClickOnAddTOCart();
		//System.out.println("clicked");
		String initialText = atc.gettext();
		log.info("=======The text is: "+ initialText);
		//System.out.println("The text is: "+ initialText);

		atc.AddProduct1();
		Thread.sleep(2000); 
		String textAfter1stclick= atc.gettext();
		//System.out.println("The text is: "+ textAfter1stclick);
		log.info("=======The text is: "+ textAfter1stclick);

		
		atc.AddProduct1();
		Thread.sleep(2000);

		String textAfter2ndclick = atc.gettext();
		//System.out.println("The text is: "+ textAfter2ndclick);
		log.info("=======The text is: "+ textAfter2ndclick);

		
		Assert.assertEquals(initialText, textAfter2ndclick);
		
		Thread.sleep(5000);

		

		
	}

}
