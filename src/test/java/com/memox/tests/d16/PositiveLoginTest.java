package com.memox.tests.d16;

import com.memox.pages.LoginPage;
import com.memox.tests.TestBase;
import com.memox.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {


    @Test
    public void loginAsDriver(){

        LoginPage loginPage=new LoginPage();

       // loginPage.usernameInput.sendKeys("user1");
       // loginPage.userpasswordInput.sendKeys("UserUser123");
       // loginPage.loginBtn.click();
        // instead of these we ll use call login method from LoginPage Class


        String url=ConfigurationReader.get("url");

        loginPage.loginAsDriver();

        Assert.assertEquals(driver.getCurrentUrl(),url);

    }

    @Test

    public void loginAsStoreManager(){

        LoginPage loginPage=new LoginPage();

        String username= ConfigurationReader.get("storemanger_username");
        String password =ConfigurationReader.get("storemanger_password");
        String url=ConfigurationReader.get("url");

        loginPage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
}
