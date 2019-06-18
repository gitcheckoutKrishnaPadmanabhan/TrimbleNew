package com.trimble.mobile.pmobileapp.stepdefinitions;

import org.testng.Assert;

import com.trimble.mobile.core.testcontext.TestContext;
import com.trimble.mobile.pmobileapp.pages.HomePage;
import com.trimble.mobile.pmobileapp.pages.SettingsPage;
import com.trimble.mobile.pmobileapp.pages.SystemPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SettingsTest {

	TestContext testContext;
	HomePage homePage;
	SystemPage systemPage;
	SettingsPage settingsPage;

	public SettingsTest(TestContext context) {
		testContext = context;
		homePage =  testContext.getPageObjectManager().getHomePage();
		systemPage = testContext.getPageObjectManager().getSystemPage();
		settingsPage = testContext.getPageObjectManager().getSettingsPage();
	}

	@Given("^I am on the Settings screen$")
	public void i_am_on_the_settings_screen() throws Throwable {
		homePage.clickSubSections("System");
		systemPage.clickSettings();
	}

	@And("^I tap the Volume/Backlight button$")
	public void i_tap_the_volumebacklight_button() throws Throwable {
		settingsPage.clickSubSections("VolumeBacklight");
		settingsPage.verifySlidersDisplayed();
		Assert.assertEquals(settingsPage.verifyVolumeBacklightTitle(), "Volume/Backlight");
	}

	@When("^I set the Backlight Auto Dim to OFF$")
	public void i_set_the_backlight_auto_dim_to_off() throws Throwable {
		Assert.assertEquals(settingsPage.turnOffBackLight(), true);
	}

	@Then("^I am not able to slide the Backlight seekbar$")
	public void i_am_not_able_to_slide_the_backlight_seekbar() throws Throwable {
		settingsPage.slideBacklight();
	}

	@When("^I set the Backlight Auto Dim to ON$")
	public void i_set_the_backlight_auto_dim_to_on() throws Throwable {
		Assert.assertEquals(settingsPage.turnOnBackLight(), false);
	}

	@Then("^I am able to slide the Backlight seekbar$")
	public void i_am_able_to_slide_the_backlight_seekbar() throws Throwable {
		settingsPage.slideBacklight();

	}

	@When("^I set the backlight to 100 and navigate to previous screen and come back to settings screen$")
	public void i_set_the_backlight_to_1000_and_navigate_to_previous_screen_and_come_back_to_settings_screen()
			throws Throwable {
		settingsPage.slideBacklight();
		settingsPage.navigateBack();
		systemPage.clickSettings();
	}

	@Then("^I see the backlight is set to same 100$")
	public void i_see_the_backlight_is_set_to_same_100() throws Throwable {
		settingsPage.clickSubSections("VolumeBacklight");
	}

	@When("^I set the volume to 100 and navigate to previous screen and come back to settings screen$")
	public void i_set_the_volume_to_100_and_navigate_to_previous_screen_and_come_back_to_settings_screen()
			throws Throwable {
		settingsPage.slideVolume();
		settingsPage.navigateBack();
		systemPage.clickSettings();
	}

	@Then("^I see the volume is set to same 100$")
	public void i_see_the_volume_is_set_to_same_100() throws Throwable {
		settingsPage.clickSubSections("VolumeBacklight");
	}

	@Given("^I tap the Units section$")
	public void i_tap_the_units_section() throws Throwable {
		settingsPage.clickSubSections("unitsButton");
	}
	
    @Then("^I verify the Units section displayed with the radio buttons in the screen$")
    public void i_verify_the_units_section_displayed_with_the_radio_buttons_in_the_screen() throws Throwable {
    	settingsPage.verifyUnitsSection();
    }

	@Then("^I tap the Units radio buttons one by one and see the text getting changed under the Units$")
	public void i_tap_the_units_radio_buttons_one_by_one_and_see_the_text_getting_changed_under_the_units()
			throws Throwable {
		Assert.assertEquals(settingsPage.verifyUnitsRadioButtons("US"), "US");
		Assert.assertEquals(settingsPage.verifyUnitsRadioButtons("Metric"), "Metric");
		Assert.assertEquals(settingsPage.verifyUnitsRadioButtons("Imperial"), "Imperial");
	}

	@Given("^I tap the Language section$")
	public void i_tap_the_language_section() throws Throwable {
		settingsPage.clickSubSections("languageButton");
		settingsPage.verifyLanguageSection();
	}

	@When("^I choose the language Espanol$")
	public void i_choose_the_language_espanol() throws Throwable {
		settingsPage.chooseLanguageRadioButtons("Español");

	}

	@Then("^I see a Alert pop-up with the message Changing language requires restart with Yes and No buttons and i tap No from the pop-up$")
	public void i_see_a_alert_popup_with_the_message_changing_language_requires_restart_with_yes_and_no_buttons_and_i_tap_no_from_the_popup()
			throws Throwable {
		settingsPage.tapAlertPopUp("NO");
		Assert.assertEquals(settingsPage.SelectedRadioButton("Language"), "English");
	}

	@Then("^I see a Alert pop-up with the message Changing language requires restart with Yes and No buttons and i tap Yes from the pop-up$")
	public void i_see_a_alert_popup_with_the_message_changing_language_requires_restart_with_yes_and_no_buttons_and_i_tap_yes_from_the_popup()
			throws Throwable {
		settingsPage.tapAlertPopUp("NO");
	}

	@Given("^I tap the Font section$")
	public void i_tap_the_font_section() throws Throwable {
		settingsPage.clickSubSections("fontSizeButton");
		settingsPage.verifyFontSection();
	}

	@When("^I tap the normal radio button$")
	public void i_tap_the_normal_radio_button() throws Throwable {
		settingsPage.chooseFontRadioButtons("Normal");
	}

	@Then("^I should not see pop-up for the normal radio button which is already selected$")
	public void i_should_not_see_popup_for_the_normal_radio_button_which_is_already_selected() throws Throwable {
		Assert.assertEquals(settingsPage.verifyAlertPopNotDisplayed(), false);
	}

	@Then("^I see a Alert pop-up with the message Changing font requires restart with Yes and No buttons and i tap Yes from the pop-up$")
	public void i_see_a_alert_popup_with_the_message_changing_font_requires_restart_with_yes_and_no_buttons_and_i_tap_yes_from_the_popup()
			throws Throwable {
		settingsPage.tapAlertPopUp("YES");
		settingsPage.waitForDashboardScreen();
		homePage.clickSubSections("System");
		systemPage.clickSettings();
		Assert.assertEquals(settingsPage.SelectedRadioButton("Font Size"), "Large");
	}

	@When("^I tap the large radio button$")
	public void i_tap_the_large_radio_button() throws Throwable {
		settingsPage.chooseFontRadioButtons("Large");
	}

	@Then("^I see a Alert pop-up with the message Changing font requires restart with Yes and No buttons and i tap NO from the pop-up$")
	public void i_see_a_alert_popup_with_the_message_changing_font_requires_restart_with_yes_and_no_buttons_and_i_tap_no_from_the_popup()
			throws Throwable {
		settingsPage.tapAlertPopUp("NO");
	}

	@And("^I wait for the pop-up to close after 30 seconds time out$")
	public void i_wait_for_the_popup_to_close_after_30_seconds_time_out() throws Throwable {
		settingsPage.waitforAlertPopUpClose();
	}

	@Given("^I tap the Sort Messages section$")
	public void i_tap_the_sort_messages_section() throws Throwable {
		settingsPage.clickSubSections("Sort Messages");
		settingsPage.verifySortMessageSection();
	}

	@When("^I choose the date ascending radio button$")
	public void i_choose_the_date_ascending_radio_button() throws Throwable {
		settingsPage.chooseSortMessagesRadioButtons("Date Ascending");
	}

	@Then("^I see the date ascending displayed below the Sort Messages section$")
	public void i_see_the_date_ascending_displayed_below_the_sort_messages_section() throws Throwable {
		Assert.assertEquals(settingsPage.SelectedRadioButton("Sort Section"), "Date Ascending");
	}

	@When("^I choose the date descending radio button$")
	public void i_choose_the_date_descending_radio_button() throws Throwable {
		settingsPage.chooseSortMessagesRadioButtons("Date Descending");
	}

	@Then("^I see the date descending displayed below the Sort Messages section$")
	public void i_see_the_date_descending_displayed_below_the_sort_messages_section() throws Throwable {
		Assert.assertEquals(settingsPage.SelectedRadioButton("Sort Section"), "Date Descending");
	}

	@Given("^I tap the Time Zone  section$")
	public void i_tap_the_time_zone_section() throws Throwable {
		settingsPage.clickSubSections("Time Zone");
	}

	@When("^I change the a different time Zone from the android device system Settings$")
	public void i_change_the_a_different_time_zone_from_the_android_device_system_settings() throws Throwable {
		settingsPage.changeTimeZone("Fiji");
		i_am_on_the_settings_screen();
	}

	@Then("^I see the selected time zone displayed in the Pmobile application$")
	public void i_see_the_selected_time_zone_displayed_in_the_pmobile_application() throws Throwable {
		Assert.assertEquals(settingsPage.SelectedRadioButton("Time Zone"), "Pacific/Fiji");
	}

	@Given("^I tap the Date Time section$")
	public void i_tap_the_date_time_section() throws Throwable {
		settingsPage.clickSubSections("Date/Time");

	}

	@When("^I verify the Date Time Selection$")
	public void i_verify_the_date_time_selection() throws Throwable {
		settingsPage.verifyDateTimeFormatSection();
	}

	@When("^I tap the 12 Hour radio button with the following combinations MMDDYY and DDMMYY and Off and verify the selected option displayed below the Date Time Format text$")
	public void i_tap_the_12_hour_radio_button_with_the_following_combinations_mmddyy_and_ddmmyy_and_off_and_verify_the_selected_option_displayed_below_the_date_time_format_text()
			throws Throwable {
		Assert.assertEquals(settingsPage.verifyDateTimeFormatRadioButtons("12 Hour-MM/DD/YY"), "MM/DD/YY - 12 Hour");
		Assert.assertEquals(settingsPage.verifyDateTimeFormatRadioButtons("12 Hour-DD/MM/YY"), "DD/MM/YY - 12 Hour");
		Assert.assertEquals(settingsPage.verifyDateTimeFormatRadioButtons("12 Hour-off"), "Off - 12 Hour");
	}

	@And("^I tap the 24 Hour radio button with the following combinations MMDDYY and DDMMYY and Off and verify the selected option displayed below the Date Time Format text$")
	public void i_tap_the_24_hour_radio_button_with_the_following_combinations_mmddyy_and_ddmmyy_and_off_and_verify_the_selected_option_displayed_below_the_date_time_format_text()
			throws Throwable {
		Assert.assertEquals(settingsPage.verifyDateTimeFormatRadioButtons("24 Hour-MM/DD/YY"), "MM/DD/YY - 24 Hour");
		Assert.assertEquals(settingsPage.verifyDateTimeFormatRadioButtons("24 Hour-DD/MM/YY"), "DD/MM/YY - 24 Hour");
		Assert.assertEquals(settingsPage.verifyDateTimeFormatRadioButtons("24 Hour-off"), "Off - 24 Hour");

	}



}
