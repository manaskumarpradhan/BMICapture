package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SelectServiceInfo_3_IND {
	WebDriver driver;
	
	public SelectServiceInfo_3_IND(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Basic Options section
	@FindBy(how=How.ID,using="containerType_l")
	public WebElement containerType;
	
	@FindBy(how=How.ID,using="billingType_l")
	public WebElement billingType;
	
	@FindBy(how=How.ID,using="rental")
	public WebElement rental;
	
	@FindBy(how=How.ID,using="wasteType")
	public WebElement wasteType;
	
	@FindBy(how=How.ID,using="unitOfMeasure")
	public WebElement UOM;
	
	@FindBy(how=How.ID,using="specialHandlingCode")
	public WebElement specialHandlingCode;
	
	@FindBy(how=How.ID,using="competitor")
	public WebElement competitor;
	
	@FindBy(how=How.ID,using="accountType")
	public WebElement accountType;
	
	@FindBy(how=How.ID,using="disposalVsProcessing")
	public WebElement disposalVsProcessing;
	
	//Service Criteria Scetion
	@FindBy(how=How.ID,using="quantity")
	public WebElement quantity;
	
	@FindBy(how=How.ID,using="equipmentSize_l")
	public WebElement equipmentSize;
	
	@FindBy(how=How.ID,using="isCustomerOwned_true")
	public WebElement CustomerOwned;
	
	@FindBy(how=How.ID,using="haulsPerPeriod")
	public WebElement freequency;
	
	@FindBy(how=How.ID,using="totalEstimatedHaulsMonth_l")
	public WebElement haulsperMonth;
	
	@FindBy(how=How.ID,using="estTonsHaul_l")
	public WebElement tonsPerHaul;
	
	//AddOn Sections
	
	@FindBy(how=How.ID,using="additionalPaperwork_l_true")
	public WebElement additionalPaperwork;
	
	@FindBy(how=How.ID,using="disposalTicketSignature_l_true")
	public WebElement disposalTicketSignature;
	
	@FindBy(how=How.ID,using="washout_l_true")
	public WebElement washoutOnEveryHaul;
	
	@FindBy(how=How.ID, using="update")
	public WebElement saveBtn;
	
	@FindBy(how=How.ID, using="return_-_quote")
	public WebElement previousBtn;
	
	@FindBy(how=How.ID,using="add_to_quote")
	public WebElement nextBtn;
	
	public void selectContainerType(String ContainerType)
	{
		Select s=new Select(containerType);
		s.selectByVisibleText(ContainerType);
	}
	
	public void selectBillingType(String BillingType)
	{
		Select s=new Select(billingType);
		s.selectByVisibleText(BillingType);
	}
	
	public void selectRental(String Rental)
	{
		Select s=new Select(rental);
		s.selectByVisibleText(Rental);
	}

	public void selectWasteType(String WasteType)
	{
		Select s=new Select(wasteType);
		s.selectByVisibleText(WasteType);
	}
	
	public void selectUOM(String Uom)
	{
		Select s=new Select(UOM);
		s.selectByVisibleText(Uom);
		
	}
	
	public void selectSpecialHandlingCode(String SpecialHandlingCode)
	{
		Select s=new Select(specialHandlingCode);
		s.selectByVisibleText(SpecialHandlingCode);
	}
	
	public void selectCompetitor(String Competitor)
	{
		Select s=new Select(competitor);
		s.selectByVisibleText(Competitor);
	}

	public void selectAccountType(String AccountType)
	{
		Select s=new Select(accountType);
		s.selectByVisibleText(AccountType);
		
	}
	
	public void selectDisposalVsProcessing(String DisposalVsProcessing)
	{
		Select s=new Select(disposalVsProcessing);
		s.selectByVisibleText(DisposalVsProcessing);
	}

	public void clearQuantity()
	{
		quantity.clear();
	}
	public void enterQuantity(String qty)
	{
		quantity.sendKeys(qty);
	}
	
	public void selectEquipmentSize(String containerSize)
	{
		Select s=new Select(equipmentSize);
		s.selectByVisibleText(containerSize);
	}

	public void checkCustomerOwned()
	{
		CustomerOwned.click();
	}
	
	public void selectFreequency(String Freequency)
	{
		Select s=new Select(freequency);
		s.selectByVisibleText(Freequency);
		
	}
	
	public void clearHaulsperMonth()
	{
		haulsperMonth.clear();
	}

	public void enterHaulsperMonth(String HaulsperMonth)
	{
		haulsperMonth.sendKeys(HaulsperMonth);
	}

	public void enterTonsPerHaul(String TonsPerHaul)
	{
		tonsPerHaul.sendKeys(TonsPerHaul);
	}

	//Add on Section
	
	public void checkAdditionalPaperwork()
	{
		additionalPaperwork.click();
	}
	
	public void checkDisposalTicketSignature()
	{
		disposalTicketSignature.click();
	}
	
	public void checkWashoutOnEveryHaul()
	{
		washoutOnEveryHaul.click();
	}
	
	public void clickSaveBtn()
	{
		saveBtn.click();
	}
	
	public void clickPreviousBtn()
	{
		previousBtn.click();
	}
	
	public void clickNextBtn()
	{
		nextBtn.click();
	}
	
}
