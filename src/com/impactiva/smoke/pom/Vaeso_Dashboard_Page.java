package com.impactiva.smoke.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vaeso_Dashboard_Page
{
    WebDriver driver;
    WebDriverWait driverWait;

    @FindBy(xpath="//img")
    private WebElement sideBar;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]")
    private WebElement logoutIcon;

    @FindBy(xpath="//button[@title='Confirm']")
    private WebElement logoutConfirm;

    @FindBy(xpath="//span[contains(text(),'Purchase Orders')]")
    private WebElement db_po;

    @FindBy(xpath="//span[.='Work Orders']")
    private WebElement db_wo;

    @FindBy(xpath="//span[.='RFID Configurator']")
    private WebElement db_rfid;


    public void PurchaseOrder()
    {
        db_po.click();
    }

    public void WorkOrder()
    {
        db_wo.click();
    }

    public void RfidConfigurator(){db_rfid.click();}

    public void Logout()
        {
            Actions builder = new Actions(driver);
             builder.moveToElement(sideBar).perform();
            logoutIcon.click();
            logoutConfirm.click();
             }

    public Vaeso_Dashboard_Page(WebDriver driver, WebDriverWait driverWait)
    {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(driver, this);
    }



}
