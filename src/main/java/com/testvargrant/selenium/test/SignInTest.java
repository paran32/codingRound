/*======================================================
 * ********History Card***************
 * 
 * File: SignInTest.java
 * Test: testClearTripSignIn
 * Created By      Date 
 * ======================================================
 * Paranthaman		12/07/2019
 * ======================================================
 *
 */
package com.testvargrant.selenium.test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testvargrant.selenium.pages.ClearTripSignInPage;
import com.testvargrant.selenium.utils.BaseTest;
import com.testvargrant.selenium.utils.TestDataHandler;

/*
 * This test class is used to validate the Clear trip sign in error scenario 
 */

public class SignInTest extends BaseTest {
	
	private static WebDriver webDriver;
	Map<String, String> dataHandler;
	private String signInErrorMessage;
	private String url;
	
	 /* this method is used to initialize the driver and read the data from Data File
	 */
	@BeforeClass
	public void startUp() throws IOException
	{
	
		//initializing the driver by passing the webdriver browser name as string argument(Chrome or IE)  
		webDriver= selectDriver("chrome");
		//CSVDataHandler to read data from CSV data file
		TestDataHandler data = new TestDataHandler();
		dataHandler=data.csvReader("testData\\SignInTest.csv");
		url=dataHandler.get("URL");
		signInErrorMessage=dataHandler.get("ErrorMessage");
		
		//URL to open the Clear trip Web App 
		webDriver.get(url);
		
		//to maximize the window 
		webDriver.manage().window().maximize();
		
	}
	
	/*
	 * this method is used to validate Clear trip sign in  
	 */
	@Test
	public void testClearTripSignIn(){
		
		try {
			ClearTripSignInPage signInPage= new ClearTripSignInPage(webDriver);
			assertTrue(signInPage.clickYourTrips(),"Unable to find Your Trip Option");
			assertTrue(signInPage.clickSignIn(),"Unable to find the Sign in Option");
			assertTrue(signInPage.clickSignInButton(),"Unable to find the Sign in Button");
			assertTrue(signInPage.isSignInErrorMessageDisplayed(signInErrorMessage),"Unable to find the Sign in error message Button");
		}catch(NoSuchElementException e){
			fail("Sign in is not completed successfully");
		}
		
	}
	

	/*
	 * this method used to close the driver
	 */
	@AfterClass
	public void tearDown() {
		webDriver.quit();
	}


}

