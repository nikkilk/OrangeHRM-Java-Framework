package com.qa.Pages;

import com.qa.Base.TestBase;
import com.qa.Utils.ElementUtils;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.qa.Utils.TestUtils.assertTrue;
import static com.qa.Utils.TestUtils.isDisplayed;

public class DashboardPage extends TestBase {

	public String records;
	public static int count;
	public int movingCount;
	public int movingPercent;
	public int stoppedCount;
	public int stoppedPercent;
	public int idleCount;
	public int idlePercent;
	public int inactiveCount;
	public int inactivePercent;
	public int operationCount;
	public int operationPercent;
	public int allCount;
	public int allPercent;
	public int totalCount;
	public int totalPercent;

	// Initialize all page objects for the given driver instance
	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//h5)[1]")
	public WebElement dashboardText;
	
	@FindBy(xpath = "(//h5)[2]")
	public WebElement todaysAlertText;
	
	@FindBy(xpath = "(//h5)[3]")
	public WebElement dynamicStatusText;

	@FindBy(xpath = "//*[contains(@class,'grid-md-6')]//*[contains(@class,'MuiGrid-spacing-xs-2')]")
	WebElement VehicleStatus;

	@FindBy(xpath = "//div[contains(@style, 'pan-x')]")
	public WebElement map;

	@FindBy(xpath = "//h2")
	List<WebElement> vehicleCount;

	@FindBy(xpath = "//h4")
	List<WebElement> vehiclePercent;

	@FindBy(xpath = "(//main)[1]")
	public WebElement movingVehicleColor;

	@FindBy(xpath = "(//*[name()='article']//*[name()='svg'])[1]")
	public WebElement movingVehicleIcon;

	@FindBy(xpath = "(//a[@href='#'])[1]")
	WebElement movingVehicleDetails;

	@FindBy(xpath = "(//a[normalize-space()='View On Map' or normalize-space()='地図表示'])[1]")
	WebElement movingVehicleMap;

	@FindBy(xpath = "(//h2)[1]")
	WebElement movingVehicleCount;

	@FindBy(xpath = "(//h4)[1]")
	WebElement movingVehiclePercent;

	@FindBy(xpath = "(//main)[2]")
	public WebElement stoppedVehicleColor;

	@FindBy(xpath = "(//*[name()='article']//*[name()='svg'])[2]")
	public WebElement stoppedVehicleIcon;

	@FindBy(xpath = "(//a[@href='#'])[2]")
	WebElement stoppedVehicleDetails;

	@FindBy(xpath = "(//a[normalize-space()='View On Map' or normalize-space()='地図表示'])[2]")
	WebElement stoppedVehicleMap;

	@FindBy(xpath = "(//h2)[2]")
	WebElement stoppedVehicleCount;

	@FindBy(xpath = "(//h4)[2]")
	WebElement stoppedVehiclePercent;

	@FindBy(xpath = "(//main)[3]")
	public WebElement idleVehicleColor;

	@FindBy(xpath = "(//*[name()='article']//*[name()='svg'])[3]")
	public WebElement idleVehicleIcon;

	@FindBy(xpath = "(//a[@href='#'])[3]")
	WebElement idleVehicleDetails;

	@FindBy(xpath = "(//a[normalize-space()='View On Map' or normalize-space()='地図表示'])[3]")
	WebElement idleVehicleMap;

	@FindBy(xpath = "(//h2)[3]")
	WebElement idleVehicleCount;

	@FindBy(xpath = "(//h4)[3]")
	WebElement idleVehiclePercent;

	@FindBy(xpath = "(//main)[4]")
	public WebElement inactiveVehicleColor;

	@FindBy(xpath = "(//*[name()='article']//*[name()='svg'])[4]")
	public WebElement inactiveVehicleIcon;

	@FindBy(xpath = "(//a[@href='#'])[4]")
	WebElement inactiveVehicleDetails;

	@FindBy(xpath = "(//a[normalize-space()='View On Map' or normalize-space()='地図表示'])[4]")
	WebElement inactiveVehicleMap;

	@FindBy(xpath = "(//h2)[4]")
	WebElement inactiveVehicleCount;

	@FindBy(xpath = "(//h4)[4]")
	WebElement inactiveVehiclePercent;

	@FindBy(xpath = "(//main)[5]")
	public WebElement operationVehicleColor;

	@FindBy(xpath = "(//*[name()='article']//*[name()='svg'])[5]")
	public WebElement operationVehicleIcon;

	@FindBy(xpath = "(//a[@href='#'])[5]")
	WebElement operationVehicleDetails;

	@FindBy(xpath = "(//*[normalize-space()='View On Map' or normalize-space()='地図表示'])[5]")
	WebElement operationVehicleMap;

	@FindBy(xpath = "(//h2)[5]")
	WebElement operationVehicleCount;

	@FindBy(xpath = "(//h4)[5]")
	WebElement operationVehiclePercent;

