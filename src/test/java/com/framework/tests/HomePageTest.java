package com.framework.tests;

import com.framework.base.TestBase;
import driverFactory.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
    public void TC_01_add_First_Name_and_Last_Name() throws InterruptedException {

        loginPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        String botText=homePage.saveFirstName_and_LastName("Sravan", "Kumar");
        Assert.assertEquals(botText,"Hi there, welcomeSravanKumar");

    }

    @Test
    public void TC_02_add_Message() throws InterruptedException {
        loginPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        String actual = homePage.add_Show_a_Message("Welcome to Insent.ai");
        Assert.assertEquals(actual,"Welcome to Insent.ai");
    }


}
