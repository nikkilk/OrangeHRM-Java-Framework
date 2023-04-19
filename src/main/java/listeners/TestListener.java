package listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.BaseClass;
import constants.FrameworkConstants;
import enums.ExtentEnums;
import utility.ExtentReportUtils;
import utility.LoggerUtils;
import utility.MediaUtils;

public class TestListener extends BaseClass implements ITestListener {
	ExtentTest extent;
	
	private static ThreadLocal<ExtentTest> textent = new ThreadLocal<>();
	
	public static ExtentTest getExtent() {
		return textent.get();
	}
	
	public void unloadExtent() {
		textent.remove();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		extent = ExtentReportUtils.report.createTest(result.getMethod().getMethodName()).assignAuthor(FrameworkConstants.authorName).assignCategory(result.getTestClass().getName()).assignDevice(FrameworkConstants.osName);
		textent.set(extent);
		
		LoggerUtils.log(ExtentEnums.INFO, "Testcase execution Started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		if(Boolean.parseBoolean(prop.getProperty("SaveSuccessScreenshot"))) {
			MediaUtils.takeScreenshotAndSave(getDriver(), "Success/", result.getName());
		}
		getExtent().pass(MarkupHelper.createLabel("Testcase "+result.getName()+ " passed", ExtentColor.GREEN));
		unloadExtent();
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		if(Boolean.parseBoolean(prop.getProperty("SaveFailureScreenshot"))) {
			MediaUtils.takeScreenshotAndSave(getDriver(), "Failure/", result.getName());
			getExtent().fail(MarkupHelper.createLabel("Testcase "+result.getName()+ " failed due to below reasons: "+"<br><br>"+Arrays.asList(result.getThrowable())+ MediaEntityBuilder.createScreenCaptureFromPath(MediaUtils.absolutePath), ExtentColor.RED));
		} else {
			getExtent().fail(MarkupHelper.createLabel("Testcase "+result.getName()+" failed due to below reasons: "+"<br><br>"+Arrays.asList(result.getName()+ MediaEntityBuilder.createScreenCaptureFromBase64String(MediaUtils.takeScreenshot(getDriver()))), ExtentColor.RED));
		}
		unloadExtent();
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		if(Boolean.parseBoolean(prop.getProperty("SaveSkippedScreenshot"))) {
			MediaUtils.takeScreenshotAndSave(getDriver(), "Skipped/", result.getName());
			getExtent().skip(MarkupHelper.createLabel("Testcase "+result.getName()+" skipped due to below reasons: "+"<br><br>"+Arrays.asList(result.getThrowable()), ExtentColor.YELLOW));
		} else {
			getExtent().skip(MarkupHelper.createLabel("Testcase "+result.getName()+" skipped due to below reasons: "+"<br><br>"+Arrays.asList(result.getThrowable()), ExtentColor.YELLOW));
		}
		unloadExtent();
	}
	
	@Override
	public void onFinish(ITestContext context) {
		ExtentReportUtils.report.flush();
		
	}
	

}
