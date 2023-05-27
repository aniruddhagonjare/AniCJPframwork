package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferlandingPage {
	
	WebDriver ldriver;

	public OfferlandingPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public By mob = By.xpath("//*[@id=\"mat-input-0\"]");
	
	public By getstartedsubmitbuton = By.xpath("//*[@class='btn btn-primary']");
	
	
	
	
	public void EnterMobileNumberField(String movb) {
		ldriver.findElement(mob).sendKeys(movb);
	}
	
	public void GetStartedButton() {
		ldriver.findElement(getstartedsubmitbuton).click();
	}
	
}
