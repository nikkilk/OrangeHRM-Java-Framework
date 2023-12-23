package activitySummary;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.TestWaits;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivitySummaryFunctionsTest extends TestBase {

    @BeforeClass
    public void preSetup() {
        init();
        TestWaits.threadSleep(500);
        vehicleReports.activitySummaryScreen();
        if(vehicleReports.generateReport(DataUtils.enDate.get(0), DataUtils.enDate.get(1), DataUtils.jaDate.get(0), DataUtils.jaDate.get(1))==false) {
            throw new SkipException("Skipping tests because report data is not available for the selected parameters.");
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        vehicleReports.navigateandGenerateReport(prop.getProperty("activitySummary"), actionsPage.activitySummarySubMenu);
    }



    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per Page text is displayed on Report generation\"")
    public void TC_activitySummaryRecordsPerPageText() {
        tablePage.recordsPerPageText();
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Records per page dropdown list entries in Activity Summary Report\"")
    public void TC_activitySummaryRecordsPerPageList() {
        tablePage.recordsperPageEntry();
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Records per Page functionality in Activity Summary screen\"")
    public void TC_activitySummaryRecordsPerPage() {
        tablePage.recordsPerPageList();
    }

    @Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary report Search functionality\"")
    public void TC_activitySummarySearch() {
    	tablePage.searchFunctionality(prop.getProperty("AlerType"), "Sharp turn", "report");
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary report Sort functionality\"")
	public void TC_activitySummarySort() {
		tablePage.sortFunctionality("report");
	}
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary report Upward Arrow button functionality\"")
    public void TC_activitySummaryUpwardArrowBtn() {
    	actionsPage.verifyUpwardArrowBtn();
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary report Alert Video functionality\"")
    public void TC_activitySummaryAlertVideo() {
    	tablePage.verifyAlertVideo();
    }
    
    @Test(groups = "functional", description = "<em><b>"+"\"This method verifies Activity Summary report Map It functionality\"")
    public void TC_activitySummaryMapIt() {
    	tablePage.verifyMapIt();
    }
    
}
