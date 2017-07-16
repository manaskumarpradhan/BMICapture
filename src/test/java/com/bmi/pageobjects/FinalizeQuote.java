package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FinalizeQuote 
{
	WebDriver obj;
	public FinalizeQuote(WebDriver obj)
	{
		this.obj=obj;
	}
	
	@FindBy(how=How.ID,using="contractStatus_quote0")
	public WebElement acceptedSignedRSICSA;
	
	@FindBy(how=How.ID,using="contractStatus_quote1" )
	public WebElement acceptedSignedThirdPartyAgreement;
	
	@FindBy(how=How.ID, using="contractStatus_quote3")
	public WebElement rejectedCSA;
	
	@FindBy(how=How.NAME, using="reasonForRejection_quote")
	public WebElement reasonForRejectionCombo;
	
	@FindBy(how=How.NAME,using="comments_quote")
	public WebElement comments;
	
	@FindBy(how=How.NAME,using="leadSourceCode_quote")
	public WebElement leadSourceCombo;
	
	@FindBy(how=How.NAME,using="customerCategoryMenu_quote")
	public WebElement customerCategoryCombo;
	
	@FindBy(how=How.NAME,using="pONumber_quote")
	WebElement poNumber;
	
	@FindBy(how=How.NAME,using="salesTerritory_quote")
	public WebElement salesTeritory;
	
	@FindBy(how=How.NAME,using="creditAnalyst_quote")
	public WebElement creditAnalyst;
	
	@FindBy(how=How.NAME, using="taxCodeText_quote")
	public WebElement taxCode;
	
	@FindBy(how=How.NAME, using="acquisitionCode_quote")
	public WebElement acquisitionCode;
	
	@FindBy(how=How.NAME, using="salesReporting_quote")
	public WebElement salesReporting;
	
	@FindBy(how=How.NAME, using="delete")
	public WebElement deleteBtn;
	
	@FindBy(how=How.NAME, using="previous")
	public WebElement previousBtn;
	
	@FindBy(how=How.NAME, using="finalize")
	public WebElement finalizeBtn;
	
	@FindBy(how=How.NAME, using="next")
	public WebElement nextBtn;
	
	@FindBy(how=How.NAME, using="send_order")
	public WebElement sendOrderBtn;
	
	public void clickAcceptedSignedRSICSA()
	{
		acceptedSignedRSICSA.click();
	}
	
	public void clickAcceptedSignedThirdPartyAgreement()
	{
		acceptedSignedThirdPartyAgreement.click();
	}
	
	public void clickRejectedCSA()
	{
		rejectedCSA.click();
	}
	
	public void selectReasonForRejectionCombo(String ReasonForRejection)
	{
		Select s=new Select(reasonForRejectionCombo);
		s.selectByVisibleText(ReasonForRejection);
	}
	
	public void enterComments(String commentsText)
	{
		comments.sendKeys(commentsText);
	}
	
	public void selectLeadSourceCombo(String leadSource)
	{
		Select s=new Select(leadSourceCombo);
		s.selectByVisibleText(leadSource);
	}
	
	public void selectCustomerCategoryCombo(String customerCatagory)
	{
		Select s=new Select(customerCategoryCombo);
		s.selectByVisibleText(customerCatagory);
	}
	
	public void enterPoNumber(String poNumberText)
	{
		poNumber.sendKeys(poNumberText);
	}
	
	public void enterSalesTeritory(String Teritory)
	{
		salesTeritory.sendKeys(Teritory);
	}
	
	public void enterCreditAnalyst(String CreditAnalyst)
	{
		creditAnalyst.sendKeys(CreditAnalyst);
	}
	
	public void enterTaxCode(String taxcode)
	{
		taxCode.sendKeys(taxcode);
	}
	
	public void enterAcquisitionCode(String AcquisationCode)
	{
		acquisitionCode.sendKeys(AcquisationCode);
	}
	
	public void selectSalesReporting(String SalesReporting)
	{
		Select s=new Select(salesReporting);
		s.selectByVisibleText(SalesReporting);
	}
	
	public void clickDeleteBtn()
	{
		deleteBtn.click();
	}
	
	public void clickPreviousBtn()
	{
		previousBtn.click();
	}
	
	public void clickFinalizeBtn()
	{
		finalizeBtn.click();
	}
}	
