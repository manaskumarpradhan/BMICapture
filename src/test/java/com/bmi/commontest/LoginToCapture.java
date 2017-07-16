package com.bmi.commontest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import BMI.Page.LoginPage;
import com.bmi.pageobjects.LoginPage;

public class LoginToCapture {
	
	/* PreCondition
	 * Browser opened and user navigated to Capture login page 
	 */
	
	public WebDriver driver;
	
	public LoginToCapture(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Test
	public WebDriver login(String username,String password)
	{
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		login.Enter_UserName(username);
		login.Enter_Password(password);
		login.Click_LoninBtn();
		return driver;
	}

}
