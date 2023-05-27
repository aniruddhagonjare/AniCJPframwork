package com.FlexiloanFlows.testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.FlexiloanFlows.pageObjects.AA_bankPage;
import com.FlexiloanFlows.pageObjects.BankAccount;
import com.FlexiloanFlows.pageObjects.Bank_Statement;
import com.FlexiloanFlows.pageObjects.DocumentUpload;
import com.FlexiloanFlows.pageObjects.FormFive;
import com.FlexiloanFlows.pageObjects.FormFour;
import com.FlexiloanFlows.pageObjects.FormOne;
import com.FlexiloanFlows.pageObjects.FormThree;
import com.FlexiloanFlows.pageObjects.FormTwo;
import com.FlexiloanFlows.pageObjects.LoanOffer;
import com.FlexiloanFlows.pageObjects.OTPPage;
import com.FlexiloanFlows.pageObjects.OfferlandingPage;
import com.FlexiloanFlows.pageObjects.StagingLOS;

public class EXAA_NoBanking_Flow extends BaseClass{
	
	
	String random4no = randome4Num();
	String randome6no = randome6Num();
	String random9no = randome9Num();
	String ranom10charcters = randome10string();
	String ranom5charcters = randome5string();
	String a = "1" + random9no; 				// Enter Mobile number
	String b = "5" + random4no;	//change to 4 when EXAA	// Enter monthly sales
	String c = "B" + randome6no + "@gmail.com";  // enter email field
	String pan = ranom5charcters + random4no + "A";
	
	int monthlysalefield=Integer.parseInt(b);
	
	
	String filepath = "/Users/fllap0221/Downloads/HDFCBankstatement.PDF";
	String pancardpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/PANCARDAutomation.jpeg";
	String Aadharcardpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/AadharcardAutomation.jpeg";
	String GSTregistrationpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/GSTRegistrationCertificateAutomation.png";
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	
	@Test(priority = 0)
	public void landinaagPage() throws Exception {
		
		
		driver.get(offerEXAAflowURL);

		OfferlandingPage olp = new OfferlandingPage(driver);
		
		dynamicWait(10, olp.mob);
		
		olp.EnterMobileNumberField(a);
		System.out.println("Mobile Number = "+a);
		
		dynamicWait(10, olp.getstartedsubmitbuton);
		olp.GetStartedButton();
		
	}
	
	
	@Test(priority = 1)
	public void DBConnectionANDOtppage() throws Exception {
		
		
		Thread.sleep(20000);
		
		String dbUrl = "jdbc:mysql://13.233.13.169:3306/flexiloans_staging_db";
		String username = "aniruddha_gonjare";
		String password = "Sukiotroo9oRjtreert9384";
		String query = "select otp from flexiloans_staging_db.otp_user where mobile_no=" +a+ " order by verification_time desc;";
	
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(dbUrl, username, password);
		
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			String otp = rs.getString(1);
			System.out.println("OTP = " +otp);
			OTPPage ot12 = new OTPPage(driver);
			
			dynamicWait(10, ot12.Otpfield);
			
			dynamicWait(10, ot12.verifybtn);
			
			driver.findElement(By.xpath("//*[@data-placeholder=\"Enter OTP\"]")).sendKeys(otp);
		}
		con.close();
		
		
		OTPPage ot = new OTPPage(driver);
		dynamicWait(10,ot.verifybtn);
		ot.VerifyOTPButton();
		
		
		
		Thread.sleep(5000);
		String dbUrll = "jdbc:mysql://13.233.13.169:3306/flexiloans_staging_db";
		String usernamee = "aniruddha_gonjare";
		String passwordd = "Sukiotroo9oRjtreert9384";
		String queryy = "select loan_code , customer_code from loan_applicant_detail where mobile_no =" +a+ " order by updated_time desc;";
	
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection(dbUrll, usernamee, passwordd);
		
		Statement stmtt = conn.createStatement();

		ResultSet rss = stmtt.executeQuery(queryy);

		String loancode = null;
		
