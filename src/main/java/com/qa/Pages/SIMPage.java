package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SIMPage extends TestBase {
    public String alertMessage;
    public String simCardNo;
    public String mobileNo;

    public SIMPage() {
        PageFactory.initElements(getDriver(), this);
        actionsPage = new ActionsPage();
        tablePage = new TablePage();
        user = new UsersPage();
    }

    @FindBy(id = "mobileNo")
    public WebElement mobileNoField;

    @FindBy(id = "mobileNo-label")
    public WebElement mobileNoLabel;

    @FindBy(id = "mobileNo-helper-text")
    public WebElement mobileNoErrorMsg;

    @FindBy(id = "simNo")
    public WebElement simCardNoField;

    @FindBy(id = "simNo-label")
    public WebElement simCardNoLabel;

    @FindBy(xpath = "(//p[contains(@class,'MuiFormHelperText')])[2]")
    public WebElement simCardNoErrorMsg;

    @FindBy(xpath = "//*[contains(@class,'MuiSelect-select')]")
    public WebElement serviceProviderField;

    @FindBy(id = "simNo-label")
    public WebElement serviceProviderLabel;

    @FindBy(xpath = "(//*[contains(@class,'MuiInputLabel-root')])[3]")
    public WebElement serviceProviderErrorMsg;

    @FindBy(xpath = "(//*[contains(@class,'MuiSelect-select')])[2]")
    public WebElement simTypeField;

    @FindBy(id = "simNo-label")
    public WebElement simTypeLabel;

    @FindBy(xpath = "(//*[contains(@class,'MuiInputLabel-root')])[4]")
    public WebElement simTypeErrorMsg;


    public void simScreen() {
        actionsPage.clickOnSubMenu(actionsPage.managementMenu, "Management", actionsPage.simSubMenu,  "SIM");
    }


    public void fillSimDetails(String mobileNo, String simCardNo, String serviceProvider, String simType) {
        TestWaits.threadSleep(1000);
        InputActions.clickAndSend(mobileNoField, "Mobile Number", mobileNo);
        InputActions.clickAndSend(simCardNoField, "SIM Card Number", simCardNo);
        actionsPage.enterDropdown(serviceProviderField, "Service Provider", DataUtils.serviceProvider.get(0), "Service Provider");
        actionsPage.enterDropdown(simTypeField, "SIM Type", simType, "SIM Type");
        actionsPage.enterDatepicker(user.validityDatepicker, "27-01-2022", "2022-01-27");
    }


    public void addSim() {
        simCardNo = DataUtils.randomInt(10);
        mobileNo = DataUtils.randomInt(10);
        fillSimDetails(mobileNo, simCardNo,
                DataUtils.serviceProvider.get(0), DataUtils.simType.get(0));
        actionsPage.clickSaveBtn();
        TestWaits.threadSleep(2000);
        alertMessage = actionsPage.alertMessage.getText();
        TestUtils.assertEquals(prop.getProperty("simAdded"), alertMessage);
        try {
            log("pass", "New SIM has been created");
            log("info", "<span style='color:green'>" + alertMessage + "</span>" + " message is displayed");
        } catch (AssertionError e) {
            log("fail", "SIM is not created");
        }
        if (Boolean.parseBoolean(prop.getProperty("Database"))) {
            NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Sims]", "Simno", sim.simCardNo);
        }

    }

    public void cancelSim() {
        String simCardNo = DataUtils.randomInt(10);
        fillSimDetails(DataUtils.randomInt(10), simCardNo,
                DataUtils.serviceProvider.get(0), DataUtils.simType.get(0));
        TestWaits.threadSleep(2000);
        actionsPage.clickCancelBtn();
        TestWaits.threadSleep(3000);
        String value = tablePage.retrieveRecord(prop.getProperty("mobileno"), simCardNo, tablePage.tableCell4);
        Assert.assertTrue(value == null);
        try {
            log("pass", "SIM details are not added on clicking Cancel button");
        } catch (Exception e) {
            log("fail", "SIM details are added on clicking Cancel button");
        }
    }



}
