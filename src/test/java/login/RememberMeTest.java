package login;



import com.qa.Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RememberMeTest extends TestBase  {
	
	@BeforeClass
	public void preSetup() {
		init();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"\"This method verifies Remember Me functionality in Login screen\"")
	public void TC_rememberMe()  {
		login.rememberMe();
		Assert.assertTrue(dash.dashboardScreen());
		try {
		log("pass", "Username and Password are Remembered");
		} catch (AssertionError e) {
			log("fail", "Username and Password are not Remembered");
		}
	}

}
