package com.FlexiloanFlows.testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.FlexiloanFlows.pageObjects.AA_bankPage;
import com.FlexiloanFlows.pageObjects.Bank_Statement;
import com.FlexiloanFlows.pageObjects.DocumentUpload;
import com.FlexiloanFlows.pageObjects.FormFive;
import com.FlexiloanFlows.pageObjects.FormFour;
import com.FlexiloanFlows.pageObjects.FormOne;
import com.FlexiloanFlows.pageObjects.FormThree;
import com.FlexiloanFlows.pageObjects.FormTwo;
import com.FlexiloanFlows.pageObjects.LandingPage;
import com.FlexiloanFlows.pageObjects.OTPPage;
import com.FlexiloanFlows.pageObjects.OfferlandingPage;

public class AA_Flow extends BaseClass {

	String random4no = randome4Num();
	String randome6no = randome6Num();
	String random9no = randome9Num();
	String ranom10charcters = randome10string();
	String ranom5charcters = randome5string();
	String a = "1" + random9no; // Enter Mobile number
	String b = "1" + random4no; // Enter monthly sales
	String c = "A" + randome6no + "@gmail.com"; // enter email field
	String pan = ranom5charcters + random4no + "B";

	String filepath = "/Users/fllap0221/Downloads/HDFCBankstatement.PDF";
	String pancardpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/PANCARDAutomation.jpeg";
	String Aadharcardpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/AadharcardAutomation.jpeg";
	String GSTregistrationpath = "/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Documents/GSTRegistrationCertificateAutomation.png";

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Test(priority = 0)
	public void OfferlandinaagPage() throws Exception {

		driver.get(flowAAURL);

		Thread.sleep(1000);

		OfferlandingPage olp = new OfferlandingPage(driver);

		olp.EnterMobileNumberField(a);
		System.out.println(a);

		Thread.sleep(1000);
		olp.GetStartedButton();

	}

	@Test(priority = 1)
	public void FormOne() throws Exception {

		Thread.sleep(6000);

		FormOne fo = new FormOne(driver);

		fo.MonthalySalesField(b);

		Thread.sleep(1000);
		fo.GstYES();

		Thread.sleep(1000);
		fo.Form1ContinueButton();

		Thread.sleep(5000);

	}
	
	@Test(priority = 2)
	public void NewAAfields() throws Exception{
		
		FormTwo f2 = new FormTwo(driver);
		Thread.sleep(1000);
		
		f2.flowAANEWFullNameField("TestAutomation");
		
		Thread.sleep(2000);
		f2.flowAANEWEmailField(c);
		
		Thread.sleep(1000);
		f2.Form2ContinueButton();
		
	}
	
	@Test(priority = 3)
	public void AABankpage() throws Exception{
		
		Thread.sleep(3000);
		
		AA_bankPage aa = new AA_bankPage(driver);
		dynamicWait(10, aa.Tryanothermethiod );
		Thread.sleep(1000);
		aa.TryAnotherMethodButton();
	}

