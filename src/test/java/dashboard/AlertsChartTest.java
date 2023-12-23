package dashboard;

import com.qa.Base.TestBase;
import com.qa.Utils.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.InputActions.mouseHoverandPause;
import static com.qa.Utils.InputActions.scrollByValue;
import static com.qa.Utils.TestUtils.colorVerify;

public class AlertsChartTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		scrollByValue(0, 450);

	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Weekly Alert Toggle in the dashboard screen\"")
	public void TC_weeklyAlertsToggleName() {
		TestUtils.getText(prop.getProperty("weekly"), dash.weeklyAlertToggle, "Dashboard Weekly Alert toggle");
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Weekly Alert Toggle background color in the dashboard screen\"")
	public void TC_weeklyAlertsToggleColor()  {
		colorVerify(dash.weeklyAlertToggle, "weekly Alerts", prop.getProperty("ToolbarButtons"));
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Weekly Alert Toggle background color after click in the dashboard screen\"")
	public void TC_weeklyAlertsToggleColorAfterClick() {
		mouseHoverandPause(dash.weeklyAlertToggle, "Weekly Alerts Toggle");
		colorVerify(dash.weeklyAlertToggle, "weekly Alerts Button after click", prop.getProperty("ToolbarButtonsClick"));
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Daily Alert Toggle in the dashboard screen\"")
	public void TC_dailyAlertsToggleName() {
		TestUtils.getText(prop.getProperty("daily"), dash.dailyAlertToggle, "Dashboard Daily Alert toggle");
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Daily Alert Toggle background color in the dashboard screen\"")
	public void TC_dailyAlertsToggleColor()  {
		colorVerify(dash.dailyAlertToggle, "Daily Alerts", prop.getProperty("ToolbarButtons"));
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Daily Alert Toggle background color after click in the dashboard screen\"")
	public void TC_dailyAlertsToggleColorAfterClick() {
		mouseHoverandPause(dash.dailyAlertToggle, "Daily Alerts toggle");
		colorVerify(dash.dailyAlertToggle, "Daily Alerts Button after click", prop.getProperty("ToolbarButtonsClick"));
	}

	@Test(groups = "functional", priority=1, description = "<em><b>"+"\"This method verifies Daily Alert Chart in the dashboard screen\"")
	public void TC_dailyAlertsChart() {
		dash.dailyAlerts();
	}

	@Test(groups = "functional", priority=2, description = "<em><b>"+"\"This method verifies Weekly Alert Chart in the dashboard screen\"")
	public void TC_weeklyAlertsChart() {
		dash.weeklyAlerts();
	}

}
