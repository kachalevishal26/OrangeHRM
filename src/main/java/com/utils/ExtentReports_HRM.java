package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.TestBase;

public class ExtentReports_HRM extends TestBase {
	static ExtentReports extent;
	
	public static ExtentReports getReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		reporter.config().setReportName("Test Results");
		reporter.config().setDocumentTitle("Test Automation Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Vishal Kachale", "Test Engineer");
		
		return extent;
	}
}
