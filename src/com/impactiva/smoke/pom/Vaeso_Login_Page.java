package com.impactiva.smoke.pom;

import com.impactiva.smoke.lib.Common_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vaeso_Login_Page
{
    private WebDriver driver;
    private WebDriverWait driverWait;

    @FindBy(xpath="//input[@placeholder='Enter username']")
    private WebElement username;

    @FindBy(xpath="//input[@placeholder='Enter password']")
    private WebElement password;

    @FindBy(xpath="//button[@title='LOGIN']")
    private WebElement login_btn;

    public Vaeso_Login_Page(WebDriver driver, WebDriverWait driverWait)
    {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(driver, this);
    }


    public void login(String userName, String passWord)
    {
        driverWait.until(ExpectedConditions.visibilityOf(login_btn));
        username.clear();
        username.sendKeys(userName);

        password.clear();
        password.sendKeys(passWord);

        login_btn.click();
       // Common_Class.waitForMilliseconds(5000);
    }






}
