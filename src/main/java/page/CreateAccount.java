package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collection;

public class CreateAccount {

    private WebDriver driver;
    private By newEmail = By.id("email_create");
    private By createButton = By.id("SubmitCreate");


    public CreateAccount(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailField(String email){

        driver.findElement(newEmail).sendKeys(email);
    }

    public NewUserPage clickCreateButton(){

        driver.findElement(createButton).click();
        return new NewUserPage(driver);
    }

}
