package CreateAcc;

import base.BaseTests;
import helper.ConfigFileReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AccountPage;
import page.CreateAccountPage;
import page.HomePage;
import page.NewUserPage;


import java.util.Random;

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

    @Test
    @Parameters("browser")
    public void titleFieldNegativeTest(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        String email = getRandomEmail() + "@email.com";
        String firstName = reader.getProperty("firstName");
        String lastName = reader.getProperty("lastName");
        String passWord = reader.getProperty("passWord");
        String addressLineOne = reader.getProperty("addressLineOne");
        String cityInput = reader.getProperty("cityInput");
        String zipCode = reader.getProperty("zipCode");
        String mobileP = reader.getProperty("mobileP");
        String welcome = reader.getProperty("welcome");

        CreateAccountPage createAccountPage = homePage.clickSignUpButtonCreate();
        createAccountPage.setEmailField(email);
        NewUserPage newUserPage = createAccountPage.clickCreateButton();

        newUserPage.setFirstName(firstName);
        newUserPage.setLastName(lastName);
        newUserPage.setPassword(passWord);
        newUserPage.selectDayDropDown();
        newUserPage.selectMonthDropDown();
        newUserPage.selectYearDropDown();
        newUserPage.setAddressLineOne(addressLineOne);
        newUserPage.setCity(cityInput);
        newUserPage.selectStateDropDown();
        newUserPage.setZipCode(zipCode);
        newUserPage.setMobileP(mobileP);

        AccountPage accountPage = newUserPage.clickRegButton();

        String errorText = accountPage.getAlertText();

        assertTrue(errorText.contains(welcome), "Incorrect data");

    }

}
