Feature: PMobile Settings feature
         As a driver i want to change the settings in the pMobile application

  Scenario: Backlight Auto Dim setting to Suspend Off
    Given I am on the Settings screen
    And I tap the Volume/Backlight button
    When I set the Backlight Auto Dim to OFF
    Then I am not able to slide the Backlight seekbar

  Scenario: Backlight Auto Dim setting to Suspend ON
    Given I tap the Volume/Backlight button
    When I set the Backlight Auto Dim to ON
    Then I am able to slide the Backlight seekbar

  Scenario: Backlight remains set to max after restart
    Given I tap the Volume/Backlight button
    When I set the backlight to 100 and navigate to previous screen and come back to settings screen
    Then I see the backlight is set to same 100

  Scenario: Volume remains set to max after restart
    Given I tap the Volume/Backlight button
    When I set the volume to 100 and navigate to previous screen and come back to settings screen
    Then I see the volume is set to same 100

  Scenario: Verify the Units section in the Settings screen
    Given I tap the Units section
    Then I verify the Units section displayed with the radio buttons in the screen
    Then I tap the Units radio buttons one by one and see the text getting changed under the Units

  Scenario: Change the system language and select no on the confirmation
    Given I tap the Language section
    When I choose the language Espanol
    Then I see a Alert pop-up with the message Changing language requires restart with Yes and No buttons and i tap No from the pop-up

  Scenario: Change the system language and select yes on the confirmation
    Given I tap the Language section
    When I choose the language Espanol
    Then I see a Alert pop-up with the message Changing language requires restart with Yes and No buttons and i tap Yes from the pop-up

  Scenario: Pmobile Font Size Change - Normal
    Given I tap the Font section
    When I tap the normal radio button
    Then I should not see pop-up for the normal radio button which is already selected

  Scenario: PMobile Font Change Selection Presents A Reboot GUF
    Given I tap the Font section
    When I tap the large radio button
    Then I see a Alert pop-up with the message Changing font requires restart with Yes and No buttons and i tap NO from the pop-up
    And I tap the large radio button
    And I wait for the pop-up to close after 30 seconds time out

  Scenario: Pmobile Font Size Change - Large
    Given I tap the Font section
    When I tap the large radio button
    Then I see a Alert pop-up with the message Changing font requires restart with Yes and No buttons and i tap Yes from the pop-up

  Scenario: Verify the Sort Messages section in the settings screen
    Given I tap the Sort Messages section
    When I choose the date ascending radio button
    Then I see the date ascending displayed below the Sort Messages section

  Scenario: Verify the Sort Messages section in the settings screen
    Given I tap the Sort Messages section
    When I choose the date descending radio button
    Then I see the date descending displayed below the Sort Messages section

  Scenario: Changing the time zone in android changes the PMobile time zone
    Given I tap the Time Zone  section
    When I change the a different time Zone from the android device system Settings
    Then I see the selected time zone displayed in the Pmobile application

  Scenario: Verify the Date Time Format section in the settings screen
    Given I tap the Date Time section
    When  I verify the Date Time Selection
    Then  I tap the 12 Hour radio button with the following combinations MMDDYY and DDMMYY and Off and verify the selected option displayed below the Date Time Format text
    And   I tap the 24 Hour radio button with the following combinations MMDDYY and DDMMYY and Off and verify the selected option displayed below the Date Time Format text

