package utils;

import driverFactory.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import reports.ExtentLogger;

@Listeners(reports.ExtentListener.class)
public class PageActionUtils {

    public static void click(By element){
        try {
            getElement(element).click();
            ExtentLogger.info("Element Clicked " + element.toString());
        } catch (ElementClickInterceptedException clickInterceptedException){
            ExtentLogger.fail("Click Intercepted ", clickInterceptedException.fillInStackTrace());
        }

    }

    public static boolean verifyElementPresence(By element){
        return  getElement(element).isDisplayed();
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

    public static void switchToFrame(By element){
        DriverManager.getDriver().switchTo().frame(getElement(element));
    }

    public static void switchToFrame(String frame){
        DriverManager.getDriver().switchTo().frame(frame);
    }

    public static void switchToFrame(int frameNum){
        DriverManager.getDriver().switchTo().frame(frameNum);
    }

    public static void switchToDefaultContent(){
        DriverManager.getDriver().switchTo().defaultContent();
    }


}
