package com.FlexiloanFlows.testCases;

import java.io.File;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.FlexiloanFlows.utilities.ReadConfig;

@Test
public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.DefaultFlowURL();
	public String flowAAURL = readconfig.OfferFlowAAURL();
	public String offerEXAAflowURL = readconfig.OfferEXAAFlowURL();
	public String nlpFlowURL = readconfig.NLPflowURL();
	public String StagingLOS = readconfig.stagingLOSurl();
	public String ProductionLOSurl = readconfig.ProductionLOSurl();
	public String ProdNLPflowURL = readconfig.ProdNLPflowURL();
	public String LoanCodeCreationURL = readconfig.LoancodeCreation();
	
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		
		if (browser.equals("chrome")) {
			
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
			System.setProperty("webdriver.chrome.driver", readconfig.ChromePath());
			driver = new ChromeDriver(chromeOptions);
			
//			System.setProperty("webdriver.chrome.driver", readconfig.ChromePath());
//			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.FirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		
	}


//	public void teardown() {
//
//		
//	}
	
	
	
	
	public String randome10string() {
		String generatedstring = RandomStringUtils.randomAlphabetic(10);
		return (generatedstring);
	}
	
	public String randome5string() {
		String generatedstring1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring1);
	}
	
	public static String randome4Num() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	public static String randome9Num() {
		String generatedString3 = RandomStringUtils.randomNumeric(9);
		return (generatedString3);
	}
	
	public static String randome6Num() {
		String generatedString2 = RandomStringUtils.randomNumeric(7);
		return (generatedString2);
	}
	
	public void dynamicWait(int sec , By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	
//	public void CaptureScreenshot2(WebDriver webdriver,String fileWithPath)throws Exception{
//		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//		File DestFile=new File(fileWithPath);
//		FileUtils.copyFile(SrcFile, DestFile);
//	}
//	
//	
//	public static void captureScreenshot1() throws Exception {
//		
//		Calendar cal = Calendar.getInstance();
//		Date time =cal.getTime();
//	
//        String FileName = time.toString().replace(":", "_").replace(" ", "_") + ".png";
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(screenshot, new File("/Users/fllap0221/eclipse-workspace/Automation_FlexiloansFlow/Screenshots/" + FileName));
//    }

}
