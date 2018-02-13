package seleniumTest.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriverWrapper driverWrapper;

    /*Browsers constants*/
    private static final String FIREFOX = "firefox";
    private static final String INTERNET_EXPLORER = "phantomjs";
    private static final String CHROME = "chrome";
    private static final String HTML_UNIT = "htmlunit";
    private static final String PHANTOMJS = "phantomjs";

    /*Platform constants*/
    public static final String WINDOWS = "WIN";
    public static final String MAC = "MAC";

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("browser.platform");

    public static final String grid = PropertyLoader.loadProperty("grid2.hub");

    public WebDriverFactory() {
    }

    public static WebDriverWrapper initDriver(){



        switch(browserName){

            case FIREFOX :
                System.setProperty("webdriver.gecko.driver", "/Users/iproskurnia/IdeaProjects/com.codespace.automation/src/main/resources/drivers/geckodriver");
                return driverWrapper = new WebDriverWrapper(new FirefoxDriver());

            case CHROME :
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver","/Users/iproskurnia/IdeaProjects/com.codespace.automation/src/main/resources/drivers/chromedriver");
                return driverWrapper = new WebDriverWrapper( new ChromeDriver(options));

            default:
                Assert.fail("invalid drivers name");
        }


//        if(FIREFOX.equals(browserName)){
//            driverWrapper = new WebDriverWrapper( new FirefoxDriver());}
//
//
//        else if(PHANTOMJS.equals(browserName)){
//
//            File phantomjs = Phanbedder.unpack();
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
//            driverWrapper = new WebDriverWrapper( new PhantomJSDriver(caps));
//
//
//        } else if(CHROME.equals(browserName)){
//            ChromeOptions options = new ChromeOptions();
//            driverWrapper = new WebDriverWrapper( new ChromeDriver(options));
//        }
//
//        else {
//            Assert.fail("invalid drivers name");
//        }

        driverWrapper.manage().deleteAllCookies();
        driverWrapper.manage().window().maximize();

        return driverWrapper;
    }

    public static WebDriverWrapper getInstance()  {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName(CHROME);
        capabilities.setJavascriptEnabled(true);
        capabilities.setPlatform(Platform.MAC);
        capabilities.setVersion("");
        try {
            driverWrapper = new WebDriverWrapper(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driverWrapper;

    }

}
