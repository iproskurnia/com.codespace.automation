package seleniumTest.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumTest.pages.*;
import seleniumTest.utils.UiMappingSingleton;
import seleniumTest.utils.WebElementActions;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.fail;


public class SeleniumFirstLesson {

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

//    @Test
//    public void searchSmth() throws Exception {
//        driver.get("https://www.google.com.ua/");
//        GoogleHomePage ghm = new GoogleHomePage(driver);
//        ghm.inputSomeValue("zerg rush");
//        ghm.submitSearch();
//    }

    //              Test Login with empty Email and Password fields
    @Test
    public void emptyLoginCredentialsTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickSubmitButton();
        loginPage.getElementText("loginpage.emptyemail");
        loginPage.getElementText("loginpage.emptypass");
    }

    //          Test login with an empty Email field
    @Test
    public void emptyEmailLoginTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.enterEmail("");
        loginPage.enterPassword("testtest");
        loginPage.clickSubmitButton();
        loginPage.getElementText("loginpage.emptyemail");

    }
    //                                               Test login with an empty Password field
    @Test
    public void emptyPasswordLoginTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.enterEmail("iaroslav.proskurnia@gmail.com");
        loginPage.enterPassword("");
        loginPage.clickSubmitButton();
        loginPage.getElementText("loginpage.emptypass");
    }

    //                                              Test login with incorrect email and password
    @Test
    public void nonExistUserLoginTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.getElementText("loginpage.invaliddata");
    }

    //                                              Test email with correct data entered
    @Test
    public void successLoginTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.enterEmail("iaroslav.proskurnia@gmail.com");
        loginPage.enterPassword("testtest");
        loginPage.clickSubmitButton();
        loginPage.getElementText(helloLogText);
    }

    //                                              Test registration
    @Test
    public void registrationTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        registrationPage.enterFirstName("iaroslav");
        registrationPage.enterLastName("proskurnia");
        registrationPage.enterEmail("iaroslav.proskurnia"+random+"@gmail.com");
        registrationPage.enterRegPassword("testtest");
        registrationPage.confirmRegPassword("testtest");
        registrationPage.clickRegisterButton();
        registrationPage.getElementText(helloRegMessage);

    }

    //                           PLP & go to PDP ->> Add product To Cart ->>> Remove product from the Cart
    @Test
    public void ProductListPageTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        ProductListingPage plp = new ProductListingPage(driver);
        ProductDetailsPage pdp =new ProductDetailsPage(driver);
        ShoppingCart cart = new ShoppingCart(driver);

        homePage.moveOnMenuItemAndClick();

        plp.isPlpPage();
        plp.isPricePresent();
        plp.isPriceCorrect();
        //plp.clickOnProductImage();
        //plp.clickOnProductTitle();
        plp.clickOnViewDetails();
    }

    @Test
    public void ProductDetailPageTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        ProductListingPage plp = new ProductListingPage(driver);
        ProductDetailsPage pdp =new ProductDetailsPage(driver);
        ShoppingCart cart = new ShoppingCart(driver);

        homePage.moveOnMenuItemAndClick();
        plp.clickOnProductTitle();

        pdp.isTitleCorrect();
        pdp.clickAndSelectColor();
        pdp.clickAndSelectSize();
        pdp.enterQuantity("2");
        pdp.clickAddToCartButton();
    }

    //                           Add product To Cart ->>> Remove product from the Cart
    @Test
    public void AddToCartTest() throws Exception {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        ProductListingPage plp = new ProductListingPage(driver);
        ProductDetailsPage pdp =new ProductDetailsPage(driver);
        ShoppingCart cart = new ShoppingCart(driver);

        homePage.moveOnMenuItemAndClick();
        plp.clickOnProductImage();
        plp.clickOnViewDetails();
        pdp.clickAndSelectColor();
        pdp.clickAndSelectSize();
        pdp.enterQuantity("2");
        pdp.clickAddToCartButton();
        cart.isProductAddedToCart();
        cart.isSubtotalCorrect();
        cart.clickRemoveIcon();
        cart.isCartEmpty();
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

