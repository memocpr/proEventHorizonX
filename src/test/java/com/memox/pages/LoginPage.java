package com.memox.pages;

import com.memox.utilities.ConfigurationReader;
import com.memox.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }




    //same with driver.findElement(By.id("prependedInput"));
    @FindAll({
            @FindBy(name = "_username"),
            @FindBy(id = "prependedInput2")
    })
    public WebElement usernameInput;
    // if there are more than one, we use :
    // public List<Webelements> usernameInnputs

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;





    public void login(String usernameStr,String passwordStr){

        usernameInput.sendKeys(usernameStr); // if there are more than one, we use : usernameInput.get(index)
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();

    }

    public void loginAsDriver(){

        String username= ConfigurationReader.get("driver_username");
        String password =ConfigurationReader.get("driver_password");
        usernameInput.sendKeys(username); // if there are more than one, we use : usernameInput.get(index)
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    public void loginAsSalesManeger(){
        String username=ConfigurationReader.get("salesmanager_username");
        String password=ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

}
