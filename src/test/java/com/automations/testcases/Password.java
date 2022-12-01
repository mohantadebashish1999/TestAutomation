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
	
	//WebDriver driver;
	//PasswordPage passwordpagw;
	//LetsGoPage lgp;
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	
	}
	
	
	
	
	
	@Test(priority=1)
	
	public void password() throws InterruptedException, IOException
	{
		//passwordpagw= new PasswordPage();
		 //lgp = passwordpagw.EnterPassword("Flp@2022#$");
		 
		// ExtentTest test = extent.createTest("MyFirstTest","sample descripiton of the text");
		// test.log(Status.INFO, "this is the log info(status, details)");
		// test.info("This step shows usage of info(details)");
		// test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test.addScreenCaptureFromPath("screenshot.png");
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);
		LetsGoPage lp = PageFactory.initElements(driver, LetsGoPage.class);
		pp.EnterPassword("Flp@2022#$");
		boolean result= lp.ValidateLetsGoPage();
		Assert.assertTrue(result); 
		log.info("*****************Test case passed.. ******************");
		
		

		

		
	}
	/*
	this is just comment by kush.
	
	public void login() throws Exception  
	{ 
		
		PasswordPage pp = PageFactory.initElements(driver, PasswordPage.class);
		pp.EnterPassword1("Flp@2022#$");
		System.out.println("entered password");
		pp.clickonbutton();
		System.out.println("clicked on the submit button");
		Thread.sleep(6000);
		
		try   
		  { 
		if (driver.findElement(By.xpath("//h1[contains(text(),'Werde Teil der Forever Community')]")).isDisplayed())
		{
			pp.CLickOnTheLetsGoButton();
			Thread.sleep(3000);
			pp.clickOnTheContinueButton();
			System.out.println("passed");
		}
		
		  }
		catch(Exception e)     
		  {
			System.out.println("failed");
		  }
		
		
		Thread.sleep(6000);
		
	}
*/

}
