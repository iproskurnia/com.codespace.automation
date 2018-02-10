package seleniumTest.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.WebDriverWrapper;
import seleniumTest.utils.WebElementsActions;

public abstract class Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public WebDriverWrapper webDriverWrapper;
    public WebElementsActions web;

    private String PAGE;


    public Page(WebDriverWrapper dr, String page) {
        webDriverWrapper = dr;
        PAGE = page;
        web = new WebElementsActions(dr);
    }

    public Page(WebDriverWrapper dr) {
        webDriverWrapper = dr;
        web = new WebElementsActions(dr);
    }

    /*
     * Open Page in a browser
     */
    public boolean openPage(){
        try{
            LOG.info("Start open page.");
            webDriverWrapper.get(PAGE);
            webDriverWrapper.getCurrentUrl();
        } catch (Exception e){
            LOG.error("Error in open page!\n");
            return false;
        }
        LOG.info("Page open successful.");
        return true;
    }

    /*
     * Verification Page open correct. Check on pageLocator
     */
    public boolean isPageOpened(String checkLocator){
        try {
            if (web.isElementPresent(checkLocator)) {
                LOG.info("Page: Check is page open. " + checkLocator + " is present!");
                LOG.info(ClassNameUtil.getCurrentClassName() + ": Page is open.");
                return true;
            } else {
                LOG.error("Page: Error with check page!\n");
                Assert.fail("Incorrect swatch");
            }
        } catch (NoSuchElementException noElementFound) {
            noElementFound.printStackTrace();
        }
        return false;
    }

    /*
     * Get page title for verification correct switch between pages
     */
    public String getTitle() {
        return webDriverWrapper.getTitle();
    }

    public String getCurrentPageURL() {
        return webDriverWrapper.getCurrentUrl();
    }

    public void deleteAllCookies() {
        webDriverWrapper.manage().deleteAllCookies();
    }


}
