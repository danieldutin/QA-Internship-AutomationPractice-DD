package page;

import org.openqa.selenium.WebDriver;
import static Locators.Locators.*;

public class NewUserPage {

    private WebDriver driver;
    /*private By accountForm = By.xpath("//*[@id=\"columns\"]/div[1]/span[2]");
    private By mr_Title = By.id("uniform-id_gender1");
    private By mrs_Title = By.id("uniform-id_gender2");
    private By firstName = By.id("customer_firstname");
    private By lastName = By.id("customer_lastname");
    private By passWord = By.id("passwd");
    private By dayDropDown = By.id("days");
    private By exactDay = By.xpath("//*[@id=\"days\"]/option[2]");
    private By monthDropDown = By.id("months");
    private By exactMonth = By.xpath("//*[@id=\"months\"]/option[2]");
    private By yearDropDown = By.id("years");
    private By exactYear = By.xpath("//*[@id=\"years\"]/option[21]");
    private By addressLineOne = By.id("address1");
    private By cityInput = By.id("city");
    private By stateDropDown = By.id("id_state");
    private By exactState = By.xpath("//*[@id=\"id_state\"]/option[4]");
    private By zipCode = By.id("postcode");
    //private By countryDropDown = By.id("//*[@id=\"id_state\"]/option[21]");
    //private By exactCountry = By.xpath("//*[@id=\"id_state\"]/option[4]");
    private By mobileP = By.id("phone_mobile");
    private By regButton = By.id("submitAccount");*/


    public NewUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {

        return driver.findElement(ACCOUNT_FORM).getText();
    }

    public void setTitle(String pass) {

        if (pass.equals("Mr.")) {
            driver.findElement(MR_TITLE).click();
        } else if (pass.equals("Mrs.")) {
            driver.findElement(MRS_TITLE).click();
        }
    }

    public void setFirstName(String firstname) {

        driver.findElement(FIRST_NAME).sendKeys(firstname);
    }

    public void setLastName(String lastname) {

        driver.findElement(LAST_NAME).sendKeys(lastname);
    }

    public void setPassword(String password) {

        driver.findElement(PASS_WORD).sendKeys(password);
    }

    public void selectDayDropDown() {

        driver.findElement(DAY_DROP_DOWN).click();
        driver.findElement(EXACT_DAY).click();
    }

    public void selectMonthDropDown() {

        driver.findElement(MONTH_DROP_DOWN).click();
        driver.findElement(EXACT_MONTH).click();
    }

    public void selectYearDropDown() {

        driver.findElement(YEAR_DROP_DOWN).click();
        driver.findElement(EXACT_YEAR).click();
    }

    public void setAddressLineOne(String address) {

        driver.findElement(ADDRESS_LINE_ONE).sendKeys(address);
    }

    public void setCity(String city) {

        driver.findElement(CITY_INPUT).sendKeys(city);
    }

    public void setZipCode(String zip) {

        driver.findElement(ZIP_CODE).sendKeys(zip);
    }

    public void selectStateDropDown() {

        driver.findElement(STATE_DROP_DOWN).click();
        driver.findElement(EXACT_STATE).click();
    }

    public void setMobileP(String mobile) {

        driver.findElement(MOBILE_P).sendKeys(mobile);
    }

    public AccountPage clickRegButton() {

        driver.findElement(REG_BUTTON).click();
        return new AccountPage(driver);
    }

     /*public void selectCountryDropDown() {

        driver.findElement(countryDropDown).click();
        driver.findElement(exactCountry).click();
    }*/

}
