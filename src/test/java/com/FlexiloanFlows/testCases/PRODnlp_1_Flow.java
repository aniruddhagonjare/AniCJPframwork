package com.FlexiloanFlows.testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.FlexiloanFlows.pageObjects.AA_bankPage;
import com.FlexiloanFlows.pageObjects.Bank_Statement;
import com.FlexiloanFlows.pageObjects.DocumentUpload;
import com.FlexiloanFlows.pageObjects.FormFive;
import com.FlexiloanFlows.pageObjects.FormFour;
import com.FlexiloanFlows.pageObjects.FormThree;
import com.FlexiloanFlows.pageObjects.FormTwo;
import com.FlexiloanFlows.pageObjects.LandingPage;
import com.FlexiloanFlows.pageObjects.OTPPage;
import com.FlexiloanFlows.pageObjects.StagingLOS;

public class PRODnlp_1_Flow extends BaseClass{
	
	
	String random4no = randome4Num();
	String randome6no = randome6Num();
	String random9no = randome9Num();
	String ranom10charcters = randome10string();
	String ranom5charcters = randome5string();
	String a = "600000" + random4no; // Enter Mobile number
	String b = "1" + random4no; // Enter monthly sales
	String name = "A"+ranom5charcters; // Enter name
	String emailid = "A" + randome6no + "@gmail.com"; // enter email field
	String pan = ranom5charcters + random4no + "B";

	String filepath = "/Users/fllap0221/Downloads/HDFCBankstatement.PDF";
	String pancardpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/PANCARDAutomation.jpeg";
	String Aadharcardpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/AadharcardAutomation.jpeg";
	String GSTregistrationpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/GSTRegistrationCertificateAutomation.png";

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Create object of Classes
	EXAA_Flow exaa = new EXAA_Flow();
	AA_Flow aa = new AA_Flow();
	
	@Test
	public void landingpage() throws Exception{

			driver.get(ProdNLPflowURL); //nlpFlowURL // ProdNLPflowURL
			
			LandingPage lp = new LandingPage(driver);
			dynamicWait(10, lp.nlpmobilenumberfield);
			
			lp.NLPMobileNumberField("6000000053"); 
			
			
			Thread.sleep(1000);
			WebElement l = driver.findElement(By.xpath("//*[@id=\"mobile-no\"]"));
			String mobileno = l.getAttribute("value");
		    System.out.println("Mobile number : " +mobileno);
		    
		    
			dynamicWait(10, lp.nlpaveragemonthlysalesdropdown);
			
			Thread.sleep(2000);
			Select monthlysal = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/select")));
			monthlysal.selectByIndex(3);
			WebElement o = monthlysal.getFirstSelectedOption();
		    String GSTselectedoption = o.getText();
		    System.out.println("Selected Monthly sale : " + GSTselectedoption);
			
		
			lp.NLPGSTYESCheckBox();
			dynamicWait(10, lp.nlpGstYES);
			
			lp.NLPCheckLoanEligibilityButton();
			
			Thread.sleep(15000);
			driver.navigate().refresh();
				
			
			if(GSTselectedoption.equals("less than 2 lakhs")) {
				System.out.println("redirect to form 2");
				
				
				Thread.sleep(12000);
				
				String dbUrl = "jdbc:mysql://13.233.13.169:3306/flexiloans_staging_db";
				String username = "aniruddha_gonjare";
				String password = "Sukiotroo9oRjtreert9384";
				String query = "select otp from flexiloans_staging_db.otp_user where mobile_no=" +a+ " order by verification_time desc;";
			
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection(dbUrl, username, password);
				
				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					
					String otp =rs.getString(1);
					System.out.println("OTP =" +otp);
					
					driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(otp);
				}
				con.close();
				
				
				OTPPage ot = new OTPPage(driver);
				dynamicWait(10,ot.nlpotpverifybtn);
				ot.nlpOTPVerifyButton();
			
				System.out.println("OTP fetched & Go to form 2");
				
				
				
				
				FormTwo f2 = new FormTwo(driver);
				
				dynamicWait(10, f2.nlpLessThan2LacLoanamt);
				driver.findElement(By.xpath("//*[@id='mat-input-1']")).clear();
				
				Thread.sleep(1000);
				dynamicWait(10, f2.nlpLessThan2LacLoanamt);
				f2.NLPLessThan2LacLoanamtFIELD("450000");
				
				dynamicWait(10, f2.nlpLessThan2Lacyouarebusinessman);
				f2.NLPLessThan2LacYouAreBusinessMan();
				
				dynamicWait(10, f2.nlpLessThan2Lacfullname);
				f2.NLPLessThan2LacFULLNAMEFIELD("TestAutomation");
				
				dynamicWait(10, f2.nlpLessThan2LacEmail);
				f2.NLPLessThan2LacEmailFIELD(emailid);
				
				dynamicWait(10, f2.nlpLessThan2Lacdateofincorporation);
				f2.NLPLessThan2LacdDATEOFINCORPORATIONFIELD("10032012");
				
				dynamicWait(10, f2.nlpLessThan2LacbusinessregPropritership);
				f2.NLPLessThan2LacbusinessregPROPEITERSHIPBOX();
				
				f2.Form2ContinueButton();
				
				Thread.sleep(120000);
				
				
				
				FormThree f3 = new FormThree(driver);
				
				Thread.sleep(13000); 
				
				dynamicWait(10, f3.nlplessthan2lacGendermale);
				f3.NLPlessthan2lacGENDERMALE();
				
				
				dynamicWait(10, f3.nlpless2lacdob);
				f3.NLPless2lacDOBFIELD("02021990");
				
				dynamicWait(10, f3.nlpless2lacresidencepincode);
				f3.NLPless2lacResdencePINCODE("400001");
				
				WebElement scroll3 = driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]"));
				scroll3.sendKeys(Keys.PAGE_DOWN);
				
