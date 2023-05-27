package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Loancodecreation {
	
	WebDriver ldriver;

	public Loancodecreation(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	public By choseloancode1 = By.xpath("//*[@id=\"script\"]");
	
	public By Addloancodenumber = By.xpath("//*[@id=\"add\"]");
	
	public By Subloancodenumber = By.xpath("//*[@id=\"subtract\"]");
	
	public By RunScriptButton = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/form/button");
	
	
	
	public void LoanCodeDropdown() throws Exception {
		ldriver.findElement(choseloancode1).click();
	}
	
	public void RunScriptButton() throws Exception {
		ldriver.findElement(RunScriptButton).click();
	}
	
}
