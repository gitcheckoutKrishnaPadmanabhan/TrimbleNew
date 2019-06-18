package com.trimble.mobile.pmobileapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class SettingsPage extends AppiumCommandsPage {
	


	@FindBy(id = "pnetpage_homebutton_imagebutton")
	private WebElement peoplenetLogo;

	@FindBy(id = "pnetpage_titletext_textview")
	private WebElement settingsText;

	@FindBy(id = "pnetpage_backbutton_imagebutton")
	private WebElement backArrow;

	@FindBy(xpath = "//*[@text='Volume/Backlight']")
	private WebElement volumeBacklightButton;

	@FindBy(id = "systemsettingsvolbl_volumebacklight_textview")
	private WebElement volumeBacklightText;

	@FindBy(id = "systemsettingsvolbl_volume_seekbar")
	private WebElement volumeSeekbar;

	@FindBy(id = "systemsettingsvolbl_backlight_seekbar")
	private WebElement backlightSeekbar;

	@FindBy(id = "systemsettingsvolbl_backlightautodim_togglebutton")
	private WebElement backLightOnOffButton;

	@FindBy(xpath = "//*[@text='Units:']")
	private WebElement unitsButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView[2]")
	private WebElement unitsSelectedText;

	@FindBy(id = "systemsettingsunits_units_textview")
	private WebElement unitsText;

	@FindBy(id = "systemsettingsunits_us_radiobutton")
	private WebElement usRadioButton;

	@FindBy(id = "systemsettingsunits_metric_radiobutton")
	private WebElement metricRadioButton;

	@FindBy(id = "systemsettingsunits_imperial_radiobutton")
	private WebElement imperialRadioButton;

	@FindBy(xpath = "//*[@text='Language:']")
	private WebElement languageButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView[2]")
	private WebElement selectedLanguageText;

	@FindBy(id = "systemsettingslanguage_languagelabel_textview")
	private WebElement LanguageText;

	@FindBy(id = "systemsettingslanguage_english_radiobutton")
	private WebElement englishRadioButton;

	@FindBy(id = "systemsettingslanguage_spanish_radiobutton")
	private WebElement spanishRadioButton;

	@FindBy(id = "systemsettingslanguage_french_radiobutton")
	private WebElement frenchRadioButton;

	@FindBy(xpath = "//*[@text='Font Size:']")
	private WebElement fontSizeButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.TextView[2]")
	private WebElement selectedFontText;

	@FindBy(id = "systemsettingsfontsize_fontsize_textview")
	private WebElement fontSizeText;

	@FindBy(id = "systemsettingsfontsize_normal_radiobutton")
	private WebElement normalRadioButton;

	@FindBy(id = "systemsettingsfontsize_large_radiobutton")
	private WebElement largerRadioButton;

	@FindBy(id = "systemsettingsfontsize_restartrequired_textview")
	private WebElement restartText;

	@FindBy(xpath = "//*[@text='Sort Messages:']")
	private WebElement sortMessagesButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.TextView[2]")
	private WebElement selectedSortingOrder;

	@FindBy(id = "systemsettingsmsgsort_sortmessages_textview")
	private WebElement sortMessagesTitle;

	@FindBy(id = "systemsettingsmsgsort_dateasc_radiobutton")
	private WebElement dateAscendingRadioButton;

	@FindBy(id = "systemsettingsmsgsort_datedesc_radiobutton")
	private WebElement dateDescendingRadioButton;

	@FindBy(xpath = "//*[@text='Time Zone:']")
	private WebElement timeZoneButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.TextView[2]")
	private WebElement selectedTimeZone;

	@FindBy(xpath = "//*[@text='DATE AND TIME']")
	private WebElement dateTimeText;

	@FindBy(xpath = "//*[@text='Date/Time Format:']")
	private WebElement dateTimeFormatButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.TextView[2]")
	private WebElement selectedDateTime;

	@FindBy(id = "systemsettingstimeformat_timeformat_textview")
	private WebElement timeFormatText;

	@FindBy(id = "systemsettingsformats_standard_radiobutton")
	private WebElement tweleveHourRadioButton;

	@FindBy(id = "systemsettingsformats_military_radiobutton")
	private WebElement twentyFourHourRadioButton;

	@FindBy(id = "systemsettingstimeformat_dateformat_textview")
	private WebElement dateFormatText;

	@FindBy(id = "systemsettingsformats_mmddyy_radiobutton")
	private WebElement MMDDYYFormatRadioButton;

	@FindBy(id = "systemsettingsformats_ddmmyy_radiobutton")
	private WebElement DDMMYYFormatRadioButton;

	@FindBy(id = "systemsettingsformats_off_radiobutton")
	private WebElement offRadioButton;

	@FindBy(id = "alert_message")
	private WebElement alertMessage;

	@FindBy(xpath = "//*[@text='YES']")
	private WebElement YesButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")
	private WebElement NoButton;

	@FindBy(xpath = "//*[@text='Automatic date and time']/../..//*[@class='android.widget.Switch']")
	private WebElement automaticDateTimeSwitch;

	@FindBy(xpath = "//*[@text='Select time zone' and @index='0']")
	private WebElement selectTimeZone;

	@FindBy(xpath = "//*[@text='System']")
	private WebElement systemButton;

	@FindBy(xpath = "//*[@text='__temp']")
	private WebElement TimeZone;

	public SettingsPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickSubSections(String menu) {

		switch (menu) {

		case "VolumeBacklight":
			clickElement(volumeBacklightButton);
			break;

		case "unitsButton":
			clickElement(unitsButton);
			break;

		case "languageButton":
			clickElement(languageButton);
			break;

		case "fontSizeButton":
			waitForElementVisibility(fontSizeButton);
			clickElement(fontSizeButton);
			break;

		case "Sort Messages":
			waitForElementVisibility(sortMessagesButton);
			clickElement(sortMessagesButton);
			break;

		case "Time Zone":
			clickElement(timeZoneButton);
			break;

		case "Date/Time":
			clickElement(dateTimeFormatButton);
			break;
		}
	}

	public String verifyVolumeBacklightTitle() {
		String actual = getElementPropertyToString("text", volumeBacklightText);
		return actual;
	}

	public void verifySlidersDisplayed() {
		VerifyElementPresent(volumeSeekbar);
		VerifyElementPresent(backlightSeekbar);
	}

	@SuppressWarnings("rawtypes")
	public void slideVolume() {
		int start = volumeSeekbar.getLocation().getX();
		int end = volumeSeekbar.getSize().getWidth();
		int y = volumeSeekbar.getLocation().getY();
		TouchAction action = new TouchAction(appiumDriver);
		int moveTo = (int) (end * 0.4);
		action.press(PointOption.point(start, y)).moveTo(PointOption.point(moveTo, y)).release().perform();
		action.press(PointOption.point(344, 223)).moveTo(PointOption.point(787, 266)).release().perform();
	}

	@SuppressWarnings("rawtypes")
	public void slideBacklight() {
		int start = backlightSeekbar.getLocation().getX();
		int end = backlightSeekbar.getSize().getWidth();
		int y = backlightSeekbar.getLocation().getY();
		TouchAction action = new TouchAction(appiumDriver);
		int moveTo = (int) (end * 0.4);
		action.press(PointOption.point(start, y)).moveTo(PointOption.point(moveTo, y)).release().perform();
		action.press(PointOption.point(344, 299)).moveTo(PointOption.point(787, 342)).release().perform();
	}

	public boolean turnOnBackLight() {
		boolean isEnabled;
		String getStatus = getElementPropertyToString("text", backLightOnOffButton);
		if (getStatus.equalsIgnoreCase("OFF")) {
			clickElement(backLightOnOffButton);
		}
		isEnabled = Boolean.parseBoolean(getElementPropertyToString("enabled", backlightSeekbar));
		return isEnabled;
		// Should return false
	}

	public boolean turnOffBackLight() {
		boolean isEnabled;
		String getStatus = getElementPropertyToString("text", backLightOnOffButton);
		if (getStatus.equalsIgnoreCase("ON")) {
			clickElement(backLightOnOffButton);
		}
		isEnabled = Boolean.parseBoolean(getElementPropertyToString("enabled", backlightSeekbar));
		return isEnabled;
		// Should return True
	}

	public void navigateBack() {
		clickElement(backArrow);
	}

	public void verifyUnitsSection() {
		VerifyElementPresent(unitsText);
		VerifyElementPresent(usRadioButton);
		VerifyElementPresent(metricRadioButton);
		VerifyElementPresent(imperialRadioButton);
	}

	public String verifyUnitsRadioButtons(String units) {

		String temp = "";
		if (units.equalsIgnoreCase("US")) {
			clickElement(usRadioButton);
			temp = getElementPropertyToString("text", unitsSelectedText);
		} else if (units.equalsIgnoreCase("Metric")) {
			clickElement(metricRadioButton);
			temp = getElementPropertyToString("text", unitsSelectedText);
		} else if (units.equalsIgnoreCase("Imperial")) {
			clickElement(imperialRadioButton);
			temp = getElementPropertyToString("text", unitsSelectedText);
		}
		return temp;
	}

	public void verifyLanguageSection() {
		VerifyElementPresent(LanguageText);
		VerifyElementPresent(englishRadioButton);
		VerifyElementPresent(spanishRadioButton);
		VerifyElementPresent(frenchRadioButton);
	}

	public void chooseLanguageRadioButtons(String units) {

		if (units.equalsIgnoreCase("English")) {
			clickElement(englishRadioButton);
		} else if (units.equalsIgnoreCase("Español")) {
			clickElement(spanishRadioButton);
		} else if (units.equalsIgnoreCase("Français")) {
			clickElement(frenchRadioButton);
		}
	}

	public String SelectedRadioButton(String section) {
		String temp = "";
		switch (section) {
		case "Language":
			temp = getElementPropertyToString("text", selectedLanguageText);
			break;
		case "Font Size":
			temp = getElementPropertyToString("text", selectedFontText);
			break;
		case "Sort Section":
			temp = getElementPropertyToString("text", selectedSortingOrder);
			break;
		case "Time Zone":
			temp = getElementPropertyToString("text", selectedTimeZone);
			break;
		case "Time Format":
			temp = getElementPropertyToString("text", selectedDateTime);
			break;
		}
		return temp;
	}

	public void tapAlertPopUp(String option) {
		if (option.equalsIgnoreCase("YES")) {
			clickElement(YesButton);
		} else if (option.equalsIgnoreCase("NO")) {
			clickElement(NoButton);
		}
	}

	public void verifyFontSection() {
		VerifyElementPresent(fontSizeText);
		VerifyElementPresent(normalRadioButton);
		VerifyElementPresent(largerRadioButton);
		VerifyElementPresent(restartText);
	}

	public boolean verifyAlertPopNotDisplayed() {
		boolean alertPopisDisplayed = verifyElementNotPresent(alertMessage);
		return alertPopisDisplayed;
	}

	public void waitForDashboardScreen() {
		waitForElementVisibility(systemButton);
	}

	public void waitforAlertPopUpClose() {
		waitForElementVisibility(normalRadioButton);
	}

	public void chooseFontRadioButtons(String units) {

		if (units.equalsIgnoreCase("Normal")) {
			clickElement(normalRadioButton);
		} else if (units.equalsIgnoreCase("Large")) {
			clickElement(largerRadioButton);
		}
	}

	public void verifySortMessageSection() {

		VerifyElementPresent(sortMessagesButton);
		VerifyElementPresent(sortMessagesTitle);
		VerifyElementPresent(dateAscendingRadioButton);
		VerifyElementPresent(dateDescendingRadioButton);
	}

	public void chooseSortMessagesRadioButtons(String order) {

		if (order.equalsIgnoreCase("Date Ascending")) {
			clickElement(dateAscendingRadioButton);
		} else if (order.equalsIgnoreCase("Date Descending")) {
			clickElement(dateDescendingRadioButton);
		}
	}

	public void changeTimeZone(String timeZone) {

		String status = getElementPropertyToString("text", automaticDateTimeSwitch);
		if (status.equalsIgnoreCase("ON")) {
			clickElement(automaticDateTimeSwitch);
		}
		clickElement(selectTimeZone);
		Swipe("DOWN", 5);
		String xpath = TimeZone.toString();
		xpath = xpath.replaceAll("__temp", timeZone);
		String[] test = xpath.split(": ");
		xpath = test[1];

		boolean found = false;
		while (!found) {
			try {
				appiumDriver.findElement(By.xpath(xpath));
				found = true;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				Swipe("UP", 1);

			}
		}
        appiumDriver.findElement(By.xpath(xpath)).click();
        Back(1);
	}

	public void verifyDateTimeFormatSection() {

		VerifyElementPresent(timeFormatText);
		VerifyElementPresent(tweleveHourRadioButton);
		VerifyElementPresent(twentyFourHourRadioButton);
		VerifyElementPresent(dateFormatText);
		VerifyElementPresent(MMDDYYFormatRadioButton);
		VerifyElementPresent(DDMMYYFormatRadioButton);
		VerifyElementPresent(offRadioButton);
	}

	public String verifyDateTimeFormatRadioButtons(String timeFormat) {

		String temp = "";

		switch (timeFormat) {

		case "12 Hour-MM/DD/YY":
			clickElement(tweleveHourRadioButton);
			clickElement(MMDDYYFormatRadioButton);
			temp = getElementPropertyToString("text", selectedDateTime);
			break;

		case "12 Hour-DD/MM/YY":
			clickElement(tweleveHourRadioButton);
			clickElement(DDMMYYFormatRadioButton);
			temp = getElementPropertyToString("text", selectedDateTime);
			break;

		case "12 Hour-off":
			clickElement(tweleveHourRadioButton);
			clickElement(offRadioButton);
			temp = getElementPropertyToString("text", selectedDateTime);
			break;

		case "24 Hour-MM/DD/YY":
			clickElement(twentyFourHourRadioButton);
			clickElement(MMDDYYFormatRadioButton);
			temp = getElementPropertyToString("text", selectedDateTime);
			break;

		case "24 Hour-DD/MM/YY":
			clickElement(twentyFourHourRadioButton);
			clickElement(DDMMYYFormatRadioButton);
			temp = getElementPropertyToString("text", selectedDateTime);
			break;

		case "24 Hour-off":
			clickElement(twentyFourHourRadioButton);
			clickElement(offRadioButton);
			temp = getElementPropertyToString("text", selectedDateTime);
			break;

		}
		return temp;
	}



}
