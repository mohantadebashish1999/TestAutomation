package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Thankyoupage extends Base {

    @FindBy(xpath= "//h2[contains(text(),'Vielen Dank!')]")
    WebElement ThankyouText;

    @FindBy(xpath = "//span[contains(text(),'Weiter')]")
    WebElement continuebtn;
    

public Thankyoupage() {

    PageFactory.initElements(driver, this);
}
public boolean verify()
{
    return ThankyouText.isDisplayed();
}
}
