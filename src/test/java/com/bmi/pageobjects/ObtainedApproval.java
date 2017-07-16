package com.bmi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ObtainedApproval {
	
	public WebDriver driver;
	
	public ObtainedApproval(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	@FindBy(how=How.XPATH,using=".//*[starts-with(@id,'approve-4654387')]/img")
	public WebElement approved1;
	
	public void clickApproved1Btn(){
		
		approved1.click();
		
	}
	
	
	
	

}
