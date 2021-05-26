package reports;

import org.testng.*;


public class ExtentListener implements ISuiteListener, ITestListener {


    @Override
    public void onStart(ISuite suite) {
        ExtentLogger.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentLogger.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
       ExtentLogger.createTest(result.getMethod().getMethodName());
       ExtentLogger.info("Current Test case Executing is :: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is failed", result.getThrowable());
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
