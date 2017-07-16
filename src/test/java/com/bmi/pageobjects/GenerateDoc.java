package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GenerateDoc 
{
	WebDriver obj;
	
	public  GenerateDoc(WebDriver obj)
	{
		this.obj=obj;
	}
	
	@FindBy(how=How.NAME,using="copyOfAuthorizedByForGenerateDocs_quote")
	public WebElement authorisedBy;
	
	@FindBy(how=How.NAME,using="siteName_Cust_info_quote")
	public WebElement siteName;
	
	@FindBy(how=How.NAME,using="contactTelNoGenerateDocs_quote")
	public WebElement site_telNo;
	
	@FindBy(how=How.NAME,using="contactNameGenerateDocs_quote")
	public WebElement site_contactName;
	
	@FindBy(how=How.NAME,using="contactTitleGenerateDocs_quote")
	public WebElement Site_tittle;
	
	@FindBy(how=How.NAME,using="contactEmailGenerateDocs_quote")
	public WebElement site_email;
	
	@FindBy(how=How.NAME,using="contactConfirmEmailGenerateDocs_quote")
	public WebElement site_confirmEmail;
	
	@FindBy(how=How.NAME,using="contactOfficeNumberGenerateDocs_quote")
	public WebElement site_officeNo;
	
	@FindBy(how=How.NAME,using="contactMobileNumberGenerateDocs_quote")
	public WebElement site_mobileNo;
	
	@FindBy(how=How.NAME,using="_billTo_company_name_2")
	public WebElement billTo_attn;
	
	@FindBy(how=How.NAME,using="_billTo_company_name")
	public WebElement billTo_customerName;
	
	@FindBy(how=How.NAME,using="_billTo_address")
	public WebElement billTo_address1;
	
	@FindBy(how=How.NAME,using="_billTo_address_2")
	public WebElement billTo_address2;
	
	@FindBy(how=How.NAME,using="_billTo_city")
	public WebElement billTo_city;
	
	@FindBy(how=How.NAME,using="_billTo_state_menu")
	public WebElement billTo_state;
	
	@FindBy(how=How.NAME,using="_billTo_zip")
	public WebElement billTo_zipCode;
	
	@FindBy(how=How.NAME,using="_billTo_phone")
	public WebElement billTo_telNo;
	
	@FindBy(how=How.NAME,using="_billTo_fax")
	public WebElement billTo_faxNo;
	
	@FindBy(how=How.NAME,using="_billTo_first_name")
	public WebElement billTo_contactName;
	
	@FindBy(how=How.NAME,using="_billTo_email")
	public WebElement billTo_email;
	
	@FindBy(how=How.NAME,using="billToOfficeNumber_quote")
	public WebElement billTo_officeNo;
	
	@FindBy(how=How.NAME,using="billToMobileNumber_quote")
	public WebElement billTo_mobileNo;
	
	@FindBy(how=How.NAME,using="chooseProposal_quote")
	public WebElement ProposalChkBox;
	
	@FindBy(how=How.NAME,using="chooseCSA_quote")
	public WebElement csaChkBox;
	
	@FindBy(how=How.NAME,using="print_documents")
	public WebElement printDocumentBtn;
	
	//some elements needs to add
	
	@FindBy(how=How.NAME,using="delete")
	public WebElement deleteBtn;
	
	@FindBy(how=How.NAME,using="revise")
	public WebElement reviseBtn;
	
	@FindBy(how=How.NAME,using="next")
	public WebElement nextBtn;
	
	//price related element and locator
	
	@FindBy(how=How.ID,using="readonly_3_sellPrice_line_1088982292")
	public WebElement sellPrice;
	
	public void clear_authorisedBy()
	{
		authorisedBy.clear();
	}
	
	public void enter_authorisedBy(String authorisedByName)
	{
		authorisedBy.sendKeys(authorisedByName);
	}
	
	public void clear_siteName()
	{
		siteName.clear();
	}
	
	public void enter_siteName(String sitename)
	{
		siteName.sendKeys(sitename);
	}
	
	public void clear_Site_tittle()
	{
		Site_tittle.clear();
	}
	
	public void enter_Site_tittle(String siteTittle)
	{
		Site_tittle.sendKeys(siteTittle);
	}
	
	public void clear_site_email()
	{
		site_email.clear();
	}
	
	public void enter_site_email(String siteEmail)
	{
		site_email.sendKeys(siteEmail);
	}
	
	public void clear_site_confirmEmail()
	{
		site_confirmEmail.clear();
	}
	
	public void enter_site_confirmEmail(String confirmEmail)
	{
		site_confirmEmail.sendKeys(confirmEmail);
	}
	
	public void enter_site_officeNo(String officeNo)
	{
		site_officeNo.sendKeys(officeNo);
	}
	
	public void enterSiteMobileNo(String x)
	{
		site_mobileNo.sendKeys(x);
	}
	
	public void enterBillToAttn(String x)
	{
		billTo_attn.sendKeys(x);
	}
	
	public void enterBillToCustomerName(String x)
	{
		billTo_customerName.sendKeys(x);
	}
	
	public void enterBillToAddress1(String x)
	{
		billTo_address1.sendKeys(x);
	}
	
	public void enterBillToAddress2(String x)
	{
		billTo_address2.sendKeys(x);
	}
	
	public void enterBillToCity(String x)
	{
		billTo_city.sendKeys(x);
	}
	
	public void enterBillToState(String x)
	{
		billTo_state.sendKeys(x);
	}
	
	public void enterBillToZipCode(String x)
	{
		billTo_zipCode.sendKeys(x);
	}
	
	public void enterBillToTelNo(String x)
	{
		billTo_telNo.sendKeys(x);
	}
	
	public void enterBillToFaxNo(String x)
	{
		billTo_faxNo.sendKeys(x);
	}
	
	public void enterBillToContactName(String x)
	{
		billTo_contactName.sendKeys(x);
	}
	
	public void enterBillToEmail(String x)
	{
		billTo_email.sendKeys(x);
	}
	
	public void enterBillToOfficeNo(String officePhoneNo)
	{
		billTo_officeNo.sendKeys(officePhoneNo);
	}
	
	public void enterBillToMobileNo(String MobileNo)
	{
		billTo_mobileNo.sendKeys(MobileNo);
	}
	
	public void clickDeleteBtn()
	{
		deleteBtn.click();
	}
	
	public void clickReviseBtn()
	{
		reviseBtn.click();
	}
	
	public void clickNextBtn()
	{
		nextBtn.click();
	}
	
	public String getSellPrice()
	{
		String sellValue=sellPrice.getText();
		return sellValue;
		
	}
	
}
