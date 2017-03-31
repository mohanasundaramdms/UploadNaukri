package com.scripts;

import org.testng.annotations.Test;

import com.basePage.BaseScript;
import com.basePage.DataPro;
import com.pages.LoginPage;

public class VerifyLogin extends BaseScript
{
	@Test(dataProviderClass=DataPro.class, dataProvider="getData")
	public void testVerifyLogin(String id, String pw){
		LoginPage l=new LoginPage(driver);
		
		l.login(id, pw);
	}

}
