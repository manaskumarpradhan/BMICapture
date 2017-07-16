package com.bmi.commontest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import BMI.Page.FinalizeQuote;

import com.bmi.pageobjects.FinalizeQuote;

public class FinalizeQuoteCreation {

	WebDriver driver;
	
	public FinalizeQuoteCreation(WebDriver driver)
	{
		this.driver=driver;
	}
	public void finalizeQuote()throws Exception
	{
		FinalizeQuote finalQuote=PageFactory.initElements(driver, FinalizeQuote.class);
		finalQuote.clickAcceptedSignedRSICSA();
		Thread.sleep(1500);
		finalQuote.selectLeadSourceCombo("A - Business Card"); 
		Thread.sleep(700);
		finalQuote.clickFinalizeBtn();
		//print_documents
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("print_documents")));
	}
}
