package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends Fixtures {

    @BeforeMethod
    public void methodSetUp()
    {
        demo.loginPage.openPage();
    }
//    public void methodSetUp()
//    {
//        demo.homePage.openPage();
//    }

    @Test
    public void successLogoutTest() throws Exception {
        //demo.homePage.proceedToLoginPage();
        demo.loginPage.successLogin();
        demo.homePage.logout();
        //Assert.assertTrue(demo.myAccountPage.isLogInSuccessful(), "You are now logged out");
    }
}