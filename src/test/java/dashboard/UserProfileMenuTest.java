package dashboard;

import com.qa.Base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utils.TestUtils;

public class UserProfileMenuTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"This method verifies Log out functionality")
	public void TC_logOut() {
		actionsPage.clickUserProfileMenu();
		actionsPage.clickLogoutBtn();
		TestUtils.verifyPageTitle("management", prop.getProperty("FmsLogin"), "Login");
		log("info", "Logged out successfully");
	}

}
