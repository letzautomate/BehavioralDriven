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
	
	public BusinessKeywords(WebDriver driver){
		this.driver = driver;
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		signOnPage = new SignOnPage(driver);
	}
	
	public void clickRegister(){
		driver.get("http://newtours.demoaut.com/");
		homePage.clickRegisterLink();	
	}
	//username=darshan|password=sriram|confirmpassword=sriram,,,
	public void register(String params){
		
		HashMap<String, String> paramsMap = new ParametersMap().getParamsMap(params);
		registerPage.enterUserName(paramsMap.get("username"));
		registerPage.enterPassword(paramsMap.get("password"));
		registerPage.enterConfirmPassword(paramsMap.get("confirmpassword"));		
	}

}
