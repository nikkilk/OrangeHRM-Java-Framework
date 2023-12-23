package dashboard;

import com.qa.Base.TestBase;
import com.qa.Utils.ExtentReport;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.colorVerify;
import static com.qa.Utils.TestUtils.verifyImage;

public class MovingVehicleTest extends TestBase {
	
	
	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Moving Vehicle icon background Color\"")
	public void TC_movingVehicleColor() {
		colorVerify(dash.movingVehicleColor, "Moving Vehicle", prop.getProperty("MovingVehicle"));
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Moving Vehicles Icon is displayed\"")
	public void TC_movingVehicleicon()  {
		verifyImage("Moving Vehicle", System.getProperty("user.dir")+"/ImageFiles/MovingVehicleIcon.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+"/ImageFiles/MovingVehicleIcon.png");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicles count\"")
	public void TC_movingVehicleCount()   {
		dash.movingCount();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicles percent\"")
	public void TC_movingVehiclePercent()   {
		dash.movingPercent();
	}
	
	@Test(priority = 1, groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicles View Details hyperlink\"")
	public void TC_movingVehicleViewDetails()  {
		dash.movingViewDetails();
	}
	
	@Test(priority = 2, groups = "functional", description = "<em><b>"+"\"This method verifies Moving Vehicles View Map hyperlink\"")
	public void TC_movingVehicleViewonMap() {
		actionsPage.clickBackBtn();
		dash.movingViewOnMap();
	}

}
