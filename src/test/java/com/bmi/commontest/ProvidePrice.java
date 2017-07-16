package com.bmi.commontest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import BMI.Page.GenerateDoc;
//import BMI.Page.ProvidePricing;
import com.bmi.pageobjects.GenerateDoc;
import com.bmi.pageobjects.ProvidePricing;





public class ProvidePrice {
	
	
	public WebDriver driver;
	
	public ProvidePrice(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@Test 
	public void configurePrice()throws Exception {
	
		ProvidePricing pp=PageFactory.initElements(driver,ProvidePricing.class);
		pp.click_calculatePriceBtn();
		Thread.sleep(5000);
		pp.click_nextBtn();
		
		GenerateDoc genDoc=PageFactory.initElements(driver,GenerateDoc.class);
		WebElement element=genDoc.sellPrice;
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
