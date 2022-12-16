package com.automations.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyEmailPage extends Base{

    @FindBy(xpath = "//input[@formcontrolname='email']") WebElement emailInputField;
    @FindBy(xpath = "//input[@formcontrolname='confirmEmail']") WebElement confirmEmailInputField;
    @FindBy(xpath = "//span[contains(text(),'Weiter')]") WebElement continueButton;
    @FindBy(xpath = "//h2[contains(text(),'E-Mail-Adresse verifizieren')]")WebElement emailVerificationTxt;
    @FindBy(xpath = "(//div[@class='form-error'])[1]")WebElement errorMsg1;
    @FindBy(xpath = "(//div[@class='form-error'])[2]")WebElement errorMsg2;

    


public VerifyEmailPage()
{
    PageFactory.initElements(driver, this);
}
public void enterEmail(String email)
{
    emailInputField.sendKeys(email);
}
public void enterConfirmEmail(String confirmEmail)
{
    confirmEmailInputField.sendKeys(confirmEmail);
}
public void clickOnContinueButton()
{
    continueButton.click();
}
public boolean verifyPage()
{
    return emailVerificationTxt.isDisplayed();
}

public String errorMsg1()
{
    return errorMsg1.getText();
}
public String errorMsg2()
{
    return errorMsg2.getText();
}
public int countElements()
{
    List<WebElement> count = driver.findElements(By.xpath("//div[@class='form-error']/div"));
    return count.size();
}


}