				Thread.sleep(1000);
				dynamicWait(10, f3.nlpless2laccurrentaccyes);
				f3.NLPless2lacCURRENTACCOUNTYES();
				
				dynamicWait(10, f3.nlpless2lacresidencepincode);
				f3.NLPless2lacPANFIELD(pan);
				
				f3.FormThressContinueButton();
				
				
				FormFour f4 = new FormFour(driver);
				
				dynamicWait(10, f4.nlplessthanbusinesspincode);
				f4.NLPlessthanBusinessPINCODE("400001");
				
//				Thread.sleep(1000);
				dynamicWait(10, f4.nlplessthanresidencerentedno);
				f4.NLPlessthanResidenceRENTEDNO();
				
				dynamicWait(10, f4.nlplessthanbusinessrentedno);
				f4.NLPlessthanBusinessRENTEDNO();
				
				f4.Form4ContinueButton();
				
				
				AA_Flow aa = new AA_Flow();
				
				aa.AABankpage();
				Thread.sleep(2000);
				aa.bank_statement();
				
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys(Keys.PAGE_DOWN);
				
				Thread.sleep(1000);
				dynamicWait(10, f4.nlplesssthanhowoldisurbusinessmorethan5yr);
				f4.NLPlessthanHowOldYourusinessMORETHAN5YEAR();
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-step4/div[2]/dynamic-form/div/form/div[5]/div/button")).click();
				
				
				
				
				FormFive f5 = new FormFive(driver);
				
				dynamicWait(10, f5.nlplessthanatureofBusinessWholesaler);
				f5.NLPlessthanatureofBusinessWHOLESALER();
				
				Thread.sleep(1500);
				dynamicWait(10, f5.NLPlessthaProductYouyouSelldropdownField);
				f5.NLPlessthaProductYouyouSellDROPDOWNField();
				
				Thread.sleep(1000);
				dynamicWait(10, f5.NLPlessthaPopUpwindowsearchsield);
				f5.NLPlessthaPopUpwindowSEARCHFIELDS("Alu");
				
				dynamicWait(10, f5.NLPlessthaPopupwindowdsasearchenter);
				f5.NLPlessthaPopupwindowdsaSEARCHENTERALU();
				
				dynamicWait(10, f5.NLPlessthaPopupwindowproductSubmitbtn);
				f5.NLPlessthaPopupwindowproductSUBMITBUTTON();
				
				Thread.sleep(1000);
				dynamicWait(10, f5.NLPlessthaBusinessField);
				f5.NLPlessthaBUSINESSField("Test business");
				
