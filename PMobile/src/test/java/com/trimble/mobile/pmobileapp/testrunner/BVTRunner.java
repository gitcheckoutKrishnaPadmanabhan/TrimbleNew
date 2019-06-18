package com.trimble.mobile.pmobileapp.testrunner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = {"src/test/resources/PMobileAppFeatures/Settings.feature"},  
		glue = {"com.trimble.mobile.pmobileapp.stepdefinitions"},
		//tags = {"@BVT"},
		monochrome = true,
		dryRun = false
		
		)

public class BVTRunner {  
	
	private TestNGCucumberRunner testNGCucumberRunner;  

	@BeforeClass(alwaysRun = true)  
	public void setUpClass() throws Exception {  
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
	}  

	@Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {  
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());  
	}  

	@DataProvider  
	public Object[][] scenarios() {  
		return testNGCucumberRunner.provideScenarios();  
	}  

	@AfterClass(alwaysRun = true)  
	public void tearDownClass() throws Exception {  
		testNGCucumberRunner.finish();  
	}  
}

