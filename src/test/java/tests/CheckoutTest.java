package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends Fixtures{

        @BeforeMethod
        public void methodSetUp()
        {
            demo.productDetailsPage.openPage();
        }

        @Test
        public void EstimateShippingAndTaxTest() throws Exception {

            demo.productDetailsPage.addProductToCart();
            demo.shoppingCart.estimateShippingTaxState();
        }

        @Test
        public void ProceedToCheckoutTest(){

            demo.productDetailsPage.addProductToCart();
            demo.shoppingCart.estimateShippingTaxState();
            demo.shoppingCart.proceedToCheckout();
        }
    }

