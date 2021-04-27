package CreateAcc;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.CreateAccount;
import page.HomePage;
import page.NewUserPage;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class CreateAccTests extends BaseTests {

    @Test
    public void validEmailTest() throws Exception{

        FileInputStream propRead = new FileInputStream("resources\\config.properties");
        Properties prop = new Properties();
        prop.load(propRead);

        String email = prop.getProperty("newEmail");
        String authentication = prop.getProperty("authentication");

        CreateAccount createAccount = homePage.clickSignUpButtonCreate();
        createAccount.setEmailField(email);
        NewUserPage newUserPage = createAccount.clickCreateButton();

        String actualContent = newUserPage.getAlertText();
        assertTrue(actualContent.contains(authentication),"Alert is incorrect!");

    }

    /*@Test
    public void accountCreatedTest(){


    }*/
}
