package page;

import org.openqa.selenium.WebDriver;
import static Locators.Locators.*;

public class AccountPage {

    private WebDriver driver;
    //private By welcomeMessage = By.id("center_column");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {

        return driver.findElement(WELCOME_MESSAGE).getText();
    }
}
