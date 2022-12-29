package com.automations.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automations.pages.AddToCartPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;
import com.automations.utilities.BrowserFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Password extends Base {
	
	 Logger log =Logger.getLogger(Password.class);
	 public Password()
	 {
		PageFactory.initElements(driver, this);
	 }
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	
	}
	
	
	@Test(priority=1)
	
	public void password() throws InterruptedException, IOException
	{
		PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);
		LetsGoPage lp = PageFactory.initElements(driver, LetsGoPage.class);
		// Enter password.s
		passwordpage.enterPassword("Flp@2022#$");

		// Validate if user is navigate to the next page. 
		boolean result= lp.ValidateLetsGoPage();
		Assert.assertTrue(result); 
		//log.info("*****************Test case passed. ******************");
			
	}
	

}
