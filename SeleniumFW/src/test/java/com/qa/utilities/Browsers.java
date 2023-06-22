package com.qa.utilities;

import com.qa.TestBase.TestBase;

public class Browsers extends TestBase {
	
	
	public void back() {
		
		driver.navigate().back();
		
	}
	
	public void forward() {
		
		driver.navigate().forward();
		
	}
	
	public void refresh() {
		
		driver.navigate().refresh();
		
	}
	
	public void navigateTo(String URL) {
		
		driver.navigate().to(URL);
		
	}

}
