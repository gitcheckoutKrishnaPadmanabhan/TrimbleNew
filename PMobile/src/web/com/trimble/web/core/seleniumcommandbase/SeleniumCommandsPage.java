package com.trimble.web.core.seleniumcommandbase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommandsPage {

	public WebDriver webdriver;
	private final int webdriverWait = 60;

	/**
	 * @param url 
	 */
	public void OpenUrl(String url) {
		webdriver.get(url);
	}
	
	/**
	 * 
	 * @param Webelement
	 *           sending the text to the webelement
	 * @param text
	 *           text which need to be entered
	 */
	public void enterText(WebElement webelement, String text) {
		webelement.sendKeys(text);
	}
	
	/**
	 * @param Webelement 
	 * 			  clear the webelement
	 */
	public void clearText(WebElement webelement) {
		webelement.clear();
	}
	
	/**
	 * @param Webelement 
	 * 			  check whether the webelement is present or not
	 * @return true or false
	 */

	public boolean VerifyElementPresent(WebElement webelement) throws Exception {
		try {
			webelement.isDisplayed();
			HighlightMyElement(webelement);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * @param webelement
	 * 			click the webelement
	 * @return true or false
	 */
	public void clickElement(WebElement webelement) throws Exception {
		try {
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);", webelement);
			waitForElementVisibility(webelement);
			if (webelement.isDisplayed() && webelement.isEnabled())
				webelement.click();
		} catch (Exception e) {
			System.out.println("Not Clicked" + e);
		}
	}

	/**
	 * @param webelement
	 * 			scroll to the webelement
	 * @return true or false
	 */
	public boolean scrollToElement(WebElement webelement) throws Exception {
		try {
			Actions actions = new Actions(webdriver);
			actions.moveToElement(webelement);
			actions.perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param value
	 * 			scroll up the page for the given value 
	 * @return true or false
	 */
	public boolean scrollUp(int value) throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) webdriver;
			jse.executeScript("window.scrollBy(0,-" + value + ")", "");
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	/**
	 * @param webelement
	 * 		scroll down the page for the given value
	 * @return true or false
	 */
	public boolean scrollDown(int value) throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) webdriver;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	/**
	 * @param webelement
	 * @return true or false
	 */
	public boolean waitForElementVisibility(WebElement webelement) {

		try {
			WebDriverWait wait = new WebDriverWait(webdriver, webdriverWait);
			wait.until(ExpectedConditions.visibilityOf(webelement));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param webelement
	 * This method is for in some situations the element will be inaccessible, 
	 * so we are trying it several times before an exception is thrown. 
	 * 
	 */
	public void waitLoop(WebElement webelement) {
		for (int i = 0; i < 3; i++)
			waitForElementVisibility(webelement);
	}

	/**
	 * @param webelement
	 * 			Highlight the webelement
	 * This method is for highlighting the elements in the web page.
	 * This method is called inside the VerifyElementPresent method
	 * It will highlight the element for a particular time, that's why its done multiple times.
	 */
	public void HighlightMyElement(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor javascript = (JavascriptExecutor) webdriver;
			javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: green; border: 3px solid green;");
			javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}
	
	/**
	 * @param webelement, value
	 * 			select value from the webelement
	 */
	public void selectOptionFromdDropDown(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByVisibleText(value);
	}
	
	/**
	 * close the current window 
	 */
	public void closeCurrentWindow() {
		webdriver.close();
	}
	
	/**
	 * Quits the webdriver
	 */
	public void quitBrowser() {
		webdriver.quit();
	}


}
