package com.FlexiloanFlows.utilities;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Listener class used to generate Extent reports

public class Reporting extends TestListenerAdapter
{
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public static WebDriver driver;


	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("dd:MM:yyyy HH:mm").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";

		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/ExtentReports/"+repName);//specify location of the report
		
		try 
		{
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		} 
		catch (IOException e) 
		{
		
			e.printStackTrace();
		}

		extent=new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","Staging-QA");
		extent.setSystemInfo("user","Aditya");

		htmlReporter.config().setDocumentTitle("EXAA Flow"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
//		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		
	}

	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the failed information to the report with GREEN color highlighted
		
	}

	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}

