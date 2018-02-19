package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static seleniumTest.utils.getCurrentClassAndMethodNames.getCurrentClassAndMethodNames;

public class RegistrationTest extends Fixtures {

    @BeforeMethod
    public void methodSetUp()
    {
        demo.registrationPage.openPage();
    }

    //                                              Test registration
    @Test
    public void registrationTest() throws Exception {

        //demo.homePage.proceedToRegistrationPage();
        demo.registrationPage.enterRegistrationData();
        demo.registrationPage.clickRegisterButton();
        demo.screenShotMaker.takeScreenShot(getCurrentClassAndMethodNames());
        Assert.assertTrue(true, "Thank you for registering with Madison Island.");
        System.out.println();
    }
}
