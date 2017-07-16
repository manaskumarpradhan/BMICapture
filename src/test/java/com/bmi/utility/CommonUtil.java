package com.bmi.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * Author "Manas Pradhan"
 * Created 09 Jul 2017
 * This class is for creating common utility for capturing test cases
 * and other things 
 */

public  class CommonUtil {
	

	
	public static String  takesScreenshot(WebDriver driver,String screenshotname) throws Exception {
		
		//String destin="src/test/resources/Screenshot/";
		String destin="C:\\Work\\CaptureDrive\\BMICapture\\src\\test\\resources\\Screenshot\\"+screenshotname+".png";
		
		File dest=new File(destin);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,dest);
		
		return destin;	
		
	}

}
