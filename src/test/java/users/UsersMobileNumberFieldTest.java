package users;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class UsersMobileNumberFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies Mobile Number field Placeholder text in the Users Add screen\"")
	public void TC_usersMobileNoPlaceholderText() {
		TestUtils.getText(prop.getProperty("MobileNo"), user.mobileNoLabel, "Mobile Number placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Mobile Number in the Users Add screen\"")
	public void TC_usersMobileNoEmpty()  {
		InputActions.clearWebField(user.mobileNoField);
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), user.mobileNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.mobileNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Mobile Number");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Mobile Number field by entering Spaces\"")
	public void TC_usersMobileNoSpace() {
		InputActions.enterSpace(user.mobileNoField, "Users screen Mobile Number");
		actionsPage.clickSaveBtn();
		TestWaits.threadSleep(500);
		assertEquals(prop.getProperty("errorNoChar"), user.mobileNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.mobileNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the Mobile Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Mobile Number field for the minimum length\"")
	public void TC_usersMobileNoMinimumLength()  {
		InputActions.clickAndSend(user.mobileNoField, "Users screen Mobile Number", DataUtils.randomInt(7));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMobileNoMin"), user.mobileNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.mobileNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the Mobile Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Mobile Number field for the maximum length\"")
	public void TC_usersMobileNoMaximumLength()  {
		InputActions.sendKeys(user.mobileNoField, "Users screen Mobile Number", DataUtils.randomInt(13));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMobileNoMax"), user.mobileNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.mobileNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the Mobile Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Mobile Number field for the Alphabetic characters\"")
	public void TC_usersMobileNoAlpha() {
		InputActions.clickAndSend(user.mobileNoField, "Users screen Mobile Number", DataUtils.randomString(8));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorNoChar"), user.mobileNoErrorMsg.getText());
		try {
		log("pass", "Alpha characters are not accepted in the Mobile Number text field");
		} catch (AssertionError e) {
			log("fail", "Alpha characters are allowed in the Mobile Number text field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Mobile Number field for the Special characters\"")
	public void TC_usersMobileNoSpecialChar() {
		InputActions.clickAndSend(user.mobileNoField, "Users screen Mobile Number", DataUtils.randomSpecialChars(8));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorNoChar"), user.mobileNoErrorMsg.getText());
		try {
		log("pass", "Special characters are not allowed in the Mobile Number text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are accepted in the Mobile Number text field");
		}
	}

}
