package activitySummary;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class ActivitySummaryFieldsTest extends TestBase {

    @BeforeClass
    public void preSetup() {
        init();
		TestWaits.threadSleep(500);
		vehicleReports.activitySummaryScreen();
    }


    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary Page URL\"")
    public void TC_activitySummaryPageUrl()  {
        TestUtils.verifyPageUrl(prop.getProperty("ReportScreenURL"), "Activity Summary");
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary Page Title\"")
    public void TC_activitySummaryPageTitle()  {
    	TestWaits.threadSleep(500);
		TestUtils.verifyPageTitle("partial", prop.getProperty("activitySummary"), "Video Status");
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary Page Header\"")
    public void TC_activitySummaryPageHeader() {
    	actionsPage.verifyPageHeader("report", prop.getProperty("activitySummary"));
    }

//	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Activity Summary Page Logo\"")
	public void TC_activitySummaryLogo() {
 		TestUtils.verifyImage("Activity Summary", System.getProperty("user.dir")+ "/ImageFiles/VideoStatusUnselected.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+ "/ImageFiles/VideoStatusUnselected.png");
	}

//	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Activity Summary Generate Report Logo\"")
	public void TC_activitySummaryGenerateReportLogo() {
		TestUtils.verifyImage("Activity Summary", System.getProperty("user.dir")+ "/ImageFiles/GenerateReportIcon.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+ "/ImageFiles/GenerateReportIcon.png");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary tooltip text\"")
	public void TC_activitySummaryTooltipText() {
		actionsPage.VerifyTooltipText(actionsPage.activitySummarySubMenu2, prop.getProperty("activitySummary"), "Video Status");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary report table is displayed\"")
	public void TC_activitySummaryTable() {
		if(tablePage.tables.size()==0) {
			Assert.assertTrue(true);
			log("pass", "The table is not displayed and a report needs to be generated to display the table");
		} else {
			log("fail", "The table is displayed without generating a report");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary Client Name placeholder text\"")
	public void TC_activitySummaryClientPlaceholder() {
		TestUtils.getText(prop.getProperty("cName"), reports.clientNameLabel, "Activity Summary Client field");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary User Name placeholder text\"")
	public void TC_activitySummaryUserPlaceholder() {
		TestUtils.getText(prop.getProperty("uName"), reports.userNameLabel, "Activity Summary User field");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status Vehicle field placeholder text\"")
	public void TC_activitySummaryVehiclePlaceholder() {
		TestUtils.getText(prop.getProperty("vNum"), reports.vehicleNumberLabel, "Activity Summary Vehicle field");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary Datepicker placeholder text\"")
	public void TC_activitySummaryDatePlaceholder() {
		TestUtils.getText(prop.getProperty("selectDate"), actionsPage.datepickerLabel, "Activity Summary Datepicker field");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary Generate Report button text\"")
	public void TC_activitySummaryGenerateReportText() {
		TestUtils.getText(prop.getProperty("generateReport"), reports.generateReportBtn, "Generate Report button");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method fetches Activity Summary Datepicker list\"")
	public void TC_activitySummaryDatepickerList() {
		reports.getDatepickerList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for empty Client Name in the Activity Summary report\"")
	public void TC_activitySummaryEmptyClientName()  {
		reports.verifyReportTableIsDisplayed();
		try {
		assertEquals(prop.getProperty("ErrorRequired"), reports.clientNameErrorMessage.getText());
		log("pass", "<span style='color:red'>"+prop.getProperty("ErrorRequired")+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Client Name");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for empty User Name in the Activity Summary report\"")
	public void TC_activitySummaryEmptyUserName()  {
		reports.verifyReportTableIsDisplayed();
		try {
			assertEquals(prop.getProperty("ErrorRequired"), reports.userNameErrorMessage.getText());
			log("pass", "<span style='color:red'>" + prop.getProperty("ErrorRequired") + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty User Name");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for empty Vehicle Number in the Activity Summary report\"")
	public void TC_activitySummaryEmptyVehicleNumber()  {
		reports.verifyReportTableIsDisplayed();
		try {
		assertEquals(prop.getProperty("ErrorRequired"), reports.vehicleNumberErrorMessage.getText());
		log("pass", "<span style='color:red'>"+prop.getProperty("ErrorRequired")+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Vehicle Number");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for empty Date in the Activity Summary report\"")
	public void TC_activitySummaryEmptyDate()  {
		reports.verifyReportTableIsDisplayed();
		try {
		assertEquals(prop.getProperty("ErrorRequired"), actionsPage.datepickerErrorMessage.getText());
		log("pass", "<span style='color:red'>"+prop.getProperty("ErrorRequired")+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Date");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Search field placeholder text in the Activity Summary report\"")
	public void TC_activitySummarySearchPlaceholder() {
		InputActions.clearWebField(reports.clientNameField);
		reports.clientNameField.click();
		try {
		assertEquals(prop.getProperty("searchText"), reports.searchField.getAttribute("placeholder"));
		log("pass", "<b>"+prop.getProperty("searchText")+"</b>"+" text is displayed in the Search field placeholder");
		} catch (AssertionError e) {
			log("fail", "Search field placeholder text is not displayed");
		}
		InputActions.clickEscape();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for invalid Client Name in the Activity Summary report\"")
	public void TC_activitySummaryClientNameError() {
		reports.verifyNoRecordsErrorMsg(reports.clientNameField, "Client Name");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for invalid User Name in the Activity Summary report\"")
	public void TC_activitySummaryUserNameError() {
		reports.verifyNoRecordsErrorMsg(reports.userNameField, "User Name");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for invalid Vehicle Number in the Activity Summary report\"")
	public void TC_activitySummaryVehicleNoError() {
		reports.verifyNoRecordsErrorMsg(reports.vehicleNumberField, "Vehicle Number");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Copyright text is displayed in the Activity Summary report\"")
	public void TC_activitySummaryCopyrightText() {
		actionsPage.copyrightisDisplayed();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report generation\"")
	public void TC_activitySummaryGenerateReport() {
		vehicleReports.generateReport(DataUtils.enDate.get(0), DataUtils.enDate.get(1), DataUtils.jaDate.get(0), DataUtils.jaDate.get(1));
	}

}
