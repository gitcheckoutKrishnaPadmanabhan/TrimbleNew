package com.trimble.mobile.pmobileapp.stepdefinitions;

import static org.testng.Assert.assertEquals;

import com.trimble.mobile.core.enums.Fields;
import org.testng.Assert;

import com.trimble.mobile.core.testcontext.TestContext;
import com.trimble.mobile.pmobileapp.pages.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Messaging_AddressBookTest {

    TestContext testContext;
    LoginPage loginPage;
    HomePage homePage;
    ApplicationToolBar toolBar;
    Messaging_AddressBookPage messagingPage;

    public Messaging_AddressBookTest(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getSignInPage();
        homePage = testContext.getPageObjectManager().getHomePage();
        toolBar = testContext.getPageObjectManager().getToolBar();
        messagingPage = testContext.getPageObjectManager().getMessagningPage();
    }

    @Given("Driver is in Messaging Page")
    public void driver_is_in_Messaging_Page() {
        if (!toolBar.getPageTitle().equalsIgnoreCase("Messaging - Inbox")) {
            toolBar.initialize();
            toolBar.waitTillPageTitleDisplayed("Home");
            homePage.clickSubSection(Fields.Messaging);
            toolBar.waitTillPageTitleDisplayed("Messaging - Inbox");
        }
    }

    @Given("Driver is on the Address book screen")
    public void driver_is_on_the_Address_book_screen() {
        messagingPage.clickContactsButton();
        toolBar.waitTillPageTitleDisplayed("Address Book");
    }

    @Then("validate the address book screen UI")
    public void validate_the_address_book_screen_UI() throws Exception {
        messagingPage.addressBookUI();
    }

    @Then("validate the Admin user {string} has empty contact address")
    public void validate_the_Admin_user_has_empty_contact_address(String searchUsername) {
        messagingPage.enterAddressSearchTextBox(searchUsername);
        Assert.assertEquals(messagingPage.getaddressBookContactEmail(), "");
    }

    @Given("Driver drafting email {string}")
    public void driver_drafting_standard_email(String emailType) {
        messagingPage.clickEmailButton();
        messagingPage.selectEmailType(emailType);
    }

    @Given("Select admin contact {string} and enter message description text {string}")
    public void select_admin_contact_and_enter_message_description_text(String adminUsername, String messageDescription) {
        messagingPage.selectRecipient(adminUsername);
        messagingPage.enterEmailDescription(messageDescription);
    }

    @When("Driver returns back to the create email page after once viewing the address book")
    public void driver_returns_back_to_the_create_email_page_after_once_viewing_the_address_book() {
        messagingPage.selectRecipient("");
    }

    @Then("Message text {string} should remains in the text field")
    public void message_text_should_remains_in_the_text_field(String messageDescription) {
        Assert.assertEquals(messagingPage.getEmailDescription(), messageDescription);
        toolBar.Back(1);
        messagingPage.clickDeleteButton();
    }

    @When("Driver selects the first 21 contacts from the list")
    public void driver_selects_the_first_contacts_from_the_list() {
        messagingPage.clickSelectRecipient();
        messagingPage.selectMultipleRecipients(21);
    }

    @Then("Driver should see the error message as {string}")
    public void driver_should_see_the_error_message_as(String errorMessage) {
        Assert.assertEquals(messagingPage.getRecipientsErrorMessage(), errorMessage);
        messagingPage.clickOk();
        toolBar.Back(2);
        messagingPage.clickDeleteButton();
    }

    @Given("Select one other contact {string}")
    public void select_one_other_contact(String string) {
        messagingPage.selectRecipient(string);
        testContext.getScenarioContext().setContext("selectedRecipients", messagingPage.getRecipientList());
    }

    @When("Driver click Drafts button")
    public void driver_click_Drafts_button() {
        messagingPage.clickDraftsButton();
    }

    @When("Driver opens the drafted mail box")
    public void driver_opens_the_drafted_mail_box() {
        toolBar.waitTillPageTitleDisplayed("Messaging");
        messagingPage.clickDraftsButton();
    }

    @When("Driver Sending the message with selecting Now option")
    public void driver_Sending_the_message_with_selecting_Now_option() {
        testContext.getScenarioContext().setContext("selectedRecipientList", messagingPage.getRecipientList());
        messagingPage.clickSendButton();
    }

    @When("Driver opens the sent mail box")
    public void driver_opens_the_sent_mail_box() {
        messagingPage.clickSentButton();
    }

    @When("Driver select first five contacts from the list")
    public void driver_select_first_five_contacts_from_the_list() {
        messagingPage.clickSelectRecipient();
        messagingPage.selectMultipleRecipients(5);
    }

    @Then("Enter message description text {string}")
    public void enter_message_description_text(String messageDescription) {
        messagingPage.enterEmailDescription(messageDescription);
    }

    @Given("Driver add a contact with contact name {string} and Email Id {string} in Add contact page")
    public void driver_add_a_contact_with_contact_name_and_Email_Id_in_Add_contact_page(String contactName, String emailAddress) {
        messagingPage.clickContactsButton();
        messagingPage.addContact(contactName, emailAddress);
        messagingPage.enterAddressSearchTextBox(contactName);
        Assert.assertEquals(messagingPage.getaddressBookContactEmail(), emailAddress);
    }

    @When("Driver edit the email address {string} for the newly added contact {string}")
    public void driver_edit_the_email_address_for_the_newly_added_contact(String updatedEmailAddress, String contactName) {
        messagingPage.EditContact(contactName, updatedEmailAddress);
    }

    @Then("Contact {string} shows in the list should updated the new email {string}")
    public void contact_shows_in_the_list_should_updated_the_new_email(String contactName, String updatedEmailAddress) {
        messagingPage.enterAddressSearchTextBox(contactName);
        Assert.assertEquals(messagingPage.getaddressBookContactEmail(), updatedEmailAddress);
    }

    @Then("Verify the check mark shown for the contacts selected and added as recipients")
    public void verify_the_check_mark_shown_for_the_contacts_selected_and_added_as_recipients() {
        Assert.assertEquals(messagingPage.getSelectedContactCount(), 5);
        testContext.getScenarioContext().setContext("selectedContact", messagingPage.getSelectedContactList(messagingPage.getSelectedContactCount()).trim());
        messagingPage.clickAcceptButton();
        assertEquals(testContext.getScenarioContext().getContext("selectedContact"), messagingPage.getRecipientList());
    }

    @Then("Draft mail box should have the recently drafted message {string} with selected recipients")
    public void draft_mail_box_should_have_the_recently_drafted_message_with_selected_recipients(String messageDescription) {
        assertEquals(testContext.getScenarioContext().getContext("selectedRecipients"), messagingPage.getMailBoxRecipientList());
        assertEquals(messageDescription, messagingPage.getMailBoxMessage());
        messagingPage.clickMailBoxMesssage();
        toolBar.Back(1);
        messagingPage.clickDeleteButton();
        messagingPage.clickInboxButton();
    }

    @Then("Sent mail box should have the recently sent message {string} with selected recipients")
    public void sent_mail_box_should_have_the_recently_sent_message_with_selected_recipients(String messageDescription) {
        assertEquals(testContext.getScenarioContext().getContext("selectedRecipientList"), messagingPage.getMailBoxRecipientList());
        assertEquals(messageDescription, messagingPage.getMailBoxMessage());
        messagingPage.clickInboxButton();
    }


}
