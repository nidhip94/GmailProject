package com.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
       
	  public static XSSFSheet ExcelWSheet;
	  public static XSSFWorkbook ExcelWBook;
      public static XSSFCell Cell;
      public static XSSFRow Row;
      public static XSSFRow rowForColumn;
      public String FinalDataOfcoulum = "";
  	  public double FinalIntDataOfcoulum ;
  	

 //This method is to set the File path and to open the Excel file,
 //Pass Excel Path and Sheetname as Arguments to this method

 public static void setExcelFile(String Path,String SheetName) throws Exception {

   try {
         // Open the Excel file
       FileInputStream ExcelFile = new FileInputStream(Path);
       // Access the required test data sheet
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        System.out.println("setup done");
          } catch (Exception e){
                 throw (e);
                                }
                                  }

	
 /*   
	 * getCellData(String sheetName, int rowNum, int colNum) method specification :-
	 *  Return Data inside a particular cell
	 *  sheetName -> name of the excel sheet. 
	 *  rowNum -> Refer to the Row Number in xls file
	 *  colNum -> Refer to the Col Number in xls file
	 */

	public String getCellData(String sheetName, int rowNum, int colNum)
	{
		ExcelWSheet  = ExcelWBook.getSheet(sheetName);
		Row = ExcelWSheet.getRow(rowNum);
		return Row.getCell(colNum).getStringCellValue();
	}	

	
	public String getCellDataByColumnName( String sheetName, int rowNum, String colName)
	{
		ExcelWSheet  = ExcelWBook.getSheet(sheetName);
		Row = ExcelWSheet.getRow(rowNum);
		
		rowForColumn = ExcelWSheet.getRow(0);
		
		int coulmcount = rowForColumn.getLastCellNum();
		//System.out.println(coulmcount);
		bb:
		for(int colmnNo=0; colmnNo<coulmcount;colmnNo++){
			String data = rowForColumn.getCell(colmnNo).getStringCellValue();
			if(data.equals(colName)){
				 FinalDataOfcoulum = Row.getCell(colmnNo).getStringCellValue();
				 break bb;
			}
		}
		
		return  FinalDataOfcoulum ;
	}	

 
 


}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

