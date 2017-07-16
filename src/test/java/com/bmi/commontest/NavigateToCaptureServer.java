package com.bmi.commontest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NavigateToCaptureServer {
	
	WebDriver driver;
	
	public NavigateToCaptureServer(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Test
	public WebDriver startTestServer()
	{
		driver.get("https://testrepublicservices.bigmachines.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return driver;
	}

}
