package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserPage {

    private WebDriver driver;
    private By emailField = By.id("email");
    private By createButton = By.id("SubmitCreate");
    private By successfulMessage = By.id("noSlide");
    public NewUserPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){

        return driver.findElement(successfulMessage).getText();
    }


}
