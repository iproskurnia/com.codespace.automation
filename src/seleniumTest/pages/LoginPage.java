package seleniumTest.pages;

import org.openqa.selenium.WebDriver;
import seleniumTest.utils.WebElementActions;

public class LoginPage {

    private WebElementActions web;

    public LoginPage(WebDriver driver) {
        web = new WebElementActions(driver);
    }

    public void enterEmail(String email){

        web.input("loginpage.email", email);
    }

    public void enterPassword(String password){
        web.input("loginpage.password", password);
    }

    public void clickSubmitButton(){
        web.clickButton("loginpage.submit");
    }

    public void getElementText(String text){
        web.getElementText(text);
    }
}
