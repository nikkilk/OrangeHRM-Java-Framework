package otherTests;

import com.qa.Base.DriverFactory;
import com.qa.Base.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utils.NonFunctional;
import com.qa.Utils.TestWaits;

public class SecurityTest extends TestBase {


	@BeforeClass
	public void setup() {
		DriverFactory driverFactory = new DriverFactory();
		driverFactory.zapBrowserConfigure();
		selectUrl();
		pagesConstructors();
	}
	
	@AfterClass
	public void generateSecurityReport() {
		NonFunctional.zapReport();
	}

	
	
	@Test(priority = 1)
	public void TC_beforeLoginSecurityScan() {
		TestWaits.threadSleep(2000);
		System.out.println("Analyzed Security vulnerabilities before login");
	}

	@Test(priority = 2)
	public void TC_afterLoginSecurityScan() {
		login.dashboardDisplay();
		TestWaits.threadSleep(2000);
		System.out.println("Analyzed Security vulnerabilities after login");
	}



	@Test(priority = 3)
	public void TC_videoplaybackScan() {
		actionsPage.clickSidebarMenuButton();
		TestWaits.threadSleep(500);
		actionsPage.trackMenu.click();
		actionsPage.videoplaybackSubMenu.click();
		TestWaits.threadSleep(2000);
		System.out.println("Analyzed Security vulnerabilities after login");
	}

	@Test(priority = 4)
	public void TC_customReportsScan() {
		actionsPage.clickSidebarMenuButton();
		TestWaits.threadSleep(500);
		actionsPage.reportMenu.click();
		actionsPage.customReportsSubMenu.click();
		TestWaits.threadSleep(2000);
		System.out.println("Analyzed Security vulnerabilities after login");
	}

	@Test(priority = 5)
	public void TC_driverReportsScan() {
		actionsPage.clickSidebarMenuButton();
		TestWaits.threadSleep(500);
		actionsPage.reportMenu.click(); 
		actionsPage.driverReportSubMenu.click();
		TestWaits.threadSleep(2000);
		System.out.println("Analyzed Security vulnerabilities after login");
	}

	@Test(priority = 6)
	public void TC_vehicleReportsScan() {
		TestWaits.threadSleep(500);
		actionsPage.reportMenu.click();
		actionsPage.vehicleReportSubMenu.click();
		TestWaits.threadSleep(2000);
		System.out.println("Analyzed Security vulnerabilities after login");
	}

	@Test(priority = 7)
	public void TC_managementScan() {
		TestWaits.threadSleep(500);
		actionsPage.managementMenu.click();
		actionsPage.clientsSubMenu.click();
		actionsPage.clickAddBtn();
		TestWaits.threadSleep(2000);
		System.out.println("Analyzed Security vulnerabilities after login");
	}

	@Test(priority = 8)
	public void TC_onMapScan() {
		actionsPage.clickSidebarMenuButton();
		TestWaits.threadSleep(500);
		actionsPage.trackMenu.click();
		actionsPage.onMapSubMenu.click();
		TestWaits.threadSleep(2000);
		System.out.println("Analyzed Security vulnerabilities after login");
	}

}
