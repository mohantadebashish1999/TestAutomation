package com.automations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Introducepage extends Base {
    @FindBy(xpath = "//label[contains(text(),' Ja, ich möchte unter folgender Person registriert werden. ')]")
     WebElement Agree;

     @FindBy(xpath = "//label[contains(text(),' Ich kenne die FBO-ID meines Sponsors nicht bzw. ich habe keinen Sponsor. ')]")
     WebElement notKnowSponser;

     @FindBy(xpath = "//p-button[@label='Suchen']")
     WebElement search;

     @FindBy(xpath = "//span[contains(text(),'Weiter')]")
     WebElement next;

     @FindBy(xpath = "//input[@formcontrolname='sponsorId']")
     WebElement searchbox;

     @FindBy(xpath = "//span[contains(text(),'Sponsor bestätigen')]")
     WebElement confirmsponser;

     @FindBy(xpath = "//span[contains(text(),'✔ Sponsor bestätigt')]")
     WebElement sponserconfirmed;

     @FindBy(xpath = "//p[contains(text(),'Es tut uns leid, leider kannst du diesen FBO nicht')]")
     WebElement ErrorMessage;

     @FindBy(xpath= "//strong[contains(text(),'Customer Care Deutschland')]")
     WebElement unknownSponsertxt;

     @FindBy(xpath = "//i[@class='pi pi-times']")
     WebElement crossicon;

     @FindBy(xpath = "//div[contains(text(),'Bitte bestätige deinen Sponsor, bevor du fortfährs')]")
     WebElement ErrorMsg2; 

     @FindBy(xpath = "//p[contains(text(),'Bitte bestätige deinen Sponsor, bevor du fortfährs')]")
     WebElement ErrorMsg3;

     public Introducepage()
	{
		
		PageFactory.initElements(driver, this);
	}

    public void validsponserid(String sponserid)
    {
        Agree.click();
        searchbox.sendKeys(sponserid);
        search.click();

    }
    public void acceptsponser() throws InterruptedException
    {
        confirmsponser.click();
        Thread.sleep(2000);
    }
    public Boolean validatebuttonclick()
    {
        return sponserconfirmed.isDisplayed();
        
    }
    public void ClickingContinue()
    {
        next.click();
    }

    public String getErrorMsg()
    {
        return ErrorMessage.getText();
        
        

    }

    public boolean verifyunknownSponser()
    {
        return unknownSponsertxt.isDisplayed();
    }

    public void clickOntheUnknownSponser()
    {
        notKnowSponser.click();
    }

    public boolean verifytheNextBtn()
    {
        return next.isEnabled();
    }
	public void clickOnCrossIcon()
    {
        crossicon.click();
    }

    public String GetErrorMsg2()
    {
        return ErrorMsg2.getText();
    }

    public String GetErrorMsg3()
    {
        return ErrorMsg3.getText();
    }

    





}