package com.ecommerce.TestCases;


import java.io.IOException;

import org.testng.annotations.Test;

import com.ecommerce.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_Login_001 extends BaseClass {
	
	
	@Test (groups= {"sanity","master"})
	public void login() throws IOException {
		String title="Dashboard / nopCommerce administration";
		LoginPage lp=new LoginPage(driver);
		String username=rf.getUserName();
		System.out.println(username);
		lp.setEmail(username);
		lp.setPassword(rf.getPassword());
		lp.clicklogin();
		if(driver.getTitle().equals(title)) {
			logger.info("Titles Matched");
			Assert.assertTrue(true);
			lp.clicklogout();

		}
		else {
			logger.info("Titles not  Matched");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			lp.clicklogout();

		}	
		
	}

	

}
