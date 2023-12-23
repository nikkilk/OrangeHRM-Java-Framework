package com.qa.Base;

import com.qa.Listeners.WebEventListener;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v108.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;


public class DriverFactory {

    public static Properties prop = new Properties();
    public static String browserName;
    private ChromeOptions chromeOption;
    private FirefoxOptions firefoxOption;
    private EdgeOptions edgeOption;
    private DesiredCapabilities capability;
    public static String name;
    public static String version;

    protected static ClientApi api;
    public static ApiResponse apiResponse;
    private static String proxyServerUrl;
    private static Proxy proxy;

    // Factory design pattern--> define separate factory methods for creating
    // objects & create object by calling the methods
    protected static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tdriver.get();
    }

    public void unloadDriver() {
        tdriver.remove();
    }


    // This Method will select the different browsers as mentioned in config file
    public void selectBrowser() {
        String browserName = prop.getProperty("Browser").toLowerCase();
        System.out.println("Browser is " + browserName);

        WebDriver driver = null;
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            case "edge":
                driver = new EdgeDriver(getEdgeOptions());
                break;
            case "safari":
                driver = new SafariDriver(getSafariOptions());
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

        tdriver.set(new EventFiringWebDriver(driver).register(new WebEventListener()));
    }


    // Adding Chrome browser capabilities
    private ChromeOptions getChromeOptions() {
        chromeOption = new ChromeOptions();
        chromeOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        name = chromeOption.getBrowserName();
        version = chromeOption.getBrowserVersion();
        chromeOption.addArguments("--lang=" + prop.getProperty("Locale"));
        chromeOption.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOption.setExperimentalOption("prefs", prefs);
        if (Boolean.parseBoolean(prop.getProperty("Headless"))) {
            chromeOption.addArguments("--headless");
        }
        if (Boolean.parseBoolean(prop.getProperty("Incognito"))) {
            chromeOption.addArguments("--incognito");
        }
        return chromeOption;
    }

    // Adding Firefox browser capabilities
    private FirefoxOptions getFirefoxOptions() {
        firefoxOption = new FirefoxOptions();
        firefoxOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        name = firefoxOption.getBrowserName();
        version = firefoxOption.getBrowserVersion();
        firefoxOption.addArguments("--lang=" + prop.getProperty("Locale"));
        if (Boolean.parseBoolean(prop.getProperty("Headless"))) {
            firefoxOption.addArguments("--headless");
        }
        return firefoxOption;
    }

    // Adding Edge browser capabilities
    private EdgeOptions getEdgeOptions() {
        edgeOption = new EdgeOptions();
        edgeOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        name = edgeOption.getBrowserName();
        version = edgeOption.getBrowserVersion();
        edgeOption.addArguments("--lang=" + prop.getProperty("Locale"));
        edgeOption.setCapability("locale", "--lang=" + prop.getProperty("Locale"));
        edgeOption.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        edgeOption.setExperimentalOption("prefs", prefs);
        if (Boolean.parseBoolean(prop.getProperty("Headless"))) {
            edgeOption.addArguments("--headless");
        }
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        if (Boolean.parseBoolean(prop.getProperty("Incognito"))) {
            edgeOption.addArguments("InPrivate");
        }
        return edgeOption;
    }

    // Adding Safari browser capabilities
    private SafariOptions getSafariOptions() {
        SafariOptions safariOption = new SafariOptions();
        name = safariOption.getBrowserName();
        version = safariOption.getBrowserVersion();
        safariOption.getCapability("--lang=" + prop.getProperty("Locale"));
        safariOption.setCapability("locale", "--lang=" + prop.getProperty("Locale"));
        if (Boolean.parseBoolean(prop.getProperty("Incognito"))) {
            safariOption.setCapability("safari.cleanSession", true);
        }
        return safariOption;
    }

    // Runs automation on Selenium grid server
    public WebDriver seleniumGrid(String browserName) {
        try {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    tdriver.set(new RemoteWebDriver(new URL("http://localhost:4444"), getChromeOptions()));
                    break;
                case "firefox":
                    tdriver.set(new RemoteWebDriver(new URL("http://localhost:4444"), getFirefoxOptions()));
                    break;
                case "edge":
                    tdriver.set(new RemoteWebDriver(new URL("http://localhost:4444"), getEdgeOptions()));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser name: " + browserName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return getDriver();
    }


    public WebDriver lambdaTest() {
        String cloudUrl = "https://testfmsv14:A9rgEEj975BtjpADutbDbLglNof5TNdw0DMmqcMqaEdlA0xwpD@hub.lambdatest.com/wd/hub";
        capability = new DesiredCapabilities();
        capability.setCapability("browserName", "chrome");
        capability.setCapability("version", "106.0");
        capability.setCapability("platform", "win10");
        capability.setCapability("build", "FMSV14 Uyeno Web Automation");
        capability.setCapability("name", "FMSV14 Uyeno Web Automation");
        capability.setCapability("video", true);
        capability.setCapability("visual", true);
        capability.setCapability("network", true);
        capability.setCapability("console", true);
        capability.setCapability("terminal", true);
        capability.setCapability("performance", true);
        capability.setCapability("selenium_version", "4.7.0");
        try {
            tdriver.set(new RemoteWebDriver(new URL(cloudUrl), capability));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Cloud URL", e);
        }
        return getDriver();
    }

    // Executes tests in mobile view
    public void runInMobileView() {
        DevTools devTools = ((HasDevTools) getDriver()).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setDeviceMetricsOverride(Integer.parseInt(prop.getProperty("MobileWidth")), Integer.parseInt(prop.getProperty("MobileHeight")), Integer.parseInt(prop.getProperty("MobileScaleFactor")), true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
    }


    // Browser configuration for the Security testing
    public WebDriver zapBrowserConfigure() {
        proxyServerUrl = prop.getProperty("ZapProxy") + ":" + Integer.parseInt(prop.getProperty("ZapPort"));
        proxy = new Proxy();
        proxy.setHttpProxy(proxyServerUrl);
        proxy.setSslProxy(proxyServerUrl);
        ChromeOptions option = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        option.setExperimentalOption("prefs", prefs);
        option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        option.setProxy(proxy);
        option.setAcceptInsecureCerts(true);
        tdriver.set(new ChromeDriver(option));
        getDriver().manage().window().maximize();
        api = new ClientApi(prop.getProperty("ZapProxy"), Integer.parseInt(prop.getProperty("ZapPort")), prop.getProperty("ZapApiKey"));
        return getDriver();
    }


}