		// While Loop to iterate through all data and print results
		while (rss.next()) {
			loancode = rss.getString(1);
			String customercode = rss.getString(2);
			System.out.println("Loan Code = "+loancode+"  "+"Customer Code = "+customercode);
			Thread.sleep(2000);
		}		
	}
	 
	
	@Test(priority = 2)
	public void FormOne1() throws Exception{
		
		FormOne f1 = new FormOne(driver);
		dynamicWait(10, f1.Monthlysale);
		
		
		
		f1.MonthalySalesField("180000");  //"b"  For AA flow

//		WebElement ms = driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]"));
//		ms.sendKeys("150000");
//		System.out.println(ms.getAttribute("value"));
		
		String text = driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).getText();
		System.out.println(text);
		
		
		dynamicWait(10, f1.GstY); 
		
		f1.GstYES();
		dynamicWait(10, f1.Form1Ctnbtn);
		
			
		f1.Form1ContinueButton();	
		
//		/*redirect to AA flow	*/
		
		if(monthlysalefield>=200000) {
			
			System.out.println("Not moved forward to EXAA");
//			System.out.println("Monthly Sales =" +monthlysalefield);
			
			AA_Flow aa = new AA_Flow();
			Thread.sleep(3000);
			aa.NewAAfields();
			aa.AABankpage();	
			aa.bank_statement();
			aa.FormTwo2();
			aa.FormThree3();
			aa.FormFour4();
			aa.FormFive5();
			aa.Upload_document();
//			System.exit(0);
		}else {
		System.out.println("Else not run if monthly sale in greater than 2 lac");
		
		}
		
	}
		
	
	@Test(priority = 3)
	public void FormTwo2() throws Exception{
		
		System.out.println("Redirect to form 2 (EXAA)");
		
		FormTwo f2 = new FormTwo(driver);
		
		dynamicWait(10, f2.loanamt);
		
		f2.LoanAmountField("250000");
		dynamicWait(10, f2.businessMan);
	
		f2.YouAreBusinessMANCheckBoX();
		dynamicWait(10, f2.salaryperson);
		
		f2.FullNameField("TestAutomation");
		dynamicWait(10, f2.Fullname);
		
		f2.EmailIDField(c);
		dynamicWait(10, f2.emailid);
		
		f2.DateOfIncorporationField("10102015");
		dynamicWait(10, f2.dateofincorption);
		
//		WebElement scroll5 = driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]"));
//		scroll5.sendKeys(Keys.PAGE_DOWN);
		
		f2.ProprietorshipCheckKBOX();
		dynamicWait(10, f2.proprietorship);
	
		f2.Form2ContinueButton();
		dynamicWait(10, f2.Form2Ctnbtn);
		
		Thread.sleep(90000);   //Not change this Sleep
	} 
	
	@Test(priority = 4)
	public void loanoffer() {
		
		System.out.println("Landed Loanoffer page");
		LoanOffer LO= new LoanOffer(driver);
		
		dynamicWait(10, LO.loanofferaccept);
		LO.LoanOfferAcceptProceedButton();
		
		
	}
	
	
	@Test(priority = 5)
	public void FormThree3() throws Exception{
		
		Thread.sleep(5000); 		 
		
		FormThree f3 =new  FormThree(driver);
		dynamicWait(10, f3.Male);
		
		f3.GenderMALECheckBOX();
		dynamicWait(10, f3.dobirth);
		
		f3.DateOFBirthField("03121993");
		dynamicWait(10, f3.residencPincodee);
		
		f3.ResidencePinCodeField("400001");
		dynamicWait(10, f3.CurrentAccountYESS);
		
		f3.CurrentAccountYESSCheckBOX();
		dynamicWait(10, f3.Pann);
		
//		WebElement l = driver.findElement(By.xpath("//*[@id=\"field4\"]/div/div/div[1]/label/span[2]"));
//		JavascriptExecutor j = (JavascriptExecutor) driver;
//		j.executeScript("arguments[0].click();", l);
		
		
		f3.PANField(pan);
		Thread.sleep(1000);
		
		f3.FormThressContinueButton();
		
	
	}
	
	
	@Test(priority = 6)
	public void FormFour4() throws Exception{
		
		
		FormFour f4 =new  FormFour(driver);
		dynamicWait(10, f4.businesspincodee);
		
		f4.WhatIsYourBusinessPinCodeField("400001");
		dynamicWait(10, f4.residencerented);
		
		f4.ResidenceRentedCheckBOXNO();
		dynamicWait(10, f4.businessrented);

		f4.BusinessRentedCheckBOXNO();
		
		Thread.sleep(1000);
		f4.Form4ContinueButton();
				
	}
