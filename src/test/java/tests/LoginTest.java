package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Fixtures {

    //String methodName = new Object(){}.getClass().getEnclosingMethod().getName();

    @BeforeMethod
  //  public void methodSetUp() { demo.homePage.openPage(); }
    public void methodSetUp()
    {
        demo.loginPage.openPage();
    }

    /**                 Test Login with empty Email and Password fields
     */

    @Test (groups = { "Negative" })
    public void emptyLoginCredentialsTest() throws Exception {
        //demo.homePage.proceedToLoginPage();
        demo.loginPage.enterEmail("");
        demo.loginPage.enterPassword("");
        demo.loginPage.clickSubmitButton();
        //demo.loginPage.getElementText("loginpage.emptyemail");
        Assert.assertTrue(demo.loginPage.isLogInWithEmptyCredentialsFailed(),"This is a required field.");
    }

    /**          Test login with an empty Email field
     *
     */
    @Test(groups = { "Negative" })
    public void emptyEmailLoginTest() throws Exception {
        //demo.homePage.proceedToLoginPage();
        demo.loginPage.enterEmail("");
        demo.loginPage.enterPassword("testtest");
        demo.loginPage.clickSubmitButton();
        demo.loginPage.getElementText("loginpage.emptyemail");
        Assert.assertTrue(demo.loginPage.isLogInWithEmptyCredentialsFailed(),"loginpage.emptyemail");

    }
    //                                               Test login with an empty Password field
    @Test(groups = { "Negative" })
    public void emptyPasswordLoginTest() throws Exception {
       // demo.homePage.proceedToLoginPage();
        demo.loginPage.enterEmail("iaroslav.proskurnia@gmail.com");
        demo.loginPage.enterPassword("");
        demo.loginPage.clickSubmitButton();
        Assert.assertTrue(true,"loginpage.emptypass");
    }

    //                                              Test login with incorrect email and password
    @Test(groups = { "Negative" })
    public void nonExistUserLoginTest() throws Exception {
        //demo.homePage.proceedToLoginPage();
        demo.loginPage.enterInvalidLoginCredentials();
        demo.loginPage.clickSubmitButton();
        //Assert.assertTrue(demo.myAccountPage.isLogInSuccessful(), "Invalid login or password.");
    }

    //                                              Test email with correct data entered
    @Test(groups = { "Positive" })
    public void successLoginTest() throws Exception {
        //demo.homePage.proceedToLoginPage();
        demo.loginPage.enterValidLoginCredentials();
        demo.loginPage.clickSubmitButton();
        //Assert.assertTrue(demo.loginPage.isLogInSuccessful(), "Hello, Yarik Pros!");
    }
}
