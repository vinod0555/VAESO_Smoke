package com.impactiva.smoke.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WO_Page
{

    private WebDriver driver;
    private WebDriverWait driverWait;

    @FindBy(xpath="//button[@title='Create New']")
    private WebElement create_wo;

    @FindBy(xpath="//div[@class='rt-tbody']//div[1]//div[1]//div[2]//span[1]//span[1]//span[1]")
    private WebElement plus_icon;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[12]/div[1]/span[2]")
    private WebElement edit_icon;

    @FindBy(xpath="//button[@title='Assign']")
    private WebElement assign_btn;

    @FindBy(xpath="//button[@title='Next']")
    private WebElement next_btn;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*")
    private WebElement select_dd;

    @FindBy(xpath="//div[@id='react-select-4-option-0']")
    private WebElement select_line;

    @FindBy(xpath="//div[.='16']")
    private WebElement bundle_size;

    @FindBy(xpath="//div[.='29']")
    private WebElement mfg_start_date;

    @FindBy(xpath="//button[@title='Create']")
    private WebElement create_btn;

    public void createwo_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(create_wo));
        driverWait.until(ExpectedConditions.elementToBeClickable(create_wo));
        create_wo.click();

    }

    public void plusicon_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(plus_icon));
        driverWait.until(ExpectedConditions.elementToBeClickable(plus_icon));
        plus_icon.click();
    }

    public void editicon_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(edit_icon));
        driverWait.until(ExpectedConditions.elementToBeClickable(edit_icon));
        edit_icon.click();
    }

    public void assignbtn_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(assign_btn));
        driverWait.until(ExpectedConditions.elementToBeClickable(assign_btn));
        assign_btn.click();
    }

    public void nextbtn_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(next_btn));
        driverWait.until(ExpectedConditions.elementToBeClickable(next_btn));
        next_btn.click();
    }

    public void selectdd_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(select_dd));
        driverWait.until(ExpectedConditions.elementToBeClickable(select_dd));
        select_dd.click();
    }

    public void selectline_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(select_line));
        driverWait.until(ExpectedConditions.elementToBeClickable(select_line));
        select_line.click();
    }

    public void bundlesize_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(bundle_size));
        driverWait.until(ExpectedConditions.elementToBeClickable(bundle_size));
        bundle_size.click();
    }

    public void mfgstartdate_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(mfg_start_date));
        driverWait.until(ExpectedConditions.elementToBeClickable(mfg_start_date));
        mfg_start_date.click();
    }

    public void createbtn_click()
    {
        driverWait.until(ExpectedConditions.visibilityOf(create_btn));
        driverWait.until(ExpectedConditions.elementToBeClickable(create_btn));
        create_btn.click();
    }



    public WO_Page(WebDriver driver, WebDriverWait driverWait)
    {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(driver, this);
    }
}
