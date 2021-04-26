package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By submitButton = By.id("SubmitLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailField(String email){

        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String pass){

        driver.findElement(passwordField).sendKeys(pass);
    }

    public AccountPage clickSignUpButton(){

        driver.findElement(submitButton).click();
        return new AccountPage(driver);
    }

}