//	
//	@Test(priority = 7)
//	public void bank_statement() throws Exception{
//		
//		Thread.sleep(5000);
//		FormFour fo4 =new  FormFour(driver);	
//		
//		WebElement test = driver.findElement(By.xpath("//*[@id='mat-input-1']"));
//		test.sendKeys(Keys.PAGE_DOWN);
//		
//		
//		Thread.sleep(1000);
//		fo4.HowOldYourBusineessMoreThan5Year();
//		
//		Thread.sleep(1000);
//		fo4.Form4ContinueButton();
//		
//	}
	

	@Test(priority = 7)
	public void FormFive5() throws Exception{
		
		Thread.sleep(5000);
		
		FormFive f5 = new FormFive(driver);

		Thread.sleep(1000);
		f5.NatureOfBusinessWholesaler();
		
		Thread.sleep(1000);
		f5.ProductYouSellDropDwonField();
		
		Thread.sleep(2000);
		f5.PopUpwindowSearchField("dsa");
		
		Thread.sleep(2000);
		f5.PopUpWindowDSASearchValueEnter();
		
		Thread.sleep(2000);
		f5.PopUpWindowProductSUBMITButton();
		
		
		Thread.sleep(3000);
		
		dynamicWait(10, f5.nonBankingEXAABusinessField);
		f5.NoNbankingEXAAABUSINESSField(ranom5charcters);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"mat-input-13\"]")).sendKeys(Keys.PAGE_DOWN);
		
		dynamicWait(10, f5.nonBankingEXAAbusinessaddressshopnumber);
		f5.NoNbankingEXAAABUSINESSaddressSHOPNUMBER(ranom5charcters);
		
		dynamicWait(10, f5.nonBankingEXAAbusinessaddressArea);
		f5.NoNbankingEXAAABUSINESSAddressAREA(ranom5charcters);
		
		dynamicWait(10, f5.nonBankingEXAAresidenceaddressFlatno);
		f5.NoNbankingEXAAARESIDENCEaddressFLATNO(ranom5charcters);
		
		dynamicWait(10, f5.nonBankingEXAAresidenceaddressArea);
		f5.NoNbankingEXAAARESIDENCEaddressAREA(ranom5charcters);
		
		Thread.sleep(1000);
		f5.FormFiveContinueButton();
		
	}
	
	
	@Test(priority = 8)
	public void Upload_document() throws Exception{
		
		Thread.sleep(5000);
		
		DocumentUpload du = new DocumentUpload(driver);
		
		Thread.sleep(2000);
		du.Upload_DocumentContinueButton();   //Check from here for digilocker
		
//	Digilocker url		https://accounts.digitallocker.gov.in/oauth_partner/register/%252Foauth2%252F1%252Fconsent%253Fresponse_type%253Dcode%2526client_id%253DB7481010%2526state%253D63226c23-4cf0-4187-8f33-caa32954b35c%2526orgid%253D003889%2526txn%253D63eb8dcdb0204oauth21676381645%2526hashkey%253De33891f0c1ee4e32f67aa7e3d11dfe110e882ea5bd8a330d51986eac3056bfa9%2526requst_pdf%253DN%2526app_name%253DRGlnaXRhbCBPbmJvYXJkaW5n%2526disable_userpwd_login%253D1%2526aadhaar_only%253DY%2526partner_name%253DQmFsZG9yIFRlY2hub2xvZ2llcyBQcml2YXRlIExpbWl0ZWQ%25253D%2526authMode%253DO
	
		// Start Digilocker redirection code
		
		Thread.sleep(2000);
		
		String parent = driver.getWindowHandle();
		
		System.out.println("Parent Tab :" +parent);
		
		Thread.sleep(2000);
		
		WebDriver newtab = driver.switchTo().newWindow(WindowType.TAB);
		
		String child = driver.getWindowHandle();
		
		System.out.println("Parent Tab :" +child);
		
		newtab.getCurrentUrl();
		
		System.out.println("redirect to digilocker");
		
		Thread.sleep(3000);
		
		newtab.close();
		
		driver.switchTo().window(parent);
		
		// End Digilocker redirection
		
		Thread.sleep(4000);
		
		WebElement scroll1 = driver.findElement(By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[3]/div/div[1]/div/div[4]/div/div/button"));
		scroll1.sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(5000);
		du.PANCARDUploadButton();
		
		Thread.sleep(1000);
		du.PANCARDDOCSelected();
		
		Thread.sleep(5000);
//		Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
		
		Runtime runtime = Runtime.getRuntime();
		String appletscriptiCommand = "tell app \"System Events\"\n" +
		
			"keystroke \"G\" using {command down, shift down}\n" +
			
			"delay 3\n" +
			"keystroke \""+pancardpath+"\"\n" +
			"delay 3\n" +
			"keystroke return\n" +
			"delay 3\n" +
			"keystroke return\n" +
			"end tell";
		String[] args = { "osascript", "-e", appletscriptiCommand };
		Process process = runtime.exec(args);
	
		Thread.sleep(15000);
		du.PANCARDSubmitButton();
		
		Thread.sleep(8000);
		
		du.ProofofCurrentResidentialAddressUploadButton();
		
		Thread.sleep(1000);
		du.ProofofCurrentResidentialAddressDOCAadharCardSelected();
		
		Thread.sleep(1000);
		du.AADHARCARDFRONTSIDEIMG();
		
		Thread.sleep(1000);
		du.UploadAadharCardChooseSelect();
		
		Thread.sleep(5000);
//		Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
		
		Runtime runtimee = Runtime.getRuntime();
		String appletscriptiCommandd = "tell app \"System Events\"\n" +
		
			"keystroke \"G\" using {command down, shift down}\n" +
			
			"delay 3\n" +
			"keystroke \""+Aadharcardpath+"\"\n" +
			"delay 3\n" +
			"keystroke return\n" +
			"delay 3\n" +
			"keystroke return\n" +
			"end tell";
		String[] argss = { "osascript", "-e", appletscriptiCommandd };
		Process processs = runtimee.exec(argss);
		
		
		Thread.sleep(15000);
		du.ProofofcurrentresidentialaddressuploadSubmitButton();
		
		
		
		Thread.sleep(8000);
		
		
//		WebElement scroll3 = driver.findElement(By.xpath("//*[@class='mat-focus-indicator button-style button-width button-rounded width-100 mat-flat-button mat-button-base mat-primary ng-star-inserted']"));
//		scroll3.sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		
		du.ProofOfBusinessAddressUpload();
		
		Thread.sleep(1000);
		du.GSTRegistrationCertificateDOCSelected();
		
		Thread.sleep(5000);		
//		Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
		
		Runtime runtimeee = Runtime.getRuntime();
		String appletscriptiCommanddd = "tell app \"System Events\"\n" +
		
			"keystroke \"G\" using {command down, shift down}\n" +
			
			"delay 3\n" +
			"keystroke \""+GSTregistrationpath+"\"\n" +
			"delay 3\n" +
			"keystroke return\n" +
			"delay 3\n" +
			"keystroke return\n" +
			"end tell";
		String[] argsss = { "osascript", "-e", appletscriptiCommanddd };
		Process processss = runtimeee.exec(argsss);
		
//		Thread.sleep(15000);
//		du.ProofOfBusinessAddressSubmitButton();
		
		
		
		
		BankAccount ba = new BankAccount(driver);
		
		dynamicWait(10, ba.Bankaccountno);
		ba.BankAccountNumberField("00011020001772");
		
		dynamicWait(10, ba.confirmbankaccountno);
		ba.ConfirmBankAccountNumberField("00011020001772");
		
		dynamicWait(10, ba.IFSC);
		ba.IFSCField("HDFC0000001");
		
		dynamicWait(10, ba.AccountType);
		ba.AccountTypeDropDown();
		
		
		Select Accountype = new Select(driver.findElement(By.xpath("//*[@id=\"mat-select-2\"]")));
		Accountype.selectByIndex(1);
		
		
		dynamicWait(10, ba.Beneficiary);
		ba.BeneficiaryNameField("Test Beneficiary");
		
		
		
		Thread.sleep(2000);
//		du.Upload_DocumentContinueButton();
		
		
		System.out.println("EXAA Flow NON BANKING PreSanction Journey Completed , Thank You...!");
//		driver.quit();
	}
	


}
