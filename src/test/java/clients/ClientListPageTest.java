package clients;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.ActionsPage;
import com.qa.Utils.TestUtils;


public class ClientListPageTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		client.clientsScreen();
		actionsPage = new ActionsPage();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients screen URL\"")
	public void TC_clientsPageUrl()  {
		TestUtils.verifyPageUrl(prop.getProperty("ManagementScreenURL"), "Clients");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients screen Title\"")
	public void TC_clientsPageTitle()  {
		TestUtils.verifyPageTitle("partial", prop.getProperty("Clients"), "Clients");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients screen Records per Page functionality\"")
	public void TC_clientsRecordsPerPage()  {
		tablePage.recordsPerPageList();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients screen Search functionality\"")
	public void TC_clientsSearch() {
		tablePage.searchFunctionalityManagement(prop.getProperty("city"), "Bangalore");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients screen Sort functionality\"")
	public void TC_clientSort() {
		tablePage.sortFunctionality("management");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients screen Upward Arrow button functionality\"")
	public void TC_clientUpwardArrowBtn() {
		actionsPage.verifyUpwardArrowBtn();
	}
	
}
