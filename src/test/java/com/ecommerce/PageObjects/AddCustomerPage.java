package com.ecommerce.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a") WebElement linkcustomer;
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a") WebElement linkcust;
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/a") WebElement btnAddNewCustomer;
	
	
	@FindBy (id="Email") WebElement txtemail;
	@FindBy (id="Password") WebElement txtpass;
	@FindBy (id="FirstName") WebElement txtfname;
	@FindBy (id="LastName") WebElement txtlname;
	
	@FindBy (id="Gender_Male") WebElement rdMale;
	@FindBy (id="Gender_Female") WebElement rdFemale;
	
	@FindBy (id="DateOfBirth") WebElement txtdob;
	@FindBy (id="Company") WebElement txtcompany;
	
	@FindBy (xpath="//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]") WebElement drpNewsLetter;	
	@FindBy(xpath="//li[contains(text(),'Your store name')]") WebElement liststrorename;
	@FindBy(xpath="//li[contains(text(),'Test store 2')]") WebElement liststore;
	
	@FindBy (xpath="//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]") WebElement drpcustrole;
	@FindBy(xpath="//li[contains(text(),'Administrators')]") WebElement liCustomerAdmin;
	@FindBy(xpath="//li[contains(text(),'Forum Moderators')]") WebElement liCustomerFM;
	@FindBy(xpath="//*[@id=\\\"SelectedCustomerRoleIds_listbox\\\"]/li[3]") WebElement liCustomerGuest;
	@FindBy(xpath="//*[@id=\\\"adf6f594-1dd9-452f-b5ce-a929a4a5db18\\\"]") WebElement liCustomerRegistered;
	@FindBy(xpath="//li[contains(text(),'Vendors')]") WebElement liCustomerVendros;
	

	
	@FindBy (xpath="//*[@id=\"VendorId\"]") WebElement drpVendor;
	@FindBy (xpath="//*[@id=\"AdminComment\"]") WebElement txtarea;
	@FindBy (xpath="/html/body/div[3]/div[1]/form/div[1]/div/button[1]") WebElement btnsave;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div[1]") WebElement txtsuccess;
	
	public void clickcustomers() {
		linkcustomer.click();		
	}
	

	public void clickcust() {
		linkcust.click();		
	}
	

	public void clickAddCust() {
		btnAddNewCustomer.click();		
	}
	
	public String setEmail(String email) {
		txtemail.sendKeys(email);
		return email;		
	}
	
	public String setPassword(String pass) {
		txtpass.sendKeys(pass);
		return pass;		
	}
	public String setFname(String fname) {
		txtfname.sendKeys(fname);
		return fname;		
	}
	public String setLname(String lname) {
		txtlname.sendKeys(lname);
		return lname;		
	}
	
	public String setGender(String gender) {
		if(gender=="Male") {
			rdMale.click();
		}
		else {
			rdFemale.click();
		}
		return gender;
	}
	
	public String setDOB(String dob) {
		txtdob.sendKeys(dob);
		return dob;
	}
	
	public String setCompany(String company) {
		txtcompany.sendKeys(company);
		return company;
	}
	
	public void setNewsLetter(String news) {
		drpNewsLetter.click();
		WebElement ListItem=null;
		switch(news) {
		case "Your store name":liststrorename.click();
		case "Test store 2":liststore.click();
		default:liststrorename.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ListItem);
		
		}
			
	}
	public void setCusstomerRoles(String role) {
		drpcustrole.click();
		
		WebElement listitem=null;
		switch(role) {
		case "Administrators":liCustomerAdmin.click();
		case "Guests":liCustomerGuest.click();
		case "Registered":liCustomerRegistered.click();
		case "Vendors":liCustomerVendros.click();
		case "Forum Moderators":liCustomerFM.click();
		default:liCustomerRegistered.click();
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", listitem);
	}
	
	public void setManagerofVendor(String Value) {
		Select drp=new Select(drpVendor);
		drp.selectByVisibleText(Value);		
	}
	
	public String setAdminContent(String content) {
		txtarea.sendKeys(content);
		return content;
		
	}
	public void clickSave() {
		btnsave.click();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void Successmsg() {
		System.out.println(txtsuccess.getText());
		if(txtsuccess.getText().contains("The new customer has been added successfully.")) {
		System.out.println("customer created");
	}else {
	
		System.out.println("customer not created");
	}}
	
	
}
	