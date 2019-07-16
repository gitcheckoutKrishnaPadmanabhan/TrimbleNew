package com.trimble.mobile.pmobileapp.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.mobile.core.appiumcommandbase.AppiumCommandsPage;
import com.trimble.mobile.core.enums.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MediaManagerPage extends AppiumCommandsPage {

	@FindBy(id = "pnetpage_titletext_textview")
	private WebElement toolBarTitle;
	
	@FindBy(xpath="//*[@text='Select the folder path']")
	private WebElement folderSelectPopUpTitle;
	
	@FindBy(xpath="//*[@text='Download']")
	private WebElement downloadOption;
	
	@FindBy(xpath="//*[@text='Pictures']")
	private WebElement picturesOption;
	
	@FindBy(xpath="//*[@text='OK']")
	private WebElement okBtn;
	
	@FindBy(id="PMobile.Android:id/media_text_view_top")
	private WebElement textView;
	
	@FindBy(id="PMobile.Android:id/media_switch_file_loc_btn")
	private WebElement changeFolderBtn;
	
	@FindBy(id="PMobile.Android:id/media_header_filename")
	private WebElement nameColumn;
	
	@FindBy(id="PMobile.Android:id/media_header_size")
	private WebElement sizeColumn;
	
	@FindBy(id="PMobile.Android:id/media_header_date")
	private WebElement dateColumn;
	
	@FindAll(@FindBy(id="PMobile.Android:id/media_fileText"))
	private List<WebElement> nameList;
	
	@FindAll(@FindBy(id="PMobile.Android:id/media_sizeText"))
	private List<WebElement> sizeList;
	
	@FindAll(@FindBy(id="PMobile.Android:id/media_dateText"))
	private List<WebElement> dateList;
	
	@FindBy(id="PMobile.Android:id/media_masterCheckBox")
	private WebElement masterCheckBox;
	
	@FindBy(xpath="//android.widget.ListView[@index='4']/android.widget.LinearLayout")
	private WebElement listView;
	
	@FindAll(@FindBy(xpath="//android.widget.ListView[@index='4']/android.widget.LinearLayout"))
	private List<WebElement> listViewCollection;
	
	@FindAll(@FindBy(id="PMobile.Android:id/media_checkBox"))
	private List<WebElement> listViewCheckBox;
	
	@FindBy(id="PMobile.Android:id/media_delete_btn")
	private WebElement deleteBtn;
	
	@FindBy(id="PMobile.Android:id/media_cancel_btn")
	private WebElement cancelBtn;
	
	@FindBy(id="android:id/alertTitle")
	private WebElement deleteAlerttitle;
	
	@FindBy(id="android:id/message")
	private WebElement deleteAlertmessage;
	
	@FindBy(id="android:id/button2")
	private WebElement cancelMenu;

	@FindBy(id="android:id/button1")
	private WebElement yesMenu;
	
	@FindBy(id="com.sec.android.gallery3d:id/gl_root_view")
	private WebElement imageView;
	
	public MediaManagerPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public Boolean isSelectFolderPathPopUpDisplayed() {
		return verifyElementDisplayed(folderSelectPopUpTitle);
	}
	
	@SuppressWarnings("incomplete-switch")
	public void selectFolderPath(Fields menu) {
		switch (menu) {
			case Download:
				waitForElementVisibility(downloadOption);
				if(verifyElementDisplayed(downloadOption)==true) {
					clickElement(downloadOption);
					clickElement(okBtn);
				}else if(getElementPropertyToString("text",toolBarTitle).equalsIgnoreCase("Media Manager - Pictures")){
					selectChangeFolder();
					clickElement(downloadOption);
					clickElement(okBtn);
				}
				break;
			case Pictures:
				waitForElementVisibility(picturesOption);
				if(verifyElementDisplayed(picturesOption)==true) {
					clickElement(picturesOption);
					clickElement(okBtn);
				}else if(getElementPropertyToString("text",toolBarTitle).equalsIgnoreCase("Media Manager - Downloads")){
					selectChangeFolder();
					clickElement(picturesOption);
					clickElement(okBtn);
				}
				break;
		}
	}
	
	public void waitForFolderAlertTitle() {
		waitForElementVisibility(folderSelectPopUpTitle);
	}
	
	public void verifySelectFolderPathPopUpUI() {
		verifyElementPresent(folderSelectPopUpTitle);
		verifyElementPresent(downloadOption);
		verifyElementPresent(picturesOption);
	}
	
	
	public String isMenuSelected(Fields option) {
		String val = null;
		switch(option) {
			case Download:
				val = getElementPropertyToString("checked",downloadOption);
				break;
			case Pictures:
				val = getElementPropertyToString("checked",picturesOption);
				break;
			default :
				break;
		}
		return val;
	}
	
	public void validateMediaManagerScreenAttribute() {
		verifyElementPresent(textView);
		verifyElementPresent(changeFolderBtn);
		verifyElementPresent(nameColumn);
		verifyElementPresent(sizeColumn);
		verifyElementPresent(dateColumn);
	}

	public Boolean isCancelButtonDisplayed() {
		return verifyElementDisplayed(cancelBtn);
	}
	
	public Boolean isDeleteButtonDisplayed() {
		return verifyElementDisplayed(deleteBtn);	
	}
	
	public void selectChangeFolder() {
		waitForElementVisibility(changeFolderBtn);
		clickElement(changeFolderBtn);
	}
	
	public int getListCount() {
		return getCount(listView);
	}
	
	public void selectSingleImage() {
		longPress(listViewCollection.get(0));
	}
	
	public void selectMultipleImage() {
		longPress(listViewCollection.get(0));
		clickElement(listViewCollection.get(1));
		clickElement(listViewCheckBox.get(2));
	}
	
	public void deselectMultipleImage() {
		longPress(listViewCollection.get(0));
		clickElement(listViewCollection.get(1));
		clickElement(listViewCheckBox.get(2));
	}
	
	public void clickDelete() {
		waitForElementVisibility(deleteBtn);
		clickElement(deleteBtn);
		waitForElementVisibility(folderSelectPopUpTitle);
	}
	
	public void clickCancel() {
		waitForElementVisibility(cancelBtn);
		clickElement(cancelBtn);
		waitForElementVisibility(folderSelectPopUpTitle);
	}
	
	public void selectMenuFromDeleteAlert(Fields menu) {
		switch(menu) {
			case Yes:
				clickElement(yesMenu);
				waitForElementInVisibility(folderSelectPopUpTitle);
				break;
			case Cancel:
				clickElement(cancelMenu);
				waitForElementInVisibility(folderSelectPopUpTitle);
				break;
			default :
				break;
		}						
	}
	
	public void validateDeleteAlertUI() {
		verifyElementPresent(deleteAlerttitle);
		verifyElementPresent(deleteAlertmessage);
		verifyElementPresent(yesMenu);
		verifyElementPresent(cancelMenu);
	}
	
	public void clickCheckAllCheckBox() {
		waitForElementVisibility(masterCheckBox);
		clickElement(masterCheckBox);
	}
	
	public Boolean validateAllCheckBoxAreSelected() {
		Boolean checkBox = false;
		int i=0;
		int count = getListCount();
		while(i<count) {
			if(getElementPropertyToString("checked",listViewCheckBox.get(i)).equalsIgnoreCase("false")) {
				checkBox = false;
				break;
			}else {
				i++;
				checkBox = true;
			}
		}
		return checkBox;
	}
	
	public void viewImage() {
		clickElement(listViewCollection.get(0));
	}
	
	public void waitTillImageLoaded() {
		waitForElementInVisibility(toolBarTitle);
		waitForElementVisibility(imageView);
	}
	
	public void clicklistColumn(Fields menu) {
		switch(menu) {
			case Name:
				clickElement(nameColumn);
				break;
			case Size:
				clickElement(sizeColumn);
				break;
			case Date:
				clickElement(dateColumn);
				break;
		}
	}
	
	public String verifyListHeaderUI(Fields menu) {
		String property=null;
		switch(menu) {
			case Name:
				property= getElementPropertyToString("text",nameColumn);
				break;
			case Size:
				property= getElementPropertyToString("text",sizeColumn);
				break;
			case Date:
				property= getElementPropertyToString("text",dateColumn);
				break;
		}
		return property;

	}
	
	public Boolean isMediaListSorted(Fields menu,SortingType order) {
		int count = getListCount();
		ArrayList<String> list=new ArrayList<String>(); 
		switch(menu) {
			case Name:
				for(int i = 0;i<count;i++) {
					list.add(nameList.get(i).getText());
				}
				break;
			case Size:
				for(int i = 0;i<count;i++) {
					list.add(sizeList.get(i).getText());
				}
				break;
			case Date:
				for(int i = 0;i<count;i++) {
					list.add(dateList.get(i).getText());
				}
				break;
		}
		return checkListIsSorted(list,order);
	}
	
	public void sortMenu(Fields menu) {
		switch(menu) {
			case Name:
				clickElement(nameColumn);
				break;
			case Size:
				clickElement(sizeColumn);
				break;
			case Date:
				clickElement(dateColumn);
				break;
		}
	}
}
