package com.bmi.commontest;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BrowserFactory {
	
	WebDriver driver;
	
	@Test
	public WebDriver startBrowser(String browserName) {
	
		if (browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			
		}
		
		else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-extensions");
			//option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			option.addArguments("disable-infobars");
			driver=new ChromeDriver(option);
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","C:\\Work\\Selenium\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		else {
			System.out.println("Driver not found in browser Factory");
		}
		
		
		driver.manage().window().maximize();
		
		return driver;
		
	}

}
