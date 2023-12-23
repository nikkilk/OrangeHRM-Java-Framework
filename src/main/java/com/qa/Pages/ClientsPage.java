package com.qa.Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Utils.InputActions;
import com.qa.Utils.TestWaits;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClientsPage extends TestBase  {

	// Initialize all page objects for the given driver instance
	public ClientsPage() {
		PageFactory.initElements(getDriver(), this);
		actionsPage = new ActionsPage();
	}
	
	private String clientName;
	private String mobileNumber;
	private String email;
	private String clientContactPerson;
	private String numberOfUnits;
	private String numberOfUsers;
	private String validity;
	private String accountManager;
	private String deviceType;
	private String address;
	private String city;
	private String country;

	
	@FindBy(id="clientname")
	public WebElement clientNameField;
	
	
	@FindBy(id="mobilenomobileno")
	WebElement mobileNoField;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="contactperson")
	WebElement contactPersonField;
	
	@FindBy(id="noOfvehicles")
	WebElement NumberOfUnitsField;
	
	@FindBy(id="noOfUsers")
	WebElement NumberOfUsersField;
	
	@FindBy(id="date")
	WebElement validityField;
	
	@FindBy(id="address")
	WebElement addressField;
	
	@FindBy(id="city")
	WebElement cityField;
	
	@FindBy(id="country")
	WebElement countryField;
	
	@FindBy(id="accManager")
	WebElement accountManagerField;
	
	@FindBy(id="mui-2285")
	WebElement deviceTypeField;
	
	@FindBy(id="date")
	WebElement validityDatepicker;
	

	public void clientsScreen() {
		actionsPage.clickOnSubMenu(actionsPage.managementMenu, "Management", actionsPage.clientsSubMenu,  "Clients");
	}
	

	
	public void enterClientName(String name) {
		InputActions.clearWebField(clientNameField);
		clientNameField.sendKeys(name);
		log("info", "Entered Client Name is " + "<b>" + name + "</b>");
	}
	
	private String fillClientForm() {
		clientNameField.sendKeys(getClientName());
		mobileNoField.sendKeys(getMobileNumber());
		emailField.sendKeys(getEmail());
		contactPersonField.sendKeys(getClientContactPerson());
		NumberOfUnitsField.sendKeys(getNumberOfUnits());
		NumberOfUsersField.sendKeys(getNumberOfUsers());
		validityField.sendKeys(getEmail());
		accountManagerField.sendKeys(getAccountManager());
		deviceTypeField.sendKeys(getDeviceType());
		emailField.sendKeys(getEmail());
		emailField.sendKeys(getEmail());
		addressField.sendKeys(getAddress());
		cityField.sendKeys(getCity());
		countryField.sendKeys(getCountry());
		actionsPage.clickSaveBtn();
		return actionsPage.alertMessage.getText();
	}
	
	public String addAddress() {
		return fillClientForm();
	}
	
	public String updateAddress(String fName) {
		getDriver().findElement(By.xpath("//td[text()='"+fName+"']//following-sibling::td/a[[text()='Edit']")).click();
		return fillClientForm();
	}
	
	public String deleteAddress(String fName) {
		getDriver().findElement(By.xpath("//td[text()='"+fName+"']//following-sibling::td/a[[text()='Delete']")).click();
		TestWaits.explicitWaitUntilAlertIsPresent();
		return actionsPage.alertMessage.getText();
	}
	
	public String getAddress(String fName) {
		getDriver().findElement(By.xpath("//td[text()='"+fName+"']//following-sibling::td/a[[text()='Show']")).click();
		return actionsPage.alertMessage.getText();
	}
	
	
	
}
