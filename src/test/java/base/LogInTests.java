package base;

import org.testng.annotations.Test;
import page.AccountPage;
import page.LoginPage;

import java.io.FileInputStream;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class LogInTests extends BaseTests{

    @Test
    public void testSuccessfulLogin() throws Exception{

        FileInputStream propRead = new FileInputStream("C:\\Users\\danie\\IdeaProjects\\QA-Internship-AutomationPractice-DD\\resources");
        Properties prop = new Properties();
        prop.load(propRead);
        String email = prop.getProperty("email");
        String pass = prop.getProperty("pass");
        String welcome = prop.getProperty("welcome");
       LoginPage loginPage = homePage.clickSignUpButton();
       loginPage.setEmailField(email);
       loginPage.setPasswordField(pass);
       AccountPage accountPage = loginPage.clickSignUpButton();
       assertEquals(accountPage.getAlertText(), welcome, "Incorect data");

    }
}
