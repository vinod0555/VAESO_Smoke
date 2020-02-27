package com.impactiva.smoke.base;

import com.impactiva.smoke.lib.Common_Class;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener {

    public static ExtentTest logger;
    public static ExtentReports report;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        if (method.isTestMethod()) {
           /*System.out.println("Test Method BeforeInvocation is started. " + Thread.currentThread().getId());
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            DriverFactory.setDriver(browserName);*/
            report = new ExtentReports(
                    "./Reports/" + DriverFactory.ENVIRONMENT_NAME + "_" + DriverFactory.SELECTED_BROWSER + Common_Class.timeStamp + ".html", false);
            logger = report.startTest("JHA SMOKE TEST SUITE " + this.getClass().getSimpleName(), "test started");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            System.out.println("Test Method AfterInvocation is started. " + Thread.currentThread().getId());
                if(!testResult.equals(null))
                    afterTest(testResult);
        }
    }

    private void afterTest(ITestResult testResult)
    {
        /*if (testResult.getStatus() == ITestResult.FAILURE) {
            String scrnsht = ScreenshotTaker.captureScreenshot(DriverFactory.getDriver(), "test");
            String scp = logger.addScreenCapture(System.getProperty("user.dir") + scrnsht);
            logger.log(LogStatus.FAIL, testResult.getName() + " Failed", scp + testResult.getThrowable().toString());

        } else if (testResult.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, testResult.getName() + " Skipped");
        } else*/ if (testResult.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test :  " + testResult.toString() + " Success");
        }
    }
}
