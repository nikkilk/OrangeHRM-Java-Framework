package dashboard;

import com.qa.Base.TestBase;
import com.qa.Utils.ExtentReport;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.*;

public class AllVehiclesTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles count\"")
	public void TC_allVehiclesCount()   {
		dash.allCount();
			assertEquals(dash.allCount, dash.totalCount);
		try {
			log("pass", "The total number of vehicles matches the sum of moving, stopped, idle, inactive and operation vehicles");
		} catch (AssertionError e) {
			log("fail", "Moving, stopped, idle, inactive and operating vehicles do not equal the total number of vehicles");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles percent\"")
	public void TC_allVehiclesPercent()   {
		dash.allPercent();
		assertEquals(dash.allPercent, dash.totalPercent);
		try {
		log("pass", "The total percent of vehicles matches the sum of moving, stopped, idle, inactive and operation vehicles");
	} catch (AssertionError e) {
		log("fail", "Moving, stopped, idle, inactive and operating vehicles do not equal the total number of vehicles percent");
	}
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies All Vehicles background color\"")
	public void TC_allVehiclesColor()  {
		colorVerify(dash.allVehiclesColor, "All Vehicles", prop.getProperty("AllVehiclescolor"));
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method validates All Vehicles icon background is displayed\"")
	public void TC_allVehiclesicon()  {
		verifyImage("All Vehicles", System.getProperty("user.dir")+ "/ImageFiles/AllVehiclesIcon.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+ "/ImageFiles/AllVehiclesIcon.png");
	}
	
	@Test(priority=1, groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles View Details hyperlink\"")
	public void TC_allVehiclesViewDetails()  {
		dash.allViewDetails();
	}
	
	@Test(priority=2, groups = "functional", description = "<em><b>"+"\"This method verifies All Vehicles View Map hyperlink\"")
	public void TC_allVehiclesViewonMap() {
		actionsPage.clickBackBtn();
		dash.allViewOnMap();
	}


}
