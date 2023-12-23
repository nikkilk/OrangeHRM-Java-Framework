package users;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class UsersCityFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies City field Placeholder text in the Users Add screen\"")
	public void TC_usersCityPlaceholderText() {
		TestUtils.getText(prop.getProperty("City"), user.cityLabel, "City placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty City in the Users Add screen\"")
	public void TC_usersCityEmpty()  {
		InputActions.clickAndSend(user.cityField, "Users screen City", DataUtils.randomString(0));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), user.cityErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.cityErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty City");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen City field by entering Spaces\"")
	public void TC_usersCitySpace() {
		InputActions.enterSpace(user.cityField, "Users screen City");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorSpace"), user.cityErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.cityErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the City field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen City field for the minimum character length\"")
	public void TC_usersCityMinimumLength()  {
		InputActions.clickAndSend(user.cityField, "Users screen City", DataUtils.randomString(1));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorDevice_RoleMin"), user.cityErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.cityErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the City field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen City field for the maximum character length\"")
	public void TC_usersCityMaximumLength()  {
		InputActions.clickAndSend(user.cityField, "Users screen City", DataUtils.randomString(31));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMax"), user.cityErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.cityErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the City field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen City field for the Alphabetic characters\"")
	public void TC_usersCityAlphanumeric() {
		InputActions.clickAndSend(user.cityField, "Users screen City", DataUtils.randomString(3));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.cityErrorMsg));
		try {
		log("pass", "Alphanumeric characters are allowed in the City text field");
		} catch (AssertionError e) {
			log("fail", "Alphanumeric characters are not accepted in the City text field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen City field for the Special characters\"")
	public void TC_usersTestWaitsSpecialChar() {
		InputActions.clickAndSend(user.cityField, "Users screen City", DataUtils.randomSpecialChars(5));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.cityErrorMsg));
		try {
		log("pass", "Special characters are allowed in the City text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are not accepted in the City text field");
		}
	}

}
