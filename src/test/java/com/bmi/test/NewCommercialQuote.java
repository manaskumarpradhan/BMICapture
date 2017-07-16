package com.bmi.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bmi.base.TestBase;
import com.bmi.commontest.BrowserFactory;

import com.bmi.commontest.LoginToCapture;
import com.bmi.commontest.ReadPropertyFile;
import com.bmi.pageobjects.CustomerSiteInfo2;
import com.bmi.pageobjects.FinalizeQuote;
import com.bmi.pageobjects.GenerateDoc;
import com.bmi.pageobjects.NavigateQuoteCreation;
import com.bmi.pageobjects.ProvidePricing;
import com.bmi.pageobjects.SelectServiceInfo_3_COM;
import com.bmi.pageobjects.SelectServiceInfo_Configure;
import com.bmi.pageobjects.StartNewQuote_1;
import com.bmi.utility.SyncWebPage;
import com.relevantcodes.extentreports.LogStatus;

public class NewCommercialQuote extends TestBase {

	// public WebDriver driver; --this line not required because Webdriver already coming from TestBase

		String bmiURL = "";
		String userName = "";
		String password = "";
		String area = "";
		String division = "";

		// Open browser and Enter Capture Test url
		@Test
		public void StartBrowser() throws Exception {
		System.out.println("this test started only");
		test = reports.startTest("NewCommercialQuote");

		// Reading property file
		ReadPropertyFile prop = new ReadPropertyFile();
		bmiURL = prop.getUrl();
		userName = prop.getUsername();
		password = prop.getPassword();
		area = prop.getArea();
		division = prop.getDivision();
		test.log(LogStatus.INFO, "property file reading completed");

		// starting the browser
		BrowserFactory br = new BrowserFactory();
		driver = br.startBrowser("chrome");
		test.log(LogStatus.INFO, "browser opened");
		driver.get(bmiURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// Call to Common login Test
		LoginToCapture lc = new LoginToCapture(driver);
		lc.login(userName, password);

		test.log(LogStatus.INFO, "Capture login successful");

		// click on newQuote button
		NavigateQuoteCreation ncc = PageFactory.initElements(driver, NavigateQuoteCreation.class);
		SyncWebPage sync = new SyncWebPage(driver);
		sync.waitforVisibilityOfElement(ncc.StartNewQuoteBtn);
		
		ncc.ClickStartNewQuote();
		Thread.sleep(2000);

		StartNewQuote_1 nq = PageFactory.initElements(driver, StartNewQuote_1.class);
		nq.Select_Area(area);
		Thread.sleep(3000);
		nq.Select_Division(division);
		// Thread.sleep(2300);
		nq.Select_salesActivity_quote("New");
		Thread.sleep(1500);
		nq.Enter_QuoteDesCription("new quote");
		Thread.sleep(1000);
		nq.Click_nextBtn();

		test.log(LogStatus.INFO, "Area Division details entered");
		
		//enter Site info details
		
		 CustomerSiteInfo2 siteinfo=new CustomerSiteInfo2(driver);
		 PageFactory.initElements(driver,siteinfo);
		 sync.waitforVisibilityOfElement(siteinfo.industryCombo);
		 siteinfo.SelectIndustryCombo("Education");
		 Thread.sleep(2000);
		 siteinfo.selectSegmentCombo("Price");
		 Thread.sleep(2000);
		 siteinfo.EnterAuthorizedBy("Manas Pradhan");
		 siteinfo.EnterSite("ABC Test");
		 siteinfo.EnterAddress1("18500 N Allied Way");
		 siteinfo.EnterCity("Phoenix"); siteinfo.SelectStateCombo("AZ");
		 Thread.sleep(1000); siteinfo.EnterZipCode("85054");
		 siteinfo.EnterTelephoneNo("9959044444");
		 siteinfo.EnterContactName("MKP"); siteinfo.EnterTittle("sales Rep");
		 siteinfo.EnterEmailId("mpradhan@gmail.com"); 
		 Thread.sleep(1000);
		  
		  test.log(LogStatus.INFO, "site details entered");
		  siteinfo.ClickFindOnMapBtn();
		  Thread.sleep(3000); 
		  //verifying whether latitude and longitude displayed
		  Assert.assertTrue(siteinfo.latitudeDisplay().isDisplayed(), "Latitude not found, not a valid address");
		  test.log(LogStatus.INFO, "successfully lat and long verified");
		  
		  Thread.sleep(1000);
		  siteinfo.ClickNextBtn();
		 
		  // Service info configure page
		  SelectServiceInfo_Configure cso=PageFactory.initElements (driver, SelectServiceInfo_Configure.class);
		  sync.waitforVisibilityOfElement(cso.smallContainerBtn); 
		  cso.clickSmallContainerBtn();
		
		 // call service offering detail page
		  
		  SelectServiceInfo_3_COM csod=PageFactory.initElements (driver, SelectServiceInfo_3_COM.class); 
		  sync.waitforVisibilityOfElement(csod.wasteTypeCombo);
		  csod.selectWasteTypeCombo("Solid Waste");
		  sync.waitforVisibilityOfElement(csod.routeTypeCombo);
		  csod.selectRouteTypeCombo("Front Load");
		  Thread.sleep(1000); 
		  csod.selectCompetitorCombo("NEW/NEW");
		  Thread.sleep(2000); 
		  csod.SelectAccountTypeCombo("Permanent");
		  Thread.sleep(1000); 
		  //csod.clearContainerQty();
		  //csod.enterContainerQty("1"); 
		  csod.selectContainerSize("8 yard"); 
		  Thread.sleep(1000); 
		  csod.clickSaveBtn();
		  Thread.sleep(5000); 
		  csod.clickNextBtn(); 
		  test.log(LogStatus.INFO, "service details entered");
		  
		  //calling provide pricing 
		  
		  ProvidePricing pp=PageFactory.initElements(driver,ProvidePricing.class);
		  sync.waitforVisibilityOfElement(pp.calculatePriceBtn);
		  pp.click_calculatePriceBtn();
		  Thread.sleep(5000);
		  pp.click_nextBtn();
		  test.log(LogStatus.INFO, "Pricing details verified");
		  
		  //calling Generate Document
		  
		  GenerateDoc genDoc=PageFactory.initElements(driver,GenerateDoc.class);
		  sync.waitforVisibilityOfElement(genDoc.nextBtn);
		  genDoc.clickNextBtn();
		  test.log(LogStatus.INFO, "Document Generation completed");
		  
		  // Finalize Quote
		  
		  FinalizeQuote finalquote=PageFactory.initElements(driver,FinalizeQuote.class);
		  sync.waitforVisibilityOfElement(finalquote.acceptedSignedRSICSA);
		  finalquote.clickAcceptedSignedRSICSA();
		  Thread.sleep(1500);
		  finalquote.selectLeadSourceCombo("A - Business Card");
		  Thread.sleep(700);
		  finalquote.clickFinalizeBtn(); 
		  Thread.sleep(800);
		 // driver.quit();
		  test.log(LogStatus.INFO, "New Commercial Quote created");
		   	  		  
     }

}
