package com.upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NaukriUpload 
{
public WebDriver driver;
	
	@BeforeTest
	public void preCondition(){
		//System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
		driver=new FirefoxDriver();
		
		//driver=new ChromeDriver();
		//driver.get("https://www.naukri.com/");
		driver.get("https://login.naukri.com/nLogin/Login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@AfterTest
	public void postCondition(){
		driver.quit();
	}
	
	
	@Test
	public void testUpload() throws InterruptedException{
		
		
		driver.findElement(By.id("emailTxt")).sendKeys("mohanasundaram.dms@gmail.com");
		
		driver.findElement(By.id("pwd1")).sendKeys("M0handms");
		
		driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		String eT="Mynaukri";
		wait.until(ExpectedConditions.titleContains(eT));
		String aT=driver.getTitle();
			
		Assert.assertEquals(aT, eT);
		Reporter.log("Title is verified", true);
		WebElement viewProfile = driver.findElement(By.linkText("View Profile"));
		wait.until(ExpectedConditions.elementToBeClickable(viewProfile));
		viewProfile.click();
		
		
		String eTT="Profile|Mynaukri";
		wait.until(ExpectedConditions.titleContains(eTT));
		String aTT=driver.getTitle();
		Reporter.log("View Profile is clickable"+ aTT, true);
		WebElement link=driver.findElement(By.id("uploadLink"));
		int y=link.getLocation().getY();
		String c="window.scrollTo(0,"+y+")";
		RemoteWebDriver r=(RemoteWebDriver)driver;
		r.executeScript(c);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(link));
		link.click();
		Thread.sleep(5000);
		Reporter.log("Scroll is done and click the upload link", true);
		
		driver.findElement(By.id("attachCV")).click();
		Thread.sleep(5000);
		Utility.getFileToUpload("D:\\vid\\WorkSpace\\UploadToNakuri\\office\\cv.docx");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(5000);
		
		
	}

}
