package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bank_Statement {

	
	WebDriver ldriver;

	public Bank_Statement(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	public By uploamanually = By.xpath("//*[@id=\"#manualUploadEnable2\"]/div");
	
//	@FindBy(xpath="")//*[@id=\"#manualUploadEnable2\"]/div
//	@CacheLookup
//	WebElement uploamanually;
	
	@FindBy(xpath="//*[@class=\"btn upload-btn-desktop ng-star-inserted\"]")
	@CacheLookup
	WebElement uplaodbtn;
	
	@FindBy(xpath="//*[@id=\"upload-pdf\"]/div[1]/div/div[2]/section/ngx-dropzone/div/div/button/span[1]/span")
	@CacheLookup
	WebElement choosedocumentbtn ;
	
	@FindBy(xpath="//*[@id=\"upload-pdf\"]/div[1]/div/div[2]/div/div/button/span[1]")
	@CacheLookup
	WebElement PopUpwindowncotbtn ;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-bank-statement/div[2]/div[3]/div[1]/button")
	@CacheLookup
	WebElement BankStatemnectnbtn ;
	
	
	
	public void UploadManually(){
		ldriver.findElement(uploamanually).click();
	}
	
	public void ChooseDocumentPopUpWindowButton() {
		choosedocumentbtn.click();
	}
	
	public void PopUpWindownContinueButton() {
		PopUpwindowncotbtn.click();
	}
	
	public void BankStatementContinueButton() {
		BankStatemnectnbtn.click();
	}
}
