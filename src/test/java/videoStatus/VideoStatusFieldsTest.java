package videoStatus;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class VideoStatusFieldsTest extends TestBase {

    @BeforeClass
    public void preSetup() {
        init();
		TestWaits.threadSleep(500);
		vehicleReports.videoStatusScreen();
    }


    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status Page URL\"")
    public void TC_videoStatusPageUrl()  {
        TestUtils.verifyPageUrl(prop.getProperty("ReportScreenURL"), "Video Status");
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status Page Title\"")
    public void TC_videoStatusPageTitle()  {
    	TestWaits.threadSleep(500);
		TestUtils.verifyPageTitle("partial", prop.getProperty("vidStatusReport"), "Video Status");
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status Page Header\"")
    public void TC_videoStatusPageHeader() {
    	actionsPage.verifyPageHeader("report", prop.getProperty("VideoStatus"));
    }

	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Video Status Page Logo\"")
	public void TC_videoStatusLogo() {
 		TestUtils.verifyImage("Video Status", System.getProperty("user.dir")+ "/ImageFiles/VideoStatusUnselected.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+ "/ImageFiles/VideoStatusUnselected.png");
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Video Status Generate Report Logo\"")
	public void TC_videoStatusGenerateReportLogo() {
		TestUtils.verifyImage("Video Status", System.getProperty("user.dir")+ "/ImageFiles/GenerateReportIcon.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+ "/ImageFiles/GenerateReportIcon.png");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status tooltip text\"")
	public void TC_videoStatusTooltipText() {
		actionsPage.VerifyTooltipText(actionsPage.videoStatusSubMenu2, prop.getProperty("videoStatus"), "Video Status");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status report table is displayed\"")
	public void TC_videoStatusTable() {
		if(tablePage.tables.size()==0) {
			Assert.assertTrue(true);
			log("pass", "The table is not displayed and a report needs to be generated to display the table");
		} else {
			log("fail", "The table is displayed without generating a report");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status Client Name placeholder text\"")
	public void TC_videoStatusClientPlaceholder() {
		TestUtils.getText(prop.getProperty("cName"), reports.clientNameLabel, "Video Status Client field");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status User Name placeholder text\"")
	public void TC_videoStatusUserPlaceholder() {
		TestUtils.getText(prop.getProperty("uName"), reports.userNameLabel, "Video Status User field");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status Vehicle field placeholder text\"")
	public void TC_videoStatusVehiclePlaceholder() {
		TestUtils.getText(prop.getProperty("vNum"), reports.vehicleNumberLabel, "Video Status Vehicle field");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status Datepicker placeholder text\"")
	public void TC_videoStatusDatePlaceholder() {
		TestUtils.getText(prop.getProperty("selectDate"), actionsPage.datepickerLabel, "Video Status Datepicker field");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status Generate Report button text\"")
	public void TC_videoStatusGenerateReportText() {
		TestUtils.getText(prop.getProperty("generateReport"), reports.generateReportBtn, "Generate Report button");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method fetches Video Status Datepicker list\"")
	public void TC_videoStatusDatepickerList() {
		reports.getDatepickerList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for empty Client Name in the Video Status report\"")
	public void TC_videoStatusEmptyClientName()  {
		reports.verifyReportTableIsDisplayed();
		try {
		assertEquals(prop.getProperty("ErrorRequired"), reports.clientNameErrorMessage.getText());
		log("pass", "<span style='color:red'>"+prop.getProperty("ErrorRequired")+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Client Name");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for empty User Name in the Video Status report\"")
	public void TC_videoStatusEmptyUserName()  {
		reports.verifyReportTableIsDisplayed();
		try {
			assertEquals(prop.getProperty("ErrorRequired"), reports.userNameErrorMessage.getText());
			log("pass", "<span style='color:red'>" + prop.getProperty("ErrorRequired") + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty User Name");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for empty Vehicle Number in the Video Status report\"")
	public void TC_videoStatusEmptyVehicleNumber()  {
		reports.verifyReportTableIsDisplayed();
		try {
		assertEquals(prop.getProperty("ErrorRequired"), reports.vehicleNumberErrorMessage.getText());
		log("pass", "<span style='color:red'>"+prop.getProperty("ErrorRequired")+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Vehicle Number");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for empty Date in the Video Status report\"")
	public void TC_videoStatusEmptyDate()  {
		reports.verifyReportTableIsDisplayed();
		try {
		assertEquals(prop.getProperty("ErrorRequired"), actionsPage.datepickerErrorMessage.getText());
		log("pass", "<span style='color:red'>"+prop.getProperty("ErrorRequired")+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Date");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Search field placeholder text in the Video Status report\"")
	public void TC_videoStatusSearchPlaceholder() {
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

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for invalid Client Name in the Video Status report\"")
	public void TC_videoStatusClientNameError() {
		reports.verifyNoRecordsErrorMsg(reports.clientNameField, "Client Name");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for invalid User Name in the Video Status report\"")
	public void TC_videoStatusUserNameError() {
		reports.verifyNoRecordsErrorMsg(reports.userNameField, "User Name");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates error message for invalid Vehicle Number in the Video Status report\"")
	public void TC_videoStatusVehicleNoRecords() {
		actionsPage.enterDropdown(reports.clientNameField, "Client Name", DataUtils.clientName.get(0), "Client Name");
		actionsPage.enterDropdown(reports.userNameField, "User Name", DataUtils.userName.get(0), "User Name");
		reports.verifyNoRecordsErrorMsg(reports.vehicleNumberField, "Vehicle Number");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Copyright text is displayed in the Video Status report\"")
	public void TC_videoStatusCopyrightText() {
		actionsPage.copyrightisDisplayed();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Video Status report generation\"")
	public void TC_videoStatusGenerateReport() {
		vehicleReports.generateReport(DataUtils.enDate.get(0), DataUtils.enDate.get(1), DataUtils.jaDate.get(0), DataUtils.jaDate.get(1));
	}

}
