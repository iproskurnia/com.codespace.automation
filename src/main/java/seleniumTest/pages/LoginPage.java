package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.PropertyLoader;
import seleniumTest.utils.WebDriverWrapper;

public class LoginPage extends GlobalPageHeader {

    private static final String LOGIN_PAGE_URL = "http://magento-demo.lexiconn.com/customer/account/login/";
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public LoginPage(WebDriverWrapper dr) { super(dr, LOGIN_PAGE_URL); }

    public void enterEmail(String email){

        web.input("loginpage.email", email);
    }

    public void enterPassword(String password){
        web.input("loginpage.password", password);
    }

    public void clickSubmitButton(){
        web.clickButton("loginpage.submit");
    }

    public void enterValidLoginCredentials(){
        enterEmail(PropertyLoader.loadProperty("login.valid.email"));
        enterPassword(PropertyLoader.loadProperty("login.valid.password"));
    }

    public void enterInvalidLoginCredentials(){
        enterEmail(PropertyLoader.loadProperty("login.invalid.email"));
        enterPassword(PropertyLoader.loadProperty("login.invalid.password"));
    }

    public void successLogin(){
        enterValidLoginCredentials();
        clickSubmitButton();
    }

    public boolean isLogInSuccessful(){
        if (web.isElementPresent("global.success.login.hello.message")){
            //System.out.println(web.isElementPresent("global.success.login.hello.message"));
            return true;
        }
        return false;
    }

    public boolean isLogInWithEmptyCredentialsFailed(){
        if (web.isElementPresent("loginpage.emptyemail")){
            return true;
        }
        return false;
    }



    public void getElementText(String text){
        web.getElementText(text);
    }
}
