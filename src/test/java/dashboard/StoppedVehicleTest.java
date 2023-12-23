package dashboard;

import static com.qa.Utils.TestUtils.colorVerify;
import static com.qa.Utils.TestUtils.verifyImage;

import com.qa.Base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utils.ExtentReport;

public class StoppedVehicleTest extends TestBase {
	
	@BeforeClass(alwaysRun = true)
	public void preSetup() {
		init();
		login.dashboardDisplay();
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Stopped Vehicles icon background color\"")
	public void TC_stoppedVehicleColor() {
		colorVerify(dash.stoppedVehicleColor, "Stopped Vehicle", prop.getProperty("StoppedVehicle"));
	}
	
	@Test(groups = "functional", description = "<em><b>"+ "\"This method validates stopped Vehicles icon is displayed\"")
	public void TC_stoppedVehicleicon()  {
		verifyImage("Stopped Vehicle", System.getProperty("user.dir")+"/ImageFiles/StoppedVehicleIcon.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+"/ImageFiles/StoppedVehicleIcon.png");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies stopped Vehicles count\"")
	public void TC_stoppedVehicleCount() {
		dash.stoppedCount();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies stopped Vehicles pervent\"")
	public void TC_stoppedVehiclePercent() {
		dash.stoppedPercent();
	}
	
	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicles View Details hyperlink\"")
	public void TC_stoppedVehicleViewDetails()  {
		dash.stoppedViewDetails();
	}
	
	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method verifies Stopped Vehicles View Map hyperlink\"")
	public void TC_stoppedVehicleViewonMap() {
		actionsPage.clickBackBtn();
		dash.stoppedViewOnMap();
	}

}
