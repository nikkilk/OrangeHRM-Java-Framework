package com.qa.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.qa.Base.TestBase;
import com.qa.Listeners.TestListener;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.qa.Utils.TestUtils.getDate;

public class ExtentReport extends TestBase {
	public static ExtentSparkReporter reporter;
	public static ExtentReports report;
	
	public static String osName = System.getProperty("os.name");
	public static String browserName = System.getProperty("Browser");
	public static String authorName = System.getProperty("user.name");
	public static String javaVersion = System.getProperty("java.version");
	public static String fileEncoding = System.getProperty("file.encoding");
	
	

	public static ExtentReports extentReport() {
		// Initialize the HtmlReporter
		reporter = new ExtentSparkReporter("./Reports/ExtentReports/FMS-V14-Web-App-Automation-Test-Report_" + getDate() + ".html");
		reporter.config().setTimeStampFormat("yyyy-MM-dd HH-mm-ss");
		reporter.config().setDocumentTitle("FMS V14 Uyeno Web App Automation Test Report");
		reporter.config().setReportName("FMS V14 Uyeno Web App Automation Test Report");
		reporter.config().setEncoding("UTF-8");
		reporter.config().setTheme(Theme.STANDARD);
	//	reporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
		// Initialize ExtentReports and attach the HtmlReporter
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("User", authorName);
		report.setSystemInfo("Browser", prop.getProperty("Browser"));
		report.setSystemInfo("OS Name", osName);
		report.setSystemInfo("Java Version", javaVersion);
		report.setSystemInfo("File Encoding", fileEncoding);
		report.setReportUsesManualConfiguration(true);
		
		// Rearrange tabs order in extent report
		List<ViewName> defaultOrder = Arrays.asList(ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.TEST, ViewName.DEVICE, ViewName.AUTHOR);
		reporter.viewConfigurer().viewOrder().as(defaultOrder);
		
		return report;
	}
	
	
	// Add browser details in Extent Report
	public static void systemInfo() {
//		test("Browser Launched");
		log("info", "Browser: " + "<span style='color:teal'>"+ name /*+ " V" + version ((RemoteWebDriver)getDriver()).getCapabilities().getBrowserVersion()*/);
		log("info", "Language: " + "<span style='color:teal'>" + prop.getProperty("Language"));
		log("info", "Login Role: " + "<span style='color:teal'>" + prop.getProperty("LoginType"));
	}
	
	// Attach logo images in extent report
	public static void attachScreenshotInReport(String logoPath) {
		String imagePath = new File(logoPath).getAbsolutePath();
		if (Boolean.parseBoolean(prop.getProperty("ExtentReport"))) {
			log("info", ""+TestListener.getExtent().info("Logo: ", MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build()));
		}
	}


}
