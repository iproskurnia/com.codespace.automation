package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.WebDriverWrapper;

public class RegistrationPage extends GlobalPageHeader{

    private static final String REGISTRATION_PAGE_URL = "http://magento-demo.lexiconn.com/customer/account/create/";
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    int random = (int)(1+Math.random()*10000000-1);

    public RegistrationPage(WebDriverWrapper dr) {
        super(dr, REGISTRATION_PAGE_URL);
    }


    public void enterFirstName(String firstname){

        web.input("registration.firstname", firstname);
    }
    public void enterLastName(String lastname){

        web.input("registration.lastname", lastname);
    }

    public void enterEmail(String email){

        web.input("registration.email", email);
    }

    public void enterRegPassword(String regPassword){

        web.input("registration.password", regPassword);
    }

    public void confirmRegPassword(String confirmRegPassword){

        web.input("registration.confirm.password", confirmRegPassword);
    }

    public void clickRegisterButton(){
        web.clickButton("registration.submit");
    }

    public void enterRegistrationData(){

        enterFirstName("iaroslav");
        enterLastName("proskurnia");
        enterEmail("iaroslav.proskurnia"+random+"@gmail.com");
        enterRegPassword("testtest");
        confirmRegPassword("testtest");
    }

    public void getElementText(String text){
        web.getElementText("registration.success.message");
    }
}
