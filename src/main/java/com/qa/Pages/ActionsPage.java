package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.qa.Utils.TestUtils.assertEquals;
import static com.qa.Utils.TestWaits.explicitWaitUntilClickable;

// ActionsPage class contains Page objects and Methods of all the common functionalities across the application
public class ActionsPage extends TestBase {

	public ActionsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h5")
	public WebElement pageHeader1;

	@FindBy(xpath = "//h3")
	public WebElement pageHeader2;

	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root'])[2]")
	WebElement sideBarMenuBtn;

	@FindBy(xpath = "//img[@alt='dashboard']")
	public WebElement dashboardMenu;

	@FindBy(xpath = "//*[normalize-space()='Track' or normalize-space()='追跡']")
	public WebElement trackMenu;

	@FindBy(xpath = "//li[normalize-space()='On Map' or normalize-space()='地図上']")
	public WebElement onMapSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Video Playback' or normalize-space()='ビデオ再生']")
	public WebElement videoplaybackSubMenu;

	@FindBy(xpath = "//*[normalize-space()='Report' or normalize-space()='レポート']")
	public WebElement reportMenu;

	@FindBy(xpath = "//li[normalize-space()='Custom' or normalize-space()='カスタマイズされた']")
	public WebElement customReportsSubMenu;

	@FindBy(xpath = "//img[@src='assets/Vehicle Daily.svg']")
	public WebElement vehicleDailySubMenu;

	@FindBy(xpath = "//img[@src='assets/Vehicle DailyH.svg']")
	public WebElement vehicleDailySubMenu2;

	@FindBy(xpath = "//img[@src='assets/Vehicle Monthly.svg']")
	public WebElement vehicleMonthlySubMenu;

	@FindBy(xpath = "//img[@src='assets/Vehicle MonthlyH.svg']")
	public WebElement vehicleMonthlySubMenu2;

	@FindBy(xpath = "//img[@src='assets/Driver Daily.svg']")
	public WebElement driverDailySubMenu;

	@FindBy(xpath = "//img[@src='assets/Driver DailyH.svg']")
	public WebElement driverDailySubMenu2;

	@FindBy(xpath = "//li[normalize-space()='Vehicle' or normalize-space()='車両']")
	public WebElement vehicleReportSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Driver' or normalize-space()='運転者']")
	public WebElement driverReportSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Driver' or normalize-space()='運転者']")
	public WebElement driverJourneySummary;

	@FindBy(xpath = "/assets/Speed graph.svg")
	WebElement speedGraphSubMenu;

	@FindBy(xpath = "/assets/Speed graphH.svg")
	public WebElement speedGraphSubMenu2;

	@FindBy(xpath = "//img[@src='/assets/VideoStatus.svg']")
	public WebElement videoStatusSubMenu;

	@FindBy(xpath = "//img[@src='/assets/VideoStatusH.svg']")
	public WebElement videoStatusSubMenu2;

	@FindBy(xpath = "//img[@src='/assets/Activity Summary .svg']")
	public WebElement activitySummarySubMenu;

	@FindBy(xpath = "//img[@src='/assets/Activity Summary H.svg']")
	public WebElement activitySummarySubMenu2;

	@FindBy(xpath = "//img[@src='/assets/Data Usage.svg']")
	public WebElement dataUsageSubMenu;

	@FindBy(xpath = "//img[@src='/assets/Data UsageH.svg']")
	public WebElement dataUsageSubMenu2;

	@FindBy(xpath = "//img[@src='/assets/IdleStop.svg']")
	public WebElement idleStopSubMenu;

	@FindBy(xpath = "//img[@src='/assets/IdleStop.svg']")
	public WebElement idleStopSubMenu2;

	@FindBy(xpath = "//img[@src='/assets/Distance.svg']")
	public WebElement distanceSubMenu;

	@FindBy(xpath = "//img[@src='/assets/Distance.svg']")
	public WebElement distanceSubMenu2;

