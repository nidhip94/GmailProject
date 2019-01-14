package com.utils;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class Keywords {

	public WebDriver driver;
	public WebDriverWait wait;

	// ====open url =====>
	public void getUrl(WebDriver driver, String URL) {
		driver.get(URL);
	}

	// ===click
	public void click(WebDriver driver, By locator) {
		driver.findElement(locator).click();
	}

	// sendkeys
	public void sendtext(WebDriver driver, By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	//presenceofelement
	public void presenceOfElement(WebDriver driver, By locator) {
		try {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//isdisplayed
	public boolean isDisplayed(WebDriver driver, By locator) {
		
		if (driver.findElement(locator).isDisplayed()){
			return true;
		}else {
			return false;
		}
		
	}
	
	//isdisplayedwithwait
		public boolean isDisplayedWait(WebDriver driver, By locator) {
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if (driver.findElement(locator).isDisplayed()){
				return true;
			}else {
				return false;
			}
			
		}
	
	
	
	
	
	
	
	
	
	public void findPresenceElement(WebDriver driver, By locator, String text) {
		try {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).sendKeys(text);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//handle stale element reference exception in findelement and send text function
	public void findElementsendtextStale(WebDriver driver, By locator, String text) {
		try {
			wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			driver.findElement(locator).sendKeys(text);
		} catch (StaleElementReferenceException e) {
			wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			driver.findElement(locator).sendKeys(text);

		}
	}
	
	
	
	
	//find element by visibility then send text
	public void findElementsendtext(WebDriver driver, By locator, String text) {
		try {
			wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			driver.findElement(locator).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ==Find element and click=====>
	public void findElementClick(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		driver.findElement(locator).click();
	}

	// ==Find element and click=====>
	public void findElementScrollAndClick(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		scrollIntoView(driver, locator);
		driver.findElement(locator).click();
	}

	public void clickByjs(WebDriver driver, By locator) {
		WebElement ele = driver.findElement(locator);
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", ele);
	}

	// ================Switch to Frames via String/Integer/default======>
	public void SwitchToframe(WebDriver driver, String frame) {
		driver.switchTo().frame(frame);
	}

	public void SwitchToframe(WebDriver driver, int frame) {
		driver.switchTo().frame(frame);
	}

	public void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	// ================================================================>

	// ===================Scroll
	// functions=============================================>
	public void scrollDownScreen(WebDriver driver) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)", "");
	}

	public void scrollUpScreen(WebDriver driver) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,-500)", "");
	}

	public void ScrollToElementLocation(WebDriver driver, By locator) {
		String location = driver.findElement(locator).getLocation().toString();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo" + location + "", "");
	}

	public void scrollIntoView(WebDriver driver, By locator) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));

	}

	// ==================================================================================================

	// ===Return attribute value==>
	public String getAttributeValue(WebDriver driver, By locator, String attributeKey) {
		return driver.findElement(locator).getAttribute(attributeKey);
	}

	// ===Wait for elements until displayed==>
	public void waitElementUntilDisplayedSmall(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// ==Find elements and return List<WebElement>==>
	public java.util.List<WebElement> findAllElements(WebDriver driver, By locator) {
		java.util.List<WebElement> listOfElement = driver.findElements(locator);
		return listOfElement;
	}

	// click on alert
	public void clickAlertOK(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// dismiss alert
	public void dismissAlert(WebDriver driver) {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// open in new tab
	public void openInNewTab(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator);
		action.moveToElement(we).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
	}

	// open in new window
	public void openInNewWindow(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator);
		action.moveToElement(we).keyDown(Keys.SHIFT).keyDown(Keys.ALT).click().keyUp(Keys.SHIFT).keyUp(Keys.ALT).build()
				.perform();
	}

	public void moveToElementByAction(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator);
		action.moveToElement(we).build().perform();
	}

	public String isAlertPresent() {

		String presentFlag = "";

		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			presentFlag = "TRUE";
			// if present consume the alert
			alert.accept();
			// ( Now, click on ok or cancel button )

		} catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();
		}
		System.out.println("ALERT");
		return presentFlag;
	}

	// assertion
	public void printAssertLog(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(expectedValue, actualValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void waitUntilPageLoad(final WebDriver driver) {
		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	public void uploadFileByRobotAfterClickBrowseButton(WebDriver driver, String filePath)
			throws AWTException, InterruptedException {
		Thread.sleep(3000);
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

}
