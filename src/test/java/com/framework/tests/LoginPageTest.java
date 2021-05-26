package com.framework.tests;


import com.framework.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

@Listeners(reports.ExtentListener.class)
public class LoginPageTest extends TestBase {
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();

    @Test
    public void TC_01_Login_with_valid_credentials()  {

        loginPage.userLogin(prop.getProperty("username"), prop.getProperty("password") );
        String actualString= homePage.getInboxText();
        Assert.assertEquals(actualString,"Inbox");

    }
    @Test
    public void TC_02_Login_with_invalid_credentials(){
        boolean success = loginPage.userLogin("abc@gamil.com","uejhb1234");
        Assert.assertFalse(success, "User Can able to login with wrong credentials");
    }

    @Test
    public void TC_03_Login_with_valid_username_only (){
        boolean success = loginPage.userLogin(prop.getProperty("username"),"bhksdfbgksgbkjkj");
        Assert.assertFalse(success, "User Can able to login with wrong credentials");
    }


    @Test
    public void TC_04_Login_with_valid_password_only (){
        boolean success = loginPage.userLogin("abc@gamil.com",prop.getProperty("password"));
        Assert.assertFalse(success, "User Can able to login with wrong credentials");
    }
}
