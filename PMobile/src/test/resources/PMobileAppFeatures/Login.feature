Feature: PMobile application sign in feature 
	In order to access pMobile application
	As a driver
	I want to sign in to the application 

Background:
	Given There are no driver signin to the application
	
Scenario: Verify that Single Driver can able to login and logout of the application successfully
	Given Driver with sign in with valid credential
	And Driver is on home page after successfull login
	When Driver tries to log out of the application
	Then Driver should logout successfully

Scenario Outline: Verify that error message should be prompted if driver login with invalid password
	Given Driver is in login page
	When Driver login with valid driver id and invalid password "<password1>"
	Then Driver should receive warning message for invalid password
Examples:
	| password1  |
	| invalidpwd |

Scenario: Verify that error message should be prompted if driver login with another driver credentials
	Given Driver is in login page
	When Driver login with another driver password
	Then Driver should receive warning message for invalid password

Scenario Outline: Verify that error message should be prompted if driver login with invalid driver id and password
	Given Driver is in login page
	When Driver with driverid "<driverid1>" and password "<password1>" sign in to the application 
	Then Driver with driverid "<driverid1>" should receive warning message for invalid driver id
Examples:
	| driverid1 | password1  | 
	| invalidid | invalidpwd | 
	
Scenario Outline: Verify that error message should be prompted if driver belongs to another company tries to login
	Given Driver is in login page
	When Driver with driverid "<driverid1>" and password "<password1>" sign in to the application 
	Then Driver with driverid "<driverid1>" should receive warning message for invalid driver id

Examples:
	| driverid1 | password1 | 
	| mohan     | mohan     | 

