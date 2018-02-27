package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.PropertyLoader;
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

    public void enterShippingTaxPostcode(String postcode){

        web.input("cart.shipping.zipcode", postcode);
    }
    public void enterShippingTaxCity(String city){

        web.input("cart.shipping.city", city);
    }

    public void estimateShippingTaxState(){

        web.clickElement("cart.shipping.state.dropdown");
        web.clickElement("cart.shipping.state.illinois");
        enterShippingTaxCity(PropertyLoader.loadProperty("shipping.city"));
        enterShippingTaxPostcode(PropertyLoader.loadProperty("shipping.zip"));
        web.clickButton("cart.shipping.estimate");
        web.clickElement("cart.shipping.method.free");
        web.clickButton("cart.shipping.update.total");
    }

    public void proceedToCheckout(){

        web.clickButton("cart.shipping.checkout.button");
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
