package loginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	@Test
	public void validUsernameAndPassword() {
		new LoginPage().login();
		Assert.assertEquals("Dashboard"	, new HomePage().dashboardText());
	}

}
