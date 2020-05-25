package com.memox.tests.m051720;

import com.memox.tests.TestBase;
import com.memox.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VyTruckFuelLogs extends TestBase {

    @Test

    public void fuelLogs() throws InterruptedException {


        driver.get(ConfigurationReader.get("url"));
        //Driver.get().get(ConfigurationReader.get("url"));



        String password=ConfigurationReader.get("password");


        for (int i = 1; i <= 3; i++) {

            WebElement usernameInput = driver.findElement(By.id("prependedInput"));

            WebElement passwordInput = driver.findElement(By.id("prependedInput2"));

            String user=ConfigurationReader.get("truckDriver"+i);

           // System.out.println("user"+i+" = " + user);
           // System.out.println(password);

            usernameInput.sendKeys(user);
            passwordInput.sendKeys(password+Keys.ENTER);

            Thread.sleep(3000);

            WebElement userMenu = driver.findElement(By.id("user-menu"));

        WebElement logout = driver.findElement(By.xpath("//a[.='Logout']"));

        actions.click(userMenu).click(logout).pause(2000).build().perform();

        Thread.sleep(3000);

            //Select userDropdown=new Select(userMenu);
            //List<WebElement> options=userDropdown.getOptions();
           // System.out.println("options.size() = " + options.size());





        }






    }
}
