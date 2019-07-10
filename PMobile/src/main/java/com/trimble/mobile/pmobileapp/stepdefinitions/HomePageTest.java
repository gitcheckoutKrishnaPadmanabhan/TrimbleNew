package com.trimble.mobile.pmobileapp.stepdefinitions;

import com.trimble.mobile.core.testcontext.TestContext;
import com.trimble.mobile.pmobileapp.pages.*;

import cucumber.api.java.en.Given;

public class HomePageTest {
	
	TestContext testContext;
	LoginPage loginPage;
	HomePage homePage;
	ApplicationToolBar toolBar;

	public HomePageTest(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getSignInPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		toolBar = testContext.getPageObjectManager().getToolBar();
	}
	
	@Given("Driver is on home page after successfull login")
	public void driver_is_on_home_page_after_successfull_login() {
	   loginPage.waitTillDriverLogSheetLoaded();
	   homePage.closeLoginAlert();
	   homePage.waitTillHomePageLoaded();
	}
	
	@Given("Driver navigate to home Page from Media Manager Page")
	public void driver_navigate_to_home_Page_from_Media_Manager_Page() {
		toolBar.Back(2);
		toolBar.waitTillPageTitleDisplayed("Home");
	}
}
