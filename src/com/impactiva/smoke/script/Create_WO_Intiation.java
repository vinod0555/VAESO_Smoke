package com.impactiva.smoke.script;

import com.impactiva.smoke.base.Dataprovider;
import com.impactiva.smoke.base.DriverFactory;
import com.impactiva.smoke.lib.Common_Class;
import com.impactiva.smoke.pom.Vaeso_Dashboard_Page;
import com.impactiva.smoke.pom.Vaeso_Login_Page;
import com.impactiva.smoke.pom.Vaeso_Rfid_Page;
import com.impactiva.smoke.pom.WO_Page;
import jdk.nashorn.internal.ir.OptimisticLexicalContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Create_WO_Intiation extends BaseTestNG
{

    private WebDriver driver;

    private WebDriver getDriver() {
        return driver = DriverFactory.getDriver();
    }

    @Test(dataProvider = "rfidData", dataProviderClass = Dataprovider.class)
    public void CreateWOIntiation(String rfidNumber) {

        Vaeso_Login_Page login_page = new Vaeso_Login_Page(getDriver(), DriverFactory.getWait(getDriver()));
        login_page.login(Common_Class.imusername, Common_Class.impassword);

        Vaeso_Dashboard_Page db_page = new Vaeso_Dashboard_Page(getDriver(), DriverFactory.getWait(getDriver()));
        db_page.RfidConfigurator();

        Vaeso_Rfid_Page wointiation_page = new Vaeso_Rfid_Page(getDriver(), DriverFactory.getWait(getDriver()));
        wointiation_page.linedropdown_click();
        wointiation_page.line_no_click();
        wointiation_page.wodropdown_click();
        wointiation_page.wono_click();
        wointiation_page.ftyprodiddropdown_click();
        wointiation_page.ftyprodidno_click();
        wointiation_page.proceedbtn_click();

        wointiation_page.sizeandwidthicon1_click();
        wointiation_page.rfidtagnotxtbox_sendrfid(rfidNumber);
        driver.quit();



    }

}
