package com.bmi.base;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.bmi.utility.CommonUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * Author "Manas Pradhan"
 * Date Created - 9 Jul 2017
 * This class is the base class for other classes in the suite
 * for capturing screenshot on fialure , creating logs
 * and sending extent report email to management
 */

public class TestBase {

	public  WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;

	public EmailAttachment attachment;
	public MultiPartEmail email;

	// @BeforeMethod()
	@BeforeSuite
	public void setup() {

		reports = new ExtentReports("./src/test/resources/logs/RegressionTest.html", true);
		System.out.println("started test log in extn");
	}

	@AfterMethod()
	public void getResult(ITestResult result) throws Exception {
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test Passed");
			System.out.println("Test passed in m method");
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			Thread.sleep(2000);
			String screenshotpath = CommonUtil.takesScreenshot(driver, result.getName());
			Thread.sleep(1000);
			String image = test.addScreenCapture(screenshotpath);
			Thread.sleep(1000);
			test.log(LogStatus.FAIL, "Snapshot below", image);
			test.log(LogStatus.FAIL, "Test Failed");
			test.log(LogStatus.INFO, result.getThrowable());

		}

		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Skipped");
		}


		else {
			test.log(LogStatus.INFO, "Test failed for TestNg unknown reason");
		}
		
		driver.quit();

	}

	@AfterSuite (alwaysRun = true)
	public void tearDown() throws InterruptedException, EmailException {
		System.out.println("report flushed started");
		reports.flush();
		System.out.println("report flushed");
		Thread.sleep(10000);

		// email Extent Reportreport

		// Create the attachment
		attachment = new EmailAttachment();
		attachment.setPath("./src/test/resources/logs/RegressionTest.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Selenium-Extent Report");
		attachment.setName("ExtentReport");

		// Create the email message
		email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("manaspradhan.kumar@gmail.com", "devyani@123"));
		email.setSSLOnConnect(true);
		email.addTo("manaspradhan.kumar@yahoo.com", "Manas Pradhan");
		email.setFrom("manaspradhan.kumar@gmail.com", "Manas Pradhma");
		email.setSubject("Selenium-Extent Report");
		email.setMsg("please find the enclosed html doc of test run report, "
				+ "please download and open the document with any web browser");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();

	}

}
