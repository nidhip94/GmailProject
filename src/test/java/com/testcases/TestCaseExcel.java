package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageobjects.LoginExcell;
import com.pageobjects.LoginObject;
import com.utils.Constants;
import com.utils.ExcelUtils;
import com.utils.GetBrowser;
import com.utils.Keywords;
import com.utils.ScreenShot;

public class TestCaseExcel extends GetBrowser {

	
	//initialization
		WebDriver driver;
		LoginExcell ex = new LoginExcell();
		Keywords key = new Keywords();
		ScreenShot ss = new ScreenShot();
		ExcelUtils excel = new ExcelUtils();

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
		public void loginToGmail() throws Exception  {
          
			//get url 
			ex.getUrl(driver);
			log.info("url open");
			//login to gmail
			try {
			ex.performLogin(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			log.info("login operation successfully performed");
			//Assertions 
			Assert.assertEquals(true, key.isDisplayedWait(driver, ex.Account));
			//ss.captureScreenshot(driver);
			log.info("Assert successsfully");
		}


		@AfterClass
		// close the browser
		public void closeBrowser() {
			driver.close();
		}

	
	
	
	
	
	
	
	
	
	
	
	
}
