package login;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.*;

public class ForgotPasswordTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
	}

	@BeforeMethod
	public void beforeMethod() {
		TestWaits.threadSleep(1000);
		if(!getDriver().getCurrentUrl().contains(prop.getProperty("ForgotPasswordURL"))) {
			login.forgotPasswordBtn.click();
		}
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Forgot Password screen Cancel button color\"")
	public void TC_forgotPasswordCancelBtnColor()  {
		colorVerify(login.cancelButton, "Cancel button", prop.getProperty("CancelBtn"));
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method validates Forgot Password screen Forgot Password text\"")
	public void TC_forgotPasswordText() {
		log("info", "Verifying Forgot Password text");
		String text = prop.getProperty("ForgotPasswordTag");
			assertEquals(text, login.forgotPasswordText.getText());
		try {
			log("pass", "<b>" + text + "</b>" + " text is displayed");
		} catch (AssertionError e) {
			log("fail", "<b>" + text + "</b>" + " text is not displayed");
		}
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method validates Reset Password button color in the Forgot Password screen\"")
	public void TC_resetPasswordBtnColor() {
		InputActions.refreshPage();
		colorVerify(login.resetPasswordButton, "Reset Password", prop.getProperty("resetPasswordBtn"));
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Username field in the Forgot Password screen\"")
	public void TC_forgotPasswordUsernameEmpty() {
		log("info", "Verifying Username field");
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(0));
		login.resetPassword();
		String actualMessage = login.usernameErrorMessage();
			assertEquals(prop.getProperty("ErrorRequired"), actualMessage);
		try {
			log("pass", "Empty username is not allowed and Error message " + "<span style='color:red'>" + actualMessage + "</span>" + " is displayed");
		} catch (AssertionError e) {
			log("fail", "Empty username is allowed and Error message is not displayed");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Forgot Password screen Username field for the maximum character length\"")
	public void TC_forgotPasswordUsernameMaxLength()  {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(16));
		login.resetPassword();
		assertEquals(prop.getProperty("ErrorUsernameMaxLength"), login.usernameErrorMessage());
		try {
		log("pass", "<span style='color:red'>"+login.usernameErrorMessage()+"</span>"+" error message is displayed");
	} catch (AssertionError e) {
		log("fail", "Maximum character length is not defined for the Username field");
	}
		
	}
	
	@Test(groups = "functional", description = "<em><b>"+ "\"This method verifies Forgot Password screen Username field for the minimum character length\"")
	public void TC_forgotPasswordUsernameMinLength() {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(3));
		login.resetPassword();
		assertEquals(prop.getProperty("ErrorUsernameMinlength"), login.usernameErrorMessage());
		try {
		log("pass", "<span style='color:red'>"+login.usernameErrorMessage()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
		log("fail", "Minimum character length is not defined for the Username field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Forgot Password screen Username field Placeholder text\"")
	public void TC_forgotPasswordUsernamePlaceholderText() {
		String text = login.usernameText.getText();
		assertEquals(text, prop.getProperty("Username"));
		try {
			log("pass", "<b>"+text+"</b>"+" text is displayed in the Password placeholder");
		} catch (AssertionError e) {
		log("fail", "Username field placeholder text is not displayed");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Forgot Password screen Username field by entering Spaces\"")
	public void TC_forgotPasswordUsernameSpace() {
		InputActions.enterSpace(login.username, "Username");
		login.enterUsername(""+Keys.SPACE);
		login.resetPassword();
		assertEquals(prop.getProperty("ErrorSpace"), login.usernameErrorMessage());
		try {
		log("info", "Space in the beginning of username field is not allowed");
		log("pass", "<span style='color:red'>"+login.usernameErrorMessage()+"</span>" + " error message is displayed");
		} catch (AssertionError e) {
		log("fail", "Entering a space in the Username field does not display an error message");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Forgot Password screen Cancel button functionality\"")
	public void TC_forgotPasswordCancelButton() {
		login.forgotPasswordCancel();
		isDisplayed(login.loginButton);
	}
	
	@Test(groups = "functional", description = "<emb><b>"+"\"This method verifies Forgot Password screen Username field for the invalid data\"")
	public void TC_forgotPasswordInvalidUsername() {
		InputActions.clickAndSend(login.username, "Username", DataUtils.randomString(5));
		login.resetPassword();
		String message = prop.getProperty("ErrorUserNotExist");
		assertTrue(message);
		try {
		log("pass", "<span style='color:red'>" + message + "</span>" + " error message is displayed for invalid username");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for invalid username");
		}
		login.alertMessageClick();
	}

	@Test(groups = "functional", description = "<emb><b>"+"\"This method verifies Forgot Password screen Username field for the valid data\"")
	public void TC_forgotPasswordValidUsername() {
		InputActions.clickAndSend(login.username, "Username", prop.getProperty("Username1"));
		login.resetPassword();
		assertTrue(prop.getProperty("MailSent"));
		try {
		log("pass", "<span style='color:blue'>" + login.alertMessageText() + "</span>" + " message is displayed");
			login.alertMessageClick();
			log("info", "Valid Username is accepted");
			TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsLogin"), "Login");
		} catch (AssertionError e) {
			log("fail", "<span style='color:blue'>" + login.alertMessageText() + "</span>" + " message is not displayed");
		}
	}

}
