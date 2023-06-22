package com.qa.reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersTestClass implements ITestListener{
	
	public ExtentHtmlReporter htmlreport;
	public ExtentReports extent;
	public ExtentTest test;

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		try {
			String screenshot=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
			File file=new File(screenshot);
			if (file.exists()) {
				test.fail("screenshot"+test.addScreenCaptureFromPath(screenshot));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		try {
			String screenshot=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
			File file=new File(screenshot);
			if (file.exists()) {
				test.fail("screenshot"+test.addScreenCaptureFromPath(screenshot));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),ExtentColor.AMBER));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
		
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart");
		String timeStamp =new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		ExtentHtmlReporter htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlreport.config().setDocumentTitle("Automation Report");
		htmlreport.config().setReportName("Extent Report");
		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreport.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("OS", "Window");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		extent.flush();
		
	}

}
