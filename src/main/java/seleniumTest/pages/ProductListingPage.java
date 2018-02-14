package seleniumTest.pages;

import org.apache.log4j.Logger;
import seleniumTest.utils.ClassNameUtil;
import seleniumTest.utils.WebDriverWrapper;

public class ProductListingPage extends GlobalPageHeader{

    private static final String PLP_URL = "http://magento-demo.lexiconn.com/men/tees-knits-and-polos.html";
    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ProductListingPage(WebDriverWrapper dr) {
        super(dr, PLP_URL);
    }


    public void isPlpPage(){
        web.getElementText("plp.title");
    }

    public void clickOnProductImage(){
        web.clickButton("plp.men.tees_knits_polos.productImage");
    }

    public void clickOnProductTitle(){
        web.clickButton("plp.men.tees_knits_polos.productTitle");
    }

    public void clickOnViewDetails(){
        web.clickButton("plp.product.viewDetails");
    }

    public void isPricePresent(){

        web.isElementPresent("plp.mentees_knits_polos.product.price");
    }

    public void isPriceCorrect() {
        web.isElementPresent("plp.mentees_knits_polos.product.price.correct");
    }
}
