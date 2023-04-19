package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManager extends DriverManager {
	public static Properties prop = new Properties();
	String browserName;
	String browserVersion;
	
	public void selectBrowser() {
		String browser = prop.getProperty("Browser");
		switch(browser.toLowerCase().trim()) {
		case "chrome": setDriver(new ChromeDriver(getChromeOptions())); break;
		case "firefox": setDriver(new FirefoxDriver()); break;
		case "edge": setDriver(new EdgeDriver()); break;
		default: throw new IllegalArgumentException("invalid browser");
		}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	}
	
	private ChromeOptions getChromeOptions() {
		ChromeOptions chromeOption = new ChromeOptions();
		browserName = chromeOption.getBrowserName();
//		browserVersion = ((RemoteWebDriver)getDriver()).getCapabilities().getBrowserVersion();
		if(Boolean.parseBoolean(prop.getProperty("Incognito"))) {
			chromeOption.addArguments("--incognito");
		}
		if(Boolean.parseBoolean(prop.getProperty("Headless"))) {
			chromeOption.addArguments("--headless");
		}
		chromeOption.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOption.setExperimentalOption("prefs", prefs);
		return chromeOption;
	}

}
