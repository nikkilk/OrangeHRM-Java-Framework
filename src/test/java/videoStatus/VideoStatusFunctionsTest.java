package videoStatus;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.TestWaits;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VideoStatusFunctionsTest extends TestBase {

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



    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed on Report generation\"")
    public void TC_videoStatusRecordsPerPageText() {
        tablePage.recordsPerPageText();
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Video Status Report\"")
    public void TC_videoStatusRecordsPerPageList() {
        tablePage.recordsperPageEntry();
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Records per Page functionality in Video Status screen\"")
    public void TC_videoStatusRecordsPerPage() {
        tablePage.recordsPerPageList();
    }

    @Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method verifies Video Status report Search functionality\"")
    public void TC_videoStatusSearch() {
    	tablePage.searchFunctionality(prop.getProperty("AlerType"), "Sharp turn", "report");
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status report Sort functionality\"")
	public void TC_videoStatusSort() {
		tablePage.sortFunctionality("report");
	}
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status report Upward Arrow button functionality\"")
    public void TC_videoStatusUpwardArrowBtn() {
    	actionsPage.verifyUpwardArrowBtn();
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status report Alert Video functionality\"")
    public void TC_videoStatusAlertVideo() {
    	tablePage.verifyAlertVideo();
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Video Status report Map It functionality\"")
    public void TC_videoStatusMapIt() {
    	tablePage.verifyMapIt();
    }
    
}
