package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ReportPage extends TestBase {
	
	public ReportPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "clientname")
	public WebElement clientNameField;

	@FindBy(id = "clientname-label")
	public WebElement clientNameLabel;

	@FindBy(id="clientname-helper-text")
	public WebElement clientNameErrorMessage;
	
	@FindBy(id = "username")
	public WebElement userNameField;

	@FindBy(id = "username-label")
	public WebElement userNameLabel;
	
	@FindBy(id="username-helper-text")
	public WebElement userNameErrorMessage;

	@FindBy(id = "vehicleno")
	public WebElement vehicleNumberField;

	@FindBy(id = "vehicleno-label")
	public WebElement vehicleNumberLabel;
	
	@FindBy(id="vehicleno-helper-text")
	public WebElement vehicleNumberErrorMessage;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	List<WebElement> datepickerList;
	
	@FindBy(xpath = "(//input[@id='datetime'])[1]")
	WebElement startDateTime;
	
	@FindBy(xpath = "//input[@name='enddate']")
	WebElement endDateTime;
	
	@FindBy(xpath = "//li[starts-with(@class,'MuiButtonBase-root MuiListItem-root ')]")
	public WebElement dropdownListNumber;

	@FindBy(xpath = "//button[contains(@class,'MuiButton-containedPrimary')]")
	public WebElement generateReportBtn;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchField;

	@FindBy(xpath = "//li[@role='option'][2]")
	public WebElement errorNoRecords;



	public void getDatepickerList() {
		List<String> list = new ArrayList<>();
		actionsPage = new ActionsPage();
		actionsPage.datepicker.click();
		for (int i = 1; i < datepickerList.size(); i++) {
			String records = datepickerList.get(i).getAttribute("data-value");
			list.add(records);
		}
		log("info", "The dropdown list in the datepicker includes the following: ");
		log("info", ""+list);
		InputActions.clickEscape();
	}

	public void selectPreviousDay() {
		actionsPage.clickDatepicker();
		TestWaits.explicitWaitUntilVisible(searchField);
		searchField.sendKeys(prop.getProperty("previousday"));
		if(dropdownListNumber.getText().equals(prop.getProperty("previousday"))) {
			dropdownListNumber.click();
			log("pass", "selected Previous Day in the Datepicker dropdown list");
		} else {
			log("fail", "Not able to select Previous Day in the Datepicker dropdown list");
		}

	}

	public void selectCurrentDay() {
		actionsPage.clickDatepicker();
		TestWaits.explicitWaitUntilVisible(searchField);
		searchField.sendKeys(prop.getProperty("currentday"));
		if(dropdownListNumber.getText().equals(prop.getProperty("currentday"))) {
			dropdownListNumber.click();
			log("pass", "selected Current Day in the Datepicker dropdown list");
		} else {
			log("fail", "Not able to select Current Day in the Datepicker dropdown list");
		}
	}

	public void selectLast2Days() {
		actionsPage.clickDatepicker();
		TestWaits.explicitWaitUntilVisible(searchField);
		searchField.sendKeys(prop.getProperty("last2days"));
		if(dropdownListNumber.getText().equals(prop.getProperty("last2days"))) {
			dropdownListNumber.click();
			log("pass", "selected Last 2 Days in the Datepicker dropdown list");
		} else {
			log("fail", "Not able to select Last 2 days in the Datepicker dropdown list");
		}
	}
	
	public boolean verifyReportTableIsDisplayed() {
		boolean flag = false;
		generateReportBtn.click();
		tablePage = new TablePage();
		if (tablePage.recordPerPageText!=null) {
			log("info", "Report is generated");
			flag=true;
		} else {
			TestWaits.threadSleep(1000);
			Assert.assertTrue(actionsPage.noRecordsErrorMsg.isDisplayed());
			log("info", actionsPage.noRecordsErrorMsg.getText() + " message is displayed in the report");
			flag=false;
		}
		return flag;
	}

	public void verifyNoRecordsErrorMsg(WebElement element, String fieldName) {
		InputActions.clearWebField(element);
		element.click();
		log("info", "Verifying Error Message in "+fieldName);
		InputActions.sendKeys(searchField, "Search Field", "abcdef");
		log("info", "Invalid "+fieldName+" is entered: " + "<b>" + "abcdef");
		String errorMessage = errorNoRecords.getText();
		InputActions.clickEscape();
		if (errorNoRecords!=null) {
			TestUtils.assertEquals(prop.getProperty("ErrorNoRecords"), errorMessage);
			log("pass", "<b>" + errorMessage + "</b>" + " error message is displayed");
		} else {
			log("fail", "<b>" + errorMessage + "</b>" + " error message is not displayed");
		}
	}
	
	

}
