package com.letzautomate.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.letzautomate.businesskeywords.BusinessKeywords;
import com.letzautomate.constants.FrameworkConstants;
import com.letzautomate.constants.TestcaseConstants;
import com.letzautomate.datasourcesutilities.ExcelUtilities;
import com.letzautomate.selenium.WebDriverManager;

public class main {
	WebDriver driver;
	String[][] testcasesArray;
	String keyword;
	String data;
	BusinessKeywords businessKeywords;
	Method method;
	
	@Test
	@Parameters({"browser" , "testcasesFile"})
	public void runSuite(String browser, String testcasesFile) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException{	
		try{
			testcasesArray = new ExcelUtilities().getExcelData(testcasesFile, "testcases");
		}catch(Exception e){
			System.out.println("There was an error and the error is" + e.toString());
		}
		
		int totalNumOfSteps = testcasesArray.length;
		this.driver = new WebDriverManager().getLocalInstance(browser);
		businessKeywords = new BusinessKeywords(driver);
		
		for (int step = 1 ; step < totalNumOfSteps ; step++){
			keyword = testcasesArray[step][TestcaseConstants.KEYWORD_COLUMN_ID];
			data = testcasesArray[step][TestcaseConstants.INPUTOREXP_COLUMN_ID];
			
			if((data.equals(""))){
				method = businessKeywords.getClass().getMethod(keyword);
				method.invoke(businessKeywords);
			}else{				
				method = businessKeywords.getClass().getMethod(keyword,String.class);
				method.invoke(businessKeywords, data);
			}
			testcasesArray[step][TestcaseConstants.STATUS_COLUMN_ID] = businessKeywords.status;
			testcasesArray[step][TestcaseConstants.ACTUALRESULT_COLUMN_ID] = businessKeywords.actualResult;
		}
		
		for(String[] m : testcasesArray){
			System.out.println(Arrays.toString(m));
		}
		
		new ExcelUtilities().updateExcelWith2DArrayData("C:/BehavioralDriven/src/test/resources/testcases/testcases1_Results.xls", "testcases" , testcasesArray);
		
		
	}
	
	@AfterClass
	public void cleanup(){
		
	}
	

}
