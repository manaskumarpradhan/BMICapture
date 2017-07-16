package com.bmi.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bmi.base.TestBase;
import com.bmi.commontest.BrowserFactory;
import com.relevantcodes.extentreports.LogStatus;

public class Test1 extends TestBase{
	//public  WebDriver driver;
	
	public String tittle="";
	
	@Test
	public void sample1() throws Exception{
		
		test=reports.startTest("sample1");
		BrowserFactory bf=new BrowserFactory();
		driver=bf.startBrowser("chrome");
		driver.get("http://www.google.com");
		test.log(LogStatus.INFO, "browser opened");
		driver.findElement(By.name("q")).sendKeys("Test1");
		Thread.sleep(2000);
		tittle=driver.getTitle();
		Assert.assertEquals(tittle, "GoogleM");
		driver.close();
		test.log(LogStatus.INFO, "sucess test1");
		
	}

}
