package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.WebDriverWrapper;

public class ProductDetailsPage extends GlobalPageHeader{

    private static final String PDP_URL = "http://magento-demo.lexiconn.com/men/tees-knits-and-polos/merino-v-neck-pullover-sweater-480.html";
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ProductDetailsPage(WebDriverWrapper dr) {
        super(dr, PDP_URL);
    }

    public void isTitleCorrect(){

        web.isElementPresent("pdp.isTitleCorrect");

    }

    public void clickAndSelectColor(){

        web.clickElement("pdp.select.color");
        web.clickElement("pdp.select.color.red");
    }

    public void clickAndSelectSize(){

        web.clickElement("pdp.select.size");
        web.clickElement("pdp.select.size.L");
    }

    public void enterQuantity(String qty){

        web.input("pdp.input.qty", qty);
    }

    public void clickAddToCartButton(){

        web.clickButton("pdp.addToCart.button");
    }

    public void addProductToCart(){

        clickAndSelectColor();
        clickAndSelectSize();
        clickAddToCartButton();
    }

}