	@Test(priority = 4)
	public void bank_statement() throws Exception{
		
		Thread.sleep(5000);
		
		
		Bank_Statement bs = new Bank_Statement(driver);
		
		bs.UploadManually();
		
//		WebElement test = driver.findElement(By.xpath("//*[@class=\"btn upload-btn-desktop ng-star-inserted\"]"));
//		test.sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(4000);
		
		WebElement button = driver.findElement(By.xpath("//*[@class=\"btn upload-btn-desktop ng-star-inserted\"]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", button);
		
		Thread.sleep(4000);
		
		bs.ChooseDocumentPopUpWindowButton();
		
		Thread.sleep(3000);
		
//		Runtime.getRuntime().exec("osascript "+"/Users/fllap0221/Documents/upload.scpt");
	
		
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
		
	}
	
	@Test(priority = 5)
	public void FormTwo2() throws Exception{
		
		Thread.sleep(4000);
		
		FormTwo f2 = new FormTwo(driver);
		
		f2.FlowAAloanamountField(randome6no);
		
		Thread.sleep(2000);
		f2.YouAreBusinessMANCheckBoX();
		
//		f2.flowAAFullNameField("TestApplication");
//		f2.flowAAEmailIdField(c);
		
		Thread.sleep(1000);
		f2.Form2ContinueButton();
		
	}
	@Test(priority = 6)
	public void FormThree3() throws Exception{
		
		Thread.sleep(5000); 		 
		
		FormThree f3 =new  FormThree(driver);
		
		f3.GenderMale();
		Thread.sleep(1000);
		
		f3.FlowAADOB("03121993");
		Thread.sleep(1000);
		
		f3.FlowAAResidencPinCode("400001");
		Thread.sleep(1000);
		
		WebElement t1 = driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]"));
		t1.sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		
		WebElement l = driver.findElement(By.xpath("//*[@id=\"field4\"]/div/div/div[1]/label/span[2]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", l);
		
		Thread.sleep(1000);
		
		f3.FlowAABusinesRegisteriProprietorship();
		
		Thread.sleep(1000);
		
		f3.FormThressContinueButton();	
		
	}
	
	@Test(priority = 7)
	public void FormFour4() throws Exception{
		
		Thread.sleep(5000);
		
		FormFour f4 =new  FormFour(driver);
		
		f4.FlowAAPanField(pan);
		Thread.sleep(1000);
		
		f4.FlowAABusinessPinCodeField("400001");
		Thread.sleep(1000);
		
		WebElement t2 = driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]"));
		t2.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		
		f4.FlowAAResidencRentedNO();
		Thread.sleep(2000);

		f4.FlowAABusinessRentedNO();
		Thread.sleep(2000);
		
		f4.FlowAAHowYourldurBusinessMoreThan5Year();
		Thread.sleep(1000);
		
		f4.Form4ContinueButton();
				
	}
	
	@Test(priority = 8)
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
		f5.FlowAABusinessNameField(ranom5charcters);
		
		Thread.sleep(1000);
		f5.FlowAABusinessStreetAddress(ranom5charcters);
		
		Thread.sleep(1000);
		f5.FlowAABusinessAreaLocalityVillege(ranom5charcters);
		
		Thread.sleep(1000);
		f5.FlowAAResedentialStreetAddress(ranom5charcters);
		
		Thread.sleep(1000);
		f5.FlowAAResedentialAreaLocalityVillege(ranom5charcters);
		
		Thread.sleep(1000);
		f5.FormFiveContinueButton();
		
	}
	
	@Test(priority = 9)
	public void Upload_document() throws Exception{
		
		Thread.sleep(5000);
		
		DocumentUpload du = new DocumentUpload(driver);
		
		String parent = driver.getWindowHandle();
		
//		System.out.println("Parent Tab :" +parent);
		
		Thread.sleep(2000);
		du.Upload_DocumentContinueButton();   //Check from here for digilocker
		
		Thread.sleep(2000);
		
		WebDriver newtab = driver.switchTo().newWindow(WindowType.TAB);
		
		String child = driver.getWindowHandle();
		
//		System.out.println("Parent Tab :" +child);
		
		newtab.getCurrentUrl();
		
		System.out.println("redirect to digilocker");
		
		Thread.sleep(3000);
		
		newtab.close();
		
		driver.switchTo().window(parent);
		
		
		Thread.sleep(3000);
		
		System.out.println("Manual document upload starting ");
		
//		WebElement scroll = driver.findElement(By.xpath(""));
//		scroll.sendKeys(Keys.PAGE_DOWN);
		
//		du.UploadDocumentLink();
		
		Thread.sleep(3000);
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
		
//		WebElement scroll2 = driver.findElement(By.xpath(""));
//		scroll2.sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
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
		
//		Thread.sleep(2000);
		
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
		
		Thread.sleep(15000);
		du.ProofOfBusinessAddressSubmitButton();
		
//		du.Upload_DocumentContinueButton();   // remove submit button
		
		
		
		// DB Conn Started
		
		Thread.sleep(10000);
		String dbUrl = "jdbc:mysql://13.233.13.169:3306/flexiloans_staging_db";
		String username = "aniruddha_gonjare";
		String password = "Sukiotroo9oRjtreert9384";
		String query = "select loan_code , customer_code from loan_applicant_detail where mobile_no =" +a+ " order by updated_time desc;";
	
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(dbUrl, username, password);
		
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			String a = rs.getString(1);
			String b = rs.getString(2);
			System.out.println("Loan Code = "+a+"  "+"Customer Code = "+b);
		}
		con.close();
		
		System.out.println("AA Flow PreSanction Journey Completed , Thank You...!");
		driver.quit();
	}

}
