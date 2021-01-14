package com.automation.tests.amazon;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public abstract class TestBase {
	protected WebDriver driver;
	protected Actions actions;

	protected ExtentReports report;
	protected ExtentSparkReporter htmlReporter;
	protected ExtentTest extentLogger;
	
	@BeforeTest
	public void setUpTest() {
		report = new ExtentReports();
		String filePath = System.getProperty("user.dir") + "/test-output/report.html";
		htmlReporter = new ExtentSparkReporter(filePath);
		report.attachReporter(htmlReporter); 
		report.setSystemInfo("ENV", "staging");
		report.setSystemInfo("browser", ConfigurationReader.getProperty("browser"));
		report.setSystemInfo("OS", System.getProperty("os.name"));

		htmlReporter.config().setReportName("Amazon Checkout Automated Test Report");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = Driver.getDriver();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

		driver.get(ConfigurationReader.getProperty("url"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotLocation = BrowserUtils.getScreenshot(result.getName());
			extentLogger.fail(result.getName());
			extentLogger.addScreenCaptureFromPath(screenshotLocation);
			extentLogger.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentLogger.skip("Test Case Skipped is " + result.getName());
		}
		Driver.closeDriver();
	}

	@AfterTest
	public void tearDownTest() {
		report.flush();
	}

}




