package com.impactiva.smoke.base;

import com.enviance.BuildConfig;
import com.impactiva.smoke.lib.Common_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static OptionsManager optionsManager = new OptionsManager();
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static String ENVIRONMENT_NAME = BuildConfig.ENVIRONMENT_NAME; //qa4
    public static String BASE_URL; //BuildConfig.ENVIRONMENT_NAME;

    static {
        try {
            Common_Class.fetchAllData();
            BASE_URL = Common_Class.selectEnvironment(ENVIRONMENT_NAME);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String SELECTED_BROWSER =  BuildConfig.BROWSER_NAME;
    public static final String GLOBAL_ADMIN_ROLE_1 = "Global Administrator";
    public static final String GLOBAL_ADMIN_ROLE_2 = "Enviance - Internal QA Admin";

    public static synchronized void setDriver(String browser) {
        if (browser.equals("firefox")) {
            //For Local Usage
            //tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(optionsManager.getFirefoxOptions()));

            //For Grid Usage
            try {
                tlDriver.set(new RemoteWebDriver(new URL(Common_Class.hubURL), optionsManager.getFirefoxOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browser.equals("chrome")) {
            //For Local Usage
            //tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

            //For Grid Usage
            try {
                tlDriver.set(new RemoteWebDriver(new URL(Common_Class.hubURL), optionsManager.getChromeOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {

            try {
                tlDriver.set(new RemoteWebDriver(new URL(Common_Class.hubURL), optionsManager.getIEOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized WebDriverWait getWait (WebDriver driver) {
        return new WebDriverWait(driver,Common_Class.DEFAULT_WAIT);
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
