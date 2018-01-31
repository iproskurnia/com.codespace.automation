package seleniumTest.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumTest.pages.HomePage;
import seleniumTest.pages.ProductDetailsPage;
import seleniumTest.pages.ProductListingPage;
import seleniumTest.pages.ShoppingCart;
import seleniumTest.utils.UiMappingSingleton;
import seleniumTest.utils.WebElementActions;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.fail;

public class ProductListingPageTest {
    private WebDriver driver;
    private WebElementActions web;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    String email = "jhgasdfjhg@dasdadjk.asd";
    String password = "uytur45";
    String helloLogText = "success.login.hello.message";
    String helloRegMessage = "registration.success.message";
    int random = (int)(1+Math.random()*10000000-1);

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/iproskurnia/Downloads/geckodriver");
        driver = new FirefoxDriver();
        web = new WebElementActions(driver);
        baseUrl = "http://magento-demo.lexiconn.com/";
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        UiMappingSingleton.getInstance();
    }


    //                           PLP & go to PDP
    @Test
    public void ProductListPageTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        ProductListingPage plp = new ProductListingPage(driver);
        homePage.moveOnMenuItemAndClick();
        plp.isPlpPage();
        plp.isPricePresent();
        plp.isPriceCorrect();
        //plp.clickOnProductImage();
        //plp.clickOnProductTitle();
        plp.clickOnViewDetails();
    }


    @After
    public void tearDown () throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent (By by){
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
