package Login;

import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AccountPage;
import page.HomePage;
import page.LoginPage;
import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class NegativeLoginTests extends BaseTests {

    @Test
    @Parameters("browser")
    public void testInvalidInputLogin(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        ConfigFileReader reader = new ConfigFileReader();
        String email = reader.getProperty("negativeEmailCreate");
        String pass = reader.getProperty("pass");
        String errorMessage = reader.getProperty("invalidEmailMessage");

        LoginPage loginPage = homePage.clickSignUpButtonLogIn();
        loginPage.setEmailField(email);
        loginPage.setPasswordField(pass);
        loginPage.clickSignUpButton();
        String error = loginPage.getAlertTextInvalidLogin();

        assertTrue(error.contains(errorMessage));

    }
}
