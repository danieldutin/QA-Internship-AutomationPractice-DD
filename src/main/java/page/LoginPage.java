package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By submitButton = By.id("SubmitLogin");
    private By errMsgInvalidEmail = By.cssSelector("div.alert-danger p");
    private By loginForm = By.cssSelector("form#login_form h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email) {

        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String pass) {

        driver.findElement(passwordField).sendKeys(pass);
    }

    public AccountPage clickSignUpButton() {

        driver.findElement(submitButton).click();
        return new AccountPage(driver);
    }

    public String getAlertTextInvalidLogin() {

        return driver.findElement(errMsgInvalidEmail).getText();
    }

    public String getLoginForm(){

        return driver.findElement(loginForm).getText();
    }

}