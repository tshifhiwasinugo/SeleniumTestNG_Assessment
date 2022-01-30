package com.selenium.assessment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

//using extends to access characteristics of Config class
public class DeleteTab {

	//test
	@Test(priority = 22)

	public void test_case_seven() throws InterruptedException {

		//selecting delete button and delete data for user
		Thread.sleep(3000);
		Config.driver.findElement(By.name(Locators.select_all)).click();
		Thread.sleep(2000);
		Config.driver.findElement(By.name(Locators.btn_del)).click();
		Thread.sleep(2000);
		Config.driver.findElement(By.id(Locators.dialog_del)).click();
		Thread.sleep(2000);
	}
}
