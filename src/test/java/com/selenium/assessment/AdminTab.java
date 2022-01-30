package com.selenium.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//using extends to access characteristics of Config class
public class AdminTab extends Config {

	//test
	@Test(priority = 6)


	public void test_case_three() {

		//click to navigate to admin tab
		Config.driver.findElement(By.linkText(Locators.admin_tab)).click();	
	}

	//test
	@Test(priority = 7)

	//validating admin Url
	public void validateAdminUrl() {

		//test case and description
		Config.test = Config.extent.createTest("Url should contain admin/viewSystemUsers", "Validate that url contain admin/viewSystemUsers");

		//admin url
		String admin_url = Locators.admin_url;

		//checking if current url contains admin url
		if(Config.driver.getCurrentUrl().contains(admin_url)) {
			result = true;
		}
		else {
			result = false;
		}

		//verify that the expected result and the actual result matched or not
		Assert.assertTrue(result);	 
		Config.test.pass("url contain admin/viewSystemUsers");
	}

	//test
	@Test(priority = 8)
	public void validateAdd () {

		//test case and description
		Config.test = Config.extent.createTest("Add button should be displayed", "Validate that add button is displayed");

		//calling web element by name 
		WebElement save_btn = Config.driver.findElement(By.name(Locators.save_btn));

		//checking if add button is displayed or not 
		if(save_btn.isDisplayed()) {
			Config.test.pass("save button is displayed");
		}
	}

	//test
	@Test (priority = 9)
	public void validateDelete() {

		//test case and description
		Config.test = Config.extent.createTest("Delete button should be displayed", "Validate that delete button is displayed");

		//calling web element by name
		WebElement delete_btn = Config.driver.findElement(By.name(Locators.delete_btn));

		//checking if delete button is displayed or not 
		if(delete_btn.isDisplayed()) {
			Config.test.pass("delete button is displayed");
		}
	}

	//test
	@Test(priority = 10)
	public void validateSearch() {

		//test case and description
		Config.test = Config.extent.createTest("Search button should be displayed", "Validate that search button is displayed");

		//calling web element by name
		WebElement search_btn = Config.driver.findElement(By.name(Locators.search_btn));

		//checking if search button is displayed or not 
		if(search_btn.isDisplayed()) {
			Config.test.pass("search button is displayed");
		}
	}

	//test
	@Test(priority = 11)
	public void validateReset() {

		//test case and description
		Config.test = Config.extent.createTest("Reset button should be displayed", "Validate that reset button is displayed");

		//calling web element by name
		WebElement reset_btn = Config.driver.findElement(By.name(Locators.reset_btn));

		//checking if reset button is displayed or not 
		if(reset_btn.isDisplayed()) {
			Config.test.pass("reset button is displayed");
		}
	}
}
