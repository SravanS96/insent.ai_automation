package com.framework.tests;

import com.framework.base.TestBase;
import driverFactory.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

@Listeners(reports.ExtentListener.class)
public class HomePageTest extends TestBase {


    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();


    @Test
    public void TC_01_This_is_Test() throws InterruptedException {

        loginPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
       String botText=homePage.saveFirstName_and_LastName("Sravan", "Kumar");
        Assert.assertEquals(botText,"Hi there, welcomeSravanKumar");

    }


}
