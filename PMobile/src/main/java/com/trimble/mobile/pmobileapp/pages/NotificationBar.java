package com.trimble.mobile.pmobileapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NotificationBar extends AppiumCommandsPage{
	@FindBy(id="main_titletext_textview")
	private WebElement mainTitleTextView;

	public NotificationBar(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getUserName() {
		
		String userName = null;
		while(VerifyElementPresent(mainTitleTextView)) {
			String sample = mainTitleTextView.getText();
			if(sample.contains("Active")) {
				userName = sample;
				break;
			}
		}
		return userName;
	}

}
