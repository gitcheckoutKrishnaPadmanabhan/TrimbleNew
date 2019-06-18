package com.trimble.mobile.pmobileapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SystemPage extends AppiumCommandsPage{
	
	@FindBy(id = "pnetpage_homebutton_imagebutton")
	private WebElement peoplenetLogo;
		
	@FindBy(id = "pnetpage_titletext_textview")
	private WebElement systemText;
	
	@FindBy(id = "pnetpage_backbutton_imagebutton")
	private WebElement backArrow;
	
	@FindBy(xpath="//*[@text='Settings']")
	private WebElement settingsButton;
	
	@FindBy(xpath="//*[@text='OBC Diagnostic']")
	private WebElement obcDiagnosticButton;
	
	@FindBy(xpath="//*[@text='Information']")
	private WebElement informationButton;
	
	@FindBy(xpath="//*[@text='OTAP']")
	private WebElement otapButton;
	
	@FindBy(xpath="//*[@text='Version']")
	private WebElement versionButton;
	
	@FindBy(xpath="//*[@text='License Plate']")
	private WebElement licensePlateButton;
	
	@FindBy(xpath="//*[@text='Wi-Fi Setup']")
	private WebElement wifiSetupButton;
	
	@FindBy(xpath="//*[@text='Camera']")
	private WebElement cameraButton;
	
	@FindBy(xpath="//*[@text='Fleet Home Setup']")
	private WebElement fleetHomeSetupButton;
	
	
	public SystemPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickSettings() {
		clickElement(settingsButton);
	}

}
