Feature: PMobile Settings feature
  As a driver i want to change the settings in the pMobile application

  Background: Driver Navigate to Settings Page
    Given Driver login to the application
    And   Driver is in Settings Screen

  #TC-493
  Scenario: Backlight Auto Dim setting to Suspend Off
    Given Driver taps the Volume/Backlight button
    When Driver sets the Backlight Auto Dim to OFF
    Then Driver is able to slide the Backlight seekbar

  #TC-493
  Scenario: Backlight Auto Dim setting to Suspend ON
    Given Driver taps the Volume/Backlight button
    When Driver sets the Backlight Auto Dim to ON
    Then Driver is not able to slide the Backlight seekbar

  #TC-497
  Scenario: Backlight remains set to max after restart
    Given Driver taps the Volume/Backlight button
    When  Driver sets the backlight to 100
    And   Driver restarts the pMobile application
    And   Driver is on the Settings screen
    Then  Driver checks the backlight is set to same 100

  #TC-496
  Scenario: Volume remains set to max after restart
    Given Driver taps the Volume/Backlight button
    When Driver sets the volume to 100
    And   Driver restarts the pMobile application
    And   Driver is on the Settings screen
    Then Driver checks the volume is set to same 100

  # Test case not available in qTest
  Scenario: Verify the Units section in the Settings screen
    Given Driver taps the Units section
    Then Driver checks the Units section displayed with the radio buttons in the screen
    Then Driver taps the Units radio buttons one by one and see the text getting changed under the Units

  #TC-495
  Scenario: Change the system language and select no on the confirmation
    Given Driver taps the Language section
    When Driver selects the language Espanol
    Then Driver sees a Alert pop-up with the message Changing language requires restart with Yes and No buttons and i tap No from the pop-up

  #TC-1926
  Scenario: Change the system language and select yes on the confirmation
    Given Driver taps the Language section
    When Driver selects the language Espanol
    Then Driver sees a Alert pop-up with the message Changing language requires restart with Yes and No buttons and i tap Yes from the pop-up

    #TC-737, TC- 739
  Scenario: Pmobile Font Size Change - Normal
    Given Driver taps the Font section
    And  Driver sees that the normal radio button is selected
    When Driver taps the normal radio button
    Then Driver should not see pop-up for the normal radio button which is already selected

    #TC -740
  Scenario: PMobile Font Change Selection Presents A Reboot GUF
    Given Driver taps the Font section
    When Driver taps the large radio button
    Then Driver sees a Alert pop-up with the message Changing font requires restart with Yes and No buttons and i tap NO from the pop-up
    And Driver taps the large radio button
    And Driver waits for the pop-up to close after 30 seconds time out

  #TC-738
  Scenario: Pmobile Font Size Change - Large
    Given Driver taps the Font section
    And   Driver checks the font are in normal size
    When   Driver taps the large radio button
    Then  Driver sees a Alert pop-up with the message Changing font requires restart with Yes and No buttons and i tap Yes from the pop-up
    And   Driver is on the Settings screen
    And   Driver checks the font size is larger

  # Test case not available in qTest
  Scenario: Verify that the Messages are sorted in the Ascending order in the Messaging module
    Given Driver taps the Sort Messages section
    When Driver selects the date ascending radio button
    Then Driver checks the date ascending displayed below the Sort Messages section

  # Test case not available in qTest
  Scenario: Verify that the Messages are sorted in the Descending order in the Messaging module
    Given Driver taps the Sort Messages section
    When Driver selects the date descending radio button
    Then Driver checks the date descending displayed below the Sort Messages section

   # Test case not available in qTest
  Scenario Outline: Verify the 12 Hour and 24 Hour Date Time Format section in the settings screen
    Given Driver taps the Date Time section
    When Driver selects the following "<DateTimeFormat>"
    And  Driver restarts the pMobile application
    And   Driver is on the Settings screen
    Then Driver sees the selected "<DateTimeFormat>" displayed in the top right screen

    Examples:
      | DateTimeFormat   |
      | 12 Hour-MM/DD/YY |
      | 12 Hour-DD/MM/YY |
      | 24 Hour-MM/DD/YY |
      | 24 Hour-DD/MM/YY |
      | 24 Hour-Off      |
      | 12 Hour-Off      |

  #TC-1310
  Scenario: Changing the time zone in android device settings changes the PMobile time zone
    Given Driver taps the Time Zone section
    When  Driver changes the a different time Zone from the android device system Settings
    And   Driver is on the Settings screen
    Then  Driver sees the selected time zone displayed in the Pmobile application
    And   Driver restarts the pMobile application
    And   Driver checks the time zone is reflected on the top right screen