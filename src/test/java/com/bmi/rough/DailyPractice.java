package com.bmi.rough;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bmi.commontest.BrowserFactory;
import com.relevantcodes.extentreports.LogStatus;

public class DailyPractice extends TestBase{
	/*

	public static void main(String[] args) throws Exception {
		String filePath="src/test/resources/excel/dummy.xlsx";
		//String filePath="C:\\Users\\pradhma\\Desktop\\Book1.xlsx";
		ExcelLibrary lib=new ExcelLibrary();
		XSSFCell cell=lib.getXlData(filePath);
		Workbook wb=lib.getWorkbook(filePath);
		XSSFSheet sheet1=(XSSFSheet) wb.getSheet("Sheet1");
		String ss=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println(ss);
		
		*/
	WebDriver driver;
	
	@Test
	public void demoMethod(){
		
		test=reports.startTest("demoMethod");
		
		
		BrowserFactory bf=new BrowserFactory();
		driver=bf.startBrowser("chrome");
		driver.get("http://www.google.com");
		test.log(LogStatus.INFO, "browser opened");
		String tittle=driver.getTitle();
		Assert.assertEquals(tittle, "Google","page tittles are not matching");
		test.log(LogStatus.INFO, "Tittle verified");
		driver.close();
		

	}

}
