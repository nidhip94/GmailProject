package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageobjects.LoginObject;
import com.pageobjects.SendMessageObject;
import com.utils.GetBrowser;
import com.utils.Keywords;
import com.utils.ScreenShot;

public class TC_03_SendMessage extends GetBrowser {

	
	
	// initialization
		WebDriver driver;
		LoginObject login = new LoginObject();
		Keywords key = new Keywords();
		ScreenShot ss = new ScreenShot();
		SendMessageObject sm = new SendMessageObject();

	
		// initializing logger

		public static Logger log = LogManager.getLogger(GetBrowser.class.getName());

		// before this class is invoked , it opens a browser and driver is initialized
		@BeforeClass
		public void openBrowser() // open the browser
		{
			// Driver name is unique in every test case
			driver = getDriver(browserName);
			log.info("driver is initialized");
		}
	
	
		@Test
		public void loginToGmail() {

			// get url
			login.getUrl(driver);
			log.info("url open");
			// login to gmail
			try {
				login.performLogin(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}

			log.info("login operation successfully performed");
			// Assertions
			Assert.assertEquals(true, key.isDisplayedWait(driver, login.Account));
			log.info("Login successsfully");
			
			//Function to send Message
			try {
				sm.sendMessage(driver);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}

		@AfterClass
		// close the browser
		public void closeBrowser() {
			driver.close();
		}
	
	
	
	
	
	
	
	
	
}
