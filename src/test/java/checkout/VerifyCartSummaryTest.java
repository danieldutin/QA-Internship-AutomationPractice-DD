package checkout;

import payment.CheckoutPage;
import base.BaseTests;
import helper.ConfigFileReader;
import org.junit.Test;
import org.testng.annotations.Parameters;
import page.HomePage;

import static org.testng.Assert.assertEquals;

public class VerifyCartSummaryTest extends BaseTests {

    ConfigFileReader reader = new ConfigFileReader();

    @Test
    @Parameters("browser")
    public void verifyCartSummary(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));
        homePage.addProductsToTheCart();
        homePage.clickOnCart();
        CheckoutPage checkoutPage = homePage.clickOnCheckOut();

        assertEquals(checkoutPage.itemsInCheckout(), 5);
    }
}
