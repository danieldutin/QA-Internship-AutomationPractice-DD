package page;

import ProductListingPage.WomanPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;
    private By signUpButton = By.linkText("Sign in");
    private By womanButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickSignUpButtonLogIn() {

        driver.findElement(signUpButton).click();
        return new LoginPage(driver);
    }

    public CreateAccountPage clickSignUpButtonCreate() {

        driver.findElement(signUpButton).click();
        return new CreateAccountPage(driver);
    }

    public WomanPage clickWomanButton() {

        driver.findElement(womanButton).click();
        return new WomanPage(driver);
    }

}
