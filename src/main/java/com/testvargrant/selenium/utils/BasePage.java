/*======================================================
 * ********History Card***************
 * 
 * File: BasePage.java
 * 
 * Created By      Date 
 * ======================================================
 * Paranthaman		12/07/2019
 * ======================================================
 *
 */

package com.testvargrant.selenium.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This Page class will provide the reusable methods for the child page classes
 */
public class BasePage {
	
	protected WebDriver webDriver;
	public BasePage(WebDriver webDriver) {
		this.webDriver=webDriver;	
	}
	

	/**
	 * this method used to check whether the element present in the page or not
	 * @param element
	 * @return
	 */
	public boolean waitForElement(By element) {
		boolean isSuccess=false;
		try {
			WebDriverWait wait=new WebDriverWait(webDriver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			isSuccess=true;
		}catch (Exception e) {
			
			isSuccess=false;
		}
		
		return isSuccess;
		
	}
	
	/**
	 * this method used to check whether the element present in the page or not
	 * @param element
	 * @return
	 */
	public boolean isElementPresent(WebElement element) {
		boolean isPresent=false;
		try {
			WebDriverWait wait=new WebDriverWait(webDriver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			isPresent=true;
		}catch (Exception e) {
			
			isPresent=false;
			
		}
		
		return isPresent;
	}
	
	/**
	 * This method is used to Click the element
	 * @param element
	 * 
	 */
	
	public boolean clickElement(By element) {
		boolean isClicked=false;
		try {
			waitForElement(element);
			WebElement webElement= webDriver.findElement(element);
			webElement.click();
			isClicked=true;
		}catch (NoSuchElementException e) {
			isClicked=false;
		}
		
		return isClicked;
	}
	
	
	/**
	 * This method is used to enter the text in the TextField
	 * @param element
	 * @param input
	 */
	
	public boolean enterText(By element,String input) {
		boolean isEntered=false;
		try {
		
			waitForElement(element);
			WebElement webElement= webDriver.findElement(element);
			webElement.clear();
			webElement.sendKeys(input);
			isEntered=true;
		}catch (NoSuchElementException e) {
			isEntered=false;
		}
		
		return isEntered;
	}
	
	/**
	 * This method is used to select a option from a dropdown
	 * @param element
	 * @param value
	 * @return
	 */
	public boolean selectFromDropdown(By element,String value) {
		boolean isSuccess=false;
		try {
			waitForElement(element);
			WebElement webElement= webDriver.findElement(element);
			Select select= new Select(webElement);
			List<WebElement> options=select.getOptions();
			for(WebElement option: options) {
				String selectOption=option.getText();
				if(value.equals(selectOption)) {
					select.selectByVisibleText(selectOption);
				}
				
			}
			isSuccess=true;
			
		}catch (Exception e) {
			isSuccess=false;
		}
		return isSuccess;
		
	}
	
	
	/**
	 * This method is used to Validate the text is present in the element
	 * @param element
	 * @param expectedText
	 */
	
	public boolean ValidateText(By element,String expectedText) {
		boolean isSuccess=false;
		try {
		
			waitForElement(element);
			WebElement webElement= webDriver.findElement(element);
			String actualText=webElement.getText();
			System.out.println(actualText);
			if(actualText.contains(expectedText)) {
				isSuccess=true;
			}
			
			
		}catch (NoSuchElementException e) {
			isSuccess=false;
		}
		
		return isSuccess;
	}



}
