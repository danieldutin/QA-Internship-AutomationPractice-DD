package Checkout;

import Payment.ShoppingCartPage;
import ProductDisplayPage.ProductDetailPage;
import ProductListingPage.WomanPage;
import base.BaseTests;
import helper.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.CreateAccountPage;
import page.HomePage;
import page.NewUserPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class GuestCheckoutTests extends BaseTests {

    ConfigFileReader reader = new ConfigFileReader();

    @Test
    public void addProductToCart() throws Exception {

        HomePage homePage = new HomePage(startWebDriver());

        String email = reader.getProperty("loginEmail");
        String pass = reader.getProperty("pass");
        String expectedResult = reader.getProperty("orderComplete");
        By addToCartBtn = By.xpath("//*[@id=\"add_to_cart\"]/button");

        WomanPage womanPage = homePage.clickWomanButton();

        ProductDetailPage  productDetailPage = womanPage.clickOnProduct();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

        ShoppingCartPage shoppingCart = productDetailPage.clickAddToCartBtn();

        shoppingCart.clickOnProceedBtn();
        shoppingCart.clickOnProceedBtn();
        shoppingCart.setEmailField(email);
        shoppingCart.setPasswordField(pass);
        shoppingCart.clickOnSignIn();
        shoppingCart.clickOnCheckBox();
        shoppingCart.clickOnProceedBtn();
        shoppingCart.clickPayByWire();
        shoppingCart.clickConfirm();

        String actualResult = shoppingCart.getAlertText();

        assertTrue(actualResult.contains(expectedResult), "Invalid operation");

    }
}
