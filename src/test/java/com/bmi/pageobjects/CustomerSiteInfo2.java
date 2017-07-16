package com.bmi.pageobjects;




import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CustomerSiteInfo2 
{
	WebDriver obj;
	
	public CustomerSiteInfo2(WebDriver obj)
	{
		this.obj=obj;
	}
	
	@FindBy(how=How.NAME, using="select_customer")
	public WebElement selectCustomerBtn;
	
	//Serch window objects
	//@FindBy(how=How.XPATH, using="//table/tbody/tr[2]/td[2]//following::input[@name='_customer_id~0']")
	@FindBy(how=How.NAME, using="_customer_id~0")
	public WebElement AccountDivisionserchbox;
	
	@FindBy(how=How.XPATH, using="//a[@id='search']")
	public WebElement searchBtn;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr[2]/td[2]/a")
	public WebElement viewAllSiteLink;
	
	@FindBy(how=How.NAME, using="populate")
	public WebElement populateBtn;
	
	//**end of search window object
	
	@FindBy(how=How.NAME, using="industry_quote")
	public WebElement industryCombo;
	
	@FindBy(how=How.NAME, using="segment_quote")
	public WebElement segmentCombo;
	
	@FindBy(how=How.NAME, using="authorizedBy_quote")
	public WebElement authorizedBy;
	
	@FindBy(how=How.NAME, using="siteName_quote")
	public WebElement siteName;
	
	@FindBy(how=How.NAME, using="_siteAddress_quote_address")
	public WebElement address1;
	
	@FindBy(how=How.NAME, using="_siteAddress_quote_address_2")
	public WebElement address2;
	
	@FindBy(how=How.NAME, using="_siteAddress_quote_city")
	WebElement city;
	
	@FindBy(how=How.NAME, using="_siteAddress_quote_state_menu")
	public WebElement stateCombo;
	
	@FindBy (how=How.NAME, using="_siteAddress_quote_zip")
	public WebElement zipCode;
	
	@FindBy(how=How.NAME, using="_siteAddress_quote_phone")
	public WebElement TelephoneNo;
	
	@FindBy(how=How.NAME, using="_siteAddress_quote_first_name")
	public WebElement contactName;
	
	@FindBy(how=How.NAME, using="_siteAddress_quote_last_name")
	WebElement tittle;
	
	@FindBy(how=How.NAME, using="_siteAddress_quote_email")
	public WebElement emailID;
	
	@FindBy(how=How.NAME, using="find_on_map")
	public WebElement FindOnMapBtn;
	
	@FindBy(how=How.NAME, using="assign_quote")
	public WebElement assignQuoteBtn;
	
	@FindBy(how=How.NAME, using="previous")
	public WebElement previousBtn;
	
	@FindBy(how=How.NAME, using="next")
	public WebElement nextBtn;
	
	
	//lattitude number
	@FindBy(how=How.ID, using="readonly_1__siteAddress_quote_company_name")
	WebElement latitudeNo;
	
	
	
	//Select Industry type
	
	public void SelectIndustryCombo(String indType)
	{
		Select s=new Select(industryCombo);
		s.selectByVisibleText(indType);
	}
	
	//Enter division and account number
	
	public void enterDivisionAccount(String divisionAccount)
	{
		AccountDivisionserchbox.sendKeys(divisionAccount);
	}
	
	public void clickSerachBtn()
	{
		searchBtn.click();
	}
	
	public void clickViewAllSiteLink()
	{
		viewAllSiteLink.click();
	}
	
	public void clickPopulateBtn()
	{
		populateBtn.click();
	}
	
	//Select segment type
	
	public void selectSegmentCombo(String segmentCode)
	{
		Select s=new Select(segmentCombo);
		s.selectByVisibleText(segmentCode);
	}
	
	//Enter Authorized by
	
	public void EnterAuthorizedBy(String x)
	{
		authorizedBy.sendKeys(x);
	}
	
	// Enter Site Name
	
	public void EnterSite(String x)
	{
		siteName.sendKeys(x);
	}
	
	//Enter address1
	
	public void EnterAddress1(String x)
	{
		address1.sendKeys(x);
	}
	
	//Enter address2
	
	public void EnterAddress2(String x)
	{
		address2.sendKeys(x);
	}
	
	//Enter City
	
	public void EnterCity(String x)
	{
		city.sendKeys(x);
	}
	
	//Select State code
	
	public void SelectStateCombo(String stateCode)
	{
		Select s=new Select(stateCombo);
		s.selectByVisibleText(stateCode);
	}
	
	//Enter zipCode
	
	public void EnterZipCode(String x)
	{
		zipCode.sendKeys(x);
	}
	
	//Enter TelePhone Number
	
	public void EnterTelephoneNo(String TelNo)
	{
		TelephoneNo.sendKeys(TelNo);
	}
	
	//Enter Contact Name
	
	public void EnterContactName(String x)
	{
		contactName.sendKeys(x);
	}
	
	//Enter job tittle
	
	public void EnterTittle(String x)
	{
		tittle.sendKeys(x);
	}
	
	//Enter Email
	
	public void EnterEmailId(String x)
	{
		emailID.sendKeys(x);
	}
	
	//Click on FindOnMap button
	
	public void ClickFindOnMapBtn()
	{
		FindOnMapBtn.click();
	}
	
	// Click Assign quote button
	
	public void ClickAssignQuoteBtn()
	{
		assignQuoteBtn.click();
	}
	
	//Click Previous button
	public void ClickPreviousBtn()
	{
		previousBtn.click();
	}
	
	//Click on Next button
	
	public void ClickNextBtn()
	{
		nextBtn.click();
	}
	
	public WebElement latitudeDisplay()
	{
		return latitudeNo;
	}
	
	//below are methods for existing customer case
	
	public void clickSelectCustomerBtn()
	{
		selectCustomerBtn.click();
	}
	
}
