package dashboard;

import com.qa.Base.TestBase;
import com.qa.Utils.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.InputActions.scrolltoEnd;

public class DynamicStatusTableTest extends TestBase {
	
	@BeforeClass
	public void preSetup() throws InterruptedException {
		init();
		login.dashboardDisplay();
		scrolltoEnd();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"This method validates Dynamic Status Table header")
	public void TC_dynamicTableHeader() {
		String text = dash.dynamicStatusText.getText();
			TestUtils.assertEquals(prop.getProperty("DynamicStatus"), text);
		try {
			log("pass", text + " Header name is displayed");
		} catch (AssertionError e) {
			log("fail", text + " Header name is not displayed");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"This method validates Dynamic Status Table records per page functionality")
	public void TC_dynamicTableRecordsPerPageTest() {
		tablePage.recordsPerPageList2();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"This method validates Dynamic Status Table search functionality")
	public void TC_dynamicTableSearchTest() {
		tablePage.searchFunctionality2("Acc", "On");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"This method validates Dynamic Status Table Sort functionality")
	public void TC_dynamicTableSortTest() {
		tablePage.sortFunctionality2();
	}
	
	
}
