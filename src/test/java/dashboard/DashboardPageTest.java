package dashboard;

import com.qa.Base.TestBase;
import com.qa.Utils.ElementUtils;
import com.qa.Utils.ExtentReport;
import com.qa.Utils.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;
import static com.qa.Utils.TestUtils.verifyImage;

public class DashboardPageTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Dashboard Page Title\"")
	public void TC_dashboardTitle() {
		TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsDashboard"), "Dashboard");
	}

	@Test(groups = "functional" , description = "<em><b>"+"\"This method verifies Dashboard Page URL\"")
	public void TC_dashboardUrl() {
		TestUtils.verifyPageUrl(prop.getProperty("DashboardURL"), "Dashboard");
	}

	public void TC_dashboardHeader() {
		assertEquals(prop.getProperty("FmsDashboard"), actionsPage.pageHeader1.getText());
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Dashboard Page Logo\"")
	public void TC_dashboardPageLogo() {
		verifyImage("Dashboard", System.getProperty("user.dir")+ "/ImageFiles/UyenoLogo.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+ "/ImageFiles/UyenoLogo.png");
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Vehicle Status and Map height in Dashboard screen\"")
	public void TC_dashboardVehicleStatusMapAlignment() {
		dash.verifyVehicleStatusAndMapHeight();
	}
	
//	@Test(groups = "functional", description = "<em><b>"+"\"This method checks for broken links in Dashboard Page\"")
	public void TC_dashboardPageBrokenLinks() {
		ElementUtils.brokenLinks();
	}

}
