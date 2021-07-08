package phoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private By cartBlockList = By.cssSelector("dt.item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

}

