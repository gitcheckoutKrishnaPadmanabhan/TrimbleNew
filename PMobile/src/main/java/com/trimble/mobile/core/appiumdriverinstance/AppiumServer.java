package com.trimble.mobile.core.appiumdriverinstance;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import com.trimble.mobile.core.filereader.PropertyFileReader;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


/**
 * @author abalasu
 *
 */
public class AppiumServer {
	
	public AppiumDriverLocalService service;

	private String nodePath;
	
	private String appiumPath;
	
	public String getNodePath() {
		return nodePath;
	}
	
	public String getAppiumPath() {
		return appiumPath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public void setAppiumPath(String appiumPath) {
		this.appiumPath = appiumPath;
	}

    public AppiumServer() {
    	initialize();
    }
	
    /**
	 * Reads the properties from the configuration file
	 */
	private void initialize() {
		PropertyFileReader handler = new PropertyFileReader(
				"configurations/configuration.properties");
		setAppiumPath(handler.getproperty("APPIUM_PATH"));
		setNodePath(handler.getproperty("NODE_PATH"));
	}
    
	/**
	 * @returns starts appium server
	 */
	public void startServer() {
		
		if(checkIfServerIsRunnning()!=true) {
			//Build the Appium service
		    AppiumServiceBuilder builder = new AppiumServiceBuilder();
		    builder.usingAnyFreePort();
		    builder.usingDriverExecutable(new File(getNodePath()));
		    builder.withAppiumJS(new File(getAppiumPath()));
		    builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		    builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		    //Start the server with the builder
		    service = AppiumDriverLocalService.buildService(builder);
		    service.start(); 
		    
		}else {
			System.out.println("Appium Server already running on Port - ");
		}		
		assertService(service);
	}
	
	/**
	 * @param service
	 */
	private void assertService(AppiumDriverLocalService service) {
		if (service == null || !service.isRunning()) {
			throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node wasn't started!");
		}
	}
	
	/**
	 * @returns stops Appium server
	 */
	public void stopServer() {
		service.stop();
	}
	
	/**
	 * @param port
	 * @return server running status
	 */
	public boolean checkIfServerIsRunnning() {

	    boolean isServerRunning = false;
	    ServerSocket serverSocket;
	    
	    try {
	        serverSocket = new ServerSocket();
	        serverSocket.close();
	    } catch (IOException e) {
	        //If control comes here, then it means that the port is in use
	        isServerRunning = true;
	    } finally {
	        serverSocket = null;
	    }
	    return isServerRunning;
	}	
	
}
