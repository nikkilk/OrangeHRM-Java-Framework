package units;

import com.qa.Base.TestBase;
import com.qa.Utils.DataUtils;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qa.Utils.TestUtils.assertEquals;

public class SIMSimCardNumberFieldTest extends TestBase {
	
	@BeforeClass
	public void preSetup() {
		init();
		sim.simScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(priority=-1, groups = "functional", description = "<em><b>"+"\"This method verifies SIM Card Number field Placeholder text in the SIM Add screen\"")
	public void TC_simCardNoPlaceholderText() {
		TestUtils.getText(prop.getProperty("simNo"), sim.simCardNoLabel, "SIM Card Number placeholder");
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies error message for the empty SIM Card Number in the SIM Add screen\"")
	public void TC_simCardNoEmpty()  {
		InputActions.clearWebField(sim.simCardNoField);
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("ErrorRequired"), sim.simCardNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+sim.simCardNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for the empty SIM Card Number");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Card Number field by entering Spaces\"")
	public void TC_simCardNoSpace() {
		InputActions.enterSpace(sim.simCardNoField, "SIM Card Number");
		actionsPage.clickSaveBtn();
		TestWaits.threadSleep(500);
		assertEquals(prop.getProperty("ErrorSpace"), sim.simCardNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+sim.simCardNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Error message is not displayed for entering space in the SIM Card Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Card Number field for the minimum length\"")
	public void TC_simCardNoMinimumLength()  {
		InputActions.clickAndSend(sim.simCardNoField, "SSIM Card", DataUtils.randomInt(7));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorMobileNoMin"), sim.simCardNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+sim.simCardNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Minimum character length is not defined for the SIM Card Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Card Number field for the maximum length\"")
	public void TC_simCardNoMaximumLength()  {
		InputActions.sendKeys(sim.simCardNoField, "SIM Card Number", DataUtils.randomInt(21));
		actionsPage.clickSaveBtn();
		TestWaits.threadSleep(500);
		assertEquals(prop.getProperty("errorSimNoMax"), sim.simCardNoErrorMsg.getText());
		try {
		log("pass", "<span style='color:red'>"+sim.simCardNoErrorMsg.getText()+"</span>"+" error message is displayed");
		} catch (AssertionError e) {
			log("fail", "Maximum character length is not defined for the SIM Card Number field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Card Number field for the Alphabetic characters\"")
	public void TC_simCardNoAlpha() {
		InputActions.clickAndSend(sim.simCardNoField, "SIM screen Mobile Number", DataUtils.randomString(8));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorNoChar"), sim.simCardNoErrorMsg.getText());
		try {
		log("pass", "Alpha characters are not accepted in the SIM Card Number text field");
		} catch (AssertionError e) {
			log("fail", "Alpha characters are allowed in the SIM Card text field");
		}
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies SIM Card Number field for the Special characters\"")
	public void TC_simCardNoSpecialChar() {
		InputActions.clickAndSend(sim.simCardNoField, "SIM Card Number", DataUtils.randomSpecialChars(8));
		actionsPage.clickSaveBtn();
		assertEquals(prop.getProperty("errorNoChar"), sim.simCardNoErrorMsg.getText());
		try {
		log("pass", "Special characters are not allowed in the Mobile Number text field");
		} catch (AssertionError e) {
			log("fail", "Special characters are accepted in the Mobile Number text field");
		}
	}

}
