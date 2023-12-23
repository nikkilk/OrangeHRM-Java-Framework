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

public class InactiveVehicleListPageTest extends TestBase  {

	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		if(dash.inactiveCount()==0) {
			log("skip", "There are no Inactive Vehicles in the Inactive Vehicle List screen, so we are skipping those tests");
			throw new SkipException("Skip Exception");
		}
		actionsPage = new ActionsPage();
	}

	@BeforeMethod
	public void beforeMethod() {
		TestWaits.threadSleep(1000);
		if(!actionsPage.pageHeader1.getText().equalsIgnoreCase(prop.getProperty("Inactive"))) {
			InputActions.scrollByValue(0, -400);
			dash.inactiveViewDetails();
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicle List screen URL\"")
	public void TC_inactiveVehicleListUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("DashboardURL")+"#", "Inactive Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicle List Page Title\"")
	public void TC_inactiveVehicleListTitle()  {
		TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsDashboard"), "Inactive Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicle List Page Header\"")
	public void TC_inactiveVehiclePageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("Inactive"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in Inactive Vehicle List Screen\"")
	public void TC_inactiveVehicleListRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(priority=3, groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Inactive Vehicle List screen\"")
	public void TC_inactiveVehicleListRecordsPerPageList() {
		tablePage.recordsperPageEntry();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicle List screen Records per Page functionality\"")
	public void TC_inactiveVehicleListRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicle List screen Search functionality\"")
	public void TC_inactiveVehicleListSearch() {
		tablePage.searchFunctionalityManagement(prop.getProperty("Vehicle"), "72082");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicle List screen Sort functionality\"")
	public void TC_inactiveVehicleListSort() {
		tablePage.sortFunctionality("report");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicle screen Upward Arrow button functionality\"")
	public void TC_inactiveVehicleUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Columns toolbar color\"")
	public void TC_inactiveVehicleListColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Columns toolbar color after click\"")
	public void TC_inactiveVehicleListColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "Inactive Vehicle List screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Columns List\"")
	public void TC_inactiveVehicleListColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Columns Hide All functionality\"")
	public void TC_inactiveVehicleListColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Columns Show All functionality\"")
	public void TC_inactiveVehicleListColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Filters toolbar color\"")
	public void TC_inactiveVehicleListFiltersBtnColor()  {
		TestWaits.threadSleep(500);
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Filters toolbar color after click\"")
	public void TC_inactiveVehicleListFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "Inactive Vehicle List screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Filters toolbar List\"")
	public void TC_inactiveVehicleListFiltersList() {
		tablePage.verifyFiltersColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Filters toolbar Delete functionality\"")
	public void TC_inactiveVehicleListFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Download toolbar color\"")
	public void TC_inactiveVehicleListdownloadBtnColor()  {
		TestWaits.threadSleep(2000);
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Download toolbar color after click\"")
	public void TC_inactiveVehicleListdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "Inactive Vehicle List screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Filters toolbar tooltip text\"")
	public void TC_inactiveVehicleListFiltersTooltip() {
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "Inactive Vehicle List Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen Download toolbar List\"")
	public void TC_inactiveVehicleListDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen CSV Download functionality\"")
	public void TC_inactiveVehicleListDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicle List screen PDF Download functionality\"")
	public void TC_inactiveVehicleListDownloadPDF() {
		tablePage.downloadPDFFile();
	}

}
