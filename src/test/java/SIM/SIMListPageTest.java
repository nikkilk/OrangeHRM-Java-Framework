package SIM;

import com.qa.Base.TestBase;
import com.qa.Pages.ActionsPage;
import com.qa.Pages.TablePage;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.InputActions.mouseHoverandPause;
import static com.qa.Utils.TestUtils.colorVerify;

public class SIMListPageTest extends TestBase  {
	
	@BeforeClass
	public void preSetup() {
		init();
		sim.simScreen();
		actionsPage = new ActionsPage();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM screen URL\"")
	public void TC_simPageUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("ManagementScreenURL"), "SIM");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Page Title\"")
	public void TC_simPageTitle()  {
		TestUtils.verifyPageTitle("partial", prop.getProperty("Sim"), "SIM");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Page Header\"")
	public void TC_simPageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("simList"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in SIM Screen\"")
	public void TC_simRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in SIM screen\"")
	public void TC_simRecordsPerPageList() {
		InputActions.refreshPage();
		tablePage.recordsperPageEntry();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM screen Records per Page functionality\"")
	public void TC_simRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM screen Search functionality\"")
	public void TC_simSearch() {
		InputActions.refreshPage();
		actionsPage.waitLoadingIconToDisappear();
		tablePage.searchFunctionalityManagement(prop.getProperty("simType_"), "3G");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM screen Sort functionality\"")
	public void TC_simSort() {
		tablePage.sortFunctionality("management");
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates SIM screen Columns toolbar color\"")
	public void TC_simColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates SIM screen Columns toolbar color after click\"")
	public void TC_simColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "SIM Add screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates SIM screen Columns List\"")
	public void TC_simColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates SIM screen Columns Hide All functionality\"")
	public void TC_simColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates SIM screen Columns Show All functionality\"")
	public void TC_simColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates SIM screen Filters toolbar color\"")
	public void TC_simFiltersBtnColor()  {
		TestWaits.threadSleep(500);
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates SIM screen Filters toolbar color after click\"")
	public void TC_simFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "SIM Add screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates SIM screen Filters toolbar List\"")
	public void TC_simFiltersList() {
		tablePage.verifyFiltersColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates SIM screen Filters toolbar Delete functionality\"")
	public void TC_simFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates SIM screen Download toolbar color\"")
	public void TC_simdownloadBtnColor()  {
		TestWaits.threadSleep(2000);
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates SIM screen Download toolbar color after click\"")
	public void TC_simdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "SIM Add screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates SIM screen Filters toolbar tooltip text\"")
	public void TC_simFiltersTooltip() {
		InputActions.refreshPage();
		tablePage = new TablePage();
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "SIM Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates SIM screen Download toolbar List\"")
	public void TC_simDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates SIM screen CSV Download functionality\"")
	public void TC_simDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates SIM screen PDF Download functionality\"")
	public void TC_simDownloadPDF() {
		tablePage.downloadPDFFile();
	}

	@Test(priority = 3, groups = "functional", description = "<em><b>"+"\"This method verifies SIM screen Upward Arrow button functionality\"")
	public void TC_simUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}
}
