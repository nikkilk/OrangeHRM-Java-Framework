package units;

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

public class UnitsListPageTest extends TestBase  {
	
	@BeforeClass
	public void preSetup() {
		init();
		unit.unitsScreen();
		actionsPage = new ActionsPage();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Units screen URL\"")
	public void TC_unitsPageUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("ManagementScreenURL"), "Units");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Units Page Title\"")
	public void TC_unitsPageTitle()  {
		TestUtils.verifyPageTitle("partial", prop.getProperty("Units"), "Units");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Units Page Header\"")
	public void TC_unitsPageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("unitList"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in Units Screen\"")
	public void TC_unitsRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Units screen\"")
	public void TC_unitsRecordsPerPageList() {
		InputActions.refreshPage();
		tablePage.recordsperPageEntry();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Units screen Records per Page functionality\"")
	public void TC_unitsRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Units screen Search functionality\"")
	public void TC_unitsSearch() {
		InputActions.refreshPage();
		actionsPage.waitLoadingIconToDisappear();
		tablePage.searchFunctionalityManagement(prop.getProperty("simDataUsage"), "123");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Units screen Sort functionality\"")
	public void TC_unitsSort() {
		tablePage.sortFunctionality("management");
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates Units screen Columns toolbar color\"")
	public void TC_unitsColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Units screen Columns toolbar color after click\"")
	public void TC_unitsColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "Units Add screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Units screen Columns List\"")
	public void TC_unitsColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Units screen Columns Hide All functionality\"")
	public void TC_unitsColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Units screen Columns Show All functionality\"")
	public void TC_unitsColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Units screen Filters toolbar color\"")
	public void TC_unitsFiltersBtnColor()  {
		TestWaits.threadSleep(500);
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Units screen Filters toolbar color after click\"")
	public void TC_unitsFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "Units Add screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Units screen Filters toolbar List\"")
	public void TC_simFiltersList() {
		tablePage.verifyFiltersColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Units screen Filters toolbar Delete functionality\"")
	public void TC_unitsFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Units screen Download toolbar color\"")
	public void TC_unitsdownloadBtnColor()  {
		TestWaits.threadSleep(2000);
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Units screen Download toolbar color after click\"")
	public void TC_unitsdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "Units Add screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Units screen Filters toolbar tooltip text\"")
	public void TC_unitsFiltersTooltip() {
		InputActions.refreshPage();
		tablePage = new TablePage();
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "Units Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Units screen Download toolbar List\"")
	public void TC_unitsDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Units screen CSV Download functionality\"")
	public void TC_unitsDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Units screen PDF Download functionality\"")
	public void TC_unitsDownloadPDF() {
		tablePage.downloadPDFFile();
	}

	@Test(priority = 3, groups = "functional", description = "<em><b>"+"\"This method verifies Units screen Upward Arrow button functionality\"")
	public void TC_unitsUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}
}
