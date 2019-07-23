Feature: Media Manager
	In order to view/delete the files 
	As a driver
	I want to access Media Manager functionality

Background: Driver Navigate to Media Manager Page
	Given Driver login to the application
	And Driver is in Media Manager Page 
	
#TC-937,TC-1126,TC-940,TC-1015
Scenario: Verify that, PNet Pictures displays the pictures taken by the system camera
	Given Driver views Pnet Picture section in Media Manager Page
	And Driver navigate to home Page from Media Manager Page
	When Driver taken picture and saved media using camera menu
	And Driver navigate back to picture view in Media Manager Page
	Then Newly taken picture should get updated in picture list view

 #TC-1017,TC-1018,TC-1020,TC-1021,TC-1019
 Scenario: Verify that, Driver can take multiple pictures using camera menu and those pictures should get listed in Media Manager Pictures view
	 Given Driver views Pnet Picture section in Media Manager Page
	 And Driver navigate to home Page from Media Manager Page
	 When Driver taken multiple picture and saved media using camera menu
	 And Driver navigate back to picture view in Media Manager Page
	 Then Multiple pictures taken should get updated in picture list view

#TC-935,TC-940
Scenario: Verify that, user displayed with an option to view Pnet Pictures or Downloads after reboot
	Given Driver views download section in Media Manager Page
	And Driver reboot PMobile application
	When Driver navigate to Media Manager Page
	Then Driver will be prompted to select the folder path

#TC-2275
Scenario: Verify that,selected folder option should be retained if user navigate to some other page and return back to Media Manager view
	Given Driver views download section in Media Manager Page
	When Driver navigate to some other page and return back to Media Manager page
	Then Driver has access to Download section in Media Manager

#TC-2277
Scenario: Verify that, folder selection will be retained if driver sign out and sign in to the application
	Given Driver views Pnet Picture section in Media Manager Page
	And Driver navigate to home Page from Media Manager Page
	And Driver log out of the application
	And Driver login to the application
	When Driver is in Media Manager Page
	Then Driver has access to Pnet Picture section in Media Manager Page

#TC-939
Scenario: Verify that, user can change the folder selection from Pictures to Downloads in Media Manager Page
	Given Driver views Pnet Picture section in Media Manager Page
	When Driver change folder selection to Downloads
	Then Driver has access to Download section in Media Manager

#TC-939
Scenario: Verify that, user can change the folder selection from Downloads to Pictures in Media Manager Page
	Given Driver views download section in Media Manager Page
	When Driver change folder selection to Pictures
	Then Driver has access to Pictures section in Media Manager

#TC-929
Scenario: Verify that driver can delete single media from the Pnet Picture folder
	Given There are existing pictures in the Pnet Picture folder section
	When Driver tries to delete single media from Pnet Picture folder
	Then Media should get deleted successfully

#TC-930
Scenario: Verify that confirmation GUF will be shown while user tries to delete media
	Given There are existing pictures in the Pnet Picture folder section
	When Driver hits delete button for deleting a media
	Then Delete confirmation GUF will be shown to the driver

#TC-1058,TC-1057
Scenario: Verify that, driver can delete multiple media from the Pnet Picture folder in Media Manager
	Given There are existing pictures in the Pnet Picture folder section
	When Driver tries to delete multiple files
	Then Selected multiple media got deleted successfully

#TC-2278
Scenario: Verify that, driver can cancel delete operation before hitting delete button
	Given There are existing pictures in the Pnet Picture folder section
	When Driver select multiple files to delete
	And Driver cancel delete operation
	Then Delete operation should be cancelled and selection will be cancelled

#TC-2279
Scenario: Verify that, driver can cancel delete operation after hitting delete button
	Given There are existing pictures in the Pnet Picture folder section
	When Driver select multiple files to delete
	And Driver hits delete button for deleting a media
	And Driver cancel delete operation by clicking cancel in the pop up
	Then Delete operation should be cancelled and selection will be cancelled

#TC-2280
Scenario: Verify that, driver can delete all files in the Pnet Picture folder in Media Manager
	Given There are existing pictures in the Pnet Picture folder section
	When Driver tries to delete all files in the Pnet Picture section
	Then All files should get deleted successfully

#TC-1056
Scenario: Verify that, media which is unchecked by driver did not get deleted
	Given There are existing pictures in the Pnet Picture folder section
	When Driver select multiple files to delete
	And Driver hits delete button after deselecting all files
	Then None of the files got deleted

#TC-1055
Scenario: Verify that, driver can select all media by clicking on Check all check box
	Given There are existing pictures in the Pnet Picture folder section
	When Driver select all media using Check All check box
	Then Checkbox displayed to the left of all media will be selected

#TC-1055
Scenario: Verify that, driver can deselect all media by clicking on Check all check box two times
	Given There are existing pictures in the Pnet Picture folder section
	When Driver select all media using Check All check box
	And Driver deselect all media using Check All check box
	Then Checkbox displayed to the left of all media will be deselected

#TC-938
Scenario: Verify that, after viewing media, driver can return back to Media Manager page
	Given There are existing pictures in the Pnet Picture folder section
	When Driver views any image and select android back button
	Then Driver should be returned to Pnet Picture - Media Manager page

#TC-1012
Scenario: Verify that, all files in the Pnet Picture - Media Manager Page can be sorted by Name in ascending order
	Given There are existing pictures in the Pnet Picture folder section
	When Driver sort Picture view using Name field in ascending order
	Then All media should be sorted by Name in ascending order

#TC-1012
Scenario: Verify that, all files in the Pnet Picture - Media Manager Page can be sorted by Name in descending order
	Given There are existing pictures in the Pnet Picture folder section
	When Driver sort Picture view using Name field in descending order
	Then All media should be sorted by Name in descending order

#TC-1013
Scenario: Verify that, all files in the Pnet Picture - Media Manager Page can be sorted by Size in ascending order
	Given There are existing pictures in the Pnet Picture folder section
	When Driver sort Picture view using Size field in ascending order
	Then All media should be sorted by Size in ascending order

#TC-1013
Scenario: Verify that, all files in the Pnet Picture - Media Manager Page can be sorted by Size in descending order
	Given There are existing pictures in the Pnet Picture folder section
	When Driver sort Picture view using Size field in descending order
	Then All media should be sorted by Size in descending order

#TC-1014
Scenario: Verify that, all files in the Pnet Picture - Media Manager Page can be sorted by Date in ascending order
	Given There are existing pictures in the Pnet Picture folder section
	When Driver sort Picture view using Date field in ascending order
	Then All media should be sorted by Date in ascending order

#TC-1014
Scenario: Verify that, all files in the Pnet Picture - Media Manager Page can be sorted by Date in descending order
	Given There are existing pictures in the Pnet Picture folder section
	When Driver sort Picture view using Date field in descending order
	Then All media should be sorted by Date in descending order