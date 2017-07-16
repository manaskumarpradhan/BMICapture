package com.bmi.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.bmi.base.TestBase;
import com.bmi.commontest.BrowserFactory;
import com.relevantcodes.extentreports.LogStatus;

public class Test2 extends TestBase{
	
	//public  WebDriver driver;
	
	@Test
	public void sample2() throws Exception{
		
		test=reports.startTest("sample2");
		BrowserFactory bf=new BrowserFactory();
		driver=bf.startBrowser("chrome");
		driver.get("http://www.google.com");
		test.log(LogStatus.INFO, "browser opened");
		driver.findElement(By.name("q")).sendKeys("Test2");
		Thread.sleep(2000);
		driver.close();
		test.log(LogStatus.INFO, "sucess test2");
	}

}
