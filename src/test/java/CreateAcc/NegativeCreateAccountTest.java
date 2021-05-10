package CreateAcc;

import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AccountPage;
import page.CreateAccountPage;
import page.HomePage;
import page.NewUserPage;

import static org.testng.Assert.assertTrue;

public class NegativeCreateAccountTest extends BaseTests {

    ConfigFileReader reader = new ConfigFileReader();

    @Test
    @Parameters("browser")
    public void invalidEmailTest(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        String email = reader.getProperty("negativeEmailCreate");
        String errorMessage = reader.getProperty("invalidEmailMessage");

        CreateAccountPage createAccountPage = homePage.clickSignUpButtonCreate();
        createAccountPage.setEmailField(email);
        createAccountPage.clickCreateButton();

        String actualContent = createAccountPage.getAlertTextInvalidEmail();
        assertTrue(actualContent.contains(errorMessage));

    }

}
