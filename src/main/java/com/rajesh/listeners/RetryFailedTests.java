package com.rajesh.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.rajesh.enums.ConfigProperties;
import com.rajesh.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 2;
	
	public boolean retry(ITestResult result) {
		boolean value = false;
		
			if(PropertyUtils.getValue(ConfigProperties.RETRY).equalsIgnoreCase("yes")) {
				value = retries<count;
				count++;
			}
		return value;
	}
}
