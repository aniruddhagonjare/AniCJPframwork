package com.FlexiloanFlows.testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.FlexiloanFlows.pageObjects.StagingLOS;
import com.FlexiloanFlows.utilities.ReadConfig;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestScript extends BaseClass{
	
	ReadConfig readconfig = new ReadConfig();
	
		@Test
		public void closeloancodefromLOS() throws Exception {  
		
		driver.get(ProductionLOSurl);  //ProductionLOSurl  //StagingLOS
		
		StagingLOS slos = new StagingLOS(driver);
	
		dynamicWait(10, slos.signinwithflexiloanemialid);
		slos.SignInithFlexiloanEmailIdCLICK();
		
		
		Set windows = driver.getWindowHandles();
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
		driver.navigate().to("https://leads.flexiloans.com/applications/"+"642527ddxkzfb");
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"applicationDetailsPage\"]/div/div/div[3]/div/div/button[4]")).click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"selectStatusTwo\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"selectStatusTwo\"]/option[2]")).click();
		
		Thread.sleep(2000);
		Runtime runtime = Runtime.getRuntime();
		String appletscriptiCommand = "tell app \"System Events\"\n" +
		
			"delay 3\n" +
			"keystroke return\n" +
			"end tell";
		
		String[] args = { "osascript", "-e", appletscriptiCommand };
		Process process = runtime.exec(args);
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"selectStatusThree\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"selectStatusThree\"]/option[5]")).click();
		
		Thread.sleep(2000);
		Runtime runtimee = Runtime.getRuntime();
		String appletscriptiCommandd = "tell app \"System Events\"\n" +
		
			"delay 3\n" +
			"keystroke return\n" +
			"end tell";
		
		String[] argss = { "osascript", "-e", appletscriptiCommandd };
		Process processs = runtimee.exec(argss);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/button[1]")).click();
		
		System.out.println("Loan code deleted success");
		
		
	}
	
	
		
//		public void GETAPITESTING() {
//			
//			//Specify API URL
//			RestAssured.baseURI="https://console-staging.flexiloans.com/policy/check-policies/6405858120uz0";
//			
//			//Request object
//			RequestSpecification httpRequest = RestAssured.given();
//			
//			//Response object
//			Response response = httpRequest.request(Method.GET,"/6405858120uz0");
//		
//			//Print response in console 
//			String responseStroninStringFromat = response.getBody().asString();
//			
//			//Print response in console in string format
//			System.out.println(" Response in String format :- " +responseStroninStringFromat);
//			
//			
//		}
	

}
