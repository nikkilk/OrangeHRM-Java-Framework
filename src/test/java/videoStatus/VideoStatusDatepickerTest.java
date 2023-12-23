package videoStatus;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestWaits;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class VideoStatusDatepickerTest extends TestBase {

    @BeforeClass
    public void preSetup() {
        init();
        TestWaits.threadSleep(500);
        vehicleReports.videoStatusScreen();
    }

    @BeforeMethod
    public void setup() {
        InputActions.refreshPage();
        actionsPage.videoStatusSubMenu.click();

    }

 //   @Test(groups = "functional", description = "<em><b>"+"\"This method verifies report generation for the previous day\"")
    public void TC_videoStatusPreviousDay() {
        vehicleReports.generateReport1();
 //       tablePage.VerifyPreviousDayInTable();
   //     test("<b>"+prop.getProperty("ErrorEqualdate")+"</b>"+" alert message is displayed");
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates alert message for the same From and To dates\"")
    public void TC_videoStatusSameFromToDates() {
        vehicleReports.generateReport(DataUtils.enDate.get(1), DataUtils.enDate.get(1), DataUtils.jaDate.get(1), DataUtils.jaDate.get(1));
        TestWaits.explicitWaitUntilVisible(actionsPage.alertMessage);
        try {
        assertEquals(prop.getProperty("ErrorEqualdate"), actionsPage.alertMessage.getText());
        log("pass", "<b>"+prop.getProperty("ErrorEqualdate")+"</b>"+" alert message is displayed");
        } catch (AssertionError e) {
            log("fail", "If the From date and To dates are same, no error message is displayed");
        }

    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates that future dates are disabled in the From and To date pickers\"")
    public void TC_videoStatusFutureDate() {
        vehicleReports.generateReport(DataUtils.enDate.get(2), DataUtils.enDate.get(3), DataUtils.jaDate.get(2), DataUtils.jaDate.get(3));
        if(tablePage.tables.size()==0) {
            log("pass", "Future dates are disabled in the From and To date pickers");
        } else {
            log("fail", "Future dates are not disabled in the From and To date pickers");
        }
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates Dates greater than three months past are disabled in the From and To date pickers\"")
    public void TC_videoStatusPastDate() {
        vehicleReports.generateReport(DataUtils.jaDate.get(4), DataUtils.jaDate.get(5), DataUtils.jaDate.get(4), DataUtils.jaDate.get(5));
        if(tablePage.tables.size()==0) {
            log("pass", "Dates greater than three months past are disabled in the From and To dates");
        } else {
            log("fail", "Dates greater than three months past are not disabled in the From and To dates");
        }
    }

    @Test(groups = "functional", description = "<em><b>"+"\"This method validates alert message for the From date greater than the To date\"")
    public void TC_videoStatusGreaterFromDate() {
        vehicleReports.generateReport(DataUtils.enDate.get(1), DataUtils.enDate.get(0), DataUtils.jaDate.get(1), DataUtils.jaDate.get(0));
        TestWaits.explicitWaitUntilVisible(actionsPage.alertMessage);
        try {
            assertEquals(prop.getProperty("ErrorDateTime"), actionsPage.alertMessage.getText());
            log("pass", "<b>" + prop.getProperty("ErrorDateTime") + "</b>" + " alert message is displayed");
        } catch (AssertionError e) {
            log("fail", "If the From date is greater than the To date, no error message is displayed");
        }
    }
}
