package com.rajesh.tests;

import java.util.Map;

import com.rajesh.enums.AuthorType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rajesh.annotations.FrameworkAnnotation;
import com.rajesh.enums.CategoryType;
import com.rajesh.pages.OrangeHRMHomePage;
import com.rajesh.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {
	
	private OrangeHRMTests() {
		
	}
	
	@FrameworkAnnotation(author= AuthorType.RAJESH, category = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test
	public void loginLogoutTest(Map<String,String >data) {
		
		OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
		OrangeHRMHomePage orangeHRMHomePage = orangeHRMLoginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		orangeHRMLoginPage = orangeHRMHomePage.clickWelcome().clickLogout();
		String actualTitle = orangeHRMLoginPage.getPageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void newTest(Map<String,String >data) {
		
		OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
		OrangeHRMHomePage orangeHRMHomePage = orangeHRMLoginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		orangeHRMLoginPage = orangeHRMHomePage.clickWelcome().clickLogout();
		String actualTitle = orangeHRMLoginPage.getPageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
}
