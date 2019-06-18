package com.trimble.mobile.pmobileapp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AppiumCommandsPage {
	
	// Tool bar Automation Id
	@FindBy(id = "pnetpage_titletext_textview")
	private WebElement titleText;
		
	@FindBy(id = "pnetpage_backbutton_imagebutton")
	private WebElement backButton;
	
	@FindBy(id="alert_message")
	private WebElement alertMessage;
	
	@FindBy(xpath="//*[@text='OK']")
	private WebElement Okbtn;
	
	@FindAll(@FindBy(id="navigatoritem_label_textview"))
	private List<WebElement> moduleMenu;
	
	@FindBy(id = "pnetpage_homebutton_imagebutton")
	private WebElement peoplenetLogo;
	
	@FindBy(id = "pnetpage_titletext_textview")
	private WebElement homeText;
	
	@FindBy(xpath="//*[@text='Messaging']")
	private WebElement messagingButton;
	
	@FindBy(xpath="//*[@text='AOBRD eDriver Logs']")
	private WebElement AOBRDButton;
	
	@FindBy(xpath="//*[@text='Driver']")
	private WebElement driverButton;
	
	@FindBy(xpath="//*[@text='System']")
	private WebElement systemButton;
	
	@FindBy(xpath="//*[@text='Workflow']")
	private WebElement workflowButton;
	
	@FindBy(xpath="//*[@text='Navigation']")
	private WebElement navigationButton;
	
	@FindBy(xpath="//*[@text='Panic Alarm']")
	private WebElement panicAlarmButton;
	
	@FindBy(xpath="//*[@text='O.E.R.']")
	private WebElement oerButton;
	
	public HomePage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void waitTillHomePageLoaded() {
		while ((titleText.getText()).equalsIgnoreCase("Home")) {
			break;
		}
	}
	
	public void closeLoginAlert() {
		clickElement(Okbtn);
	}
	
	public int getModuleIndex(String module) {
		int i = 0;
		for(@SuppressWarnings("unused") WebElement el:moduleMenu) {
			if(!module.equals(((WebElement) moduleMenu.get(i)).getText())){
				i++;
			}
		}
		return i;
	}
	
	public void selectModule(String module) {
		int index = getModuleIndex(module);
		clickElement(moduleMenu.get(index));
	}
	
	public void clickSubSections(String menu) {

		switch (menu) {

		case "System":
			waitForElementVisibility(systemButton);
			clickElement(systemButton);
			break;

		}
	}	

}
