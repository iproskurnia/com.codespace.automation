package seleniumTest.tests;

import org.testng.annotations.Test;
import seleniumTest.pages.Global;
import seleniumTest.pages.RegistrationPage;

@Test
public class RegistrationTest extends BrowserFixtures{

    String helloRegMessage = "registration.success.message";
    int random = (int)(1+Math.random()*10000000-1);

    //                                              Test registration
    @Test
    public void registrationTest() throws Exception {
        driver.get(baseUrl);

        Global global = new Global(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        global.clickMyAccountLink();
        global.clickRegisterLink();
        registrationPage.enterFirstName("iaroslav");
        registrationPage.enterLastName("proskurnia");
        registrationPage.enterEmail("iaroslav.proskurnia"+random+"@gmail.com");
        registrationPage.enterRegPassword("testtest");
        registrationPage.confirmRegPassword("testtest");
        registrationPage.clickRegisterButton();
        registrationPage.getElementText(helloRegMessage);

    }


}
