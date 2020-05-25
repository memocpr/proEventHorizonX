package com.memox.tests.d16;

import com.memox.pages.CalendarEventsPage;
import com.memox.pages.DashboardPage;
import com.memox.pages.LoginPage;
import com.memox.tests.TestBase;
import com.memox.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {


    @Test

    public void test1(){


        LoginPage loginPage=new LoginPage();

        loginPage.loginAsDriver();

        BrowserUtils.waitFor(3);

        DashboardPage dashboardPage=new DashboardPage();

        String expectedSubtitle ="Quick Launchpad";

        String actualSubtitle=dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle);


        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        BrowserUtils.waitFor(3);

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events");
    }

}
