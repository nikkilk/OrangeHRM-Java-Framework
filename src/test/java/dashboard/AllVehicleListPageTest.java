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

public class AllVehicleListPageTest extends TestBase  {

	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		if(dash.allCount()==0) {
			log("skip", "There are no All Vehicles in the All Vehicles List screen, so we are skipping those tests");
			throw new SkipException("Skip Exception");
		}
		actionsPage = new ActionsPage();
	}

	@BeforeMethod
	public void beforeMethod() {
		TestWaits.threadSleep(1000);
		if(!actionsPage.pageHeader1.getText().equalsIgnoreCase(prop.getProperty("AllVehicles")+" List")) {
			dash.allViewDetails();
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles List screen URL\"")
	public void TC_allVehiclesListUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("DashboardURL")+"#", "All Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles List Page Title\"")
	public void TC_allVehiclesListTitle()  {
		TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsDashboard"), "All Vehicles List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles List Page Header\"")
	public void TC_allVehiclesPageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("AllVehicles")+" List");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in All Vehicles List Screen\"")
	public void TC_allVehiclesListRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(priority=3, groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in All Vehicles List screen\"")
	public void TC_allVehiclesListRecordsPerPageList() {
		tablePage.recordsperPageEntry();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles List screen Records per Page functionality\"")
	public void TC_allVehiclesListRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles List screen Search functionality\"")
	public void TC_allVehiclesListSearch() {
		tablePage.searchFunctionalityManagement(prop.getProperty("Vehicle"), "72082");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles List screen Sort functionality\"")
	public void TC_allVehiclesListSort() {
		tablePage.sortFunctionality("report");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles screen Upward Arrow button functionality\"")
	public void TC_allVehiclesUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates All Vehicles List screen Columns toolbar color\"")
	public void TC_allVehiclesListColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates All Vehicles List screen Columns toolbar color after click\"")
	public void TC_allVehiclesListColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "All Vehicles List screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen Columns List\"")
	public void TC_allVehiclesListColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen Columns Hide All functionality\"")
	public void TC_allVehiclesListColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen Columns Show All functionality\"")
	public void TC_allVehiclesListColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates All Vehicles List screen Filters toolbar color\"")
	public void TC_allVehiclesListFiltersBtnColor()  {
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates All Vehicles List screen Filters toolbar color after click\"")
	public void TC_allVehiclesListFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "All Vehicles List screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen Filters toolbar List\"")
	public void TC_allVehiclesListFiltersList() {
		tablePage.verifyFiltersColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen Filters toolbar Delete functionality\"")
	public void TC_allVehiclesListFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates All Vehicles List screen Download toolbar color\"")
	public void TC_allVehiclesListdownloadBtnColor()  {
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates All Vehicles List screen Download toolbar color after click\"")
	public void TC_allVehiclesListdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "All Vehicles List screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen Filters toolbar tooltip text\"")
	public void TC_allVehiclesListFiltersTooltip() {
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "All Vehicle List Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen Download toolbar List\"")
	public void TC_allVehiclesListDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen CSV Download functionality\"")
	public void TC_allVehiclesListDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles List screen PDF Download functionality\"")
	public void TC_allVehiclesListDownloadPDF() {
		tablePage.downloadPDFFile();
	}

}
