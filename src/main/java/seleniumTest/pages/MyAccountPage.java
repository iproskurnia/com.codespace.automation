package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.WebDriverWrapper;

public class MyAccountPage extends GlobalPageHeader{

    private static final String MY_ACCOUNT_PAGE = "http://magento-demo.lexiconn.com/customer/account/index/";

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public MyAccountPage(WebDriverWrapper dr) {
        super(dr, MY_ACCOUNT_PAGE);
    }

    public boolean isLogInSuccessful(){
        if (web.isElementPresent("global.success.login.hello.message")){
        return true;
    }
        return false;
    }

    public boolean isRegistrationSuccessful(){
        if (web.isElementPresent("registration.success.message2")){
            return true;
        }
        return false;
    }

    public boolean isLogOutSuccessful(){
        if (web.isElementPresent("global.assert.loggedout")){
            return true;
        }
        return false;
    }
}
