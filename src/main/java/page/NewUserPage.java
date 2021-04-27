package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserPage {

    private WebDriver driver;
    // private By emailField = By.id("email");
    // private By createButton = By.id("SubmitCreate");
    private By accountForm = By.xpath("//*[@id=\"columns\"]/div[1]/span[2]");
    private By mr_Title = By.id("uniform-id_gender1");
    private By mrs_Title = By.id("uniform-id_gender2");
    private By firstName = By.id("customer_firstname");
    private By lastName = By.id("customer_lastname");
    private By password = By.id("passwd");
    private By dayDropDown = By.id("days");
    private By exactDay = By.xpath("//*[@id=\"days\"]/option[2]");
    private By monthDropDown = By.id("months");
    private By exactMonth = By.xpath("//*[@id=\"months\"]/option[2]");
    private By yearDropDown = By.id("years");
    private By exactYear = By.xpath("//*[@id=\"years\"]/option[2000]");
    private By address = By.id("address1");
    private By city = By.id("city");
    private By stateDropDown = By.id("id_state");
    private By exactState = By.xpath("//*[@id=\"id_state\"]/option[4]");
    private By zipCode = By.id("postcode");
    private By countryDropDown = By.id("//*[@id=\"id_state\"]/option[21]");
    private By exactCountry = By.xpath("//*[@id=\"id_state\"]/option[4]");
    private By mobileP = By.id("phone_mobile");
    private By regButton = By.id("submitAccount");

    public NewUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {

        return driver.findElement(accountForm).getText();
    }


}
