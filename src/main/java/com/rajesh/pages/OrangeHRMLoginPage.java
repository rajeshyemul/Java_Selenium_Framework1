package com.rajesh.pages;

import org.openqa.selenium.By;

import com.rajesh.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {


	private final By txtUsername = By.id("txtUsername");
	private final By txtPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By btnLogin = By.id("btnLogin");
	
	public OrangeHRMLoginPage enterUserName(String userName) {
		sendKeys(txtUsername, userName, WaitStrategy.PRESENCE, "user name");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(txtPassword,password, WaitStrategy.PRESENCE, "password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		click(btnLogin, WaitStrategy.CLICKABLE, "Login Button");
		return new OrangeHRMHomePage();
	}
	
}
