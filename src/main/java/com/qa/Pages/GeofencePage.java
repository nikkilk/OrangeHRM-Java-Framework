package com.qa.Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GeofencePage extends TestBase {
	
	public GeofencePage() {
		PageFactory.initElements(getDriver(), this);
		actionsPage = new ActionsPage();
		dash = new DashboardPage();
	}
	
	
	@FindBy(xpath="//h5")
	WebElement geofencePageHeader;
	
	public void geofenceScreen()  {
		actionsPage.clickOnSubMenu(actionsPage.managementMenu, "Management", actionsPage.geofenceSubMenu,  "Geofence");
	}

}
