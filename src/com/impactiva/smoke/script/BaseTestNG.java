package com.impactiva.smoke.script;

import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.impactiva.smoke.lib.Common_Class;
import com.impactiva.smoke.lib.ScreenshotTaker;
import com.impactiva.smoke.base.DriverFactory;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.remote.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTestNG {

	public static ExtentReports report;
	public static ExtentTest logger;

	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
	public static String html_extension = ".html";
	public static String jobName;
	public static String assignedTo;

	//public static String AdminRole = "OES User+JHA Approver+IMS Admin";
	//public static String AuthorRole = "Marvin - Grifols - JHA Author + IMS Mgmt";

	// ThreadLocal will keep local copy of driver
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	public FileChannel src;

    @BeforeTest
    public void Start_Test() {

        if (!this.getClass().getSimpleName().equalsIgnoreCase(ImpactivaLogin.class.getName())) {

            report = new ExtentReports(
                    "./Reports/" + DriverFactory.ENVIRONMENT_NAME + "_" + DriverFactory.SELECTED_BROWSER + timeStamp + html_extension, false);
         //  logger = report.startTest("JHA TEST SUITE " + this.getClass().getSimpleName());
            report.config().documentTitle("JHA Tests Automation");
            report.config().reportName("JHA SMOKE");
            report.config().reportHeadline("[" + DriverFactory.SELECTED_BROWSER + "]");
        }

        openBrowser(DriverFactory.SELECTED_BROWSER, DriverFactory.BASE_URL);

        DriverFactory.getDriver().get(DriverFactory.BASE_URL);
        ((RemoteWebDriver)DriverFactory.getDriver()).setFileDetector(new LocalFileDetector());

    }

    private static void openBrowser(String browser, String environment) {

        Common_Class.waitForMilliseconds(Common_Class.threeSec);
        Common_Class.waitForMilliseconds(Common_Class.threeSec);
        DriverFactory.setDriver(browser);
        DriverFactory.getDriver().manage().window().maximize();
        long timeInSec = 10;
        try {
            DriverFactory.getDriver().manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("implicit wait not compatible");
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void methodReport(Method method){

        logger = report.startTest("VAESO TEST SUITE " +this.getClass().getSimpleName()+"_"+method.getName(), "method started");
    }

    @AfterMethod
    public void endMethod(ITestResult testResult){
        if(testResult.getStatus() == ITestResult.FAILURE) {
            String scrnsht = ScreenshotTaker.captureScreenshot(DriverFactory.getDriver(), "test"+timeStamp);
            logger.log(LogStatus.FAIL, logger.addScreenCapture(System.getProperty("user.dir") + scrnsht));
            logger.log(LogStatus.FAIL, testResult.getName(), testResult.getThrowable().toString());
        }else if (testResult.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, testResult.getName() + " Skipped");
        }
        report.endTest(logger);
        report.flush();
    }

}
