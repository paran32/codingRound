/*======================================================
 * ********History Card***************
 * 
 * File: ClearTripFightSearchSummaryPage.java
 * 
 * Created By      Date 
 * ======================================================
 * Paranthaman		15/07/2019
 * ======================================================
 *
 */
package com.testvargrant.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testvargrant.selenium.utils.BasePage;

/*
 * This page class is used to perform the actions in Clear Trip Fight Search Summary Page
 */

public class ClearTripFightSearchSummaryPage extends BasePage{
	
	public WebDriver webDriver;
	
	//Page Objects in the Clear Trip Fight Search Summary Page
	
	public static final By SEARCH_SUMMARY= By.xpath("//*[@class='searchSummary']");
		
		
	//constructor

	public ClearTripFightSearchSummaryPage(WebDriver webDriver) {
		super(webDriver);
		this.webDriver=webDriver;
	
	}
	
	//Page Methods
	
	/**
	 * this method used to check the search summary is displayed
	 * 
	 * @return
	 */
	public boolean isSearchSummaryDisplayed() {
		boolean isSuccess=false;
		try {
			WebElement searchSummaryElement=webDriver.findElement(SEARCH_SUMMARY);
			isSuccess=isElementPresent(searchSummaryElement);	
			
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	

}
