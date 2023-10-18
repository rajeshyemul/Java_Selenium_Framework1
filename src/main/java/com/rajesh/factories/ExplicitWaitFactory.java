package com.rajesh.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rajesh.constants.FrameworkConstants;
import com.rajesh.driver.DriverManager;
import com.rajesh.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static WebElement explicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;
		if(waitStrategy == WaitStrategy.CLICKABLE) {
			WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTime());
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitStrategy == WaitStrategy.VISIBILITY) {
			WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWaitTime());
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitStrategy == WaitStrategy.PRESENCE) {
			WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWaitTime());
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else  if(waitStrategy == WaitStrategy.NONE) {
			System.out.println("No wait strategy is applied");
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
