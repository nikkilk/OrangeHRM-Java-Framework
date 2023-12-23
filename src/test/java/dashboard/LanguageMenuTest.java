package dashboard;

import com.qa.Base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utils.TestUtils;

public class LanguageMenuTest extends TestBase {

	@BeforeClass
	public void preSetup() {
		init();
		login.dashboardDisplay();
	}
	
	@Test(groups = "functional", description = "<em><b>"+"This method verifies Japanese language change functionality")
	public void TC_japaneseLanguage() {
		actionsPage.selectJapanese();
		TestUtils.verifyPageTitle("management", "FMS - ダッシュボード", "Dashboard");
		log("info", "Application language is changed to Japanese");
	}


	@Test(groups = "functional", description = "<em><b>"+"This method verifies English language change functionality")
	public void TC_englishLanguage() {
		actionsPage.selectEnglish();
		TestUtils.verifyPageTitle("management", "FMS - Dashboard", "Dashboard");
		log("info", "Application language is changed to English");
	}

}
