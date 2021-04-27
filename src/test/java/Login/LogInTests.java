package Login;

import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Test;
import page.AccountPage;
import page.HomePage;
import page.LoginPage;

import java.io.FileInputStream;
import java.util.Properties;

import static org.testng.Assert.*;

public class LogInTests extends BaseTests {


    @Test
    public void testSuccessfulLogin() throws Exception {

        HomePage homePage = new HomePage(startWebDriver());

        ConfigFileReader reader = new ConfigFileReader();
        String email = reader.getProperty("email");
        String pass = reader.getProperty("pass");
        String welcome = reader.getProperty("welcome");

        LoginPage loginPage = homePage.clickSignUpButtonLogIn();
        loginPage.setEmailField(email);
        loginPage.setPasswordField(pass);
        AccountPage accountPage = loginPage.clickSignUpButton();
        String myAccountText = accountPage.getAlertText();

        assertTrue(myAccountText.contains(welcome), "Incorrect data");

    }
}
