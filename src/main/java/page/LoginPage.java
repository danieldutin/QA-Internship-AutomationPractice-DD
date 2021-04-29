package page;

import org.openqa.selenium.WebDriver;

import static Locators.Locators.*;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email) {

        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public void setPasswordField(String pass) {

        driver.findElement(PASSWORD_FIELD).sendKeys(pass);
    }

    public AccountPage clickSignUpButton() {

        driver.findElement(SUBMIT_BUTTON).click();
        return new AccountPage(driver);
    }

}


//private By emailField = By.id("email");
//private By passwordField = By.id("passwd");
//private By submitButton = By.id("SubmitLogin");