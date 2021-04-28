package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private WebDriver driver;
    private By welcomeMessage = By.id("center_column");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {

        return driver.findElement(welcomeMessage).getText();
    }
}
