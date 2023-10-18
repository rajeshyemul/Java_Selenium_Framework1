package com.rajesh.pages;

import org.openqa.selenium.By;

import com.rajesh.enums.WaitStrategy;

public class OrangeHRMHomePage extends BasePage {
	
	private final By lnkWelcome = By.id("welcome");
	private final By lnkLogout = By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome() {
		click(lnkWelcome, WaitStrategy.CLICKABLE, "Welcome Button");
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		// Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS); same like Thread.sleep()		
		// wait.until(d->d.findElement(lnkLogout).isEnabled()); java 8 way to handle wait
		
		click(lnkLogout, WaitStrategy.CLICKABLE, "Logout Button");
		return new OrangeHRMLoginPage();
	}
}