	@FindBy(xpath = "//img[@src='/assets/Vehicle Journey Summary.svg']")
	public WebElement vehicleJourneySummary;

	@FindBy(xpath = "//img[@src='/assets/Vehicle Journey SummaryH.svg']")
	WebElement vehicleJourneySummary2;

	@FindBy(xpath = "//*[normalize-space()='Management' or normalize-space()='管理']")
	public WebElement managementMenu;

	@FindBy(xpath = "//li[normalize-space()='Clients' or normalize-space()='クライアント']")
	public WebElement clientsSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Users' or normalize-space()='ユーザ']")
	public WebElement usersSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Vehicles' or normalize-space()='車両']")
	public WebElement vehiclesSubMenu;

	@FindBy(xpath = "//li[normalize-space()='SIM']")
	public WebElement simSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Roles' or normalize-space()='役割']")
	public WebElement rolesSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Units' or normalize-space()='ユニット番号']")
	public WebElement unitsSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Driver' or normalize-space()='運転者']")
	public WebElement driverSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Geofence Type' or normalize-space()='ジオフェンスの種類']")
	public WebElement geofenceTypeSubMenu;

	@FindBy(xpath = "//li[normalize-space()='Geofence' or normalize-space()='ジオフェンス']")
	public WebElement geofenceSubMenu;

	@FindBy(xpath = "//*[@title='Go Back' or @title='ホーム']")
	List<WebElement> backBtn;

	@FindBy(xpath = "//button[2]")
	WebElement saveButton;

	@FindBy(xpath = "(//button[@type='button']/span[@class='MuiButton-label'])[2]")
	WebElement cancelButton;

	@FindBy(className = "MuiAlert-message")
	public WebElement alertMessage;

	@FindBy(xpath = "//button[normalize-space()='Confirm' or normalize-space()='確認']")
	public WebElement alertConfirmBtn;

	@FindBy(xpath = "//button[normalize-space()='CANCEL' or normalize-space()='キャンセル']")
	WebElement alertCancelBtn;

	@FindBy(id = "Group_241")
	WebElement upwardArrowButton;

	@FindBy(xpath = "(//button[contains(@class,'MuiButton-containedPrimary')])[1]")
	public WebElement addButton;

	@FindBy(xpath = "(//button[@type='button']/span[@class='MuiButton-label'])[2]")
	WebElement deleteButton;

	@FindBy(xpath = "//div[@role='tooltip']/div")
	WebElement tooltip;

	@FindBy(xpath = "//p")
	WebElement copyrightText1;

	@FindBy(xpath = "//a")
	WebElement copyrightText2;

	@FindBy(id = "basic-button")
	WebElement userProfileMenu;

	@FindBy(xpath = "//li[@role='menuitem'][2]")
	WebElement logoutButton;

	@FindBy(xpath = "//*[@data-testid='TranslateOutlinedIcon']")
	WebElement languageChange;

	@FindBy(xpath = "//*[text()='日本語']")
	WebElement japaneseLang;

	@FindBy(xpath = "//*[text()='EN']")
	WebElement englishLang;

	@FindBy(xpath = "//button[@title='Show street map']")
	WebElement streetMap;

	@FindBy(className = "MuiAlert-message")
	WebElement noRecordsErrorMsg;

	@FindBy(xpath = "//button[@data-testid='error-button-close']")
	WebElement noRecordsErrorMsgClose;

	@FindBy(xpath = "//*[@placeholder='Type to search...' or @placeholder='検索するタイプ...']")
	WebElement searchField;

	@FindBy(xpath = "//li[starts-with(@class,'MuiButtonBase-root MuiListItem-root ')]")
	WebElement dropdownListNumber;

	@FindBy(xpath = "//li[@data-value='Previous Day' or @data-value='前日']")
	public WebElement previousDay;

	@FindBy(xpath = "//li[@data-value='Current Day' or @data-value='今日']")
	WebElement currentDay;

	@FindBy(xpath = "//li[@data-value='Last 2 Days' or @data-value='過去2日間']")
	WebElement last2Days;

