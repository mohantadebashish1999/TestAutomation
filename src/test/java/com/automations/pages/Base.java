package com.automations.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.automations.utilities.BrowserFactory;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class Base {

	public static WebDriver driver;
	public static Properties prop;
	//ExtentHtmlReporter htmlreporter;
	//protected ExtentReports extent;
	

	@BeforeClass
	public void setup()
	{

		driver=BrowserFactory.startApplication(driver, "chrome", "https://flp-de-sponsoring-dev.disellco.cloud/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



	}

	/*	

	@BeforeTest
	public void loadconfig() throws IOException
	{
		try
		{
		prop = new Properties();
		System.out.println("super constructer invocked");
		FileInputStream ip= new FileInputStream(System.getProperty("user.dir") + "\\Config\\config.properties");
		prop.load(ip);
		System.out.println("driver: " + driver);
		}

		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void launchapp()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.out.println("Sorry we donot support this browser");
		}

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);    

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}

	 */


	
	@AfterClass
	public void TearDown()
	{
		BrowserFactory.closeBrowser(driver);
		//		driver.quit();
	}
	
	
	


}


