package users;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class UsersAddressFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		user.usersScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies Address field Placeholder text in the Users Add screen\"")
	public void TC_usersAddressPlaceholderText() {
		TestUtils.getText(prop.getProperty("Address"), user.addressLabel, "Address placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Address in the Users Add screen\"")
	public void TC_usersAddressEmpty()  {
		InputActions.clickAndSend(user.addressField, "Users screen Address", DataUtils.randomString(0));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), user.addressErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.addressErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Address");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Address field by entering Spaces\"")
	public void TC_usersAddressSpace() {
		InputActions.enterSpace(user.addressField, "Users screen Address");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorSpace"), user.addressErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.addressErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the Address field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Address field for the minimum character length\"")
	public void TC_usersAddressMinimumLength()  {
		InputActions.clickAndSend(user.addressField, "Users screen Address", DataUtils.randomString(3));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMinEmpID"), user.addressErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.addressErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the Address field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Address field for the maximum character length\"")
	public void TC_usersAddressMaximumLength()  {
		InputActions.clickAndSend(user.addressField, "Users screen Address", DataUtils.randomAlphaNumeric(502));
		TestWaits.threadSleep(3000);
		InputActions.scrolltoEnd();
		TestWaits.threadSleep(500);
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("erroAddressMax"), user.addressErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+user.addressErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the Address field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Address field for the Alphabetic characters\"")
	public void TC_usersAddressAlphanumeric() {
		InputActions.clickAndSend(user.addressField, "Users screen Address", DataUtils.randomString(5));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.addressErrorMsg));
		try {
		log("pass", "Alphanumeric characters are allowed in the Address text field");
		} catch (AssertionError e) {
			log("fail", "Alphanumeric characters are not accepted in the Address text field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Users Add screen Address field for the Special characters\"")
	public void TC_usersAddressSpecialChar() {
		InputActions.clickAndSend(user.addressField, "Users screen Address", DataUtils.randomSpecialChars(5));
		actionsPage.clickSaveBtn();
		Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.addressErrorMsg));
		try {
		log("pass", "Special characters are allowed in the Address text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are not accepted in the Address text field");
		}
	}

}
