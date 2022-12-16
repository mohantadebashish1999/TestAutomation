package com.automations.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailTabPage extends Base{

    @FindBy(id ="login") WebElement emailtextbox;
    @FindBy(id = "refreshbut")WebElement sendBtn;
    @FindBy(xpath = "//a[contains(text(),'Bitte hier klicken')]")WebElement clickhereBtn;
    @FindBy(xpath = "//div[@id='r_dialog']")WebElement iamnotanrobot;
    @FindBy(xpath = "(//div[@class='m'])[1]") WebElement firstEmail;
    

    public EmailTabPage()
    {
        PageFactory.initElements(driver, this);
    }
    public void checkEmail(String email)
    {   
        emailtextbox.sendKeys(email);
        sendBtn.click();

    }
    public void clickHereBtn()
    {
        clickhereBtn.click();
    }
    public int countEmails()
    {
        List<WebElement> elementsid = driver.findElements(By.xpath("//div[@class='m']"));
		return elementsid.size();

    }
    public boolean robotdialogisdisplayed()
    {
        return iamnotanrobot.isDisplayed();
    }
    public void clickonNotanRobot()
    {
        iamnotanrobot.click();
    }
    public void clickOnFirstEmail()
    {
        firstEmail.click();
    }
    
}
