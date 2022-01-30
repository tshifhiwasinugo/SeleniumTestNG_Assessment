package com.selenium.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//using extends to access characteristics of Config class
public class VerifyUserRecord {

	@Test(priority = 23)
	public void test_case_eight() throws InterruptedException {

		//serching for username
		Thread.sleep(3000);
		Config.driver.findElement(By.name(Locators.search_username)).sendKeys(InstanceVariables.input_username);
		Thread.sleep(3000);

		//submit to search
		WebElement search = Config.driver.findElement(By.id("searchBtn"));
		search.click();
	}
}