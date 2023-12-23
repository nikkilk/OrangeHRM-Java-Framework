package clients;

import com.qa.Base.TestBase;
import com.qa.Pages.ActionsPage;
import com.qa.Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class ClientNameFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		actionsPage = new ActionsPage();
		client.clientsScreen();
		actionsPage.clickAddBtn();
		TestWaits.threadSleep(500);
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies Client Name field Placeholder text in the Clients Add screen\"")
	public void TC_clientNamePlaceholder() {
		TestUtils.getText(prop.getProperty("clientname"), reports.clientNameLabel, "Client Name field");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Client Name in the Clients Add screen\"")
	public void TC_clientNameEmpty()  {
		InputActions.clickAndSend(client.clientNameField, "Client Name", DataUtils.randomString(0));
		actionsPage.clickSaveBtn();
		try {
			assertEquals(prop.getProperty("ErrorRequired"), reports.clientNameErrorMessage.getText());
			log("pass", "<span style='color:red'>" + prop.getProperty("errorMaxClient") + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Client Name");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients Add screen Client Name field for the minimum character length\"")
	public void TC_clientNameMinimumLength()  {
		InputActions.clickAndSend(client.clientNameField, "Client Name", DataUtils.randomString(3));
		actionsPage.clickSaveBtn();
		try {
			assertEquals(prop.getProperty("errorMin"), reports.clientNameErrorMessage.getText());
			log("pass", "<span style='color:red'>" + prop.getProperty("errorMaxClient") + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the Client Name field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients Add screen Client Name field for the maximum character length\"")
	public void TC_clientNameMaximumLength()  {
		InputActions.clickAndSend(client.clientNameField, "Client Name", DataUtils.randomString(51));
		actionsPage.clickSaveBtn();
		try {
			assertEquals(prop.getProperty("errorMaxClient"), reports.clientNameErrorMessage.getText());
			log("pass", "<span style='color:red'>" + prop.getProperty("errorMaxClient") + "</span>" + " error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the Client Name field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients Add screen Client Name field for the Alphabetic characters\"")
	public void TC_clientNameAlphanumeric() {
		InputActions.clickAndSend(client.clientNameField, "Client Name", DataUtils.randomString(5));
		actionsPage.clickSaveBtn();
			Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.firstNameErrorMsg));
		try {
			log("pass", "Alphanumeric characters are allowed in the Client Name text field");
		} catch (AssertionError e) {
			log("fail", "Alphanumeric characters are not accepted in the Client Name text field");
		}
	}

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Clients Add screen Client Name field for the Special characters\"")
	public void TC_clientNameSpecialChar() {
		InputActions.clickAndSend(client.clientNameField, "Client Name", DataUtils.randomSpecialChars(4));
		actionsPage.clickSaveBtn();
			Assert.assertTrue(TestWaits.explicitWaitinvisibilityOfElement(user.firstNameErrorMsg));
		try {
			log("pass", "Special characters are allowed in the Client Name text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are not accepted in the Client Name text field");
		}
	}

}
