package com.bmi.commontest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



/*
 * This is a common test to select service information for industrial customer
 * this script will take data from MasterData.xlsx file
 * ***Author*** <<<Manas Pradhan>>>
 */

//import BMI.Page.SelectServiceInfo_3_IND;
import com.bmi.pageobjects.*;

public class ServiceInfoIndustrial {
	
	WebDriver driver;
	
	public ServiceInfoIndustrial(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebDriver fillIndServiceInfo() throws Exception
	{
		SelectServiceInfo_3_IND selectservIND=PageFactory.initElements(driver, SelectServiceInfo_3_IND.class);
		selectservIND.selectContainerType("Open Top");
		Thread.sleep(3000);
		selectservIND.selectBillingType("Haul + Disposal");
		Thread.sleep(4000);
		selectservIND.selectRental("None");
		Thread.sleep(1000);
		selectservIND.selectWasteType("Concrete");
		Thread.sleep(3000);
		selectservIND.selectUOM("per load"); 
		Thread.sleep(1000);
		selectservIND.selectSpecialHandlingCode("N - None");
		Thread.sleep(1000);
		selectservIND.selectCompetitor("NEW/NEW");
		Thread.sleep(2000);
		selectservIND.selectAccountType("Permanent");
		Thread.sleep(1000);
		selectservIND.selectDisposalVsProcessing("Disposal");
		Thread.sleep(1000);
		
		//fill service criteria
		//selectservIND.clearQuantity();
		//selectservIND.enterQuantity("1");
		selectservIND.selectEquipmentSize("15");
		Thread.sleep(2000);
		selectservIND.checkCustomerOwned();
		Thread.sleep(1000);
		selectservIND.selectFreequency("On-Call");
		Thread.sleep(2000);
		//selectservIND.clearHaulsperMonth();
		//selectservIND.enterHaulsperMonth("2.0");
		//selectservIND.enterTonsPerHaul("8");
		//Thread.sleep(2000);
		selectservIND.clickSaveBtn();
		Thread.sleep(3000);
		selectservIND.clickNextBtn();
		return driver;
		
	}

}
