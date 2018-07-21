package com.letzautomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement userNameTextBox;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordTextBox;
	
	@FindBy (xpath="//input[@name='confirmPassword']")
	public WebElement confirmPasswordTextBox;
	
	@FindBy (xpath="//input[@name='register']")
	public WebElement registerImageButton;
	
	public void enterUserName(String userName){
		userNameTextBox.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password){
		confirmPasswordTextBox.sendKeys(password);
	}
	
	public void clickRegisterbutton(){
		registerImageButton.click();
	}
	
}


