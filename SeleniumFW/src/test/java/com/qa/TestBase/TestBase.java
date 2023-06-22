package com.qa.TestBase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.resources.ReadConfigFile;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public static Logger log;
	
	ReadConfigFile read=new ReadConfigFile();
	public String baseURL=read.launchUrl();
	public String browserVal=read.browserAccess();
	
	@BeforeClass
	public void setUp() {
		
		try {
//			log=LogManager.getLogger("TestBase");
			log=(Logger) LogManager.getLogger("TestBase");
			String browser=browserVal;
			
			if (browser.equals("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				log.info("Chrome Browser launched successfully");
			}else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				log.info("firefox Browser launched successfully");
			}else if(browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				log.info("edge Browser launched successfully");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseURL);
			log.info("application launched successfully");
		} catch (Exception e) {
			log.error(e);
		}
		
		
	}
	
	@AfterClass
	public void tearDown() {
		try {
			driver.quit();
			log.info("browser closed successfully");
			
		} catch (Exception e) {
			log.error(e);
		}
		
	}
	
	public void takeScreenShot(WebDriver driver, String tname) {
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcFile =ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(srcFile, destFile);
			log.info("Screenshot taken successfully");
			
			
			
		} catch (Exception e) {
			log.error(e);
		}
	}
	

}
