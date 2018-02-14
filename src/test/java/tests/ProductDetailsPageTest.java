package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProductDetailsPageTest extends Fixtures {

    @BeforeMethod
    public void methodSetUp()
    {
        demo.homePage.openPage();
    }

    @Test
    public void ProductDetailPageTest() throws Exception {

        demo.homePage.proceedToPLP();
//        demo.homePage.moveToElementAndClick();
        //demo.productListingPage.clickOnProductImage();
        demo.productListingPage.clickOnViewDetails();
        demo.productDetailsPage.isTitleCorrect();
        demo.productDetailsPage.clickAndSelectColor();
        demo.productDetailsPage.clickAndSelectSize();
        demo.productDetailsPage.enterQuantity("2");
        demo.productDetailsPage.clickAddToCartButton();
    }
}
