package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailVerificationPopupPage extends Base {
    
    @FindBy(xpath = "//div[@class='modal-popup']") WebElement popup1;

    @FindBy(xpath = "//span[contains(text(),'Einreichen')]") WebElement submitButton;

    @FindBy(xpath = "//i[@class='pi pi-times']")WebElement crossIcon;

    @FindBy(xpath = "//h2[contains(text(),'E-Mail wurde versendet')]") WebElement emailSentPopup;

    @FindBy(xpath = "//div[contains(text(),'Ihre E-Mail-Adresse ist bereits in unserem System ')]") WebElement alreadyRegisteredEmailPopup;



    public EmailVerificationPopupPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyPage()
    {
       return popup1.isDisplayed();
    }
    public boolean VerifyPopupForRegisteredEmail()
    {
        return alreadyRegisteredEmailPopup.isDisplayed();
    }
    public void clickOnSubmitBtn()
    {
        submitButton.click();
    }
    public boolean verifyEmailSentPopup()
    {
        return emailSentPopup.isDisplayed();
    }
    public void clickOnCrossIcon()
    {
        crossIcon.click();
    }
}
