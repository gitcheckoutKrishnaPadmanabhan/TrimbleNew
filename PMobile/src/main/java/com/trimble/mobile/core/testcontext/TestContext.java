package com.trimble.mobile.core.testcontext;

import com.trimble.mobile.core.appiumdriverinstance.AppiumDriverInstance;
import com.trimble.mobile.core.managers.PageObjectManager;
import com.trimble.mobile.core.scenariocontext.ScenarioContext;

public class TestContext {

	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;

	public TestContext() throws Exception {
		pageObjectManager = new PageObjectManager(
				AppiumDriverInstance.getInstance().getAppiumDriver());
		scenarioContext = new ScenarioContext();
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
	
	
}
