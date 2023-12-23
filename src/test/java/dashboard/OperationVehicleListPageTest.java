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

public class OperationVehicleListPageTest extends TestBase  {

	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		if(dash.operationCount()==0) {
			log("skip", "There are no Operation Vehicles in the Operation Vehicle List screen, so we are skipping those tests");
			throw new SkipException("Skip Exception");
		}
		actionsPage = new ActionsPage();
	}

	@BeforeMethod
	public void beforeMethod() {
		TestWaits.threadSleep(1000);
		if(!actionsPage.pageHeader1.getText().equalsIgnoreCase(prop.getProperty("Working"))) {
			dash.operationViewDetails();
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicle List screen URL\"")
	public void TC_operationVehicleListUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("DashboardURL")+"#", "Operation Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicle List Page Title\"")
	public void TC_operationVehicleListTitle()  {
		TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsDashboard"), "Operation Vehicle List screen");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicle List Page Header\"")
	public void TC_operationVehiclePageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("Working"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in Operation Vehicle List Screen\"")
	public void TC_operationVehicleListRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Operation Vehicle List screen\"")
	public void TC_operationVehicleListRecordsPerPageList() {
		InputActions.refreshPage();
		dash.operationViewDetails();
		tablePage.recordsperPageEntry();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicle List screen Records per Page functionality\"")
	public void TC_operationVehicleListRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicle List screen Search functionality\"")
	public void TC_operationVehicleListSearch() {
		tablePage.searchFunctionalityManagement(prop.getProperty("Vehicle"), "72082");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicle List screen Sort functionality\"")
	public void TC_operationVehicleListSort() {
		tablePage.sortFunctionality("report");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicle screen Upward Arrow button functionality\"")
	public void TC_operationVehicleUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Columns toolbar color\"")
	public void TC_operationVehicleListColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Columns toolbar color after click\"")
	public void TC_operationVehicleListColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "Operation Vehicle List screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Columns List\"")
	public void TC_operationVehicleListColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Columns Hide All functionality\"")
	public void TC_operationVehicleListColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Columns Show All functionality\"")
	public void TC_operationVehicleListColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Filters toolbar color\"")
	public void TC_operationVehicleListFiltersBtnColor()  {
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Filters toolbar color after click\"")
	public void TC_operationVehicleListFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "Operation Vehicle List screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Filters toolbar List\"")
	public void TC_operationVehicleListFiltersList() {
		tablePage.verifyFiltersColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Filters toolbar Delete functionality\"")
	public void TC_operationVehicleListFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Download toolbar color\"")
	public void TC_operationVehicleListdownloadBtnColor()  {
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Download toolbar color after click\"")
	public void TC_operationVehicleListdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "Operation Vehicle List screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Filters toolbar tooltip text\"")
	public void TC_operationVehicleListFiltersTooltip() {
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "Operation Vehicle List Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen Download toolbar List\"")
	public void TC_operationVehicleListDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen CSV Download functionality\"")
	public void TC_operationVehicleListDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Operation Vehicle List screen PDF Download functionality\"")
	public void TC_operationVehicleListDownloadPDF() {
		tablePage.downloadPDFFile();
	}

}