				dynamicWait(10, f5.nlplessthabusinessaddressshopnumber);
				f5.nlplessthaBUSINESSaddressSHOPNUMBER("101 , Om plaza");
				
				dynamicWait(10, f5.nlplessthabusinessaddressArea);
				f5.nlplessthaBUSINESSAddressAREA("Test Area");
				
				dynamicWait(10, f5.nlplesstharesidenceaddressFlatno);
				f5.nlplessthaRESIDENCEaddressFLATNO("B402 , test");
				
				dynamicWait(10, f5.nlplesstharesidenceaddressArea);
				f5.nlplessthaRESIDENCEaddressAREA("Test Area");
				
				Thread.sleep(1000);
				f5.FormFiveContinueButton();
				
				
				
				
				
				
				
				Thread.sleep(8000);
				
				DocumentUpload du = new DocumentUpload(driver);
				
				String parent = driver.getWindowHandle();
				
//				System.out.println("Parent Tab :" +parent);
				
				Thread.sleep(2000);
				du.Upload_DocumentContinueButton();   //Check from here for digilocker
				
				Thread.sleep(2000);
				
				WebDriver newtab = driver.switchTo().newWindow(WindowType.TAB);
				
				String child = driver.getWindowHandle();
				
//				System.out.println("Parent Tab :" +child);
				
				newtab.getCurrentUrl();
				
				Thread.sleep(3000);
				
				newtab.close();
				
				driver.switchTo().window(parent);
				
				
				Thread.sleep(3000);
				
//				WebElement scroll = driver.findElement(By.xpath(""));
//				scroll.sendKeys(Keys.PAGE_DOWN);
				
//				du.UploadDocumentLink();
				
