package Checkout;

import Payment.CheckoutPage;
import ProductDetailPage.ProductDetailPage;
import ProductListingPage.WomanPage;
import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.HomePage;

import static Constants.ConfigFileConstants.*;
import static org.testng.Assert.assertTrue;

public class GuestCheckoutTests extends BaseTests {

    ConfigFileReader reader = new ConfigFileReader();

    @Test
    @Parameters("browser")
    public void addProductToCart(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        WomanPage womanPage = homePage.clickWomanButton();

        ProductDetailPage productDetailPage = womanPage.clickOnProduct();

        CheckoutPage checkoutPage = productDetailPage.clickAddToCartBtn();
        checkoutPage.waitForLoad(driver);
        Thread.sleep(2000);
        checkoutPage.proceedToCheckout();
        checkoutPage.summaryProceed();
        checkoutPage.setEmailField(reader.getProperty(loginEmail));
        checkoutPage.setPasswordField(reader.getProperty(pass));
        checkoutPage.clickOnSignIn();
        checkoutPage.addressProceed();
        checkoutPage.clickOnCheckBox();
        checkoutPage.shippingProceed();
        checkoutPage.clickPayByWire();
        checkoutPage.clickConfirm();

        String actualResult = checkoutPage.getAlertText();

        assertTrue(actualResult.contains(reader.getProperty(orderComplete)), "Invalid operation");

    }
}
