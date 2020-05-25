package com.memox.pages;

import com.memox.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

   /* @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement email;*/


//    create a method getContactEmail that accepts email as a String, and return webelement based on that email.

    public WebElement getContactEmail(String emailStr){
        String emailxpath = "//td[contains(text(),'"+emailStr+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(emailxpath));
    }


}
