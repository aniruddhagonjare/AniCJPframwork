package com.FlexiloanFlows.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
			
			try {
				
				FileInputStream fis=new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			}catch(Exception e) {
				System.out.println("Exception is " + e.getMessage());
			}
			
		}
	
	public String DefaultFlowURL() {
		String url = pro.getProperty("DefaultURL");
		return url;
	}
	
	public String OfferFlowAAURL() {
		String aaurl = pro.getProperty("OfferflowAAURL");
		return aaurl;
	}
	
	public String OfferEXAAFlowURL() {
		String aaurl = pro.getProperty("offerexaaflowURL");
		return aaurl;
	}
	
	public String ChromePath() {
		String chromepat = pro.getProperty("chromepath");
		return chromepat;
	}
	
	public String FirefoxPath() {
		String firfoxpat = pro.getProperty("firefoxpath");
		return firfoxpat;
	}
	
	public String NLPflowURL() {
		String nlpflowurl = pro.getProperty("nlpflowURL");
		return nlpflowurl;
	}
	
	public String stagingLOSurl() {
		String LOSURl = pro.getProperty("StagingLOS");
		return LOSURl;
	}
	
	public String ProductionLOSurl() {
		String prodLOSURl = pro.getProperty("ProductionLOSurl");
		return prodLOSURl;
	}
	
	public String ProdNLPflowURL() {
		String ProdnlpflowURL = pro.getProperty("ProdnlpflowURL");
		return ProdnlpflowURL;
	}
	
	public String LoancodeCreation() {
		String LoanCodeCreation = pro.getProperty("LoancodeCreation");
		return LoanCodeCreation;
	}
	
}

