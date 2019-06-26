package com.trimble.web.core.managers;

import org.openqa.selenium.WebDriver;

import com.trimble.web.pfmwebapp.pages.WebLoginPage;

public class WebPageObjectManager {
	
	/**
	 * 
	 * This class serves to avoid creation of multiple objects for pages in the Step
	 * definition files.
	 */

	private WebDriver webdriver;

	/**
	 * All the Page Objects have to be declared here
	 */

	private WebLoginPage WebLoginPage;

	/**
	 * @param webdriver
	 */
	public WebPageObjectManager(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
	
	public WebLoginPage getWebLoginPage() {
		return (WebLoginPage == null) ? WebLoginPage = new WebLoginPage(webdriver) :  WebLoginPage;
	}
	

}
