package com.ecommerce.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ecommerce.PageObjects.AddCustomerPage;
import com.ecommerce.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_Add_customer extends BaseClass {

	
	@Test (groups= {"regression","master"})
	public void AddCustomer() throws IOException {
		String title="Dashboard / nopCommerce administration";
		LoginPage lp=new LoginPage(driver);
		lp.setEmail("admin@yourstore.com");
		lp.setPassword("admin");
		lp.clicklogin();
		if(driver.getTitle().equals(title)) {
			logger.info("Titles matched");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Titles not  matched");
			captureScreen(driver,"addCustomer");

			Assert.assertTrue(false);
		}
		
		
		
		AddCustomerPage ac=new AddCustomerPage(driver);
		ac.clickcustomers();
		ac.clickcust();
		ac.clickAddCust();
		ac.setEmail(randomestring()+"@gmail.com");
		ac.setPassword("anusha123");
		ac.setFname("Anusha");
		ac.setLname("KT");
		ac.setGender("Female");
		ac.setDOB("01/08/1992");
		ac.setCompany("JMR");
//		ac.setNewsLetter("Your store name");		
		//ac.setCusstomerRoles("Vendors");		
		ac.setManagerofVendor("Vendor 1");
		ac.setAdminContent("This is admin content");
		ac.clickSave();
		System.out.println("done");
		ac.Successmsg();
		
		
		
	}
	
	
	

}
