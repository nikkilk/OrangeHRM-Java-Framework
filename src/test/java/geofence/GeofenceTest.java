package geofence;

import com.qa.Base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Pages.DashboardPage;
import com.qa.Pages.GeofencePage;
import com.qa.Utils.TestUtils;


public class GeofenceTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		dash = new DashboardPage();
		geo = new GeofencePage();
		geo.geofenceScreen();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Geofence screen title\"")
	public void TC_verifyGeofencePageTitle()  {
		TestUtils.verifyPageTitle("partial", prop.getProperty("FmsAdmin"), "Geofence Report");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Geofence screen Records per Page List\"")
	public void TC_geofenceRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}

}
