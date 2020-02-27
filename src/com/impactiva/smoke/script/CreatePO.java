package com.impactiva.smoke.script;

import com.impactiva.smoke.base.DriverFactory;
import com.impactiva.smoke.lib.Common_Class;
import com.impactiva.smoke.pom.PO_Page;
import com.impactiva.smoke.pom.Vaeso_Dashboard_Page;
import com.impactiva.smoke.pom.Vaeso_Login_Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class CreatePO extends BaseTestNG{

    private WebDriver driver;

    private WebDriver getDriver() {
        return driver = DriverFactory.getDriver();
    }

    @Test
    public void testCreatePO() throws AWTException
    {

        Vaeso_Login_Page login_page = new Vaeso_Login_Page(getDriver(), DriverFactory.getWait(getDriver()));
        login_page.login(Common_Class.imusername, Common_Class.impassword);

        Vaeso_Dashboard_Page db_page = new Vaeso_Dashboard_Page(getDriver(), DriverFactory.getWait(getDriver()));
        db_page.PurchaseOrder();
        //Click on Upload PO
        PO_Page po_page = new PO_Page(getDriver(), DriverFactory.getWait(getDriver()));
        po_page.uploadPO();

        /*Robot robot = new Robot();

        StringSelection str = new StringSelection("./excels/Vaeso_PO.xlsx");


        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        po_page.uploadButton();*/


        //Click on Upload Button

        po_page.uploadButton();

    }
}
