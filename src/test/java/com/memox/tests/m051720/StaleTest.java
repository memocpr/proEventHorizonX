package com.memox.tests.m051720;

import com.memox.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StaleTest extends TestBase {


    @Test

    public void test1(){

        driver.get("https://www.google.com/");

        WebElement input = driver.findElement(By.name("q"));

        input.sendKeys("selenium"+ Keys.ENTER);


        WebElement result = driver.findElement(By.id("result-stats"));

        Assert.assertTrue(result.isDisplayed(),"verify that result is displayed");

        driver.navigate().back();


        input = driver.findElement(By.name("q"));

        input.sendKeys("java"+Keys.ENTER);

        result = driver.findElement(By.id("result-stats"));

        Assert.assertTrue(result.isDisplayed(),"verify that result is displayed");






    }
}
