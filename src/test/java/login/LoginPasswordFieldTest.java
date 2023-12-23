package login;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class LoginPasswordFieldTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies password field Placeholder text\"")
	public void TC_loginPasswordPlaceholderText() {
		String text = login.passwordText.getText();
		assertEquals(text, prop.getProperty("Password"));
		try {
		log("pass", "<b>" + text + "</b>" + " Password field placeholder text is not displayed");
		} catch (AssertionError e) {
			log("fail", "Password is displayed in plain text");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Password in the Login screen\"")
	public void TC_loginPasswordEmpty() {
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomString(0));
		InputActions.click(login.loginButton, "Login button");
		assertEquals(prop.getProperty("ErrorRequired"), login.passwordErrorMessage());
		try {
		log("pass", "<span style='color:red'>" + login.passwordErrorMessage() + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Password");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login screen Password field by entering Spaces\"")
	public void TC_loginPasswordSpace() {
		InputActions.enterSpace(login.password, "Password");
		InputActions.click(login.loginButton, "Login button");
		assertEquals(prop.getProperty("ErrorRequired"), login.passwordErrorMessage());
		try {
		log("pass", "<span style='color:red'>" + login.passwordErrorMessage() + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the Password field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login screen Password field for the minimum character length\"")
	public void TC_loginPasswordMinimumLength() {
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomString(3));
		InputActions.click(login.loginButton, "Login button");
		assertEquals(prop.getProperty("ErrorPasswordMinLength"), login.passwordErrorMessage());
		try {
		log("pass", "<span style='color:red'>" + login.passwordErrorMessage() + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the Password field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login screen Password field for the maximum character length\"")
	public void TC_loginPasswordMaximumLength() {
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomString(16));
		InputActions.click(login.loginButton, "Login button");
		assertEquals(prop.getProperty("ErrorPasswordMaxLength"), login.passwordErrorMessage());
		try {
		log("pass", "<span style='color:red'>" + login.passwordErrorMessage() + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the Password field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login screen Password field for the Alphabetic characters\"")
	public void TC_loginPasswordAlphanumeric() {
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomString(5));
		InputActions.click(login.loginButton, "Login button");
		Assert.assertTrue(login.passwordErrorMsg.isDisplayed());
		try {
		log("pass", "Alphanumeric characters are allowed in the password text field");
		} catch (AssertionError e) {
			log("fail", "Alphanumeric characters are not accepted in the password text field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login screen Password field for the Special characters\"")
	public void TC_loginPasswordSpecialChar() {
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomSpecialChars(6));
		InputActions.click(login.loginButton, "Login button");
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(login.passwordErrorMsg));
		try {
		log("pass", "Special characters are allowed in the password text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are not accepted in the password text field");
		}
	}

	@Test(groups = "functional", description = "em><b>"+"\"This method verifies entered Password is displayed in encrypted format by default in Login screen\"")
	public void TC_loginPasswordEyeIconEnable() {
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomString(6));
		if(login.password.getAttribute("type").equals("text")) {
			InputActions.click(login.eyeIcon, "Eye icon");
			}
		String status = login.password.getAttribute("type");
		TestUtils.assertEquals(status, "password");
		try {
		log("pass", "The password is displayed by default in encrypted format");
		} catch (AssertionError e) {
			log("fail", "password is not displayed by default in encrypted format");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies entered Password is displayed in Plain text format on disabling View icon in Login screen\"")
	public void TC_loginPasswordEyeIconDisable() {
		InputActions.clickAndSend(login.password, "Password", DataUtils.randomString(6));
		if(login.password.getAttribute("type").equalsIgnoreCase("password")) {
			InputActions.click(login.eyeIcon, "Eye icon");
			}
		String status = login.password.getAttribute("type");
		TestUtils.assertEquals(status, "text");
		try {
		log("pass", "Password is displayed in plain text in the password field");
		} catch (AssertionError e) {
			log("fail", "Password is not displayed in plain text on disabling Eye icon in the password field");
		}
	}

}
