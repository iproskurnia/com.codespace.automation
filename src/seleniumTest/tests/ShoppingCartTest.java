package seleniumTest.tests;

import org.testng.annotations.Test;
import seleniumTest.pages.Global;
import seleniumTest.pages.ProductDetailsPage;
import seleniumTest.pages.ProductListingPage;
import seleniumTest.pages.ShoppingCart;

public class ShoppingCartTest extends BrowserFixtures{

    //                           Add product To Cart ->>> Remove product from the Cart
    @Test
    public void AddToCartTest() throws Exception {
        driver.get(baseUrl);

        Global global = new Global(driver);
        ProductListingPage plp = new ProductListingPage(driver);
        ProductDetailsPage pdp =new ProductDetailsPage(driver);
        ShoppingCart cart = new ShoppingCart(driver);

        global.moveOnMenuItemAndClick();

        plp.clickOnProductImage();
        //plp.clickOnViewDetails();
        pdp.clickAndSelectColor();
        pdp.clickAndSelectSize();
        pdp.enterQuantity("2");
        pdp.clickAddToCartButton();

        cart.isProductAddedToCart();
        cart.isSubtotalCorrect();
        cart.clickRemoveIcon();
        cart.isCartEmpty();
    }
}
