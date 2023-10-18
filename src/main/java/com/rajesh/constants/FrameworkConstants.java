package com.rajesh.constants;

import com.rajesh.enums.ConfigProperties;
import com.rajesh.helpers.PropertiesHelpers;
import com.rajesh.utils.PropertyUtils;

import java.io.File;

public final class FrameworkConstants {

	private FrameworkConstants() {
		
	}
	
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver";
	private static final String GHECODRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/executables/ghecodriver";
	private static final String IEDRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/executables/iedriver";
	private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";
	private static final String EXCELFILEPATH = System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx";
	public static final String REPORT_TITLE = PropertiesHelpers.getValue("REPORT_TITLE");
	public static final String SEND_EMAIL_TO_USERS = PropertiesHelpers.getValue("SEND_EMAIL_TO_USERS");

	public static final int WAIT_DEFAULT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_DEFAULT"));
	public static final int WAIT_IMPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_IMPLICIT"));
	public static final int WAIT_EXPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_EXPLICIT"));
	public static final int WAIT_PAGE_LOADED = Integer.parseInt(PropertiesHelpers.getValue("WAIT_PAGE_LOADED"));
	public static final int WAIT_SLEEP_STEP = Integer.parseInt(PropertiesHelpers.getValue("WAIT_SLEEP_STEP"));
	public static final String ACTIVE_PAGE_LOADED = PropertiesHelpers.getValue("ACTIVE_PAGE_LOADED");
	public static final String EXTENT_REPORT_NAME = PropertiesHelpers.getValue("EXTENT_REPORT_NAME");

	public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME + ".html";
	public static String EXTENT_REPORT_FILE_PATH = EXTENTREPORTFOLDERPATH + File.separator + EXTENT_REPORT_FILE_NAME;
	public static final String YES = "yes";
	public static final String NO = "no";

	public static final String BOLD_START = "<b>";
	public static final String BOLD_END = "</b>";

	public static String getExtentreportpath() {
		if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH  + System.currentTimeMillis() + "/" +"index.html" ;
		}
		else {
			return EXTENTREPORTFOLDERPATH + "/"  + "index.html" ;
		}
	}

	public static String getExcelfilepath() {
		return EXCELFILEPATH;
	}

	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
				extentReportFilePath = getExtentreportpath();
		}
		return extentReportFilePath;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
	
	public static int getExplicitWaitTime() {
		return WAIT_EXPLICIT;
	}
	
	public static String getGhecoDriverPath() {
		return GHECODRIVERPATH;
	}

	public static String getIeDriverPath() {
		return IEDRIVERPATH;
	}
}
