package seleniumTest.tests;

import org.testng.annotations.Test;
import seleniumTest.pages.Global;
import seleniumTest.pages.ProductDetailsPage;
import seleniumTest.pages.ProductListingPage;


@Test
public class ProductDetailsPageTest extends LoginFixtures{

    public void ProductDetailPageTest() throws Exception {

        driver.get(baseUrl);
        Global global = new Global(driver);
        ProductListingPage plp = new ProductListingPage(driver);
        ProductDetailsPage pdp =new ProductDetailsPage(driver);
        global.clickTitle();
        global.moveOnMenuItemAndClick();
        plp.clickOnProductImage();
        pdp.isTitleCorrect();
        pdp.clickAndSelectColor();
        pdp.clickAndSelectSize();
        pdp.enterQuantity("2");
        pdp.clickAddToCartButton();
    }
}
