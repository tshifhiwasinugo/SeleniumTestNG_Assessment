/**
 * @author Tshifhiwa.Sinugo
 * Date: 28/01/2022
 * Test Case Title: Selenium Verify User Added Funtionality
 * Description: Checking User Addition, Search and Delete Functionality working properly
 */

package com.selenium.assessment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Config {

	//global variables
	static ExtentReports extent; 
	static WebDriver driver;
	static ExtentTest test;
	static Logger logger;
	static boolean result;

	@BeforeSuite
	public void setup() {
		//starts reports
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/Spark.html");

		//create extent reports and attach reporters
		extent = new ExtentReports();
		extent.attachReporter(spark);

		// launch browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 

		//logger
		logger = LogManager.getLogger(PageTitle.class);
		logger = LogManager.getLogger(Login.class);
		logger = LogManager.getLogger(AdminTab.class);
		logger = LogManager.getLogger(AddButton.class);
		logger = LogManager.getLogger(AddUser.class);
		logger = LogManager.getLogger(SearchTab.class);
		logger = LogManager.getLogger(DeleteTab.class);
		logger = LogManager.getLogger(VerifyUserRecord.class);
		logger = LogManager.getLogger(Logout.class);

	}

	@AfterMethod
	public void EvaluateResult(ITestResult result) {

		if(result.getStatus() == ITestResult.FAILURE) {
			Config.test.fail("Test Failed");
			Config.logger.info("Test Failed");
		}
	}

	@AfterSuite
	public void cleanUp() throws InterruptedException {
		//calling flush writes everything to the log file 
		extent.flush();   

		//delay by 7 seconds
		Thread.sleep(4000); 

		//close browser
		Config.driver.close();

		//quit browser
		Config.driver.quit();
	}
}