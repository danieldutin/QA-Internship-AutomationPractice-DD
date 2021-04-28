package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserPage {

    private WebDriver driver;
    private By accountForm = By.xpath("//*[@id=\"columns\"]/div[1]/span[2]");
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
    private By regButton = By.id("submitAccount");


    public NewUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {

        return driver.findElement(accountForm).getText();
    }

    public void setTitle(String pass) {

        if (pass.equals("Mr.")) {
            driver.findElement(mr_Title).click();
        } else if (pass.equals("Mrs.")) {
            driver.findElement(mrs_Title).click();
        }
    }

    public void setFirstName(String firstname) {

        driver.findElement(firstName).sendKeys(firstname);
    }

    public void setLastName(String lastname) {

        driver.findElement(lastName).sendKeys(lastname);
    }

    public void setPassword(String password) {

        driver.findElement(passWord).sendKeys(password);
    }

    public void selectDayDropDown() {

        driver.findElement(dayDropDown).click();
        driver.findElement(exactDay).click();
    }

    public void selectMonthDropDown() {

        driver.findElement(monthDropDown).click();
        driver.findElement(exactMonth).click();
    }

    public void selectYearDropDown() {

        driver.findElement(yearDropDown).click();
        driver.findElement(exactYear).click();
    }

    public void setAddressLineOne(String address) {

        driver.findElement(addressLineOne).sendKeys(address);
    }

    public void setCity(String city) {

        driver.findElement(cityInput).sendKeys(city);
    }

    public void setZipCode(String zip) {

        driver.findElement(zipCode).sendKeys(zip);
    }

    public void selectStateDropDown() {

        driver.findElement(stateDropDown).click();
        driver.findElement(exactState).click();
    }

    public void setMobileP(String mobile) {

        driver.findElement(mobileP).sendKeys(mobile);
    }

    public AccountPage clickRegButton() {

        driver.findElement(regButton).click();
        return new AccountPage(driver);
    }

     /*public void selectCountryDropDown() {

        driver.findElement(countryDropDown).click();
        driver.findElement(exactCountry).click();
    }*/

}
