package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class FormTwo {
	
	WebDriver ldriver;

	public FormTwo(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// EXAA Flow
	
	public By loanamt = By.xpath("//*[@id=\"mat-input-3\"]");
	
	public By businessMan = By.xpath("//*[@id=\"field2\"]/div/div/div[1]/label/span[2]");
	
	public By salaryperson = By.xpath("//*[@id=\"field2\"]/div/div/div[2]/label/span[2]");
	
	public By Fullname = By.xpath("//*[@id=\"mat-input-4\"]");
	
	public By  emailid = By.xpath("//*[@id=\"mat-input-5\"]");
	
	public By  dateofincorption= By.xpath("//*[@id=\"mat-input-6\"]");
	
	public By  proprietorship= By.xpath("//*[@id=\"field6\"]/div/div/div[1]/label/span[2]");
	
	public By  partnership= By.xpath("//*[@id=\"field6\"]/div/div/div[2]/label/span[2]");
	
	public By  privatelimited= By.xpath("//*[@id=\"field6\"]/div/div/div[3]/label/span[2]");
	
	public By  publiclimited= By.xpath("//*[@id=\"field6\"]/div/div/div[4]/label/span[2]");
	
	public By  onepersoncompany= By.xpath("//*[@id=\"field6\"]/div/div/div[5]/label/span[2]");
	
	public By  limitedliability= By.xpath("//*[@id=\"field6\"]/div/div/div[6]/label/span[2]");
	
	public By  Form2Ctnbtn= By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-step2/div/dynamic-form/div/form/div[5]/div/button/span[1]");
	
	
//	NLPGreaterThan2LAC  ==     >2lac
	public By nlpgreaterthan2loanamt = By.xpath("//*[@id='mat-input-0']");
	
	public By nlpgreaterthan2businessman = By.xpath("//*[@id=\"field2\"]/div/div/div[1]/label/span[2]");
	
	public By nlpgreaterthan2fullname = By.xpath("//*[@id='mat-input-1']");
	
	public By nlpgreaterthan2emailid = By.xpath("//*[@id='mat-input-2']");
	
	
	
	//NLPLessThan2LAC  == <2lac
	
	public  By nlpLessThan2LacLoanamt = By.xpath("//*[@id='mat-input-1']");
	
	public By nlpLessThan2Lacyouarebusinessman = By.xpath("//*[@id=\"field2\"]/div/div/div[1]/label/span[2]");
	
	public By nlpLessThan2Lacyouareasalaryperson = By.xpath("//*[@id=\"field2\"]/div/div/div[2]/label/span[2]");
	
	public By nlpLessThan2Lacfullname = By.xpath("//*[@id='mat-input-2']");
	
	public By nlpLessThan2LacEmail = By.xpath("//*[@id='mat-input-3']");
	
	public By nlpLessThan2Lacdateofincorporation = By.xpath("//*[@id='mat-input-4']");
	
	public By nlpLessThan2LacbusinessregPropritership = By.xpath("//*[@id=\"field6\"]/div/div/div[1]/label/span[2]");
	
	public By nlpLessThan2Lacbusinessregpartnership = By.xpath("//*[@id=\"field6\"]/div/div/div[2]/label/span[2]");
	
	
	
	
	// FlowAA xpath
	
	public By flowaanewfullnameF = By.xpath("//*[@id=\"mat-input-3\"]");
	
	public By flowaanewEmailF = By.xpath("//*[@id=\"mat-input-4\"]");
	
	
	
//	Flow nlp=1 New Field xpath
	
	public By flownlpnewfullnameF = By.xpath("//*[@id=\"mat-input-0\"]");
	
	public By flownlpnewEmailF = By.xpath("//*[@id=\"mat-input-1\"]");
	
	
	
	
	@FindBy(xpath="//*[@id=\"mat-input-0\"]")
	@CacheLookup
	WebElement flowAAloanamt;
	
	@FindBy(xpath="//*[@id=\"mat-input-1\"]")
	@CacheLookup
	WebElement flowAAFullName ;
	
	@FindBy(xpath="//*[@id=\"mat-input-2\"]")
	@CacheLookup
	WebElement flowAAemailid;
	
	
	
	public void LoanAmountField(String lA) {
		ldriver.findElement(loanamt).sendKeys(lA);
	}
	
	public void YouAreBusinessMANCheckBoX() {
		ldriver.findElement(businessMan).click();
	}
	
	public void YouAreSalaryPersonCheckBox() {
		ldriver.findElement(salaryperson).click();
	}
	
	
	public void FullNameField(String fn) {
		ldriver.findElement(Fullname).sendKeys(fn);
	}
	
	
	public void EmailIDField(String ei) {
		ldriver.findElement(emailid).sendKeys(ei);
	}
	
	
	public void DateOfIncorporationField(String doi) {
		ldriver.findElement(dateofincorption).sendKeys(Keys.PAGE_DOWN);
		ldriver.findElement(dateofincorption).sendKeys(doi);
	}
	
	
	public void ProprietorshipCheckKBOX() {
		ldriver.findElement(proprietorship).click();
	}
	
	
	public void PartnershipCheckBOX() {
		ldriver.findElement(partnership).click();
	}
	
	
	public void Form2ContinueButton() {
		ldriver.findElement(Form2Ctnbtn).click();
	}
	
	
	
	
	public void nlpgreaterthan2loanAmountField(String la) {
		ldriver.findElement(nlpgreaterthan2loanamt).sendKeys(la);
	}
	
	public void nlpgreaterthan2businessMANField() {
		ldriver.findElement(nlpgreaterthan2businessman).click();
	}
	
	public void nlpgreaterthan2FULLNameField(String fn) {
		ldriver.findElement(nlpgreaterthan2fullname).sendKeys(fn);
	}
	
	
	public void nlpgreaterthan2EmailIDField(String eid) {
		ldriver.findElement(nlpgreaterthan2emailid).sendKeys(eid);
	}
	
	
	
	
	
	
	
	
	
	
	
	//Flow AA
	
	public void FlowAAloanamountField(String AAamt) {
		flowAAloanamt.sendKeys(AAamt);
	}
	
	
	public void flowAAFullNameField(String name) {
		flowAAFullName.sendKeys(name);
	}
	
	public void flowAAEmailIdField(String emai) {
		flowAAemailid.sendKeys(emai);
	}
	
	
	public void flowAANEWFullNameField(String eid) {
		ldriver.findElement(flowaanewfullnameF).sendKeys(eid);
	}
	
	public void flowAANEWEmailField(String eid) {
		ldriver.findElement(flowaanewEmailF).sendKeys(eid);
	}
	
	
	
	//Flow nlp=1
	
	
	public void flowNLPNEWFullNameField(String eid) {
		ldriver.findElement(flownlpnewfullnameF).sendKeys(eid);
	}
	
	public void flowNLPNEWEmailField(String eid) {
		ldriver.findElement(flownlpnewEmailF).sendKeys(eid);
	
	}
	
	
	
	// NLP less than 2 lac
	
	public void NLPLessThan2LacLoanamtFIELD(String eid) {
		ldriver.findElement(nlpLessThan2LacLoanamt).sendKeys(eid);
	}
	
	public void NLPLessThan2LacYouAreBusinessMan() {
		ldriver.findElement(nlpLessThan2Lacyouarebusinessman).click();
	}
	
	public void nlpLessThan2Lacyouareasalaryperson() {
		ldriver.findElement(nlpLessThan2Lacyouareasalaryperson).click();
	}

	public void NLPLessThan2LacFULLNAMEFIELD(String na) {
		ldriver.findElement(nlpLessThan2Lacfullname).sendKeys(na);
	}
	
	public void NLPLessThan2LacEmailFIELD(String na) {
		ldriver.findElement(nlpLessThan2LacEmail).sendKeys(na);
	}
	
	
	public void NLPLessThan2LacdDATEOFINCORPORATIONFIELD(String na) {
		ldriver.findElement(nlpLessThan2Lacdateofincorporation).sendKeys(na);
	}
	
	public void NLPLessThan2LacbusinessregPROPEITERSHIPBOX() {
		ldriver.findElement(nlpLessThan2LacbusinessregPropritership).click();
	}
	

	public void NLPLessThan2LacbusinessregPARTNERSHIPBOX() {
		ldriver.findElement(nlpLessThan2Lacbusinessregpartnership).click();
	}
	
	
	
}
