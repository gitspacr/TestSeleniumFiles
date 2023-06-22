package com.qa.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.pages.basicControl;
import com.qa.resources.DataDriventest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumScriptInTestNG extends TestBase{

	
	basicControl bc;
	
	
	
	@Test(dataProvider="passDataFromExcel", dataProviderClass=DataDriventest.class)
	public void formValidation(String FirstName, String LastName,
			String emailID, String password ) throws Exception {
		try {
			bc=new basicControl(driver);
			bc.fillForm(FirstName, LastName, emailID, password);
			takeScreenShot(driver, "fillform");
			log.info("registeration form is clear");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Test
	public void title() {
		try {
			bc=new basicControl(driver);
			bc.titleofThePage();
			log.info("validation of title page is success");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void validationOflinkText() {
		
		try {
			bc=new basicControl(driver);
			bc.linkTxtValidation();
			takeScreenShot(driver, "link text");
			log.info("validation on link text success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

}
