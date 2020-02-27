package com.impactiva.smoke.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class PO_Page
{
    private  WebDriver driver;
    private WebDriverWait driverWait;

    @FindBy(xpath="//div[@id='file-upload']")
    private WebElement uploadPo;

    @FindBy(xpath="//button[@title='Upload']")
    private WebElement uploadbtn;

    public PO_Page(WebDriver driver, WebDriverWait driverWait)
    {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(driver, this);
    }



    public void  uploadPO() throws AWTException {
        uploadPo.click();

    }



    public void  uploadButton()
    {
        uploadbtn.click();
    }




}
