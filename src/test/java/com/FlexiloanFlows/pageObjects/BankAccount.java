package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BankAccount {

	
	WebDriver ldriver;

	public BankAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public By Bankaccountno = By.xpath("//*[@id=\"mat-input-17\"]");
	
	public By confirmbankaccountno = By.xpath("//*[@id=\"mat-input-18\"]");
	
	public By IFSC = By.xpath("//*[@id=\"mat-input-19\"]");
	
	public By AccountType = By.xpath("//*[@id=\"mat-select-2\"]");
	
	public By Beneficiary = By.xpath("//*[@id=\"mat-input-20\"]");
	
	
	
	public void BankAccountNumberField(String Acc) {
		ldriver.findElement(Bankaccountno).sendKeys(Acc);
	}

	public void ConfirmBankAccountNumberField(String Acc) {
		ldriver.findElement(confirmbankaccountno).sendKeys(Acc);
	}
	
	public void IFSCField(String Acc) {
		ldriver.findElement(IFSC).sendKeys(Acc);
	}
	
	public void AccountTypeDropDown() {
		ldriver.findElement(AccountType).click();
	}
	
	public void BeneficiaryNameField(String bene) {
		ldriver.findElement(Beneficiary).sendKeys(bene);
	}
}
