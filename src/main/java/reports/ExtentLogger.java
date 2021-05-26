package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driverFactory.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentLogger {

    private static ExtentReports extent;
    public static ExtentTest test;


    public static void initReports(){
        if(null == extent){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("target/index.html");
            extent.attachReporter(spark);
        }
    }

    public static  void flushReports() {

        if(null != extent){
            extent.flush();
        }
    }

    public static void info(String message, boolean isScreenshotRequired){
        if(isScreenshotRequired){
            ExtentThreadLocal.getExtentTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Img()).build());
        }else {
            info(message);
        }
    }

    public static void pass(String message){
        ExtentThreadLocal.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Img()).build());
    }

    public static void fail(String message, Throwable throwable){

        ExtentThreadLocal.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Img()).build());
        ExtentThreadLocal.getExtentTest().fail(throwable);
    }

    public static void skip(String message, Throwable throwable){
        ExtentThreadLocal.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Img()).build());
        ExtentThreadLocal.getExtentTest().skip(throwable);
    }

    public static void info(String message){
        ExtentThreadLocal.getExtentTest().info(message);

    }

    public static void createTest(String testName){
        test = extent.createTest(testName);
        ExtentThreadLocal.setExtentTest(test);

    }

    private static String getBase64Img(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
