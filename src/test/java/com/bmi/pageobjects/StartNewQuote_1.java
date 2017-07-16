package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class StartNewQuote_1 
{
	WebDriver obj;
	
	public StartNewQuote_1(WebDriver x)
	{
		this.obj=x;
	}
	
	
	@FindBy(how=How.NAME, using="area_quote")
	public WebElement AreaCombo;
	
	@FindBy(how=How.NAME, using="division_quote")
	public	WebElement DivisionCombo;
	
	@FindBy(how=How.NAME, using="salesActivity_quote")
	public WebElement salesActivityCombo;
	
	@FindBy (how=How.NAME, using="quoteDescriptionLong_quote")
	public WebElement QuoteDesCription;
	
	@FindBy (how=How.NAME, using="next")
	public WebElement nextBtn;
	
	@FindBy (how=How.NAME, using="delete")
	public WebElement deleteBtn;
	
	public void Select_Area(String area)
	{
		Select s=new Select(AreaCombo);
		s.selectByVisibleText(area);
	}
	
	public void Select_Division(String division)
	{
		Select s=new Select(DivisionCombo);
		s.selectByVisibleText(division);
	}
	
	public void Select_salesActivity_quote(String activity)
	{
		Select s=new Select(salesActivityCombo);
		s.selectByVisibleText(activity);
		
	}
	public void Enter_QuoteDesCription(String text)
	{
		QuoteDesCription.sendKeys(text);
	}
	
	public void Click_nextBtn()
	{
		nextBtn.click();
	}
	public void Click_deleteBtn()
	{
		deleteBtn.click();
	}
	

}
