package Checkout;

import Payment.CheckoutPage;
import ProductDisplayPage.ProductDetailPage;
import ProductListingPage.WomanPage;
import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Test;
import page.AccountPage;
import page.HomePage;
import page.LoginPage;

import static org.testng.Assert.assertTrue;

public class RegisteredUserCheckoutTests extends BaseTests {
    ConfigFileReader reader = new ConfigFileReader();

    @Test
    public void addProductToCart() throws Exception {

        HomePage homePage = new HomePage(startWebDriver());

        ConfigFileReader reader = new ConfigFileReader();
        String email = reader.getProperty("loginEmail");
        String pass = reader.getProperty("pass");

        LoginPage loginPage = homePage.clickSignUpButtonLogIn();
        loginPage.setEmailField(email);
        loginPage.setPasswordField(pass);
        loginPage.clickSignUpButton();

        String expectedResult = reader.getProperty("orderComplete");

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

        assertTrue(actualResult.contains(expectedResult), "Invalid operation");

    }
}
