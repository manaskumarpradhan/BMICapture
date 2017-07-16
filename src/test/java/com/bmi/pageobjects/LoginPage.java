package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{
	WebDriver obj;
	public LoginPage(WebDriver x)
	{
		this.obj=x;
	}
	
	@FindBy(how=How.NAME, using="username")
	@CacheLookup
	public WebElement username;
	
	@FindBy(how=How.ID, using="psword")
	public WebElement Password;
	
	@FindBy(how=How.NAME, using="log_in")
	public WebElement LoginBtn;
	
	public void Enter_UserName(String x)
	{
		username.sendKeys(x);
	}
	public void Enter_Password(String x)
	{
		Password.sendKeys(x);
	}
	public void Click_LoninBtn()
	{
		LoginBtn.click();
	}
	
	
}
