package dashboard;

import com.qa.Base.TestBase;
import com.qa.Utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.InputActions.mouseHoverandPause;
import static com.qa.Utils.InputActions.scrollByValue;
import static com.qa.Utils.TestUtils.colorVerify;

public class TodaysAlertsTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		scrollByValue(0, 250);
	}
	
	@Test(groups = "functional", description = "<em><b>"+"This method validates Today's Alert table header")
	public void TC_alertTableHeader() {
		String text = dash.todaysAlertText.getText();
			TestUtils.assertEquals(prop.getProperty("TodayAlert"), text);
		try {
			log("pass", text + " Header name is displayed");
		} catch (AssertionError e) {
			log("fail", text + " Header name is not displayed");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"This method validates Today's Alert table recent 5 alerts")
	public void TC_alertTableList() {
		int rows = dash.todaysAlertTableRows.size();
		if(rows>1) {
				Assert.assertTrue((rows - 1) < 6);
			try {
				log("pass", "Recent 5 alerts are displayed in the Today's Alert Table");
			} catch (AssertionError e) {
				log("fail", "Recent 5 alerts are not displayed in the Today's Alert Table");
			}
		} else {
			log("info", "There are no records in the table");
			log("info", "<span style='color:red'>"+tablePage.noRecordsErrorText()+"</span>"+" error message is displayed");
		}
	}
	
	@Test(groups = "ui", description = "<em><b>"+"This method validates Today's Alert table More Details button background color")
	public void TC_moreDetailsBtnColor()  {
		colorVerify(dash.moreDetails, "Toolbar Buttons", prop.getProperty("ToolbarButtons"));
	}

	@Test(groups = "ui", description = "<em><b>"+"This method validates Today's Alert table More Details button background color after click")
	public void TC_moreDetailsBtnColorAfterClick() {
		mouseHoverandPause(dash.moreDetails, "Today's Alerts table More Details");
		colorVerify(dash.moreDetails, "More Details Button after click", prop.getProperty("ToolbarButtonsClick"));
	}

	
}
