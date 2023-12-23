package com.qa.Utils;

import com.qa.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import java.io.File;

public class TestUtils extends TestBase {

	public static String absolutePath;

	// This Method is to create and append current date
	public static String getDate() {
		return new LocalDateTime().now().toString("yyyy-MM-dd HH-mm-ss");
	}

	// This Method is to create and append current Japanese date and time
	public static String getDateJapan() {
		return new LocalDateTime().now(DateTimeZone.forID("Japan")).toString("yyyy-MM-dd HH-mm-ss");
	}

	public static String pastDate(int days) {
		return new LocalDate().now().minusDays(days).toString("yyyy-MM-dd");
	}

	public static String FutureDate(int days) {
		return new LocalDate().now().plusDays(days).toString("yyyy-MM-dd");
	}

	public static String pastHours(int hours) {
		return new LocalDateTime().now().minusHours(hours).toString("HH-mm-ss");
	}

	public static String futureHours(int hours) {
		return new LocalDateTime().now().plusHours(hours).toString("HH-mm-ss");
	}

	// This Method is to capture screenshots and save in local folder
	public static String takeScreenshotAndSave(String SubFolder, String MethodName) {
		try {
			File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			File destFile = new File("src/main/java/com/qa/" + SubFolder + "/" + MethodName + "_" + getDate() + ".png");
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot Taken");
			absolutePath = destFile.getAbsolutePath();
			return destFile.toString();
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot " + e.getMessage());
		}
		return MethodName;
	}

	// This Method is to capture screenshots directly
	public static String takeScreenshot() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	// This method converts String data type to Integer
	public static int stringToInt(WebElement element) {
		String text = element.getText();
		return Integer.parseInt(text);
	}

	// This method extract numbers and converts String data type to Integer
	public static int extractInt(WebElement element) {
		String text = element.getText();
		text = text.replaceAll("\\D", "");
		return Integer.parseInt(text);
	}

	// This method verifies element is displayed
	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// This method verifies element is not displayed
	public static boolean notDisplayed(WebElement element) {
		TestWaits.threadSleep(2000);
		return (!element.isDisplayed());
	}

	// This method return page title
	public static void verifyPageTitle(String moduleType, String expected, String pageName) {
		log("info", "Verifying " + pageName + " page title");
		if (moduleType.equalsIgnoreCase("fullname")) {
			assertEquals(getDriver().getTitle(), expected);
			try {
				log("info", "Page Title is " + "<b>" + expected);
			} catch (AssertionError e) {
				log("fail", "Not able to retrieve Page Title");
			}
		} else if (moduleType.equalsIgnoreCase("partial")) {
			try {
				assertEquals(getDriver().getTitle(), "FMS - " + expected);
				log("info", "Page Title is " + "<b>" + "FMS - " + expected);
			} catch (AssertionError e) {
				log("fail", "Not able to retrieve Page Title");
			}
		}
	}

	// This method return page URL
	public static void verifyPageUrl(String expected, String pageName) {
		log("info", "Verifying " + pageName + " page URL");
		assertEquals(expected, getDriver().getCurrentUrl());
		try {
			log("pass", "Page URL is " + "<b>" + expected);
		} catch (AssertionError e) {
			log("fail", "Not able to retrieve Page URL");
		}
	}

	// This method verifies placeholder text
	public static void getText(String expected, WebElement element, String fieldName) {
		TestWaits.threadSleep(1000);
		try {
			Assert.assertTrue(expected.equalsIgnoreCase(element.getText()));
			log("pass", "<b>" + expected + "</b>" + " text is displayed in the " + fieldName);
		} catch (AssertionError e) {
			log("fail", "<b>" + expected + "</b>" + " text is not displayed in the " + fieldName);
		}
	}

	// This method fetches text already present
	public static void getAttribute(String expected, WebElement element, String attribute) {
		Assert.assertTrue(expected.equalsIgnoreCase(element.getAttribute(attribute)));
		try {
			log("pass", "<b>" + expected + "</b>" + " text is displayed");
		} catch (AssertionError e) {
			log("fail", "<b>" + expected + "</b>" + " text is not displayed");
		}
	}

	// This method is used to verify images and logos
	public static void verifyImage(String pageName, String imagePath) {
		int flag = 0;
		try {
			// Define the entire Screen as the target region Region screen
			Screen screen = new Screen();
			// Take the sample image to define as image search pattern
			Pattern pattern = new Pattern(imagePath);
			// Check if the target contains image
			if (screen.contains(pattern.getTargetOffset())) {
				flag = 1;
				log("pass", pageName + " Logo is displayed");
			}
		} catch (Exception e) {
			log("fail", pageName + " Logo is not displayed");
			e.printStackTrace();
		}
		TestUtils.assertEquals(flag, 1);
	}

	// This method is used for handling Alert pop-up
	public static void alertPopup() {
		// Capturing alert message
		Alert alert = getDriver().switchTo().alert();
		// Displaying alert message
		String alertMessage = getDriver().switchTo().alert().getText();
		System.out.println(alertMessage);
		// Accepting alert
		alert.accept();
	}

	// This method is used for handling frames
	public static void frame(int indexNumber) {
		getDriver().switchTo().frame(indexNumber);
	}

	// This method is used for Assert
	public static void assertEquals(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}

	// This method verifies presence of String on a page
	public static void assertTrue(String text) {
		Assert.assertTrue(true, text);
	}

	// This method used to verify color code
	public static void colorVerify(WebElement element, String elementName, String propFile) {
		TestWaits.threadSleep(1000);
		String colorCode = element.getCssValue("background-color");
		String hexaColor = Color.fromString(colorCode).asHex();
		log("info", elementName + " Background color defined : " + "<b>" + propFile + "</b>");
		log("info", elementName + " Background color displayed : " + "<b>" + hexaColor + "</b>");
		assertEquals(hexaColor, propFile);
		try {
			log("pass", elementName + " background colour matches the defined colour code");
		} catch (AssertionError e) {
			Assert.assertTrue(false);
			log("fail", elementName + " background colour does not match the defined colour code");
		}
	}

}
