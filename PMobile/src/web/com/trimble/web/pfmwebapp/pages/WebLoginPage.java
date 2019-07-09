package com.trimble.web.pfmwebapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.web.core.seleniumcommandbase.SeleniumCommandsPage;

public class WebLoginPage extends SeleniumCommandsPage{

	@FindBy(id="IDToken1")
	private WebElement tfCompanyID;
	
	@FindBy(id="IDToken2")
	private WebElement tfPassword;
	
	@FindBy(id="loginButton")
	private WebElement btnSignIn;
	
	@FindBy(xpath="//span[text()='MY ACCOUNT']")
	private WebElement tabMyAccount;
	
	public WebLoginPage(WebDriver webdriver) {
		this.webdriver = webdriver;
        //This initElements method will create all WebElements
        PageFactory.initElements(webdriver, this);
	}
	
	public void enterCompanyID(String companyID) throws Exception {
		waitForElementVisibility(tfCompanyID);
		tfCompanyID.sendKeys(companyID);
	}
	
	public void enterPassword(String pwd) {
		tfPassword.sendKeys(pwd);
	}
	
	public void clickSignInButton() throws Exception {
		clickElement(btnSignIn);
	}
	
	public boolean verfiyMyAccountTab() throws Exception {
		waitForElementVisibility(tabMyAccount);
		return VerifyElementPresent(tabMyAccount);
	}
	
	
	public boolean verfiySignInButton() throws Exception {
		return VerifyElementPresent(btnSignIn);
	}
	
}
