package com.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageobjects.LoginObject;
import com.utils.GetBrowser;
import com.utils.Keywords;
import com.utils.ScreenShot;


public class LoginTestCase extends GetBrowser{

	//initialization
	WebDriver driver;
	LoginObject login = new LoginObject();
	Keywords key = new Keywords();
	ScreenShot ss = new ScreenShot();

	//initializing logger
	
	public static Logger log =LogManager.getLogger(GetBrowser.class.getName());

	@BeforeClass
	public void openBrowser() // open the browser
	{
		// Driver name is unique in every test case
		driver = getDriver(browserName);
		log.info("driver is initialized");
	}

	@Test
	public void loginToGmail()  {

		//get url 
		login.getUrl(driver);
		log.info("url open");
		//login to gmail
		try {
		login.performLogin(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		log.info("login operation successfully performed");
		//Assertions 
		Assert.assertEquals(true, key.isDisplayedWait(driver, login.Account));
		//ss.captureScreenshot(driver);
		log.info("Assert successsfully");
	}


	@AfterClass
	// close the browser
	public void closeBrowser() {
		driver.close();
	}

}
