package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver ldriver;

	public LandingPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id='mobile-no']")
	@CacheLookup
	WebElement enterMobilefield;
	
	@FindBy(xpath="//*[@id='btn-text']")
	@CacheLookup
	WebElement Chckloaneligibiltybtn;
	
	
	
	public By nlpmobilenumberfield = By.xpath("//*[@id=\"mobile-no\"]");
	
	public By nlpaveragemonthlysalesdropdown = By.xpath("/html/body/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/select");
	
	public By nlpGstYES = By.xpath("/html/body/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/div/span[1]");
	
	public By nlpcheclloaneligibilitybutton = By.xpath("//*[@id=\"btn-text\"]");
	
	
	
	
	
	public void EnterMobilefield(String mob) {
		enterMobilefield.sendKeys(mob);

	}
	
	public void CheckLoanEligibilityButton() {
		Chckloaneligibiltybtn.click();
	}
	
	public void NLPMobileNumberField(String MNS) {
		ldriver.findElement(nlpmobilenumberfield).sendKeys(MNS);
	}
	
	public void NLPAverageMonthlySalesDropDownField() throws Exception {
		ldriver.findElement(nlpaveragemonthlysalesdropdown).click();
	}
	
	public void NLPGSTYESCheckBox() {
		ldriver.findElement(nlpGstYES).click();
	}
	
	public void NLPCheckLoanEligibilityButton() {
		ldriver.findElement(nlpcheclloaneligibilitybutton).click();
	}
	
}
