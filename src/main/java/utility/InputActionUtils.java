package utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.DriverManager;
import enums.ExtentEnums;

public class InputActionUtils {
	
	public static void click(WebElement element, String elementName) {
		element.click();
		LoggerUtils.log(ExtentEnums.INFO, "Clicked on "+elementName);
	}
	
	public static void sendkeys(WebElement element, String input, String elementName) {
		element.clear();
		element.sendKeys(input);
		LoggerUtils.log(ExtentEnums.INFO, "Entered "+input+" in the "+elementName+" field");
	}
	
	public static void clickAndSend(WebElement element, String input, String elementName) {
		click(element, elementName);
		sendkeys(element, input, elementName);
	}
	
	public static void clickEscape(WebElement element) {
		new Actions(DriverManager.getDriver()).sendKeys(Keys.ESCAPE);
	}

}
