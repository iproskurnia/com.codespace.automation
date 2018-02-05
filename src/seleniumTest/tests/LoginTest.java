package seleniumTest.tests;

import org.testng.annotations.Test;
import seleniumTest.pages.Global;
import seleniumTest.pages.LoginPage;

public class LoginTest extends BrowserFixtures{

    String email = "jhgasdfjhg@dasdadjk.asd";
    String password = "uytur45";
    String helloLogText = "global.success.login.hello.message";


    /**                 Test Login with empty Email and Password fields
     */
    @Test
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
        loginPage.getElementText("loginpage.emptypass");
    }

    /**          Test login with an empty Email field
     *
     */
    @Test
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
    @Test
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
    @Test
    public void nonExistUserLoginTest() throws Exception {
        driver.get(baseUrl);
        Global global = new Global(driver);
        LoginPage loginPage = new LoginPage(driver);
        global.clickMyAccountLink();
        global.clickLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.getElementText("loginpage.invaliddata");
    }
}
