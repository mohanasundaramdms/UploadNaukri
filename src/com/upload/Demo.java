package com.upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {
	
	@Test
	public void testDemo()
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("file:///D:/test.html");
		String text = driver.findElement(By.xpath("//div[@class='deviceTypeBar Android']")).getText();
		Reporter.log(text, true);
		}
	}


