package com.impactiva.smoke.script;

import com.impactiva.smoke.base.DriverFactory;
import com.impactiva.smoke.lib.Common_Class;
import com.impactiva.smoke.pom.Vaeso_Dashboard_Page;
import com.impactiva.smoke.pom.Vaeso_Login_Page;
import com.impactiva.smoke.pom.WO_Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreareWO extends BaseTestNG
{
    private WebDriver driver;

    private WebDriver getDriver() {
        return driver = DriverFactory.getDriver();
    }

    @Test
    public void testCreateWO()
        {

            Vaeso_Login_Page login_page = new Vaeso_Login_Page(getDriver(), DriverFactory.getWait(getDriver()));
            login_page.login(Common_Class.imusername, Common_Class.impassword);

            Vaeso_Dashboard_Page db_page = new Vaeso_Dashboard_Page(getDriver(), DriverFactory.getWait(getDriver()));
            db_page.WorkOrder();

            WO_Page workorder_page = new WO_Page(getDriver(), DriverFactory.getWait(getDriver()));
            workorder_page.createwo_click();
            workorder_page.plusicon_click();
            workorder_page.editicon_click();
            workorder_page.assignbtn_click();
            workorder_page.nextbtn_click();
            workorder_page.selectdd_click();
            workorder_page.selectline_click();
            workorder_page.bundlesize_click();
            workorder_page.mfgstartdate_click();
            workorder_page.createbtn_click();

            

        }

}
