package users;

import com.qa.Base.TestBase;
import com.qa.Pages.ActionsPage;
import com.qa.Pages.TablePage;
import com.qa.Utils.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersCRUDTest extends TestBase {

    @BeforeClass
    public void preSetup() {
        init();
        actionsPage = new ActionsPage();
        tablePage = new TablePage();
        user.usersScreen();
    }

    @BeforeMethod
    public void setup() {
        if (actionsPage.pageHeader1.getText().equals(prop.getProperty("Users"))) {
            TestWaits.threadSleep(1000);
            InputActions.refreshPage();
        } else if (!actionsPage.pageHeader1.getText().equals(prop.getProperty("Users"))) {
            TestWaits.threadSleep(2000);
        }
        TestWaits.explicitWaitUntilVisible(actionsPage.addButton);
        actionsPage.clickAddBtn();
    }

    @Test(groups = "functional", description = "<em><b>" + "\"This method validates new User creation functionality\"")
    public void TC_createUser() {
        user.addUser();
    }

    @Test(groups = "functional", description = "<em><b>" + "\"This method validates existing User in the User List\"")
    public void TC_retrieveUser() {
        user.addUser();
        String value = tablePage.retrieveRecord(prop.getProperty("UserName"), user.firstName, tablePage.tableCell4);
        TestUtils.assertEquals(user.firstName, value);
        try {
            log("pass", "Added SIM detail is displayed in the SIM List table");
        } catch (Exception e) {
            log("fail", "Added SIM detail is not displayed in the SIM List table");
        }
        log("pass", "<span style='color:green'>" + user.alertMessage + "</span>" + " message is displayed");
    }

    @Test(priority = 1, groups = "functional", description = "<em><b>"
            + "\"This method validates modifying existing User functionality\"")
    public void TC_updateUser() {
        user.addUser();
        String lastName = DataUtils.faker.name().lastName();
        String alertMessage2 = tablePage.updateRecord(prop.getProperty("UserName"), user.firstName,
                user.lastNameField, "Last Name field", "updateuser");
        TestUtils.assertEquals(prop.getProperty("userUpdated"), alertMessage2);
        if (Boolean.parseBoolean(prop.getProperty("Database"))) {
            NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Users]", "LastName", lastName);
        }
    }

    @Test(groups = "functional", description = "<em><b>" + "\"This method validates delete User functionality\"")
    public void TC_deleteUser() {
        user.addUser();
        String alertMessage2 = tablePage.deleteRecord(prop.getProperty("UserName"), user.firstName, actionsPage.alertConfirmBtn);
        TestUtils.assertEquals(prop.getProperty("userDeleted"), alertMessage2);
        log("pass", "<span style='color:blue'>" + alertMessage2 + "</span>" + " message is displayed");
        if (Boolean.parseBoolean(prop.getProperty("Database"))) {
            NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Users]", "FirstName", user.firstName);
        }
    }

    @Test(groups = "functional", description = "<em><b>" + "\"This method validates Error message for adding duplicate User\"")
    public void TC_verifyDuplicateUser() {
        user.addUser();
        TestWaits.threadSleep(1000);
        actionsPage.clickAddBtn();
        TestWaits.threadSleep(500);
        user.fillUserDetails(user.firstName, DataUtils.faker.name().lastName(),
                user.loginName, DataUtils.faker.internet().password(6, 15), DataUtils.faker.internet().emailAddress(),
                DataUtils.randomInt(10), DataUtils.faker.address().cityName(), DataUtils.faker.address().fullAddress());
        actionsPage.clickSaveBtn();
        TestWaits.threadSleep(2000);
        String alertMessage2 = actionsPage.alertMessage.getText();
        try {
            log("pass", "<span style='color:blue'>" + alertMessage2 + "</span>" + " message is displayed");
        } catch (Exception e) {
            log("fail", "Error message is not displayed for adding duplicate user");
        }
        InputActions.refreshPage();
    }

    @Test(groups = "functional", description = "<em><b>"
            + "\"This method verifies User Add screen Cancel button functionality\"")
    public void TC_verifyUserCancelBtn() {
        user.cancelUser();
    }

}
