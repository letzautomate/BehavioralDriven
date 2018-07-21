package com.letzautomate.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.letzautomate.constants.SeleniumConstants;

public class WebDriverManager {
	
	public WebDriver getLocalInstance(String browser){
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("CHROME")){
			System.setProperty(SeleniumConstants.CHROMEDRIVER_KEY, SeleniumConstants.chromeDriver);		
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("IE")){
			System.setProperty(SeleniumConstants.IEDRIVER_KEY, SeleniumConstants.ieDriver);		
			driver = new InternetExplorerDriver();
		} else if(browser.equalsIgnoreCase("EDGE")) {
			System.setProperty(SeleniumConstants.EDGEDRIVER_KEY, SeleniumConstants.edgeDriver);		
			driver = new InternetExplorerDriver();
		}
		return driver;
		
	}
	
	public WebDriver getRemoteInstance() throws MalformedURLException{
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		Capabilities cap = getChromeCapabilities(capabilities);
		return new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), cap);
	}
	
	
	
	private DesiredCapabilities getChromeCapabilities(DesiredCapabilities chromeCapabilities){
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("--disable-plugins");
		chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		chromeCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		chromeCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		return chromeCapabilities;
		
	}

}
