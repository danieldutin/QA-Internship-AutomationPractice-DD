package ProductListingPage;

import ProductDetailPage.ProductDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomanPage {

    private WebDriver driver;
    public static final By selectItemBtn = By.cssSelector("div.right-block a");

    public WomanPage(WebDriver driver) {

        this.driver = driver;
    }

    public ProductDetailPage clickOnProduct() {

        driver.findElement(selectItemBtn).click();
        return new ProductDetailPage(driver);
    }

}