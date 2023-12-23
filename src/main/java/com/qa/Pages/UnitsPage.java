package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;

public class UnitsPage extends TestBase {
    public String unitNo;
    public String alertMessage;

    public UnitsPage() {
        PageFactory.initElements(getDriver(), this);
        actionsPage = new ActionsPage();
        tablePage = new TablePage();
        user = new UsersPage();
    }


    @FindBy(xpath = "//*[contains(@class,'MuiSelect-select')]")
    public WebElement unitTypeField;

    @FindBy(xpath = "//*[contains(@class,'MuiInputLabel-root')]")
    public WebElement unitTypeLabel;

    @FindBy(xpath = "//*[contains(@class,'MuiFormHelperText')]")
    public WebElement unitTypeErrorMsg;

    @FindBy(xpath = "(//*[contains(@class,'MuiSelect-select')])[2]")
    public WebElement serviceProviderField;

    @FindBy(xpath = "(//*[contains(@class,'MuiSelect-select')])[3]")
    public WebElement simCardNoField;

    @FindBy(id = "unitNo")
    public WebElement unitNoField;

    @FindBy(id = "unitNo-label")
    public WebElement unitNoLabel;

    @FindBy(id = "unitNo-helper-text")
    public WebElement unitNoErrorMsg;

    @FindBy(name = "manufacturer")
    public WebElement manufacturerNoField;

    @FindBy(xpath = "(//*[contains(@class,'MuiInputLabel-root')])[5]")
    public WebElement manufacturerNoLabel;

    @FindBy(xpath = "(//*[contains(@class,'MuiFormHelperText')])[5]")
    public WebElement manufacturerNoErrorMsg;

    @FindBy(name = "imei")
    public WebElement imeiField;

    @FindBy(xpath = "(//*[contains(@class,'MuiInputLabel-root')])[7]")
    public WebElement imeiLabel;

    @FindBy(xpath = "(//*[contains(@class,'MuiFormHelperText')])[7]")
    public WebElement imeiErrorMsg;

    @FindBy(name = "dataUsage")
    public WebElement simDataUsageField;

    @FindBy(xpath = "(//*[contains(@class,'MuiInputLabel-root')])[8]")
    public WebElement simDataUsageLabel;

    @FindBy(xpath = "(//*[contains(@class,'MuiFormHelperText')])[8]")
    public WebElement simDataUsageErrorMsg;


    public void unitsScreen() {
        actionsPage.clickOnSubMenu(actionsPage.managementMenu, "Management", actionsPage.unitsSubMenu, "Units");
    }

    public void fillUnitsDetails(String unitNo, String manufacturer, String imei, String simDataUsage) {
        TestWaits.threadSleep(1000);
        actionsPage.enterDropdown(unitTypeField, "Unit type", DataUtils.unitType.get(0), "Unit Type");
        InputActions.clickAndSend(unitNoField, "Unit Number", unitNo);
        actionsPage.enterDropdown(serviceProviderField, "Service Provider", DataUtils.serviceProvider.get(0), "Service Provider");
        InputActions.click(simCardNoField, "Service Provider");
        if (tablePage.recordsPerPageList.size() > 0) {
            InputActions.click(tablePage.recordsPerPageEntry2, tablePage.recordsPerPageEntry2.getText());
        } else {
            log("skip", "Sim Card Number is not available in the Sim Card Number dropdown");
            throw new SkipException("Sim Card Number is not available in the Sim Card Number dropdown");
        }
        InputActions.clickAndSend(manufacturerNoField, "Manufacturer", manufacturer);
        actionsPage.enterDatepicker(user.validityDatepicker, "27-01-2022", "2022-01-27");
        InputActions.clickAndSend(imeiField, "IMEI", imei);
        InputActions.clickAndSend(simDataUsageField, "Sim Data Usage Limit", simDataUsage);
    }


    public void addUnit() {
        unitNo = DataUtils.randomInt(10);
            fillUnitsDetails(unitNo, DataUtils.randomString(5),
                    DataUtils.randomInt(10), DataUtils.randomInt(1));
        actionsPage.clickSaveBtn();
        TestWaits.threadSleep(2000);
        alertMessage = actionsPage.alertMessage.getText();
        TestUtils.assertEquals(prop.getProperty("unitAdded"), alertMessage);
        try {
            log("pass", "New Unit has been created");
            log("info", "<span style='color:green'>" + alertMessage + "</span>" + " message is displayed");
        } catch (AssertionError e) {
            log("fail", "Unit is not created");
        }
        if (Boolean.parseBoolean(prop.getProperty("Database"))) {
            NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Units]", "UnitNo", unit.unitNo);
        }
    }

    public void cancelUnit() {
        String unitNo = DataUtils.randomInt(10);
        fillUnitsDetails(unitNo, DataUtils.randomString(5),
                DataUtils.randomInt(10), DataUtils.randomInt(1));
        TestWaits.threadSleep(2000);
        actionsPage.clickCancelBtn();
        TestWaits.threadSleep(3000);
        String value = tablePage.retrieveRecord(prop.getProperty("unitNo"), unitNo, tablePage.tableCell3);
        Assert.assertTrue(value==null);
        try {
            log("pass", "Unit details are not added on clicking Cancel button");
        } catch (Exception e) {
            log("fail", "Unit details are added on clicking Cancel button");
        }
    }


}
