package login;

import static com.qa.Utils.TestUtils.assertEquals;
import static com.qa.Utils.TestUtils.colorVerify;
import static com.qa.Utils.TestUtils.verifyImage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Utils.ElementUtils;
import com.qa.Utils.ExtentReport;
import com.qa.Utils.InputActions;
import com.qa.Utils.TestUtils;

public class LoginPageTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login Page header\"")
	public void TC_loginPageHeader() {
		TestUtils.assertEquals(prop.getProperty("Login"), login.loginHeader.getText());
		try {
		log("pass", "<b>"+login.loginHeader.getText()+"</b>"+" Page Header name is displayed");
		} catch (AssertionError e) {
			log("fail", "Page Header name is not displayed");
		}
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Login Page logo\"")
	public void TC_loginPageLogo() {
		verifyImage("Login", System.getProperty("user.dir")+ "/ImageFiles/UyenoLogo.png");
		ExtentReport.attachScreenshotInReport(System.getProperty("user.dir")+ "/ImageFiles/UyenoLogo.png");
	}
	

	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Login Page Title\"")
	public void TC_loginTitle() {
		TestUtils.verifyPageTitle("fullname", prop.getProperty("FmsLogin")+"-Test", "Login");
	}
	
	@Test(groups = "ui", description = "<em><b>"+"\"This method verifies Login button background color\"")
	public void TC_loginBtnBackgroundColor() {
		InputActions.navigateBack();
		colorVerify(login.loginButton, "Login button", prop.getProperty("LoginBtn"));
	}
	
//	@Test(groups = "functional", description = "<emb>"+"\"This method checks for broken links in Login Page\"")
	public void TC_loginPageBrokenLinks() {
		ElementUtils.brokenLinks();
	}
	
//	@Test(groups = "functional", description = "<emb>"+"\"This method checks for broken images in Login Page\"")
	public void TC_loginPageBrokenImages() {
		ElementUtils.brokenImages();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies clicking on Mobile Create hyperlink navigates to their official site\"")
	public void TC_mcSiteHyperlink() {
		login.mcHyperlink();
		assertEquals(getDriver().getCurrentUrl(), prop.getProperty("MCURL"));
		try {
		log("info", "Navigated to MC website");
		} catch (AssertionError e) {
			log("info", "Unable to Navigate to MC website");
		}
	}
	
	@Test(groups = "functional", priority=1, description = "<em><b>"+"\"This method verifies Logging is displayed on clicking login button\"")
	public void TC_logging() {
		if(getDriver().getTitle().equalsIgnoreCase("Mobile Create")) {
			InputActions.navigateBack();  
		}
		login.login();
		TestUtils.assertEquals(prop.getProperty("LoggingIn"), login.loggingText.getText());
		try {
		log("pass", "Upon clicking the Login button, logging is displayed");
		} catch (Exception e) {
			log("fail", "Upon clicking the Login button, logging is not displayed");
		}
	}

}
