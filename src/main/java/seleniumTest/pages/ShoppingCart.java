package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.WebDriverWrapper;

public class ShoppingCart extends GlobalPageHeader{

    private static final String CART_URL = "magento-demo.lexiconn.com/checkout/cart/";
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ShoppingCart(WebDriverWrapper dr) {
        super(dr, CART_URL);
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
