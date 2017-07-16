package com.bmi.pageobjects;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SelectServiceInfo_Configure 
{
	WebDriver obj;
	
	public SelectServiceInfo_Configure(WebDriver obj)
	{
		this.obj=obj;
	}
	
	@FindBy(how=How.ID,using="containerGroupToDisplayDropdown")
	public WebElement chooseContainerGroupCombo;
	
	public void selectContainerGroup(String containergroup)
	{
		Select s=new Select(chooseContainerGroupCombo);
		s.selectByVisibleText(containergroup);
	}
	
	//first next button 
		@FindBy(how=How.XPATH, using="//a[@id='next'][@href='#']")
		public WebElement nextBtnFirst;
		
		public void clickNextBtnFirst()
		{
			nextBtnFirst.click();
			
		}
	
	@FindBy(how=How.NAME, using="small_container")
	public WebElement smallContainerBtn;
	
	@FindBy(how=How.NAME, using="large_container")
	public WebElement largeContainerBtn;
	
	@FindBy(how=How.NAME, using="additional_items")
	public WebElement additionalItemBtn;
	
	@FindBy(how=How.NAME, using="electronic_recycling")
	public WebElement ElectronicRecyclingBtn;
	
	@FindBy(how=How.NAME, using="all-in-one_office")
	public WebElement All_in_One_Btn;
	
	@FindBy(how=How.NAME,using="universal_recycling")
	public WebElement universalRecyclingBtn;
	
	@FindBy(how=How.NAME, using="delete")
	public WebElement deleteBtn;
	
	@FindBy(how=How.NAME, using="assign_quote")
	public WebElement assignQuoteBtn;
	
	@FindBy(how=How.NAME, using="previous")
	public WebElement previousBtn;
	
	public void clickSmallContainerBtn()
	{
		smallContainerBtn.click();
	}
	
	public void clickLargeContainerBtn()
	{
		largeContainerBtn.click();
	}
	
	public void clickAdditionalItemBtn()
	{
		additionalItemBtn.click();
		
	}
	
	public void clickElectronicRecyclingBtn()
	{
		ElectronicRecyclingBtn.click();
	}
	
	public void clickAll_in_One_Btn()
	{
		All_in_One_Btn.click();
	}
	
	public void clickuniversalRecyclingBtn()
	{
		universalRecyclingBtn.click();
	}
	
	public void clickdeleteBtn()
	{
		deleteBtn.click();
	}
	
	public void clickAssignQuoteBtn()
	{
		assignQuoteBtn.click();
	}
	
	public void clickpreviousBtn()
	{
		previousBtn.click();
	}	

}
