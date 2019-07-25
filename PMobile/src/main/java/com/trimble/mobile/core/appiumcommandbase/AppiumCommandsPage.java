package com.trimble.mobile.core.appiumcommandbase;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.Ordering;
import com.trimble.mobile.core.filereader.PropertyFileReader;
import com.trimble.mobile.core.enums.SortingType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumCommandsPage {

	public AppiumDriver<WebElement> appiumDriver;

	public AndroidDriver<WebElement> androidDriver;

	public IOSDriver<WebElement> iOSDriver;

	public WebDriverWait wait;

	private final int appiumDriverWait = 60;

	/**
	 * Reads the properties from the configuration file
	 */
	private void initialize() {
		PropertyFileReader handler = new PropertyFileReader(
				"configurations/configuration.properties");
	
	}
	/**
	 * @param driver
	 */
	public AppiumCommandsPage(AppiumDriver<WebElement> driver) {
		initialize();
		this.appiumDriver = driver;
		wait = new WebDriverWait(driver, appiumDriverWait);
	}
	
	/**
	 * @param webelement
	 */
	public void waitForElementVisibility(WebElement webelement) {
		try {
			wait.until(ExpectedConditions.visibilityOf(webelement));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param webelement
	 */
	public void waitForElementInVisibility(WebElement webelement) {
		try {
			wait.until(ExpectedConditions.invisibilityOf(webelement));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param webelement
	 */
	public void waitForElementToBeClickable(WebElement webelement) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webelement));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param webelement
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
	public boolean verifyElementDisplayed(WebElement webelement) {
		try {
			return webelement.isDisplayed();
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @param webelement
	 * @return true or false
	 */
	public boolean verifyElementPresent(WebElement webelement) {
		return webelement.isDisplayed();
	}
	
	
	/**
	 * Closes the Application under test
	 */
	public void closeApplication() {
		try {
			appiumDriver.closeApp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Launches the Application under test
	 */
	public void launchApplication() {
        try {
        	
        	appiumDriver.launchApp();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param webelement
	 * @return true or false
	 */
	public boolean verifyElementNotPresent(WebElement webelement) {
		boolean isElementPresent = false ;
	    try {
	        webelement.isDisplayed();
	        isElementPresent = true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	isElementPresent = false;
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return isElementPresent;
	}
	
	
	public Dimension getElementSize(WebElement webelement) {
	
	     Dimension elementSize = webelement.getSize();
		 return elementSize;
	}
	
	/**
	 * @param webelement
	 * @return true or false
	 */
	public boolean verifyElementEnabled(WebElement webelement) {
		return webelement.isEnabled();
	}
	
	/**
	 * @param webelement
	 * @return true or false
	 */
	public boolean verifyElementSelected(WebElement webelement) {
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
			String cmd ="adb shell input keyevent" + " " + keyevent;
			Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finding the duplicate elements in the list
	 *
	 * @param listWithDuplicates
	 */
	public List<String> findDuplicates(List<String> listWithDuplicates) {

		List<String> duplicate = new ArrayList<String>();
		Set<String> s = new HashSet<String>();
		try {
			if (listWithDuplicates.size() > 0) {
				for (String content : listWithDuplicates) {
					if (!s.add(content)) {
						duplicate.add(content);
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
	 * @param webelement
	 *            the webelement
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
	 * @param ListToSort
	 * @return true if the list is sorted
	 * @return false if the list is not sorted
	 */
	public boolean checkListIsSorted(List<String> ListToSort,SortingType order) {

		boolean isSorted = false;

		if (ListToSort.size() > 0) {
			try {
				switch(order) {
					case ascending:
						if (Ordering.natural().isOrdered(ListToSort)) {
							isSorted = true;
						}else {
							isSorted = false;
						}
						break;
					case descending:
						if(Ordering.natural().reverse().isOrdered(ListToSort)) {
							isSorted = true;
						}
						else {
							isSorted = false;
						}
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	public void KillAndroidApplication(String activity) {
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
	 * @param webelement
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
	 * @param webelement
	 */
	public void clearText(WebElement webelement) {
		webelement.clear();
	}

	/**
	 * @param webelement
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
	
	/**
	 * @param webelement
	 *            Long Press element
	 */
	@SuppressWarnings("rawtypes")
	public void longPress(WebElement webelement) {
		TouchAction action = new TouchAction(appiumDriver);
		action.longPress(new LongPressOptions()
				.withElement(ElementOption.element(webelement))
				.withDuration(Duration.ofMillis(5000)))
				.release()
				.perform();

	}

}
