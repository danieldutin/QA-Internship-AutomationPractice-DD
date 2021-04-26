package base;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.CreateAccount;
import page.NewUserPage;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccTests extends BaseTests{

    @Test
    public void validEmailTest() throws Exception{

        FileInputStream propRead = new FileInputStream("resources\\config.properties");
        Properties prop = new Properties();
        prop.load(propRead);
        String email = prop.getProperty("newEmail");

        CreateAccount createAccount = homePage.clickSignUpButtonCreate();
        createAccount.setEmailField(email);
        //createAccount.clickCreateButton();

        NewUserPage newUserPage = createAccount.clickCreateButton();

        boolean present;
        try {
            driver.findElement(By.id("account-creation_form"));
            present = true;
        } catch (NoSuchElementException e){
            present = false;
        }

        assertTrue(present);


    }

    @Test
    public void accountCreatedTest(){


    }
}
