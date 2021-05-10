package CreateAcc;

import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AccountPage;
import page.CreateAccountPage;
import page.HomePage;
import page.NewUserPage;
import static Constants.ConfigFileConstants.*;
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
        Thread.sleep(2000);

        String actualContent = createAccountPage.getAlertTextInvalidEmail();
        assertTrue(actualContent.contains(errorMessage));

    }

    @Test
    @Parameters("browser")
    public void titleFieldNegativeTest(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        CreateAccountPage createAccountPage = homePage.clickSignUpButtonCreate();
        createAccountPage.setEmailField(getRandomEmail() + "@email.com");
        NewUserPage newUserPage = createAccountPage.clickCreateButton();

        newUserPage.setFirstName(reader.getProperty(name));
        newUserPage.setLastName(reader.getProperty(surName));
        newUserPage.setPassword(reader.getProperty(passWord));
        newUserPage.selectDayDropDown();
        newUserPage.selectMonthDropDown();
        newUserPage.selectYearDropDown();
        newUserPage.setAddressLineOne(reader.getProperty(lineOne));
        newUserPage.setCity(reader.getProperty(city));
        newUserPage.selectStateDropDown();
        newUserPage.setZipCode(reader.getProperty(zip));
        newUserPage.setMobileP(reader.getProperty(mobile));
        Thread.sleep(2000);

        AccountPage accountPage = newUserPage.clickRegButton();

        String errorText = accountPage.getAlertText();

        assertTrue(errorText.contains(reader.getProperty(invalidEmailMessage)), "Incorrect data");
    }
}
