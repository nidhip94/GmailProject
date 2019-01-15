package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import com.utils.Constants;
import com.utils.Keywords;

public class LoginObject {

	// object initialization
	Keywords key = new Keywords();

	// locators of login page
	By username = By.id("identifierId");
	By usernameNext = By.id("identifierNext");
	By password = By.xpath("//input[@type='password']");
	By passwordNext = By.id("passwordNext");
	
	//assertion -> check whether google account button is displayed or not
	public By Account = By.xpath("//a[contains(@aria-label,'Google Account')]");

	     // Functions==>

	     // =======>login to application======>
	public void getUrl(WebDriver driver) {
		key.getUrl(driver, Constants.url);
	}

	     // ========>login function=========>
	public void performLogin(WebDriver driver) throws InterruptedException {

		// ====>enter username
		key.findElementsendtext(driver, username, Constants.username);

		//=====> click on next
		key.findElementClick(driver, usernameNext);
		
		
		//===>enter password
		key.findElementsendtextStale(driver, password, Constants.password);
		
		//=====>click on password next
		key.findElementClick(driver, passwordNext);
		
	}

}
