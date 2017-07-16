package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProvidePricing 
{
	WebDriver obj;
	
	public ProvidePricing(WebDriver obj)
	{
		this.obj=obj;
	}
	
	@FindBy(how=How.ID, using="feesToCharge_quote0")
	public WebElement frfcheckBox;
	
	@FindBy(how=How.ID, using="feesToCharge_quote1")
	public WebElement erfCheckBox;
	
	@FindBy(how=How.ID, using="feesToCharge_quote2")
	public WebElement adminFessCheckBox;
	
	@FindBy(how=How.NAME, using="recalculate_fees")
	public WebElement recalculateBtn;
	
	@FindBy(how=How.NAME, using="initialTerm_quote")
	public WebElement initialTermCombo;
	
	@FindBy(how=How.NAME, using="renewalTerm_quote")
	public WebElement renewalTermCombo;
	
	@FindBy(how=How.NAME, using="customerRateRestriction_quote")
	public WebElement rateRestrictation_CheckBox;
	
	//newly added
	@FindBy(how=How.NAME,using="year1Rate_quote")
	public WebElement YearOnePriceIncrease;
	
	@FindBy(how=How.NAME,using="year2Rate_quote")
	public WebElement YearTwoPriceIncrease;
	
	
	
	@FindBy(how=How.NAME,using="desiredQuoteTotal_quote-display")
	public WebElement desiredTotalPrice;
	
	@FindBy(how=How.NAME, using="calculate_total_price")
	public WebElement calcualateTotalPriceBtn;
	
	@FindBy(how=How.XPATH,using="//*[@id='line-item-grid']/tbody/tr[1]/td[2]/div/table/tbody/tr/td[1]/div")
	public WebElement SRBtn;
	
	@FindBy(how=How.XPATH, using="//*[@id='line-item-grid']/tbody/tr[1]/td[2]/div/table/tbody/tr/td[2]/div")
	public WebElement deleteItemBtn;
	
	@FindBy(how=How.XPATH, using="//*[@id='line-item-grid']/tbody/tr[1]/td[2]/div/table/tbody/tr/td[3]/div")
	public WebElement configureBtn;
	
	@FindBy(how=How.ID, using="readonly_3_billingType_line_1088982298")
	public WebElement billingMethod;

	@FindBy(how=How.NAME, using="select_additional_services")
	public WebElement additionalServiceBtn;
	
	@FindBy(how=How.NAME, using="calculate_price")
	public WebElement calculatePriceBtn;
	
	@FindBy(how=How.NAME, using="delete")
	public WebElement deleteBtn;
	
	@FindBy(how=How.NAME, using="assign_quote")
	public WebElement assignQuoteBtn;
	
	@FindBy(how=How.NAME, using="next")
	public WebElement nextBtn;
	
	//popup window
	
	@FindBy(how=How.XPATH,using=".//*[@id='reasons_popup']")
	public WebElement popupWindow;
	
	@FindBy(how=How.XPATH,using=".//*[@id='reasons_popup']/div[3]/table[1]/tbody/tr/td[2]")
	public WebElement submitButton;
	
	//price related elements and locators
	
	@FindBy(how=How.ID,using="3_sellPrice_line_1088982292-display")
	public WebElement sellPrice;
	
	
	public void click_calculatePriceBtn()
	{
		calculatePriceBtn.click();
	}
	
	public void click_nextBtn()
	{
		nextBtn.click();
	}
	
	public void enterYearOnePriceIncrease(String YearOneRate)
	{
		YearOnePriceIncrease.sendKeys(YearOneRate);
	}
	
	public void enterYearTwoPriceIncrease(String YearTwoRate)
	{
		YearTwoPriceIncrease.sendKeys(YearTwoRate);
	}
	
	public String getSellPrice()
	{
		String sellValue=sellPrice.getAttribute("value");
		return sellValue;
	}
	
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	
	
	
}


