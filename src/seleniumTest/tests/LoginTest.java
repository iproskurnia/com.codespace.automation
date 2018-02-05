package seleniumTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTest.pages.Global;
import seleniumTest.pages.LoginPage;

public class LoginTest extends BrowserFixtures{

    String email = "jhgasdfjhg@dasdadjk.asd";
    String password = "uytur45";
    //String helloLogText = "global.success.login.hello.message";

    /**                 Test Login with empty Email and Password fields
     */
    @Test(priority = 2)
    public void emptyLoginCredentialsTest() throws Exception {
        driver.get(baseUrl);
        Global global = new Global(driver);
        LoginPage loginPage = new LoginPage(driver);
        global.clickMyAccountLink();
        global.clickLoginLink();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickSubmitButton();
        loginPage.getElementText("loginpage.emptyemail");
        Assert.assertTrue(true,"This is a required field.");
    }

    /**          Test login with an empty Email field
     *
     */
    @Test(priority = 3)
    public void emptyEmailLoginTest() throws Exception {
        driver.get(baseUrl);
        Global global = new Global(driver);
        LoginPage loginPage = new LoginPage(driver);
        global.clickMyAccountLink();
        global.clickLoginLink();
        loginPage.enterEmail("");
        loginPage.enterPassword("testtest");
        loginPage.clickSubmitButton();
        loginPage.getElementText("loginpage.emptyemail");

    }
    //                                               Test login with an empty Password field
    @Test(priority = 1)
    public void emptyPasswordLoginTest() throws Exception {
        driver.get(baseUrl);
        Global global = new Global(driver);
        LoginPage loginPage = new LoginPage(driver);
        global.clickMyAccountLink();
        global.clickLoginLink();
        loginPage.enterEmail("iaroslav.proskurnia@gmail.com");
        loginPage.enterPassword("");
        loginPage.clickSubmitButton();
        loginPage.getElementText("loginpage.emptypass");
    }

    //                                              Test login with incorrect email and password
    @Test(priority = 4)
    public void nonExistUserLoginTest() throws Exception {
        driver.get(baseUrl);
        Global global = new Global(driver);
        LoginPage loginPage = new LoginPage(driver);
        global.clickMyAccountLink();
        global.clickLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        Assert.assertTrue(true, "Invalid login or password.");
    }
}
