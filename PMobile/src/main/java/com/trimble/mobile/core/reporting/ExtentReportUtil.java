package com.trimble.mobile.core.reporting;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.trimble.mobile.core.appiumdriverinstance.AppiumDriverInstance;
import io.appium.java_client.AppiumDriver;

public class ExtentReportUtil {
	
	public AppiumDriver<WebElement> appiumdDriver;
	
	public ExtentReports extent;
	
	public ExtentTest scenarioDef;
	
	public ExtentTest features;
	
	private String time = getDate();

	public String report;
	
	/**
	 * Base configuration for generating the Extent Report
	 */
	public void extentReportConfig(String reportname) {
		
		this.report = reportname;
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports" + "/" + reportname + "/" + "/" + reportname + "_" + time + "/" + reportname + "_" + time + ".html");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setDocumentTitle("PMobile Automation");
		htmlReporter.config().setReportName("PMobile Test Automation Report");
		htmlReporter.config().setTimeStampFormat("yyyy-MM-dd, HH:mm:ss");
		extent.attachReporter(htmlReporter);
		
	}
	
	/**
	 * Takes screenshot when there is a failure
	 */
	public void extentReportScreenshot(String testname) {
	
		try {
		File scrfile = ((TakesScreenshot)getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
	    FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "/reports" + "/" + report + "/" + "/" + report + "_" + time + "/" + "/Screenshots/" + testname + "_" + time + ".jpg"));
		scenarioDef.fail("details").addScreenCaptureFromPath(System.getProperty("user.dir") + "/reports" + "/" + report + "/" + "/" + report + "_" + time + "/" + "/Screenshots/" + testname + "_" + time + ".jpg");
	   } catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * @return AppiumDriver
	 * @throws Exception
	 */
	public AppiumDriver<WebElement> getDriver() throws Exception{
		if(appiumdDriver == null) {
			appiumdDriver = AppiumDriverInstance.getInstance().getAppiumDriver();
		}
		return appiumdDriver;
	}
	
	/**
	 * @returns the date
	 */	
	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String name = dateFormat.format(date).toString().replaceFirst(" ", "_").replaceAll("/", "_").replaceAll(":","_");
		return name;
	}
	
	/**
	 *
	 */
	public void flushReport() {
		extent.flush();
	}
}
