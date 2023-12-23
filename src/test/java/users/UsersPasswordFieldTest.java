package users;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class UsersPasswordFieldTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage.clickAddBtn();
	}

	@Test(priority = -1, groups = "functional", description = "<em><b>"
			+ "\"This method verifies Password field Placeholder text in the Users Add screen\"")
	public void TC_usersPasswordPlaceholderText() {
		TestUtils.getText(prop.getProperty("Password"), user.loginPasswordLabel, "Password placeholder");
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies error message for the empty Password in the Users Add screen\"")
	public void TC_usersPasswordEmpty() {
		InputActions.clickAndSend(user.loginPasswordField, "Users screen Password", DataUtils.randomString(0));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), user.loginPasswordErrorMsg.getText());
		try {
			log("pass", "<span style='color:red'>" + user.loginPasswordErrorMsg.getText() + "</span>"
					+ " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Password");
		}
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies Users Add screen Password field by entering Spaces\"")
	public void TC_usersPasswordSpace() {
		InputActions.enterSpace(user.loginPasswordField, "Users screen Password");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorSpace"), user.loginPasswordErrorMsg.getText());
		try {
			log("pass", "<span style='color:red'>" + user.loginPasswordErrorMsg.getText() + "</span>"
					+ " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the Password field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies Users Add screen Password field for the minimum character length\"")
	public void TC_usersPasswordMinimumLength() {
		InputActions.clickAndSend(user.loginPasswordField, "Users screen Password", DataUtils.randomString(3));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorPasswordMinLength"), user.loginPasswordErrorMsg.getText());
		try {
			log("pass", "<span style='color:red'>" + user.loginPasswordErrorMsg.getText() + "</span>"
					+ " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the Password field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies Users Add screen Password field for the maximum character length\"")
	public void TC_usersPasswordMaximumLength() {
		InputActions.clickAndSend(user.loginPasswordField, "Users screen Password", DataUtils.randomString(16));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorPasswordMaxLength"), user.loginPasswordErrorMsg.getText());
		try {
			log("pass", "<span style='color:red'>" + user.loginPasswordErrorMsg.getText() + "</span>"
					+ " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the Password field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies Users Add screen Password field for the Alphabetic characters\"")
	public void TC_usersPasswordAlphanumeric() {
		InputActions.clickAndSend(user.loginPasswordField, "Users screen Password", DataUtils.randomAlphaNumeric(6));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.loginPasswordErrorMsg));
		try {
			log("pass", "Alphanumeric characters are allowed in the password text field");
		} catch (AssertionError e) {
			log("fail", "Alphanumeric characters are not accepted in the Password text field");
		}
	}


	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies Users Add screen Password field for the Special characters\"")
	public void TC_usersPasswordSpecialChar() {
		InputActions.clickAndSend(user.loginPasswordField, "Users screen Password field",
				DataUtils.randomSpecialChars(6));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.loginPasswordErrorMsg));
		try {
			log("pass", "Special characters are allowed in the password text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are not accepted in the Password text field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies entered Password is displayed in encrypted format by default in Users Add screen\"")
	public void TC_usersPasswordEyeIconEnable() {
		InputActions.clickAndSend(user.loginPasswordField, "Users screen Password field",
				DataUtils.randomAlphaNumeric(7));
		if (user.loginPasswordField.getAttribute("type").equals("text")) {
			InputActions.click(user.userEyeIcon, "Eye icon");
		}
		String status = user.loginPasswordField.getAttribute("type");
		TestUtils.assertEquals(status, "password");
		try {
			log("pass", "The password is displayed by default in encrypted format");
		} catch (AssertionError e) {
			log("fail", "password is not displayed by default in encrypted format");
		}
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies entered Password is displayed in Plain text format on disabling View icon in Users Add screen\"")
	public void TC_usersPasswordEyeIconDisable() {
		InputActions.clickAndSend(user.loginPasswordField, "Users screen Password field",
				DataUtils.randomAlphaNumeric(7));
		if (user.loginPasswordField.getAttribute("type").equals("password")) {
			InputActions.click(user.userEyeIcon, "Eye icon");
		}
		String status = user.loginPasswordField.getAttribute("type");
		TestUtils.assertEquals(status, "text");
		try {
			log("pass", "Password is displayed in plain text");
		} catch (AssertionError e) {
			log("fail", "Password is not displayed in plain text on disabling Eye icon in the password field");
		}
	}

}
