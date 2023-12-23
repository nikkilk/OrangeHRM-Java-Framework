package com.qa.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int counter = 0;
	int retryLimit = 3;

// This method decides how many time should test should run TestNG will call this method every time a test is failed

// This method will return true every time when test needs to be retried and false when it not

	public boolean retry(ITestResult result) {

		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
