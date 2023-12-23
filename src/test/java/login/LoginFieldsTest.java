package login;


import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.InputActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertTrue;

public class LoginFieldsTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Login screen Username and Password fields alignment\"")
	public void TC_usernamePasswordFieldAlignment() {
		login.usernamePasswordFieldAlignment();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Login screen Username and Password fields Width\"")
	public void TC_usernamePasswordFieldsWidth() {
		login.usernamePasswordFieldsWidth();
	}

	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Login screen Username and Password fields height\"")
	public void TC_usernamePasswordFieldsHeight() {
		login.usernamePasswordFieldsHeight();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies authentication for invalid username and valid password\"")
	public void TC_invalidUsernameValidPassword() {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(4));
		InputActions.clickAndSend(login.password, "Password", DataUtils.password);
		assertTrue(prop.getProperty("AlertLoginFailed"));
		try {
		log("pass", "<span style='color:red'>" + prop.getProperty("AlertLoginFailed") + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for invalid username");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies authentication for empty username and valid password\"")
	public void TC_emptyUsernameValidPassword()  {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(0));
		InputActions.clickAndSend(login.password, "Password", DataUtils.password);
		assertTrue(prop.getProperty("AlertLoginFailed"));
		try {
		log("pass", "<span style='color:red'>"+prop.getProperty("AlertLoginFailed")+"</span>"+" error message is displayed");
	} catch (AssertionError e) {
		log("fail", "Error message is not displayed for Empty username");
	}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies authentication for valid username and invalid password\"")
	public void TC_validUsernameInvalidPassword()  {
		InputActions.clickAndSend(login.username, "Username", username);
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomString(6));
		assertTrue(prop.getProperty("AlertLoginFailed"));
		try {
		log("pass", "<span style='color:red'>"+prop.getProperty("AlertLoginFailed")+"</span>"+" error message is displayed");
	} catch (AssertionError e) {
		log("fail", "Error message is not displayed for invalid Password");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies authentication for valid username and empty password\"")
	public void TC_validUsernameEmptyPassword()  {
		InputActions.clickAndSend(login.username, "Username", DataUtils.username);
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomString(0));
		assertTrue(prop.getProperty("AlertLoginFailed"));
		try {
		log("pass", "<span style='color:red'>"+prop.getProperty("AlertLoginFailed")+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
		log("fail", "Error message is not displayed for empty password");
		}
	}

	@Test(priority = 1, groups = "functional", description = "<em><b>"+"\"This method verifies authentication for valid username and valid password\"")
	public void TC_validUsernameValidPassword()  {
		login.dashboardDisplay();
		log("pass", "Login Successful and Dashboard is displayed");
	}

}
