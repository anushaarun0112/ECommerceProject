package com.ecommerce.TestCases;
//this is base class

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecommerce.utilities.ReadConfig;

public class BaseClass {
public static WebDriver driver;
ReadConfig rf=new ReadConfig();
public String baseurl=rf.getApplicationURl();
public String username=rf.getUserName();
public String password=rf.getPassword();
public String chromepath=rf.getChromePath();
public String iepath=rf.getIePath();
public String firefoxpath=rf.getFireFoxPath();
public static Logger logger;
	
	@BeforeClass (groups= {"sanity","master","regression"})
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		 logger=Logger.getLogger("EcommerceProject");
		 PropertyConfigurator.configure("log4j.properties");
		 
		 if(browser.equalsIgnoreCase("chrome")) {		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+chromepath);
		logger.info("opening chrome");
		driver=new ChromeDriver();
		 }
		 else if(browser.equalsIgnoreCase("ie")) {
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+iepath);
			 logger.info("opening ie");
			driver = new EdgeDriver();
		 }
		 else if(browser.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+firefoxpath);
			 logger.info("opening firefox");
				driver = new FirefoxDriver();
		 }
		 else{
				//If no browser is passed throw exception
				throw new Exception("Incorrect Browser");
				}
		driver.get(baseurl);
		logger.info("opening url");
		System.out.println("entered URl");
	}
	
	
	@AfterClass
	public void teardown() {
		logger.info("closing");
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
