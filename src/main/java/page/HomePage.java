package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;
    private By signUpButton = By.linkText("Sign in");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage clickSignUpButton(){

        driver.findElement(signUpButton).click();
        return new LoginPage(driver);
    }
}
