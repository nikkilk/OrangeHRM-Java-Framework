package utility;

import java.util.Arrays;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import base.BaseClass;
import constants.FrameworkConstants;

public class ExtentReportUtils extends BaseClass {
	public static ExtentReports report = new ExtentReports();
	private static ExtentSparkReporter reporter;
	
	public static void extentReport() {
		reporter = new ExtentSparkReporter(FrameworkConstants.extentReportPath+DateUtils.getDate()+".html");
		reporter.config().setDocumentTitle("OrangeHRM Automation Report");
		reporter.config().setReportName("OrangeHRM Automation Report");
		reporter.config().setEncoding("UTF-8");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setTimeStampFormat("DD-MM-yyyy HH-mm-ss");
		report.attachReporter(reporter);
		
		report.attachReporter(reporter);
		report.setSystemInfo("User", FrameworkConstants.authorName);
		report.setSystemInfo("Browser", prop.getProperty("Browser"));
		report.setSystemInfo("OS Name", FrameworkConstants.osName);
		report.setSystemInfo("Java Version", FrameworkConstants.javaVersion);
		report.setSystemInfo("File Encoding", FrameworkConstants.fileEncoding);
		report.setReportUsesManualConfiguration(true);
		
		List<ViewName> list = Arrays.asList(ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.TEST, ViewName.DEVICE, ViewName.AUTHOR);
		reporter.viewConfigurer().viewOrder().as(list);
	}

}
