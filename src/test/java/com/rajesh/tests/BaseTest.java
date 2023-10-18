package com.rajesh.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.rajesh.driver.Driver;
import com.rajesh.enums.ConfigProperties;
import com.rajesh.utils.PropertyUtils;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	
	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver(PropertyUtils.getValue(ConfigProperties.BROWSER));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
