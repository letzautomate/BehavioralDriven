package com.letzautomate.businesskeywords;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.letzautomate.datasourcesutilities.ParametersMap;
import com.letzautomate.pages.HomePage;
import com.letzautomate.pages.RegisterPage;
import com.letzautomate.pages.SignOnPage;

public class BusinessKeywords{
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	SignOnPage signOnPage;
	public String status = null;
	public String actualResult = null;
	
	public  String STATUS_PASS = "PASS";
	public  String STATUS_FAIL = "FAIL";
	
	public BusinessKeywords(WebDriver driver){
		this.driver = driver;
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		signOnPage = new SignOnPage(driver);
	}
	
	public void clickRegister(){
		try{
			driver.get("http://newtours.demoaut.com/");
			homePage.clickRegisterLink();
			status = STATUS_PASS;
			actualResult = "Click Register function is worked";
			
		}catch(Exception e){
			status = STATUS_PASS;
			actualResult = "There was an error and the error is " + e.toString();
		}
	}
	//username=darshan|password=sriram|confirmpassword=sriram,,,
	public void register(String params){
		
		try{
			HashMap<String, String> paramsMap = new ParametersMap().getParamsMap(params);
			registerPage.enterUserName(paramsMap.get("username"));
			registerPage.enterPassword(paramsMap.get("password"));
			registerPage.enterConfirmPassword(paramsMap.get("confirmpassword"));
			status = STATUS_PASS;
			actualResult = "Register function is worked";
		}catch(Exception e) {
			status = STATUS_FAIL;
			actualResult = "There was an error and the error is " + e.toString();
		}
	}

}
