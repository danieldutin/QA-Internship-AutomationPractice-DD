package CreateAcc;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AccountPage;
import page.CreateAccountPage;
import page.HomePage;
import page.NewUserPage;
import helper.ConfigFileReader;

import static Constants.ConfigFileConstants.*;
import static org.testng.Assert.assertTrue;

public class CreateAccTests extends BaseTests {

    ConfigFileReader reader = new ConfigFileReader();

    @Test
    @Parameters("browser")
    public void validEmailTest(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        String email = getRandomEmail() + "@email.com";
        String confirmation = reader.getProperty(authentication);

        CreateAccountPage createAccountPage = homePage.clickSignUpButtonCreate();
        createAccountPage.setEmailField(email);
        NewUserPage newUserPage = createAccountPage.clickCreateButton();

        String actualContent = newUserPage.getAlertText();
        assertTrue(actualContent.contains(confirmation), "Alert is incorrect!");

    }

    @Test
    @Parameters("browser")
    public void accountCreatedTest(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        CreateAccountPage createAccountPage = homePage.clickSignUpButtonCreate();
        createAccountPage.setEmailField(getRandomEmail() + "@email.com");
        NewUserPage newUserPage = createAccountPage.clickCreateButton();

        newUserPage.setTitle(reader.getProperty(checkBoxTitle));
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

        AccountPage accountPage = newUserPage.clickRegButton();

        String myAccountText = accountPage.getAlertText();

        assertTrue(myAccountText.contains(reader.getProperty(confirmed)), "Incorrect data");

    }

}
