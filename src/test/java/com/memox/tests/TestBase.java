package com.memox.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.memox.utilities.BrowserUtils;
import com.memox.utilities.ConfigurationReader;
import com.memox.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected ExtentReports reports;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){

        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(path);

        reports=new ExtentReports();
        reports.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytruck Smoke Test");

        reports.setSystemInfo("Environment","QA");
        reports.setSystemInfo("Browser",ConfigurationReader.get("url"));
        reports.setSystemInfo("Tester","MemoX");
        reports.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,3);
        driver.get(ConfigurationReader.get("url"));

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws InterruptedException, IOException {

        if (result.getStatus()==ITestResult.FAILURE){

            extentLogger.fail(result.getName());

            String screeShotPath= BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screeShotPath);

            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void teardown(){
        reports.flush();
    }
}
