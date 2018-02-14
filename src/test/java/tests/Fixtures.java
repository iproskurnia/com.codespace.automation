package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import seleniumTest.pages.Demo;
import seleniumTest.utils.UiMappingSingleton;
import seleniumTest.utils.WebDriverFactory;
import seleniumTest.utils.WebDriverWrapper;

import static java.util.concurrent.TimeUnit.SECONDS;

@Test
public class Fixtures {

    public static WebDriverWrapper driver;
    public static Demo demo;

    @BeforeSuite
    public void setUp(){
        System.out.println("FIXTURE - BEFORE SUITE START");
        driver = WebDriverFactory.initDriver();
        demo = new Demo(driver);
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        UiMappingSingleton.getInstance();
        System.out.println("FIXTURE - BEFORE SUITE END");

    }

    @BeforeMethod
    public void deleteAllCoockies(){
        System.out.println("FIXTURE - BEFORE METHOD START");
        demo = new Demo(driver);
        driver.manage().deleteAllCookies();
        System.out.println("FIXTURE - BEFORE METHOD END");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("FIXTURE - AFTER CLASS END");
        driver.quit();
    }
}

