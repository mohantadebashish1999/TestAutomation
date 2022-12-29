package com.automations.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.automations.pages.AttractiveOfferPage;
import com.automations.pages.Base;
import com.automations.pages.LetsGoPage;
import com.automations.pages.PasswordPage;

public class LetGoTest extends Base {
	
	Logger log =Logger.getLogger(LetGoTest.class);
	public LetGoTest()
	{
		PageFactory.initElements(driver, this);
	}

	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	@Test (priority=2)
	
	public void clickOnButton() throws InterruptedException, IOException
	{
		//PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class);

		LetsGoPage letsgopage = PageFactory.initElements(driver, LetsGoPage.class);
		//AttractiveOfferPage afp = PageFactory.initElements(driver, AttractiveOfferPage.class);
		Password password1 = PageFactory.initElements(driver, Password.class);
		password1.password();
		
		//entering password. 
		//passwordpage.enterPassword("Flp@2022#$");
		//Thread.sleep(2000);
		letsgopage.clickOnTheLetsGoButton();
		Thread.sleep(5000);
		String actualURL= driver.getCurrentUrl();
		String expectedURL= "https://flp-de-sponsoring-dev.disellco.cloud/register/starter";
		
		//afp.ValidateAttractivePage();
		Assert.assertEquals(expectedURL, actualURL ); 
		//log.info("*****************Test case passed ******************");

		
		
		

	}

}
