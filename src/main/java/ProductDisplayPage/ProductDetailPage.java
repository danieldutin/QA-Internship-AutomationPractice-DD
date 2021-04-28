package ProductDisplayPage;

import Payment.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private WebDriver driver;
        private By addToCartBtn = By.xpath("//*[@id=\"add_to_cart\"]/button");
    public ProductDetailPage(WebDriver driver){

        this.driver = driver;
    }

    public ShoppingCartPage clickAddToCartBtn() {

        driver.findElement(addToCartBtn).click();
        return new ShoppingCartPage(driver);
    }




}
