package base;

import java.io.FileInputStream;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.yaml.snakeyaml.Yaml;

import constants.FrameworkConstants;
import enums.ExtentEnums;
import lombok.SneakyThrows;
import utility.ExtentReportUtils;
import utility.LoggerUtils;

public class BaseClass extends BrowserManager {
	public static FileInputStream input;
	public static Yaml yaml = new Yaml();
	public static Map<String, Object> yamlMap;
	public static Logger logger = org.apache.logging.log4j.LogManager.getLogger(BaseClass.class.getName());
	
	@SneakyThrows
	@BeforeSuite
	public void readConfig() {
		input = new FileInputStream(FrameworkConstants.configFilePath);
		prop.load(input);
		
		input = new FileInputStream(FrameworkConstants.credentialsFilePath);
		yamlMap = yaml.load(input);
		
		if(Boolean.parseBoolean(prop.getProperty("ExtentReport"))) {
			ExtentReportUtils.extentReport();
		}
	}
	
	@AfterMethod
	public void onTestFinish(ITestResult result) {
		LoggerUtils.log(ExtentEnums.INFO, "Testcase execution completed");
	}
	
	@BeforeClass
	public void init() {
		selectBrowser();
		getDriver().get(prop.getProperty("URL"));
	}
	
	@AfterClass
	public void tearDown() {
		if(getDriver()!=null) {
		getDriver().quit();
		}
		unloadDriver();
	}
	

}
