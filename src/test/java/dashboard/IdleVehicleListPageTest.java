package dashboard;

import com.qa.Base.TestBase;
import com.qa.Pages.ActionsPage;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qa.Utils.InputActions.mouseHoverandPause;
import static com.qa.Utils.TestUtils.colorVerify;

public class IdleVehicleListPageTest extends TestBase  {

	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		if(dash.idleCount()==0) {
			log("skip", "There are no Idle Vehicles in the Idle Vehicle List screen, so we are skipping those tests");
			throw new SkipException("Skip Exception");
		}
		actionsPage = new ActionsPage();
	}

	@BeforeMethod
	public void beforeMethod() {
		TestWaits.threadSleep(1000);
		if(!actionsPage.pageHeader1.getText().equalsIgnoreCase(prop.getProperty("Idle"))) {
			InputActions.scrollByValue(0, -400);
			dash.idleViewDetails();
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicle List screen URL\"")
	public void TC_idleVehicleListUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("DashboardURL")+"#", "Idle Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicle List Page Title\"")
	public void TC_idleVehicleListTitle()  {
		TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsDashboard"), "Idle Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicle List Page Header\"")
	public void TC_idleVehiclePageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("Idle"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in Idle Vehicle List Screen\"")
	public void TC_idleVehicleListRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(priority=3, groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Idle Vehicle List screen\"")
	public void TC_idleVehicleListRecordsPerPageList() {
		tablePage.recordsperPageEntry();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicle List screen Records per Page functionality\"")
	public void TC_idleVehicleListRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicle List screen Search functionality\"")
	public void TC_idleVehicleListSearch() {
		tablePage.searchFunctionalityManagement(prop.getProperty("Vehicle"), "72070");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicle List screen Sort functionality\"")
	public void TC_idleVehicleListSort() {
		tablePage.sortFunctionality("report");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicle screen Upward Arrow button functionality\"")
	public void TC_idleVehicleUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Columns toolbar color\"")
	public void TC_idleVehicleListColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Columns toolbar color after click\"")
	public void TC_idleVehicleListColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "Idle Vehicle List screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Columns List\"")
	public void TC_idleVehicleListColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Columns Hide All functionality\"")
	public void TC_idleVehicleListColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Columns Show All functionality\"")
	public void TC_idleVehicleListColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Filters toolbar color\"")
	public void TC_idleVehicleListFiltersBtnColor()  {
		TestWaits.threadSleep(500);
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Filters toolbar color after click\"")
	public void TC_idleVehicleListFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "Idle Vehicle List screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Filters toolbar List\"")
	public void TC_idleVehicleListFiltersList() {
		tablePage.verifyFiltersColumnsList();
		InputActions.refreshPage();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Filters toolbar Delete functionality\"")
	public void TC_idleVehicleListFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Download toolbar color\"")
	public void TC_idleVehicleListdownloadBtnColor()  {
		TestWaits.threadSleep(2000);
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Download toolbar color after click\"")
	public void TC_idleVehicleListdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "Idle Vehicle List screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Filters toolbar tooltip text\"")
	public void TC_idleVehicleListFiltersTooltip() {
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "Idle Vehicle List Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen Download toolbar List\"")
	public void TC_idleVehicleListDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicle List screen Live Video functionality\"")
	public void TC_idleVehicleListLiveVideo() {
		tablePage.verifyLiveVideo();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen CSV Download functionality\"")
	public void TC_idleVehicleListDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicle List screen PDF Download functionality\"")
	public void TC_idleVehicleListDownloadPDF() {
		tablePage.downloadPDFFile();
	}
}
