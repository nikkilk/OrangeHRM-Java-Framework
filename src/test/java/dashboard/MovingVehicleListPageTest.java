package dashboard;

import com.qa.Base.TestBase;
import com.qa.Pages.ActionsPage;
import com.qa.Pages.DashboardPage;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qa.Utils.InputActions.mouseHoverandPause;
import static com.qa.Utils.TestUtils.colorVerify;

public class MovingVehicleListPageTest extends TestBase  {

	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		if(dash.movingCount()==0) {
			log("skip", "There are no Moving Vehicles in the Moving Vehicle List screen, so we are skipping those tests");
			throw new SkipException("Skip Exception");
		}
		dash = new DashboardPage();
		actionsPage = new ActionsPage();
	}

	@BeforeMethod
	public void beforeMethod() {
		TestWaits.threadSleep(1000);
		try {
			if (!actionsPage.pageHeader1.getText().equalsIgnoreCase(prop.getProperty("Moving"))) {
				InputActions.scrollByValue(0, -400);
				dash.movingViewDetails();
			}
		} catch (Exception e) {

		}
	}


	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicle List screen URL\"")
	public void TC_movingVehicleListUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("DashboardURL")+"#", "Moving Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicle List Page Title\"")
	public void TC_movingVehicleListTitle()  {
		TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsDashboard"), "Moving Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicle List Page Header\"")
	public void TC_movingVehiclePageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("Moving"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in Moving Vehicle List Screen\"")
	public void TC_movingVehicleListRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(priority=3, groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Moving Vehicle List screen\"")
	public void TC_movingVehicleListRecordsPerPageList() {
		tablePage.recordsperPageEntry();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicle List screen Records per Page functionality\"")
	public void TC_movingVehicleListRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicle List screen Search functionality\"")
	public void TC_movingVehicleListSearch() {
		tablePage.searchFunctionalityManagement(prop.getProperty("Vehicle"), "GreenSlow-2");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicle List screen Sort functionality\"")
	public void TC_movingVehicleListSort() {
		tablePage.sortFunctionality("report");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicle screen Upward Arrow button functionality\"")
	public void TC_movingVehicleUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Columns toolbar color\"")
	public void TC_movingVehicleListColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Columns toolbar color after click\"")
	public void TC_movingVehicleListColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "Moving Vehicle List screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Columns List\"")
	public void TC_movingVehicleListColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Columns Hide All functionality\"")
	public void TC_movingVehicleListColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Columns Show All functionality\"")
	public void TC_movingVehicleListColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Filters toolbar color\"")
	public void TC_movingVehicleListFiltersBtnColor()  {
		TestWaits.threadSleep(500);
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Filters toolbar color after click\"")
	public void TC_movingVehicleListFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "Moving Vehicle List screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Filters toolbar List\"")
	public void TC_movingVehicleListFiltersList() {
		tablePage.verifyFiltersColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Filters toolbar Delete functionality\"")
	public void TC_movingVehicleListFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Download toolbar color\"")
	public void TC_movingVehicleListdownloadBtnColor()  {
		TestWaits.threadSleep(2000);
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Download toolbar color after click\"")
	public void TC_movingVehicleListdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "Moving Vehicle List screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Filters toolbar tooltip text\"")
	public void TC_movingVehicleListFiltersTooltip() {
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "Moving Vehicle List Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen Download toolbar List\"")
	public void TC_movingVehicleListDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicle List screen Live Video functionality\"")
	public void TC_movingVehicleListLiveVideo() {
		InputActions.refreshPage();
		tablePage.verifyLiveVideo();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen CSV Download functionality\"")
	public void TC_movingVehicleListDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicle List screen PDF Download functionality\"")
	public void TC_movingVehicleListDownloadPDF() {
		tablePage.downloadPDFFile();
	}

}
