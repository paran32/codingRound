/*======================================================
 * ********History Card***************
 * 
 * File: HotelBookingTest.java
 * Test: testHotelBooking
 * Created By      Date 
 * ======================================================
 * Paranthaman		16/07/2019
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

import com.testvargrant.selenium.pages.ClearTripHotelSearchSummaryPage;
import com.testvargrant.selenium.pages.ClearTripSearchForHotelsPage;
import com.testvargrant.selenium.pages.ClearTripSignInPage;
import com.testvargrant.selenium.utils.BaseTest;
import com.testvargrant.selenium.utils.TestDataHandler;

/*
 * This test class is used to validate the Hotel booking 
 */

public class HotelBookingTest extends BaseTest {
	

	private static WebDriver webDriver;
	Map<String, String> dataHandler;
	private String url;
	private String location;
	private String travellersOption;
	
	 /* this method is used to initialize the driver and read the data from Data File
	 */
	@BeforeClass
	public void startUp() throws IOException
	{
	
		//initializing the driver by passing the webdriver browser name as string argument(Chrome or IE)  
		webDriver= selectDriver("chrome");
		//CSVDataHandler to read data from CSV data file
		TestDataHandler data = new TestDataHandler();
		dataHandler=data.csvReader("testData\\HotelBookingTest.csv");
		url=dataHandler.get("URL");
		location=dataHandler.get("Location");
		travellersOption=dataHandler.get("Travellers");
		
		//URL to open the Clear trip Web App 
		webDriver.get(url);
		
		//to maximize the window 
		webDriver.manage().window().maximize();
		
	}
	
	/*
	 * this method is used to validate Hotel Booking in Clear trip web site 
	 */
	@Test
	public void testHotelBooking(){
		
		try {
			ClearTripSignInPage signInPage= new ClearTripSignInPage(webDriver);
			assertTrue(signInPage.clickHotelsOption(),"Unable to find hotels option element");
		}catch(NoSuchElementException e){
			fail("Sign in is not completed successfully");
		}
		
		try {
			ClearTripSearchForHotelsPage searchForHotelsPage= new ClearTripSearchForHotelsPage(webDriver);
			assertTrue(searchForHotelsPage.enterLocation(location),"Unable to find location element");
			assertTrue(searchForHotelsPage.selectTravellers(travellersOption),"Unable to find travellers drop down");
			assertTrue(searchForHotelsPage.clickSearchHotelsButton(),"Unable to find search hotels button");
			
		}catch(NoSuchElementException e){
			fail("Sign in is not completed successfully");
		}
		
		try {
			ClearTripHotelSearchSummaryPage searchSummaryPage= new ClearTripHotelSearchSummaryPage(webDriver);
			assertTrue(searchSummaryPage.isSearchSummaryDisplayed(),"Unable to find Search Summary element");
			
		}catch(NoSuchElementException e){
			fail("Search summary not displayed successfully");
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
