package login;

import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import static constants.ConfigFileConstants.*;
import static org.testng.Assert.assertTrue;

public class NegativeLoginTests extends BaseTests {

    @Test
    @Parameters("browser")
    public void testInvalidInputLogin(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        ConfigFileReader reader = new ConfigFileReader();

        LoginPage loginPage = homePage.clickSignUpButtonLogIn();
        loginPage.setEmailField(reader.getProperty(negativeEmailCreate));
        loginPage.setPasswordField(reader.getProperty(pass));
        loginPage.clickSignUpButton();
        Thread.sleep(2000);
        String error = loginPage.getAlertTextInvalidLogin();

        assertTrue(error.contains(reader.getProperty(thereIs1Error)));

    }
}
