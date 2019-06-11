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
		while (getElementPropertyToString("text",titleText).equalsIgnoreCase(pageName)) {
			break;
		}
	}
	
	public String getPageTitle() {
		return getElementPropertyToString("text",titleText);
	}

}
