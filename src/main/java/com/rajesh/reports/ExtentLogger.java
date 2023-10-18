package com.rajesh.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.rajesh.enums.ConfigProperties;
import com.rajesh.utils.PropertyUtils;
import com.rajesh.utils.ScreenshotsUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}
	
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void pass(String message, boolean isScreenShotNeeded) {
		if(PropertyUtils.getValue(ConfigProperties.PASSEDTESTSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message, boolean isScreenShotNeeded) {
		if(PropertyUtils.getValue(ConfigProperties.FAILEDTESTSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
}
