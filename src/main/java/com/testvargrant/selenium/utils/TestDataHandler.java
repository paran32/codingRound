/*======================================================
 * ********History Card***************
 * 
 * File: TestDataHandler.java
 * 
 * Created By      Date 
 * ======================================================
 * Paranthaman		12/07/2019
 * ======================================================
 *
 */
package com.testvargrant.selenium.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/*
 * this class used to read the test data from the CSV file
 */
public class TestDataHandler {
	
	/*
	 *this method used to read the test data from the CSV file 
	 *it will return a map data
	 */
	
	public Map<String, String> csvReader(String file) throws IOException {
		
		Map<String, String> readData = new HashMap<String,String>();
		@SuppressWarnings("resource")
		BufferedReader bufferReader = new BufferedReader(new FileReader(file));
		String[] columnNames = null,currentRow = null;String currentLine = null;
		currentLine = bufferReader.readLine();
		if(currentLine != null) {
			
			columnNames = currentLine.split(",");
			}
		while((currentLine = bufferReader.readLine())!= null) {
			
			
			currentRow = currentLine.split(",");
			for(int i=0; i<currentRow.length ; i++) {
				readData.put(columnNames[i], currentRow[i]);
			}
			
		}
		return readData;
		
	}

}
