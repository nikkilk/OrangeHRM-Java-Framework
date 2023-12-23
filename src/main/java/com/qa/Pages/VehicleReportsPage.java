package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.TestWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleReportsPage extends TestBase {

	public VehicleReportsPage() {
		PageFactory.initElements(getDriver(), this);
		actionsPage = new ActionsPage();
		reports = new ReportPage();
	}

	@FindBy(xpath = "//h3[normalize-space()='Report Content' or normalize-space()='レポート内容']")
	public WebElement ReportContentHeader;

	public void videoStatusScreen() {
		actionsPage.clickOnSubMenu2(actionsPage.reportMenu, "Report", actionsPage.vehicleReportSubMenu,"Vehicle", actionsPage.videoStatusSubMenu,"Video Status");
	}

	public void activitySummaryScreen() {
		actionsPage.clickOnSubMenu2(actionsPage.reportMenu, "Report", actionsPage.vehicleReportSubMenu,"Vehicle", actionsPage.videoStatusSubMenu,"Video Status");
	}

	public boolean generateReport(String fromEnDate, String toEnDate, String fromJaDate, String toJaDate) {
//		if(prop.getProperty("LoginType").equalsIgnoreCase("super admin") && prop.getProperty("LoginType").equalsIgnoreCase("command center")) {
			actionsPage.enterDropdown(reports.clientNameField, "Client Name", DataUtils.clientName.get(0), "Client Name");
//		}
//		if(!prop.getProperty("LoginType").equalsIgnoreCase("user")) {
			actionsPage.enterDropdown(reports.userNameField, "User Name", DataUtils.userName.get(0), "User Name");
//		}
		actionsPage.enterDropdown(reports.vehicleNumberField, "Vehicle Number", DataUtils.vehicleNo.get(0), "Vehicle Number");
			TestWaits.threadSleep(500);
			actionsPage.datepicker.click();
			TestWaits.threadSleep(500);
			actionsPage.selectCustomDate();
		actionsPage.enterCustomDates(fromEnDate, toEnDate, fromJaDate, toJaDate);
		boolean flag = reports.verifyReportTableIsDisplayed();
		return flag;
	}

	public boolean generateReport1() {
//		if(prop.getProperty("LoginType").equalsIgnoreCase("super admin") && prop.getProperty("LoginType").equalsIgnoreCase("command center")) {
			actionsPage.enterDropdown(reports.clientNameField, "Client Name", DataUtils.clientName.get(0), "Client Name");
//		}
//		if(!prop.getProperty("LoginType").equalsIgnoreCase("user")) {
			actionsPage.enterDropdown(reports.userNameField, "User Name", DataUtils.userName.get(0), "User Name");
//		}
		actionsPage.enterDropdown(reports.vehicleNumberField, "Vehicle Number", DataUtils.vehicleNo.get(0), "Vehicle Number");
		TestWaits.threadSleep(500);
		actionsPage.datepicker.click();
		TestWaits.threadSleep(500);
		actionsPage.previousDay.click();
		boolean flag = reports.verifyReportTableIsDisplayed();
		return flag;
	}

	public void navigateandGenerateReport(String reportName, WebElement element) {
		if (!actionsPage.pageHeader2.getText().equals(reportName)) {
			TestWaits.threadSleep(1000);
			element.click();
			generateReport(DataUtils.enDate.get(0), DataUtils.enDate.get(1), DataUtils.jaDate.get(0), DataUtils.jaDate.get(1));
		}
	}

}