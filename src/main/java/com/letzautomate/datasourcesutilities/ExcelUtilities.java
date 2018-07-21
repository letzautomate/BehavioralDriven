package com.letzautomate.datasourcesutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtilities {
	
	
	public void createExcelFile(String filePath)  {
		try{
			Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(filePath)));
			FileOutputStream outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);
			workbook.close();
		}catch (Exception e){
			System.out.println("There was an error while creating the Workbook, and the error is " + e.toString());
		}
		
	}
	
	public String[][] getExcelData(String filePath, String sheetName) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		
		
		Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(filePath)));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(0);
		
		int numberOfRows = sheet.getLastRowNum() + 1;
		int numberOfColumns = sheet.getRow(0).getLastCellNum();
		
		String[][] dataArray = new String[numberOfRows][numberOfColumns];
		
		for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {			
			for(int columnIndex = 0; columnIndex < numberOfColumns ; columnIndex++){
				Cell cell = sheet.getRow(rowIndex).getCell(columnIndex);
				if(cell == null) {
					dataArray[rowIndex][columnIndex] = "";
				} else {
					dataArray[rowIndex][columnIndex] = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
				}	
				
			}
		}
		
		for(String[] m: dataArray){
			System.out.println(Arrays.toString(m));
		}
		
		return dataArray;
		
		
	}
	
	/*@Test
	public void test() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException{
		getExcelData("C:/BehavioralDriven/src/test/java/com/letzautomate/testsuite/testcases1.xls", "testcases");
	}*/

}