	@FindBy(id = "date_range")
	public WebElement datepicker;

	@FindBy(id = "date_range-label")
	public WebElement datepickerLabel;

	@FindBy(id = "date_range-helper-text")
	public WebElement datepickerErrorMessage;

	@FindBy(xpath = "//li[@data-value='Custom Date' or @data-value='カスタマイズ日付']")
	WebElement customDate;

	@FindBy(name = "startdate")
	public WebElement FromDatepicker;

	@FindBy(name = "enddate")
	WebElement ToDatepicker;
	
	@FindBy(xpath = "//*[name()='circle']")
	public List<WebElement> loadingIcon;


	public void waitLoadingIconToDisappear() {
		int count = 0;
		while(!loadingIcon.isEmpty() && count<10) {
			TestWaits.threadSleep(1000);
			count++;
		}
	}
	
	public void clickSidebarMenuButton() {
		TestWaits.explicitWaitUntilClickable(sideBarMenuBtn, "Sidebar menu button");
		TestWaits.threadSleep(500);
	}

	// Click on menu bar by passing name of menu
	public void clickOnMenu(WebElement menu, String elementName) {
		login = new LoginPage();
		login.dashboardDisplay();
		TestWaits.pauseUntilDuration(2);
		TestWaits.explicitWaitUntilClickable(menu, elementName);
	}

	// Click on sub menu bar by passing name of menu
	public void clickOnSubMenu(WebElement menu, String menuName, WebElement submenu, String subMenuName) {
		login = new LoginPage();
		login.dashboardDisplay();
		TestWaits.pauseUntilDuration(2);
		TestWaits.explicitWaitUntilVisible(menu);
		InputActions.click(menu, menuName);
		InputActions.click(submenu, subMenuName);
	}

	// Click on sub menu bar by passing name of menu
	public void clickOnSubMenu2(WebElement menu, String menuName, WebElement submenu1, String subMenuName1, WebElement submenu2, String subMenuName2) {
		login = new LoginPage();
		login.dashboardDisplay();
		TestWaits.pauseUntilDuration(2);
		TestWaits.explicitWaitUntilVisible(menu);
		InputActions.click(menu, menuName);
		InputActions.click(submenu1, subMenuName1);
		InputActions.click(submenu2, subMenuName2);
	}

	// Retrieves page header
	// h5 - for management
	// h3 - for report
	public void verifyPageHeader(String moduleType, String expected) {
		if (moduleType.equalsIgnoreCase("management")) {
			TestWaits.explicitWaitUntilVisible(pageHeader1);
			try {
				assertEquals(expected, pageHeader1.getText());
				log("pass", pageHeader1.getText() + " Page Header name is displayed");
			} catch (AssertionError e) {
				log("fail", "Page Header name is not proper");
			}
		} else if (moduleType.equalsIgnoreCase("report")) {
			TestWaits.explicitWaitUntilVisible(pageHeader2);
			try {
			assertEquals(expected, pageHeader2.getText());
			log("pass", "<b>" + pageHeader2.getText() + "</b>" + " Page Header name is displayed");
		} catch (AssertionError e) {
			log("fail", "Page Header name is not proper");
		}
		}
	}

	// This method is used to enter data in dropdown 
	public void enterDropdown(WebElement element, String elementName, String recordName, String fieldName) {
		InputActions.click(element, elementName);
		InputActions.sendKeys(searchField, "Search", recordName);
		TestWaits.pauseUntilDuration(1);
		InputActions.click(dropdownListNumber, "Dropdown record");
		if(searchField.isDisplayed()) {
			InputActions.clickEscape();
		}
		log("info", "From the dropdown list, the selected " + fieldName + " is: " + "<b>" + recordName + "</b>");
	}

	public void selectCustomDate() {
		TestWaits.explicitWaitUntilVisible(customDate);
		InputActions.click(customDate, "Custom Date");
	}

	public void enterFromDate(String fromDate) {
		InputActions.sendKeys(FromDatepicker, "From Date Picker", fromDate);
	}

