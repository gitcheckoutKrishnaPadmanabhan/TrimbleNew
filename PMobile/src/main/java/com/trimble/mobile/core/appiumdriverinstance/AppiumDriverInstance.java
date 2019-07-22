package com.trimble.mobile.core.appiumdriverinstance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.trimble.mobile.core.filereader.PropertyFileReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDriverInstance {

	private String deviceName;
	private String appPath;
	private String platform;

	private static DesiredCapabilities capabilities;

	private static AppiumDriverInstance instance = null;

	private AppiumDriver<WebElement> appiumDriver;

	AppiumServer appiumServer = new AppiumServer();

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getAppPath() {
		return appPath;
	}

	public void setAppPath(String appPath) {
		this.appPath = appPath;
	}

	/**
	 * Private constructor for singleton
	 */
	private AppiumDriverInstance() {
	}

	/**
	 * @return
	 */
	public static AppiumDriverInstance getInstance() {
		return (instance == null) ? instance = new AppiumDriverInstance() : instance;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public AppiumDriver<WebElement> getAppiumDriver() throws Exception {

		if (appiumDriver == null) {
			initialize();
			appiumServer.startServer();
			appiumDriver = getAppiumDriverInstance();
		}
		return appiumDriver;
	}

	/**
	 * Reads the properties from the configuration file
	 */
	private void initialize() {
		PropertyFileReader handler = new PropertyFileReader(
				"configurations/configuration.properties");
		setDeviceName(handler.getproperty("DEVICE_NAME"));
		setPlatform(handler.getproperty("PLATFORM_NAME"));
		setAppPath(handler.getproperty("APP_PATH"));
	}

	/**
	 * @returns the Android capabilities
	 */
	protected DesiredCapabilities generateAndroidCapabilities() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + getAppPath());
		capabilities.setCapability(
				AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,
				"com.domain.pmobile.mainactivity_ip");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				getDeviceName());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				"Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				"uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5);
		capabilities.setCapability("skipDeviceInitialization", true);
		capabilities.setCapability("skipServerInstallation", true);
		
		return capabilities;

	}
	
	/**
	 * @returns the iOS capabilities
	 */
	protected DesiredCapabilities generateiOSCapabilities() {

		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getDeviceName());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getPlatform());
		return capabilities;

	}
	
	/**
	 * @returns the Appium driver
	 * @throws Exception
	 *             when given platform is not supported
	 */
	public AppiumDriver<WebElement> getAppiumDriverInstance() throws Exception {
		
		try {
			
			if ("Android".equalsIgnoreCase(getPlatform())) {
				appiumDriver = new AppiumDriver<WebElement>( this.generateAndroidCapabilities());
			} else if ("iOS".equalsIgnoreCase(getPlatform())) {
				appiumDriver = new AppiumDriver<WebElement>(appiumServer.service.getUrl(), this.generateiOSCapabilities());
			} else {
				throw new Exception("Given Platform is not supported");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appiumDriver;
	}

	/**
	 * Quits the driver
	 */
	public void tearDown() {
		appiumDriver.quit();
		appiumServer.stopServer();
	}

}
