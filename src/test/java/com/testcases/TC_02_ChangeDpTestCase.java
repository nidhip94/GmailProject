package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageobjects.ChangeDpObject;
import com.pageobjects.LoginObject;
import com.utils.GetBrowser;
import com.utils.Keywords;
import com.utils.ScreenShot;

public class TC_02_ChangeDpTestCase extends GetBrowser {

	// initialization
	WebDriver driver;
	LoginObject login = new LoginObject();
	ChangeDpObject cd = new ChangeDpObject();
	Keywords key = new Keywords();
	ScreenShot ss = new ScreenShot();

	// initializing logger

	public static Logger log = LogManager.getLogger(GetBrowser.class.getName());

	
	//before this class is invoked , it opens a browser and driver is initialized
	@BeforeClass
	public void openBrowser() // open the browser
	{
		// Driver name is unique in every test case
		driver = getDriver(browserName);
		log.info("driver is initialized for change dp class");
	}

	
	@Test
	public void changeDpGmail() {

		// get url
		log.info("redirect to gmail login page");
		login.getUrl(driver);
		log.info("url open");
		
		
		// login to gmail
		log.info("call login operation");
		try {
			login.performLogin(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
        log.info("login operation successfully performed");
        
        
        // Assertions
        log.info("Assert that user is successfully login");
		Assert.assertEquals(true, key.isDisplayedWait(driver, login.Account));
		log.info("Assert successsfully");
		
		//call change dp function from changedpobject class
		log.info("calling change dp function");
		try {
		cd.changeDp(driver);
		}catch(Exception e) {
			System.out.println("exception in changed dp" +  e);
		}
		
		
		//assert image is  uploaded successfully or not
		Assert.assertEquals(true, key.isDisplayedWait(driver, login.Account));
		log.info("changed successsfully");
		
	}

	
	
	// close the browser after the class is executed
	@AfterClass
	public void closeBrowser() {
		driver.close();
		log.info("driver is closed for change dp class");
	}
	


	
	
	
	
}
