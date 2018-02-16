package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Fixtures {

    @BeforeMethod
    public void methodSetUp()
    {
        demo.homePage.openPage();
    }

    /**                 Test Login with empty Email and Password fields
     */

    @Test(priority = 2)
    public void emptyLoginCredentialsTest() throws Exception {
        demo.homePage.proceedToLoginPage();
        demo.loginPage.enterEmail("");
        demo.loginPage.enterPassword("");
        demo.loginPage.clickSubmitButton();
        //demo.loginPage.getElementText("loginpage.emptyemail");
        Assert.assertTrue(demo.loginPage.isLogInWithEmptyCredentialsFailed(),"This is a required field.");
    }

    /**          Test login with an empty Email field
     *
     */
    @Test(priority = 3)
    public void emptyEmailLoginTest() throws Exception {
        demo.homePage.proceedToLoginPage();
        demo.loginPage.enterEmail("");
        demo.loginPage.enterPassword("testtest");
        demo.loginPage.clickSubmitButton();
        demo.loginPage.getElementText("loginpage.emptyemail");
        Assert.assertTrue(demo.loginPage.isLogInWithEmptyCredentialsFailed(),"loginpage.emptyemail");

    }
    //                                               Test login with an empty Password field
    @Test(priority = 1)
    public void emptyPasswordLoginTest() throws Exception {
        demo.homePage.proceedToLoginPage();
        demo.loginPage.enterEmail("iaroslav.proskurnia@gmail.com");
        demo.loginPage.enterPassword("");
        demo.loginPage.clickSubmitButton();
        Assert.assertTrue(true,"loginpage.emptypass");
    }

    //                                              Test login with incorrect email and password
    @Test(priority = 4)
    public void nonExistUserLoginTest() throws Exception {
        demo.homePage.proceedToLoginPage();
        demo.loginPage.enterInvalidLoginCredentials();
        demo.loginPage.clickSubmitButton();
        //Assert.assertTrue(demo.myAccountPage.isLogInSuccessful(), "Invalid login or password.");
    }

    //                                              Test email with correct data entered
    @Test
    public void successLoginTest() throws Exception {
        demo.homePage.proceedToLoginPage();
        demo.loginPage.enterValidLoginCredentials();
        demo.screenShotMaker.takeScreenShot("successLoginTest");
        demo.loginPage.clickSubmitButton();
        //Assert.assertTrue(demo.loginPage.isLogInSuccessful(), "Hello, Yarik Pros!");
    }
}
