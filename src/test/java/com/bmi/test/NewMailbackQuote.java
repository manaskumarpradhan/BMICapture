package com.bmi.test;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

//import Utility.SyncWebPage;
import com.bmi.utility.SyncWebPage;
//import Utility.WebPageUtility;
import com.bmi.utility.WebPageUtility;
import com.relevantcodes.extentreports.LogStatus;
import com.bmi.base.TestBase;
//import BMI.CommonTest.BrowserFactory;
import com.bmi.commontest.BrowserFactory;
//import BMI.CommonTest.FillSiteInformation;
import com.bmi.commontest.FillSiteInformation;
//import BMI.CommonTest.ReadPropertyFile;
import com.bmi.commontest.ReadPropertyFile;
//import BMI.CommonTest.ServiceInfoConfigure;

//import BMI.Page.CustomerSiteInfo2;
import com.bmi.pageobjects.CustomerSiteInfo2;
//import BMI.Page.FinalizeQuote;
import com.bmi.pageobjects.FinalizeQuote;
//import BMI.Page.GenerateDoc;
import com.bmi.pageobjects.GenerateDoc;
//import BMI.Page.LoginPage;
import com.bmi.pageobjects.LoginPage;
//import BMI.Page.NavigateQuoteCreation;
import com.bmi.pageobjects.NavigateQuoteCreation;
//import BMI.Page.ProvidePricing
import com.bmi.pageobjects.ProvidePricing;
//import BMI.Page.SelectServiceInfo_3_ElectonicRecycling;
import com.bmi.pageobjects.SelectServiceInfo_3_ElectonicRecycling;
//import BMI.Page.SelectServiceInfo_Configure;
import com.bmi.pageobjects.SelectServiceInfo_Configure;
//import BMI.Page.StartNewQuote_1;
import com.bmi.pageobjects.StartNewQuote_1;

public class NewMailbackQuote extends TestBase{
	
	//public WebDriver driver;
	
