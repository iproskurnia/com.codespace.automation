package seleniumTest.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import seleniumTest.utils.UiMappingSingleton;
import seleniumTest.utils.WebElementActions;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.fail;

@Test
public class BrowserFixtures {

    protected WebDriver driver;
    protected WebElementActions web;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/iproskurnia/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        web = new WebElementActions(driver);
        baseUrl = "http://magento-demo.lexiconn.com/";
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        UiMappingSingleton.getInstance();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}

