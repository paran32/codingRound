/*======================================================
 * ********History Card***************
 * 
 * File: BaseTest.java
 * 
 * Created By      Date 
 * ======================================================
 * Paranthaman		12/07/2019
 * ======================================================
 *
 */
package com.testvargrant.selenium.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


/*
 * This Test class will provide the reusable methods for the other test classes
 */
public class BaseTest {
	WebDriver webDriver;
	
	/*
	 * this method is used to select a webdriver and return it
	 */
	@SuppressWarnings("deprecation")
	public WebDriver selectDriver(String driver){
		
		if(driver=="chrome") {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			webDriver= new ChromeDriver(); 
			
			
		}else if(driver=="ie") {
			DesiredCapabilities capabilities= DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			webDriver= new InternetExplorerDriver(capabilities); 
			
			
		}
		
		return webDriver;
		
		
	}
}
