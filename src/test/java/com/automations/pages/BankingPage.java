package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingPage extends Base {
    @FindBy(xpath = "//h2[contains(text(),'Bankverbindung für Bonusauszahlung')]")WebElement BankingText;

    public BankingPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyPage()
    {
        return BankingText.isDisplayed();
    }
    
}
