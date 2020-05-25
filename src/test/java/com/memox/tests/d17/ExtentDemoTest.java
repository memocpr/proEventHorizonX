package com.memox.tests.d17;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.memox.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    ExtentReports reports;

    ExtentHtmlReporter htmlReporter;

    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){

        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(path);

        reports=new ExtentReports();
        reports.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytruck Smoke Test");

        reports.setSystemInfo("Environment","QA");
        reports.setSystemInfo("Browser", ConfigurationReader.get("url"));
        reports.setSystemInfo("Tester","MC");

    }

    @Test
    public void test1(){

        extentLogger=reports.createTest("TC Login as Driver Test");

        //we can add several info as muc as we want
        extentLogger.info("Open Chrome");

        extentLogger.pass("TC Login as Driver Test is passed");
    }

    @AfterMethod
    public void teardown(){

        reports.flush();
    }
}
