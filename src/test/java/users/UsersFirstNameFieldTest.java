package users;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class UsersFirstNameFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies First Name field Placeholder text in the Users Add screen\"")
	public void TC_usersFirstNamePlaceholderText() {
		TestUtils.getText(prop.getProperty("fName"), user.firstNameLabel, "First Name placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty First Name in the Users Add screen\"")
	public void TC_usersFirstNameEmpty()  {
		InputActions.clickAndSend(user.firstNameField, "Users screen First Name", DataUtils.randomString(0));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), user.firstNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.firstNameErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty First Name");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen First Name field by entering Spaces\"")
	public void TC_usersFirstNameSpace() {
		InputActions.enterSpace(user.firstNameField, "Users screen First Name");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorSpace"), user.firstNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.firstNameErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the First Name field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen First Name field for the minimum character length\"")
	public void TC_usersFirstNameMinimumLength()  {
		InputActions.clickAndSend(user.firstNameField, "Users screen First Name", DataUtils.randomString(1));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorDevice_RoleMin"), user.firstNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.firstNameErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the First Name field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen First Name field for the maximum character length\"")
	public void TC_usersFirstNameMaximumLength()  {
		InputActions.clickAndSend(user.firstNameField, "Users screen First Name", DataUtils.randomString(31));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMax"), user.firstNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.firstNameErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the First Name field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen First Name field for the Alphabetic characters\"")
	public void TC_usersFirstNameAlphanumeric() {
		InputActions.clickAndSend(user.firstNameField, "Users screen First Name", DataUtils.randomString(3));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.firstNameErrorMsg));
		try {
		log("pass", "Alphanumeric characters are allowed in the First Name text field");
		} catch (AssertionError e) {
			log("fail", "Alphanumeric characters are not accepted in the First Name text field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen First Name field for the Special characters\"")
	public void TC_usersFirstNameSpecialChar() {
		InputActions.clickAndSend(user.firstNameField, "Users screen First Name", DataUtils.randomSpecialChars(3));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.firstNameErrorMsg));
		try {
		log("pass", "Special characters are allowed in the First Name text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are not accepted in the First Name text field");
		}
	}

}
