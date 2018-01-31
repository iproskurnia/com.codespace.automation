package seleniumTest.pages;

import org.openqa.selenium.WebDriver;
import seleniumTest.utils.WebElementActions;

public class ProductListingPage {

    WebElementActions web;

    public ProductListingPage(WebDriver driver) {
        web = new WebElementActions(driver);
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
