package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormFour {
	

	WebDriver ldriver;

	public FormFour(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public By businesspincodee = By.xpath("//*[@id=\"mat-input-10\"]");
	
	public By residencerented = By.xpath("//*[@id=\"field2\"]/div/div/div[2]/label/span[2]");
	
	public By businessrented = By.xpath("//*[@id=\"field3\"]/div/div/div[2]/label/span[2]");
	
	
	
	
	// NLP greater than 2 lac 
	
	public By flownlPAN =  By.xpath("//*[@id=\"mat-input-5\"]");
	
	public By flownlpusinesspincode =  By.xpath("//*[@id=\"mat-input-6\"]");
	
	public By flownlpresidencerented =  By.xpath("//*[@id=\"field3\"]/div/div/div[2]/label/span[2]");
	
	public By flownlpbusinessrented =  By.xpath("//*[@id=\"field4\"]/div/div/div[2]/label/span[2]");
	
	public By flownlpHowoldisyourbusiness =  By.xpath("//*[@id=\"field5\"]/div/div/div[4]/label/span[2]");
	
	
	// NLP Less than 2 lac 
	
	
	public By nlplessthanbusinesspincode=  By.xpath("//*[@id=\"mat-input-8\"]");
	
	public By nlplessthanresidencerentedno =  By.xpath("//*[@id=\"field2\"]/div/div/div[2]/label");
	
	public By nlplessthanbusinessrentedno =  By.xpath("//*[@id=\"field3\"]/div/div/div[2]/label");
	
	public By nlplesssthanhowoldisurbusinessmorethan5yr = By.xpath("//*[@id=\"field5\"]/div/div/div[4]/label");
	
	
	@FindBy(xpath="//*[@id=\"mat-input-9\"]")
	@CacheLookup
	WebElement businesspin;
	
	@FindBy(xpath="//*[@id=\"field2\"]/div/div/div[2]/label/span[2]")
	@CacheLookup
	WebElement residencrentedno ;
	
	@FindBy(xpath="//*[@id=\"field3\"]/div/div/div[2]/label/span[2]")
	@CacheLookup
	WebElement businessrentedno;
	
	
	@FindBy(xpath="//*[@id=\"field5\"]/div/div/div[4]/label/span[2]")
	@CacheLookup
	WebElement owoldurbusineessmorethan5year;
	
					
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-step4/div[2]/dynamic-form/div/form/div[5]/div/button/span[1]")
	@CacheLookup
	WebElement form4ctnbtn;
	
	
	
	
	
	
	@FindBy(xpath="//*[@id=\"mat-input-5\"]")
	@CacheLookup
	WebElement flowaapan;
	
	@FindBy(xpath="//*[@id=\"mat-input-6\"]")
	@CacheLookup
	WebElement flowaabusinesspincode;
	
	@FindBy(xpath="//*[@id=\"field3\"]/div/div/div[2]/label")
	@CacheLookup
	WebElement flowaaresidencrentedno;
	
	@FindBy(xpath="//*[@id=\"field4\"]/div/div/div[2]/label")
	@CacheLookup
	WebElement flowaabusinessrentedno;
	
	@FindBy(xpath="//*[@id=\"field5\"]/div/div/div[4]/label")
	@CacheLookup
	WebElement flowaahowoldurbusinessmorethan5year;
	
	
	
	
	
	
	
	public void WhatIsYourBusinessPinCodeField(String MS) {
		ldriver.findElement(businesspincodee).sendKeys(MS);
	}
	
	public void ResidenceRentedCheckBOXNO() {
		ldriver.findElement(residencerented).click();
	}
	
	public void BusinessRentedCheckBOXNO() {
		ldriver.findElement(businessrented).click();
	}
	
	
	
	
	public void BusinessPincode(String pincod) {
		businesspin.sendKeys(pincod);
	}
	
	public void ResidenceRentedNO() {
		residencrentedno.click();
	}
	
	public void BusinessRentedNO() {
		businessrentedno.click();
	}
	
	public void Form4ContinueButton() {
		form4ctnbtn.click();
	}
	
	public void HowOldYourBusineessMoreThan5Year() throws Exception {
		owoldurbusineessmorethan5year.click();
	}
	
	
	
	
	
	
	public void FlowAAPanField(String pan) {
		flowaapan.sendKeys(pan);
	}
	
	public void FlowAABusinessPinCodeField(String busspin) {
		flowaabusinesspincode.sendKeys(busspin);
	}
	
	public void FlowAAResidencRentedNO() {
		flowaaresidencrentedno.click();
	}
	
	public void FlowAABusinessRentedNO() {
		flowaabusinessrentedno.click();
	}
	
	public void FlowAAHowYourldurBusinessMoreThan5Year() {
		flowaahowoldurbusinessmorethan5year.click();
	}
	
	
	
	
	// nlp greater than 2 lac
	
	
	public void FlowNLPPanField(String pan) {
		ldriver.findElement(flownlPAN).sendKeys(pan);
	}
	
	public void FlowNLPBusinessPinCodeField(String busspin) {
		ldriver.findElement(flownlpusinesspincode).sendKeys(busspin);
	}
	
	public void FlowNLPResidencRentedNO() {
		ldriver.findElement(flownlpresidencerented).click();
	}
	
	public void FlowNLPBusinessRentedNO() {
		ldriver.findElement(flownlpbusinessrented).click();
	}
	
	public void FlowNLPHowYourldurBusinessMoreThan5Year() {
		ldriver.findElement(flownlpHowoldisyourbusiness).click();
	}
	
	
	
	// nlp less than 2 lac
	
	
	public void NLPlessthanBusinessPINCODE(String pin) {
		ldriver.findElement(nlplessthanbusinesspincode).sendKeys(pin);
	}
	
	public void NLPlessthanResidenceRENTEDNO() {
		ldriver.findElement(nlplessthanresidencerentedno).click();
	}
	
	public void NLPlessthanBusinessRENTEDNO() {
		ldriver.findElement(nlplessthanbusinessrentedno).click();
	}
	
	
	public void NLPlessthanHowOldYourusinessMORETHAN5YEAR() {
		ldriver.findElement(nlplesssthanhowoldisurbusinessmorethan5yr).click();
	}
	
}
