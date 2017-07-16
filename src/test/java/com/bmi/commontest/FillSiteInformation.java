package com.bmi.commontest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import BMI.Page.CustomerSiteInfo2;
import com.bmi.pageobjects.CustomerSiteInfo2;

public class FillSiteInformation {

	
	WebDriver driver;
	
	public FillSiteInformation(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void fillSiteInfo()throws Exception {
		
		CustomerSiteInfo2  siteinfo=new 
				           CustomerSiteInfo2(driver);
		PageFactory.initElements(driver,siteinfo);
		siteinfo.SelectIndustryCombo("Education");
		Thread.sleep(2000);
		siteinfo.selectSegmentCombo("Price");
		Thread.sleep(2000);
		siteinfo.EnterAuthorizedBy("Manas Pradhan");
		siteinfo.EnterSite("ABC Test");
		siteinfo.EnterAddress1("2320 E Jones Ave");   //18500 N Allied Way
		siteinfo.EnterCity("Phoenix");
		siteinfo.SelectStateCombo("AZ");
		Thread.sleep(1000);
		siteinfo.EnterZipCode("85040");
		siteinfo.EnterTelephoneNo("9959044444");
		siteinfo.EnterContactName("MKP");
		siteinfo.EnterTittle("sales Rep");
		siteinfo.EnterEmailId("mpradhan@gmail.com");
		Thread.sleep(1300);
		siteinfo.ClickFindOnMapBtn();
		Thread.sleep(3000);
		//verifying whether latitude and longitude displayed
		Assert.assertTrue(siteinfo.latitudeDisplay().isDisplayed(),
				        "Latitude not found, not a valid address");
		
		Thread.sleep(1000);
		siteinfo.ClickNextBtn();
		Thread.sleep(4000);
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("small_container")));
	}

}
