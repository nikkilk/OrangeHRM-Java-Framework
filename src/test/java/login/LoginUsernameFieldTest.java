package login;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class LoginUsernameFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
	}
	
	@Test(groups = "functional", description ="<em><b>"+ "\"This method verifies Username field Placeholder text in the Login screen\"")
	public void TC_loginUsernamePlaceholderText() {
		TestUtils.getText(prop.getProperty("Username"), login.usernameText, "Username placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Username in the Login screen\"")
	public void TC_loginUsernameEmpty() {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(0));
		InputActions.click(login.loginButton, "Login button");
		assertEquals(prop.getProperty("ErrorRequired"), login.usernameErrorMessage());
		try {
		log("pass", "<span style='color:red'>"+login.usernameErrorMessage()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Username");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+ "\"This method verifies Login screen Username field by entering Spaces\"")
	public void TC_loginUsernameSpace() {
		InputActions.enterSpace(login.username, "Username");
		InputActions.click(login.loginButton, "Login button");
		assertEquals(prop.getProperty("ErrorRequired"), login.usernameErrorMessage());
		try {
		log("pass", "<span style='color:red'>"+login.usernameErrorMessage()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the Username field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+ "\"This method verifies Login screen Username field for the minimum character length\"")
	public void TC_loginUsernameMinimumLength() {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(3));
		InputActions.click(login.loginButton, "Login button");
		assertEquals(prop.getProperty("ErrorUsernameMinlength"), login.usernameErrorMessage());
		try {
		log("pass", "<span style='color:red'>"+login.usernameErrorMessage()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the Username field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login screen Username field for the maximum character length\"")
	public void TC_loginUsernameMaximumLength()  {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(16));
		InputActions.click(login.loginButton, "Login button");
		assertEquals(prop.getProperty("ErrorUsernameMaxLength"), login.usernameErrorMessage());
		try {
		log("pass", "<span style='color:red'>"+login.usernameErrorMessage()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the Username field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login screen Username field for the Alphabetic characters\"")
	public void TC_loginUsernameAlphanumeric() {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(4));
		InputActions.click(login.loginButton, "Login button");
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(login.usernameErrorMsg));
		try {
		log("pass", "Alphanumeric characters are allowed in the username text field");
		} catch (AssertionError e) {
			log("fail", "Alphanumeric characters are not accepted in the Username text field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login screen Username field for the Special characters\"")
	public void TC_loginUsernameSpecialChar() {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomSpecialChars(5));
		InputActions.click(login.loginButton, "Login button");
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(login.usernameErrorMsg));
		try {
		log("pass", "Special characters are allowed in the username text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are not accepted in the Username text field");
		}
	}

}
