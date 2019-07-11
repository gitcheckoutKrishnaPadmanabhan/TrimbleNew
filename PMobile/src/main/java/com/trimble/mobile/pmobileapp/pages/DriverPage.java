package com.trimble.mobile.pmobileapp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;
import com.trimble.mobile.core.enums.Fields;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DriverPage extends AppiumCommandsPage {

	// Tool bar Automation Id
	@FindBy(id = "pnetpage_titletext_textview")
	private WebElement titleText;
		
	@FindBy(id = "pnetpage_backbutton_imagebutton")
	private WebElement backButton;
	
	@FindAll(@FindBy(id="navigatoritem_label_textview"))
	private List<WebElement> moduleMenu;
	
	@FindBy(xpath="//*[@text='Login']")
    private WebElement loginMenu;
	
	@FindBy(xpath="//*[@text='Logout']")
    private WebElement logoutMenu;
	
	@FindBy(xpath="//*[@text='Change User']")
    private WebElement changeUserMenu;
	
	@FindBy(xpath="//*[@text='Driver Training']")
    private WebElement driverTrainingMenu;
	
	@FindBy(xpath="//*[@text='Change Driver']")
    private WebElement changeDriverMenu;
	
	@FindBy(xpath="//*[@text='Device Training']")
    private WebElement 	deviceTrainingMenu;
	
	@FindBy(xpath="//*[@text='Internet']")
    private WebElement internetMenu;
	
	@FindBy(xpath="//*[@text='Media Manager']")
    private WebElement mediaManagerMenu;
	
	@FindBy(xpath="//*[@text='Android Access']")
    private WebElement androidAccessMenu;
	
	@FindBy(xpath="//*[@text='MyMedia']")
    private WebElement myMediaMenu;
	
	public DriverPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void waitTillDriverPageLoaded() {
		while ((titleText.getText()).equalsIgnoreCase("Driver")) {
			break;
		}
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
		while(VerifyElementEnabled(moduleMenu.get(index)) == false){
			waitForElementToBeClickable(moduleMenu.get(index));
		}
		clickElement(moduleMenu.get(index));
	}
	
	public void clickSubSection(Fields menu) {
		switch(menu) {
			case Login:
				waitForElementToBeClickable(loginMenu);
    			clickElement(loginMenu);
				break;
			case Logout:
				waitForElementToBeClickable(logoutMenu);
    			clickElement(logoutMenu);
				break;
			case ChangeUser:
				waitForElementToBeClickable(changeUserMenu);
    			clickElement(changeUserMenu);
				break;
			case DriverTraining:
				waitForElementToBeClickable(driverTrainingMenu);
    			clickElement(driverTrainingMenu);
				break;
			case ChangeDriver:
				waitForElementToBeClickable(changeDriverMenu);
    			clickElement(changeDriverMenu);
				break;
			case DeviceTraining:
				waitForElementToBeClickable(deviceTrainingMenu);
    			clickElement(deviceTrainingMenu);
				break;
			case Internet:
				waitForElementToBeClickable(internetMenu);
    			clickElement(internetMenu);
				break;
			case MediaManager:
				waitForElementToBeClickable(mediaManagerMenu);
    			clickElement(mediaManagerMenu);
				break;
			case AndroidAccess:
				waitForElementToBeClickable(androidAccessMenu);
    			clickElement(androidAccessMenu);
				break;
			case MyMedia:
				waitForElementToBeClickable(myMediaMenu);
    			clickElement(myMediaMenu);
				break;
		}
	}
}
