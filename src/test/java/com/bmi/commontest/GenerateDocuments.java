package com.bmi.commontest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import BMI.Page.GenerateDoc;

import com.bmi.pageobjects.GenerateDoc;



public class GenerateDocuments {
	
	WebDriver driver;
	
	public GenerateDocuments(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Test
	public void generateDoc()
	{
		GenerateDoc genDoc=PageFactory.initElements(driver, GenerateDoc.class);
		genDoc.clickNextBtn();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("finalize")));
	}

}
