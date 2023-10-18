package com.rajesh.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rajesh.annotations.FrameworkAnnotation;
import com.rajesh.reports.ExtentLogger;
import com.rajesh.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener{

	public void onStart(ISuite suite) {
			ExtentReport.initReport();
	}

	public void onFinish(ISuite suite) {
			ExtentReport.flushReports();
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed");
	}

	public void onTestFailure(ITestResult result) {
			try {
				ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed", true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
}
