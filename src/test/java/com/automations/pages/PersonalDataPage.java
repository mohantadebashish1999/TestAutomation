package com.automations.pages;

import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automations.utilities.TestData;
import com.github.javafaker.Faker;

public class PersonalDataPage extends Base{

    @FindBy(xpath = "//h2[contains(text(),'Persönliche Daten')]")WebElement personaldataText;
    @FindBy(xpath = "//span[contains(text(),'Anrede')]")WebElement salutation;
    @FindBy(xpath = "//span[contains(text(),'Herr')]")WebElement Mr;
    @FindBy(xpath = "//span[contains(text(),'Frau')]")WebElement women;
    @FindBy(xpath = "//input[@placeholder='Geburtsdatum (TT.MM.JJJJ)']")WebElement DOB;
    @FindBy(xpath = "//input[@placeholder='Vorname']")WebElement firstname;
    @FindBy(xpath = "//input[@placeholder='Nachname']")WebElement lastname;
    @FindBy(xpath = "//input[@placeholder='Straße']")WebElement street;
    @FindBy(xpath = "//input[@placeholder='Hausnummer']")WebElement housenumber;
    @FindBy(xpath = "//input[@placeholder='PLZ']")WebElement zipcode;
    @FindBy(xpath = "//input[@placeholder='Ort']")WebElement location;
    @FindBy(xpath = "//input[@id='phone']")WebElement phonenumber;
    @FindBy(xpath = "//span[contains(text(),'Weiter')]")WebElement nextBtn;
    @FindBy(xpath = "//div[@class='form-error ng-star-inserted']")WebElement errorMsg;

    public PersonalDataPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyPage()
    {
        return personaldataText.isDisplayed();
    }

    public int countErrorMsg()
    {
        List<WebElement> errorMsgscount = driver.findElements(By.xpath("//div[@class='form-error ng-star-inserted']"));
		return errorMsgscount.size();
    }
    
    public void clickOnNextBtn() throws InterruptedException
    {   
       
        JavascriptExecutor executor = (JavascriptExecutor)driver;   
        executor.executeScript("arguments[0].click();", nextBtn);
    }

    public void setSomeInfo()
    {
        salutation.click();
        Mr.click();
        DOB.sendKeys(TestData.GenerateDOB());
        firstname.sendKeys(TestData.GenerateFirstName());
        lastname.sendKeys(TestData.GenerateLastName());

    }

    public void setAllValidInfo()
    {
        salutation.click();
        Mr.click();
        DOB.sendKeys(TestData.GenerateDOB());
        firstname.sendKeys(TestData.GenerateFirstName());
        lastname.sendKeys(TestData.GenerateLastName());
        street.sendKeys(TestData.GenerateStreet());
        housenumber.sendKeys(TestData.GenerateHouseNumber());
        zipcode.sendKeys(TestData.GenerateZipCode());
        location.sendKeys(TestData.GenerateLocation());
        phonenumber.sendKeys(TestData.GeneratePhoneNumber());

    }
   

    
        
        
}



    

