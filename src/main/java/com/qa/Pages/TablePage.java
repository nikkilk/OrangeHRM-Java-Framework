package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TablePage extends TestBase {

	private int rowSize;
	List<String> originalList1 = new ArrayList<>();
	List<String> originalList2 = new ArrayList<>();
	List<String> sortedList1 = new ArrayList<>();
	List<String> sortedList2 = new ArrayList<>();
	List<String> searchList1 = new ArrayList<>();
	List<String> searchList2 = new ArrayList<>();


	private boolean navigationBtnstatus;

	public TablePage() {
		PageFactory.initElements(getDriver(), this);
		actionsPage = new ActionsPage();
	}


	@FindBy(xpath = "//button[@aria-label='Select columns' and @type='button']")
	public WebElement columnsBtn;

	@FindBy(xpath = "//label[normalize-space()='Find column' or normalize-space()='列を検索']")
	WebElement findColumnField;

	@FindBy(xpath = "//input[@placeholder='Column title']")
	WebElement columTitleField;

	@FindBy(xpath = "//button[normalize-space()='Hide all' or normalize-space()='すべて隠す']")
	WebElement columnsHideAllBtn;

	@FindBy(xpath = "//button[normalize-space()='Show all' or normalize-space()='すべて表示']")
	WebElement columnsShowAllBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> columnsToggleBtnList;

	@FindBy(xpath = "//span[contains(@class,'MuiTypography-root MuiTypography')]")
	List<WebElement> columnsToggleTextList;

	@FindBy(xpath = "//*[@role='tooltip']")
	WebElement toolsTooltip;

	@FindBy(xpath = "//button[@aria-label='Show filters']")
	public WebElement filtersBtn;

	@FindBy(xpath = "(//select[starts-with(@class,'MuiNativeSelect-select MuiNativeSelect-standard MuiI')])[1]")
	List<WebElement> filterColumnsDropdown;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement filterTextField;

	@FindBy(xpath = "//label[normalize-space()='Columns' or normalize-space()='列']")
	WebElement filterColumnsLabel;

	@FindBy(xpath = "(//label[normalize-space()='Operators' or normalize-space()='オペレーター'])[2]")
	WebElement filterOperatorsLabel;

	@FindBy(xpath = "(//select[starts-with(@class,'MuiNativeSelect-select MuiNativeSelect-standard MuiI')])[2]")
	List<WebElement> filterOperatorsDropdown;

	@FindBy(xpath = "//label[normalize-space()='Value' or normalize-space()='値']")
	WebElement filterValueLabel;

	@FindBy(xpath = "//button[@title='Delete' or @title='削除']")
	public WebElement filterDeleteBtn;

	@FindBy(xpath = "//div[@id='lock-button']/button")
	public WebElement downloadBtn;

	@FindBy(xpath = "//li")
	public List<WebElement> downloadList;

	@FindBy(xpath = "//li[@tabindex='0']")
	public WebElement downloadCSVFile;

	@FindBy(xpath = "//li[@tabindex='-1']")
	public WebElement downloadPDFFile;

	@FindBy(xpath = "//button[@title='Delete']")
	public WebElement closeBtn;

	@FindBy(xpath = "//*[@class='MuiTablePagination-displayedRows css-1chpzqh']")
	WebElement numberOfRecords;

	@FindBy(xpath = "//*[contains(@class,'MuiTablePagination-select MuiSelect-select')]")
	WebElement recordPerPageDropdown;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	List<WebElement> recordsPerPageList;

	@FindBy(xpath = "//ul[@role='listbox']/li[1]")
	WebElement recordsPerPageEntry1;

	@FindBy(xpath = "//ul[@role='listbox']/li[2]")
	WebElement recordsPerPageEntry2;

	@FindBy(xpath = "//ul[@role='listbox']/li[3]")
	WebElement recordsPerPageEntry3;

	@FindBy(xpath = "//p[starts-with(@class,'MuiTablePagination-selectLabel css-1chpzqh')]")
	public WebElement recordPerPageText;

	@FindBy(xpath = "//p[contains(@class,'MuiTablePagination-displayedRows')]")
	WebElement paginationDisplayedText;

	@FindBy(xpath = "//*[contains(@class,'MuiDataGrid-columnHeaderTitle ')]")
	List<WebElement> tableColumns;

	@FindBy(xpath = "//*[starts-with(@class,'MuiDataGrid-virtualScrollerRenderZone')]/*[@role='row']")
	List<WebElement> tableRows;

	@FindBy(xpath = "//*[starts-with(@class,'MuiDataGrid-virtualScrollerRenderZone')]/*[@role='row'][last()]")
	public WebElement lastTableRow;

	@FindBy(xpath = "//*[@role='row']/div[@role='cell'][2]")
	public List<WebElement> vehicleNoList;

	@FindBy(xpath = "//*[starts-with(@class,'MuiDataGrid-virtualScroller ')]")
	public WebElement table;

	@FindBy(xpath = "//*[starts-with(@class,'MuiDataGrid-virtualScroller ')]")
	public List<WebElement> tables;

	@FindBy(xpath = "(//*[starts-with(@class,'MuiDataGrid-virtualScroller ')])[2]")
	public WebElement table2;

	@FindBy(xpath = "//div[@role='columnheader']")
	List<WebElement> tableHeaders;

	@FindBy(xpath = "//*[@role='columnheader'][3]")
	public WebElement tableHeader;

	@FindBy(xpath = "(//*[@role='columnheader'][3])[2]")
	WebElement tableHeaderSecond;

	@FindBy(xpath = "//*[@role='cell'][3]")
	List<WebElement> tableCell;

	@FindBy(xpath = "//*[@role='cell'][5]")
	List<WebElement> tableCellVideoStatus;

	@FindBy(xpath = "//*[@role='cell'][2]")
	public List<WebElement> tableCell2;

	@FindBy(xpath = "//*[@role='cell'][3]")
	public List<WebElement> tableCell3;

	@FindBy(xpath = "//*[@role='cell'][4]")
	public List<WebElement> tableCell4;

	@FindBy(xpath = "//*[@role='cell'][2]")
	List<WebElement> managementSlNoColumn;

	@FindBy(xpath = "(//*[starts-with(@class,'MuiDataGrid-virtualScrollerRenderZone')])[2]//*[@role='cell'][3]")
	List<WebElement> tableCellSecond;

	@FindBy(xpath = "(//*[@class='MuiDataGrid-main css-1fm09i6'])[2]//*[@class='MuiDataGrid-row']")
	List<WebElement> dynamicTableRows;

	@FindBy(xpath = "//*[@class='MuiDataGrid-main css-1fm09i6']//main")
	WebElement noRecords1;

	@FindBy(xpath = "//div[@class='css-yq1fcm']")
	WebElement noRecords2;

	@FindBy(xpath = "//button[@title='Go to first page']")
	WebElement firstPageBtn;

	@FindBy(xpath = "//button[@title='Go to previous page']")
	WebElement previousPageBtn;

	@FindBy(xpath = "//button[@title='Go to next page']")
	public static WebElement nextPageBtn;

	@FindBy(xpath = "//button[@title='Go to last page']")
	WebElement lastPageBtn;

	@FindBy(xpath = "//*[@aria-label='Select All Rows checkbox']")
	WebElement headerCheckbox;

	@FindBy(xpath = "//*[@aria-label='Select Row checkbox']")
	List<WebElement> checkboxes;

	@FindBy(xpath = "(//button[@title='Sort'])[1]")
	WebElement sortBtn;

	@FindBy(xpath = "//input[@type='text']")
	WebElement searchTextbox;

	@FindBy(xpath = "//*[@data-field='LiveUrl']/button")
	List<WebElement> liveVideoBtn;

	@FindBy(xpath = "//div[@data-field='video']/button")
	List<WebElement> alertVideoBtn;

	@FindBy(xpath = "//h2//button[2]")
	WebElement videoCloseBtn;

	@FindBy(xpath = "//h2//button")
	WebElement alertVideoFullscreenBtn;

	@FindBy(id = "winFullscreen")
	WebElement liveVideoFullscreenBtn;

	@FindBy(xpath = "//div[@data-field='lat']/button")
	List<WebElement> mapItBtn;

	@FindBy(xpath = "//h2//button")
	WebElement mapItCloseBtn;

	@FindBy(xpath = "(//h3)[2]")
	WebElement alertVideoWindowVehicleNoText;

	@FindBy(xpath = "(//h3)[3]")
	WebElement alertVideoWindowVehicleNo;

	@FindBy(xpath = "(//h4)[1]")
	WebElement liveVideoWindowVehicleNoText;

	@FindBy(xpath = "(//h4)[2]")
	WebElement liveVideoWindowVehicleNo;

	public String noRecordsErrorText() {
		String result;
		String noRecords1Text = tablePage.noRecords1.getText();
		String noRecords2Text = tablePage.noRecords2.getText();
		result = noRecords1Text.isEmpty() ? noRecords2Text : noRecords1Text;
		return result;
	}

	// Clicks Columns button
	public void clickColumnsBtn() {
		columnsBtn.click();
	}

	// Verifies Columns menu list
	public void verifyColumnsList() {
		TestWaits.threadSleep(2000);
		InputActions.click(columnsBtn, "Columns toolbar");
		TestWaits.threadSleep(500);
		List<String> list1 = columnsToggleTextList.stream().map(WebElement::getText).collect(Collectors.toList());
		log("info", "The Columns list are  " + list1);
		InputActions.clickEscape();
		List<String> list2 = tableColumns.stream().map(WebElement::getText).collect(Collectors.toList());
		if(list1.contains("Checkbox selection")) {
			list2.add(0, "Checkbox selection");
		}
		log("info", "The table headers are " + list2);
		try {
		TestUtils.assertEquals(list2, list1);
			log("pass", "The columns list matches the table headers");
		} catch (AssertionError e) {
			log("fail", "Columns list does not match table headers");
		}
	}

	// Verifies Columns menu Hide All button
	public void verifyColumnsHideAll() {
		boolean flag=true;
		InputActions.click(columnsBtn, "Columns toolbar");
		InputActions.click(columnsHideAllBtn, "Columns toolbar Hide All button");
		InputActions.clickEscape();
		if(totalNumOfColumnsInTable()>0) {
			flag=false;
			log("fail", "All the table columns are not hidden");
			log("info", "Following columns are displayed: "+tableHeaders);
		} else {
			flag=true;
			log("pass", "All the table columns are hidden");
		}
		TestUtils.assertEquals(true, flag);
	}

	// Verifies Columns menu Show All button
		public void verifyColumnsShowAll() {
			recordPerPageText.click();
			InputActions.click(columnsBtn, "Columns toolbar");
			List<String> list1 = columnsToggleTextList.stream().map(WebElement::getText).collect(Collectors.toList());
			log("info", "The Columns list are  " + list1);
			InputActions.click(columnsShowAllBtn, "Columns toolbar Show All button");
			InputActions.clickEscape();
			List<String> list2 = tableColumns.stream().map(WebElement::getText).collect(Collectors.toList());
			if(list1.contains("Checkbox selection")) {
				list2.add(0, "Checkbox selection");
			}
			log("info", "The table headers are " + list2);
			try {
				TestUtils.assertEquals(list2, list1);
				log("pass", "The columns list matches the table headers");
			} catch(AssertionError e) {
				log("fail", "Columns list does not match table headers");
			}
		}

	// Verifies Filters Columns menu list
	public void verifyFiltersColumnsList() {
		InputActions.click(filtersBtn, "Filters toolbar");
		TestWaits.threadSleep(1000);
		List<String> list1 = filterColumnsDropdown.stream().map(WebElement::getText).collect(Collectors.toList());
		log("info", "Filter Columns dropdown list are " + list1);
		InputActions.clickEscape();
		List<String> list2 = tableColumns.stream().map(WebElement::getText).collect(Collectors.toList());
		log("info", "The headers of the table are     " + list2);
		try {
		Assert.assertTrue(list2.equals(list2));
			log("pass", "The Filter columns list matches the table headers");
		} catch(AssertionError e) {
			log("fail", "Filter columns list does not match the table headers");
		}
		InputActions.clickEscape();
	}

	// Retrieves Filters Operators menu list
	public void getFiltersOperatorsList() {
		InputActions.click(filtersBtn, "Filters toolbar");
		List<String> list = filterOperatorsDropdown.stream().map(WebElement::getText).collect(Collectors.toList());
		log("info", "Filters Operators dropdown list are " + list);
		InputActions.clickEscape();
	}

	// Verifies Filters menu Delete function
	public void verifyFiltersDeleteBtn() {
		InputActions.click(filtersBtn, "Filters toolbar");
		log("info", "Entering data in Filters text field "+"<b>"+"abcd");
		InputActions.sendKeys(filterTextField, "Filters toolbar text field", "abcd");
		InputActions.click(filterDeleteBtn, "Filters toolbar Delete button");
		try {
		TestUtils.assertEquals("", filterDeleteBtn.getText());
			log("pass", "Entered data is cleared from the text field");
		} catch(AssertionError e) {
			log("fail", "Entered data is not cleared from the text field");
		}
	}

	// Retrieves Download menu list
	public void getDownloadList() {
		InputActions.click(downloadBtn, "Download toolbar");
		List<String> list = downloadList.stream().map(WebElement::getText).collect(Collectors.toList());
		log("info", "Download menu list are " + list);
		InputActions.clickEscape();
	}

	// This method downloads CSV file
	public void downloadCSVFile() {
		InputActions.click(downloadBtn, "Download toolbar");
		InputActions.click(downloadCSVFile, "CSV");
		InputActions.clickEscape();
	}

	// This method downloads PDF file
	public void downloadPDFFile() {
		recordPerPageText.click();
		InputActions.click(downloadBtn, "Download toolbar");
		InputActions.click(downloadPDFFile, "PDF");
		InputActions.clickEscape();
		TestWaits.threadSleep(500);
	}

	// Check First Page button status
	public boolean firstPageStatus() {
		if (Integer.parseInt(firstPageBtn.getAttribute("tabindex")) == 0) {
			navigationBtnstatus = firstPageBtn.isEnabled();
		}
		return navigationBtnstatus;
	}

	// Check Previous Page button status
	public boolean previousPageStatus() {
		if (Integer.parseInt(previousPageBtn.getAttribute("tabindex")) == 0) {
			navigationBtnstatus = previousPageBtn.isEnabled();
		}
		return navigationBtnstatus;
	}

	// Check Next Page button status
	public boolean nextPageStatus() {
		if (Integer.parseInt(nextPageBtn.getAttribute("tabindex")) == 0) {
			navigationBtnstatus = nextPageBtn.isEnabled();
		}
		return navigationBtnstatus;
	}

	// Check Last Page button status
	public boolean lastPageStatus() {
		if (Integer.parseInt(lastPageBtn.getAttribute("tabindex")) == 0) {
			navigationBtnstatus = lastPageBtn.isEnabled();
		}
		return navigationBtnstatus;
	}

	// Click First Page Button if enabled
	public void clickFirstPageBtn() {
		if (firstPageStatus()) {
			firstPageBtn.click();
		}
	}

	// Click Previous Page Button if enabled
	public void clickPreviousPageBtn() {
		if (previousPageStatus()) {
			previousPageBtn.click();
		}
	}

	// Click Next Page Button if enabled
	public void clickNextPageBtn() {
		if (nextPageStatus()) {
			nextPageBtn.click();
		}
	}

	// Click Last Page Button if enabled
	public void clickLastPageBtn() {
		if (lastPageStatus()) {
			lastPageBtn.click();
		}
	}

	// This method scrolls down across the table
	// Report, Management
	public void tableScrollDown(String moduleType) {
		TestWaits.threadSleep(500);
		if(moduleType.equalsIgnoreCase("report")) {
		new Actions(getDriver()).moveToElement(table).click().perform();
		} else if(moduleType.equalsIgnoreCase("management")) {
			new Actions(getDriver()).moveToElement(table).build().perform();
		}
		InputActions.scrollByValue(0, 400);
		InputActions.scrollByValue(0, 400);
		InputActions.scrolltoEnd();
		TestWaits.threadSleep(500);
	}

	// This method scrolls down across the table
		// Report, Management
	public void tableScrollUp(String moduleType) {
		TestWaits.threadSleep(500);
		if(moduleType.equalsIgnoreCase("report")) {
		new Actions(getDriver()).moveToElement(table).click().perform();
		} else if(moduleType.equalsIgnoreCase("management")) {
			new Actions(getDriver()).moveToElement(table).build().perform();
		}
		InputActions.scrollByValue(0, -400);
		InputActions.scrollByValue(0, -400);
		InputActions.scrolltoStart();
		TestWaits.threadSleep(500);
	}

	// This method verifies number of rows in a table	
	public int totalNumOfRowsInTable() {
		TestWaits.threadSleep(1000);
		String text = numberOfRecords.getText();
		System.out.println(text);
		String displayedRows = text.substring(text.length()-2);
		displayedRows = displayedRows.replaceAll("\\D", "");
		rowSize = Integer.parseInt(displayedRows);
		log("info", "Total Number of rows count in a table: " + rowSize);
		return rowSize;
	}

	// This method verifies number of rows in a table for Dynamic Status Table
	public int totalNumOfRowsInTable2() {
		rowSize = Integer.parseInt(lastTableRow.getAttribute("data-id"));
		log("info", "Total Number of rows count in a table: " + rowSize);
		return rowSize;
	}

	// This method verifies number of columns in a table
	public int totalNumOfColumnsInTable() {
		int colSize = tableColumns.size();
		log("info", "Total Number of columns count in a table: " + "<b>" + colSize + "</b>");
		for (WebElement e : tableColumns) {
			log("info", e.getText());
		}
		return colSize;
	}

	public String verifyAlertMessage(String moduleType) {
		String result = null;
		if (moduleType.equalsIgnoreCase("report")) {
			result = actionsPage.alertMessage.getText();
		} else if(moduleType.equalsIgnoreCase("others")) {
			String noRecords1Text = tablePage.noRecords1.getText();
			String noRecords2Text = tablePage.noRecords2.getText();
			result = noRecords1Text.isEmpty() ? noRecords2Text : noRecords1Text;
		}
		return result;
	}

	// This method fetches table headers
	public List<String> tableHeaders() {
		List<String> headers = new ArrayList<>();
		for (WebElement e : tableColumns) {
			headers.add(e.getText());
		}
		return headers;
	}

/*	public void VerifyPreviousDayInTable() {
		List<String> list1 = null;
		List<String> list2 = null;
		if (rowSize == 0) {
			Assert.assertEquals(prop.getProperty("ErrorNoRecords"), verifyAlertMessage("report"));
			test("<b>" + prop.getProperty("ErrorNoRecords") + "</b>" + " message is displayed");
		} else {
			do {
				// capture text of all web elements in a table after sorting
				TestWaits.threadSleep(500);
				list1 = tableCell.stream().map(WebElement::getText).collect(Collectors.toList());
				tableScrollDown("management");
				list1 = tableCell.stream().map(WebElement::getText).collect(Collectors.toList());
				tableScrollUp("management");
				if (nextPageStatus()) {
					nextPageBtn.click();
					list1.addAll(tableCell.stream().map(WebElement::getText).collect(Collectors.toList()));
				}
			} while (Integer.parseInt(nextPageBtn.getAttribute("tabindex")) == 0);
			list2 = list1.stream().distinct().collect(Collectors.toList());
			System.out.println(list2);
			System.out.println("dfdfdf "+TestUtils.findPrevDay());
			Assert.assertTrue(list2.contains(findPrevDay()));
			list2.stream().anyMatch(TestUtils.findPrevDay());
			Assert.assertTrue(list2.contains(TestUtils.findPrevDay()));
		}
	}
*/
	public void recordsPerPageText() {
		TestUtils.isDisplayed(recordPerPageText);
		TestUtils.assertEquals(prop.getProperty("RowsPerPage"), recordPerPageText.getText());

	}

	// This method returns record per page entries
	public void recordsperPageEntry() {
		TestWaits.threadSleep(1000);
		InputActions.click(recordPerPageDropdown, "Records per page Dropdown");
		TestWaits.threadSleep(500);
		List<String> list = recordsPerPageList.stream().map(WebElement::getText).collect(Collectors.toList());
		log("info", "Records per page entries are " + list);
		InputActions.clickEscape();
	}

	// This method verifies records per page functionality for all 3 entries
	public void recordsPerPageList() {
		TestWaits.threadSleep(500);
		for (int i = 1; i <= recordsPerPageList.size(); i++) {
			TestWaits.explicitWaitUntilClickable(recordPerPageDropdown, "Records per page dropdown");
			String actualXpath = "//ul[@role='listbox']/li[" + i + "]";
			WebElement element = getDriver().findElement(By.xpath(actualXpath));
			int recordsValue = Integer.parseInt(element.getText());
			log("info", "Selected Records per page: " + "<b>" + recordsValue + "</b>");
			element.click();
			totalNumOfRowsInTable();
			if (rowSize == 0) {
				TestUtils.assertEquals(noRecordsErrorText(), prop.getProperty("ErrorNoRecords"));
				log("info", "<b>" + prop.getProperty("ErrorNoRecords") + "</b>" + " message is displayed");
			} else if (rowSize <= recordsValue) {
				log("pass", "Number of records in table is less than or equal to Records per page");
			} else {
				log("fail", "Number of records in table is greater than Records per page");
			}
			InputActions.scrolltoStart();
		}
		InputActions.refreshPage();
	}

	// This method verifies records per page functionality for Dynamic Status table
	public void recordsPerPageList2() {
		for (int i = 1; i <= recordsPerPageList.size(); i++) {
			TestWaits.explicitWaitUntilClickable(recordPerPageDropdown, "Records per page dropdown");
			String actualXpath = "//ul[@role='listbox']/li[" + i + "]";
			WebElement element = getDriver().findElement(By.xpath(actualXpath));
			int recordsValue = Integer.parseInt(element.getText());
			log("info", "Selected Records per page: " + "<b>" + recordsValue + "</b>");
			element.click();
			totalNumOfRowsInTable2();
			if (rowSize == 0) {
				TestUtils.assertEquals(noRecordsErrorText(), prop.getProperty("ErrorNoRecords"));
				log("info", "<b>" + prop.getProperty("ErrorNoRecords") + "</b>" + " message is displayed");
			} else if (rowSize <= recordsValue) {
				log("pass", "Number of records in table is less than or equal to Records per page");
			} else {
				log("fail", "Number of records in table is greater than Records per page");
			}
		}
		InputActions.refreshPage();
	}

	// This method verifies search functionality
	public void searchFunctionality(String columnName, String searchText, String moduleType) {
		TestWaits.pauseUntilDuration(2);
		actionsPage.waitLoadingIconToDisappear();
		List<WebElement> tableCellValue;
		if(actionsPage.pageHeader2.getText().equalsIgnoreCase(prop.getProperty("VideoStatus"))) {
			tableCellValue = tableCellVideoStatus;
		} else  {
			tableCellValue = tableCell;
		}
		actionsPage.waitLoadingIconToDisappear();
		TestWaits.threadSleep(2000);
		InputActions.click(filtersBtn, "Filters toolbar");
		InputActions.clickAndSend(filterColumnsDropdown.get(0), "Filters toolbar Columns dropdown", columnName);
		InputActions.sendKeys(filterTextField, "Filters toolbar Value Text field", searchText);
		TestWaits.threadSleep(1000);
		InputActions.clickEscape();
		TestWaits.threadSleep(500);
		log("info", "Searching for the "+"<b>"+searchText+" "+columnName);
		totalNumOfRowsInTable();
		TestWaits.threadSleep(500);
		if (rowSize == 0) {
			TestUtils.assertEquals(noRecordsErrorText(), prop.getProperty("ErrorNoRecords"));
			log("info", "<b>" + prop.getProperty("ErrorNoRecords") + "</b>" + " message is displayed");
		} else {
			do {
				// capture text of all web elements in a table after sorting
				sortedList1.addAll(tableCellValue.stream().map(WebElement::getText).collect(Collectors.toList()));
				tableScrollDown(moduleType);
				sortedList1.addAll(tableCellValue.stream().map(WebElement::getText).collect(Collectors.toList()));
				tableScrollUp(moduleType);
				if (nextPageStatus()) {
					nextPageBtn.click();
					sortedList1.addAll(tableCellValue.stream().map(WebElement::getText).collect(Collectors.toList()));
				}
			} while (Integer.parseInt(nextPageBtn.getAttribute("tabindex")) == 0);
			sortedList2 =  sortedList1.stream().distinct().collect(Collectors.toList());
			long listCount = sortedList2.stream().count();
			int filteredCount = (int) listCount;
			log("info", "Number of records present for the searched element: " + filteredCount);
			System.out.println("filteredCount "+filteredCount);
			System.out.println("rowSize is "+rowSize);
			Assert.assertEquals(filteredCount, rowSize);
		}
		InputActions.refreshPage();
	}
	
	public void searchFunctionalityManagement(String columnName, String searchText) {
		TestWaits.pauseUntilDuration(2);
		actionsPage.waitLoadingIconToDisappear();
		InputActions.click(filtersBtn, "Filters toolbar");
		InputActions.clickAndSend(filterColumnsDropdown.get(0), "Filters toolbar Columns dropdown", columnName);
		InputActions.sendKeys(filterTextField, "Filters toolbar Value Text field", searchText);
		TestWaits.threadSleep(1000);
		InputActions.clickEscape();
		TestWaits.threadSleep(500);
		log("info", "Searching for the "+"<b>"+searchText+" "+columnName);
		totalNumOfRowsInTable();
		if (rowSize == 0) {
			TestUtils.assertEquals(noRecordsErrorText(), prop.getProperty("ErrorNoRecords"));
			log("info", "<b>" + prop.getProperty("ErrorNoRecords") + "</b>" + " message is displayed and no records present for the searched value");
		} else {
			do {
				// capture text of all web elements in a table after sorting
				TestWaits.threadSleep(500);
				searchList1.addAll(managementSlNoColumn.stream().map(WebElement::getText).collect(Collectors.toList()));
				tableScrollDown("management");
				searchList1.addAll(managementSlNoColumn.stream().map(WebElement::getText).collect(Collectors.toList()));
				tableScrollUp("management");
				if (nextPageStatus()) {
					new Actions(getDriver()).moveToElement(nextPageBtn).click().perform();
					searchList1.addAll(managementSlNoColumn.stream().map(WebElement::getText).collect(Collectors.toList()));
				}
			} while (Integer.parseInt(nextPageBtn.getAttribute("tabindex")) == 0);
			searchList2 =  searchList1.stream().distinct().collect(Collectors.toList());
			long listCount = searchList2.stream().count();
			int filteredCount = (int) listCount;
			log("info", "Number of records present for the searched element: " + filteredCount);
			Assert.assertEquals(filteredCount, rowSize);
		}
		InputActions.refreshPage();
	}
	
	public void searchFunctionality2(String columnName, String searchText) {
		TestWaits.pauseUntilDuration(2);
		actionsPage.waitLoadingIconToDisappear();
		InputActions.click(filtersBtn, "Filters toolbar");
		InputActions.clickAndSend(filterColumnsDropdown.get(0), "Filters toolbar Columns dropdown", columnName);
		InputActions.sendKeys(filterTextField, "Filters toolbar Value Text field", searchText);
		TestWaits.threadSleep(1000);
		InputActions.clickEscape();
		TestWaits.threadSleep(500);
		log("info", "Searching for the "+"<b>"+searchText+" "+columnName);
		int rowSize = dynamicTableRows.size();
		log("info", "Total Number of rows count in a table: " + rowSize);
		if (rowSize == 0) {
			TestUtils.assertEquals(noRecordsErrorText(), prop.getProperty("ErrorNoRecords"));
			log("info", "<b>" + prop.getProperty("ErrorNoRecords") + "</b>" + " message is displayed");
		} else {
			long elementList = dynamicTableRows.stream().count();
			int filter = (int) elementList;
			log("info", "Number of records present for the searched element: " + filter);
			Assert.assertEquals(filter, rowSize);
		}
		InputActions.refreshPage();
	}

	// This method verifies sort functionality
	public void sortFunctionality(String moduleType) {
		do {
			// capture text of all web elements in a table column and sort into original list
			TestWaits.threadSleep(500);
			originalList1.addAll(tableCell.stream().map(WebElement::getText).collect(Collectors.toList()));
			tableScrollDown(moduleType);
			originalList1.addAll(tableCell.stream().map(WebElement::getText).collect(Collectors.toList()));
			TestWaits.threadSleep(500);
			tableScrollUp(moduleType);
			if (nextPageStatus()) {
				nextPageBtn.click();
				originalList1.addAll(tableCell.stream().map(WebElement::getText).collect(Collectors.toList()));
			}
		} while (Integer.parseInt(nextPageBtn.getAttribute("tabindex")) == 0);
		originalList2 = originalList1.stream().distinct().sorted().collect(Collectors.toList());
		clickFirstPageBtn();
		// click on sort button
		InputActions.mouseHoverandClick(tableHeader, "Table Sort button");
		do {
			// capture text of all web elements in a table after sorting
			TestWaits.threadSleep(500);
			sortedList1.addAll(tableCell.stream().map(WebElement::getText).collect(Collectors.toList()));
			tableScrollDown(moduleType);
			sortedList1.addAll(tableCell.stream().map(WebElement::getText).collect(Collectors.toList()));
			TestWaits.threadSleep(500);
			tableScrollUp(moduleType);
			if (nextPageStatus()) {
				nextPageBtn.click();
				sortedList1.addAll(tableCell.stream().map(WebElement::getText).collect(Collectors.toList()));
			}
		} while (Integer.parseInt(nextPageBtn.getAttribute("tabindex")) == 0);
		sortedList2 =  sortedList1.stream().distinct().collect(Collectors.toList());
		// compare original list vs sorted list
		try {
		Assert.assertEquals(originalList2, sortedList2);
			log("pass", "Table records are sorted");
		} catch(AssertionError e) {
			log("fail", "Table records are not sorted");
		}
		InputActions.refreshPage();
	}
	
	
	
	// This method verifies sort functionality
	public void sortFunctionality2() {
		do {
			// capture text of all web elements in a table column and sort into original list
			originalList1.addAll(tableCellSecond.stream().map(WebElement::getText).collect(Collectors.toList()));
			originalList1.addAll(tableCellSecond.stream().map(WebElement::getText).collect(Collectors.toList()));
			if (nextPageStatus()) {
				nextPageBtn.click();
				originalList1.addAll(tableCellSecond.stream().map(WebElement::getText).collect(Collectors.toList()));
			}
		} while (Integer.parseInt(nextPageBtn.getAttribute("tabindex")) == 0);
		originalList2 = originalList1.stream().distinct().sorted().collect(Collectors.toList());
		clickFirstPageBtn();
		// click on sort button
		InputActions.mouseHoverandClick(tableHeaderSecond, "Table Sort button");
		do {
			// capture text of all web elements in a table after sorting
			sortedList1.addAll(tableCellSecond.stream().map(WebElement::getText).collect(Collectors.toList()));
			sortedList1.addAll(tableCellSecond.stream().map(WebElement::getText).collect(Collectors.toList()));
			if (nextPageStatus()) {
				TestWaits.fluentWait(nextPageBtn);
				nextPageBtn.click();
				sortedList1.addAll(tableCellSecond.stream().map(WebElement::getText).collect(Collectors.toList()));
			}
		} while (Integer.parseInt(nextPageBtn.getAttribute("tabindex")) == 0);
		sortedList2 =  sortedList1.stream().distinct().collect(Collectors.toList());
		// compare original list vs sorted list
		try {
		Assert.assertEquals(originalList2, sortedList2);
			log("pass", "Table records are sorted");
		} catch(AssertionError e) {
			log("fail", "Table records are not sorted");
		}
		InputActions.refreshPage();
	}

	/*
	 * public static void Navigation() throws InterruptedException { WebDriver
	 * driver = WebDriverManager.chromedriver().create();
	 * driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	 * 
	 * List<String> result; do { //capture all web elements into list
	 * List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
	 * //capture text of particular web element and fetch price into list result =
	 * elementList.stream().filter(s->s.getText().contains("Beans")).collect(
	 * Collectors.toList()); result.forEach(a->System.out.println(a));
	 * if(result.size()<1) { Thread.sleep(500);
	 * driver.findElement(By.cssSelector("[aria-label='Next']")).click(); } }
	 * while(result.size()<1); driver.quit(); }
	 */
	
	public void verifyAlertVideo() {
		InputActions.click(alertVideoBtn.get(0), "Alert Video");
		InputActions.click(alertVideoFullscreenBtn, "Video Fullscreen button");
		InputActions.clickEscape();
		try {
		TestUtils.assertEquals(vehicleNoList.get(0).getText(), alertVideoWindowVehicleNo.getText());
			log("pass", "Alert video window verified for the Vehicle Number: " + alertVideoWindowVehicleNo.getText());
		} catch(AssertionError e) {
			log("fail", "Failed to verify Alert video window for the Vehicle Number: " + alertVideoWindowVehicleNo.getText());
		}
		InputActions.click(videoCloseBtn, "Video Close button");
	}
	
	public void verifyLiveVideo() {
		InputActions.click(liveVideoBtn.get(0), "Live Video");
		try {
		TestUtils.assertEquals(vehicleNoList.get(0).getText(), liveVideoWindowVehicleNo.getText());
			log("pass", "Live video window verified for the Vehicle Number: " + liveVideoWindowVehicleNo.getText());
		} catch(AssertionError e) {
			log("fail", "Failed to verify Live video window for the Vehicle Number: " + liveVideoWindowVehicleNo.getText());
		}
		InputActions.clickEscape();
	}
	
	public void verifyMapIt() {
		InputActions.click(mapItBtn.get(0), "Map It");
		try {
		TestUtils.assertEquals(vehicleNoList.get(0).getText(), alertVideoWindowVehicleNo.getText());
			log("pass", "Map It window verified for the Vehicle Number: " + alertVideoWindowVehicleNo.getText());
		} catch (AssertionError e) {
			log("fail", "Failed to verify Map It window for the Vehicle Number: " + alertVideoWindowVehicleNo.getText());
		}
		InputActions.click(mapItCloseBtn, "Map It Close button");
	}

	public String retrieveRecord(String columnName, String searchText, List<WebElement> tableCell) {
		String VehicleNo=null;
		actionsPage.waitLoadingIconToDisappear();
		InputActions.click(filtersBtn, "Filters toolbar");
		InputActions.clickAndSend(filterColumnsDropdown.get(0), "Filters toolbar Columns dropdown", columnName);
		InputActions.sendKeys(filterTextField, "Filters toolbar Value Text field", searchText);
		TestWaits.threadSleep(500);
		InputActions.clickEscape();
		if (tableRows.isEmpty()) {
			Assert.assertTrue(tableRows.size()==0);
			log("info", "<span style='color:red'>" + prop.getProperty("ErrorNoRecords") + "</span>" + " error message is displayed");
		} else {
			TestWaits.threadSleep(1000);
			VehicleNo = tableCell.get(0).getText();
		}
		return VehicleNo;
	}

	public String updateRecord(String columnName, String searchText, WebElement element, String elementName, String elementEdit) {
		actionsPage.waitLoadingIconToDisappear();
		InputActions.click(filtersBtn, "Filters toolbar");
		InputActions.clickAndSend(filterColumnsDropdown.get(0), "Filters toolbar Columns dropdown", columnName);
		InputActions.sendKeys(filterTextField, "Filters toolbar Value Text field", searchText);
		TestWaits.threadSleep(500);
		InputActions.clickEscape();
		if (tableRows.isEmpty()) {
			TestUtils.assertEquals(noRecordsErrorText(), prop.getProperty("ErrorNoRecords"));
			log("fail", "<span style='color:red'>" + prop.getProperty("ErrorNoRecords") + "</span>" + " error message is displayed");
			log("info", "Added record is not displayed in the table");
		} else {
			TestWaits.threadSleep(500);
			tableRows.get(0).click();
			InputActions.clickAndSend(element, elementName, elementEdit);
			actionsPage.clickSaveBtn();
			log("pass", "The record has been updated");
			}
		TestWaits.threadSleep(500);
		return actionsPage.alertMessage.getText();
	}
	
	public String deleteRecord(String columnName, String searchText, WebElement element) {
		actionsPage.waitLoadingIconToDisappear();
		InputActions.click(filtersBtn, "Filters toolbar");
		InputActions.clickAndSend(filterColumnsDropdown.get(0), "Filters toolbar Columns dropdown", columnName);
		InputActions.sendKeys(filterTextField, "Filters toolbar Value Text field", searchText);
		TestWaits.threadSleep(500);
		InputActions.clickEscape();
		if (tableRows.isEmpty()) {
			TestUtils.assertEquals(noRecordsErrorText(), prop.getProperty("ErrorNoRecords"));
			log("info", "<span style='color:red'>" + prop.getProperty("ErrorNoRecords") + "</span>" + " error message is displayed");
		} else {
			TestWaits.threadSleep(1000);
			InputActions.click(checkboxes.get(0), "Checkbox");
			actionsPage.clickDeleteBtn();
			}
		element.click();
		TestWaits.threadSleep(1000);
		log("info", "The record has been Deleted");
		return actionsPage.alertMessage.getText();
	}
	
}
