package com.qa.Utils;

import com.qa.Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class TestWaits extends TestBase {

	// This method is used for thread sleep
	public static void threadSleep(int nanoSeconds) {
		try {
			Thread.sleep(nanoSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// This method is used to pause before proceeding execution
	public static void pauseUntilDuration(int seconds) {
		new Actions(getDriver()).pause(Duration.ofSeconds(seconds)).perform();
	}
	
	// This Method is used to wait explicitly until element is visible
	public static void explicitWaitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

	// This Method is used to wait explicitly until element is visible and click on
	// element
	public static void explicitWaitUntilClickable(WebElement element, String elementName) {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			log("pass", "Performed click action on "+elementName);
		} catch (Exception e) {
			log("fail", "Unable to perform click action on "+elementName);
		}
	}

	// This Method is used to wait explicitly until alert is visible and click accept
	public static void explicitWaitUntilAlertIsPresent() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}
	
	// This Method is used to verify element is not present
		public static boolean explicitWaitinvisibilityOfElement(WebElement element) {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1));
			return wait.until(ExpectedConditions.invisibilityOf(element));
		}

	// Waiting 30 seconds for an element to be present on the page, checking for its
	// presence once every 5 seconds.
	public static void fluentWait(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});
	}

}
