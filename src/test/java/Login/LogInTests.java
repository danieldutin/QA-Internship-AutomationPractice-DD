package Login;

import base.BaseTests;
import org.testng.annotations.Test;
import page.AccountPage;
import page.LoginPage;

import java.io.FileInputStream;
import java.util.Properties;

import static org.testng.Assert.*;

public class LogInTests extends BaseTests {


    @Test
    public void testSuccessfulLogin() throws Exception{

        FileInputStream propRead = new FileInputStream("resources\\config.properties");
        Properties prop = new Properties();
        prop.load(propRead);

        String email = prop.getProperty("email");
        String pass = prop.getProperty("pass");
        String welcome = prop.getProperty("welcome");

       LoginPage loginPage = homePage.clickSignUpButtonLogIn();
       loginPage.setEmailField(email);
       loginPage.setPasswordField(pass);
       AccountPage accountPage = loginPage.clickSignUpButton();
       assertTrue(accountPage.getAlertText().contains(welcome), "Incorrect data");

    }
}
