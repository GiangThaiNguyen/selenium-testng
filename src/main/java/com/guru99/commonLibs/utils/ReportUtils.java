package com.guru99.commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
    ExtentReports extentReports;
    ExtentSparkReporter sparkReporter;
    ExtentTest extentTest;
    public ReportUtils(String reportFileName) {
        sparkReporter = new ExtentSparkReporter(reportFileName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    public void createATestCase(String testcaseName) {
        extentTest = extentReports.createTest(testcaseName);
    }

    public void addTestLog(Status status, String detail) {
        extentTest.log(status, detail);
    }

    public void flushReport() {
        extentReports.flush();
    }
}
