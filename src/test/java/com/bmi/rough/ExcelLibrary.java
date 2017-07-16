package com.bmi.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLibrary {
	/*
	Workbook workbook;
	
	public ExcelLibrary(Workbook workbook){
		
		this.workbook=workbook;
	}
	*/
	
	
	public XSSFCell getXlData(String filePath) throws Exception
	{
		XSSFCell cell=null;
		File xlData=new File(filePath);
		FileInputStream fis=new FileInputStream(xlData);
		XSSFWorkbook xlWorkBook=new XSSFWorkbook(fis);
		//XSSFSheet sheet1=xlWorkBook.getSheetAt(0);
		XSSFSheet sheet1=xlWorkBook.getSheet("Sheet1");
		int xlRows=sheet1.getLastRowNum();
		int xlCols=sheet1.getRow(0).getLastCellNum();
		System.out.println(xlRows+" "+xlCols);
		
		
		
		for(int i=0;i<=xlRows;i++)
		{
			XSSFRow row=sheet1.getRow(i);
			for (int j=0;j<xlCols;j++)
			{
				try{
				cell=row.getCell(j);
				String value=cell.toString();
				System.out.println(value);
				}catch(Exception e){}
				
			}
			
			System.out.println();
			
		}
		
		
		FileOutputStream fos=new FileOutputStream(xlData);
		xlWorkBook.write(fos);
		return cell;
	
	}
	
	public static Workbook getWorkbook(String filePath) throws InvalidFormatException, IOException{
		
		File file=new File(filePath);
		
		Workbook workbook=WorkbookFactory.create(file);
		
		return workbook;
	}
	
	public static XSSFCell getCellValue(Workbook workbook,String sheetName,int startRowNum, int startColNum){
		
		XSSFCell cell=null;
		
		XSSFSheet sheet=(XSSFSheet) workbook.getSheet(sheetName);
		
		int xlRows=sheet.getLastRowNum();
		int xlCols=sheet.getRow(startRowNum).getLastCellNum();
		
		for (int i=startRowNum;i<=xlRows;i++){
			
			XSSFRow row=sheet.getRow(i);
			for(int j=startColNum;j<xlCols;j++){
				
				try{
				cell=row.getCell(j);
				if(cell.getCellType()==cell.CELL_TYPE_STRING){
					
					String stringCellValue=cell.getStringCellValue();
					System.out.print(stringCellValue+" ");
					
				}
				
				else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
					double numericCellValue=cell.getNumericCellValue();
					System.out.print(numericCellValue+" ");
				}
				
				else if (cell.getCellType()==cell.CELL_TYPE_BOOLEAN){
					Boolean booleanCellValue=cell.getBooleanCellValue();
					System.out.print(booleanCellValue+" ");
					
				}
				else{
					
					System.out.print("cell data type not found by class ExcelLibrary");
				}
				
				}catch(Exception e){}
			}
			
			System.out.println();
		}
		
		return cell;
		
	}

}
