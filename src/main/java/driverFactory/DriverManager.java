package driverFactory;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

}
