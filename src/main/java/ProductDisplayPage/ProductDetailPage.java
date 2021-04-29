package ProductDisplayPage;

import Payment.CheckoutPage;
import org.openqa.selenium.WebDriver;

import static Locators.Locators.*;

public class ProductDetailPage {

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {

        this.driver = driver;
    }

    public CheckoutPage clickAddToCartBtn() {

        driver.findElement(ADD_TO_CART_BTN).click();
        return new CheckoutPage(driver);
    }

}

//private By addToCartBtn = By.xpath("//*[@id=\"add_to_cart\"]/button");
