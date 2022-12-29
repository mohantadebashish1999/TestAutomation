package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetPasswordPage extends Base {
    @FindBy(xpath = "//h2[contains(text(),'Passwort erstellen')]") WebElement passwordTxt;
    @FindBy(xpath = "(//input[@type='password'])[1]")WebElement passwordfield;
    @FindBy(xpath = "//input[@placeholder='Passwort wiederholen']")WebElement confirmpasswordfield;
    @FindBy(xpath = "//span[contains(text(),'Weiter')]")WebElement nextBtn;
    @FindBy(xpath = "//div[contains(text(),'Das Passwort muss aus mindest')]")WebElement passworderrormsg;
    @FindBy(xpath = "//div[contains(text(),'Die Passwörter stimmen nicht überein.')]")WebElement confirmpassworderrormsg;
    

    public SetPasswordPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean verifySetPasswordPage()
    {
        return passwordTxt.isDisplayed();
    }
    public void setPassword(String pass1) throws InterruptedException
    {   
        //passwordfield.clear();
        passwordfield.click();
        Thread.sleep(2000);
        passwordfield.sendKeys(pass1);
    }
    public void setConfirmPassword(String confirmpassword) throws InterruptedException
    {
        confirmpasswordfield.click();
        Thread.sleep(2000);
        confirmpasswordfield.sendKeys(confirmpassword);
    }
    public void clickonNextButton()
    {
        nextBtn.click();
    }
    public String captureErrorMessage2()
    {
        return confirmpassworderrormsg.getText();
    }
    public String CaptureErrorMsg()
    {
        return passworderrormsg.getText();
    }
   
    
}
