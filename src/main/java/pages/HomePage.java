package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement DashboardHeader;
	
	public String dashboardText() {
		return DashboardHeader.getText();
	}

}
