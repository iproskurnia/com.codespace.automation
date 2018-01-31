package seleniumTest.pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTest.utils.WebElementActions;


public class GoogleHomePage {

    WebElementActions web;
    private static Logger LOG = Logger.getLogger(GoogleHomePage.class);
    WebDriver driver;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementActions(driver);

    }

    public void inputSomeValue(String value) {
        web.input("google.search.field", value);
        LOG.info("LOG MESSAGE: " + value);
    }

    public void submitSearch() {
        web.clickButton("google.search.button");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(.//h3[@class='r'])[1]")));
    }

}
