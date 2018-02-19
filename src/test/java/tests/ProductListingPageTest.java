package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static seleniumTest.utils.getCurrentClassAndMethodNames.getCurrentClassAndMethodNames;

public class ProductListingPageTest extends Fixtures {

    @BeforeMethod
    public void methodSetUp()
    {
        demo.productListingPage.openPage();
    }

    //                           PLP & go to PDP
    @Test
    public void ProductListPageTest() throws Exception {

        //demo.homePage.proceedToPLP();
        demo.productListingPage.isPlpPage();
        demo.productListingPage.isPricePresent();
        demo.productListingPage.isPriceCorrect();
        demo.productListingPage.clickOnProductImage();
        demo.screenShotMaker.takeScreenShot(getCurrentClassAndMethodNames());
       // demo.productListingPage.clickOnProductTitle();
        //demo.productListingPage.clickOnViewDetails();
    }
}
