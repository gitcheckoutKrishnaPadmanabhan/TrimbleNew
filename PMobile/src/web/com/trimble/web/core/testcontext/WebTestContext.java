package com.trimble.web.core.testcontext;

import com.trimble.web.core.managers.WebPageObjectManager;
import com.trimble.web.core.seleniumdriverinstance.SeleniumDriverInstance;

public class WebTestContext {
	
	private WebPageObjectManager webPageObjectManager;
	
	public WebTestContext() throws Exception {
		webPageObjectManager = new WebPageObjectManager(SeleniumDriverInstance.getInstance().getSeleniumDriver());
		
	}
	
	public WebPageObjectManager getWebPageObjectManager() {
		return webPageObjectManager;
	}
}
