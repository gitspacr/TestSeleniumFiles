package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.TestBase.TestBase;
import com.qa.utilities.Control;

public class basicControl extends TestBase{
	
	public WebDriver ldriver;
	
	//locate objects
	
	//3 ways
	//1st way
//	public String firstNameTxt="//input[@id='firstName']";
//	public String lastNameTxt="//input[@id='lastName']";
//	public String genderRdBtn="//input[@id='femalerb']";
//	public String languageCheckBox="//input[@id='hindichbx']";
//	public String langChkbx="//input[@id='spanishchbx']";
//	public String emailTxt="//input[@id='email']";
//	public String passwordTxt="//input[@id='password']";
//	public String clearbtn="//button[@id='clearbtn']";
	
	//2nd way
//	By firstNameTxt=By.id("firstName");
//	By lastNameTxt= By.id("lastName");
//	By genderRdBtn = By.id("femalerb");
//	By languageCheckBox = By.id("hindichbx");
//	By langChkbx = By.id("spanishchbx");
//	By emailTxt = By.xpath("//input[@id='email']");
//	By passwordTxt = By.xpath("//input[@id='password']");
//	By clearbtn = By.xpath("//button[@id='clearbtn']");
	
	//3rd way
	
	@FindBy (xpath="//input[@id='firstName']")
	WebElement firstNameTxt;
	
	@FindBy (xpath="//input[@id='lastName']")
	WebElement lastNameTxt;
	
	@FindBy (xpath="//input[@id='femalerb']")
	WebElement genderRdBtn;
	
	@FindBy (id="hindichbx")
	WebElement languageCheckBox;
	
	@FindBy (id="spanishchbx")
	WebElement langChkbx;
	
	@FindBy (id="email")
	WebElement emailTxt;
	
	@FindBy (id="password")
	WebElement passwordTxt;
	
	@FindBy (id="clearbtn")
	WebElement clearbtn;
	
	@FindBy (id="navigateHome")
	WebElement linkTxt;
	
	Control control=new Control();
	
	public basicControl(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	public void fillForm(String firstname, String lastName, String emailID, String password) {
		
		
		try {
			firstNameTxt.sendKeys(firstname);
			control.enterText("Enter text value", firstname,firstNameTxt);
			lastNameTxt.sendKeys(lastName);
			genderRdBtn.click();
			languageCheckBox.click();
			langChkbx.click();
			emailTxt.sendKeys(emailID);
			passwordTxt.sendKeys(password);
			takeScreenShot(driver, "fillform");
			clearbtn.click();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void titleofThePage() {
		
		try {
			
			String title =ldriver.getTitle();
			System.out.println("title of the page"+title);
			String expectedTitle="Basic Controls - H Y R Tutorials";
			Assert.assertEquals(title, expectedTitle);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void linkTxtValidation() {
		
		try {
			
			linkTxt.click();
			String getUrl=ldriver.getCurrentUrl();
			
			System.out.println(getUrl);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void name() throws Exception {
		
		Actions act=new Actions(driver);
		act.moveToElement(linkTxt).click().build().perform();
		
				
		
	}
	

}
