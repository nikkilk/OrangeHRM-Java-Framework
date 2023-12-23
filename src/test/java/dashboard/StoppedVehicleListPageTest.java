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

public class StoppedVehicleListPageTest extends TestBase  {
	
	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		if(dash.stoppedCount()==0) {
			log("skip", "There are no Stopped Vehicles in the Stopped Vehicle List screen, so we are skipping those tests");
			throw new SkipException("Skip Exception");
		}
		actionsPage = new ActionsPage();
	}

	@BeforeMethod
	public void beforeMethod() {
		TestWaits.threadSleep(1000);
		if(!actionsPage.pageHeader1.getText().equalsIgnoreCase(prop.getProperty("Stopped"))) {
			InputActions.scrollByValue(0, -400);
			dash.stoppedViewDetails();
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicle List screen URL\"")
	public void TC_stoppedVehicleListUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("DashboardURL")+"#", "Stopped Vehicle List screen");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicle List Page Title\"")
	public void TC_stoppedVehicleListTitle()  {
		TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsDashboard"), "Stopped Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicle List Page Header\"")
	public void TC_stoppedVehiclePageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("Stopped"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in Stopped Vehicle List Screen\"")
	public void TC_stoppedVehicleListRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(priority=3, groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Stopped Vehicle List screen\"")
	public void TC_stoppedVehicleListRecordsPerPageList() {
		tablePage.recordsperPageEntry();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicle List screen Records per Page functionality\"")
	public void TC_stoppedVehicleListRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicle List screen Search functionality\"")
	public void TC_stoppedVehicleListSearch() {
		tablePage.searchFunctionalityManagement(prop.getProperty("Vehicle"), "72082");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicle List screen Sort functionality\"")
	public void TC_stoppedVehicleListSort() {
		tablePage.sortFunctionality("report");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicle screen Upward Arrow button functionality\"")
	public void TC_stoppedVehicleUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Columns toolbar color\"")
	public void TC_stoppedVehicleListColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Columns toolbar color after click\"")
	public void TC_stoppedVehicleListColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "Stopped Vehicle List screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Columns List\"")
	public void TC_stoppedVehicleListColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Columns Hide All functionality\"")
	public void TC_stoppedVehicleListColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Columns Show All functionality\"")
	public void TC_stoppedVehicleListColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Filters toolbar color\"")
	public void TC_stoppedVehicleListFiltersBtnColor()  {
		TestWaits.threadSleep(500);
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Filters toolbar color after click\"")
	public void TC_stoppedVehicleListFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "Stopped Vehicle List screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Filters toolbar List\"")
	public void TC_stoppedVehicleListFiltersList() {
		tablePage.verifyFiltersColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Filters toolbar Delete functionality\"")
	public void TC_stoppedVehicleListFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Download toolbar color\"")
	public void TC_stoppedVehicleListdownloadBtnColor()  {
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Download toolbar color after click\"")
	public void TC_stoppedVehicleListdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "Stopped Vehicle List screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Filters toolbar tooltip text\"")
	public void TC_stoppedVehicleListFiltersTooltip() {
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "Stopped Vehicle List Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen Download toolbar List\"")
	public void TC_stoppedVehicleListDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen CSV Download functionality\"")
	public void TC_stoppedVehicleListDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Stopped Vehicle List screen PDF Download functionality\"")
	public void TC_stoppedVehicleListDownloadPDF() {
		tablePage.downloadPDFFile();
	}

}
