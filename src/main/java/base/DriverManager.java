package base;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return tdriver.get();
	}

	public static void setDriver(WebDriver driver) {
		tdriver.set(driver);
	}
	
	public static void unloadDriver() {
		tdriver.remove();
	}
 
}
