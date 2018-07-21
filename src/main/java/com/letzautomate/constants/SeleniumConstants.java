package com.letzautomate.constants;

public class SeleniumConstants {
	
	public static final String CHROMEDRIVER_KEY = "webdriver.chrome.driver";
	public static final String IEDRIVER_KEY = "webdriver.ie.driver";
	public static final String EDGEDRIVER_KEY = "webdriver.edge.driver";
	
	
	public static final String chromeDriver = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
	public static final String ieDriver = System.getProperty("user.dir") + "/src/test/resources/drivers/IEDriverServer.exe";
	public static final String edgeDriver = System.getProperty("user.dir") + "/src/test/resources/drivers/MicrosoftWebDriver.exe";
	

}
