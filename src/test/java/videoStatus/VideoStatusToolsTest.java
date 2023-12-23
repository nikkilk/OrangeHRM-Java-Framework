package videoStatus;

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

public class VideoStatusToolsTest extends TestBase {
	
	@BeforeClass
    public void preSetup() {
        init();
        TestWaits.threadSleep(500);
        vehicleReports.videoStatusScreen();
        if(vehicleReports.generateReport(DataUtils.enDate.get(0), DataUtils.enDate.get(1), DataUtils.jaDate.get(0), DataUtils.jaDate.get(1))==false) {
        	throw new SkipException("Skipping tests because report data is not available for the selected parameters.");
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        vehicleReports.navigateandGenerateReport(prop.getProperty("videoStatus"), actionsPage.videoStatusSubMenu);
    }
    
    
    @Test(priority = -2, groups = "ui", description = "<em><b>"+"\"This method validates Video Status report Columns toolbar color\"")
    public void TC_videoStatusColumnsBtnColor()  {
       colorVerify(tablePage.columnsBtn, "Columns Toolbar", prop.getProperty("ToolbarButtons"));
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Video Status report Columns toolbar color after click\"")
    public void TC_videoStatusColumnsBtnColorAfterClick() {
        mouseHoverandPause(tablePage.columnsBtn, "Video Status screen Columns toolbar");
        colorVerify(tablePage.columnsBtn, "Columns Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
    }

    @Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates Video Status report Columns List\"")
    public void TC_videoStatusColmnsList() {
        tablePage.verifyColumnsList();
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Video Status report Columns Hide All functionality\"")
    public void TC_videoStatusColumnsHideAll() {
    	tablePage.verifyColumnsHideAll();
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Video Status report Columns Show All functionality\"")
    public void TC_videoStatusColumnsShowAll() {
    	tablePage.verifyColumnsShowAll();
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Video Status report Filters toolbar color\"")
    public void TC_videoStatusFiltersBtnColor()  {
        colorVerify(tablePage.filtersBtn, "Filters Toolbar", prop.getProperty("ToolbarButtons"));
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Video Status report Filters toolbar color after click\"")
    public void TC_videoStatusFiltersBtnColorAfterClick() {
        mouseHoverandPause(tablePage.filtersBtn, "Video Status screen Filters toolbar");
        colorVerify(tablePage.filtersBtn, "Filters Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Video Status report Filters toolbar List\"")
    public void TC_videoStatusFiltersList() {
        tablePage.verifyFiltersColumnsList();
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Video Status report Filters toolbar Delete functionality\"")
    public void TC_videoStatusFiltersDeleteBtn() {
        tablePage.verifyFiltersDeleteBtn();
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Video Status report Download toolbar color\"")
    public void TC_videoStatusdownloadBtnColor()  {
        TestWaits.threadSleep(2000);
        colorVerify(tablePage.downloadBtn, "Download Toolbar", prop.getProperty("ToolbarButtons"));
    }

    @Test(groups = "ui", description = "<em><b>"+"\"This method validates Video Status report Download toolbar color after click\"")
    public void TC_videoStatusdownloadBtnColorAfterClick() {
        mouseHoverandPause(tablePage.downloadBtn, "Video Status screen Download toolbar");
        colorVerify(tablePage.downloadBtn, "Download Toolbar after click", prop.getProperty("ToolbarButtonsClick"));
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Video Status report Download toolbar List\"")
    public void TC_videoStatusDownloadList() {
        tablePage.getDownloadList();
        InputActions.clickEscape();
    }
    
    @Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method validates Video Status report CSV Download functionality\"")
    public void TC_videoStatusDownloadCSV() {
        tablePage.downloadCSVFile();
    }

    @Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method validates Video Status report PDF Download functionality\"")
    public void TC_videoStatusDownloadPDF() {
        tablePage.downloadPDFFile();
    }

}
