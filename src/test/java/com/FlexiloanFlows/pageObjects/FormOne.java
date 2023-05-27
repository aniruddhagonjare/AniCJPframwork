package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlexiloanFlows.testCases.BaseClass;

public class FormOne extends BaseClass{
	
	WebDriver ldriver;

	public FormOne(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public By Monthlysale = By.xpath("//*[@id=\"mat-input-2\"]");

	public By GstY = By.xpath("//*[@id=\"field2\"]/div/div/div[1]/label/span[2]");
	
	public By GstN = By.xpath("//*[@id=\"field2\"]/div/div/div[2]/label/span[2]");
	
	public By Form1Ctnbtn = By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-step1/div/dynamic-form/div/form/div[5]/div/button/span[1]");
	
	public By loancreationform1ctnbutton = By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-step1/div/dynamic-form/div/form/div[6]/div/button");
	
	
	public void MonthalySalesField(String MS) {
		ldriver.findElement(Monthlysale).sendKeys(MS);
	}
	
	public void GstYES() {
		ldriver.findElement(GstY).click();
	}
	
	public void GstNO() {
		ldriver.findElement(GstN).click();
	}
	
	public void Form1ContinueButton() {
		ldriver.findElement(Form1Ctnbtn).click();
	}
	
	public void LoanCreationForm1ContinueButton() {
		ldriver.findElement(loancreationform1ctnbutton).click();
	}
	
}
