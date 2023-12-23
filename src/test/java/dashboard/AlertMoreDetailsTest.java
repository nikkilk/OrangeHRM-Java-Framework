package dashboard;

import com.qa.Base.TestBase;
import com.qa.Utils.InputActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.InputActions.scrollByValue;

public class AlertMoreDetailsTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
		scrollByValue(0, 250);
	}
	
	
//	@Test(priority=-1)
	public void TC_moreDetailsScreen() {
		
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Records per Page functionality in Dashboard, Alerts More Details screen\"")
	public void TC_moreDetailsRecordsPerPage() {
		InputActions.click(dash.moreDetails, "More Details");
		tablePage.recordsPerPageList();
	}

}


