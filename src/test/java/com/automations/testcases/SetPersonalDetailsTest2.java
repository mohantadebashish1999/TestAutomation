package com.automations.testcases;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.BankingPage;
import com.automations.pages.Base;
import com.automations.pages.EmailTabPage;
import com.automations.pages.EmailVerificationPopupPage;
import com.automations.pages.Introducepage;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.pages.PersonalDataPage;
import com.automations.pages.SetPasswordPage;
import com.automations.pages.StarterPackagesPage;
import com.automations.pages.TermsAndConditionsPage;
import com.automations.pages.Thankyoupage;
import com.automations.pages.VerifyEmailPage;
import com.github.javafaker.Faker;

public class SetPersonalDetailsTest2 extends Base {

    Logger log = Logger.getLogger(SetPersonalDetailsTest2.class);

    // overserve while not filling on all the required fields and clicking on the next button.
    @Test
    public void setValidPassword() throws InterruptedException {
        AddToCartPage addtocartpage = PageFactory.initElements(driver, AddToCartPage.class);
        PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

        LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
        AttractiveOfferPage attractiveofferpage = PageFactory.initElements(driver, AttractiveOfferPage.class);
        TermsAndConditionsPage termsandconditionspage = PageFactory.initElements(driver, TermsAndConditionsPage.class);
        Introducepage introducepage = PageFactory.initElements(driver, Introducepage.class);
        Thankyoupage thankyoupage = PageFactory.initElements(driver, Thankyoupage.class);
        StarterPackagesPage starterpackagespage = PageFactory.initElements(driver, StarterPackagesPage.class);
        VerifyEmailPage verifyemailpage = PageFactory.initElements(driver, VerifyEmailPage.class);
        EmailVerificationPopupPage emailverificationpopuppage = PageFactory.initElements(driver,EmailVerificationPopupPage.class);
        EmailTabPage emailtabpage = PageFactory.initElements(driver, EmailTabPage.class);
        SetPasswordPage setpasswordpage = PageFactory.initElements(driver, SetPasswordPage.class);
        PersonalDataPage personaldatapage = PageFactory.initElements(driver, PersonalDataPage.class);
        BankingPage bankingpage = PageFactory.initElements(driver, BankingPage.class);


        passwordpage.enterPassword("Flp@2022#$");

        letsgopage.clickOnTheLetsGoButton();
        Thread.sleep(2000);

        attractiveofferpage.ClickonContinuebtn();
        addtocartpage.addFirstProduct();
        Thread.sleep(2000);
        // boolean added= addtocartpage.validateAdd();
        // Assert.assertTrue(added);
        addtocartpage.clickOnTheContinueButton();
        Thread.sleep(3000);
        starterpackagespage.clickOnContinuebtn();

        Thread.sleep(3000);
        termsandconditionspage.clickOnAllTheCheckBoxes();
        Thread.sleep(4000);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://flp-de-sponsoring-dev.disellco.cloud/register/sponsorselection";
        Assert.assertEquals(actualURL, expectedURL);
        introducepage.validsponserid("410000001887");
        introducepage.acceptsponser();
        // verifying the accept sponser button is clicked....
        Boolean accepted = introducepage.validatebuttonclick();
        Assert.assertTrue(accepted);

        introducepage.ClickingContinue();
        Thread.sleep(2000);
        thankyoupage.clickOnTheContinueBtn();
        // creating random emails using java facker
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@yopmail.com";
        System.out.println("your new email address is :" + email);

        verifyemailpage.enterEmail(email);
        verifyemailpage.enterConfirmEmail(email);
        verifyemailpage.clickOnContinueButton();

        // verifying clicking on the continue button is displaying the respective popup
        // pages.

        boolean result = emailverificationpopuppage.verifyEmailSentPopup();
        Assert.assertTrue(result);
        Thread.sleep(3000);
        emailverificationpopuppage.clickOnCrossIcon();
        Thread.sleep(2000);
        boolean emailPagedisplayed = verifyemailpage.verifyPage();
        Assert.assertTrue(emailPagedisplayed);
        // opening new tab..
        // driver.switchTo().newWindow(WindowType.TAB);

        // driver.navigate().to("https://yopmail.com/");
        driver.get("https://yopmail.com/");
        emailtabpage.checkEmail(email);
        try {
            boolean robotpopup= emailtabpage.robotdialogisdisplayed();
            if (robotpopup)
            {
            emailtabpage.clickonNotanRobot();
            log.info("-----clicked on the i am not an robot option--------");
            }
            else
            log.info("------i am not an robot popup is not there------");
            
            // Assert.assertTrue(robotpopup);
        } catch (Exception e) {
            
            driver.close();
        }
        Thread.sleep(3000);
        driver.switchTo().frame("ifinbox");
        int emailcount = emailtabpage.countEmails();
        log.info("emails count is :" + emailcount);
        driver.switchTo().parentFrame();

        if (emailcount >= 1) {

            driver.switchTo().frame("ifmail");
            Boolean emailtabisdisplayed = emailtabpage.clickHereLinkisDisplayed();
            Assert.assertTrue(emailtabisdisplayed);
            emailtabpage.clickHereBtn();

        } else {
            log.info("Test case failed......");
            driver.quit();
        }

        // Getting all the tabs......

        ArrayList<String> newtabs = new ArrayList<String>(driver.getWindowHandles());
        log.info("total tabs are: " + newtabs.size());

        // switch to new tab

        driver.switchTo().window(newtabs.get(1));
        // System.out.println("Page title of new tab: " + driver.getTitle());
        boolean setpasswordpagedisplayed = setpasswordpage.verifySetPasswordPage();
        Assert.assertTrue(setpasswordpagedisplayed);

        //setting valid password.
       // Thread.sleep(2000);
        setpasswordpage.setPassword("Demo@123");
        //Thread.sleep(2000);
        setpasswordpage.setConfirmPassword("Demo@123");
        Thread.sleep(3000);
        setpasswordpage.clickonNextButton();
        boolean isdetailspagedisplayed= personaldatapage.verifyPage();
        Assert.assertTrue(isdetailspagedisplayed);
        log.info("Details page displayed........");
        //adding some required personal informations...
        personaldatapage.setSomeInfo();
        personaldatapage.clickOnNextBtn();
        Thread.sleep(2000);
        //count the number of error messages displayed.
        int errorMsgs= personaldatapage.countErrorMsg();
        log.info("no. of error messages are : "+ errorMsgs);
        //printing all the error messages..
        List<WebElement> errormsgs = driver.findElements(By.xpath("(//div[@class='form-error ng-star-inserted'])"));

        //System.out.println(bakeries.size());

        for (WebElement webElement : errormsgs)
        {
            String msgs = webElement.getText();
            log.info("error message is : "+ msgs);
        }
        if (errorMsgs==0)
        {
            Boolean result2 = bankingpage.VerifyPage();
            Assert.assertFalse(result2);
        }
        else
        {
            log.info("inside else block.........");
            
            Boolean result1 = personaldatapage.verifyPage();
            Assert.assertTrue(result1);
            log.info("test case passed.........");

        }

        Thread.sleep(4000);

    }

    
}