	public void enterToDate(String toDate) {
		InputActions.sendKeys(ToDatepicker, "To Date Picker", toDate);
	}

	public void clickDatepicker() {
		datepicker.click();
	}

	// This method is used to enter data in date picker field
	public void enterDatepicker(WebElement element, String enDate, String jaDate) {
		if (prop.getProperty("Language").equalsIgnoreCase("english")) {
			element.sendKeys(enDate);
		} else if (prop.getProperty("Language").equalsIgnoreCase("japanese")) {
			element.sendKeys(jaDate);
		}
	}

	// This method is used to enter data in Custom From and To fields
	public void enterCustomDates(String enFromDate, String enToDate, String jaFromDate, String jaToDate) {
		TestWaits.threadSleep(500);
		if (prop.getProperty("Language").equalsIgnoreCase("english")) {
			enterFromDate(enFromDate);
			enterToDate(enToDate);
		} else if (prop.getProperty("Language").equalsIgnoreCase("japanese")) {
			enterFromDate(jaFromDate);
			enterToDate(jaToDate);
		}
	}

	// Clicks Back button
	public void clickBackBtn() {
		int count = backBtn.size();
		if (count > 0) {
			TestWaits.explicitWaitUntilClickable(backBtn.get(0), "Back button");
		}
	}

	// Clicks Add button
	public void clickAddBtn() {
		InputActions.click(addButton, "Add button");
	}

	// Clicks Delete button
	public void clickDeleteBtn() {
		InputActions.click(deleteButton, "Delete Button");
	}

	// Clicks Save button
	public void clickSaveBtn() {
		InputActions.click(saveButton, "Save button");
	}

	// Clicks Cancel button
	public void clickCancelBtn() {
		cancelButton.click();
	}

	// This method verifies tooltip text
	public void VerifyTooltipText(WebElement element, String expectedText, String elementName) {
		TestWaits.threadSleep(1000);
		InputActions.mouseHoverandPause(element, elementName);
		log("info", "Tooltip text for the " + elementName + " is: " + "<b>" + expectedText);
		try {
			TestUtils.assertEquals(expectedText, tooltip.getText());
			log("pass", "The tooltip text appears correctly");
		} catch (AssertionError e) {
			log("fail", "Tooltip text appears incorrectly");
		}
	}

	// Verifies Copyright text displayed in a page
	public void copyrightisDisplayed() {
		if(copyrightText1.isDisplayed() && copyrightText2.isDisplayed()) {
			log("pass", "A copyright text is displayed on the page");
			log("info", "<b>"+copyrightText1.getText());
			Assert.assertTrue(true);
		} else {
			log("fail", "A copyright text is not displayed on the page");
			Assert.assertTrue(false);
		}
	}

	// This method verifies Upward arrow button functionality
	public void verifyUpwardArrowBtn() {
		InputActions.scrollByValue(0, 400);
		InputActions.scrollByValue(0, 400);
		InputActions.scrolltoEnd();
		TestWaits.threadSleep(1000);
		log("info", "The page is scrolled to the end");
		InputActions.click(upwardArrowButton, "Upward Arrow button");
		if(TestUtils.isDisplayed(saveButton)) {
			log("pass", "As the upward arrow button was clicked, the page scrolled to the top");
		} else {
			log("fail", "Clicking the upward arrow button did not scroll the page up");
		}
	}
	
	public void selectJapanese() {
		explicitWaitUntilClickable(languageChange, "Language menu");
		explicitWaitUntilClickable(japaneseLang, "Japanese Language menu");
	}

	public void selectEnglish() {
		explicitWaitUntilClickable(languageChange, "Language menu");
		explicitWaitUntilClickable(englishLang, "English Language menu");
	}

	public void clickUserProfileMenu() {
		InputActions.click(userProfileMenu, "User Profile Menu");
	}

	public void clickLogoutBtn() {
		InputActions.click(logoutButton, "Logout Button");
	}
	
}
