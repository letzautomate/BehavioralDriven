package com.letzautomate.testcases;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.letzautomate.businesskeywords.BusinessKeywords;
import com.letzautomate.constants.FrameworkConstants;
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
	public void runSuite(String browser, String testcasesFile) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{	
		try{
			testcasesArray = new ExcelUtilities().getExcelData(testcasesFile, "testcases");
		}catch(Exception e){
			System.out.println("There was an error and the error is" + e.toString());
		}
		
		int totalNumOfSteps = testcasesArray.length;
		this.driver = new WebDriverManager().getLocalInstance(browser);
		businessKeywords = new BusinessKeywords(driver);
		
		for (int step = 1 ; step < totalNumOfSteps ; step++){
			keyword = testcasesArray[step][1];
			data = testcasesArray[step][2];
			
			if((data.equals(""))){
				method = businessKeywords.getClass().getMethod(keyword);
				method.invoke(businessKeywords);
			}else{				
				method = businessKeywords.getClass().getMethod(keyword,String.class);
				method.invoke(businessKeywords, data);
			}
		}
		
		
	}
	

}
