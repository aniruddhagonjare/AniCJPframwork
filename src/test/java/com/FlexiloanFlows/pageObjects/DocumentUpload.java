package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentUpload {
	
	WebDriver ldriver;

	public DocumentUpload(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[3]/div[2]")
					
	@CacheLookup
	WebElement uploaddocumentlink;
	
	
	
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[3]/div/div[1]/div/div[4]/div/div/button/span[1]")
	@CacheLookup
	WebElement panCardupload;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[2]/div[1]/div/div[1]/label/span[2]/div")
	@CacheLookup
	WebElement pancarddocSelected;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[1]/div/span[3]/button/span[1]")
	@CacheLookup	
	WebElement pancardsubmitbtn;
	
	
	
	
	
	
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[3]/div/div[1]/div/div[4]/div/div/button")
	@CacheLookup
	WebElement Proofofcurrentresidentialaddressuploadbtn;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[2]/div[1]/div/div[1]/label/span[2]/div/div[2]")
	@CacheLookup
	WebElement ProofofcurrentresidentialaddressDOCAadharcardselected;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[2]/div/span[1]/img")
	@CacheLookup
	WebElement AADHARCARDFRONTSIDEImg ;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[2]/div/ngx-dropzone/div/ngx-dropzone-label")
	@CacheLookup
	WebElement Uploadaddharcardselect;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[1]/div/span[3]/button/span[1]")
	@CacheLookup
	WebElement Proofofcurrentresidentialaddressuploadsubitbtn;
	
	
	
	
	
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[2]/div/div/div/div[4]/div/div/button")
	@CacheLookup
	WebElement Proofofbusinessaddressupload;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[2]/div[1]/div/div[1]/label/span[2]/div")
	@CacheLookup
	WebElement GSTregistrationcertificateDOCselected;
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[1]/div/span[3]/button/span[1]")
	@CacheLookup
	WebElement Proofofbusinessaddresssubmitbtn;
	

	
	
	
	
	
	
//	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[3]/div/div[4]/div/div[4]/div/div/button/span[1]")
//	@CacheLookup
//	WebElement proofofincorporationdocumentupload;
//	
//	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[2]/div[1]/div/div/label/span[2]/div")
//	@CacheLookup
//	WebElement PartnershipdeedDOCSelected;
//	
//	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/app-doc-upload-desktop/div/div[1]/div/span[3]/button/span[1]")
//	@CacheLookup
//	WebElement proofofincorporationdocumentuploadsubitbtn;
	
	
	
	@FindBy(xpath="/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[9]/div/button/span[1]")
	@CacheLookup 
	WebElement upload_documentctnbtn;
	
	
	
	// PROD pan card upload button
	public By PRODPANcardUploadbutton = By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[2]/div/div/div/div[4]/div/div/button");
	
	
	public void PRODnlp_1flowPANCARDUploadBUTTON() {
		ldriver.findElement(PRODPANcardUploadbutton).click();
	}
	
	
	
	public void UploadDocumentLink() {
		uploaddocumentlink.click();
	}
	
	
	
	
	public void PANCARDUploadButton() {
		panCardupload.click();
	}
	
	public void PANCARDDOCSelected() {
		pancarddocSelected.click();
	}
	
	
	public void PANCARDSubmitButton() {
		pancardsubmitbtn.click();
	}
	
	
	
	
	public void ProofofCurrentResidentialAddressUploadButton() {
		Proofofcurrentresidentialaddressuploadbtn.click();
	}
	
	public void ProofofCurrentResidentialAddressDOCAadharCardSelected() {
		ProofofcurrentresidentialaddressDOCAadharcardselected.click();
	}
	
	public void AADHARCARDFRONTSIDEIMG() {
		AADHARCARDFRONTSIDEImg.click();
	}
	
	public void UploadAadharCardChooseSelect() {
		Uploadaddharcardselect.click();
	}
	
	public void ProofofcurrentresidentialaddressuploadSubmitButton() {
		Proofofcurrentresidentialaddressuploadsubitbtn.click();
	}
	
	
	
	
	
	public void ProofOfBusinessAddressUpload() {
		Proofofbusinessaddressupload.click();
	}
	
	public void GSTRegistrationCertificateDOCSelected() {
		GSTregistrationcertificateDOCselected.click();
	}
	
	public void ProofOfBusinessAddressSubmitButton() {
		Proofofbusinessaddresssubmitbtn.click();
	}
	
	
	
	public void Upload_DocumentContinueButton() {
		upload_documentctnbtn.click();
	}
	
	
	
	
}
