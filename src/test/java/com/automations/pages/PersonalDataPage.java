package com.automations.pages;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDataPage extends Base{

    @FindBy(xpath = "//h2[contains(text(),'Persönliche Daten')]")WebElement personaldataText;

    public PersonalDataPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyPage()
    {
        return personaldataText.isDisplayed();
    }


    
}
