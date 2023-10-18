package com.rajesh.tests;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rajesh.driver.DriverManager;

public final class HomepageTests extends BaseTest {

	private HomepageTests() {

	}

	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing mini bytes - Youtube", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		
		System.out.println(title);

		Assert.assertTrue(Objects.nonNull(title), "Title is NULL");
		Assert.assertTrue(title.contains("Google Search"),"Title does not have Google Search word");
		Assert.assertTrue(title.length() > 15,"title length is less than 15");
		Assert.assertTrue(title.length() < 100, "title length is greater than 100");
		//Assert.assertTrue(title.toLowerCase().matches("\\w.*" + "Google Search"),"No match found");

	}
}
