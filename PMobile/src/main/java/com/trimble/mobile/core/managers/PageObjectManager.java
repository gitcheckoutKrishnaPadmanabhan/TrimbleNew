package com.trimble.mobile.core.managers;

import org.openqa.selenium.WebElement;

import com.trimble.mobile.pmobileapp.pages.*;

import io.appium.java_client.AppiumDriver;

public class PageObjectManager {
	/**
	 * 
	 * This class serves to avoid creation of multiple objects for pages in the
	 * Step definition files.
	 */

	private AppiumDriver<WebElement> driver;

	/**
	 * @param driver
	 */
	public PageObjectManager(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}

}
