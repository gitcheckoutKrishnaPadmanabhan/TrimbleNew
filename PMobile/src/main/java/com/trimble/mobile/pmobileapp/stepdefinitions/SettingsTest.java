package com.trimble.mobile.pmobileapp.stepdefinitions;

import com.trimble.mobile.core.enums.Fields;
import com.trimble.mobile.pmobileapp.pages.*;
import org.testng.Assert;
import com.trimble.mobile.core.testcontext.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SettingsTest {

	TestContext testContext;
	HomePage homePage;
	SystemPage systemPage;
	SettingsPage settingsPage;
	ApplicationToolBar toolBar;

	public SettingsTest(TestContext context) {
		testContext = context;
		homePage =  testContext.getPageObjectManager().getHomePage();
		systemPage = testContext.getPageObjectManager().getSystemPage();
		settingsPage = testContext.getPageObjectManager().getSettingsPage();
		toolBar = testContext.getPageObjectManager().getToolBar();
	}

	@Given("Driver is in Settings Screen")
	public void driver_is_in_Settings_Screen() {
		toolBar.waitForPageTitle();
		if(!toolBar.getPageTitle().equalsIgnoreCase("Settings")){
			toolBar.initialize();
			toolBar.waitTillPageTitleDisplayed("Home");
			homePage.clickSubSection(Fields.System);
			toolBar.waitTillPageTitleDisplayed("System");
			systemPage.clickSubSection(Fields.Settings);
			toolBar.waitTillPageTitleDisplayed("Settings");
		}
	}

	@Given("^Driver is on the Settings screen$")
	public void driver_is_on_the_settings_screen() throws Throwable {
		homePage.waitTillHomePageLoaded();
		homePage.clickSubSection(Fields.System);
		systemPage.clickSettings();
		toolBar.waitTillPageTitleDisplayed("Settings");
	}

	@And("^Driver taps the Volume/Backlight button$")
	public void driver_taps_the_volumebacklight_button() throws Throwable {
		settingsPage.clickSubSections("VolumeBacklight");
		settingsPage.verifySlidersDisplayed();
		Assert.assertEquals(settingsPage.verifyVolumeBacklightTitle(), "Volume/Backlight");
	}

	@When("^Driver sets the Backlight Auto Dim to OFF$")
	public void driver_sets_the_backlight_auto_dim_to_off() throws Throwable {
		Assert.assertEquals(settingsPage.turnOffBackLight(), true);
	}

	@Then("^Driver is not able to slide the Backlight seekbar$")
	public void driver_is_not_able_to_slide_the_backlight_seekbar() throws Throwable {
		settingsPage.slideBacklight();

	}

	@When("^Driver sets the Backlight Auto Dim to ON$")
	public void driver_sets_the_backlight_auto_dim_to_on() throws Throwable {
		Assert.assertEquals(settingsPage.turnOnBackLight(), false);
	}

	@Then("^Driver is able to slide the Backlight seekbar$")
	public void driver_is_able_to_slide_the_backlight_seekbar() throws Throwable {
		settingsPage.slideBacklight();
		settingsPage.setSlider("backlight");
	}
	
	@When("^Driver sets the backlight to 100$")
    public void driver_sets_the_backlight_to_100() throws Throwable {
	    settingsPage.slideBacklight();
	    testContext.getScenarioContext().setContext("backLightBeforeRestart", settingsPage.getBounds("backlightSeekbar"));
    }
	
	 @And("^Driver restarts the pMobile application$")
	 public void driver_restarts_the_pmobile_application() throws Throwable {
		 settingsPage.restartApp();
		 toolBar.waitTillPageTitleDisplayed("Home");
	 }
	
	@Then("^Driver checks the backlight is set to same 100$")
	public void driver_checks_the_backlight_is_set_to_same_100() throws Throwable {
		settingsPage.clickSubSections("VolumeBacklight");
		testContext.getScenarioContext().setContext("backLightAfterRestart", settingsPage.getBounds("backlightSeekbar"));
		Assert.assertEquals(testContext.getScenarioContext().getContext("backLightBeforeRestart"), testContext.getScenarioContext().getContext("backLightAfterRestart"));
		settingsPage.setSlider("backlight");
	}
	
	 @When("^Driver sets the volume to 100$")
	    public void driver_sets_the_volume_to_100() throws Throwable {
		settingsPage.slideVolume();
		testContext.getScenarioContext().setContext("volumeBeforeRestart", settingsPage.getBounds("volumeSeekbar"));
	   }	
	
	@Then("^Driver checks the volume is set to same 100$")
	public void driver_checks_the_volume_is_set_to_same_100() throws Throwable {
		settingsPage.clickSubSections("VolumeBacklight");
		testContext.getScenarioContext().setContext("volumeAfterRestart", settingsPage.getBounds("volumeSeekbar"));
		Assert.assertEquals(testContext.getScenarioContext().getContext("volumeBeforeRestart"), testContext.getScenarioContext().getContext("volumeAfterRestart"));
		settingsPage.setSlider("volume");
	}

	@Given("^Driver taps the Units section$")
	public void Driver_taps_the_units_section() throws Throwable {
		settingsPage.clickSubSections("unitsButton");
	}
	
    @Then("^Driver checks the Units section displayed with the radio buttons in the screen$")
    public void driver_checks_the_units_section_displayed_with_the_radio_buttons_in_the_screen() throws Throwable {
    	settingsPage.verifyUnitsSection();
    }

	@Then("^Driver taps the Units radio buttons one by one and see the text getting changed under the Units$")
	public void driver_taps_the_units_radio_buttons_one_by_one_and_see_the_text_getting_changed_under_the_units()
			throws Throwable {
		Assert.assertEquals(settingsPage.verifyUnitsRadioButtons("US"), "US");
		Assert.assertEquals(settingsPage.verifyUnitsRadioButtons("Metric"), "Metric");
		Assert.assertEquals(settingsPage.verifyUnitsRadioButtons("Imperial"), "Imperial");
				
	}

	@Given("^Driver taps the Language section$")
	public void driver_taps_the_language_section() throws Throwable {
		settingsPage.clickSubSections("languageButton");
		settingsPage.verifyLanguageSection();
	}

	@When("^Driver selects the language Espanol$")
	public void driver_selects_the_language_espanol() throws Throwable {
		settingsPage.chooseLanguageRadioButtons("Español");
		
	}

	@Then("^Driver sees a Alert pop-up with the message Changing language requires restart with Yes and No buttons and i tap No from the pop-up$")
	public void driver_sees_a_alert_popup_with_the_message_changing_language_requires_restart_with_yes_and_no_buttons_and_i_tap_no_from_the_popup()
			throws Throwable {
		settingsPage.tapAlertPopUp("NO");
		Assert.assertEquals(settingsPage.SelectedRadioButton("Language"), "English");
	}

	@Given("^Driver taps the Font section$")
	public void driver_taps_the_font_section() throws Throwable {
		settingsPage.clickSubSections("fontSizeButton");
		settingsPage.verifyFontSection();
	}

	@Given("^Driver checks that the normal radio button is selected$")
	public void driver_checks_that_the_normal_radio_button_is_selected() throws Throwable {
		settingsPage.checkNormalFontSelected();
	}

	@And("^Driver checks the font are in normal size$")
	public void driver_checks_the_font_are_in_normal_size() throws Throwable {
		testContext.getScenarioContext().setContext("normalFontSize", settingsPage.getFontSize());
	}
	  
	@When("^Driver taps the normal radio button$")
	public void driver_taps_the_normal_radio_button() throws Throwable {
		settingsPage.chooseFontRadioButtons("Normal");
	}

	@Then("^Driver should not see pop-up for the normal radio button which is already selected$")
	public void driver_should_not_see_popup_for_the_normal_radio_button_which_is_already_selected() throws Throwable {
		Assert.assertEquals(settingsPage.verifyAlertPopNotDisplayed(), false);
	}

	@Then("^Driver sees a Alert pop-up with the message Changing font requires restart with Yes and No buttons and i tap Yes from the pop-up$")
	public void Driver_sees_a_alert_popup_with_the_message_changing_font_requires_restart_with_yes_and_no_buttons_and_i_tap_yes_from_the_popup()
			throws Throwable {
		settingsPage.tapAlertPopUp("YES");
		settingsPage.waitForDashboardScreen();
	}
	
	@And("^Driver checks the font size is larger$")
    public void driver_checks_the_font_size_is_larger() throws Throwable {
		testContext.getScenarioContext().setContext("largeFontSize", settingsPage.getFontSize());
		int x = (int) testContext.getScenarioContext().getContext("normalFontSize");
		int y = (int) testContext.getScenarioContext().getContext("largeFontSize");
		Assert.assertTrue(y > x);
	}

	@When("^Driver taps the large radio button$")
	public void driver_taps_the_large_radio_button() throws Throwable {
		settingsPage.setFontPreCondition("large");
		settingsPage.chooseFontRadioButtons("Large");
	}

	@Then("^Driver sees a Alert pop-up with the message Changing font requires restart with Yes and No buttons and i tap NO from the pop-up$")
	public void driver_sees_a_alert_popup_with_the_message_changing_font_requires_restart_with_yes_and_no_buttons_and_i_tap_no_from_the_popup()
			throws Throwable {
		settingsPage.tapAlertPopUp("NO");
	}

	@And("^Driver sets the font size back to normal size$")
	public void driver_sets_the_font_size_back_to_normal_size() throws Throwable {
		settingsPage.clickSubSections("fontSizeButton");
		settingsPage.chooseFontRadioButtons("Normal");
		settingsPage.tapAlertPopUp("YES");
		toolBar.waitTillPageTitleDisplayed("Home");
		driver_is_on_the_settings_screen();
	}


	@Then("^Driver waits for the pop-up to close after 30 seconds time out$")
	public void driver_waits_for_the_popup_to_close_after_30_seconds_time_out() throws Throwable {
		settingsPage.waitforAlertPopUpClose();
	}

	@Given("^Driver taps the Sort Messages section$")
	public void driver_taps_the_sort_messages_section() throws Throwable {
		settingsPage.clickSubSections("Sort Messages");
		settingsPage.verifySortMessageSection();
	}

	@When("^Driver selects the date ascending radio button$")
	public void driver_selects_the_date_ascending_radio_button() throws Throwable {
		settingsPage.chooseSortMessagesRadioButtons("Date Ascending");
	}

	@Then("^Driver checks the date ascending displayed below the Sort Messages section$")
	public void driver_checks_the_date_ascending_displayed_below_the_sort_messages_section() throws Throwable {
		Assert.assertEquals(settingsPage.SelectedRadioButton("Sort Section"), "Date Ascending");
	}

	@When("^Driver selects the date descending radio button$")
	public void driver_selects_the_date_descending_radio_button() throws Throwable {
		settingsPage.chooseSortMessagesRadioButtons("Date Descending");
	}

	@Then("^Driver checks the date descending displayed below the Sort Messages section$")
	public void driver_checks_the_date_descending_displayed_below_the_sort_messages_section() throws Throwable {
		Assert.assertEquals(settingsPage.SelectedRadioButton("Sort Section"), "Date Descending");
	}

	@Given("^Driver taps the Time Zone section$")
	public void driver_taps_the_time_zone_section() throws Throwable {
		settingsPage.clickSubSections("Time Zone");
	}

	@When("^Driver changes the a different time Zone from the android device system Settings$")
	public void driver_changes_the_a_different_time_zone_from_the_android_device_system_settings() throws Throwable {
		testContext.getScenarioContext().setContext("deviceTime", settingsPage.changeTimeZone("Fiji"));
	}

	@Then("^Driver sees the selected time zone displayed in the Pmobile application$")
	public void driver_sees_the_selected_time_zone_displayed_in_the_pmobile_application() throws Throwable {
		Assert.assertEquals(settingsPage.SelectedRadioButton("Time Zone"), "Pacific/Fiji");
	}
	
	 @And("^Driver checks the time zone is reflected on the top right screen$")
	 public void driver_checks_the_time_zone_is_reflected_on_the_top_right_screen() throws Throwable {
		 testContext.getScenarioContext().setContext("pMobileApplicationTime", settingsPage.getPmobileTime());
	     Assert.assertEquals(testContext.getScenarioContext().getContext("deviceTime"), testContext.getScenarioContext().getContext("pMobileApplicationTime"));
	 }
	 
	@Given("^Driver taps the Date Time section$")
	public void driver_taps_the_date_time_section() throws Throwable {
		settingsPage.clickSubSections("Date/Time");
		settingsPage.verifyDateTimeFormatSection();
    }

	 @When("^Driver selects the following \"([^\"]*)\"$")
	 public void driver_selects_the_following_something(String datetimeformat) throws Throwable {
		 settingsPage.SelectDateTimeFormat(datetimeformat);
	}
	 
	 @Then("^Driver sees the selected \"([^\"]*)\" displayed in the top right screen$")
	 public void driver_sees_the_selected_something_displayed_in_the_top_right_screen(String datetimeformat) throws Throwable {
		  Assert.assertEquals(settingsPage.DateTimeFormatMatcher(datetimeformat), true);
	  }

	@And("^Driver waits for a minute to see the time format change in the application$")
	public void driver_waits_for_a_minute_to_see_the_time_format_change_in_the_application() throws Throwable {
		settingsPage.waitForTimeFormatChange();
	}

}