package com.impactiva.smoke.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vaeso_Rfid_Page
{
    private WebDriver driver;
    private WebDriverWait driverWait;


    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*")
    private WebElement line_dropdown;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    private WebElement line_no;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/*")
    private WebElement wo_dropdown;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    private WebElement wo_no;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/*")
    private WebElement ftyprodid_dropdown;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]")
    private WebElement ftyprodid_no;

    @FindBy(xpath="//span[.='Proceed']")
    private WebElement proceed_btn;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]")
    private WebElement sizeandwidth_icon1;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/tr[1]/div[1]")
    private WebElement rfidtagno_txtbox;

    public Vaeso_Rfid_Page(WebDriver driver, WebDriverWait driverWait)
    {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(driver, this);
    }


    public void linedropdown_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(line_dropdown));
        driverWait.until(ExpectedConditions.elementToBeClickable(line_dropdown));
        line_dropdown.click();

    }

    public void line_no_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(line_no));
        driverWait.until(ExpectedConditions.elementToBeClickable(line_no));
        line_no.click();
    }

    public void wodropdown_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(wo_dropdown));
        driverWait.until(ExpectedConditions.elementToBeClickable(wo_dropdown));
        wo_dropdown.click();
    }

    public void wono_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(wo_no));
        driverWait.until(ExpectedConditions.elementToBeClickable(wo_no));
        wo_no.click();
    }

    public void ftyprodiddropdown_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(ftyprodid_dropdown));
        driverWait.until(ExpectedConditions.elementToBeClickable(ftyprodid_dropdown));
        ftyprodid_dropdown.click();
    }


    public void ftyprodidno_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(ftyprodid_no));
        driverWait.until(ExpectedConditions.elementToBeClickable(ftyprodid_no));
        ftyprodid_no.click();
    }

    public void proceedbtn_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(proceed_btn));
        driverWait.until(ExpectedConditions.elementToBeClickable(proceed_btn));
        proceed_btn.click();
    }

    public void sizeandwidthicon1_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(sizeandwidth_icon1));
        driverWait.until(ExpectedConditions.elementToBeClickable(sizeandwidth_icon1));
        sizeandwidth_icon1.click();
    }

    public void rfidtagnotxtbox_sendrfid(String rfidNumber)
    {

        /*JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value= "+rfidNumber+";",rfidtagno_txtbox);*/
        Actions actions = new Actions(driver);
        actions.moveToElement(rfidtagno_txtbox).sendKeys(rfidNumber).perform();
        actions.moveToElement(rfidtagno_txtbox).sendKeys(Keys.ENTER).perform();
        /*js.executeScript("arguments[0].click();", rfidtagno_txtbox);*/
        /*driverWait.until(ExpectedConditions.visibilityOf(rfidtagno_txtbox));*//*
        rfidtagno_txtbox.sendKeys("7485852345");
        rfidtagno_txtbox.sendKeys(Keys.ENTER);*/
        /*if(sizeandwidth_icon1.isEnabled())
        {

        }*/
    }



}
