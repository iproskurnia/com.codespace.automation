package seleniumTest.pages;

import org.openqa.selenium.WebDriver;
import seleniumTest.utils.WebElementActions;

public class Global {

    private WebElementActions web;

    public Global(WebDriver driver) {
        web = new WebElementActions(driver);
    }

    public void clickTitle()
    {
        web.clickButton("global.title");
    }
    public void clickMyAccountLink()
    {
        web.clickButton("global.myaccount.link");
    }
    public void clickLoginLink() {
        web.clickElement("global.login.link");
    }
    public void clickRegisterLink() {
        web.clickElement("global.register.link");
    }
    public void clickLogOutLink() {
        web.clickElement("global.logout.link");
    }

    public void moveOnMenuItemAndClick(){
        web.moveToElementAndClick("global.menu.men","global.menu.men.tees_knits_polos");
    }

}
