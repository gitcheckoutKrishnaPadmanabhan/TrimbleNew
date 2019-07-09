package com.trimble.web.core.seleniumdriverinstance;

import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriverInstance{
	
	public Properties prop = new Properties();
	static InputStream input = null;
	
	private static SeleniumDriverInstance instance = null;
	private WebDriver webdriver;
 	
	 		/**
	 		 * Private constructor for singleton
	 		 */
	 		private SeleniumDriverInstance() {
	 		}

	 		/**
	 		 * @return
	 		 */
	 		public static SeleniumDriverInstance getInstance() {
	 			return (instance == null) ? instance =  new SeleniumDriverInstance():instance;
	 		}

	 		/**
	 		 * @return the webdriver
	 		 * @throws Exception
	 		 */
	 		public WebDriver getSeleniumDriver() throws Exception {

	 			if (webdriver == null) {
	 				webdriver = getSeleniumDriverInstance();
	 			}
	 			return webdriver;
	 		}

	 		/**
	 		 *  Initializing the chrome webdriver
	 		 *  @return the webdriver
	 		 */ 	 	
	
	public WebDriver getSeleniumDriverInstance() {
		
		
		 //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
 
        //Create driver object for Chrome
		webdriver = new ChromeDriver();
	
		return webdriver;
	}
	
}