package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import seleniumTest.pages.Demo;
import seleniumTest.utils.UiMappingSingleton;
import seleniumTest.utils.WebDriverFactory;
import seleniumTest.utils.WebDriverWrapper;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Fixtures {

    public static WebDriverWrapper driver;
    public static Demo demo;

    @BeforeSuite
    public void setUp(){
        System.out.println("FIXTURE - BEFORE SUITE START");
        driver = WebDriverFactory.initDriver();
        demo = new Demo(driver);
        UiMappingSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        System.out.println("FIXTURE - BEFORE SUITE END");

    }

    @BeforeMethod
    public void deleteAllCoockies(){
        System.out.println("FIXTURE - BEFORE METHOD START");
        driver.manage().deleteAllCookies();
        System.out.println("FIXTURE - BEFORE METHOD END");
    }

    @AfterMethod
    public void afterMethodTearDown(ITestResult testResult){
        System.out.println("FIXTURE - AFTER METHOD START");
        if(!testResult.isSuccess()){
            demo.screenShotMaker.takeScreenShot(testResult.getMethod().getMethodName());
        }
        System.out.println("FIXTURE - AFTER METHOD ENDS");

    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
//    @AfterClass
//    public void tearDown(){
//        System.out.println("FIXTURE - AFTER CLASS START");
//        driver.quit();
//        System.out.println("FIXTURE - AFTER CLASS END");
//    }
}