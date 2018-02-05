package seleniumTest.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import seleniumTest.pages.Global;
import seleniumTest.pages.LoginPage;

@Test
public class LoginFixtures extends BrowserFixtures{

    //                                              Test email with correct data entered

    @BeforeClass
    public void successLoginTest() throws Exception {
        driver.get(baseUrl);
        Global global = new Global(driver);
        LoginPage loginPage = new LoginPage(driver);
        global.clickMyAccountLink();
        global.clickLoginLink();
        loginPage.enterEmail("iaroslav.proskurnia@gmail.com");
        loginPage.enterPassword("testtest");
        loginPage.clickSubmitButton();
        Assert.assertTrue(true,"Hello, Yarik Pros!");
    }

    @AfterClass
    public void successLogoutTest() throws Exception {
        driver.get(baseUrl);
        Global global = new Global(driver);
        global.clickMyAccountLink();
        global.clickLogOutLink();
    }
}