				Thread.sleep(3000);
				WebElement scroll1 = driver.findElement(By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[3]/div/div[1]/div/div[4]/div/div/button"));
				scroll1.sendKeys(Keys.PAGE_DOWN);
				
				Thread.sleep(5000);
				du.PANCARDUploadButton();
				
				Thread.sleep(1000);
				du.PANCARDDOCSelected();
				
				Thread.sleep(5000);
//				Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
				
				Runtime rntime = Runtime.getRuntime();
				String appletscriptiCommandd = "tell app \"System Events\"\n" +
				
					"keystroke \"G\" using {command down, shift down}\n" +
					
					"delay 3\n" +
					"keystroke \""+pancardpath+"\"\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"end tell";
				String[] argss = { "osascript", "-e", appletscriptiCommandd };
				Process processs = rntime.exec(argss);
			
				Thread.sleep(15000);
				du.PANCARDSubmitButton();
				
				Thread.sleep(8000);
				
//				WebElement scroll2 = driver.findElement(By.xpath(""));
//				scroll2.sendKeys(Keys.PAGE_DOWN);
				
				Thread.sleep(2000);
				du.ProofofCurrentResidentialAddressUploadButton();
				
				Thread.sleep(1000);
				du.ProofofCurrentResidentialAddressDOCAadharCardSelected();
				
				Thread.sleep(1000);
				du.AADHARCARDFRONTSIDEIMG();
				
				Thread.sleep(1000);
				du.UploadAadharCardChooseSelect();
				
				Thread.sleep(5000);
//				Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
				
				Runtime runtimee1 = Runtime.getRuntime();
				String appletscriptiCommandd1 = "tell app \"System Events\"\n" +
				
					"keystroke \"G\" using {command down, shift down}\n" +
					
					"delay 3\n" +
					"keystroke \""+Aadharcardpath+"\"\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"end tell";
				String[] argsss = { "osascript", "-e", appletscriptiCommandd1 };
				Process processss = runtimee1.exec(argsss);
				
				
				Thread.sleep(15000);
				du.ProofofcurrentresidentialaddressuploadSubmitButton();
				
				
				
				Thread.sleep(8000);
				
				
//				WebElement scroll3 = driver.findElement(By.xpath("//*[@class='mat-focus-indicator button-style button-width button-rounded width-100 mat-flat-button mat-button-base mat-primary ng-star-inserted']"));
//				scroll3.sendKeys(Keys.PAGE_DOWN);
				
//				Thread.sleep(2000);
				
				du.ProofOfBusinessAddressUpload();
				
				Thread.sleep(1000);
				du.GSTRegistrationCertificateDOCSelected();
				
				Thread.sleep(5000);		
//				Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
				
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
				String[] argsss2 = { "osascript", "-e", appletscriptiCommanddd };
				Process processss1 = runtimeee.exec(argsss2);
				
				Thread.sleep(15000);
				du.ProofOfBusinessAddressSubmitButton();
				
				
				
				// 	DB Conn Started
				
				Thread.sleep(10000);
				String dbUrll = "jdbc:mysql://13.233.13.169:3306/flexiloans_staging_db";
				String usernamee = "aniruddha_gonjare";
				String passwordd = "Sukiotroo9oRjtreert9384";
				String queryy = "select loan_code , customer_code from loan_applicant_detail where mobile_no =" +mobileno+ " order by updated_time desc;";
			
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection conn = DriverManager.getConnection(dbUrll, usernamee, passwordd);
				
				Statement stmtt = conn.createStatement();

				ResultSet rss = stmtt.executeQuery(queryy);

				// While Loop to iterate through all data and print results
				while (rss.next()) {
					String loancode = rss.getString(1);
					String customercode = rss.getString(2);
					System.out.println("Loan Code = "+loancode+"  "+"Customer Code = "+customercode);
				}
				con.close();
				
				System.out.println("Nlp flow (<= 2 lac) completed successfully ");
				driver.quit();
				
				
				
			}else {
				
				System.out.println("Redirect to AA page");
				
				FormTwo f2n = new FormTwo(driver);
				
				dynamicWait(10, f2n.flownlpnewfullnameF);
				f2n.flowNLPNEWFullNameField("TestAutomation");
				
				dynamicWait(10, f2n.flownlpnewEmailF);
				f2n.flowNLPNEWEmailField(emailid);
				
				
				
				f2n.Form2ContinueButton();
				
				
				
				AA_bankPage aa = new AA_bankPage(driver);
				
				dynamicWait(10, aa.Tryanothermethiod);
				
				aa.TryAnotherMethodButton();
				
				Thread.sleep(3000);
				
				Bank_Statement bs = new Bank_Statement(driver);
				
				dynamicWait(10, bs.uploamanually);
				
				bs.UploadManually();
				
				Thread.sleep(4000);
				
				WebElement button = driver.findElement(By.xpath("//*[@class=\"btn upload-btn-desktop ng-star-inserted\"]"));
				JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("arguments[0].click();", button);
				
				Thread.sleep(4000);
				
				bs.ChooseDocumentPopUpWindowButton();
				
				Thread.sleep(3000);
				
//				Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
			
				
				Runtime runtime = Runtime.getRuntime();
				String appletscriptiCommand = "tell app \"System Events\"\n" +
				
					"keystroke \"G\" using {command down, shift down}\n" +
					
					"delay 3\n" +
					"keystroke \""+filepath+"\"\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"delay 3\n" +
					"keystroke tab\n" +
					"delay 2\n" +
					"keystroke tab\n" +
					"delay 2\n" +
					"keystroke tab\n" +
					"delay 2\n" +
					"keystroke return\n" +
					"end tell";
				
				String[] args = { "osascript", "-e", appletscriptiCommand };
				Process process = runtime.exec(args);
				
				
				Thread.sleep(25000);
				Bank_Statement bs1 = new Bank_Statement(driver);
				
				bs1.BankStatementContinueButton();
				Thread.sleep(6000);
				
				
				
				
				
				FormTwo f2= new FormTwo(driver);
				dynamicWait(10, f2.nlpgreaterthan2loanamt);
				
				f2.nlpgreaterthan2loanAmountField("210000");
				
				f2.nlpgreaterthan2businessMANField();
				dynamicWait(10, f2.nlpgreaterthan2businessman);
				
//				f2.nlpgreaterthan2FULLNameField(name);
//				dynamicWait(10, f2.nlpgreaterthan2fullname);
				
//				f2.nlpgreaterthan2EmailIDField(emailid);
//				dynamicWait(10, f2.nlpgreaterthan2emailid);
				
				f2.Form2ContinueButton();
				
				
				
				
				Thread.sleep(3000);
				FormThree f3 = new FormThree(driver);
				
				dynamicWait(10, f3.nlpgreater2lacGendermale);
				f3.nlpgreater2lacGenderMALE();
				
				dynamicWait(10, f3.nlpgreater2lacdob);
				f3.nlpgreater2lacDOBField("03121993");
				
				dynamicWait(10, f3.nlpgreater2lacresidencepincode);
				f3.nlpgreater2lacResidencePincodeFeld("400001");
				
				
				WebElement scroll3 = driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]"));
				scroll3.sendKeys(Keys.PAGE_DOWN);
				
