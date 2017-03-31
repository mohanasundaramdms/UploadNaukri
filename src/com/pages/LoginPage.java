package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(id="USER_NAME")
	private WebElement userID;
	
	@FindBy(id="Password")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@class='btn btn-primary pull-right']")
	private WebElement login;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void login(String id, String pw){
		userID.sendKeys(id);
		pwd.sendKeys(pw);
		login.click();
	}
	
	
}
