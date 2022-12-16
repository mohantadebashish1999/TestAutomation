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
import com.github.javafaker.Faker;

public class EmailVerificationTest4 extends Base {
    
    Logger log =Logger.getLogger(EmailVerificationTest4.class);

    //checking with new email address. 

    @Test
    public void newEmails() throws InterruptedException
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
        //creating random emails using java facker
        Faker faker = new Faker();
        String firstName= faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() +"."+lastName.toLowerCase() + "@yopmail.com";
        System.out.println(email);

        verifyemailpage.enterEmail(email);
        verifyemailpage.enterConfirmEmail(email);
        verifyemailpage.clickOnContinueButton();


        //verifying clicking on the continue button is displaying the respective popup pages. 
       
            boolean result= emailverificationpopuppage.verifyEmailSentPopup();
            Assert.assertTrue(result);
            //emailverificationpopuppage.clickOnSubmitBtn();
            //boolean emailsentIsdisplayed = emailverificationpopuppage.verifyEmailSentPopup();
           // Assert.assertTrue(emailsentIsdisplayed);
           Thread.sleep(3000);
            emailverificationpopuppage.clickOnCrossIcon();
            Thread.sleep(2000);
            boolean emailPagedisplayed= verifyemailpage.verifyPage();
            Assert.assertTrue(emailPagedisplayed);
            
            log.info("--------------test case passed------------");


       
        Thread.sleep(5000);
       
        
    }

    
    
}
