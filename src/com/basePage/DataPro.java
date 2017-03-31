package com.basePage;

import org.testng.annotations.DataProvider;

public class DataPro {
	
	@DataProvider
	public static String[][] getData(){
		String[][] data=new String[1][2];
		data[0][0]="teststudent01";
		data[0][1]="123";
				
		return data;
		
	}

}
