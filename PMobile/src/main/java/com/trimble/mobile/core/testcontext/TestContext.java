package com.trimble.mobile.core.testcontext;

import com.trimble.mobile.core.appiumdriverinstance.AppiumDriverInstance;
import com.trimble.mobile.core.managers.PageObjectManager;
import com.trimble.mobile.core.scenariocontext.ScenarioContext;
import com.trimble.mobile.core.filereader.jsonFileReader;

public class TestContext {

	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;
	private jsonFileReader jsonFileReader;

	public TestContext() throws Exception {
		pageObjectManager = new PageObjectManager(
				AppiumDriverInstance.getInstance().getAppiumDriver());
		scenarioContext = new ScenarioContext();
		jsonFileReader = new jsonFileReader();
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
	
	public jsonFileReader getJsonFileReader(){return jsonFileReader;}
}