	@FindBy(xpath = "(//main)[6]")
	public WebElement allVehiclesColor;

	@FindBy(xpath = "(//*[name()='article']//*[name()='svg'])[6]")
	WebElement allVehicleIcon;

	@FindBy(xpath = "(//a[@href='#'])[6]")
	WebElement allVehiclesDetails;

	@FindBy(xpath = "(//*[normalize-space()='View On Map' or normalize-space()='地図表示'])[6]")
	WebElement allVehiclesMap;

	@FindBy(xpath = "(//h2)[6]")
	public WebElement allVehiclesCount;

	@FindBy(xpath = "(//h4)[6]")
	WebElement allVehiclesPercent;

	@FindBy(xpath = "//h5")
	WebElement movingVehiclesList;
	
	@FindBy(xpath="(//div[contains(@class,'MuiGrid-grid-sm-12 MuiGrid-grid-md-6')])[3]//*[@role='row']")
	public List<WebElement> todaysAlertTableRows;

	@FindBy(xpath = "//main/button[@type='button']")
	public WebElement moreDetails;

	@FindBy(xpath = "(//main/button[@type='button'])[2]")
	public WebElement weeklyAlertToggle;

	@FindBy(xpath = "(//main/button[@type='button'])[3]")
	public WebElement dailyAlertToggle;
	
	@FindBy(xpath = "(//main/button[@type='button'])[2]/span")
	public WebElement dailyAlertToggleText;
	
	@FindBy(xpath = "(//main/button[@type='button'])[3]/span")
	public WebElement weeklyAlertToggleText;

	@FindBy(xpath = "//*[@class='recharts-layer recharts-bar-rectangles']//*[name()='g']")
	List<WebElement> alertGraphBars;
	
	@FindBy(xpath="//*[contains(@class,'recharts-label-list')]/*[name()='text']")
	List<WebElement> alertGraphBarCount;
	
	@FindBy(xpath="(//*[contains(@class,'recharts-label-list')]/*[name()='text'])[5]")
	List<WebElement> todaysAlertCount;

	@FindBy(xpath = "//*[@data-field='DelayEnable']/button")
	WebElement powerOffdelay;


	public boolean dashboardScreen() {
		return isDisplayed(dashboardText);
	}

	public void verifyVehicleStatusAndMapHeight() {
		int vehicleStatusHeight = ElementUtils.getElementHeight(VehicleStatus, "Vehicle Status");
		int mapHeight = ElementUtils.getElementHeight(map, "Map");
		try {
		TestUtils.assertEquals(vehicleStatusHeight, mapHeight);
		log("pass", "Vehicle Status and Map height are same");
		} catch (AssertionError e) {
			log("fail", "Vehicle Status and Map height are different");
		}
	}
	
	public void charts() {
		int totalBars = alertGraphBars.size();
		log("info", "Number of bars " + totalBars);
		Actions ac = new Actions(getDriver());
		for (WebElement e : alertGraphBars) {
			ac.moveToElement(e).perform();
			String text = e.getText();
			System.out.println(text);
		}
	}
	
	public void weeklyAlerts() {
		TestWaits.threadSleep(500);
		weeklyAlertToggle.click();
		charts();
	}
	
	public void dailyAlerts() {
		Assert.assertTrue(dailyAlertToggle.isDisplayed());
		dailyAlertToggle.click();
		charts();
	}


	public void viewDetails(int count, String status, String message) {
		log("info", status + " Vehicle count: " + "<b>" + count);
		if (count > 0) {
			assertTrue(prop.getProperty(status));
			log("info", status + " Vehicle List is displayed");
		} else {
			String actualMessage = prop.getProperty(message);
			assertTrue(actualMessage);
			log("info", "<span style='color:blue'>" + actualMessage + "</span>" + " message is displayed");
		}
	}

	public void viewOnMap(int count, String status, String message) {
		log("info", status + " Vehicle count: " + "<b>" + count);
		if (count > 0) {
			assertTrue(prop.getProperty(status));
			onMap = new OnMapPage();
			isDisplayed(onMap.trackLiveBtn);
			log("info", "Navigated to Track on Map screen");
		} else {
			String actualMessage = prop.getProperty(message);
			assertTrue(actualMessage);
			log("info", "<span style='color:blue'>" + actualMessage + "</span>" + " message is displayed");
		}
	}

	public int movingCount() {
		movingCount = TestUtils.stringToInt(movingVehicleCount);
		log("info", "Moving vehicles count: " + "<b>" + movingCount);
		return movingCount;
	}

	public int movingPercent() {
		movingPercent = TestUtils.extractInt(movingVehiclePercent);
		log("info", "Moving vehicles Percent: " + "<b>" + movingPercent + "%");
		return movingPercent;
	}

	public void movingViewDetails() {
		movingVehicleDetails.click();
		viewDetails(movingCount, "Moving", "warnNoMoving");
	}

