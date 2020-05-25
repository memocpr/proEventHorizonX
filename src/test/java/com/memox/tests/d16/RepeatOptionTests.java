package com.memox.tests.d16;

import com.memox.pages.CalendarEventsPage;
import com.memox.pages.CreateCalenderEventsPage;
import com.memox.pages.DashboardPage;
import com.memox.pages.LoginPage;
import com.memox.tests.TestBase;
import com.memox.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionTests extends TestBase {

    @Test

    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(4);
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalenderEventsPage createCalenderEventsPage=new CreateCalenderEventsPage();
        createCalenderEventsPage.repeat.click();

        Assert.assertTrue(createCalenderEventsPage.days.isSelected());
        Assert.assertFalse(createCalenderEventsPage.weekday.isSelected());

    }

  /*
     VERIFY REPEAT OPTIONS
        Open browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events
        Click on repeat
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */

  @Test

    public void test2(){

      new LoginPage().loginAsDriver();

      new DashboardPage().navigateToModule("Activities","Calendar Events");

      CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
      BrowserUtils.waitFor(4);
      calendarEventsPage.waitUntilLoaderScreenDisappear();
      calendarEventsPage.createCalendarEvent.click();

      CreateCalenderEventsPage createCalenderEventsPage=new CreateCalenderEventsPage();
      createCalenderEventsPage.repeat.click();

      createCalenderEventsPage.repeatOptions.click();


      Select repeatDropdown = createCalenderEventsPage.repeatOptionsList();
      List<WebElement> actualOptions = repeatDropdown.getOptions();

      List<String> expextedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
      List<String> actualList =new ArrayList<>();

    /*  for (WebElement option :actualOptions) {

        actualList.add(option.getText());

      }*/

    List<String> actualList2=BrowserUtils.getElementsText(actualOptions);

    Assert.assertEquals(actualList,expextedList);

  }
}
