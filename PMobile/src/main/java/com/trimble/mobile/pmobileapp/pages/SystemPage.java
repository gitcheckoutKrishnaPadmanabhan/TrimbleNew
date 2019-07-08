package com.trimble.mobile.pmobileapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SystemPage extends AppiumCommandsPage{
    
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
    
    @FindBy(xpath="//*[@text='Shutter']")
	private WebElement shutterButton;
    
    public SystemPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public void clickSettings() {
        clickElement(settingsButton);
    }
    
    public void clickSubSection(String Menu) {
    	switch(Menu) {
    		case "Settings":
    			waitForElementVisibility(settingsButton);
    			clickElement(settingsButton);
    			break;
    		case "OBC Dignostic":
    			waitForElementVisibility(obcDiagnosticButton);
    			clickElement(obcDiagnosticButton);
    			break;
    		case "Information":
    			waitForElementVisibility(informationButton);
    			clickElement(informationButton);
    			break;
    		case "OTAP":
    			waitForElementVisibility(otapButton);
    			clickElement(otapButton);
    			break;
    		case "Version":
    			waitForElementVisibility(versionButton);
    			clickElement(versionButton);
    			break;
    		case "Licence Plate":
    			waitForElementVisibility(licensePlateButton);
    			clickElement(licensePlateButton);
    			break;
    		case "WifiSetup":
    			waitForElementVisibility(wifiSetupButton);
    			clickElement(wifiSetupButton);
    			break;
    		case "Camera":
    			waitForElementVisibility(cameraButton);
    			clickElement(cameraButton);
    			break;
    		case "Fleet Home Setup":
    			waitForElementVisibility(fleetHomeSetupButton);
    			clickElement(fleetHomeSetupButton);
    			break;
    	}
    }
	
	public void takeSinglePicture() throws InterruptedException {
		waitForElementVisibility(shutterButton);
		clickElement(shutterButton);
		Thread.sleep(500);
		Back(1);
	}
	
	public void takeMultiplePicture() throws InterruptedException {
		waitForElementVisibility(shutterButton);
		clickElement(shutterButton);
		clickElement(shutterButton);
		clickElement(shutterButton);
		Thread.sleep(500);
		Back(1);
		waitForElementInVisibility(shutterButton);
	}
}
