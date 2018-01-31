package seleniumTest.pages;
import org.openqa.selenium.WebDriver;
import seleniumTest.utils.WebElementActions;

public class ProductDetailsPage {

    WebElementActions web;

    public ProductDetailsPage(WebDriver driver) {

        web = new WebElementActions(driver);
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

    public void isProductAddedToCart(){

        web.isElementPresent("cart.productAdded");
    }

    public void isSubtotalCorrect(){

        web.isElementPresent("cart.subtotal");
    }

    public void clickRemoveIcon(){

        web.clickButton("cart.remove.icon");
    }

    public void isCartEmpty(){

        web.isElementPresent("cart.empty");
        web.isElementPresent("cart.empty2");
    }


}
