package com.qa.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.TestBase.TestBase;

public class Reusability extends TestBase{
	
	

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
	
	public void webdriverwait(WebElement ele) {
		
		try {
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
