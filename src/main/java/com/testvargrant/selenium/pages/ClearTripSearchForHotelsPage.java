/*======================================================
 * ********History Card***************
 * 
 * File: ClearTripSearchForHotelsPage.java
 * 
 * Created By      Date 
 * ======================================================
 * Paranthaman		16/07/2019
 * ======================================================
 *
 */
package com.testvargrant.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.testvargrant.selenium.utils.BasePage;

/*
 * This page class is used to perform the actions in Clear Trip Search For Hotels Page
 */

public class ClearTripSearchForHotelsPage extends BasePage{
	
	public WebDriver webDriver;
	
	//Page Objects in the Clear Trip Search For Hotels Page 
	
		public static final By WHERE= By.xpath("//*[@name='from']");
		
		public static final By TRAVELLER_SELECTION= By.xpath("//*[@id='travellersOnhome']");
		
		public static final By SEARCH_BUTTON= By.xpath("//*[@value='Search hotels']");
		
		
	//constructor

	public ClearTripSearchForHotelsPage(WebDriver webDriver) {
		super(webDriver);
		this.webDriver=webDriver;
	
	}
	
	//Page Methods
	
	/**
	 * This method used to enter the location 
	 * @return
	 */
	public boolean enterLocation(String location) {
		boolean isEntered=false;
		try {
			enterText(WHERE,location);
			By fromOption=By.xpath("//*[@id='ui-id-1']/li/a[contains(text(),'"+location+"')]");
			isEntered=clickElement(fromOption);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isEntered;
	}
	
	
	/**
	 * This method used to Select the Travellers 
	 * @return
	 */
	public boolean selectTravellers(String option) {
		boolean isSelected=false;
		try {
			isSelected=selectFromDropdown(TRAVELLER_SELECTION, option);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isSelected;
	}
	
	/**
	 * This method used to click the Search Hotels Button
	 * @return
	 */
	public boolean clickSearchHotelsButton() {
		boolean isClicked=false;
		try {
			
			isClicked=clickElement(SEARCH_BUTTON);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isClicked;
	}
	
	
	


}
