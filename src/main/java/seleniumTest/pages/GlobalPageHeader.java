package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.WebDriverWrapper;

public class GlobalPageHeader extends Page{

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public GlobalPageHeader(WebDriverWrapper dr) {
        super(dr);
    }

    public GlobalPageHeader(WebDriverWrapper dr, String page) {
        super(dr, page);
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

    public void proceedToPLP(){
        web.clickElement("global.menu.men");
        web.clickElement("men.pcp.tees_knits_polos");
    }

//    public void moveToElementAndClick(){
//        web.moveToElementAndClick("global.menu.men", "men.pcp.tees_knits_polos");
//    }

}
