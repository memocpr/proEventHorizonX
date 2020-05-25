package com.memox.tests.d17;

import com.memox.pages.LoginPage;
import com.memox.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegetiveLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        extentLogger=reports.createTest("Wrong Password Test");
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter user name : user1");

        loginPage.usernameInput.sendKeys("somepassword");
        extentLogger.info("Enter password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click login buttton");

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        extentLogger.info("verify url");


        extentLogger.pass("Pass : Wrong password");
    }

    @Test
    public void wrongUserNameTest(){

        extentLogger=reports.createTest("Wrong User Name Test");
        LoginPage loginPage=new LoginPage();

        extentLogger.info("Enter user name : someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password : UserUser123 ");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify url ");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/loginXXX");

        extentLogger.pass("Pass : Wrong user name");
    }
}
