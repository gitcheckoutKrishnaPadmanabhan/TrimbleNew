Feature: PMobile application Messaging feature

  Background: Driver Navigate to Messaging Page
    Given Driver login to the application
    And Driver is in Messaging Page

  #TC596
  Scenario Outline: The Address book is laid out correctly
    Given Driver is on the Address book screen
    Then validate the address book screen UI
    Then validate the Admin user "<adminUsername>" has empty contact address

    Examples:
      | adminUsername |
      | 57            |

  #TC-501
  Scenario Outline: Message text remains after navigating to Address book
    Given Driver drafting email "<emailType>"
    And Select admin contact "<adminUsername>" and enter message description text "<messageDescription>"
    When Driver returns back to the create email page after once viewing the address book
    Then Message text "<messageDescription>" should remains in the text field

    Examples:
      | emailType | adminUsername | messageDescription |
      | Standard  | 57            | automation testing |

  #TC-598
  Scenario Outline: Compose Personal Email - Max Recipients

    Given Driver drafting email "<emailType>"
    When Driver selects the first 21 contacts from the list
    Then Driver should see the error message as "<errorMessage>"

    Examples:
      | emailType | errorMessage                                              |
      | Personal  | You may only select up to 20 recipients for your message. |

  #TC-502
  Scenario Outline: Personal Email message and addresses are displayed in order in the Drafts Mailbox

    Given Driver drafting email "<emailType>"
    And Select admin contact "<adminUsername>" and enter message description text "<messageDescription>"
    And Select one other contact "<Username>"
    When Driver click Drafts button
    And Driver opens the drafted mail box
    Then Draft mail box should have the recently drafted message "<messageDescription>" with selected recipients

    Examples:
      | emailType | adminUsername | messageDescription | Username |
      | Personal  | 57            | automation testing | automate |

  #TC-503
  Scenario Outline: Personal Email message and addresses are displayed in order in the Sent Mailbox

    Given Driver drafting email "<emailType>"
    And Select admin contact "<adminUsername>" and enter message description text "<messageDescription>"
    And Select one other contact "<Username>"
    When Driver Sending the message with selecting Now option
    And Driver opens the sent mail box
    Then Sent mail box should have the recently sent message "<messageDescription>" with selected recipients

    Examples:
      | emailType | adminUsername | messageDescription | Username |
      | Personal  | 57            | automation testing | automate |

  #TC-595
  Scenario Outline: Editing a personal contact will update the address book

    Given Driver add a contact with contact name "<newContactName>" and Email Id "<newEmail>" in Add contact page
    When Driver edit the email address "<updatedEmail>" for the newly added contact "<newContactName>"
    Then Contact "<newContactName>" shows in the list should updated the new email "<updatedEmail>"

    Examples:
      | newContactName    | newEmail                        | updatedEmail                  |
      | automationTesting | automationtesting@peoplenet.com | automationtesting@trimble.com |

  #TC-597 and #TC-1476
  Scenario Outline: Send mail to several recipients
  Check mark appears when selecting a Contact from Address Book

    Given Driver drafting email "<emailType>"
    When Driver select first five contacts from the list
    Then Verify the check mark shown for the contacts selected and added as recipients
    And Enter message description text "<messageDescription>"
    When Driver Sending the message with selecting Now option
    And Driver opens the sent mail box
    Then Sent mail box should have the recently sent message "<messageDescription>" with selected recipients

    Examples:
      | emailType | messageDescription |
      | Standard  | automation testing |

	