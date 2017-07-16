package com.bmi.utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebPageUtility {
	
WebDriver driver;
	
	public WebPageUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement clickButton(WebElement element) {
	
		element.click();
		return element;
		
	}
	
	public WebElement sendText(WebElement element,String text) {
	
		element.sendKeys(text);
		return element;
		
	}
	
	public WebElement selectFromCombo(WebElement element,String comboValue) {
	
		Select select=new Select(element);
		select.selectByVisibleText(comboValue);
		return element;	
		
	}
	
	public WebElement clickRadioButton(WebElement element )
	{
		element.click();
		return element;
	}
	
	public String getText(WebElement element )
	{
		String elementValue=element.getText();
		return elementValue;
	}
	
	public String getAttribute(WebElement element, String attribute)
	{
		String attributeVal=element.getAttribute(attribute);
		return attributeVal;
	}
	

}
