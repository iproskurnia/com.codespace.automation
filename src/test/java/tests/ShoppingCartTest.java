package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest extends Fixtures {

    @BeforeMethod
    public void methodSetUp()
    {
        demo.productDetailsPage.openPage();
    }

    //                           Add product To Cart ->>> Remove product from the Cart
    @Test
    public void AddToCartTest() throws Exception {

        demo.productDetailsPage.clickAndSelectColor();
        demo.productDetailsPage.clickAndSelectSize();
        demo.productDetailsPage.enterQuantity("2");
        demo.productDetailsPage.clickAddToCartButton();

        demo.shoppingCart.isProductAddedToCart();
        demo.shoppingCart.isSubtotalCorrect();
    }

    @Test
    public void RemoveItemsFromCartTest() throws Exception {

        demo.productDetailsPage.addProductToCart();
        demo.shoppingCart.clickRemoveIcon();
        demo.shoppingCart.isCartEmpty();
    }
}
