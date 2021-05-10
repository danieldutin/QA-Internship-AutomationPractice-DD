package Checkout;

import Payment.CheckoutPage;
import ProductDetailPage.ProductDetailPage;
import ProductListingPage.WomanPage;
import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import static Constants.ConfigFileConstants.*;
import static org.testng.Assert.assertTrue;

public class RegisteredUserCheckoutTests extends BaseTests {
    ConfigFileReader reader = new ConfigFileReader();

    @Test
    @Parameters("browser")
    public void addProductToCart(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        ConfigFileReader reader = new ConfigFileReader();

        LoginPage loginPage = homePage.clickSignUpButtonLogIn();
        loginPage.setEmailField(reader.getProperty(loginEmail));
        loginPage.setPasswordField(reader.getProperty(pass));
        loginPage.clickSignUpButton();

        WomanPage womanPage = homePage.clickWomanButton();

        ProductDetailPage productDetailPage = womanPage.clickOnProduct();

        CheckoutPage checkoutPage = productDetailPage.clickAddToCartBtn();
        checkoutPage.waitForLoad(driver);
        Thread.sleep(2000);
        checkoutPage.proceedToCheckout();
        checkoutPage.summaryProceed();
        checkoutPage.addressProceed();
        checkoutPage.clickOnCheckBox();
        checkoutPage.shippingProceed();
        checkoutPage.clickPayByWire();
        checkoutPage.clickConfirm();

        String actualResult = checkoutPage.getAlertText();

        assertTrue(actualResult.contains(reader.getProperty(orderComplete)), "Invalid operation");

    }
}
