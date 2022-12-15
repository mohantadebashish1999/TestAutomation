package com.automations.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.Introducepage;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.StarterPackagesPage;
import com.automations.pages.TermsAndConditionsPage;
import com.automations.pages.Thankyoupage;
import com.beust.jcommander.internal.Console;

public class UnknownSponser extends Base {
    Logger log =Logger.getLogger(UnknownSponser.class);

    @Test
    public void clickingOntheUnknownSponserbtn() throws InterruptedException
    {
        AddToCartPage addtocartpage = PageFactory.initElements(driver, AddToCartPage.class);
		PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
		AttractiveOfferPage attractiveofferpage = PageFactory.initElements(driver, AttractiveOfferPage.class);
		//AddToCartPage atc = PageFactory.initElements(driver, AddToCartPage.class);
		//StarterPackagesPage spp = PageFactory.initElements(driver, StarterPackagesPage.class);
		//AddToCartPopupPage acp = PageFactory.initElements(driver, AddToCartPopupPage.class);
		TermsAndConditionsPage termsandconditionspage = PageFactory.initElements(driver, TermsAndConditionsPage.class);
        Introducepage introducepage = PageFactory.initElements(driver, Introducepage.class);
        Thankyoupage thankyoupage = PageFactory.initElements(driver, Thankyoupage.class);
        StarterPackagesPage starterpackagespage = PageFactory.initElements(driver, StarterPackagesPage.class);



		passwordpage.enterPassword("Flp@2022#$");
		
		letsgopage.clickOnTheLetsGoButton();
		
		attractiveofferpage.ClickonContinuebtn();
		addtocartpage.addFirstProduct();
		boolean added= addtocartpage.validateAdd();
		Assert.assertTrue(added);
		addtocartpage.clickOnTheContinueButton();
        Thread.sleep(3000);
        starterpackagespage.clickOnContinuebtn();
		
        Thread.sleep(2000);
		termsandconditionspage.clickOnAllTheCheckBoxes();
		Thread.sleep(4000);
		String actualURL = driver.getCurrentUrl();
		String expectedURL ="https://flp-de-sponsoring-dev.disellco.cloud/register/sponsorselection";
		Assert.assertEquals(actualURL, expectedURL);

        introducepage.clickOntheUnknownSponser();
        boolean pass = introducepage.verifyunknownSponser();
        Assert.assertTrue(pass);
       
        
        try {
            introducepage.ClickingContinue();
            Boolean t1= thankyoupage.verify();
            Assert.assertTrue(t1);
            log.info("------------- test case failed------------");
            
        }
         catch (Exception e) {
            
            log.info("--------------test case passed-----------");
        }
        
       
        Thread.sleep(5000);


}
}
