package dashboard;

import static com.qa.Utils.TestUtils.colorVerify;
import static com.qa.Utils.TestUtils.verifyImage;

import com.qa.Base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Pages.DashboardPage;
import com.qa.Utils.ExtentReport;

public class OperationVehicleTest extends TestBase {
	public static int operationCount;
	public static int operationPercent;

	@BeforeClass(alwaysRun = true)
	public void preSetup() {
		init();
		login.dashboardDisplay();
		dash = new DashboardPage();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Operation Vehicles icon background color\"")
	public void TC_operationVehicleColor() {
		colorVerify(dash.operationVehicleColor, "Operation Vehicle", prop.getProperty("OperationVehicle"));
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles icon is displayed\"")
	public void TC_operationVehicleicon()  {
		verifyImage("Operation Vehicle", System.getProperty("user.dir")+"/ImageFiles/OperationVehicleIcon.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+"/ImageFiles/OperationVehicleIcon.png");
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicles count\"")
	public void TC_operationVehicleCount()   {
		dash.operationCount();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicles percent\"")
	public void TC_operationVehiclePercent()   {
		dash.operationPercent();
	}

	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicles View Details hyperlink\"")
	public void TC_operationVehicleViewDetails() {
		dash.operationViewDetails();
	}

	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method verifies Operation Vehicles View Map hyperlink\"")
	public void TC_operationVehicleViewonMap()  {
		actionsPage.clickBackBtn();
		dash.operationViewOnMap();
	}
}
