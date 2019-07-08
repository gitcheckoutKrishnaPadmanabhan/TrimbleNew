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
	 * All the Page Objects have to be declared here
	 */
	private LoginPage loginPage;
	private HomePage homePage;
	private ApplicationToolBar applicationToolBar;
	private DriverPage driverPage;
	private LogoutPage logoutPage;
	private SystemPage systemPage;
	private MediaManagerPage mediaManagerPage;
	
	/**
	 * @param driver
	 */
	public PageObjectManager(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}

	public LoginPage getSignInPage() {
		return (loginPage == null)
				? loginPage = new LoginPage(driver)
				: loginPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public ApplicationToolBar getToolBar() {
		return (applicationToolBar == null) ? applicationToolBar = new ApplicationToolBar(driver) : applicationToolBar;
	}

	public DriverPage getDriverPage() {
		return (driverPage == null) ? driverPage = new DriverPage(driver) : driverPage;
	}

	public LogoutPage getLogoutPage() {
		return (logoutPage == null) ? logoutPage = new LogoutPage(driver) : logoutPage;
	}
	
	public MediaManagerPage getMediaManagerPage() {
		return (mediaManagerPage == null) ? mediaManagerPage = new MediaManagerPage(driver) : mediaManagerPage;
	}

	public SystemPage getSystemPage() {
		return (systemPage == null) ? systemPage = new SystemPage(driver) : systemPage;
	}

}
