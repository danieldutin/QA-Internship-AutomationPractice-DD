package CucumberTests;

import base.BaseTests;
import helper.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("Valid credentials are entered")
    public void valid_credentials_are_entered() {
        homePage.clickSignUpButtonLogIn();
        loginPage = new LoginPage(driver);
        loginPage.setEmailField(reader.getProperty(loginEmail));
        loginPage.setPasswordField(reader.getProperty(pass));
        loginPage.clickSignUpButton();
    }

    @Then("User must be redirected to My Account Page")
    public void user_must_be_redirected_to_Page() {
        accountPage = new AccountPage(driver);
        String myAccountText = accountPage.getAlertText();
        assertTrue(myAccountText.contains(reader.getProperty(confirmed)), "Incorrect data");
        closingDown();
    }

}
