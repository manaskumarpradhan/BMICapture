package com.bmi.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SelectServiceInfo_3_COM 
{
	WebDriver obj;
	
	public SelectServiceInfo_3_COM(WebDriver obj)
	{
		this.obj=obj;
	}
	
	
	@FindBy(how=How.NAME, using="wasteType")
	public WebElement wasteTypeCombo;
	
	@FindBy(how=How.NAME, using="routeType")
	public WebElement routeTypeCombo;
	
	@FindBy(how=How.NAME, using="competitor")
	public WebElement competitorCombo;
	
	@FindBy(how=How.NAME, using="accountType")
	public WebElement accountTypeCombo;
	
	@FindBy(how=How.NAME, using="isCustomerOwned")
	public WebElement customerOwnedCheckBox;
	
	@FindBy(how=How.NAME, using="compactor")
	public WebElement compactorCheckBox;
	
	@FindBy(how=How.NAME, using="customerOwnedCompactor")
	public WebElement customerOwnedCompactorCheckBox;
	
	@FindBy(how=How.NAME, using="compactorValue-display")
	public WebElement compactorCost;
	
	@FindBy(how=How.NAME, using="installationCostEstimate_s-display")
	public WebElement oneTimeInstallationCharge;
	
	@FindBy(how=How.NAME, using="quantity")
	public WebElement containerQty;
	
	@FindBy(how=How.NAME, using="quantity_sc")
	public WebElement containerQtyEdit;
	
	@FindBy(how=How.NAME, using="containerSize")
	public WebElement containerSize;
	
	@FindBy(how=How.NAME, using="liftsPerContainer_s")
	public WebElement Frequency;
	
	@FindBy(how=How.NAME, using="requestPickupDays")
	public WebElement requestPickupDays;
	
	@FindBy(how=How.ID, using="tentativePickupDays_Mon")
	public WebElement tentativePickupDays_Mon;
	
	@FindBy(how=How.ID, using="tentativePickupDays_Tue")
	public WebElement tentativePickupDays_Tue;
	
	@FindBy(how=How.ID, using="tentativePickupDays_Wed")
	WebElement tentativePickupDays_Wed;
	
	@FindBy(how=How.ID, using="tentativePickupDays_Thu")
	public WebElement tentativePickupDays_Thu;
	
	@FindBy(how=How.ID, using="tentativePickupDays_Fri")
	public WebElement tentativePickupDays_Fri;
	
	@FindBy(how=How.ID, using="tentativePickupDays_Sat")
	public WebElement tentativePickupDays_Sat;
	
	@FindBy(how=How.ID, using="tentativePickupDays_Sun")
	public WebElement tentativePickupDays_Sun;
	
	@FindBy(how=How.NAME,using="containerRefresh")
	public WebElement containerRefreshCheckBox;
	
	@FindBy(how=How.NAME, using="lock")
	public WebElement lockCombo;
	
	@FindBy(how=How.NAME, using="isEnclosure")
	public WebElement enclosureCheckBox;
	
	@FindBy(how=How.NAME, using="scoutRoute")
	public WebElement scoutRouteCheckBox;
	
	@FindBy(how=How.NAME, using="onsiteTimeInMins")
	public WebElement additionalOnSiteTime;
	
	@FindBy(how=How.NAME, using="update")
	public WebElement saveBtn;
	
	@FindBy(how=How.NAME, using="return_-_quote")
	public WebElement PreviousBtn;
	
	@FindBy(how=How.NAME, using="add_to_quote")
	public WebElement NextBtn;
	
	public void selectWasteTypeCombo(String wasteType)
	{
		Select s=new Select(wasteTypeCombo);
		s.selectByVisibleText(wasteType);
	}
	
	public void selectRouteTypeCombo(String routeType)
	{
		Select s=new Select(routeTypeCombo);
		s.selectByVisibleText(routeType);
		
	}
	
	public void selectCompetitorCombo(String competitorCode)
	{
		Select s=new Select(competitorCombo);
		s.selectByVisibleText(competitorCode);
		
	}
	
	public void SelectAccountTypeCombo(String accountType)
	{
		Select s=new Select(accountTypeCombo);
		s.selectByVisibleText(accountType);
		
	}
	
	public void clickCustomerOwnedCheckBox()
	{
		customerOwnedCheckBox.click();
	}
	
	public void ClickcustomerOwnedCompactorCheckBox()
	{
		customerOwnedCompactorCheckBox.click();
	}
	
	public void enterCompactorCost(String cost)
	{
		compactorCost.sendKeys(cost);
	}
	
	//one time installation cost
	
	public void enterOneTimeInstallationCharge(String installcost)
	{
		oneTimeInstallationCharge.sendKeys(installcost);
	}
	
	public void clearContainerQty()
	{
		containerQty.clear();
	}
	
	public void enterContainerQty(String contQty)
	{
		containerQty.sendKeys(contQty);
		
	}
	
	public void enterEditContainerQty(String containerQty)
	{
		containerQtyEdit.sendKeys(containerQty);
	}
	
	
	public void selectContainerSize(String contsize)
	{
		Select s=new Select(containerSize);
		s.selectByVisibleText(contsize);
	}
	
	public void selectFrequency(String Frequency1)
	{
		Select s=new Select(Frequency);
		s.selectByVisibleText(Frequency1);
		
	}
	
	public void clickrequestPickupDays()
	{
		requestPickupDays.click();
	
	}
	
	public void clickTentativePickupDays_Mon()
	{
		tentativePickupDays_Mon.click();
	}
	
	public void clickTentativePickupDays_Tue()
	{
		tentativePickupDays_Tue.click();
		
	}
	
	public void clickTentativePickupDays_Wed()
	{
		tentativePickupDays_Wed.click();
	}
	
	public void clickTentativePickupDays_Thu()
	{
		tentativePickupDays_Thu.click();
	}
	
	public void clickTentativePickupDays_Fri()
	{
		tentativePickupDays_Fri.click();
	}
	
	public void clickTentativePickupDays_Sat()
	{
		tentativePickupDays_Sat.click();
	}
	
	public void clickTentativePickupDays_Sun()
	{
		tentativePickupDays_Sun.click();
	}
	
	public void clickContainerRefreshCheckBox()
	{
		containerRefreshCheckBox.click();
	}
	
	public void selectLockCombo(String lockType)
	{
		Select s=new Select(lockCombo);
		s.selectByVisibleText(lockType);
	}
	
	public void clickEnclosureCheckBox()
	{
		enclosureCheckBox.click();
	}
	
	
	public void clickScoutRouteCheckBox()
	{
		scoutRouteCheckBox.click();
	}
	
	public void enterAdditionalOnSiteTime(String x)
	{
		additionalOnSiteTime.sendKeys(x);
	}
	
	public void clickSaveBtn()
	{
		saveBtn.click();
	}
	
	public void clickPreviousBtn()
	{
		PreviousBtn.click();
	}
	
	public void clickNextBtn()
	{
		NextBtn.click();
	}
	
}
