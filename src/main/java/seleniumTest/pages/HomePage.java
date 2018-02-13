package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.WebDriverWrapper;

public class HomePage extends GlobalPageHeader{

    private static final String HOME_PAGE_URL = "http://magento-demo.lexiconn.com/";
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public HomePage(WebDriverWrapper dr) {
        super(dr, HOME_PAGE_URL);
    }

    public void proceedToLoginPage(){
        clickMyAccountLink();
        clickLoginLink();
    }

    public void proceedToRegistrationPage(){
        clickMyAccountLink();
        clickRegisterLink();
    }

    public void logout(){
        clickMyAccountLink();
        clickLogOutLink();
    }

//    public HomePage(WebDriverWrapper dr, String HOME_PAGE_URL) {
//        super(dr, HOME_PAGE_URL);
//    }
}
