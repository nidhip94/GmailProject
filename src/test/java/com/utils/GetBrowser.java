package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetBrowser {

	 public static WebDriver driver;
	 public String browserName = Constants.browser;
	  /*
	   * This function will Initiate the type of browser defined in constants file and will create the
	   * browser instance accordingly
	   */
	  public WebDriver getDriver(String browserName) {
	    if (browserName.equalsIgnoreCase("chrome")) {
	      driver = initChromeDriver();
	    } else if (browserName.equalsIgnoreCase("Edge")) {
	      driver = initEdgeDriver();
	    } else if (browserName.equalsIgnoreCase("firefox")) {
	      driver = initFirefoxDriver();
	    }

	    return driver;
	  }


	  /*
	   * This function will create the Chrome browser instance and return the driver
	   */
	  public WebDriver initChromeDriver() {
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chrome\\chromedriver.exe");
	    
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("disable-extensions");
	    options.addArguments("--start-maximized");
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();

	    return driver;
	  }

	  /*
	   * This function will create the Edge browser instance and return the driver. Please Note: This
	   * will oncly work with windows10 Environment.
	   */
	  public WebDriver initEdgeDriver() {
		return driver;
         //driver of edge
	  }

	  /*
	   * This function will create the firefox browser instance and return the driver.
	   */

	  public WebDriver initFirefoxDriver() {
	    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\chrome\\chromedriver.exe");
	    driver = new FirefoxDriver();
	    return driver;
	  }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
