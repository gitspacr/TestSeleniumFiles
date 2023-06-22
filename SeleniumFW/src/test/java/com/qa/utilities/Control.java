package com.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.TestBase.TestBase;

public class Control extends TestBase {
	
	
	public void enterText(String locator, String txt, WebElement ele) {
		
		driver.findElement(By.xpath(locator)).sendKeys(txt);
		
	}
	
	public void click() {
		
		driver.navigate().forward();
		
	}
	
	public void isDisplayed() {
		
		driver.navigate().refresh();
		
	}
	
	public void isEnabled(String URL) {
		
		driver.navigate().to(URL);
		
	}

}
