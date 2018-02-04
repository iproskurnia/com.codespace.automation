package seleniumTest.pages;

import org.openqa.selenium.WebDriver;
import seleniumTest.utils.WebElementActions;

public class HomePage {

    WebElementActions web;

    public HomePage(WebDriver driver) {
        web = new WebElementActions(driver);
    }

    public void clickMyAccountLink()
    {
        web.clickButton("homepage.myaccount.link");
    }
    public void clickLoginLink() {
        web.clickElement("homepage.login.link");
    }
    public void clickRegisterLink() {
        web.clickElement("homepage.register.link");
    }

    public void moveOnMenuItemAndClick(){
        web.moveToElementAndClick("global.menu.men","global.menu.men.tees_knits_polos");
    }

}
