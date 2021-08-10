package com.pom.xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils {
	
	public static void main(String[] args)  {
		
		try {
			
		   String excel =".\\excel\\data.xlsx";
		
		   FileInputStream fileInputStream = new FileInputStream(excel);
		   XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
		   
		  // XSSFSheet sheet = workBook.getSheet("Sheet1");
		   XSSFSheet sheet = workBook.getSheetAt(0);
		   int totalNumberOfRows = sheet.getPhysicalNumberOfRows();
		   System.out.println("Total Number of Rows "+totalNumberOfRows);
		   
		   int rows = sheet.getLastRowNum();
		   int coln = sheet.getRow(1).getLastCellNum();
		   
		   Iterator itr = sheet.iterator();
		   
		   while(itr.hasNext()) {
			   XSSFRow row = (XSSFRow)itr.next();
			   Iterator cellIterator = row.cellIterator();
			   
			   while(cellIterator.hasNext()) {
				   XSSFCell  cell =(XSSFCell)cellIterator.next();
				   
				  switch(cell.getCellType()) {
	     		   case 1:System.out.print(cell.getStringCellValue()+" ");
	     		         break;
				   case 2: 
					     int number = (int)cell.getNumericCellValue();
					     System.out.println(number);
				         break;
				   }
				  
				}
		   }
		   
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}