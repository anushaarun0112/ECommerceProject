package com.ecommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy (id="Email") WebElement txtemail;
	@FindBy (id="Password") WebElement txtpassword;
	@FindBy (xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button") WebElement btnLogin;
	@FindBy (linkText="Logout") WebElement btnLogout;
	
	
	public String setEmail(String email) {
		txtemail.clear();
		txtemail.sendKeys(email);
		return email;		
	}
	public String setPassword(String pass) {
		txtpassword.clear();
		txtpassword.sendKeys(pass);
		return pass;		
	}
	
	public void clicklogin() {
		btnLogin.click();
	}
	
	public void  clicklogout() {
		btnLogout.click();
	}
	
}
