package com.qa.Base;

import com.aventstack.extentreports.ExtentTest;
import com.qa.Listeners.TestListener;
import com.qa.Pages.*;
import com.qa.Utils.DataUtils;
import com.qa.Utils.ExtentReport;
import com.qa.Utils.NonFunctional;
import com.qa.Utils.ScreenRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.time.Duration;
import java.util.Map;

public class TestBase extends DriverFactory {

	public static Yaml yaml = new Yaml();
	public static Map<String, Object> yamlMap;
	public static final Logger logger = LogManager.getLogger(TestBase.class.getName());
	public static FileInputStream input;
	public static Reader file;
	public String title;
	public static String loginType;
	public static String username;
	public static String password;

	public DriverFactory df = new DriverFactory();
	public ActionsPage actionsPage;
	public TablePage tablePage;
	public LoginPage login;
	public DashboardPage dash;
	public OnMapPage onMap;
	public ReportPage reports;
	public VehicleReportsPage vehicleReports;
	public GeofencePage geo;
	public ClientsPage client;
	public UsersPage user;
	public SIMPage sim;
	public UnitsPage unit;

	
	public void pagesConstructors() {
		login = new LoginPage();
		actionsPage = new ActionsPage();
		tablePage = new TablePage();
		dash = new DashboardPage();
		onMap = new OnMapPage();
		reports = new ReportPage();
		vehicleReports = new VehicleReportsPage();
		client = new ClientsPage();
		geo = new GeofencePage();
		user = new UsersPage();
		sim = new SIMPage();
		unit = new UnitsPage();
	}

	// This method loads the data from the config file from main java folder
	@BeforeSuite
	public void configPropReader() {
		try {
			// Load data from Config.Properties file
			input = new FileInputStream("./src/main/java/com/qa/Config/Config.properties");
			prop.load(input);

			input = new FileInputStream("./src/main/java/com/qa/Config/UyenoStaging.Config.properties");
			prop.load(input);

			input = new FileInputStream("./src/main/java/com/qa/Config/Color.properties");
			prop.load(input);

			// Read data from Yaml file
			file = new FileReader("./src/main/java/com/qa/TestData/ManagementData.yaml");
			yamlMap = yaml.load(file);
			DataUtils.ManagementData();
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

		// Load Extent Report
		ExtentReport.extentReport();

		
		//Start Screen Recording
		if(Boolean.parseBoolean(prop.getProperty("RecordScreen"))) {
		ScreenRecord.startRecording("Record");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("Database"))) {
			NonFunctional.connectSQL();
		}

		// Add SSL certificate path
		String keystore = "./src/main/resources";
		String storepass = "changeit";
		String storetype = "JKS";
		String[][] props = { { "javax.net.ssl.trustStore", keystore, }, { "javax.net.ssl.keyStore", keystore, },
				{ "javax.net.ssl.keyStorePassword", storepass, }, { "javax.net.ssl.keyStoreType", storetype, }, {"javax.http.ssl.insecure", "true",}, };
		for (int i = 0; i < props.length; i++) {
			System.getProperties().setProperty(props[i][0], props[i][1]);
		}
	}

	@Parameters("browser")
	// This method is to select browser and url from the config file
	public void init() {
		// Launch in Selenium grid server
		WebDriver driver = null;
		if (Boolean.parseBoolean(prop.getProperty("SeleniumGrid"))) {
			df.seleniumGrid(browserName);
		} else if (Boolean.parseBoolean(prop.getProperty("lambdaTest"))) {
			df.lambdaTest();
		} else {
			df.selectBrowser();
			driver = getDriver();
		}
		if (Boolean.parseBoolean(prop.getProperty("MobileView"))) {
			df.runInMobileView();
		}

		// Delete all cookies and maximize the browser
		driver.manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		selectUrl();
		selectLanguage();
		Login();
		pagesConstructors();
	}

	// This Method will select the different environment as per mentioned in config
	// file
	protected void selectUrl() {
		String environment = prop.getProperty("Environment").toLowerCase();
		try {
			switch (environment) {
			case "automation":
				getDriver().get(prop.getProperty("AutomationURL"));
				break;
			case "staging":
				getDriver().get(prop.getProperty("StagingURL"));
				break;
			case "production":
				getDriver().get(prop.getProperty("ProductionURL"));
				break;
			default:
				System.out.println("Please pass the right Environment " + environment);
				throw new Exception("Environment is not defined");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This Method will select the different language as mentioned in config
	// properties file
	private void selectLanguage() {
		String language = prop.getProperty("Language").toLowerCase();
		try {
			switch (language) {
			case "english":
				input = new FileInputStream("./src/main/java/com/qa/Config/Lang.Eng.properties");
				break;
			case "japanese":
				input = new FileInputStream(new File("./src/main/java/com/qa/Config/Lang.Jap.properties"));
				break;
			default:
				System.out.println("Please pass the right Language " + language);
				throw new Exception("Language is not defined");
			}
			prop.load(new InputStreamReader(input, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Read the login role type from config properties and set login credentials
		private void Login() {
			loginType = prop.getProperty("LoginType").toLowerCase().trim();
			switch (loginType) {
				case "super admin":
					username = prop.getProperty("Username1");
					password = prop.getProperty("Password1");
					break;
				case "command center":
					username = prop.getProperty("Username2");
					password = prop.getProperty("Password2");
					break;
				case "admin":
					username = prop.getProperty("Username3");
					password = prop.getProperty("Password3");
					break;
				case "user":
					username = prop.getProperty("Username4");
					password = prop.getProperty("Password4");
					break;

				default:
					System.err.println("Please pass the right Login credentials. " + "Entered Login Detail is "+loginType);
					try {
						throw new Exception("Login Credentials not correct");
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}

	// Adds Test case end info in Extent Report
	@AfterMethod
	public synchronized void onTestFinish(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " Testcase execution Completed");
	}

	// This method logs all details in the console and reports
	public static void log(String status, String data) {
	    // Decides extent report enabled or not from config file
		 if (Boolean.parseBoolean(prop.getProperty("ExtentReport"))) {
		        ExtentTest extentTest = TestListener.getExtent();
		        if (extentTest != null) {
		            if (status.equalsIgnoreCase("pass")) {
		                extentTest.pass("" + data);
		            } else if (status.equalsIgnoreCase("fail")) {
		                extentTest.fail("" + data);
		            } else if (status.equalsIgnoreCase("skip")) {
		                extentTest.skip("" + data);
		            } else if (status.equalsIgnoreCase("info")) {
		                extentTest.info("" + data);
		            }
		        }
		    }
	    logger.info(data);
	    System.out.println(data);
	    Reporter.log(data);
	}

	// This method is used to close browser
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		try {
			if(getDriver()!=null) {
			getDriver().quit();
		}
		}catch(Exception e) {
		System.out.println("The browser could not be closed.");
	} finally {
			df.unloadDriver();
		}
	log("info", "Browser Closed");
	}
	
	@AfterSuite
	public void StopRecord() {
		if(Boolean.parseBoolean(prop.getProperty("Database"))) {
			NonFunctional.closeSQL();
		}
		if(Boolean.parseBoolean(prop.getProperty("RecordScreen"))) {
			ScreenRecord.stopRecording();
		}
	}

}
