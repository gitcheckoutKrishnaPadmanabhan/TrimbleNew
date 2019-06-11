package com.trimble.mobile.pmobileapp.stepdefinitions;

import com.trimble.mobile.core.testcontext.TestContext;
import com.trimble.mobile.pmobileapp.pages.*;

import cucumber.api.java.en.When;


public class DriverPageTest {
	TestContext testContext;
	HomePage homePage;
	ApplicationToolBar toolBar;
	DriverPage driverPage;
	LogoutPage logoutPage;
	
	public DriverPageTest(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		toolBar = testContext.getPageObjectManager().getToolBar();
		driverPage = testContext.getPageObjectManager().getDriverPage();
		logoutPage = testContext.getPageObjectManager().getLogoutPage();
	}
	
	@When("Driver with driverid {string} tries to log out of the application")
	public void driver_with_driverid_tries_to_log_out_of_the_application(String driverid) {
		homePage.selectModule("Driver");
		toolBar.waitTillPageTitleDisplayed("Driver");
		driverPage.selectModule("Logout");
		toolBar.waitTillPageTitleDisplayed("Logout");
		logoutPage.selectYesButton();
	}
}