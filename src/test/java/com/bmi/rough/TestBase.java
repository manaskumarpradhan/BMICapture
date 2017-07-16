package com.bmi.rough;


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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static ExtentReports reports;
	public static ExtentTest test;
	public  WebDriver driver;
	
	public  EmailAttachment attachment;
	public MultiPartEmail email;


	@BeforeMethod
	//@BeforeSuite
	public void setup() {
		reports = new ExtentReports("./src/test/resources/logs/demosuite.html", true);
	}

	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(LogStatus.FAIL, "Test Failed");
			test.log(LogStatus.INFO, result.getThrowable());

		}

		else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, "Test Passed");
		}

		else {

			test.log(LogStatus.SKIP, "Test Skipped");
		}

	}

	@AfterSuite()
	public void tearDown() throws EmailException, InterruptedException {
		reports.flush();
		
		Thread.sleep(5000);
		
		//email Extent Reportreport
		System.out.println("mail send started");
		// Create the attachment
		  attachment = new EmailAttachment();
		  attachment.setPath("./src/test/resources/logs/demosuite.html");
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
		  email.setMsg("please find the enclosed html doc of test run report, please download and open the document with any web browser");

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
		  System.out.println("mail sent");

		

	}

}
