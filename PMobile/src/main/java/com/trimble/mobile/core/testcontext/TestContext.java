package com.trimble.mobile.core.testcontext;

import com.trimble.mobile.core.appiumdriverinstance.AppiumDriverInstance;
import com.trimble.mobile.core.managers.PageObjectManager;

public class TestContext {

	private PageObjectManager pageObjectManager;

	public TestContext() throws Exception {
		pageObjectManager = new PageObjectManager(
				AppiumDriverInstance.getInstance().getAppiumDriver());
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
