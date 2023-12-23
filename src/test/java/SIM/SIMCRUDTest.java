package SIM;

import com.qa.Base.TestBase;
import com.qa.Pages.ActionsPage;
import com.qa.Utils.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SIMCRUDTest extends TestBase {

    @BeforeClass
    public void preSetup() {
        init();
        actionsPage = new ActionsPage();
        sim.simScreen();
    }

    @BeforeMethod
    public void setup() {
        if (actionsPage.pageHeader1.getText().equals(prop.getProperty("Sim"))) {
            TestWaits.threadSleep(1000);
            InputActions.refreshPage();
        } else if (!actionsPage.pageHeader1.getText().equals(prop.getProperty("Sim"))) {
            TestWaits.threadSleep(3000);
        }
        TestWaits.explicitWaitUntilVisible(actionsPage.addButton);
        actionsPage.clickAddBtn();
    }

    @Test(groups = "functional", description = "<em><b>" + "\"This method validates new SIM creation functionality\"")
    public void TC_createSIM() {
        sim.addSim();
    }

    @Test(groups = "functional", description = "<em><b>" + "\"This method validates existing SIM in the User List\"")
    public void TC_retrieveSIM() {
        sim.addSim();
        TestUtils.assertEquals(prop.getProperty("simAdded"), sim.alertMessage);
        try {
            log("pass", "New SIM has been created");
        } catch (AssertionError e) {
            log("fail", "SIM is not created");
        }
        String value = tablePage.retrieveRecord(prop.getProperty("simNo_"), sim.simCardNo, tablePage.tableCell4);
        TestUtils.assertEquals(sim.simCardNo, value);
        try {
            log("pass", "Added SIM detail is displayed in the SIM List table");
        } catch (Exception e) {
            log("fail", "Added SIM detail is not displayed in the SIM List table");
        }
        log("pass", "<span style='color:green'>" + sim.alertMessage + "</span>" + " message is displayed");

    }

    @Test(groups = "functional", description = "<em><b>"
            + "\"This method validates modifying existing SIM functionality\"")
    public void TC_updateSIM() {
        sim.addSim();
        String simCardNo2 = DataUtils.randomInt(10);
        TestWaits.threadSleep(2000);
        String alertMessage2 = tablePage.updateRecord(prop.getProperty("simNo"), sim.simCardNo,
                sim.simCardNoField, "SIM Card Number field", simCardNo2);
        TestUtils.assertEquals(prop.getProperty("simUpdated"), alertMessage2);
        if (Boolean.parseBoolean(prop.getProperty("Database"))) {
            NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Sims]", "Simno", simCardNo2);
        }
    }

    @Test(groups = "functional", description = "<em><b>" + "\"This method validates delete SIM functionality\"")
    public void TC_deleteSIM() {
        sim.addSim();
        String alertMessage2 = tablePage.deleteRecord(prop.getProperty("simNo"), sim.simCardNo, actionsPage.alertConfirmBtn);
        TestUtils.assertEquals(prop.getProperty("simDeleted"), alertMessage2);
        log("pass", "<span style='color:blue'>" + alertMessage2 + "</span>" + " message is displayed");
        if (Boolean.parseBoolean(prop.getProperty("Database"))) {
            NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Sims]", "Simno", sim.simCardNo);
        }
    }

    @Test(groups = "functional", description = "<em><b>"
            + "\"This method validates Error message for adding duplicate Mobile Number\"")
    public void TC_createDuplicateMobileNo() {
        sim.addSim();
        TestWaits.threadSleep(1000);
        actionsPage.clickAddBtn();
        TestWaits.threadSleep(500);
        sim.fillSimDetails(sim.mobileNo, DataUtils.randomInt(10), DataUtils.serviceProvider.get(0), DataUtils.simType.get(0));
        actionsPage.clickSaveBtn();
        TestWaits.threadSleep(2000);
        String alertMessage2 = actionsPage.alertMessage.getText();
        TestUtils.assertEquals(prop.getProperty("simExist"), alertMessage2);
        try {
            log("pass", "<span style='color:blue'>" + alertMessage2 + "</span>" + " message is displayed");
        } catch (Exception e) {
            log("fail", "Error message is not displayed for adding duplicate SIM");
        }
        InputActions.refreshPage();
    }

    @Test(groups = "functional", description = "<em><b>"
            + "\"This method validates Error message for adding duplicate Sim Card Number\"")
    public void TC_createDuplicateSimCardNo() {
        sim.addSim();
        TestWaits.threadSleep(1000);
        actionsPage.clickAddBtn();
        TestWaits.threadSleep(500);
        sim.fillSimDetails(DataUtils.randomInt(10), sim.simCardNo, DataUtils.serviceProvider.get(0), DataUtils.simType.get(0));
        actionsPage.clickSaveBtn();
        TestWaits.threadSleep(2000);
        String alertMessage2 = actionsPage.alertMessage.getText();
        TestUtils.assertEquals(prop.getProperty("simExist"), alertMessage2);
        try {
            log("pass", "<span style='color:blue'>" + alertMessage2 + "</span>" + " message is displayed");
        } catch (Exception e) {
            log("fail", "Error message is not displayed for adding duplicate SIM");
        }
        InputActions.refreshPage();
    }

    @Test(groups = "functional", description = "<em><b>"
            + "\"This method verifies SIM Add screen Cancel button functionality\"")
    public void TC_verifySIMCancelBtn() {
        sim.cancelSim();
    }

}
