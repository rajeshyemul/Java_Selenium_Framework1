package com.rajesh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.rajesh.driver.DriverManager;
import com.rajesh.enums.WaitStrategy;
import com.rajesh.factories.ExplicitWaitFactory;
import com.rajesh.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.explicitWait(waitStrategy, by);
		element.click();
		ExtentLogger.pass(elementName + " clicked", true);
	}
	
	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.explicitWait(waitStrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value + " Value is enetered successfully into " + elementName , true);
	}
	
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
