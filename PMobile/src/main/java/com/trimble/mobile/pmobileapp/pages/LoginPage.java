package com.trimble.mobile.pmobileapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends AppiumCommandsPage {
	
	@FindBy(id = "loadingProgressBar")
	private WebElement progressBar;
	
	// Tool bar Automation Id
	@FindBy(id = "pnetpage_titletext_textview")
	private WebElement titleText;
	
	@FindBy(id = "pnetpage_backbutton_imagebutton")
	private WebElement backButton;
	
	@FindBy(id = "loginfields_loginid_edittext")
	private WebElement userName;

	@FindBy(id = "loginfields_password_edittext")
	private WebElement password;
	
	@FindBy(id = "pnetactionbarbutton_button_imageview")
	private WebElement submitBtn;
	
	@FindBy(id = "loginfields_responsemessage_textview")
	private WebElement responseMessageView;
	
	@FindBy(id="alert_message")
	private WebElement alertMessage;
	
	@FindBy(xpath="//*[@text='OK']")
	private WebElement Okbtn;
	
	@FindBy(id="loginform_error_textview")
	private WebElement loginErrorMessage;
	
	public LoginPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void waitTillProgressBarloaded() {
		waitForElementVisibility(progressBar);
	}
	
	public void waitTillLoginPageLoaded() {
		waitForElementVisibility(userName);
	}
	
	public void login(String usrName, String pwd) {
		enterText(userName, usrName);
		enterText(password, pwd);
		clickElement(submitBtn);
	}
	
	public void waitTillDriverLogSheetLoaded() {	
		try {
			while ((titleText.getText()).equalsIgnoreCase("Login")) {
					waitForElementInVisibility(responseMessageView);	
				}	
		}catch (Exception e){
		}
	}
	
	public void waitTillAlertMessageShown() {
		try {
			while ((titleText.getText()).equalsIgnoreCase("Login")) {
				waitForElementVisibility(alertMessage);	
			}	
		}catch (Exception e){
		}
		
	}

	public String getAlertMessage() {
		return getElementPropertyToString("text",alertMessage);
	}
	
	public void closeAlertPopup() {
		clickElement(Okbtn);
	}
	
	public void clickBackButton() {
		clickElement(backButton);
	}
	
	public String getLoginErrorMessage() {
		waitForElementVisibility(loginErrorMessage);
		return getElementPropertyToString("text",loginErrorMessage);
	}
}
