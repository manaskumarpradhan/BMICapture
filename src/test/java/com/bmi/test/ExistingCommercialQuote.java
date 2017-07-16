package com.bmi.test;

import java.util.ArrayList;  




import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
   


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import com.bmi.commontest.BrowserFactory;

//import BMI.CommonTest.LoginToCapture;
//import BMI.CommonTest.ReadPropertyFile;
//import BMI.Page.*;
//import DemoPack.Browser;

import com.bmi.commontest.LoginToCapture;
import com.bmi.commontest.ReadPropertyFile;
import com.bmi.pageobjects.*;
import com.bmi.utility.SyncWebPage;
import com.bmi.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;





public class ExistingCommercialQuote extends TestBase 
{
	
	
	//public WebDriver driver; --because of this test extendts TestBase Webdriver not required here
	
	String url="";
	String username="";
	String password="";
	String area="";
	String division="";
	String InfoProDivisionAccount="";
	
	
	@Test (priority=1)
	public void openBrowser() throws Exception {
		
		
		test=reports.startTest("ExistingCommercialQuote");
		
		//Reading Property File
		ReadPropertyFile rpf=new ReadPropertyFile();
		username=rpf.getUsername();
		password=rpf.getPassword();
		url=rpf.getUrl();
		area=rpf.getArea();
		division=rpf.getDivision();
		InfoProDivisionAccount=rpf.getInfoProDivisionAccount();
		
		test.log(LogStatus.INFO, "Property file reading completed");
		
		BrowserFactory br=new BrowserFactory();
		driver=br.startBrowser("chrome");
		
		test.log(LogStatus.INFO,"browser opened");
		
		driver.get(url);
		driver.manage().window().maximize();
		
		//Call the common test
		LoginToCapture lc=new LoginToCapture(driver);
		lc.login(username, password);
		test.log(LogStatus.INFO, "capture login successful");
		
		//starts here   ********************************************************
		
		NavigateQuoteCreation	nqc=PageFactory.initElements(driver,NavigateQuoteCreation.class);
		SyncWebPage sync=new SyncWebPage(driver);
		sync.waitforVisibilityOfElement(nqc.StartNewQuoteBtn);
		nqc.ClickStartNewQuote();
		Thread.sleep(2000);
		test.log(LogStatus.INFO,"Quote creation screen opened");
		
		StartNewQuote_1 snq=PageFactory.initElements(driver, com.bmi.pageobjects.StartNewQuote_1.class);
		sync.waitforVisibilityOfElement(snq.AreaCombo);
		snq.Select_Area(area);
		Thread.sleep(3000);
		snq.Select_Division(division);
		Thread.sleep(2300);
		snq.Select_salesActivity_quote("Existing Customer");
		Thread.sleep(2000);
		snq.Enter_QuoteDesCription("Existing Customer");
		snq.Click_nextBtn();
		
		test.log(LogStatus.INFO,"area, division, sales type fileter selected");
		
		CustomerSiteInfo2 srh=PageFactory.initElements(driver, CustomerSiteInfo2.class);
		
		sync.waitforVisibilityOfElement(srh.selectCustomerBtn);
		srh.clickSelectCustomerBtn();
		Thread.sleep(5000);
		ArrayList<String> al=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(al.get(1));
		srh.enterDivisionAccount(InfoProDivisionAccount);
		srh.clickSerachBtn();
		Thread.sleep(3000);
		srh.clickViewAllSiteLink();
		Thread.sleep(1000);
		srh.clickPopulateBtn();
		Thread.sleep(2000);
		driver.switchTo().window(al.get(0));
		srh.SelectIndustryCombo("Education");
		Thread.sleep(500);
		srh.selectSegmentCombo("Price");
		Thread.sleep(2000);
		srh.EnterAuthorizedBy("Manas Pradhan");
		srh.EnterEmailId("mkp@gmail.com");
		srh.ClickFindOnMapBtn();
		Thread.sleep(1300);
		//Assert.assertTrue(srh.latitudeDisplay().isDisplayed());
		srh.ClickNextBtn();
		
		test.log(LogStatus.INFO,"Customer site info entered");
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small_container")));
		
		//Scroll up using Action
		Actions a =new Actions(driver);
		for(int i=0;i<10;i++){
		a.sendKeys(Keys.UP).build().perform();
		}
		Thread.sleep(2000);
		SelectServiceInfo_Configure si=PageFactory.initElements(driver, SelectServiceInfo_Configure.class);
		si.clickNextBtnFirst();
		
		//calling service info commercial screen
		
		SelectServiceInfo_3_COM serviceInfo=PageFactory.initElements(driver, SelectServiceInfo_3_COM.class);
		sync.waitforVisibilityOfElement(serviceInfo.containerQtyEdit);
		serviceInfo.containerQtyEdit.clear();
		serviceInfo.enterEditContainerQty("2");
		serviceInfo.clickSaveBtn();
		Thread.sleep(2000);
		serviceInfo.clickNextBtn();
		
		test.log(LogStatus.INFO,"commercial container service info entered");
		
		ProvidePricing price=PageFactory.initElements(driver, ProvidePricing.class);
		sync.waitforVisibilityOfElement(price.calculatePriceBtn);
		price.click_calculatePriceBtn();
		Thread.sleep(3000);
		
		String sellPrice=price.getSellPrice();
		System.out.println(sellPrice);
		price.click_nextBtn();
		
		test.log(LogStatus.INFO,"Pricing details completed");
		Thread.sleep(2000);
		
		//after the next button the code needs to add for popup window if exist
		if(price.popupWindow.isDisplayed()){
			
			//driver.switchTo().alert().accept();
			price.clickSubmitButton();
			Thread.sleep(5000);
			
			//Scroll up using Action class
			for(int i=0;i<25;i++){
			 a.sendKeys(Keys.UP).build().perform();
			}
				Thread.sleep(2000);
			ObtainedApproval approval=PageFactory.initElements(driver, ObtainedApproval.class);
			approval.clickApproved1Btn();
		}
		
		GenerateDoc generateDoc=PageFactory.initElements(driver, GenerateDoc.class);
		sync.waitforVisibilityOfElement(generateDoc.nextBtn);
		
		String sellPriceN=generateDoc.getSellPrice();
		System.out.println(sellPriceN);
		
		generateDoc.clickNextBtn();
		test.log(LogStatus.INFO,"Document generation completed");
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finalize")));
		
		
		FinalizeQuote finalizeQuote=PageFactory.initElements(driver, FinalizeQuote.class);
		sync.waitforVisibilityOfElement(finalizeQuote.acceptedSignedRSICSA);
		finalizeQuote.clickAcceptedSignedRSICSA();
		Thread.sleep(3000);
		finalizeQuote.clickFinalizeBtn();
		String quoteNumber=driver.findElement(By.id("readonly_1_quoteNumber_RO_quote")).getText();
		System.out.println("Edit Quote Number= "+quoteNumber);
		Thread.sleep(2000);
		//driver.quit();
		test.log(LogStatus.INFO,"quote creation successful");
		
		
		
	}
	
	
}
