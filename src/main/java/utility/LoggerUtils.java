package utility;

import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import enums.ExtentEnums;
import listeners.TestListener;

public class LoggerUtils extends BaseClass {
	
	public static void log(ExtentEnums status, String data) {
		ExtentTest extentTest = TestListener.getExtent();
		if(Boolean.parseBoolean(prop.getProperty("ExtentReport"))) {
			if(extentTest!=null) {
				if(status.equals(ExtentEnums.PASS)) {
					extentTest.pass(data);
				} else if(status.equals(ExtentEnums.FAIL)) {
					extentTest.fail(data);
				} else if(status.equals(ExtentEnums.SKIP)) {
					extentTest.skip(data);
				} else if(status.equals(ExtentEnums.INFO)) {
					extentTest.info(data);
				}
			}
		}
		System.out.println(data);
		Reporter.log(data);
		logger.info(data);
	}

}
