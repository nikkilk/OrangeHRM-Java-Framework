package dashboard;

import com.qa.Base.TestBase;
import com.qa.Utils.ExtentReport;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.colorVerify;
import static com.qa.Utils.TestUtils.verifyImage;

public class IdleVehicleTest extends TestBase {

	@BeforeClass(alwaysRun = true)
	public void preSetup() {
		init();
		login.dashboardDisplay();
	}

	@Test(groups = "ui", description = "<em><b>"+ "\"This method verifies Idle Vehicles icon background color\"")
	public void TC_idleVehicleColor() {
		colorVerify(dash.idleVehicleColor, "Idle Vehicle", prop.getProperty("IdleVehicle"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Idle Vehicles icon is displayed\"")
	public void TC_idleVehicleicon() {
		verifyImage("Idle Vehicle", System.getProperty("user.dir")+ "/ImageFiles/IdleVehicleIcon.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+"/ImageFiles/IdleVehicleIcon.png");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicles count\"")
	public void TC_idleVehicleCount()   {
		dash.idleCount();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicles percent\"")
	public void TC_idleVehiclePercent()   {
		dash.idlePercent();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicles View Details hyperlink\"")
	public void TC_idleVehicleViewDetails()  {
		dash.idleViewDetails();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method verifies Idle Vehicles View Map hyperlink\"")
	public void TC_idleVehicleViewonMap() {
		actionsPage.clickBackBtn();
		dash.idleViewOnMap();
	}



}
