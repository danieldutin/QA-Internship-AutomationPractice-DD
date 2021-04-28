package ProductListingPage;

import Payment.ShoppingCartPage;
import ProductDisplayPage.ProductDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

public class WomanPage {

    private WebDriver driver;

    //private By proceedToCheckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
    private By buttonContainer = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");

    public WomanPage(WebDriver driver) {

        this.driver = driver;
    }

    public ProductDetailPage clickOnProduct() {

        driver.findElement(buttonContainer).click();
        return new ProductDetailPage(driver);
    }

}
