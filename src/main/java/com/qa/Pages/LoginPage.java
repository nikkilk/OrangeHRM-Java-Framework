package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.Utils.TestWaits.explicitWaitUntilClickable;
import static com.qa.Utils.TestWaits.explicitWaitUntilVisible;

public class LoginPage extends TestBase  {

	// Initialize all page objects for the given driver instance
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);

	}

	@FindBy(xpath = "(//*[text()='LOGIN' or text()='ログイン'])[1]")
	public WebElement loginHeader;

	@FindBy(id = "username")
    public
    WebElement username;

	@FindBy(xpath = "//*[@id='username-label']")
	public WebElement usernameText;

	@FindBy(id="username-helper-text")
	public WebElement usernameErrorMsg;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//*[@id='password-label']")
	public WebElement passwordText;

	@FindBy(xpath = "//*[contains(@class,'MuiFormControl-fullWidth')][2]")
	WebElement passwordField;

	@FindBy(id="password-helper-text")
	public WebElement passwordErrorMsg;

	@FindBy(xpath="//button[@type='button']")
	public WebElement eyeIcon;

	@FindBy(name = "rememberme")
	WebElement checkBox;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement loginButton;

	@FindBy(xpath="//button[@type='submit']/span[text()]")
	public WebElement loggingText;

	@FindBy(xpath = "//a[@href='http://www.mcinc-products.jp/en/']")
	WebElement mcHyperlink;

	@FindBy(xpath = "//*[@href='/Forget']")
	public WebElement forgotPasswordBtn;

	@FindBy(xpath = "//h5/span")
	public WebElement forgotPasswordHeader;

	@FindBy(xpath = "//h6/span")
	public WebElement forgotPasswordText;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement resetPasswordButton;

	@FindBy(xpath = "//button[@type='button']")
	public WebElement cancelButton;

	@FindBy(id="canv")
	WebElement captcha;

	@FindBy(id="captcha")
	WebElement captchaTextbox;

	@FindBy(id="reload_href")
	WebElement reloadCaptcha;

	@FindBy(xpath="//*[@class='MuiAlert-action']/button[@type='button']")
	WebElement alertMessageDialog;

	@FindBy(className = "MuiAlert-message")
	WebElement alertMessageText;


	public void enterUsername(String usn) {
		InputActions.clickAndSend(username, "Username", usn);
	}

	public void enterPassword(String pwd) {
		InputActions.clearWebField(password);
		password.sendKeys(pwd);
	}

	public void loginBtnClick() {
		loginButton.click();
	}

	public void login() {
		InputActions.clickAndSend(username, "Username", DataUtils.username);
		enterPassword(DataUtils.password);
		loginBtnClick();
	}

	public void cancelBtnClick() {
		InputActions.click(cancelButton, "Cancel button");
	}

	public void dashboardDisplay() {
		dash = new DashboardPage();
		login();
		explicitWaitUntilVisible(dash.allVehiclesCount);
	}

	public String usernameErrorMessage() {
		return usernameErrorMsg.getText();
	}

	public String passwordErrorMessage() {
		return passwordErrorMsg.getText();
	}

	public void usernamePasswordFieldAlignment() {
		int usernameYCoordinate = ElementUtils.getElementYCoordinate(username, "Username");
		int passwordYCoordinate = ElementUtils.getElementYCoordinate(password, "Password");
		try {
		TestUtils.assertEquals(usernameYCoordinate, passwordYCoordinate);
			log("pass", "Username and Password Y-coordinates are identical");
		} catch(AssertionError e) {
			log("fail", "Username and Password Y-coordinates are not identical");
		}
	}

	public void usernamePasswordFieldsWidth() {
		int usernameWidth = ElementUtils.getElementWidth(username, "Username");
		int passwordWidth = ElementUtils.getElementWidth(passwordField, "Password");
		try {
		TestUtils.assertEquals(usernameWidth, passwordWidth);
		log("pass", "Username and Password fields width are same");
		} catch(AssertionError e) {
			log("fail", "Username and Password fields width are not same");
		}
	}

	public void usernamePasswordFieldsHeight() {
		int usernameHeight = ElementUtils.getElementWidth(username, "Username");
		int passwordHeight = ElementUtils.getElementWidth(passwordField, "Password");
		try {
		TestUtils.assertEquals(usernameHeight, passwordHeight);
			log("pass", "Username and Password fields height are same");
		} catch (AssertionError e) {
			log("fail", "Username and Password fields height are not same");
		}
	}

	public void rememberMe()  {
		enterUsername(DataUtils.username);
		enterPassword(DataUtils.password);
		if (checkBox.isEnabled()) {
			checkBox.click();
		}
		log("indo", "Remember Me checkbox is selected");
		loginBtnClick();
		actionsPage = new ActionsPage();
		explicitWaitUntilClickable(actionsPage.userProfileMenu, "User Profile menu");
		actionsPage.clickLogoutBtn();
		TestWaits.threadSleep(10000);
		loginBtnClick();
		TestWaits.threadSleep(2000);
	}

	public void forgotPassword() {
		InputActions.click(forgotPasswordBtn, "Forgot Password button");
	}

	public void resetPassword() {
		InputActions.click(resetPasswordButton, "Reset Password button");
	}

	public void forgotPasswordCancel() {
		InputActions.click(cancelButton, "Forgot Password Cancel button");
	}

	public String alertMessageText() {
		TestWaits.explicitWaitUntilVisible(alertMessageText);
		return alertMessageText.getText();
	}

	public void alertMessageClick() {
		TestWaits.explicitWaitUntilClickable(alertMessageDialog, "Alert Dialog Close button");
	}

	public void mcHyperlink() {
		InputActions.click(mcHyperlink, "MC Website hyperlink");
	}

}
