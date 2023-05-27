package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoanOffer {
	WebDriver ldriver;

	public LoanOffer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public By loanofferaccept = By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-auto-offer/div/div[2]/div[6]/button");
	
	
	public void LoanOfferAcceptProceedButton() {
		ldriver.findElement(loanofferaccept).click();
	}
	
}
