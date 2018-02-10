package seleniumTest.pages;

import seleniumTest.utils.WebDriverWrapper;
import seleniumTest.utils.WebElementsActions;

public class Demo {

    public WebElementsActions web;
    public MyAccountPage myAccountPage;
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductDetailsPage productDetailsPage;
    public ProductListingPage productListingPage;
    public RegistrationPage registrationPage;
    public ShoppingCart shoppingCart;

    public Demo(WebDriverWrapper driver) {
        
        web  = new WebElementsActions(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productListingPage = new ProductListingPage(driver);
        registrationPage = new RegistrationPage(driver);
        shoppingCart = new ShoppingCart(driver);

    }

}
