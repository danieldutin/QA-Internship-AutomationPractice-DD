package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

    private WebDriver driver;
    private By newEmail = By.id("email_create");
    private By createButton = By.id("SubmitCreate");
    private By errMsgCreateAccInvalidEmail = By.xpath("//*[@id=\"create_account_error\"]/ol/li");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email) {

        driver.findElement(newEmail).sendKeys(email);
    }

    public NewUserPage clickCreateButton() {

        driver.findElement(createButton).click();
        return new NewUserPage(driver);
    }

    public String getAlertTextInvalidEmail() {

        return driver.findElement(errMsgCreateAccInvalidEmail).getText();
    }

}

//private By newEmail = By.id("email_create");
//private By createButton = By.id("SubmitCreate");
