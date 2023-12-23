package units;

import com.qa.Base.TestBase;
import com.qa.Pages.ActionsPage;
import com.qa.Utils.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnitsCRUDTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
		actionsPage = new ActionsPage();
		unit.unitsScreen();
	}

	@BeforeMethod
	public void setup() {
		if (actionsPage.pageHeader1.getText().equals(prop.getProperty("unit"))) {
			TestWaits.threadSleep(1000);
			InputActions.refreshPage();
		} else if (!actionsPage.pageHeader1.getText().equals(prop.getProperty("unit"))) {
			TestWaits.threadSleep(3000);
		}
		TestWaits.explicitWaitUntilVisible(actionsPage.addButton);
		actionsPage.clickAddBtn();
	}

	@Test(groups = "functional", description = "<em><b>" + "\"This method validates new Unit creation functionality\"")
	public void TC_createUnit() {
		unit.addUnit();
	}

	@Test(groups = "functional", description = "<em><b>" + "\"This method validates existing Unit in the User List\"")
	public void TC_retrieveUnit() {
		unit.addUnit();
		String value = tablePage.retrieveRecord(prop.getProperty("unitNo"), unit.unitNo, tablePage.tableCell3);
		TestUtils.assertEquals(unit.unitNo, value);
		try {
			log("pass", "Added Unit detail is displayed in the Unit List table");
		} catch (Exception e) {
			log("fail", "Added Unit detail is not displayed in the Unit List table");
		}
		log("pass", "<span style='color:green'>" + unit.alertMessage + "</span>" + " message is displayed");

	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method validates modifying existing Unit functionality\"")
	public void TC_updateUnit() {
		unit.addUnit();
		String unitNo2 = DataUtils.randomInt(10);
		TestWaits.threadSleep(2000);
		String alertMessage2 = tablePage.updateRecord(prop.getProperty("unitNo"), unit.unitNo,
				unit.unitNoField, "Unit Number field", unitNo2);
		TestUtils.assertEquals(prop.getProperty("unitUpdated"), alertMessage2);
		if (Boolean.parseBoolean(prop.getProperty("Database"))) {
			NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Units]", "UnitNo", unitNo2);
		}
	}

	@Test(groups = "functional", description = "<em><b>" + "\"This method validates delete Unit functionality\"")
	public void TC_deleteUnit() {
		unit.addUnit();
		String alertMessage2 = tablePage.deleteRecord(prop.getProperty("unitNo"), unit.unitNo,
				actionsPage.alertConfirmBtn);
		TestUtils.assertEquals(prop.getProperty("unitDeleted"), alertMessage2);
		log("pass", "<span style='color:blue'>" + alertMessage2 + "</span>" + " message is displayed");
		if (Boolean.parseBoolean(prop.getProperty("Database"))) {
			NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Units]", "UnitNo", unit.unitNo);
		}
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method validates Error message for adding duplicate Unit Number\"")
	public void TC_createDuplicateUnitNo() {
		unit.addUnit();
		TestWaits.threadSleep(1000);
		actionsPage.clickAddBtn();
		TestWaits.threadSleep(500);
		unit.fillUnitsDetails(unit.unitNo, DataUtils.randomString(5),
				DataUtils.randomInt(10), DataUtils.randomInt(1));
		actionsPage.clickSaveBtn();
		TestWaits.threadSleep(2000);
		String alertMessage2 = actionsPage.alertMessage.getText();
		TestUtils.assertEquals(prop.getProperty("unitExist"), alertMessage2);
		try {
		log("pass", "<span style='color:blue'>" + alertMessage2 + "</span>" + " message is displayed");
		} catch (Exception e) {
			log("fail", "Error message is not displayed for adding duplicate Unit");
		}
		InputActions.refreshPage();
	}

	@Test(groups = "functional", description = "<em><b>"
			+ "\"This method verifies Unit Add screen Cancel button functionality\"")
	public void TC_verifyUnitCancelBtn() {
		unit.cancelUnit();
	}

}
