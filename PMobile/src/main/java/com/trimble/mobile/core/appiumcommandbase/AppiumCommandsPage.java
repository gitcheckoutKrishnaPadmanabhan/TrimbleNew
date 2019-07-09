package com.trimble.mobile.core.appiumcommandbase;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Ordering;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumCommandsPage {

	public AppiumDriver<WebElement> appiumDriver;

	public AndroidDriver<WebElement> androidDriver;

	public IOSDriver<WebElement> iOSDriver;

	public WebDriverWait wait;
	
	private final int appiumDriverWait = 60;

	/**
	 * @param driver
	 */
	public AppiumCommandsPage(AppiumDriver<WebElement> driver) {
		this.appiumDriver = driver;
		wait = new WebDriverWait(driver, appiumDriverWait);
	}

	/**
	 * @param Webelement
	 */
	public void waitForElementVisibility(WebElement webelement) {
		try {
			wait.until(ExpectedConditions.visibilityOf(webelement));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param Webelement
	 */
	public void waitForElementInVisibility(WebElement webelement) {
		try {
			wait.until(ExpectedConditions.invisibilityOf(webelement));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param Webelement
	 */
	public void waitForElementToBeClickable(WebElement webelement) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webelement));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param element
	 *            clicks the element
	 */
	public void clickElement(WebElement webelement) {
		try {
			webelement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param webelement
	 * @return true or false
	 */
	public boolean VerifyElementPresent(WebElement webelement) {
		try {
			return webelement.isDisplayed();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @param webelement
	 * @return true or false
	 */
	public boolean VerifyElementEnabled(WebElement webelement) {
		return webelement.isEnabled();
	}
	
	/**
	 * @param webelement
	 * @return true or false
	 */
	public boolean VerifyElementSelected(WebElement webelement) {
		return webelement.isSelected();
	}
	

	/**
	 * @return true if keyboard is displayed else returns false
	 * @throws IOException
	 */
	public boolean checkKeyboardDisplayed() throws IOException {
		boolean mInputShown = false;
		try {
			String cmd = "adb shell dumpsys input_method | grep mInputShown";
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			String outputText = "";
			while ((outputText = br.readLine()) != null) {
				if (!outputText.trim().equals("")) {
					String[] output = outputText.split(" ");
					String[] value = output[output.length - 1].split("=");
					String keyFlag = value[1];
					if (keyFlag.equalsIgnoreCase("True")) {
						mInputShown = true;
					}
				}
			}
			br.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mInputShown;
	}

	/**
	 * @param keyevent
	 *            pass the android key event value to perform specific action
	 * 
	 */
	public void adbKeyEvents(int keyevent) {

		try {
			String cmd = "adb shell input keyevent" + " " + keyevent;
			Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finding the duplicate elements in the list
	 * 
	 * @param mono
	 * @param content
	 * @param dosechang
	 * @param enteral
	 */
	public List<String> findDuplicates(List<String> mono) {

		List<String> duplicate = new ArrayList<String>();
		Set<String> s = new HashSet<String>();
		try {
			if (mono.size() > 0) {
				for (String content : mono) {
					if (s.add(content) == false) {
						int i = 1;
						duplicate.add(content);
						System.out.println(
								"List of duplicate elements is" + i + content);
						i++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}

	/**
	 * get specific property value of a web element and stores to string
	 * variable.
	 * 
	 * @param property
	 *            the property of the element
	 * @param byLocator
	 *            the by locator
	 * @return value of the property
	 */
	public String getElementPropertyToString(String property,
			WebElement webelement) {
		String propertyValue = null;
		try {
			propertyValue = webelement.getAttribute(property);
		} catch (Exception e) {
		}
		return propertyValue;
	}

	/**
	 * @param sorted
	 * @return true if the list is sorted
	 * @return false if the list is not sorted
	 */
	public boolean checkListIsSorted(List<String> ListToSort) {

		boolean isSorted = false;

		if (ListToSort.size() > 0) {
			try {
				if (Ordering.natural().isOrdered(ListToSort)) {
					isSorted = true;
					return isSorted;
				} else {
					isSorted = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("List is not sorted");
		}
		return isSorted;
	}

	/**
	 * 
	 * @param activity
	 *            Start an application by passing the activity
	 */
	public void LaunchAndroidApplication(String activity) {
		String cmd;
		try {
			cmd = "adb shell am start -n" + " " + activity;
			Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param activity
	 *            Kill an application by passing the activity
	 */
	public void KillAndroidApplication(String command, String activity) {
		String cmd;
		try {
			cmd = "adb shell am force-stop" + " " + activity;
			Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Closes the Keyboard
	 */
	public void hideKeyboard() {
		appiumDriver.hideKeyboard();
	}

	/**
	 * 
	 * @param Webelement
	 *            the Webelement
	 * @param text
	 *            the text
	 */
	public void enterText(WebElement webelement, String text) {
		clickElement(webelement);
		webelement.sendKeys(text);
		hideKeyboard();
	}
	
	/**
	 * @param Webelement 
	 */
	public void clearText(WebElement webelement) {
		webelement.clear();
	}

	/**
	 * @param byLocator
	 * @returns the list count of the elements
	 * we need to get the count of Web element (XPath) =  “//*[@text='API Demos']* “ 
After converting it as a string, value stored in the String xPath = “Located by By.xpath: //*[@text='API Demos’]”
So, we are splitting the in put by “:”. so we get two outputs,
1. Located by By.xpath 
2. //*[@text='API Demos']

So the second part is the one which we need to parse to get the count. So, always 1 will be constant which retrieves count in the list
	 */
	public int getCount(WebElement webelement) {

		int count = 0;
		try {
			
			String xpath = webelement.toString();
		    String[] test = xpath.split(": ");
		        xpath = test[1];
		        count = appiumDriver.findElements(By.xpath(xpath)).size();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * @param count
	 *            Navigate to previous screen based on the count input
	 * 
	 */
	public void Back(int count) {

		for (int i = 0; i < count; i++) {
			appiumDriver.navigate().back();
		}
	}

	/**
	 * Swipes the screen in left or right or Up or Down direction
	 * 
	 * @param direction
	 *            to swipe Left or Right or Up or Down
	 * @param count
	 *            to swipe n number of times
	 */
	@SuppressWarnings("rawtypes")
	public void Swipe(String direction, int count) {

		String dire = direction;

		try {

			if (dire.equalsIgnoreCase("LEFT")) {

				for (int i = 0; i < count; i++) {
					Dimension size = appiumDriver.manage().window().getSize();
					int startx = (int) (size.width * 0.8);
					int endx = (int) (size.width * 0.20);
					int starty = size.height / 2;

					TouchAction ta = new TouchAction(appiumDriver);
					ta.press(PointOption.point(startx, starty))
							.moveTo(PointOption.point(endx, starty)).release()
							.perform();
				}
			} else if (dire.equalsIgnoreCase("RIGHT")) {

				for (int j = 0; j < count; j++) {
					Dimension size = appiumDriver.manage().window().getSize();
					int endx = (int) (size.width * 0.8);
					int startx = (int) (size.width * 0.20);
					int starty = size.height / 2;

					TouchAction ta = new TouchAction(appiumDriver);
					ta.press(PointOption.point(startx, starty))
							.moveTo(PointOption.point(endx, starty)).release()
							.perform();
				}
			} else if (dire.equalsIgnoreCase("UP")) {

				for (int j = 0; j < count; j++) {
					Dimension size = appiumDriver.manage().window().getSize();
					int starty = (int) (size.height * 0.80);
					int endy = (int) (size.height * 0.20);
					int startx = size.width / 2;
					TouchAction ta = new TouchAction(appiumDriver);
					ta.press(PointOption.point(startx, starty))
							.moveTo(PointOption.point(startx, endy)).release()
							.perform();
				}
			} else if (dire.equalsIgnoreCase("DOWN")) {

				for (int j = 0; j < count; j++) {
					Dimension size = appiumDriver.manage().window().getSize();
					int starty = (int) (size.height * 0.80);
					int endy = (int) (size.height * 0.20);
					int startx = size.width / 2;
					TouchAction ta = new TouchAction(appiumDriver);
					ta.press(PointOption.point(startx, endy))
							.moveTo(PointOption.point(startx, starty)).release()
							.perform();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @param x
	 * @param y
	 * @param seconds
	 *            Press the screen using coordinates
	 */
	@SuppressWarnings("rawtypes")
	public void pressByCoordinates(int x, int y, long seconds) {
		try {
			new TouchAction(appiumDriver).press(point(x, y))
					.waitAction(waitOptions(ofSeconds(seconds))).release()
					.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reLaunchApp() {
		appiumDriver.launchApp();
	}
}
