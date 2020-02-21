package auto.testcases;

import auto.pages.*;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestDonatePage extends Init {

    @Test
    public void testDemoPage() throws InterruptedException {
    	WePage wePage = new WePage(driver);
        DemoPage demoPage = new DemoPage(driver);
        wePage.verifyWelcomePageTitle();
        wePage.verifyWelcomePageHeader();
        wePage.clickOnLinkViaLinkText("DONATE");
        demoPage.verifyDemoPageHeader();
        demoPage.verifyDemoPageTitle();
        demoPage.verifyDemoPageAmount();
        demoPage.selectCurrency("CAD");
        demoPage.donate();
    }
}
