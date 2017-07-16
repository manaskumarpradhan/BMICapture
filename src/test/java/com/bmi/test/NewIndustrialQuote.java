package com.bmi.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.bmi.base.TestBase;
import com.bmi.commontest.BrowserFactory;
import com.bmi.commontest.FillSiteInformation;
import com.bmi.commontest.FinalizeQuoteCreation;
import com.bmi.commontest.GenerateDocuments;
import com.bmi.commontest.LoginToCapture;
import com.bmi.commontest.ProvidePrice;
import com.bmi.commontest.ReadPropertyFile;
import com.bmi.commontest.ServiceInfoConfigure;
import com.bmi.commontest.ServiceInfoIndustrial;
import com.bmi.commontest.StartNewQuote;
import com.relevantcodes.extentreports.LogStatus;

public class NewIndustrialQuote extends TestBase {
	//public WebDriver driver;

	@Test
	public void createIndQuote() throws Exception {

		test = reports.startTest("NewIndustrialQuote");

		// get the details of test data from properties file

		ReadPropertyFile prop = new ReadPropertyFile();
		String bmiUrl = prop.getUrl();
		String userName = prop.getUsername();
		String password = prop.getPassword();
		
		
		test.log(LogStatus.INFO, "Property file reading completed");

		// Call Browser Factory test from BMI.CommonTest package
		BrowserFactory bf = new BrowserFactory();
		driver = bf.startBrowser("chrome");
		
		test.log(LogStatus.INFO, "Browser Opened");

		// call navigate to capture test link
		
		driver.get(bmiUrl);
		//NavigateToCaptureServer navigateTestServer = new NavigateToCaptureServer(driver);
		//navigateTestServer.startTestServer();

		// Call LoginToCapture test from BMI.CommonTest package

		LoginToCapture login = new LoginToCapture(driver);
		login.login(userName, password);
		test.log(LogStatus.INFO, "Capture login successful");

		// Start new Quote

		StartNewQuote newQuote = new StartNewQuote(driver);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_quote")));
		newQuote.clickStartNewQuoteBtn();
		newQuote.fillAreaDivision("A03 - SOUTHWEST","4753 - AWS - PHOENIX");
		
		test.log(LogStatus.INFO, "Area and Division combo filling completed");

		// "A10 - GREAT LAKES","4491 - AWS - PIERSON"

		// Fill Site Infomation
		FillSiteInformation fillsite = new FillSiteInformation(driver);
		fillsite.fillSiteInfo();
		
		test.log(LogStatus.INFO, "Site info filling completed");

		// Select service Info configure
		ServiceInfoConfigure sic = new ServiceInfoConfigure(driver);
		sic.clickLargeContainer();

		// Industrial service detail

		ServiceInfoIndustrial sid = new ServiceInfoIndustrial(driver);
		sid.fillIndServiceInfo();
		
		test.log(LogStatus.INFO, "Service info filling completed");
		// Provide pricing calling from Common test library

		ProvidePrice pp = new ProvidePrice(driver);
		pp.configurePrice();
		test.log(LogStatus.INFO, "Provide Price completed");

		// Call GenerateDocuments from commonTest library

		GenerateDocuments genDoc = new GenerateDocuments(driver);
		genDoc.generateDoc();
		
		test.log(LogStatus.INFO, "Document generation completed");

		// call FinalizeQuoteCreation test from commonTest library
		FinalizeQuoteCreation finalQuote = new FinalizeQuoteCreation(driver);
		finalQuote.finalizeQuote();
		//driver.quit();
		test.log(LogStatus.INFO, "New Industrial Quote  created");

	}
}
