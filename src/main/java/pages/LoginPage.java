package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import enums.YamlEnums;
import utility.DataUtils;
import utility.InputActionUtils;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(name = "username")
	WebElement usernameField;
	
	@FindBy(name = "password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	
	public LoginPage setUsername(String usn) {
		InputActionUtils.sendkeys(usernameField, usn, "Username");
		return this;
	}
	
	public LoginPage setPassword(String pwd) {
		InputActionUtils.sendkeys(passwordField, pwd, "Password");
		return this;
	}
	
	public void clickLoginButton() {
		InputActionUtils.click(loginButton, "Login Button");
	}
	
	public HomePage login() {
		setUsername(DataUtils.yamlData(YamlEnums.Username, 0))
		.setPassword(DataUtils.yamlData(YamlEnums.Password, 0))
		.clickLoginButton();
		return new HomePage();
	}
	
	

}
