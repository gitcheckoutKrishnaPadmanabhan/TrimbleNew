package com.trimble.mobile.core.appiumdriverinstance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.trimble.mobile.core.filereader.PropertyFileReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDriverInstance {

	private String host;
	private int port;
	private String deviceName;
	private String appPath;

	private static DesiredCapabilities capabilities;

	private static AppiumDriverInstance instance = null;

	private AppiumDriver<WebElement> appiumDriver;

	AppiumServer server = new AppiumServer();

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
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
		return (instance == null)
				? instance = new AppiumDriverInstance()
				: instance;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public AppiumDriver<WebElement> getAppiumDriver() throws Exception {

		if (appiumDriver == null) {
			initialize();
			//server.startServer(getPort());
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
		setHost(handler.getproperty("HOST_IP"));
		setPort(Integer.parseInt(handler.getproperty("HOST_PORT")));
		setDeviceName(handler.getproperty("DEVICE_NAME"));
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
		return capabilities;

	}
	/**
	 * @returns the Appium driver
	 * @throws Exception
	 *             when given platform is not supported
	 */
	public AppiumDriver<WebElement> getAppiumDriverInstance() throws Exception {
		try {
			String remoteUrl = "http://" + getHost() + ":" + getPort()
					+ "/wd/hub";
			appiumDriver = new AppiumDriver<WebElement>(
					this.generateAndroidCapabilities());
			// new URL(remoteUrl),
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
		server.stopServer();
	}

}
