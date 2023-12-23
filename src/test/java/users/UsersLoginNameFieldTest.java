package users;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class UsersLoginNameFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies Login Name field Placeholder text in the Users Add screen\"")
	public void TC_usersLoginNamePlaceholderText() {
		TestUtils.getText(prop.getProperty("loginName"), user.loginNameLabel, "Login Name placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Login Name in the Users Add screen\"")
	public void TC_usersLoginNameEmpty()  {
		InputActions.clickAndSend(user.loginNameField, "Users screen Login Name", DataUtils.randomString(0));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), user.loginNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.loginNameErrorMsg.getText()+"</span>"+" error message is displayed");
	} catch (Exception e) {
		log("fail", "Error message is not displayed for the empty Login Name");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Login Name field by entering Spaces\"")
	public void TC_usersLoginNameSpace() {
		InputActions.enterSpace(user.loginNameField, "Users screen Login Name");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorSpace"), user.loginNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.loginNameErrorMsg.getText()+"</span>"+" error message is displayed");
	} catch (Exception e) {
		log("fail", "Error message is not displayed for entering space in the Login Name field");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Login Name field for the minimum character length\"")
	public void TC_usersLoginNameMinimumLength()  {
		InputActions.clickAndSend(user.loginNameField, "Users screen Login Name", DataUtils.randomString(3));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMin"), user.loginNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.loginNameErrorMsg.getText()+"</span>"+" error message is displayed");
	} catch (Exception e) {
		log("fail", "Minimum character length is not defined for the Login Name field");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Login Name field for the maximum character length\"")
	public void TC_usersLoginNameMaximumLength()  {
		InputActions.clickAndSend(user.loginNameField, "Users screen Login Name", DataUtils.randomString(16));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorDevice_RoleMax"), user.loginNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.loginNameErrorMsg.getText()+"</span>"+" error message is displayed");
	} catch (Exception e) {
		log("fail", "Maximum character length is not defined for the Login Name field");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Login Name field for the Alphabetic characters\"")
	public void TC_usersLoginNamenameAlphanumeric() {
		InputActions.clickAndSend(user.loginNameField, "Users screen Login Name", DataUtils.randomString(4));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.loginNameErrorMsg));
		try {
		log("pass", "Alphanumeric characters are allowed in the Login Name text field");
	} catch (Exception e) {
		log("fail", "Alphanumeric characters are not accepted in the Login Name text field");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Login Name field for the Special characters\"")
	public void TC_usersLoginNameSpecialChar() {
		InputActions.clickAndSend(user.loginNameField, "Users screen Login Name", DataUtils.randomSpecialChars(5));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.loginNameErrorMsg));
		try {
		log("pass", "Special characters are allowed in the Login Name text field");
	} catch (Exception e) {
		log("fail", "Special characters are not accepted in the Login Name text field");
	}
	}

}