				Thread.sleep(1000);
				dynamicWait(10, f3.nlpgreater2lacCurrentaccYES);
				f3.nlpgreater2lacCurrentAccountYES();
				
				dynamicWait(10, f3.nlpgreater2lacbusinessregPropritership);
				f3.nlpgreater2lacbusinessregPROPRITERSHIP();
				
				f3.FormThressContinueButton();
				
				
				
				
				
				
				FormFour f4 = new FormFour(driver);
	
				dynamicWait(10, f4.flownlPAN);
				f4.FlowNLPPanField(pan);
								
			
				dynamicWait(10, f4.flownlpusinesspincode);
				f4.FlowNLPBusinessPinCodeField("400001");
				
				Thread.sleep(1000);
				WebElement scroll2 = driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]"));
				scroll2.sendKeys(Keys.PAGE_DOWN);
				
				Thread.sleep(1000);
				dynamicWait(10, f4.flownlpresidencerented);
				f4.FlowNLPResidencRentedNO();
				
				Thread.sleep(1000);
				dynamicWait(10, f4.flownlpbusinessrented);
				f4.FlowNLPBusinessRentedNO();
				
				Thread.sleep(1000);
				dynamicWait(10, f4.flownlpHowoldisyourbusiness);
				f4.FlowNLPHowYourldurBusinessMoreThan5Year();
				
				f4.Form4ContinueButton();
				
				
				
				
				FormFive f5 = new FormFive(driver);
				
				dynamicWait(10, f5.nlpnatureofBusinessWholesaler);
				f5.NLPNatureofBusinessWHOSELER();
				
				Thread.sleep(2000);
				dynamicWait(10, f5.NLPProductYouyouSelldropdownField);
				f5.NLPProductyouSellDROPDOWNField();
				
				f5.NLPPopUpwindowSEARCHFIELD("Accou");
				
				Thread.sleep(1000);
				f5.NLPPopupwindowACCENTER();
				
				dynamicWait(10, f5.NLPPopupwindowproductSubmitbtn);
				f5.NLPPOPUPWindowSubmitBUTTON();
				
				dynamicWait(10, f5.NLPBusinessField);
				f5.NLPBUSINESSNAMEField("Test Business");
				
				dynamicWait(10, f5.nlpbusinessaddressshopnumber);
				f5.NLPBusinessAddressSHOPNUMBER("Test Shop no");
				
				dynamicWait(10, f5.nlpbusinessaddressshopnumber);
				f5.NLPBUSINESSADDRESSArea("Test area");
				
				dynamicWait(10, f5.nlpresidenceaddressFlatno);
				f5.NLPRESIDENCEADDRESSFLATNO("Test Flat");
			
				dynamicWait(10, f5.nlpresidenceaddressArea);
				f5.NLPRESIDENCEADDRESSAREA("Test Area");
				
				Thread.sleep(1000);
				f5.FormFiveContinueButton();
				
					
				
//				AA_Flow aaa = new AA_Flow();
//				aaa.Upload_document();
				
				
				
				
				
				Thread.sleep(5000);
				
				DocumentUpload du = new DocumentUpload(driver);
				
				String parent = driver.getWindowHandle();
				
//				System.out.println("Parent Tab :" +parent);
				
				Thread.sleep(2000);
				du.Upload_DocumentContinueButton();   //Check from here for digilocker
				
				Thread.sleep(2000);
				
				WebDriver newtab = driver.switchTo().newWindow(WindowType.TAB);
				
				String child = driver.getWindowHandle();
				
//				System.out.println("Parent Tab :" +child);
				
				newtab.getCurrentUrl();
				
				Thread.sleep(3000);
				
				newtab.close();
				
				driver.switchTo().window(parent);
				
				
				Thread.sleep(3000);
				
