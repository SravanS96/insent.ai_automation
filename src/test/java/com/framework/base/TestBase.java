package com.framework.base;

import com.framework.constants.AppConstants;
import driverFactory.DriverManager;
import driverFactory.Drivers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class TestBase {

    public static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream inputStream = new FileInputStream(AppConstants.basePath + "/src/test/resources/configuration.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        Drivers.launchBrowser(prop.getProperty("browser"));
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().get(prop.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        Drivers.closeBrowser();
    }

}
