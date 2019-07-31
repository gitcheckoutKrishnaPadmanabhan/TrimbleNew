package com.trimble.mobile.pmobileapp.stepdefinitions;

import com.trimble.mobile.core.testData.TestData;
import cucumber.api.java.en.When;
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
	TestData testData;

	public LoginTest(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getSignInPage();
		toolBar = testContext.getPageObjectManager().getToolBar();
		testData = testContext.getJsonFileReader().gettestDataByName();
	}
	

	@Given("Driver login to the application")
	public void driver_login_to_the_application() {
		if(toolBar.getPageTitle().equalsIgnoreCase("Login")) {
			loginPage.waitTillLoginPageLoaded();
			loginPage.login(testData.driverid,testData.driverpwd);
			loginPage.waitTillDriverLogSheetLoaded();
			toolBar.waitTillPageTitleDisplayed("Home");
		}
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


	@Then("Driver should receive warning message for invalid driver id")
	public void driver_should_receive_warning_message_for_invalid_driver_id() {
		loginPage.waitTillAlertMessageShown();
		Assert.assertEquals(loginPage.getAlertMessage(),"INVALID DRIVER ID: ".concat(testData.driverid) );
		loginPage.closeAlertPopup();
		Assert.assertEquals(loginPage.getLoginErrorMessage(),"INVALID DRIVER ID");
	}

	@Then("Driver with driverid {string} should receive warning message for invalid driver id")
	public void driver_with_driverid_should_receive_warning_message_for_invalid_driver_id(String driverid) {
		loginPage.waitTillAlertMessageShown();
		Assert.assertEquals(loginPage.getAlertMessage(),"INVALID DRIVER ID: ".concat(driverid) );
		loginPage.closeAlertPopup();
		Assert.assertEquals(loginPage.getLoginErrorMessage(),"INVALID DRIVER ID");
	}


	@Then("Driver should logout successfully")
	public void driver_with_driverid_should_logout_successfully() {
		loginPage.waitTillLoginPageLoaded();
		Assert.assertTrue(toolBar.getPageTitle().contains("Login"));
	}
	@Given("Driver with sign in with valid credential")
	public void driver_with_sign_in_with_valid_credential() {
		loginPage.waitTillLoginPageLoaded();
		loginPage.login(testData.driverid,testData.driverpwd);
	}

	@When("Driver login with valid driver id and invalid password {string}")
	public void driver_login_with_valid_driver_id_and_invalid_password(String password) {
		loginPage.waitTillLoginPageLoaded();
		loginPage.login(testData.driverid,password);
	}

	@Then("Driver should receive warning message for invalid password")
	public void driver_should_receive_warning_message_for_invalid_password() {
		loginPage.waitTillAlertMessageShown();
		Assert.assertEquals(loginPage.getAlertMessage(),"INVALID DRIVER PASSWORD: ".concat(testData.driverid) );
		loginPage.closeAlertPopup();
		Assert.assertEquals(loginPage.getLoginErrorMessage(),"INVALID DRIVER PASSWORD");
	}

	@When("Driver login with another driver password")
	public void driver_login_with_another_driver_password() {
		loginPage.waitTillLoginPageLoaded();
		loginPage.login(testData.driverid,testData.codriverpwd);
	}

}

