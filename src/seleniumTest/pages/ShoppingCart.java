package seleniumTest.pages;

import org.openqa.selenium.WebDriver;
import seleniumTest.utils.WebElementActions;

public class ShoppingCart {

        WebElementActions web;

        public ShoppingCart(WebDriver driver) {

            web = new WebElementActions(driver);
        }

        public void isProductAddedToCart(){

            web.isElementPresent("cart.productAdded");
        }

        public void isSubtotalCorrect(){

            web.isElementPresent("cart.subtotal");
        }

        public void clickRemoveIcon(){

            web.clickButton("cart.remove.icon");
        }

        public void isCartEmpty() {

            web.isElementPresent("cart.empty");
            web.isElementPresent("cart.empty2");
        }
}
