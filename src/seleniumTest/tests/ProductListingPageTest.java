package seleniumTest.tests;

import org.testng.annotations.Test;
import seleniumTest.pages.Global;
import seleniumTest.pages.ProductListingPage;

public class ProductListingPageTest extends LoginFixtures{

    //                           PLP & go to PDP
    @Test
    public void ProductListPageTest() throws Exception {
        driver.get(baseUrl);

        Global global = new Global(driver);
        ProductListingPage plp = new ProductListingPage(driver);
        global.moveOnMenuItemAndClick();
        plp.isPlpPage();
        plp.isPricePresent();
        plp.isPriceCorrect();
        //plp.clickOnProductImage();
        //plp.clickOnProductTitle();
        plp.clickOnViewDetails();
    }
}
