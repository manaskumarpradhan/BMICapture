package com.bmi.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtility {
	
	@Test
	public static void readExcel() throws IOException, InvalidFormatException{
		
		/*
		String filePath="src/test/resources/excel/dummy.xlsx";
		File xlFile=new File(filePath);
		FileInputStream fis=new FileInputStream(xlFile);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheet("Sheet1");
		
		int xlRows=sheet1.getLastRowNum();
		int xlCols=sheet1.getRow(0).getLastCellNum();
		
		Workbook wwbb=WorkbookFactory.create(xlFile);
		
		for(int i=0;i<=xlRows;i++){
			
			XSSFRow row=sheet1.getRow(i);
			
			for(int j=0;j<xlCols;j++){
				
				XSSFCell cell=row.getCell(j);
				
				//String cellData=cell.toString();
				//System.out.print(cellData+" ");
				
				if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
					
				    System.out.print(cell.getNumericCellValue()+" ");
				    System.out.print(cell.getCellType());
				    
				}
				else if(cell.getCellType()== cell.CELL_TYPE_STRING){
					System.out.print(cell.getStringCellValue()+" ");
					System.out.println(cell.getCellType());
				}
				
				else if (cell.getCellType()==cell.CELL_TYPE_BOOLEAN){
					System.out.print(cell.getBooleanCellValue()+" ");
				}
				
				else {
					System.out.print("unknown value found in cell");
				}
			}
			
			System.out.println();
			
			
		}
		
		
		fis.close();
		*/
		String filePath="src/test/resources/excel/dummy.xlsx";
		/*
		ExcelLibrary lib=new ExcelLibrary();
		Workbook wb=lib.getWorkbook(filePath);
		lib.getCellValue(wb, "Sheet1", 0, 0);
		*/
		Workbook workbook=ExcelLibrary.getWorkbook(filePath);
		ExcelLibrary.getCellValue(workbook, "Sheet1", 0, 0);
	}

}
