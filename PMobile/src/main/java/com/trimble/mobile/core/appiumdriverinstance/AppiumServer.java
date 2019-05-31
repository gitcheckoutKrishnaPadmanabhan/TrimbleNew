package com.trimble.mobile.core.appiumdriverinstance;

import java.io.IOException;
import java.net.ServerSocket;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


/**
 * @author abalasu
 *
 */
public class AppiumServer {
	private AppiumDriverLocalService service;

	/**
	 * @returns starts appium server
	 */
	public void startServer(int port) {
		
		if(checkIfServerIsRunnning(port)!=true) {
			//Build the Appium service
		    AppiumServiceBuilder builder = new AppiumServiceBuilder();
		    builder.withIPAddress("127.0.0.1");
		    builder.usingPort(port);
		    builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		    builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		    //Start the server with the builder
		    service = AppiumDriverLocalService.buildService(builder);
		    service.start();
		}else {
			System.out.println("Appium Server already running on Port - " + port);
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
	 * @returns stops appium server
	 */
	public void stopServer() {
		service.stop();
	}
	
	
	/**
	 * @param port
	 * @return server running status
	 */
	public boolean checkIfServerIsRunnning(int port) {

	    boolean isServerRunning = false;
	    ServerSocket serverSocket;
	    
	    try {
	        serverSocket = new ServerSocket(port);
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
