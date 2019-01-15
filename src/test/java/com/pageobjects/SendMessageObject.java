package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.utils.Constants;
import com.utils.Keywords;

public class SendMessageObject {

	// object initialization
	Keywords key = new Keywords();

	// locators=====>
	By compose = By.xpath("//div[text()='Compose']");
	By to = By.xpath("//textarea[@name='to']");
	By sub = By.xpath("//input[@name='subjectbox']");
	By body = By.xpath("//div[@aria-label='Message Body']");
	By send = By.xpath("//div[contains(@aria-label,'Send')]");
	By sentMail = By.xpath("//a[@title='Sent']");
	
	//get subject
	By getSubject = By.xpath("//span[text()='"+Constants.Sub+"']");

	// =============>send message function===>
	public void sendMessage(WebDriver driver) throws InterruptedException {

		// redirect to gmail page
		key.getUrl(driver, Constants.gmailurl);

		// click on compose button
		key.elementToBeClickable(driver, compose);

		// send mail in to field
		// enter in to field
		key.visibilityOfElement(driver, to);
		key.findElementsendtext(driver, to, Constants.To);

		// enter subject
		key.findElementsendtext(driver, sub, Constants.Sub);

		// enter body
		key.findElementsendtext(driver, body, Constants.Body);

		// click on send button
		key.findElementClick(driver, send);
		
		Thread.sleep(3000);
        
		key.findElementClick(driver, sentMail);
		
		Thread.sleep(3000);
		
		
		
		
		
		
		
		
	}

}
