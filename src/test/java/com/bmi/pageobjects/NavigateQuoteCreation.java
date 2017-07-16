package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigateQuoteCreation 
{
	public WebDriver driver;
	
	public NavigateQuoteCreation(WebDriver x)
	{
		this.driver=x;
		
	}
	
	
	@FindBy(how=How.LINK_TEXT, using="Home")
	public WebElement HomeTab;
	
	@FindBy(how=How.NAME, using ="new_quote")
	public 	WebElement StartNewQuoteBtn;
	
	
	public void ClickHomeTab()
	{
		HomeTab.click();
	}
	
	public void ClickStartNewQuote()
	{
		StartNewQuoteBtn.click();
	}

}
