package com.trimble.mobile.pmobileapp.stepdefinitions;

import org.testng.Assert;

import com.trimble.mobile.core.testcontext.TestContext;
import com.trimble.mobile.pmobileapp.pages.ApplicationToolBar;
import com.trimble.mobile.pmobileapp.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginTest {
	TestContext testContext;
	LoginPage loginPage;
	ApplicationToolBar toolBar;

	public LoginTest(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getSignInPage();
		toolBar = testContext.getPageObjectManager().getToolBar();
	}
	
	@Given("Driver with driverid {string} and password {string} sign in to the application")
	public void driver_with_driverid_and_password_sign_in_to_the_application(String driverid, String password) {
		loginPage.waitTillLoginPageLoaded();
		loginPage.login(driverid, password);
	}
	
	@Given("Driver is in login page")
	public void driver_is_in_login_page() {
		loginPage.waitTillLoginPageLoaded();
	}

	@Then("Driver with driverid {string} should receive warning message")
	public void driver_with_driverid_should_receive_warning_message(String driverid) {
		loginPage.waitTillAlertMessageShown();
		Assert.assertEquals(loginPage.getAlertMessage(),"INVALID DRIVER PASSWORD: ".concat(driverid) );
		loginPage.closeAlertPopup();
		Assert.assertEquals(loginPage.getLoginErrorMessage(),"INVALID DRIVER PASSWORD");
	}
	
	@Then("Driver with driverid {string} should receive warning message for invalid driver id")
	public void driver_with_driverid_should_receive_warning_message_for_invalid_driver_id(String driverid) {
		loginPage.waitTillAlertMessageShown();
		Assert.assertEquals(loginPage.getAlertMessage(),"INVALID DRIVER ID: ".concat(driverid) );
		loginPage.closeAlertPopup();
		Assert.assertEquals(loginPage.getLoginErrorMessage(),"INVALID DRIVER ID");
	}
	
	@Then("Driver with driverid {string} should logout successfully")
	public void driver_with_driverid_should_logout_successfully(String driverid) {
		loginPage.waitTillLoginPageLoaded();
		Assert.assertTrue(toolBar.getPageTitle().contains("Login"));
	}
	
}

