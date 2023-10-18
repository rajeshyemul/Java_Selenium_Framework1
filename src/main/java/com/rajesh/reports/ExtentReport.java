package com.rajesh.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.rajesh.constants.FrameworkConstants;
import com.rajesh.enums.AuthorType;
import com.rajesh.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {
		
	}
	
	private static ExtentReports extent;
	
	public static void initReport() {
		if (Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath()); 
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Extent Reports");
		spark.config().setReportName("Extent Report Practice");
		spark.config().setDocumentTitle("Practice Report");
		}
	}
	
	public static void flushReports() {
		if (Objects.nonNull(extent)) {
		extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			
		} //open the file in the desktop default browser.
	}
	
	public static void createTest(String testcaseName) {
		ExtentTest test = extent.createTest(testcaseName);
		ExtentManager.setExtentTest(test);
	}
	
	
	public static void addAuthor(AuthorType[] authorName) {
		ExtentManager.getExtentTest().assignAuthor(authorName);
	}
	
	public static void addCategories(CategoryType[] categories) {
		for(CategoryType category: categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}
}
