package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class UsersPage extends TestBase {
	public String alertMessage;
	public String firstName;
	public String loginName;
	
	public UsersPage() {
		PageFactory.initElements(getDriver(), this);
		actionsPage = new ActionsPage();
		tablePage = new TablePage();
	}
	
	
	
	@FindBy(xpath = "//*[contains(@class,'MuiSelect-select MuiSelect-outlined')]")
	WebElement clientName;
	
	@FindBy(xpath = "//li[@role='option']")
	WebElement clientNameList;
	
	@FindBy(id = "loginPwd")
	public WebElement loginPasswordField;
	
	@FindBy(id = "loginPwd-helper-text")
	public WebElement loginPasswordErrorMsg;
	
	@FindBy(id = "loginPwd-label")
	public WebElement loginPasswordLabel;
	
	@FindBy(xpath="//*[contains(@class,'MuiIconButton-sizeMedium css')]")
	public WebElement userEyeIcon;
	
	@FindBy(id = "fName")
	public WebElement firstNameField;
	
	@FindBy(id = "fName-label")
	public WebElement firstNameLabel;
	
	@FindBy(id = "fName-helper-text")
	public WebElement firstNameErrorMsg;
	
	@FindBy(id = "lName")
	public WebElement lastNameField;
	
	@FindBy(id = "lName-label")
	public WebElement lastNameLabel;
	
	@FindBy(id = "lName-helper-text")
	public WebElement lastNameErrorMsg;
	
	@FindBy(id = "loginName")
	public WebElement loginNameField;
	
	@FindBy(id = "loginName-label")
	public WebElement loginNameLabel;
	
	@FindBy(id = "loginName-helper-text")
	public WebElement loginNameErrorMsg;
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id = "email-label")
	public WebElement emailLabel;
	
	@FindBy(id = "email-helper-text")
	public WebElement emailErrorMsg;
	
	@FindBy(id = "phoneNo")
	public WebElement mobileNoField;
	
	@FindBy(id = "phoneNo-label")
	public WebElement mobileNoLabel;
	
	@FindBy(id = "phoneNo-helper-text")
	public WebElement mobileNoErrorMsg;
	
	@FindBy(xpath = "(//*[contains(@class,'MuiSelect-select MuiSelect-outlined')])[2]")
	public WebElement rolefield;
	
	@FindBy(id = "mui-43-label")
	public WebElement rolelabel;
	
	@FindBy(id = "mui-43-helper-text")
	public WebElement roleErrorMsg;
	
	@FindBy(xpath = "//*[@placeholder='Type to search...' or @placeholder='検索するタイプ...']")
	public WebElement searchField;
	
	@FindBy(xpath = "//li[contains(@class,'MuiListItem-gutters MuiListItem-button')]")
	public WebElement rolesList;
	
	@FindBy(xpath = "//li[normalize-space()='Super Admin']")
	public WebElement superAdminRole;
	
	@FindBy(xpath = "//li[normalize-space()='Command Center']")
	public WebElement commandCenterRole;
	
	@FindBy(xpath = "//li[normalize-space()='Admin']")
	public WebElement adminRole;
	
	@FindBy(xpath = "//li[normalize-space()='User']")
	public WebElement userRole;
	
	@FindBy(id = "date")
	WebElement validityDatepicker;

	@FindBy(id = "date-label")
	public WebElement validityDatepickerLabel;

	@FindBy(id = "date-helper-text")
	public WebElement validityDatepickerErrorMsg;
	
	@FindBy(id = "city")
	public WebElement cityField;
	
	@FindBy(id = "city-label")
	public WebElement cityLabel;
	
	@FindBy(id = "city-helper-text")
	public WebElement cityErrorMsg;
	
	@FindBy(id = "address")
	public WebElement addressField;
	
	@FindBy(id = "address-label")
	public WebElement addressLabel;
	
	@FindBy(id = "address-helper-text")
	public WebElement addressErrorMsg;
	
	
	public void usersScreen() {
		actionsPage.clickOnSubMenu(actionsPage.managementMenu, "Management", actionsPage.usersSubMenu,  "Users");
	}
	
	
	public void fillUserDetails(String firstName, String lastName, String loginName, String pwd, String email, String mobileNo, String city, String address) {
		actionsPage.enterDropdown(clientName, "Client Name", "InfoTrack Telematics Pvt LTD", "Client Name");
		InputActions.sendKeys(firstNameField, "First Name", firstName);
		InputActions.sendKeys(lastNameField, "Last Name", lastName);
		InputActions.sendKeys(loginNameField, "Login Name", loginName);
		InputActions.sendKeys(loginPasswordField, "Login Password", pwd);
		InputActions.sendKeys(emailField, "Email", email);
		InputActions.sendKeys(mobileNoField, "Mobile Number", mobileNo);
		actionsPage.enterDropdown(rolefield, "Roles", "Super Admin", "Roles");
		actionsPage.enterDatepicker(validityDatepicker, "27-01-2022", "2022-01-27");
		InputActions.sendKeys(cityField, "Last Name", city);
		InputActions.sendKeys(addressField, "Last Name", address);
	}
	
	
	public void addUser() {
		firstName = DataUtils.faker.name().firstName();
		loginName = DataUtils.faker.lorem().characters(4, 15);
		while(firstName.length()>3 && firstName.length()<15) {
			firstName = DataUtils.faker.name().firstName();
		}
		fillUserDetails(firstName, DataUtils.faker.name().lastName(),
				loginName, DataUtils.faker.internet().password(6, 15), DataUtils.faker.internet().emailAddress(),
				DataUtils.randomInt(10), DataUtils.faker.address().cityName(), DataUtils.faker.address().fullAddress());
		actionsPage.clickSaveBtn();
		TestWaits.threadSleep(2000);
		alertMessage = actionsPage.alertMessage.getText();
		TestUtils.assertEquals(prop.getProperty("userAdded"), alertMessage);
		try {
			log("pass", "New User has been created");
			log("info", "<span style='color:green'>" + alertMessage + "</span>" + " message is displayed");
		} catch (AssertionError e) {
			log("fail", "User is not created");
		}
		if (Boolean.parseBoolean(prop.getProperty("Database"))) {
			NonFunctional.executeSQLQuery("[MDVRDB].[M].[Tbl_Users]", "firstName", user.firstName);
		}
	}
	
	public void cancelUser() {
		String firstName = DataUtils.faker.name().firstName();
		fillUserDetails(firstName, DataUtils.faker.name().lastName(),
				DataUtils.faker.lorem().characters(4, 15), DataUtils.faker.internet().password(6, 15), DataUtils.faker.internet().emailAddress(),
				DataUtils.randomInt(10), DataUtils.faker.address().cityName(), DataUtils.faker.address().fullAddress());
		TestWaits.threadSleep(2000);
		actionsPage.clickCancelBtn();
		TestWaits.threadSleep(3000);
		String value = tablePage.retrieveRecord(prop.getProperty("UserName"), firstName, tablePage.tableCell4);
		Assert.assertTrue(value == null);
		try {
			log("pass", "SIM details are not added on clicking Cancel button");
		} catch (Exception e) {
			log("fail", "SIM details are added on clicking Cancel button");
		}
	}
	
	
}
