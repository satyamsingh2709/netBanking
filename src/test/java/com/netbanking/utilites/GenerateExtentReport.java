package com.netbanking.utilites;


import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.netbanking.testCases.BaseClass;


public class GenerateExtentReport extends BaseClass implements ITestListener{
	
	public ExtentReports report = new ExtentReports();
	public ExtentTest test;
	public ExtentSparkReporter htmlReporter;
	

	public void onStart(ITestContext tr) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//        htmlReporter.config().setDocumentTitle("Simple Automation Report");
//        htmlReporter.config().setReportName("Test Report");
//        htmlReporter.config().setTheme(Theme.STANDARD);

		
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Host Name", "Local Host");
		report.setSystemInfo("User", "Satyam");
	}

	
	public void onTestStart(ITestResult tr) {
		
	}
	
	public void onTestFailure(ITestResult tr) {
		test = report.createTest(tr.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		System.out.println(screenshotPath);
		File f = new File(screenshotPath);

		try {
			FileUtils.copyFile(screenshot, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotPath);

	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test = report.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
	}
	
	public void onFinish(ITestContext tr) {
		//report = new ExtentReports();
		report.flush();
	}
}
