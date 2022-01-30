package com.selenium.assessment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

//using extends to access characteristics of Config class
public class Logout extends Config {

	//test
	@Test(priority = 25)
	public void test_case_ten() throws InterruptedException {

		//selecting the welcome admin tab
		Thread.sleep(2000);
		Config.driver.findElement(By.id(Locators.wel_tab)).click();
		Thread.sleep(2000);

		//selecting the logout admin tab
		Config.driver.findElement(By.linkText(Locators.logout_tab)).click();
		Thread.sleep(5000);
	}

	//test
	@Test(priority = 26)

	//validate User Login
	public void validateUserLogin () {

		//test case and description
		Config.test = Config.extent.createTest("User should contain login", "validate if user contain login");

		//checking if current url contains val_login or not
		if(Config.driver.getCurrentUrl().contains(Locators.val_login)) {
			result = true;
		}
		else {
			result = false;
		}

		//verify that the expected result and the actual result matched or not
		Assert.assertTrue(result);	 
		Config.test.pass("url contain login");
	}

	//test
	@Test(priority = 27)
	public void validateTitle() throws InterruptedException {

		//test case and description
		Config.test = Config.extent.createTest("Title should be OrangeHRM", "validate that Title should be OrangeHRM");
		String actualTitle = Config.driver.getTitle();
		String expectedTitle = InstanceVariables.exp_title;

		//verify that the expected result and the actual result matched or not
		Assert.assertEquals(actualTitle, expectedTitle);

		Config.test.pass("Test Passed");
		Thread.sleep(5000);
	}
}