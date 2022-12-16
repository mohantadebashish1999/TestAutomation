package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetPasswordPage extends Base {
    @FindBy(xpath = "//h2[contains(text(),'Passwort erstellen')]") WebElement passwordTxt;
    @FindBy(xpath = "//input[@placeholder='Passwort']")WebElement passwordfield;
    @FindBy(xpath = "//input[@placeholder='Passwort wiederholen']")WebElement confirmpasswordfield;
    

    public SetPasswordPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean verifySetPasswordPage()
    {
        return passwordTxt.isDisplayed();
    }
}
