package com.letzautomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOnPage {
	
	WebDriver driver;
	
	public SignOnPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='userName']")
	public WebElement userNameTextBox;
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordTextBox;
	
	@FindBy (xpath="//input[@name='login']")
	public WebElement loginImageButton;
	
	public void enterUserName(String userName){
		userNameTextBox.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		passwordTextBox.sendKeys(password);
	}
	
	public void clickLoginImageButton(){
		loginImageButton.click();
	}

}
