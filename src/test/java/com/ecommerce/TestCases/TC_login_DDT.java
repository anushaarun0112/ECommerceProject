package com.ecommerce.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.PageObjects.LoginPage;
import com.ecommerce.utilities.XLUtils;

import junit.framework.Assert;

public class TC_login_DDT extends BaseClass {
	
	@Test(dataProvider="logindata")	
	public void login(String uname,String pass) throws IOException {
		driver.get(baseurl);
		logger.info("opening url");
		driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(uname);
		logger.info("User name is set");
		
		lp.setPassword(pass);
		logger.info("password is set");
		
		lp.clicklogin();
		logger.info("login is clicked");
		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			logger.info("titles matched");
			Assert.assertTrue(true);
			lp.clicklogout();
			
		}
		else {
			captureScreen(driver,"loginTest");
			logger.info("titles not matched");
			Assert.assertTrue(false);
			lp.clicklogout();

		}
	}
	
	
@DataProvider(name="logindata")	
	public String[][] getdata() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/ecommerce/testData/LoginData.xlsx";
		int rowcount=XLUtils.getRowCount(path,"sheet1");
		int colcount=XLUtils.getCellCount(path,"sheet1",1);
		
		String[][] logindata= new String[rowcount][colcount];
		for(int r=1;r<=rowcount;r++) {
			for(int c=0;c<colcount;c++) {
				logindata[r-1][c]=XLUtils.getCellData(path,"sheet1",r,c);
				
			}
		}
		return logindata;
		
	}



}
