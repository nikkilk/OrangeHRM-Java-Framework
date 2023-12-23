package com.qa.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.Base.TestBase;
import com.qa.Utils.ELKUtils;
import com.qa.Utils.ExtentReport;
import com.qa.Utils.TestUtils;
import com.qa.Utils.TestWaits;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.qa.Utils.ExtentReport.report;

public class TestListener extends TestBase implements ITestListener {
	public static ExtentTest extent;

	// To make ExtentTest class object Thread safe to update in report while parallel execution
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static ExtentTest getExtent() {
		return extentTest.get();
	}

	public static void unloadExtent() {
		extentTest.remove();
	}

	@Override
	public void onStart(ITestContext context) {

	}

@Override
	public void onTestStart(ITestResult result) {
		// Adding System Properties in Extent Report
		extent = report.createTest(result.getMethod().getMethodName()).assignDevice(ExtentReport.osName).assignAuthor(ExtentReport.authorName)
				.assignCategory(result.getTestClass().getName());
		extentTest.set(extent);

		// Add system info in extent report
		ExtentReport.systemInfo();

		// Adds Test case start info in Extent Report
		log("info", result.getMethod().getMethodName() + " Testcase execution Started");
		log("info", result.getMethod().getDescription());
		getExtent().info(MarkupHelper.createLabel("<span style=\"font-size:13px\">"+"Test Steps:", ExtentColor.INDIGO));
	}

/*@Override
public void onStart(ITestContext context) {
	// Create parent node for test suite
	extentTest = extent.createTest(context.getName());
}

	@Override
	public void onTestStart(ITestResult result) {
		// Create child node for test case
		ExtentTest test = extentTest.createNode(result.getMethod().getMethodName());

		// Add System Properties in Extent Report
		test.assignDevice(ExtentReport.osName).assignAuthor(ExtentReport.authorName)
				.assignCategory(result.getTestClass().getName());

		// Add system info in extent report
		ExtentReport.systemInfo();

		// Adds Test case start info in Extent Report
		log("info", result.getMethod().getMethodName() + " Testcase execution Started");
		log("info", result.getMethod().getDescription());
		test.info(MarkupHelper.createLabel("<span style=\"font-size:13px\">" + "Test Steps:", ExtentColor.INDIGO));

		// Set extentTest for current test case
		extentTest.set(test);
	}

	// Other methods
}
*/
	@Override
	public void onTestSuccess(ITestResult result) {
		if(Boolean.parseBoolean(prop.getProperty("SaveScreenshot"))) {
			TestUtils.takeScreenshotAndSave("SuccessScreenshot/", result.getName());
		}
		log("info", result.getMethod().getMethodName() + " Testcase execution Completed");
		getExtent().pass(MarkupHelper.createLabel("Testcase " + result.getName() + " Passed", ExtentColor.GREEN));
		ELKUtils.realTImeDashboard(result.getMethod().getMethodName(), "pass");
		unloadExtent();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (Boolean.parseBoolean(prop.getProperty("SaveScreenshot"))) {
			TestUtils.takeScreenshotAndSave("FailureScreenshot/", result.getName());
			// This method attaches screenshot in Extent Report for failed Test cases from local folder
			getExtent().fail(result.getName() + " Test case FAILED due to below issues:"+"<br><br>"+Arrays.asList(result.getThrowable()),
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.absolutePath).build());
		} else {
			// This method attaches screenshot directly in Extent Report for failed Test cases
			getExtent().fail(result.getName() + " Test case FAILED due to below issues:"+"<br><br>"+Arrays.asList(result.getThrowable()),
					MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtils.takeScreenshot()).build());
		}
		log("info", result.getMethod().getMethodName() + " Testcase execution Failed");
		getExtent().fail(MarkupHelper.createLabel("Testcase " + result.getName() + " Failed", ExtentColor.RED));
		ELKUtils.realTImeDashboard(result.getMethod().getMethodName(), "fail");
		unloadExtent();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
/*		if(Boolean.parseBoolean(prop.getProperty("SaveScreenshot"))) {
			TestUtils.takeScreenshotAndSave("SkippedScreenshot/", result.getName());
			// This method attaches screenshot in Extent Report for Skipped Test cases from local folder
			getExtent().skip(result.getName() + " Test case SKIPPED due to below issues:"+"<br><br>"+Arrays.asList(result.getThrowable()),
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.absolutePath).build());
		} else {
			// This method attaches screenshot directly in Extent Report for skipped Test cases
			getExtent().skip(result.getName() + " Test case SKIPPED due to below issues:"+"<br><br>"+Arrays.asList(result.getThrowable()),
					MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtils.takeScreenshot()).build());
		}
*/		log("info", result.getMethod().getMethodName() + " Testcase execution Skipped");
		getExtent().skip(MarkupHelper.createLabel("Testcase " + result.getName() + " SKIPPED", ExtentColor.ORANGE));
		ELKUtils.realTImeDashboard(result.getMethod().getMethodName(), "skip");
		unloadExtent();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// No need of this method
	}

	@Override
	public void onFinish(ITestContext context) {
		// write results into the file
		report.flush();
		TestWaits.threadSleep(1000);
		try (Stream<Path> paths = Files.walk(Paths.get("C:/Users/Nikkil/eclipse-workspace/Uyeno2/Reports/ExtentReports"))) {
			List<Object> list = paths.collect(Collectors.toList());
			File file = new File(list.get(list.size()-1).toString().replaceAll("\\\\", "/"));
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
