package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormFive {

	WebDriver ldriver;

	public FormFive(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id=\"field1\"]/div/div/div[1]/label/span[2]")
	@CacheLookup	 	
	WebElement natureofbusinessretailer;

	@FindBy(xpath = "//*[@id=\"field1\"]/div/div/div[2]/label/span[2]")
	@CacheLookup
	WebElement natureofbusinessreWholsesaller;

	@FindBy(xpath = "//*[@id=\"field1\"]/div/div/div[3]/label/span[2]")
	@CacheLookup
	WebElement natureofbusinessmanufacturer;

	@FindBy(xpath = "//*[@id=\"field1\"]/div/div/div[4]/label/span[2]")
	@CacheLookup
	WebElement natureofbusinessServicer;

	@FindBy(xpath = "//*[@id=\"field1\"]/div/div/div[5]/label/span[2]")
	@CacheLookup
	WebElement natureofbusinesswholse_retailer;

	
	
	@FindBy(xpath = "//*[@id=\"mat-select-0\"]")
	@CacheLookup
	WebElement Productyouselldropdwonfield;
	
	@FindBy(xpath="//*[@id=\"mat-dialog-0\"]/app-product-dialog/app-products/div/div[2]/div/input")
	@CacheLookup
	WebElement PopUpwindowsearchsield;
	
	@FindBy(xpath="//*[@id=\"mat-dialog-0\"]/app-product-dialog/app-products/div/div[3]/div/div")
	@CacheLookup
	WebElement Popupwindowdsasearchenter;
	
	
	@FindBy(xpath="//*[@class='mat-focus-indicator button-style button-rounded mat-flat-button mat-button-base mat-primary']")
	@CacheLookup
	WebElement PopupwindowproductSubmitbtn;
	
	
	
	
	@FindBy(xpath = "//*[@id=\"mat-input-2\"]")
	@CacheLookup
	WebElement whatisurbusinessname;

	@FindBy(xpath = "//*[@id=\"mat-input-4\"]")
	@CacheLookup
	WebElement BusinessaddressstreetShop;

	@FindBy(xpath = "//*[@id=\"mat-input-5\"]")
	@CacheLookup
	WebElement BusinessAddressarealocalityvillege;

	@FindBy(xpath = "//*[@id=\"mat-input-7\"]")
	@CacheLookup
	WebElement residentialaddressStreetNameshopnumber;

	@FindBy(xpath = "//*[@id=\"mat-input-8\"]")
	@CacheLookup
	WebElement residentialaddressArealocalityvillege;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-step5/div[2]/dynamic-form/div/form/div[5]/div/button/span[1]")
	@CacheLookup
	WebElement Formfivectnbtn;
	

	
	
	@FindBy(xpath="//*[@id=\"mat-input-7\"]")
	@CacheLookup
	WebElement flowAAbusinessname;
	
	@FindBy(xpath="//*[@id=\"mat-input-9\"]")
	@CacheLookup
	WebElement flowAAbusinessstreetaddress;
	
	@FindBy(xpath="//*[@id=\"mat-input-10\"]")
	@CacheLookup
	WebElement flowAABusinessarealocalityvillege;
	
	@FindBy(xpath="//*[@id=\"mat-input-12\"]")
	@CacheLookup
	WebElement flowAAresedentialstreetaddress;
	
	@FindBy(xpath="//*[@id=\"mat-input-13\"]")
	@CacheLookup
	WebElement flowAAresedentialarealocalityvillege;
	
	
	
	
//	 nlp=1 Greater than 2 lac AA_FLow Xpath
	
	
	public By nlpnatureofBusinessRetailer = By.xpath("//*[@id=\"field1\"]/div/div/div[1]/label/span[2]");
	
	public By nlpnatureofBusinessWholesaler = By.xpath("//*[@id=\"field1\"]/div/div/div[2]/label/span[2]");
	
	
	
	
	public By NLPProductYouyouSelldropdownField = By.xpath("//*[@id=\"mat-select-value-1\"]");
	
	public By NLPPopUpwindowsearchsield = By.xpath("//*[@id=\"mat-dialog-0\"]/app-product-dialog/app-products/div/div[2]/div/input");

	public By NLPPopupwindowdsasearchenter = By.xpath("//*[@id=\"mat-dialog-0\"]/app-product-dialog/app-products/div/div[3]/div/div/span");

	public By NLPPopupwindowproductSubmitbtn = By.xpath("//*[@id=\"mat-dialog-0\"]/app-product-dialog/app-products/div/div[4]/div/div/div/button/span[1]");
	
	
	
	
	public By NLPBusinessField = By.xpath("//*[@id=\"mat-input-7\"]");
	
	public By nlpbusinessaddressshopnumber = By.xpath("//*[@id=\"mat-input-9\"]");
	
	public By nlpbusinessaddressArea = By.xpath("//*[@id=\"mat-input-10\"]");
	
	public By nlpresidenceaddressFlatno = By.xpath("//*[@id=\"mat-input-12\"]");
	
	public By nlpresidenceaddressArea = By.xpath("//*[@id=\"mat-input-13\"]");
	
	
	
	
	
//	 nlp=1 Less than 2 lac AA_FLow Xpath
	
	
	
	public By nlplessthanatureofBusinessRetailer = By.xpath("//*[@id=\"field1\"]/div/div/div[1]/label");
	
	public By nlplessthanatureofBusinessWholesaler = By.xpath("//*[@id=\"field1\"]/div/div/div[2]/label");
	
	
	
	
	public By NLPlessthaProductYouyouSelldropdownField = By.xpath("//*[@id=\"mat-select-0\"]");
	
	public By NLPlessthaPopUpwindowsearchsield = By.xpath("//*[@id=\"mat-dialog-0\"]/app-product-dialog/app-products/div/div[2]/div/input");
//Alu
	public By NLPlessthaPopupwindowdsasearchenter = By.xpath("//*[@id=\"mat-dialog-0\"]/app-product-dialog/app-products/div/div[3]/div/div/span");

	public By NLPlessthaPopupwindowproductSubmitbtn = By.xpath("//*[@id=\"mat-dialog-0\"]/app-product-dialog/app-products/div/div[4]/div/div/div/button/span[1]");
	
	
	
	
	public By NLPlessthaBusinessField = By.xpath("//*[@id=\"mat-input-2\"]");
	
	public By nlplessthabusinessaddressshopnumber = By.xpath("//*[@id=\"mat-input-4\"]");
	
	public By nlplessthabusinessaddressArea = By.xpath("//*[@id=\"mat-input-5\"]");
	
	public By nlplesstharesidenceaddressFlatno = By.xpath("//*[@id=\"mat-input-7\"]");
	
	public By nlplesstharesidenceaddressArea = By.xpath("//*[@id=\"mat-input-8\"]");
	
	
	
	// Non banking EXAA flow
	
	
	
	public By nonBankingEXAABusinessField = By.xpath("//*[@id=\"mat-input-11\"]");
	
	public By nonBankingEXAAbusinessaddressshopnumber = By.xpath("//*[@id=\"mat-input-13\"]");
	
	public By nonBankingEXAAbusinessaddressArea = By.xpath("//*[@id=\"mat-input-14\"]");
	
	public By nonBankingEXAAresidenceaddressFlatno = By.xpath("//*[@id=\"mat-input-16\"]");
	
	public By nonBankingEXAAresidenceaddressArea = By.xpath("//*[@id=\"mat-input-17\"]");
	
	
	
	
	
	
	
	
	
	
	public void NatureOfBusinessRetailer() {
		natureofbusinessretailer.click();
	}

	public void NatureOfBusinessWholesaler() {
		natureofbusinessreWholsesaller.click();
	}

	public void NatureOfBusinessManuFacturer() {
		natureofbusinessmanufacturer.click();
	}

	public void NatureOfBusinessService() {
		natureofbusinessServicer.click();
	}

	public void NatureOfBusinessholesaler_Manufacturer() {
		natureofbusinesswholse_retailer.click();
	}

	public void ProductYouSellDropDwonField() {
		Productyouselldropdwonfield.click();
	}

	
	public void PopUpwindowSearchField(String ser) {
		PopUpwindowsearchsield.sendKeys(ser);
	}
	
	
	public void PopUpWindowDSASearchValueEnter() {
		Popupwindowdsasearchenter.click();
	}
	
	public void PopUpWindowProductSUBMITButton() {
		PopupwindowproductSubmitbtn.click();
	}
	
	
	public void WhatIsYourBusinessName(String name) {
		whatisurbusinessname.sendKeys(name);
	}

	public void BusinessAddressShopNumberStreetname(String street) {
		BusinessaddressstreetShop.sendKeys(street);
	}

	public void BusinessAddressAreaLocalityVillege(String Arevill) {
		BusinessAddressarealocalityvillege.sendKeys(Arevill);
	}

	public void ResidentialAddressStreetNameShopNumber(String stre) {
		residentialaddressStreetNameshopnumber.sendKeys(stre);
	}

	public void ResidentialAddressAreLocalityVillege(String strse) {
		residentialaddressArealocalityvillege.sendKeys(strse);
	}
	
	public void FormFiveContinueButton() {
		Formfivectnbtn.click();
	}
	
	public void FlowAABusinessNameField(String bussname) {
		flowAAbusinessname.sendKeys(bussname);
	}
	
	public void FlowAABusinessStreetAddress(String bussstrradd) {
		flowAAbusinessstreetaddress.sendKeys(bussstrradd);
	}
	
	public void FlowAABusinessAreaLocalityVillege(String bussarealocality) {
		flowAABusinessarealocalityvillege.sendKeys(bussarealocality);
	}
	
	public void FlowAAResedentialStreetAddress(String Resstrradd) {
		flowAAresedentialstreetaddress.sendKeys(Resstrradd);
	}
	
	public void FlowAAResedentialAreaLocalityVillege(String Resedentialarealocality) {
		flowAAresedentialarealocalityvillege.sendKeys(Resedentialarealocality);
	}
	
	
	
	
	
//	 nlp=1 Greater than 2 lac AA_FLow Methods
	
	public void NLPNatureOfBusinessRETAILER() {
		ldriver.findElement(nlpnatureofBusinessRetailer).click();
	}
	
	public void NLPNatureofBusinessWHOSELER() {
		ldriver.findElement(nlpnatureofBusinessWholesaler).click();
	}
	
	public void NLPProductyouSellDROPDOWNField() {
		ldriver.findElement(NLPProductYouyouSelldropdownField).click();
	}
	
	public void NLPPopUpwindowSEARCHFIELD(String MS) {
		ldriver.findElement(NLPPopUpwindowsearchsield).sendKeys(MS);
	}
	
	public void NLPPopupwindowACCENTER() {
		ldriver.findElement(NLPPopupwindowdsasearchenter).click();
	}
	
	public void NLPPOPUPWindowSubmitBUTTON() {
		ldriver.findElement(NLPPopupwindowproductSubmitbtn).click();
	}
	
	public void NLPBUSINESSNAMEField(String MS) {
		ldriver.findElement(NLPBusinessField).sendKeys(MS);
	}
	
	public void NLPBusinessAddressSHOPNUMBER(String MS) {
		ldriver.findElement(nlpbusinessaddressshopnumber).sendKeys(MS);
	}
	
	public void NLPBUSINESSADDRESSArea(String MS) {
		ldriver.findElement(nlpbusinessaddressArea).sendKeys(MS);
	}
	
	public void NLPRESIDENCEADDRESSFLATNO(String MS) {
		ldriver.findElement(nlpresidenceaddressFlatno).sendKeys(MS);
	}
	
	public void NLPRESIDENCEADDRESSAREA(String MS) {
		ldriver.findElement(nlpresidenceaddressArea).sendKeys(MS);
	}
	
	
	
	// nlp=1 Less than 2 lac methods
	
	
	public void NLPlessthanatureofBusinessRETAILER() {
		ldriver.findElement(nlplessthanatureofBusinessRetailer).click();
	}
	
	
	public void NLPlessthanatureofBusinessWHOLESALER() {
		ldriver.findElement(nlplessthanatureofBusinessWholesaler).click();
	}
	
	public void NLPlessthaProductYouyouSellDROPDOWNField() {
		ldriver.findElement(NLPlessthaProductYouyouSelldropdownField).click();
	}
	
	
	public void NLPlessthaPopUpwindowSEARCHFIELDS(String al) {
		ldriver.findElement(NLPlessthaPopUpwindowsearchsield).sendKeys(al);
	}
	
	
	public void NLPlessthaPopupwindowdsaSEARCHENTERALU() {
		ldriver.findElement(NLPlessthaPopupwindowdsasearchenter).click();
	}	
	
	public void NLPlessthaPopupwindowproductSUBMITBUTTON() {
		ldriver.findElement(NLPlessthaPopupwindowproductSubmitbtn).click();
	}

	
	
	public void NLPlessthaBUSINESSField(String se) {
		ldriver.findElement(NLPlessthaBusinessField).sendKeys(se);
	}
	
	public void nlplessthaBUSINESSaddressSHOPNUMBER(String se) {
		ldriver.findElement(nlplessthabusinessaddressshopnumber).sendKeys(se);
	}
	
	public void nlplessthaBUSINESSAddressAREA(String se) {
		ldriver.findElement(nlplessthabusinessaddressArea).sendKeys(se);
	}
	
	public void nlplessthaRESIDENCEaddressFLATNO(String se) {
		ldriver.findElement(nlplesstharesidenceaddressFlatno).sendKeys(se);
	}
	
	public void nlplessthaRESIDENCEaddressAREA(String se) {
		ldriver.findElement(nlplesstharesidenceaddressArea).sendKeys(se);
	}
	
	
	
	
	// Non banking EXAA flow
	
	public void NoNbankingEXAAABUSINESSField(String se) {
		ldriver.findElement(nonBankingEXAABusinessField).sendKeys(se);
	}
	
	public void NoNbankingEXAAABUSINESSaddressSHOPNUMBER(String se) {
		ldriver.findElement(nonBankingEXAAbusinessaddressshopnumber).sendKeys(se);
	}
	
	public void NoNbankingEXAAABUSINESSAddressAREA(String se) {
		ldriver.findElement(nonBankingEXAAbusinessaddressArea).sendKeys(se);
	}
	
	public void NoNbankingEXAAARESIDENCEaddressFLATNO(String se) {
		ldriver.findElement(nonBankingEXAAresidenceaddressFlatno).sendKeys(se);
	}
	
	public void NoNbankingEXAAARESIDENCEaddressAREA(String se) {
		ldriver.findElement(nonBankingEXAAresidenceaddressArea).sendKeys(se);
	}
	
}
