package activitySummary;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestWaits;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qa.Utils.InputActions.mouseHoverandPause;
import static com.qa.Utils.TestUtils.colorVerify;

public class ActivitySummaryToolsTest extends TestBase {
	
	@BeforeClass
    public void preSetup() {
        init();
        TestWaits.threadSleep(500);
        vehicleReports.activitySummaryScreen();
        if(vehicleReports.generateReport(DataUtils.enDate.get(0), DataUtils.enDate.get(1), DataUtils.jaDate.get(0), DataUtils.jaDate.get(1))==false) {
        	throw new SkipException("Skipping tests because report data is not available for the selected parameters.");
        }
        InputActions.scrollintoView(vehicleReports.ReportContentHeader);
    }

    @BeforeMethod
    public void beforeMethod() {
        vehicleReports.navigateandGenerateReport(prop.getProperty("activitySummary"), actionsPage.videoStatusSubMenu);
        InputActions.scrollintoView(vehicleReports.ReportContentHeader);
    }
    
    
    @Test(priority = -2, groups = "ui", description = "<em><b>"+"\"This method validates Activity Summary report Columns toolbar color\"")
    public void TC_activitySummaryColumnsBtnColor()  {
       colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Activity Summary report Columns toolbar color after click\"")
    public void TC_activitySummaryColumnsBtnColorAfterClick() {
        mouseHoverandPause(tablePage.columnsBtn, "Activity Summary screen Columns toolbar");
        colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
    }

    @Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report Columns List\"")
    public void TC_activitySummaryColmnsList() {
        tablePage.verifyColumnsList();
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report Columns Hide All functionality\"")
    public void TC_activitySummaryColumnsHideAll() {
    	tablePage.verifyColumnsHideAll();
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report Columns Show All functionality\"")
    public void TC_activitySummaryColumnsShowAll() {
    	tablePage.verifyColumnsShowAll();
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Activity Summary report Filters toolbar color\"")
    public void TC_activitySummaryFiltersBtnColor()  {
        colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Activity Summary report Filters toolbar color after click\"")
    public void TC_activitySummaryFiltersBtnColorAfterClick() {
        mouseHoverandPause(tablePage.filtersBtn, "Activity Summary screen Filters toolbar");
        colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report Filters toolbar List\"")
    public void TC_activitySummaryFiltersList() {
        tablePage.verifyFiltersColumnsList();
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report Filters toolbar Delete functionality\"")
    public void TC_activitySummaryFiltersDeleteBtn() {
        tablePage.verifyFiltersDeleteBtn();
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Activity Summary report Download toolbar color\"")
    public void TC_activitySummarydownloadBtnColor()  {
        TestWaits.threadSleep(2000);
        colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Activity Summary report Download toolbar color after click\"")
    public void TC_activitySummarydownloadBtnColorAfterClick() {
        mouseHoverandPause(tablePage.downloadBtn, "Activity Summary screen Download toolbar");
        colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report Download toolbar List\"")
    public void TC_activitySummaryDownloadList() {
        tablePage.getDownloadList();
        InputActions.clickEscape();
    }
    
    @Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report CSV Download functionality\"")
    public void TC_activitySummaryDownloadCSV() {
        tablePage.downloadCSVFile();
    }

    @Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Activity Summary report PDF Download functionality\"")
    public void TC_activitySummaryDownloadPDF() {
        tablePage.downloadPDFFile();
    }

}
