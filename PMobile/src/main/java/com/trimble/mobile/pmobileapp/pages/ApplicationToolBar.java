package com.trimble.mobile.pmobileapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApplicationToolBar extends AppiumCommandsPage {

	// Tool bar Automation Id
	@FindBy(id = "pnetpage_titletext_textview")
	private WebElement titleText;
		
	@FindBy(id = "pnetpage_backbutton_imagebutton")
	private WebElement backButton;
	
	public ApplicationToolBar(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void waitTillPageTitleDisplayed(String pageName) {
		waitForElementVisibility(titleText);
		while (getElementPropertyToString("text",titleText).equalsIgnoreCase(pageName)) {
			break;
		}
	}
	
	public void waitForPageTitle() {
		waitForElementVisibility(titleText);
	}
	public String getPageTitle() {
		waitForElementVisibility(titleText);
		return getElementPropertyToString("text",titleText);
	}
	
	public void selectBackButton() {
		clickElement(backButton);
	}
	
	public Boolean isBackButtonDisplayed() {
		return verifyElementPresent(backButton);
	}
	
	/*
	 * To-Do Work 
	 * This method is used to initialize device state to respective screen. 
	 * We have started building up based on the dependency identified in current test scripts
	 * This work is in progress stage and method will get updated based on the requirement while writting new test
	 */
	public void initialize() {
		waitForPageTitle();
		switch (getPageTitle()) {
			case "Home":
				break;
			case "Media Manager - Downloads":
				Back(2);
				break;
			case "Media Manager - Pictures":
				Back(2);
				break;
			case "Settings":
				Back(2);
				break;
		}
	}

}
