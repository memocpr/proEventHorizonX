package com.memox.tests.d18;

import com.memox.pages.ContactInfoPage;
import com.memox.pages.ContactsPage;
import com.memox.pages.DashboardPage;
import com.memox.pages.LoginPage;
import com.memox.tests.TestBase;
import com.memox.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfo extends TestBase {

    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void contactTest(){

        new LoginPage().loginAsSalesManeger();
        extentLogger=reports.createTest("Contact test");

        extentLogger.info("username :"+ ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("password : "+ConfigurationReader.get("salesmanager_password"));



        new DashboardPage().navigateToModule("Customer","Contacts");

        ContactsPage contactsPage=new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("brackstone9@example.com").click();




        ContactInfoPage contactInfoPage=new ContactInfoPage();
        String actualname = contactInfoPage.fullName.getText();
        String ecpectedname="Mariam Brackstone";

        Assert.assertEquals(actualname,ecpectedname,"verify name");

        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");

        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone");

        extentLogger.pass("PASS : Contact test");

    }

}
