package Login;

import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AccountPage;
import page.HomePage;
import page.LoginPage;

import java.io.FileInputStream;
import java.util.Properties;

import static org.testng.Assert.*;

public class LogInTests extends BaseTests {


    @Test
    @Parameters("browser")
    public void testSuccessfulLogin(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        ConfigFileReader reader = new ConfigFileReader();
        String email = reader.getProperty("loginEmail");
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
