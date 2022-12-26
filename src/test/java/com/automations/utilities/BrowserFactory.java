package com.automations.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String Url)
	{
		if(browserName.equals("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput","true");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.out.println("Sorry we donot support this browser");
		}
		else if(browserName.equals("IE"))
		{
			System.out.println("Sorry we donot support this browser");
		}
		else 
		{
			System.out.println("Sorry we donot support this browser"); 	
		}
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);    

		driver.manage().window().maximize();
		driver.get(Url);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		return driver;
	} 
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
		driver = null;
	}
}
