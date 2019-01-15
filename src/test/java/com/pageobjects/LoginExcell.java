package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.Constants;
import com.utils.ExcelUtils;
import com.utils.Keywords;

public class LoginExcell {

	
	// object initialization
		Keywords key = new Keywords();
		ExcelUtils excel = new ExcelUtils();
		Constants c = new Constants();
		// locators of login page
		By username = By.id("identifierId");
		By usernameNext = By.id("identifierNext");
		By password = By.xpath("//input[@type='password']");
		By passwordNext = By.id("passwordNext");
		
		//assertion -> check whether google account button is displayed or not
		public By Account = By.xpath("//a[contains(@aria-label,'Google Account')]");

		// Functions

		     // login to application
		public void getUrl(WebDriver driver) {
			key.getUrl(driver, Constants.url);
		}

		     // login function
		public void performLogin(WebDriver driver) throws Exception {

			 excel.setExcelFile(Constants.Path_TestData, Constants.sheetname);
			
			
			
			 driver.findElement(username).sendKeys(excel.getCellData(Constants.sheetname, 1, 0));
			 Thread.sleep(2000);
			 
			 driver.findElement(usernameNext).click();
			 
			 Thread.sleep(2000);
			 
			 
			 driver.findElement(password).sendKeys(excel.getCellData(Constants.sheetname, 1, 1));
			 
			 Thread.sleep(2000);
			
			//click on password next
			key.findElementClick(driver, passwordNext);
			 Thread.sleep(2000);
			
		}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
