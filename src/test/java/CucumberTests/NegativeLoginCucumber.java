package CucumberTests;

import base.BaseTests;
import helper.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import page.AccountPage;
import page.HomePage;
import page.LoginPage;

import static Constants.ConfigFileConstants.*;
import static org.testng.Assert.assertTrue;

public class NegativeLoginCucumber extends BaseTests {

    HomePage homePage;
    AccountPage accountPage;
    ConfigFileReader reader = new ConfigFileReader();
    LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page_of_the_Automation_Practice_online_store() throws Exception {
        homePage = new HomePage(startWebDriver("chrome"));
    }

    @When("When user click on SignIn button")
    public void click_on_sign_in() {
        homePage.clickSignUpButtonLogIn();
        loginPage = new LoginPage(driver);
    }

    @Then("The login page is available for user")
    public void login_page_is_available(){
        assertTrue(driver.findElement(By.cssSelector("form#login_form")).isDisplayed());
    }

    @When("Invalid credentials are entered")
    public void valid_credentials_are_entered() {
        homePage.clickSignUpButtonLogIn();
        loginPage = new LoginPage(driver);
        loginPage.setEmailField(reader.getProperty(negativeEmailCreate));
        loginPage.setPasswordField(reader.getProperty(pass));
    }

    @And("User clicks on Login button")
    public void click_on_login_button(){
        loginPage.clickSignUpButton();
        accountPage = new AccountPage(driver);
    }

    @Then("Error message must be displayed")
    public void error_message() {
        assertTrue(loginPage.getAlertTextInvalidLogin().contains(reader.getProperty(thereIs1Error)));
        closingDown();
    }


}
