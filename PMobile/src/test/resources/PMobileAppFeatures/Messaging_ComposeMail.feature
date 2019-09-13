Feature: Messaging_ComposeEmail
As a driver i want to compose and send a email message in Pmobile application

    Background: Driver navigates to Messaging Page
    Given Driver login to the application
    And   Driver is in Messaging Page
  
  Scenario: Verify whether driver views standard,personal and cancel options in selecting email
	When driver selects email option
	Then standard,personal and cancel buttons should be displayed

