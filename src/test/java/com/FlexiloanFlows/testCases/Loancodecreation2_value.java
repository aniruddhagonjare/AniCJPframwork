package com.FlexiloanFlows.testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.FlexiloanFlows.pageObjects.AA_bankPage;
import com.FlexiloanFlows.pageObjects.Bank_Statement;
import com.FlexiloanFlows.pageObjects.DocumentUpload;
import com.FlexiloanFlows.pageObjects.FormFive;
import com.FlexiloanFlows.pageObjects.FormFour;
import com.FlexiloanFlows.pageObjects.FormOne;
import com.FlexiloanFlows.pageObjects.FormThree;
import com.FlexiloanFlows.pageObjects.FormTwo;
import com.FlexiloanFlows.pageObjects.Loancodecreation;
import com.FlexiloanFlows.pageObjects.OTPPage;
import com.FlexiloanFlows.pageObjects.OfferlandingPage;
import com.FlexiloanFlows.pageObjects.StagingLOS;
import com.google.common.collect.RowSortedTable;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class Loancodecreation2_value extends BaseClass{
	
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
	
	String Loancode = null;
	String mobilenumber = null;
	
	
	@Test(priority = 0)
	public void openLoancreatio() throws Exception {
		
		driver.get(LoanCodeCreationURL);
		
		Loancodecreation Lc = new Loancodecreation(driver);
		
		Thread.sleep(2000);
		
		Select loancodeselect = new Select(driver.findElement(By.xpath("//*[@id=\"script\"]")));
		loancodeselect.selectByIndex(1);
//		WebElement o = loancodeselect.getFirstSelectedOption();
		
		
		dynamicWait(10, Lc.RunScriptButton);
		Lc.RunScriptButton();
		
		Thread.sleep(10000);
		
//		List<WebElement> NoOfcolumn = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered')]//th"));
//		System.out.println(NoOfcolumn.size());
		
		
		List<WebElement>  loancode= driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[2]/div/table/tbody//td[2]"));
//		System.out.println(loancode.size());
		
		List<WebElement>  MobileNo= driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[2]/div/table/tbody//td[3]"));
//		System.out.println(MobileNo.size());
		
		
		for (WebElement loancodee :  loancode ) {
			Loancode = new String();
			Loancode=loancodee.getText(); // Copy loan code from loan code creation
		}
		System.out.println("Generated Loan Code :- "+Loancode);
		
		
		
		for (WebElement mob1 :  MobileNo ) {
//			System.out.println(mob1.getText());       
			mobilenumber = new String();
			mobilenumber=mob1.getText();  // Copy Mobile number from loan code creation
		}
		System.out.println("Generated Mobile number :- "+mobilenumber);
		
		driver.navigate().to(offerEXAAflowURL);
		
		
		// landing page
		OfferlandingPage Olp = new OfferlandingPage(driver);
		
		dynamicWait(10, Olp.mob);
		Olp.EnterMobileNumberField(mobilenumber);
		
		dynamicWait(10, Olp.getstartedsubmitbuton);
		Olp.GetStartedButton();
		
		
		// DB Connection
		
		Thread.sleep(10000);
		
		String dbUrl = "jdbc:mysql://13.233.13.169:3306/flexiloans_staging_db";
		String username = "aniruddha_gonjare";
		String password = "Sukiotroo9oRjtreert9384";
		String query = "select otp from flexiloans_staging_db.otp_user where mobile_no=" +mobilenumber+ " order by verification_time desc;";
	
		
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
		
	}
		 
		
		
		@Test(priority = 1)
		public void FormFour4() throws Exception{
			
			Thread.sleep(350000);   //Not change this Sleep
			System.out.println("Start flow further");
			
			FormFour f4 =new  FormFour(driver);
			dynamicWait(10, f4.businesspincodee);
			
			f4.WhatIsYourBusinessPinCodeField("400001");
			dynamicWait(10, f4.residencerented);
			
			f4.ResidenceRentedCheckBOXNO();
			dynamicWait(10, f4.businessrented);

			f4.BusinessRentedCheckBOXNO();
			
			Thread.sleep(1000);
			f4.Form4ContinueButton();
			
			
			Thread.sleep(3000);
			AA_bankPage aa= new AA_bankPage(driver);
			
			Thread.sleep(2000);
			
			aa.TryAnotherMethodButton();		
		}
		
		@Test(priority = 2)
		public void bank_statement() throws Exception{
			
			Thread.sleep(5000);
			
			
			Bank_Statement bs = new Bank_Statement(driver);
			
			bs.UploadManually();
			
			Thread.sleep(4000);
			
			WebElement button = driver.findElement(By.xpath("//*[@class=\"btn upload-btn-desktop ng-star-inserted\"]"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", button);
			
			Thread.sleep(4000);
			
			bs.ChooseDocumentPopUpWindowButton();
			
			Thread.sleep(3000);
			
//			Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
		
			
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
			
			
			Thread.sleep(5000);
			FormFour fo4 =new  FormFour(driver);	
			
			WebElement test = driver.findElement(By.xpath("//*[@id='mat-input-1']"));
			test.sendKeys(Keys.PAGE_DOWN);
			
			
			Thread.sleep(1000);
			fo4.HowOldYourBusineessMoreThan5Year();
			
			Thread.sleep(1000);
			fo4.Form4ContinueButton();
			
		}
		

		@Test(priority = 3)
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
			f5.WhatIsYourBusinessName(ranom5charcters);
			
			Thread.sleep(1000);
			f5.BusinessAddressShopNumberStreetname(ranom5charcters);
			
			Thread.sleep(1000);
			f5.BusinessAddressAreaLocalityVillege(ranom5charcters);
			
			Thread.sleep(1000);
			f5.ResidentialAddressStreetNameShopNumber(ranom5charcters);
			
			Thread.sleep(1000);
			f5.ResidentialAddressAreLocalityVillege(ranom5charcters);
			
			Thread.sleep(1000);
			f5.FormFiveContinueButton();
			
		}
		
		
		@Test(priority = 4)
		public void Upload_document() throws Exception{
			
			Thread.sleep(5000);
			
			DocumentUpload du = new DocumentUpload(driver);
			
			Thread.sleep(2000);
			du.Upload_DocumentContinueButton();   //Check from here for digilocker
			
//		Digilocker url		https://accounts.digitallocker.gov.in/oauth_partner/register/%252Foauth2%252F1%252Fconsent%253Fresponse_type%253Dcode%2526client_id%253DB7481010%2526state%253D63226c23-4cf0-4187-8f33-caa32954b35c%2526orgid%253D003889%2526txn%253D63eb8dcdb0204oauth21676381645%2526hashkey%253De33891f0c1ee4e32f67aa7e3d11dfe110e882ea5bd8a330d51986eac3056bfa9%2526requst_pdf%253DN%2526app_name%253DRGlnaXRhbCBPbmJvYXJkaW5n%2526disable_userpwd_login%253D1%2526aadhaar_only%253DY%2526partner_name%253DQmFsZG9yIFRlY2hub2xvZ2llcyBQcml2YXRlIExpbWl0ZWQ%25253D%2526authMode%253DO
		
			// Start Digilocker redirection code
			
			Thread.sleep(2000);
			
			String parent = driver.getWindowHandle();
			
//			System.out.println("Parent Tab :" +parent);
			
			Thread.sleep(2000);
			
			WebDriver newtab = driver.switchTo().newWindow(WindowType.TAB);
			
			String child = driver.getWindowHandle();
			
//			System.out.println("Parent Tab :" +child);
			
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
//			Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
			
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
//			Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
			
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
			
			
//			WebElement scroll3 = driver.findElement(By.xpath("//*[@class='mat-focus-indicator button-style button-width button-rounded width-100 mat-flat-button mat-button-base mat-primary ng-star-inserted']"));
//			scroll3.sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			
			du.ProofOfBusinessAddressUpload();
			
			Thread.sleep(1000);
			du.GSTRegistrationCertificateDOCSelected();
			
			Thread.sleep(5000);		
//			Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
			
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
			
			Thread.sleep(15000);
			du.ProofOfBusinessAddressSubmitButton();
			
			Thread.sleep(10000);
			
		}
//			Thread.sleep(5000);
//			du.Upload_DocumentContinueButton();
			
			@Test(priority = 5)
			public void ClosLoancode() throws Exception{
				
				
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
				System.setProperty("webdriver.chrome.driver", readconfig.ChromePath());
				driver = new ChromeDriver(chromeOptions);
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				
				driver.get("https://leads-staging.flexiloans.com/");
				
//				driver.get(StagingLOS);
				
				StagingLOS slos = new StagingLOS(driver);
			
				dynamicWait(10, slos.signinwithflexiloanemialid);
				slos.SignInithFlexiloanEmailIdCLICK();
				
				
				Set<String> windows = driver.getWindowHandles();
				Iterator<String> it = windows.iterator();
				String p = it.next();
				String c = it.next();
				driver.switchTo().window(c);
				
				Thread.sleep(2000);
				
				dynamicWait(10, slos.emaildusername);
				slos.EmaildUserName("aniruddha.gonjare@flexiloans.com");
				
				dynamicWait(10, slos.emailnextbtn);
				slos.EmailNextBUTTON();
				
				dynamicWait(10, slos.emailpass);
				slos.EmaildPassword("aniruddhaG@1995");
				
				dynamicWait(10, slos.passnextbtn1);
				slos.PassNextBUTTON();
				
				Thread.sleep(8000);
				driver.switchTo().window(p);
				
				Thread.sleep(8000);
				driver.navigate().to("https://leads-staging.flexiloans.com/applications/"+Loancode);
				
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"applicationDetailsPage\"]/div/div/div[3]/div/div/button[4]")).click();
				
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectStatusTwo\"]")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectStatusTwo\"]/option[2]")).click();
				
				Thread.sleep(2000);
				Runtime runtimew = Runtime.getRuntime();
				String appletscriptiCommandw = "tell app \"System Events\"\n" +
				
					"delay 3\n" +
					"keystroke return\n" +
					"end tell";
				
				String[] argsw = { "osascript", "-e", appletscriptiCommandw };
				Process processw = runtimew.exec(argsw);
				
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectStatusThree\"]")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectStatusThree\"]/option[5]")).click();
				
				Thread.sleep(2000);
				Runtime runtimees = Runtime.getRuntime();
				String appletscriptiCommandds = "tell app \"System Events\"\n" +
				
					"delay 3\n" +
					"keystroke return\n" +
					"end tell";
				
				String[] argssd = { "osascript", "-e", appletscriptiCommandds };
				Process processsd = runtimees.exec(argssd);
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/button[1]")).click();
				
				Thread.sleep(2000);
				System.out.println("Loan code deleted successfully");
				driver.quit();
				//loan code closed done
				
			}
			
}
