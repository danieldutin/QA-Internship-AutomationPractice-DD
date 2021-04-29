package ProductListingPage;

import ProductDisplayPage.ProductDetailPage;
import org.openqa.selenium.WebDriver;

import static Locators.Locators.SELECT_ITEM_BUTTON;

public class WomanPage {

    private WebDriver driver;

    public WomanPage(WebDriver driver) {

        this.driver = driver;
    }

    public ProductDetailPage clickOnProduct() {

        driver.findElement(SELECT_ITEM_BUTTON).click();
        return new ProductDetailPage(driver);
    }

}

//private By proceedToCheckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
//private By selectItemButton = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
