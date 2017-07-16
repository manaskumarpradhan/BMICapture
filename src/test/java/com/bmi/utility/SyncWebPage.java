package com.bmi.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncWebPage {
	
	public WebDriver driver;
	
	public SyncWebPage(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	public void waitforVisibilityOfElement(WebElement element){
		
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));	
		
	}

}
