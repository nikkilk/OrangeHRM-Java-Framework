package users;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class UsersLastNameFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies Last Name field Placeholder text in the Users Add screen\"")
	public void TC_usersLastNamePlaceholderText() {
		TestUtils.getText(prop.getProperty("lName"), user.lastNameLabel, "Last Name placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Last Name in the Users Add screen\"")
	public void TC_usersLastNameEmpty()  {
		InputActions.clickAndSend(user.lastNameField, "Users screen Last Name", DataUtils.randomString(0));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.lastNameErrorMsg));
		try {
		log("pass", "The Last Name field is not a mandatory field and a error message is not displayed if no data is entered");
	} catch (AssertionError e) {
		log("fail", "Error message is not displayed for the empty Last Name");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Last Name field by entering Spaces\"")
	public void TC_usersLastNameSpace() {
		InputActions.enterSpace(user.lastNameField, "Users screen Last Name");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorSpace"), user.lastNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.lastNameErrorMsg.getText()+"</span>"+" error message is displayed");
	} catch (AssertionError e) {
		log("fail", "Error message is not displayed for entering space in the Last Name field");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Last Name field for the minimum character length\"")
	public void TC_usersLastNameMinimumLength()  {
		InputActions.clickAndSend(user.lastNameField, "Users screen Last Name", DataUtils.randomString(1));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.lastNameErrorMsg));
		try {
		log("pass", "The Last Name field is not a mandatory field and there is no minimum character limit");
	} catch (AssertionError e) {
		log("fail", "Minimum character length is not defined for the Last Name field");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Last Name field for the maximum character length\"")
	public void TC_usersLastNameMaximumLength()  {
		InputActions.clickAndSend(user.lastNameField, "Users screen Last Name", DataUtils.randomString(31));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMax"), user.lastNameErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.lastNameErrorMsg.getText()+"</span>"+" error message is displayed");
	} catch (AssertionError e) {
		log("fail", "Maximum character length is not defined for the Last Name field");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Last Name field for the Alphabetic characters\"")
	public void TC_usersLastNameAlphanumeric() {
		InputActions.clickAndSend(user.lastNameField, "Users screen Last Name", DataUtils.randomString(4));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.lastNameErrorMsg));
		try {
		log("pass", "Alphanumeric characters are allowed in the Last Name text field");
	} catch (AssertionError e) {
		log("fail", "Alphanumeric characters are not accepted in the Last Name text field");
	}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Last Name field for the Special characters\"")
	public void TC_usersLastNameSpecialChar() {
		InputActions.clickAndSend(user.lastNameField, "Users screen Last Name", DataUtils.randomSpecialChars(4));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.lastNameErrorMsg));
		try {
		log("pass", "Special characters are allowed in the Last Name text field");
	} catch (AssertionError e) {
		log("fail", "Special characters are not accepted in the Last Name text field");
	}
	}

}
