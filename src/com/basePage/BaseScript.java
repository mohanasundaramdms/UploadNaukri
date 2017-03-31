package com.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseScript 
{
	public WebDriver driver;
	@BeforeTest
	public void preTest(){
		driver=new FirefoxDriver();
		
	}
	
	@AfterTest
	public void postTest(){
		driver.close();
	}
	

}