	public void movingViewOnMap() {
		TestWaits.explicitWaitUntilClickable(movingVehicleMap, "Moving vehicles View on Map");
		viewOnMap(movingCount, "Moving", "warnNoMoving");
	}

	public int stoppedCount() {
		stoppedCount = TestUtils.stringToInt(stoppedVehicleCount);
		log("info", "Stopped vehicles count: " + "<b>" + stoppedCount);
		return stoppedCount;
	}

	public int stoppedPercent() {
		stoppedPercent = TestUtils.extractInt(stoppedVehiclePercent);
		log("info", "Stopped vehicles Percent: " + "<b>" + stoppedPercent + "%");
		return stoppedPercent;
	}

	public void stoppedViewDetails() {
		stoppedVehicleDetails.click();
		viewDetails(stoppedCount, "Stopped", "warnNoStopped");
	}

	public void stoppedViewOnMap() {
		TestWaits.explicitWaitUntilClickable(stoppedVehicleMap, "Stopped vehicle View on Map");
		viewOnMap(stoppedCount, "Stopped", "warnNoStopped");
	}

	public int idleCount() {
		idleCount = TestUtils.stringToInt(idleVehicleCount);
		log("info", "Idle vehicles count: " + "<b>" + idleCount);
		return idleCount;
	}

	public int idlePercent() {
		idlePercent = TestUtils.extractInt(idleVehiclePercent);
		log("info", "Idle vehicles Percent: " + "<b>" + idlePercent + "%");
		return idlePercent;
	}

	public void idleViewDetails() {
		idleVehicleDetails.click();
		viewDetails(idleCount, "Idle", "warnNoIdle");
	}

	public void idleViewOnMap() {
		TestWaits.explicitWaitUntilClickable(idleVehicleMap, "Idle vehicle View on Map");
		viewOnMap(idleCount, "Idle", "warnNoMoving");
	}

	public int inactiveCount() {
		inactiveCount = TestUtils.stringToInt(inactiveVehicleCount);
		log("info", "Inactive vehicles count: " + "<b>" + inactiveCount);
		return inactiveCount;
	}

	public int inactivePercent() {
		inactivePercent = TestUtils.extractInt(inactiveVehiclePercent);
		log("info", "Inactive vehicles Percent: " + "<b>" + inactivePercent + "%");
		return inactivePercent;
	}

	public void inactiveViewDetails() {
		inactiveVehicleDetails.click();
		viewDetails(inactiveCount, "Inactive", "warnNoInactive");
	}

	public void inactiveViewOnMap() {
		TestWaits.explicitWaitUntilClickable(inactiveVehicleMap, "Inactive vehicle View on Map");
		viewOnMap(inactiveCount, "Inactive", "warnNoMoving");
	}

	public int operationCount() {
		operationCount = TestUtils.stringToInt(operationVehicleCount);
		log("info", "Operation vehicles count: " + "<b>" + operationCount);
		return operationCount;
	}

	public int operationPercent() {
		operationPercent = TestUtils.extractInt(operationVehiclePercent);
		log("info", "Operation vehicles Percent: " + "<b>" + operationPercent + "%");
		return operationPercent;
	}

	public void operationViewDetails() {
		operationVehicleDetails.click();
		viewDetails(operationCount, "Operation", "warnNoOperation");
	}

	public void operationViewOnMap() {
		TestWaits.explicitWaitUntilClickable(operationVehicleMap, "Operation vehicle View on Map");
		viewOnMap(operationCount, "Operation", "warnNoMoving");
	}

	public int allCount() {
		allCount = TestUtils.stringToInt(allVehiclesCount);
		log("info", "All vehicles count: " + "<b>" + allCount);
		for (int i = 0; i < vehicleCount.size() - 1; i++) {
			int number = TestUtils.stringToInt(vehicleCount.get(i));
			totalCount += number;
		}
		log("info", "Sum of Moving, Stopped, Idle, Inactive and Operation vehicles Count: "+"<b>"+totalCount);
		return allCount;
	}

	public int allPercent() {
		allPercent = TestUtils.extractInt(allVehiclesPercent);
		log("info", "All vehicles Percent: " + "<b>" + allPercent + "%");
		for (int i = 0; i < vehiclePercent.size() - 1; i++) {
			int number = TestUtils.extractInt(vehiclePercent.get(i));
			totalPercent += number;
		}
		log("info", "Sum of Moving, Stopped, Idle, Inactive and Operation vehicles percent: "+"<b>"+totalPercent+"%");
		return allPercent;
	}

	public void allViewDetails() {
		allVehiclesDetails.click();
		viewDetails(allCount, "All Vehicles", "no");
	}

	public void allViewOnMap() {
		TestWaits.explicitWaitUntilClickable(allVehiclesMap, "All vehicles View on Map");
		viewOnMap(allCount, "All", "warnNoMoving");
	}

}
