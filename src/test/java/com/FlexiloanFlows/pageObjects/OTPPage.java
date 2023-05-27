package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OTPPage {

	WebDriver ldriver;

	public OTPPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	public By Otpfield = By.xpath("//*[@id=\"mat-input-1\"]");
	
	public By verifybtn = By.xpath("//*[@id=\"otpModal\"]/div/div/div[2]/div/button");

	public By loaderxpath = By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-loader/div/div/svg/circle");

	public By nlpotpverifybtn = By.xpath("//*[@id=\"otpModal\"]/div/div/div[2]/div/button");
	
	@FindBy(xpath = "//*[@class='highlighted-text pointer pl-1 ng-star-inserted']")
	WebElement resendlink;
	

	public void OTPInputField(String otp) {
		ldriver.findElement(Otpfield).sendKeys(otp);
	}

	public void VerifyOTPButton() {
		ldriver.findElement(verifybtn).click();
	}

	public void ResnedLinkOTPpage() {
		resendlink.click();
	}
	
	public void nlpOTPVerifyButton() {
		ldriver.findElement(nlpotpverifybtn).click();
	}

}
