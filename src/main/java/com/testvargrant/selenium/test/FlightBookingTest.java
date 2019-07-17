/*======================================================
 * ********History Card***************
 * 
 * File: FlightBookingTest.java
 * Test: testFlightBooking
 * Created By      Date 
 * ======================================================
 * Paranthaman		15/07/2019
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

import com.testvargrant.selenium.pages.ClearTripFightSearchSummaryPage;
import com.testvargrant.selenium.pages.ClearTripSearchFightsPage;
import com.testvargrant.selenium.utils.BaseTest;
import com.testvargrant.selenium.utils.TestDataHandler;


/*
 * This test class is used to validate the Flight booking 
 */

public class FlightBookingTest extends BaseTest {
	
	//declaration of variables used for this test
	private static WebDriver webDriver;
	Map<String, String> dataHandler;
	private String url;
	private String from;
	private String to;
	private String travelDate;
	
	
	 /* this method is used to initialize the driver and read the data from Data File
	 */
	@BeforeClass
	public void startUp() throws IOException
	{
	
		//initializing the driver by passing the webdriver browser name as string argument(Chrome or IE)  
		webDriver= selectDriver("chrome");
		//CSVDataHandler to read data from CSV data file
		TestDataHandler data = new TestDataHandler();
		dataHandler=data.csvReader("testData\\FlightBookingTest.csv");
		url=dataHandler.get("URL");
		from=dataHandler.get("From");
		to=dataHandler.get("To");
		travelDate=dataHandler.get("TravelDate");

		//URL to open the Clear trip Web App 
		webDriver.get(url);
		
		//to maximize the window 
		webDriver.manage().window().maximize();
		
	}
	
	/*
	 * this method is used to validate Fight Booking in Clear trip web site 
	 */
	@Test
	public void testFlightBooking(){
		
		
		try {
			ClearTripSearchFightsPage searchFightsPage= new ClearTripSearchFightsPage(webDriver);
			assertTrue(searchFightsPage.selectOneWayRadioButton(),"Unable to find One Way Radio Button");
			assertTrue(searchFightsPage.enterFrom(from),"Unable to find From element");
			assertTrue(searchFightsPage.enterTo(to),"Unable to find To element");
			assertTrue(searchFightsPage.enterDepartDate(travelDate),"Unable to find Depart Date element");
			assertTrue(searchFightsPage.clickSearchFlightsButton(),"Unable to find Search Flights Button");
			
		}catch(NoSuchElementException e){
			fail("Search was not completed successfully");
		}
		
		try {
			ClearTripFightSearchSummaryPage searchSummaryPage= new ClearTripFightSearchSummaryPage(webDriver);
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
