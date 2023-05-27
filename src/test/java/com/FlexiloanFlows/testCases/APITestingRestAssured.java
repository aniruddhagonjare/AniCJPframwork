package com.FlexiloanFlows.testCases;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class APITestingRestAssured {
	
	
	@Test
	public void POSTAPITESTING() {
	
		
		RestAssured.baseURI="https://console-staging.flexiloans.com/offers/v1/loan-application/6405b5f4r8dyy/loan/offers";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object BODY
		
		JSONObject requestparameter = new JSONObject();
		
		requestparameter.put("policy", "DIRECT");
		requestparameter.put("offered_min_cap_amount", "300000");
		requestparameter.put("offered_max_cap_amount", "400000");
		requestparameter.put("offered_min_cap_tenure", "18");
		requestparameter.put("offered_max_cap_tenure", "18");
		requestparameter.put("offered_min_cap_roi", "5");
		requestparameter.put("offered_max_cap_roi", "5");
		requestparameter.put("pf_charges", "0");
		requestparameter.put("tenure_units", "18");
		requestparameter.put("tenure_type", "Months");
		
		httpRequest.header("content-Type","application/json");
		
		httpRequest.body(requestparameter.toString());
		
		
		Response response = httpRequest.request(Method.POST);
		
		
	
		//Print response in console 
		String responseStroninStringFromat = response.getBody().asString();
		
		//Print response in console in string format
		System.out.println(" Response in String format :- " +responseStroninStringFromat);
		
		//Status code validation
		
		int statuscode = response.getStatusCode();
		System.out.println("Status Code = "+statuscode);
		Assert.assertEquals(statuscode, 200);
	
	
		String sucess = response.jsonPath().get("success");
		Assert.assertEquals(sucess, "true");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public void GETAPITESTING() {
		
		//Specify API URL
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/Pune");
	
		//Print response in console 
		String responseStroninStringFromat = response.getBody().asString();
		
		//Print response in console in string format
		System.out.println(" Response in String format :- " +responseStroninStringFromat);
		
		//Status code validation
		
		int statuscode = response.getStatusCode();
		System.out.println("Status Code = "+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "200OK");
		
		
		
	}
	

}
