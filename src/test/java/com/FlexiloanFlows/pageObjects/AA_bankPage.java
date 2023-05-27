package com.FlexiloanFlows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;

public class AA_bankPage {

	WebDriver ldriver;

	public AA_bankPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public By Tryanothermethiod= By.xpath("/html/body/app-root/div[2]/div[2]/div[1]/div[2]/div/app-account-aggregator/div/div[6]/div/button");
	
	
	
	
	public void TryAnotherMethodButton() throws Exception {
		ldriver.findElement(Tryanothermethiod).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		ldriver.findElement(Tryanothermethiod).click();
	}
}
