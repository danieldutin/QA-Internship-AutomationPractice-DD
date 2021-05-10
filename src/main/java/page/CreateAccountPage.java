package page;

import org.openqa.selenium.WebDriver;

import static Locators.Locators.*;

public class CreateAccountPage {

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email) {

        driver.findElement(NEW_EMAIL).sendKeys(email);
    }

    public NewUserPage clickCreateButton() {

        driver.findElement(CREATE_BUTTON).click();
        return new NewUserPage(driver);
    }

    public String getAlertTextInvalidEmail() {

        return driver.findElement(ERROR_MESSAGE_CREATE_ACC_INVALID_EMAIL).getText();
    }

}

//private By newEmail = By.id("email_create");
//private By createButton = By.id("SubmitCreate");
