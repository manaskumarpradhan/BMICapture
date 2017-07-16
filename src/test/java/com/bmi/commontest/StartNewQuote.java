package com.bmi.commontest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import BMI.Page.NavigateQuoteCreation;
//import BMI.Page.StartNewQuote_1;

import com.bmi.pageobjects.NavigateQuoteCreation;
import com.bmi.pageobjects.StartNewQuote_1;

public class StartNewQuote {
	
	WebDriver driver;
	
	public StartNewQuote(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Test (priority=1)
	public WebDriver clickStartNewQuoteBtn() throws Exception {
	
		NavigateQuoteCreation ncc=PageFactory.initElements
				        (driver,NavigateQuoteCreation.class);
		//ncc.ClickHomeTab();
		//Thread.sleep(2000);
		ncc.ClickStartNewQuote();
		Thread.sleep(2000);
		return driver;
	}
	
	
	@Test  (priority=1)
	public WebDriver fillAreaDivision(String Area, String Division) throws Exception
	{
		StartNewQuote_1 filldata=PageFactory.initElements(driver, StartNewQuote_1.class);
		
	filldata.Select_Area(Area);   //A07 - SOUTHEAST
	Thread.sleep(3000);
	filldata.Select_Division(Division);   //4800 - AWS - ATLANTA
	Thread.sleep(2300);
	filldata.Select_salesActivity_quote("New");
	Thread.sleep(1500);
	filldata.Enter_QuoteDesCription("new quote");
	Thread.sleep(1000);
	filldata.Click_nextBtn();
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("industry_quote")));
	return driver;
	}

}
