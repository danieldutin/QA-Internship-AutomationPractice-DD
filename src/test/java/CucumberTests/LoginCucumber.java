package CucumberTests;

import base.BaseTests;
import helper.ConfigFileReader;
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

public class LoginCucumber extends BaseTests {

    HomePage homePage;
    AccountPage accountPage;
    ConfigFileReader reader = new ConfigFileReader();
    LoginPage loginPage;

    @Given("User is on the login page of the Automation Practice online store")
    public void user_is_on_the_login_page_of_the_Automation_Practice_online_store() throws Exception {
        homePage = new HomePage(startWebDriver("chrome"));
    }

    @When("When user click on Sign In button")
    public void click_on_sign_in() {
        homePage.clickSignUpButtonLogIn();
        loginPage = new LoginPage(driver);
    }

    @Then("The login page is available for the user")
    public void login_page_is_available(){
        assertTrue(driver.findElement(By.cssSelector("form#login_form")).isDisplayed());
    }

    @When("User enter valid credentials")
    public void enter_valid_credential_login(){
        loginPage.setEmailField(reader.getProperty(loginEmail));
        loginPage.setPasswordField(reader.getProperty(pass));
    }

    @And("User click on Login button")
    public void click_on_login_button(){
        loginPage.clickSignUpButton();
    }
    @Then("User must be redirected to My Account Page")
    public void user_must_be_redirected_to_Page() {
        accountPage = new AccountPage(driver);
        assertTrue(accountPage.getAlertText().contains(reader.getProperty(confirmed)), "Incorrect data");
        closingDown();
    }

}
