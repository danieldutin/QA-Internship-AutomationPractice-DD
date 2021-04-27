package CreateAcc;

import base.BaseTests;
import org.testng.annotations.Test;
import page.CreateAccountPage;
import page.HomePage;
import page.NewUserPage;
import helper.ConfigFileReader;

import static org.testng.Assert.assertTrue;

public class CreateAccTests extends BaseTests {


    @Test
    public void validEmailTest() throws Exception {

        HomePage homePage = new HomePage(startWebDriver());

        ConfigFileReader reader = new ConfigFileReader();
        String email = reader.getProperty("newEmail");
        String authentication = reader.getProperty("authentication");

        CreateAccountPage createAccountPage = homePage.clickSignUpButtonCreate();
        createAccountPage.setEmailField(email);
        NewUserPage newUserPage = createAccountPage.clickCreateButton();

        String actualContent = newUserPage.getAlertText();
        assertTrue(actualContent.contains(authentication), "Alert is incorrect!");

    }

    /*@Test
    public void accountCreatedTest(){


    }*/
}
