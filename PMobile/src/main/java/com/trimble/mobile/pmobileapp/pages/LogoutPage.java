package com.trimble.mobile.pmobileapp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogoutPage extends AppiumCommandsPage {

	@FindBy(id="logout_title_textview")
	private WebElement logoutPageTitle;
	
	@FindBy(id="logout_leavetruck_textview")
	private WebElement logoutMessageView;
	
	@FindAll(@FindBy(id="pnetactionbarbutton_name_textview"))
	private List<WebElement> moduleMenu;
	
	public LogoutPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String userDetails() {
		return getElementPropertyToString("text",logoutPageTitle);
	}
	
	public String logoutMessage() {
		return getElementPropertyToString("text",logoutMessageView);
	}
	
	public void selectYesButton() {
		clickElement(moduleMenu.get(0));
	}
	
	public void selectNoButton() {
		clickElement(moduleMenu.get(1));
	}
}
