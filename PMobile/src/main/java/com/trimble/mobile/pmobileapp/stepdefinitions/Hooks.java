package com.trimble.mobile.pmobileapp.stepdefinitions;

import org.openqa.selenium.WebDriverException;

import com.trimble.mobile.core.testcontext.TestContext;
import com.trimble.mobile.pmobileapp.pages.ApplicationToolBar;

import org.openqa.selenium.TakesScreenshot;

import com.trimble.mobile.core.reporting.ExtentReportUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends ExtentReportUtil  {
	TestContext testContext;
	ApplicationToolBar toolBar;
	
	public Hooks(TestContext context) {
		testContext = context;
		toolBar = testContext.getPageObjectManager().getToolBar();
	}
	/**
	 * @param scenario
	 * @throws WebDriverException
	 * @throws Exception
	 * 
	 * @After runs after every scenario in the feature file.
	 * 
	 */
	@After
	public void tearDown(Scenario scenario) throws WebDriverException, Exception {
		
		if(scenario.isFailed()) {
			scenario.embed(((TakesScreenshot)getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.BYTES), "image/png");
			toolBar.reLaunchApp();
		}
	}

}
