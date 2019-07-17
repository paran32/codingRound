/*======================================================
 * ********History Card***************
 * 
 * File: ClearTripSignInPage.java
 * 
 * Created By      Date 
 * ======================================================
 * Paranthaman		12/07/2019
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
 * This page class is used to perform the actions in Clear Trip SignIn Page
 */

public class ClearTripSignInPage extends BasePage{
	
	public WebDriver webDriver;
	
	//Page Objects in the Clear Trip SignIn Page 
	
		public static final By YOUR_TRIPS= By.xpath("//*[text()='Your trips']");
		
		public static final By SIGN_IN= By.xpath("//*[@id='SignIn']");
		
		public static final By SIGN_IN_FRAME= By.xpath("//*[@id='modal_window']");
		
		public static final By SIGN_IN_BUTTON= By.xpath("//*[@id='signInButton']");
		
		public static final By SIGN_IN_ERROR_MESSAGE= By.xpath("//*[contains(text(),'errors')]");
		
		public static final By HOTEL_BOOKING_OPTION= By.linkText("Hotels");
		
		
		
		
	//constructor

	public ClearTripSignInPage(WebDriver webDriver) {
		super(webDriver);
		this.webDriver=webDriver;
	
	}
	
	//Page Methods
	
	/**
	 * this method used to click the Your Trips in the Sign in page
	 * @return
	 */
	public boolean clickYourTrips() {
		boolean isClicked=false;
		try {
			isClicked=clickElement(YOUR_TRIPS);
		}catch (NoSuchElementException e) {
			//Logger.error(SIGN_IN_BUTTON +"element was not found");
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			//LOGGER.error(SIGN_IN_BUTTON +"unable to find element before timeout");
			e.printStackTrace();
		}
		return isClicked;
	}
	
	/**
	 * this method used to click the Sign in in the Sign in page
	 * @return
	 */
	public boolean clickSignIn() {
		boolean isClicked=false;
		try {
			isClicked=clickElement(SIGN_IN);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isClicked;
	}
	
	/**
	 * this method used to click the Sign in Button in the Sign in page
	 * @return
	 */
	public boolean clickSignInButton() {
		boolean isClicked=false;
		try {
			waitForElement(SIGN_IN_FRAME);
			webDriver.switchTo().frame(webDriver.findElement(SIGN_IN_FRAME));
			isClicked=clickElement(SIGN_IN_BUTTON);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isClicked;
	}
	
	
	/**
	 * this method used to check the whether error message is displayed after clicking the Sign In button
	 * @param user
	 * @return
	 */
	public boolean isSignInErrorMessageDisplayed(String errorMessage) {
		boolean isSuccess=false;
		try {
			isSuccess=ValidateText(SIGN_IN_ERROR_MESSAGE, errorMessage);	
			
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	/**
	 * this method used to select the Hotels option
	 * @return
	 */
	public boolean clickHotelsOption() {
		boolean isClicked=false;
		try {
			isClicked=clickElement(HOTEL_BOOKING_OPTION);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		return isClicked;
	}
	

}
