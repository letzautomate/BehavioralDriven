package com.letzautomate.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.letzautomate.selenium.WebDriverManager;

public class main {
	WebDriver driver;
	
	@Test
	@Parameters({"browser"})
	public void runSuite(String browser){	
		driver = new WebDriverManager().getLocalInstance(browser);
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
	}
	

}
