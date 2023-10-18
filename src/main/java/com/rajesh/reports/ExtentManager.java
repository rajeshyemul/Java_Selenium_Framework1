package com.rajesh.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {
		
	}
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();

	static ExtentTest getExtentTest() {
		return extTest.get();
	}

	public static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	public static void unload() {
		extTest.remove();
	}
}
