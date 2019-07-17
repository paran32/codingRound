/*======================================================
 * ********History Card***************
 * 
 * File: ClearTripSearchFightsPage.java
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

import com.testvargrant.selenium.utils.BasePage;

/*
 * This page class is used to perform the actions in Clear Trip Search Fights Page
 */

public class ClearTripSearchFightsPage extends BasePage{
	
	public WebDriver webDriver;
	
	//Page Objects in the Clear Trip SignIn Page 
	
		public static final By ONE_WAY_RADIO_BUTTON= By.xpath("//*[@id='OneWay']");
		
		public static final By FROM= By.xpath("//*[@id='FromTag']");
		
		public static final By TO= By.xpath("//*[@id='ToTag']");
		
		public static final By DEPART_ON=By.xpath("//*[@id='DepartDate']"); 

		public static final By SEARCH_BUTTON= By.xpath("//*[@title='Search flights']");
		
		
	//constructor

	public ClearTripSearchFightsPage(WebDriver webDriver) {
		super(webDriver);
		this.webDriver=webDriver;
	
	}
	
	//Page Methods
	
	/**
	 * this method used to select the one way radio button
	 * @return
	 */
	public boolean selectOneWayRadioButton() {
		boolean isClicked=false;
		try {
			isClicked=clickElement(ONE_WAY_RADIO_BUTTON);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isClicked;
	}
	
	/**
	 * this method used to enter the from location
	 * @return
	 */
	public boolean enterFrom(String from) {
		boolean isEntered=false;
		try {
			enterText(FROM, from);
			By fromOption=By.xpath("//*[@id='ui-id-1']/li/a[contains(text(),'"+from+"')]");
			isEntered=clickElement(fromOption);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isEntered;
	}
	
	/**
	 * this method used to enter the To location
	 * @return
	 */
	public boolean enterTo(String to) {
		boolean isEntered=false;
		try {
			enterText(TO,to);
			By toOption=By.xpath("//*[@id='ui-id-2']/li/a[contains(text(),'"+to+"')]");
			isEntered=clickElement(toOption);
			
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isEntered;
	}
	
	/**
	 * this method used to enter the Depart Date
	 * @return
	 */
	public boolean enterDepartDate(String date) {
		boolean isEntered=false;
		try {
			isEntered=enterText(DEPART_ON, date);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isEntered;
	}
	
	/**
	 * this method used to click the search flight button
	 * @return
	 */
	public boolean clickSearchFlightsButton() {
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
