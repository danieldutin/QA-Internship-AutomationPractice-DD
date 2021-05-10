package ProductListingPage;

import ProductDisplayPage.ProductDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomanPage {

    private WebDriver driver;
    public static final By selectItemBtn = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");

    public WomanPage(WebDriver driver) {

        this.driver = driver;
    }

    public ProductDetailPage clickOnProduct() {

        driver.findElement(selectItemBtn).click();
        return new ProductDetailPage(driver);
    }

}