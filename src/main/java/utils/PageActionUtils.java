package utils;

import driverFactory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;

public class PageActionUtils {

    public static void click(By element){
        try {
            getElement(element).click();
            ExtentLogger.info("Element Clicked " + element.toString());
        } catch (ElementClickInterceptedException clickInterceptedException){
            ExtentLogger.fail("Click Intercepted ", clickInterceptedException.fillInStackTrace());
        }

    }

    public static void typeIntoTextBox(By element, String text){
        try {
            getElement(element).sendKeys(text);
            ExtentLogger.pass( text + "  entered Successfully");
        }catch (ElementNotInteractableException notInteractableException){
            ExtentLogger.fail("Click Intercepted ", notInteractableException.fillInStackTrace());
        }

    }

    public static String getElementText(By element){
        return getElement(element).getText();
    }

    public static void moveToElement(By element){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(getElement(element)).build().perform();
    }


    private static WebElement getElement(By element){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 20);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }



}
