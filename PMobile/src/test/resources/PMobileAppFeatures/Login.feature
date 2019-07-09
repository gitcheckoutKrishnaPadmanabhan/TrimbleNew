Feature: PMobile application sign in feature 
	In order to access pMobile application
	As a driver
	I want to sign in to the application 

Background:
	Given There are no driver signin to the application
	
Scenario Outline: Verify that Single Driver can able to login and logout of the application successfully
	Given Driver with driverid "<driverid1>" and password "<password1>" sign in to the application 
	And Driver is on home page after successfull login
	When Driver with driverid "<driverid1>" tries to log out of the application
	Then Driver with driverid "<driverid1>" should logout successfully
Examples:
	| driverid1 | password1 | 
	| anitha    | anitha    | 

Scenario Outline: Verify that error message should be prompted if driver login with invalid password
	Given Driver is in login page
	When Driver with driverid "<driverid1>" and password "<password1>" sign in to the application 
	Then Driver with driverid "<driverid1>" should receive warning message
Examples:
	| driverid1 | password1  | 
	| anitha    | invalidpwd | 

Scenario Outline: Verify that error message should be prompted if driver login with another driver credentials
	Given Driver is in login page
	When Driver with driverid "<driverid1>" and password "<password1>" sign in to the application 
	Then Driver with driverid "<driverid1>" should receive warning message
Examples:
	| driverid1 | password1 | 
	| anitha    | anitha1   | 

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

