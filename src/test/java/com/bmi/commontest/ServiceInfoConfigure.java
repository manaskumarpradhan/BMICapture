package com.bmi.commontest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import BMI.Page.SelectServiceInfo_3_COM;
//import BMI.Page.SelectServiceInfo_3_IND;
//import BMI.Page.SelectServiceInfo_Configure;

import com.bmi.pageobjects.SelectServiceInfo_3_COM;
import com.bmi.pageobjects.SelectServiceInfo_3_IND;
import com.bmi.pageobjects.SelectServiceInfo_Configure;

public class ServiceInfoConfigure {
	
	WebDriver driver;
	
	public ServiceInfoConfigure(WebDriver driver)
	{
		this.driver=driver;
	}
	
	SelectServiceInfo_Configure csi;
	
	public WebDriver clickSmallContainer()
	{
		csi=PageFactory.initElements
		        (driver, SelectServiceInfo_Configure.class);
		csi.clickSmallContainerBtn();
		
		//wait for Acount type field available
		SelectServiceInfo_3_COM csod=PageFactory.initElements
		        (driver, SelectServiceInfo_3_COM.class);
		WebElement element=csod.accountTypeCombo;
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		return driver;
		
	}
	
	public WebDriver clickLargeContainer()
	{
		csi=PageFactory.initElements
		        (driver, SelectServiceInfo_Configure.class);
		csi.clickLargeContainerBtn();
		
		//wait for Acount type field available
		SelectServiceInfo_3_IND ssi=PageFactory.initElements(driver, SelectServiceInfo_3_IND.class);
		WebElement element=ssi.accountType;
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		return driver;
		
	}

}
