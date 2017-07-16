package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectServiceInfo_3_ElectonicRecycling {
	
	WebDriver driver;
	
	public SelectServiceInfo_3_ElectonicRecycling(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	@FindBy(how=How.NAME,using="electronicRecyclingCatagory_er") 
	public WebElement eRecyclingCatagoryCombo;
	
	@FindBy(how=How.ID,using="boxMailProductQty_er-0")
	public WebElement crtTvQty;
	
	@FindBy(how=How.ID,using="boxMailProductQty_er-1")
	public WebElement lcdTvQty;
	
	@FindBy(how=How.ID,using="boxMailProductQty_er-2")
	public WebElement plasmaTvQty;
	
	@FindBy(how=How.ID,using="boxMailProductQty_er-3")
	public WebElement ledTvQty;
	
	@FindBy(how=How.ID,using="boxMailProductQty_er-30")
	public WebElement gamingDTvQty;
	
	
	//Total Boxes
	@FindBy(how=How.ID,using="boxMailBoxQty_er-0")
	public WebElement totalSmallBoxes;
	
	@FindBy(how=How.ID,using="boxMailBoxQty_er-1")
	public WebElement totalMediumBoxes;
	
	@FindBy(how=How.ID,using="boxMailBoxQty_er-2")
	public WebElement totalLargeBoxes;
	
	@FindBy(how=How.ID,using="boxMailBoxQty_er-3")
	public WebElement totalHalfPalletBoxes;
	
	@FindBy(how=How.ID,using="boxMailBoxQty_er-4")
	public WebElement totalFullPalletBoxes;
	
	@FindBy(how=How.NAME, using="estimate")
	public WebElement estimateBoxQty;
	
	@FindBy(how=How.NAME, using="update")
	public WebElement saveBtn;
	
	@FindBy(how=How.NAME, using="return_-_quote")
	public WebElement previousBtn;
	
	@FindBy(how=How.NAME, using="add_to_quote")
	public WebElement nextBtn;
	
	
	

}
