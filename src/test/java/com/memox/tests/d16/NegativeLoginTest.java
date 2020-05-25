package com.memox.tests.d16;

import com.memox.pages.LoginPage;
import com.memox.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.usernameInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
    }

    @Test
    public void wrongUserNameTest(){

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");

        loginPage.passwordInput.sendKeys("UserUser123");

        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");

    }
}