//				WebElement scroll = driver.findElement(By.xpath(""));
//				scroll.sendKeys(Keys.PAGE_DOWN);
				
//				du.UploadDocumentLink();
				
				
				
				
//				WebElement scroll1 = driver.findElement(By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-document-upload/div/div[4]/div[3]/div/div[1]/div/div[4]/div/div/button"));
//				scroll1.sendKeys(Keys.PAGE_DOWN);
				
				
				
				Thread.sleep(6000);
				du.ProofofCurrentResidentialAddressUploadButton();
				
				Thread.sleep(1000);
				du.ProofofCurrentResidentialAddressDOCAadharCardSelected();
				
				Thread.sleep(1000);
				du.AADHARCARDFRONTSIDEIMG();
				
				Thread.sleep(1000);
				du.UploadAadharCardChooseSelect();
				
				Thread.sleep(5000);
//				Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
				
				Runtime runtimee1 = Runtime.getRuntime();
				String appletscriptiCommandd1 = "tell app \"System Events\"\n" +
				
					"keystroke \"G\" using {command down, shift down}\n" +
					
					"delay 3\n" +
					"keystroke \""+Aadharcardpath+"\"\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"end tell";
				String[] argsss = { "osascript", "-e", appletscriptiCommandd1 };
				Process processss = runtimee1.exec(argsss);
				
				
				Thread.sleep(15000);
				du.ProofofcurrentresidentialaddressuploadSubmitButton();
				
				
				
				
			
				
				Thread.sleep(10000);
				du.PRODnlp_1flowPANCARDUploadBUTTON();
				
				Thread.sleep(1000);
				du.PANCARDDOCSelected();
			
				Thread.sleep(5000);
//				Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
				
				Runtime rntime = Runtime.getRuntime();
				String appletscriptiCommandd = "tell app \"System Events\"\n" +
				
					"keystroke \"G\" using {command down, shift down}\n" +
					
					"delay 3\n" +
					"keystroke \""+pancardpath+"\"\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"delay 3\n" +
					"keystroke return\n" +
					"end tell";
				String[] argss = { "osascript", "-e", appletscriptiCommandd };
				Process processs = rntime.exec(argss);
			
				Thread.sleep(15000);
				du.PANCARDSubmitButton();
				
				
				
				Thread.sleep(8000);
				
//				WebElement scroll2 = driver.findElement(By.xpath(""));
//				scroll2.sendKeys(Keys.PAGE_DOWN);
				
				
				
//				WebElement scroll3 = driver.findElement(By.xpath("//*[@class='mat-focus-indicator button-style button-width button-rounded width-100 mat-flat-button mat-button-base mat-primary ng-star-inserted']"));
//				scroll3.sendKeys(Keys.PAGE_DOWN);
				
//				Thread.sleep(2000);
				
				du.ProofOfBusinessAddressUpload();
				
				Thread.sleep(1000);
				du.GSTRegistrationCertificateDOCSelected();
				
				Thread.sleep(5000);		
//				Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
				
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
				String[] argsss2 = { "osascript", "-e", appletscriptiCommanddd };
				Process processss1 = runtimeee.exec(argsss2);
				
				Thread.sleep(15000);
				du.ProofOfBusinessAddressSubmitButton();
				
				
				// DB Conn Started
				
				Thread.sleep(12000);
				String dbUrl = "jdbc:mysql://13.233.13.169:3306/flexiloans_aws_prod_db";
				String username = "aniruddha_gonjare";
				String password = "Sukiotroo9oRjtreert9384";
				String query = "select loan_code , customer_code from loan_applicant_detail where mobile_no =" +mobileno+ " order by updated_time desc;";
			
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection(dbUrl, username, password);
				
				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query);

				// While Loop to iterate through all data and print results
				while (rs.next()) {
					String loancode = rs.getString(1);
					String customercode = rs.getString(2);
					System.out.println("Loan Code = "+loancode+"  "+"Customer Code = "+customercode);
					
				}
				con.close();
				
				System.out.println("Nlp flow (=> 2 lac) completed successfully ");
				driver.quit();
		}
						
}
		
}
	


