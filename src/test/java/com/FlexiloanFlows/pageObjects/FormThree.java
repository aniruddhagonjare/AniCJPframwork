package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormThree {
	
	WebDriver ldriver;

	public FormThree(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public By Male = By.xpath("//*[@id=\"field1\"]/div/div/div[1]/label/span[2]");
	
	public By FeMale = By.xpath("//*[@id=\"field1\"]/div/div/div[2]/label/span[2]");
	
	public By Others= By.xpath("//*[@id=\"field1\"]/div/div/div[3]/label/span[2]");
	
	public By dobirth = By.xpath("//*[@id=\"mat-input-7\"]");
	
	public By residencPincodee = By.xpath("//*[@id=\"mat-input-8\"]");
	
	public By CurrentAccountYESS = By.xpath("//*[@id=\"field4\"]/div/div/div[1]/label/span[2]");
	
	public By CurrentAccountNO = By.xpath("//*[@id=\"field4\"]/div/div/div[2]/label/span[2]");
	
	public By Pann = By.xpath("//*[@id=\"mat-input-9\"]");
	 

	
	// Nlp Greater than 2 lac
	public By nlpgreater2lacGendermale = By.xpath("//*[@id=\"field1\"]/div/div/div[1]/label/span[2]");
	
	public By tenlpgreater2lacGenderfemale = By.xpath("//*[@id=\"field1\"]/div/div/div[2]/label/span[2]");
	
	public By nlpgreater2lacgenderothers = By.xpath("//*[@id=\"field1\"]/div/div/div[3]/label/span[2]");
	
	public By nlpgreater2lacdob = By.xpath("//*[@id=\"mat-input-3\"]");
	
	public By nlpgreater2lacresidencepincode = By.xpath("//*[@id=\"mat-input-4\"]");
	
	public By nlpgreater2lacCurrentaccYES = By.xpath("//*[@id=\"field4\"]/div/div/div[1]/label");
	
	public By nlpgreater2lacbusinessregPropritership = By.xpath("//*[@id=\"field5\"]/div/div/div[1]/label/span[2]");
	
	public By nlpgreater2lacbusinessregpartneship = By.xpath("//*[@id=\"field5\"]/div/div/div[2]/label/span[2]");
	
	
	
	// Nlp Less than 2 lac
	
	
	public By nlplessthan2lacGendermale = By.xpath("//*[@id=\"field1\"]/div/div/div[1]/label/span[2]");
	
	public By nlpless2lacGenderfemale = By.xpath("//*[@id=\"field1\"]/div/div/div[2]/label/span[2]");

	public By nlpless2lacdob = By.xpath("//*[@id=\"mat-input-5\"]");

	public By nlpless2lacresidencepincode = By.xpath("//*[@id=\"mat-input-6\"]");
	
	public By  nlpless2laccurrentaccyes = By.xpath("//*[@id=\"field4\"]/div/div/div[1]/label/span[2]");
	
	public By nlpless2laccurrentaccno = By.xpath("//*[@id=\"field4\"]/div/div/div[2]/label/span[2]");
	
	public By nlpless2lacpan = By.xpath("//*[@id=\"mat-input-7\"]");
	
	
	@FindBy(xpath="//*[@id=\"field1\"]/div/div/div[1]/label/span[2]")
	@CacheLookup
	WebElement gendermale;
	
	
	@FindBy(xpath="//*[@id=\"field1\"]/div/div/div[2]/label/span[2]")
	@CacheLookup
	WebElement genderfemale;
	
	@FindBy(xpath="//*[@id=\"mat-input-6\"]")
	@CacheLookup
	WebElement dateofbirth;
	
	@FindBy(xpath="//*[@id=\"mat-input-7\"]")
	@CacheLookup
	WebElement residencpincode;
	
	@FindBy(xpath="//*[@id=\"field4\"]/div/div/div[1]/label/span[2]")
	@CacheLookup
	WebElement currentaccounty;
	
	@FindBy(xpath="//*[@id=\"field4\"]/div/div/div[2]/label/span[2]")
	@CacheLookup
	WebElement currentaccountn;
	
	@FindBy(xpath="//*[@id=\"mat-input-8\"]")
	@CacheLookup
	WebElement pan;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-step3/div[2]/dynamic-form/div/form/div[5]/div/button/span[1]")
	@CacheLookup
	WebElement for3ctnbtn;
	
	@FindBy(xpath="//*[@id=\"mat-input-3\"]")
	@CacheLookup
	WebElement flowaadateofbirth;
	
	@FindBy(xpath="//*[@id=\"mat-input-4\"]")
	@CacheLookup
	WebElement flowAAresidencpincode;
	
	@FindBy(xpath="//*[@id=\"field5\"]/div/div/div[1]/label/span[2]")
	@CacheLookup
	WebElement flowAABusinesregiProprietorship;
	
	
	
	public void GenderMALECheckBOX() {
		ldriver.findElement(Male).click();
	}
	
	public void GenderFEMALECheckBOX() {
		ldriver.findElement(FeMale).click();
	}
	
	public void GendearOthersCheckBOX() {
		ldriver.findElement(Others).click();
	}
	
	public void DateOFBirthField(String dobb) {
		ldriver.findElement(dobirth).sendKeys(dobb);
	}
	
	public void ResidencePinCodeField(String pin) {
		ldriver.findElement(residencPincodee).sendKeys(Keys.PAGE_DOWN);
		ldriver.findElement(residencPincodee).sendKeys(pin);
	}
	
	public void CurrentAccountYESSCheckBOX() {
		ldriver.findElement(CurrentAccountYESS).click();
	}
	
	public void CurrentAccountNOSCheckBOX() {
		ldriver.findElement(CurrentAccountNO).click();
	}
	
	public void PANField(String pan) {
		ldriver.findElement(Pann).sendKeys(pan);
	}
	
	
	
	
	
	
	
	
	public void GenderMale() {
		gendermale.click();
	}
	
	public void GenderFeMale() {
		genderfemale.click();
	}
	
	public void DOB(String dob) {
		dateofbirth.sendKeys(dob);
	}
	
	public void ResidencePincode(String pin) {
		residencpincode.sendKeys(pin);
	}
	
	public void CurrentAccountYES() {
		currentaccounty.click();
	}
	
	public void CurrentAccountNO() {
		currentaccountn.click();
	}

	public void PANCardField(String pancard) {
		pan.sendKeys(pancard);
	}
	
	public void FormThressContinueButton() {
		for3ctnbtn.click();
	}
	
	
	
	
	
	// nlp Greater than 2 lac
	
	public void nlpgreater2lacGenderMALE() {
		ldriver.findElement(nlpgreater2lacGendermale).click();
	}
	
	public void nlpgreater2lacGendeFEMALE() {
		ldriver.findElement(tenlpgreater2lacGenderfemale).click();
	}
	
	public void nlpgreater2lacGenderOTHERS() {
		ldriver.findElement(nlpgreater2lacgenderothers).click();
	}
	
	public void nlpgreater2lacDOBField(String doe) {
		ldriver.findElement(nlpgreater2lacdob).sendKeys(doe);
	}
	
	public void nlpgreater2lacResidencePincodeFeld(String pin) {
		ldriver.findElement(nlpgreater2lacresidencepincode).sendKeys(pin);
	}
	
	public void nlpgreater2lacCurrentAccountYES() {
		ldriver.findElement(nlpgreater2lacCurrentaccYES).click();
	}
	
	public void nlpgreater2lacbusinessregPROPRITERSHIP() {
		ldriver.findElement(nlpgreater2lacbusinessregPropritership).click();
	}
	
	
	
	// nlp Less Than 2 lac
	
	
	public void NLPlessthan2lacGENDERMALE() {
		ldriver.findElement(nlplessthan2lacGendermale).click();
	}
	
	public void NLPlessthan2lacGENDERFEMALE() {
		ldriver.findElement(nlpless2lacGenderfemale).click();
	}
	
	public void NLPless2lacDOBFIELD(String db) {
		ldriver.findElement(nlpless2lacdob).sendKeys(db);
	}

	public void NLPless2lacResdencePINCODE(String pin) {
		ldriver.findElement(nlpless2lacresidencepincode).sendKeys(pin);
	}
	

	public void NLPless2lacCURRENTACCOUNTYES() {
		ldriver.findElement(nlpless2laccurrentaccyes).click();
	}
	
	public void NLPless2lacCURRENTACCOUNTNO() {
		ldriver.findElement(nlpless2laccurrentaccno).click();
	}
	
	public void NLPless2lacPANFIELD(String pin) {
		ldriver.findElement(nlpless2lacpan).sendKeys(pin);
	}
	
	
	//Flow AA 
	
	
	public void FlowAADOB(String aadob) {
		flowaadateofbirth.sendKeys(aadob);
	}
	
	public void FlowAAResidencPinCode(String respincode) {
		flowAAresidencpincode.sendKeys(respincode);
	}
	
	public void FlowAABusinesRegisteriProprietorship() {
		flowAABusinesregiProprietorship.click();
	}

	
	
}
