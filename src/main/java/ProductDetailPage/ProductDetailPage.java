package ProductDetailPage;

import Payment.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private WebDriver driver;
    private By addToCartBtn = By.cssSelector("div.box-cart-bottom button");

    public ProductDetailPage(WebDriver driver) {

        this.driver = driver;
    }

    public CheckoutPage clickAddToCartBtn() {

        driver.findElement(addToCartBtn).click();
        return new CheckoutPage(driver);
    }

}