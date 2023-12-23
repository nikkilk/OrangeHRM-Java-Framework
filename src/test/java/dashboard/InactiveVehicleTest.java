package dashboard;

import static com.qa.Utils.TestUtils.colorVerify;
import static com.qa.Utils.TestUtils.verifyImage;

import com.qa.Base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utils.ExtentReport;

public class InactiveVehicleTest extends TestBase {
	public static int inactiveCount;
	public static int inactivePercent;
	
	@BeforeClass(alwaysRun = true)
	public void preSetup() {
		init();
		login.dashboardDisplay();
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Inactive Vehicles icon background color\"")
	public void TC_inactiveVehicleColor() {
		colorVerify(dash.inactiveVehicleColor, "Inactive Vehicle", prop.getProperty("InactiveVehicle"));
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Inactive Vehicles icon is displayed\"")
	public void TC_inactiveVehicleicon()  {
		verifyImage("Inactive Vehicle", System.getProperty("user.dir")+"/ImageFiles/InactiveVehicleIcon.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+"/ImageFiles/InactiveVehicleIcon.png");
	}
	
	@Test(groups = "functional", description = "<em><b>"+ "\"This method verifies Inactive Vehicles count\"")
	public void TC_inactiveVehicleCount()   {
		dash.inactiveCount();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicles percent\"")
	public void TC_inactiveVehiclePercent()   {
		dash.inactivePercent();
	}
	
	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicles View Details hyperlink\"")
	public void TC_inactiveVehicleViewDetails()  {
		dash.inactiveViewDetails();
	}
	
	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method verifies Inactive Vehicles View Map hyperlink\"")
	public void TC_inactiveVehicleViewonMap() {
		actionsPage.clickBackBtn();
		dash.inactiveViewOnMap();
	}

	

}