	@Test
	public void createMailBackQuote() throws Exception{
		
		test=reports.startTest("NewMailbackQuote");
		
		//get the details of test data from properties file
		
		ReadPropertyFile prop=new ReadPropertyFile();
		String bmiUrl=prop.getUrl();
		String userName=prop.getUsername();
		String password=prop.getPassword();
		String area=prop.getArea();
		String division=prop.getDivision();
		
		test.log(LogStatus.INFO,"Property file reading completed");
		
		BrowserFactory browser=new BrowserFactory();
		driver=browser.startBrowser("chrome");
		driver.get(bmiUrl);
		
		test.log(LogStatus.INFO,"browser opened ");
		
		//calling webpage utility class
		WebPageUtility utility=new WebPageUtility(driver);
		
		//Calling SyncWeb Page
		SyncWebPage sync=new SyncWebPage(driver);
		

		//login to BMI Capture application
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		utility.sendText(loginpage.username, userName);
		utility.sendText(loginpage.Password, password);
		utility.clickButton(loginpage.LoginBtn);
		
		test.log(LogStatus.INFO,"capture login successful");
		//navigate to start new quote
		NavigateQuoteCreation createQuote=PageFactory.initElements(driver, NavigateQuoteCreation.class);
		sync.waitforVisibilityOfElement(createQuote.StartNewQuoteBtn);
		utility.clickButton(createQuote.StartNewQuoteBtn);
		
		//create new Quote
		StartNewQuote_1 newQuote= PageFactory.initElements(driver,StartNewQuote_1.class);
		utility.selectFromCombo(newQuote.AreaCombo, area);
		Thread.sleep(3000);
		utility.selectFromCombo(newQuote.DivisionCombo, division);
		utility.selectFromCombo(newQuote.salesActivityCombo, "New");
		Thread.sleep(1500);
		utility.sendText(newQuote.QuoteDesCription, "MailBack Quote");
		Thread.sleep(1000);
		utility.clickButton(newQuote.nextBtn);
		Thread.sleep(1000);
		test.log(LogStatus.INFO,"Area and division combo filled");
		
		//wait for next page-'Industry combo' to display 
		CustomerSiteInfo2 fillSiteInfo=PageFactory.initElements(driver,CustomerSiteInfo2.class);
		sync.waitforVisibilityOfElement(fillSiteInfo.industryCombo);
		
		//call to  Enter Customer Site Info --calling common function
		FillSiteInformation fillsiteInfo=new FillSiteInformation(driver);
		fillsiteInfo.fillSiteInfo();
		
		test.log(LogStatus.INFO,"site info filling completed");
		
		//wait for next page-'Electronic Recycling' to display
		SelectServiceInfo_Configure serviceOffering=PageFactory.initElements(driver, SelectServiceInfo_Configure.class);
		sync.waitforVisibilityOfElement(serviceOffering.ElectronicRecyclingBtn);
		
		//click electronic recycling
		utility.clickButton(serviceOffering.ElectronicRecyclingBtn);
		
		//Calling Service Info Details page 
		SelectServiceInfo_3_ElectonicRecycling erService=PageFactory.initElements(driver,SelectServiceInfo_3_ElectonicRecycling.class);
		sync.waitforVisibilityOfElement(erService.eRecyclingCatagoryCombo);
		utility.selectFromCombo(erService.eRecyclingCatagoryCombo, "Box Mail-Back");
		sync.waitforVisibilityOfElement(erService.crtTvQty);
		
		//entering the qty required
		utility.sendText(erService.crtTvQty, "1");
		utility.sendText(erService.lcdTvQty,"11");
		utility.sendText(erService.gamingDTvQty, "1");
		utility.clickButton(erService.estimateBoxQty);
		Thread.sleep(1000);
		
		//Total full pallet qty verify
		String totalfullpalletqty=utility.getAttribute(erService.totalFullPalletBoxes, "value");
		System.out.println("Total of full palet is "+totalfullpalletqty);
		Assert.assertTrue(totalfullpalletqty.equals("2"));
		utility.clickButton(erService.nextBtn);
		test.log(LogStatus.INFO,"service info details entered");
		
		//calling provide pricing screen
		
		ProvidePricing pricepage=PageFactory.initElements(driver, ProvidePricing.class);
		sync.waitforVisibilityOfElement(pricepage.additionalServiceBtn);
		utility.clickButton(pricepage.calculatePriceBtn);
		Thread.sleep(700);
		
		//verifying sell price
		String sellPrice=utility.getAttribute(pricepage.sellPrice, "value");
		System.out.println(sellPrice);
		Assert.assertTrue(sellPrice.equals("$600.00"),"sell price is not correct in pricing page");
		//Verify billing method
		String billingMethodType=utility.getText(pricepage.billingMethod);
		Assert.assertTrue(billingMethodType.equalsIgnoreCase("One-time"), "Billing method not matching");
		utility.clickButton(pricepage.nextBtn);
		test.log(LogStatus.INFO,"Sell price details verified");
		//calling generate documents page
		GenerateDoc genDoc=PageFactory.initElements(driver, GenerateDoc.class);
		sync.waitforVisibilityOfElement(genDoc.printDocumentBtn);
		utility.clickButton(genDoc.nextBtn);
		test.log(LogStatus.INFO,"Document Generated");
		//calling Finalize Quote Button
		FinalizeQuote finalQuote=PageFactory.initElements(driver, FinalizeQuote.class);
		sync.waitforVisibilityOfElement(finalQuote.nextBtn);
		Thread.sleep(1500);
		utility.clickRadioButton(finalQuote.acceptedSignedRSICSA);
		Thread.sleep(1500);
		utility.selectFromCombo(finalQuote.leadSourceCombo, "A - Business Card");
		Thread.sleep(800);
		utility.clickButton(finalQuote.nextBtn);
		sync.waitforVisibilityOfElement(finalQuote.sendOrderBtn);
		utility.clickButton(finalQuote.sendOrderBtn);
		sync.waitforVisibilityOfElement(finalQuote.finalizeBtn);
		utility.clickButton(finalQuote.finalizeBtn);
		//driver.close();
		test.log(LogStatus.INFO,"New MailBack quote created");
		
	}



}
