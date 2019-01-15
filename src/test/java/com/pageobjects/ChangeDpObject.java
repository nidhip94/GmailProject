package com.pageobjects;

import com.utils.Constants;
import com.utils.Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ChangeDpObject {

	//creating object of keyword class where all commom functions are defined
	Keywords key = new Keywords();

	
	//===>locators of change dp 
	public By Account = By.xpath("//a[contains(@aria-label,'Google Account')]");
	By changeicon = By.xpath("//a[contains(@aria-label,'Change profile picture')]");
	By switchIntoFrame = By.xpath("//iframe[@allow='camera']");
	By selectphoto = By.xpath("//div[text()='Set as profile photo']");
	By inputFile = By.xpath("//input[@type='file']");
	By afterupload = By.xpath("//div[@id='picker:ap:3']");
	
	
	
	
	//Functions
	
	
	//========== changedp function ==========>
	
	public void changeDp(WebDriver driver) throws InterruptedException {

		// ====>click on google account icon
		key.findElementClick(driver,Account);

		//=====> click on change icon
		key.findElementClick(driver, changeicon);
		
		//===>change dp  logic
		//switch driver to frame 
		key.switchFrameWebElement(driver, switchIntoFrame);
		
		//wait for an element to be visible
		key.visibilityOfElement(driver, selectphoto);
		
		//code to upload a picture
		key.sendtext(driver, inputFile, Constants.imagePath);
		
		//click ok
		key.presenceOfElement(driver, afterupload);
		key.findElementClick(driver,afterupload);
		
		//swich driver to default pane
		key.switchToDefault(driver);
		
		Thread.sleep(2000);
	}
	
	
	
	
	
	
}
