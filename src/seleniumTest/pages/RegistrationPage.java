package seleniumTest.pages;
import org.openqa.selenium.WebDriver;
import seleniumTest.utils.WebElementActions;

public class RegistrationPage {

    WebElementActions web;

    public RegistrationPage(WebDriver driver){
        web = new WebElementActions(driver);
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

    public void getElementText(String text){
        web.getElementText("registration.success.message");
    }
}
