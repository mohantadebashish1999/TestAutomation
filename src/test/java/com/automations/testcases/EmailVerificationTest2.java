package com.automations.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.EmailVerificationPopupPage;
import com.automations.pages.Introducepage;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.StarterPackagesPage;
import com.automations.pages.TermsAndConditionsPage;
import com.automations.pages.Thankyoupage;
import com.automations.pages.VerifyEmailPage;

public class EmailVerificationTest2 extends Base {
    Logger log =Logger.getLogger(EmailVerificationTest2.class);

    //checking with valid email id but different confirmemail id..

    @Test
    public void DifferentEmails() throws InterruptedException
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
        VerifyEmailPage verifyemailpage = PageFactory.initElements(driver, VerifyEmailPage.class);
        EmailVerificationPopupPage emailverificationpopuppage = PageFactory.initElements(driver, EmailVerificationPopupPage.class);


		passwordpage.enterPassword("Flp@2022#$");
		
		letsgopage.clickOnTheLetsGoButton();
        Thread.sleep(2000);
		
		attractiveofferpage.ClickonContinuebtn();
		addtocartpage.addFirstProduct();
        Thread.sleep(2000);
		//boolean added= addtocartpage.validateAdd();
		//Assert.assertTrue(added);
		addtocartpage.clickOnTheContinueButton();
        Thread.sleep(3000);
        starterpackagespage.clickOnContinuebtn();
		
        Thread.sleep(2000);
		termsandconditionspage.clickOnAllTheCheckBoxes();
		Thread.sleep(4000);
		String actualURL = driver.getCurrentUrl();
		String expectedURL ="https://flp-de-sponsoring-dev.disellco.cloud/register/sponsorselection";
		Assert.assertEquals(actualURL, expectedURL);
        introducepage.validsponserid("410000001887");
        introducepage.acceptsponser();
        //verifying the accept sponser button is clicked....
        Boolean accepted = introducepage.validatebuttonclick();
        Assert.assertTrue(accepted);

        introducepage.ClickingContinue();
        Thread.sleep(2000);
        thankyoupage.clickOnTheContinueBtn();
        verifyemailpage.enterEmail("test@yopmail.com");
        verifyemailpage.enterConfirmEmail("test123@yopmail.com");
        verifyemailpage.clickOnContinueButton();


        //verifying clicking on the continue button it is going to the next page.
        String errorMsg= verifyemailpage.errorMsg1();
       // String errorMsg1= verifyemailpage.errorMsgConfirmEmail();
        log.info("error message is: "+ errorMsg);
        //log.info("error message on the confirm email field is: "+errorMsg1);
        try
        {
            boolean result= emailverificationpopuppage.verifyPage();
            Assert.assertTrue(result);
            log.info("-----------Test case failed.--------");

        }
        catch(Exception e)
        {
            log.info("---------Test case passed----------");
        }
       
       
        
    }

    
}
