package com.FlexiloanFlows.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;


public class StagingLOS {

	WebDriver ldriver;

	public StagingLOS(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	public By signinwithflexiloanemialid = By.xpath("/html/body/main/div[1]/div[1]/div/div[2]/div[1]/button/span[2]");
	
	public By emaildusername = By.xpath("//input[@type='email']");
	
	public By emailnextbtn = By.xpath("//span[text()='Next']");
	
	public By emailpass = By.xpath("//input[@type='password']");
	
	public By passnextbtn1 = By.xpath("//span[text()='Next']");
	
	
	
	public void SignInithFlexiloanEmailIdCLICK() {
		ldriver.findElement(signinwithflexiloanemialid).click();
	}
	
	public void EmaildUserName(String email) {
		ldriver.findElement(emaildusername).sendKeys(email);
	}
	
	public void EmailNextBUTTON() {
		ldriver.findElement(emailnextbtn).click();
	}
	
	public void EmaildPassword(String pass) {
		ldriver.findElement(emailpass).sendKeys(pass);
	}
	
	public void PassNextBUTTON() {
		ldriver.findElement(passnextbtn1).click();
	}
	
}
