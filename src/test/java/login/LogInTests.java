package login;

import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AccountPage;
import page.HomePage;
import page.LoginPage;

import static constants.ConfigFileConstants.*;
import static org.testng.Assert.*;

public class LogInTests extends BaseTests {


    @Test
    @Parameters("browser")
    public void testSuccessfulLogin(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        ConfigFileReader reader = new ConfigFileReader();

        LoginPage loginPage = homePage.clickSignUpButtonLogIn();
        loginPage.setEmailField(reader.getProperty(loginEmail));
        loginPage.setPasswordField(reader.getProperty(pass));
        AccountPage accountPage = loginPage.clickSignUpButton();
        String myAccountText = accountPage.getAlertText();

        assertTrue(myAccountText.contains(reader.getProperty(confirmed)), "Incorrect data");

    }
}
