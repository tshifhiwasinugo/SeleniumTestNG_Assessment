package com.selenium.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

//using extends to access characteristics of Config class
public class AddUser extends Config {

	//test
	@Test(priority = 15)
	public void test_case_five() throws InterruptedException {

		//3 seconds delay
		Thread.sleep(3000);

		//prompt to input data into user
		Select user_role = new Select(Config.driver.findElement(By.name(Locators.user_role)));
		user_role.selectByVisibleText("ESS");

		Config.driver.findElement(By.name(Locators.uEmp_name)).sendKeys(InstanceVariables.EmpName);
		Config.driver.findElement(By.name(Locators.uname)).sendKeys(InstanceVariables.input_username);
		Config.driver.findElement(By.name(Locators.upassword)).sendKeys(InstanceVariables.input_password);
		Config.driver.findElement(By.name(Locators.cpassword)).sendKeys(InstanceVariables.input_con_password);

		//save your data
		WebElement save = Config.driver.findElement(By.id("btnSave"));
		save.click();
	}

	//test
	@Test(priority = 16)

	//Validate status dropdown
	public void VerifyStatusDropdown() {

		//test case and description
		Config.test = Config.extent.createTest("status dropdown validation", "Verify Status dropdown is Selected to enabled");

		//selecting status using web element by id
		Select status = new Select(Config.driver.findElement(By.id("systemUser_status")));
		
		//boolean result = driver.findElement(By.xpath("xpath")).isEnabled();
		//checking if first select option is enabled or not
		if(status.getFirstSelectedOption().getText().equalsIgnoreCase(Locators.status_enabled)) {
			result = true;
		}
		else {
			result = false;
		}

		//verify that the expected result and the actual result matched or not
		Assert.assertTrue(result);
		Config.test.pass("stutus dropdown is enabled");
	}
}
