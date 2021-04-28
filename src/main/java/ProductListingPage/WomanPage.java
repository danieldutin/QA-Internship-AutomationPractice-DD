package ProductListingPage;

import ProductDisplayPage.ProductDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomanPage {

    private WebDriver driver;

    //private By proceedToCheckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
    private By selectItemButton = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");

    public WomanPage(WebDriver driver) {

        this.driver = driver;
    }

    public ProductDetailPage clickOnProduct() {

        driver.findElement(selectItemButton).click();
        return new ProductDetailPage(driver);
    }

}
