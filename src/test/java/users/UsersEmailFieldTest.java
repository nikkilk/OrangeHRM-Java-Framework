package users;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class UsersEmailFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method validates Email field placeholder text in the Users Add screen\"")
	public void TC_usersEmailPlaceholderText() {
		TestUtils.getText(prop.getProperty("Email"), user.emailLabel, "Email placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for empty Email field in the Users Add screen\"")
	public void TC_usersEmailEmpty()  {
		InputActions.clickAndSend(user.emailField, "Users screen Email", DataUtils.randomString(0));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), user.emailErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.emailErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Email");
		}
	}
	
	@Test(groups = "functional", description = "\"This method verifies Users Add screen Email field by entering Spaces\"")
	public void TC_usersEmailSpace() {
		InputActions.enterSpace(user.emailField, "Users screen Email");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorSpace"), user.emailErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.emailErrorMsg.getText()+"</span>"+" error message is displayed");
			} catch (AssertionError e) {
				log("fail", "Error message is not displayed for entering space in the Email field");
			}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Email Add screen Email field for the minimum character length\"")
	public void TC_usersEmailMinimumLength()  {
		InputActions.clickAndSend(user.emailField, "Users screen Email", DataUtils.randomString(3));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorEmail"), user.emailErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.emailErrorMsg.getText()+"</span>"+" error message is displayed");
				} catch (AssertionError e) {
					log("fail", "Minimum character length is not defined for the Email field");
				}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Email Add screen Email field for the maximum character length\"")
	public void TC_usersEmailMaximumLength()  {
		InputActions.clickAndSend(user.emailField, "Users screen Email", DataUtils.randomAlphaNumeric(98)+"@gmail.com");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorEmailMax"), user.emailErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.emailErrorMsg.getText()+"</span>"+" error message is displayed");
					} catch (AssertionError e) {
						log("fail", "Maximum character length is not defined for the Email field");
					}
	}

}
