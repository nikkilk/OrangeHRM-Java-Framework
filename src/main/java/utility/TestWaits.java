package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverManager;
import enums.WaitStrategy;
import lombok.SneakyThrows;

public class TestWaits {
	
	@SneakyThrows
	public static void threadSleep(int duration) {
		Thread.sleep(duration);
	}
	
	
	public static void pauseUntilDuration(WebElement element, int duration) {
		new Actions(DriverManager.getDriver()).moveToElement(element).pause(duration).build().perform();
	}

	
	public static void explicitWait(WaitStrategy input, WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
		if(input.equals(WaitStrategy.CLICKABLE)) {
			wait.until(ExpectedConditions.elementToBeClickable(element)); 
			} else if(input.equals(WaitStrategy.VISIBLE)) {
				wait.until(ExpectedConditions.visibilityOf(element));
			} else if(input.equals(WaitStrategy.INVISIBLE)) {
				wait.until(ExpectedConditions.invisibilityOf(element));
			} else if(input.equals(WaitStrategy.PRESENCE)) {
				wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
			} else if(input.equals(WaitStrategy.ALERTACCEPT)) {
				wait.until(ExpectedConditions.alertIsPresent()).accept();
			} else if(input.equals(WaitStrategy.ALERTTEXT)) {
				wait.until(ExpectedConditions.alertIsPresent()).getText();
			}
		}
	
	
	public static void fluentWait(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class);
		wait.until(driver-> element);
	}

}
