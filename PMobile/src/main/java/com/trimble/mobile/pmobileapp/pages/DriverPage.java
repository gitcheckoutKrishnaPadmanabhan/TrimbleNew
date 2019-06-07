package com.trimble.mobile.pmobileapp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;

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
}
