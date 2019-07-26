package com.trimble.mobile.pmobileapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Messaging_AddressBookPage extends AppiumCommandsPage {

    @FindBy(xpath = "//*[@text='Messaging']")
    private WebElement messagingButton;

    @FindBy(id = "loadingProgressBar")
    private WebElement progressBar;

    @FindBy(id = "pnetpage_homebutton_imagebutton")
    private WebElement peoplenetLogo;

    @FindBy(id = "PMobile.Android:id/pnetpage_titletext_textview")
    private WebElement messagingInboxLabel;

    @FindBy(id = "PMobile.Android:id/pnetpage_backbutton_imagebutton")
    private WebElement backButton;

    @FindBy(xpath = "//*[@text='Inbox']")
    private WebElement inboxButton;

    @FindBy(id = "PMobile.Android:id/MessageFolderCountText")
    private WebElement inboxCount;

    @FindBy(xpath = "//*[@text='Saved']")
    private WebElement savedButton;

    @FindBy(id = "MessageFolderCountText")
    private WebElement savedCount;

    @FindBy(xpath = "//*[@text='Outbox']")
    private WebElement outboxButton;

    @FindBy(id = "MessageFolderCountText")
    private WebElement outboxCount;

    @FindBy(xpath = "//*[@text='Sent']")
    private WebElement sentButton;

    @FindBy(id = "MessageFolderCountText")
    private WebElement sentCount;

    @FindBy(xpath = "//*[@text='Drafts']")
    private WebElement draftsButton;

    @FindBy(xpath = "//*[@text='Messaging - Drafts']")
    private WebElement messagingDraftsLabel;

    @FindBy(xpath = "//*[@text='Messaging - Sent']")
    private WebElement messagingSentLabel;

    @FindBy(id = "MessageFolderCountText")
    private WebElement draftscount;

    @FindBy(id = "PMobile.Android:id/MessagePreviewText")
    private WebElement mailMessageContent;

    @FindBy(id = "PMobile.Android:id/MessageSubjectText")
    private WebElement mailType;

    @FindBy(id = "PMobile.Android:id/MessageFromText")
    private WebElement mailRecipients;

    @FindBy(xpath = "//*[@text='Contacts']")
    private WebElement contactsButton;

    @FindBy(xpath = "//*[@text='Email']")
    private WebElement emailButton;

    @FindBy(xpath = "//*[@text='Form']")
    private WebElement formButton;

    @FindBy(xpath = "//*[@text='Delete' or @text='DELETE']")
    private WebElement deleteButton;

    @FindBy(id = "PMobile.Android:id/MailboxMessageListView")
    private WebElement mailboxMessageListView;

    @FindBy(xpath = "//*[@class='android.widget.RelativeLayout'][0]")
    private WebElement mailboxFirstMessage;

    //=============== Address Book Locators ===================//

    @FindBy(xpath = "//*[@text='Address Book']")
    private WebElement addressBookLabel;

    @FindBy(id = "PMobile.Android:id/AddressSearchTextBox")
    private WebElement addressSearchTextBox;

    @FindBy(id = "PMobile.Android:id/AddButton")
    private WebElement addContactButton;

    @FindBy(id = "PMobile.Android:id/ContactEmailAddress")
    private WebElement contactEmailAddress;

    @FindBy(id = "PMobile.Android:id/ContactUserName")
    private WebElement contactUsername;

    @FindBy(xpath = "//*[@text='Add Contact']")
    private WebElement addContactLabel;

    @FindBy(xpath = "//*[@text='Edit Contact']")
    private WebElement editContactLabel;

    @FindBy(id = "PMobile.Android:id/NameText")
    private WebElement addContactNameTextBox;

    @FindBy(id = "PMobile.Android:id/EmailText")
    private WebElement addContactEmailTextBox;

    @FindBy(xpath = "//*[@text='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@class='android.widget.CheckedTextView' and @checked='false'] ")
    private WebElement addressBookContactEmail;

    @FindBy(xpath = "//*[@class='android.widget.CheckedTextView' and @checked='true'] ")
    private WebElement addressBookContactEmailChecked;

    @FindBy(xpath = "//*[@class='android.widget.RelativeLayout']//*[@class='android.widget.TextView']")
    private WebElement addressBookContactName;
    //*[@class='android.widget.TextView']

    @FindBy(id = "PMobile.Android:id/ContactSearchText")
    private WebElement recipientsList;

    @FindBy(id = "PMobile.Android:id/alert_message")
    private WebElement recipientsErrorMessage;

    @FindBy(xpath = "//*[@text='OK']")
    private WebElement okButton;

    @FindBy(xpath = "//*[@text='YES']")
    private WebElement yesButton;

    //================= Email Locators =========================//

    @FindBy(xpath = "//*[@text='STANDARD']")
    private WebElement standardButton;

    @FindBy(xpath = "//*[@text='PERSONAL']")
    private WebElement PersonalButton;

    @FindBy(xpath = "//*[@text='CANCEL' or @text='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@text='Create Email']")
    private WebElement createEmailLabel;

    @FindBy(id = "PMobile.Android:id/ContactSearchText")
    private WebElement selectRecipientsTextBox;

    @FindBy(id = "PMobile.Android:id/ContactsButton")
    private WebElement createEmailContactsButton;

    @FindBy(id = "PMobile.Android:id/MessageText")
    private WebElement emailMessageTextBox;

    @FindBy(xpath = "//*[@text='Standard Email']")
    private WebElement standardEmailLabel;

    @FindBy(xpath = "//*[@text='Personal Email']")
    private WebElement personalEmailLabel;

    @FindBy(xpath = "//*[@text='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@text='NOW']")
    private WebElement nowButton;

    @FindBy(xpath = "//*[@text='Accept']")
    private WebElement acceptButton;


    public Messaging_AddressBookPage(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public int getSelectedContactCount() {
        return getCount(addressBookContactEmailChecked);
    }

    public String getSelectedContactList() {
        String xpath = addressBookContactName.toString();
        String[] test = xpath.split(": ");
        xpath = test[1];
        List<WebElement> dropList = appiumDriver.findElements(By.xpath(xpath));
        String temp = "";
        for (int i = 1; i <= 5; i++) {
            WebElement listItem = (WebElement) dropList.get(i);
            String currentValue = listItem.getText();
            temp = temp + currentValue.trim() + "; ";
        }
        return temp;
    }

    public String getRecipientList() {
        return getElementPropertyToString("text", recipientsList) + ";";
    }

    public String getMailBoxRecipientList() {
        return getElementPropertyToString("text", mailRecipients) + ";";
    }

    public String getMailBoxMessage() {
        return getElementPropertyToString("text", mailMessageContent);
    }

    public void addressBookUI() {
        verifyElementPresent(addressBookLabel);
        verifyElementPresent(addressSearchTextBox);
        verifyElementEnabled(addressSearchTextBox);
        verifyElementPresent(addContactButton);
        verifyElementPresent(addressBookContactName);
    }

    public String getaddressBookContactEmail() {
        String contactEmail = getElementPropertyToString("text", addressBookContactEmail);
        if (contactEmail != null)
            return contactEmail;
        else
            return "null";
    }

    public String getaddressBookContactName() {
        return getElementPropertyToString("text", addressBookContactName);
    }

    public void enterAddressSearchTextBox(String username) {
        waitForElementVisibility(addressSearchTextBox);
        enterText(addressSearchTextBox, username);
    }


    public void enterEmailDescription(String mailDescription) {
        enterText(emailMessageTextBox, mailDescription);
    }

    public String getEmailDescription() {
        return getElementPropertyToString("text", emailMessageTextBox);
    }

    public void clickContactsButton() {
        clickElement(contactsButton);
    }

    public void addContact(String contactName, String contactEmail) {
        enterAddressSearchTextBox(contactName);
        if (getaddressBookContactEmail().equalsIgnoreCase("null")) {
            clickElement(addContactButton);
            waitForElementVisibility(addContactLabel);
            enterText(addContactNameTextBox, contactName);
            enterText(addContactEmailTextBox, contactEmail);
            clickElement(submitButton);
        } else {
            deleteContact(contactName, contactEmail);
            addContact(contactName, contactEmail);
        }

    }

    public void deleteContact(String contactName, String contactEmail) {
        clickElement(addressBookContactEmail);
        waitForElementVisibility(editContactLabel);
        clickElement(deleteButton);
        clickElement(yesButton);
    }

    public void EditContact(String contactName, String contactEmail) {
        clickElement(addressBookContactEmail);
        waitForElementVisibility(editContactLabel);
        enterText(addContactEmailTextBox, contactEmail);
        clickElement(submitButton);
    }

    public void clickEmailButton() {
        clickElement(emailButton);
    }

    public void clickMailBoxMesssage() {
        clickElement(mailMessageContent);
    }

    public void clickDeleteButton() {
        clickElement(deleteButton);
    }

    public void clickDraftsButton() {
        clickElement(draftsButton);
        waitForElementVisibility(messagingInboxLabel);
        clickElement(draftsButton);
        waitForElementVisibility(messagingDraftsLabel);
    }

    public void clickSentButton() {
        clickElement(sentButton);
        waitForElementVisibility(messagingSentLabel);
    }

    public void clickSendButton() {
        clickElement(sendButton);
        clickElement(nowButton);
    }

    public void clickInboxButton() {
        clickElement(inboxButton);
    }

    public void selectRecipient(String username) {
        clickElement(selectRecipientsTextBox);
        enterAddressSearchTextBox(username);
        clickElement(addressBookContactEmail);
        clickElement(acceptButton);
    }

    public void clickAcceptButton() {
        clickElement(acceptButton);
    }


    public void clickSelectRecipient() {
        clickElement(selectRecipientsTextBox);
        waitForElementVisibility(addressBookContactName);
    }

    public void selectMultipleRecipients(int count) {
        for (int i = 1; i <= count; i++) {
            if (verifyElementDisplayed(addressBookContactEmail))
                clickElement(addressBookContactEmail);
            else {
                Swipe("UP", 1);
                clickElement(addressBookContactEmail);
            }
        }
    }

    public String getRecipientsErrorMessage() {
        return getElementPropertyToString("text", recipientsErrorMessage);
    }

    public void clickOk() {
        clickElement(okButton);
    }

    public void selectEmailType(String emailType) {
        switch (emailType.trim()) {
            case "Standard":
                waitForElementVisibility(standardButton);
                clickElement(standardButton);
                waitForElementVisibility(standardEmailLabel);
                break;
            case "Personal":
                clickElement(PersonalButton);
                waitForElementVisibility(personalEmailLabel);
                break;
            case "Cancel":
                clickElement(cancelButton);
                waitForElementVisibility(messagingInboxLabel);
                break;
        }
    }

}

