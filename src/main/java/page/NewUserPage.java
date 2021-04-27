package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserPage {

    private WebDriver driver;
   // private By emailField = By.id("email");
   // private By createButton = By.id("SubmitCreate");
    private By accountForm = By.xpath("//*[@id=\"columns\"]/div[1]/span[2]");

    public NewUserPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){

        return driver.findElement(accountForm).getText();
    }


}
