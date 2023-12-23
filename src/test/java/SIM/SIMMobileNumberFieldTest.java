package SIM;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class SIMMobileNumberFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		sim.simScreen();
		actionsPage.clickAddBtn();
	}

	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies Mobile Number field Placeholder text in the SIM Add screen\"")
	public void TC_simMobileNoPlaceholderText() {
		TestUtils.getText(prop.getProperty("MobileNo"), sim.mobileNoLabel, "Mobile Number placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty Mobile Number in the SIM Add screen\"")
	public void TC_simMobileNoEmpty()  {
		InputActions.clearWebField(sim.mobileNoField);
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), sim.mobileNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+sim.mobileNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty Mobile Number");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Add screen Mobile Number field by entering Spaces\"")
	public void TC_simMobileNoSpace() {
		InputActions.enterSpace(sim.mobileNoField, "SIM screen Mobile Number");
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorNoChar"), sim.mobileNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+sim.mobileNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the Mobile Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Add screen Mobile Number field for the minimum length\"")
	public void TC_simMobileNoMinimumLength()  {
		InputActions.clickAndSend(sim.mobileNoField, "SIM screen Mobile Number", DataUtils.randomInt(7));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMobileNoMin"), sim.mobileNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+sim.mobileNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the Mobile Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Add screen Mobile Number field for the maximum length\"")
	public void TC_simMobileNoMaximumLength()  {
		InputActions.sendKeys(sim.mobileNoField, "SIM screen Mobile Number", DataUtils.randomInt(21));
		actionsPage.clickSaveBtn();
		TestWaits.threadSleep(1000);
		assertEquals(prop.getProperty("errorSimNoMax"), sim.mobileNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+sim.mobileNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the Mobile Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Add screen Mobile Number field for the Alphabetic characters\"")
	public void TC_simMobileNoAlpha() {
		InputActions.clickAndSend(sim.mobileNoField, "SIM screen Mobile Number", DataUtils.randomString(8));
		actionsPage.clickSaveBtn();
		TestWaits.threadSleep(1000);
		assertEquals(prop.getProperty("errorNoChar"), sim.mobileNoErrorMsg.getText());
		try {
		log("pass", "Alpha characters are not accepted in the Mobile Number text field");
		} catch (AssertionError e) {
			log("fail", "Alpha characters are allowed in the Mobile Number text field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Add screen Mobile Number field for the Special characters\"")
	public void TC_simMobileNoSpecialChar() {
		InputActions.clickAndSend(sim.mobileNoField, "SIM screen Mobile Number", DataUtils.randomSpecialChars(8));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorSpace"), sim.mobileNoErrorMsg.getText());
		try {
		log("pass", "Special characters are not allowed in the Mobile Number text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are accepted in the Mobile Number text field");
		}
	}

}
