package users;

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

public class UsersListPageTest extends TestBase  {
	
	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage = new ActionsPage();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users screen URL\"")
	public void TC_usersPageUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("ManagementScreenURL"), "Users");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Page Title\"")
	public void TC_usersPageTitle()  {
		TestUtils.verifyPageTitle("partial", prop.getProperty("Users"), "Users");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Page Header\"")
	public void TC_usersPageHeader() {
		actionsPage.verifyPageHeader("management", prop.getProperty("userList"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed in Users Screen\"")
	public void TC_usersRecordsPerPageText() {
		tablePage.recordsPerPageText();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Users screen\"")
	public void TC_usersRecordsPerPageList() {
		InputActions.refreshPage();
		tablePage.recordsperPageEntry();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users screen Records per Page functionality\"")
	public void TC_usersRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users screen Search functionality\"")
	public void TC_usersSearch() {
		InputActions.refreshPage();
		actionsPage.waitLoadingIconToDisappear();
		tablePage.searchFunctionalityManagement(prop.getProperty("Role"), "Super Admin");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users screen Sort functionality\"")
	public void TC_usersSort() {
		tablePage.sortFunctionality("management");
	}

	@Test(priority = -1, groups = "ui", description = "<em><b>"+"\"This method validates Users screen Columns toolbar color\"")
	public void TC_usersColumnsBtnColor()  {
		colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Users screen Columns toolbar color after click\"")
	public void TC_usersColumnsBtnColorAfterClick() {
		mouseHoverandPause(tablePage.columnsBtn, "Users Add screen Columns toolbar");
		colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Users screen Columns List\"")
	public void TC_usersColmnsList() {
		tablePage.verifyColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Users screen Columns Hide All functionality\"")
	public void TC_usersColumnsHideAll() {
		tablePage.verifyColumnsHideAll();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Users screen Columns Show All functionality\"")
	public void TC_usersColumnsShowAll() {
		tablePage.verifyColumnsShowAll();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Users screen Filters toolbar color\"")
	public void TC_usersFiltersBtnColor()  {
		TestWaits.threadSleep(500);
		colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Users screen Filters toolbar color after click\"")
	public void TC_usersFiltersBtnColorAfterClick() {
		mouseHoverandPause(tablePage.filtersBtn, "Users Add screen Filters toolbar");
		colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Users screen Filters toolbar List\"")
	public void TC_usersFiltersList() {
		tablePage.verifyFiltersColumnsList();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Users screen Filters toolbar Delete functionality\"")
	public void TC_usersFiltersDeleteBtn() {
		tablePage.verifyFiltersDeleteBtn();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Users screen Download toolbar color\"")
	public void TC_usersdownloadBtnColor()  {
		TestWaits.threadSleep(2000);
		colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Users screen Download toolbar color after click\"")
	public void TC_usersdownloadBtnColorAfterClick() {
		mouseHoverandPause(tablePage.downloadBtn, "Users Add screen Download toolbar");
		colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Users screen Filters toolbar tooltip text\"")
	public void TC_usersFiltersTooltip() {
		InputActions.refreshPage();
		tablePage = new TablePage();
		actionsPage.VerifyTooltipText(tablePage.filtersBtn, prop.getProperty("toolbarFiltersTooltipShow"), "Video Status Filters");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Users screen Download toolbar List\"")
	public void TC_usersDownloadList() {
		tablePage.getDownloadList();
		InputActions.clickEscape();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Users screen CSV Download functionality\"")
	public void TC_usersDownloadCSV() {
		tablePage.downloadCSVFile();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Users screen PDF Download functionality\"")
	public void TC_usersDownloadPDF() {
		tablePage.downloadPDFFile();
	}

	@Test(priority = 3, groups = "functional", description = "<em><b>"+"\"This method verifies Users screen Upward Arrow button functionality\"")
	public void TC_userUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}
}
