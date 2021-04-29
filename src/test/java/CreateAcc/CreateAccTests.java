package CreateAcc;

import base.BaseTests;
import com.beust.jcommander.IStringConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AccountPage;
import page.CreateAccountPage;
import page.HomePage;
import page.NewUserPage;
import helper.ConfigFileReader;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class CreateAccTests extends BaseTests {

    ConfigFileReader reader = new ConfigFileReader();

    @Test
    @Parameters("browser")
    public void validEmailTest(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        String email = getRandomEmail() + "@email.com" ;
        String authentication = reader.getProperty("authentication");

        CreateAccountPage createAccountPage = homePage.clickSignUpButtonCreate();
        createAccountPage.setEmailField(email);
        NewUserPage newUserPage = createAccountPage.clickCreateButton();

        String actualContent = newUserPage.getAlertText();
        assertTrue(actualContent.contains(authentication), "Alert is incorrect!");

    }

    @Test
    @Parameters("browser")
    public void accountCreatedTest(String browser) throws Exception {

        HomePage homePage = new HomePage(startWebDriver(browser));

        String email = getRandomEmail() + "@email.com";
        String title = reader.getProperty("title");
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

        newUserPage.setTitle(title);
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

        String myAccountText = accountPage.getAlertText();

        assertTrue(myAccountText.contains(welcome), "Incorrect data");

    }

    protected String getRandomEmail() {
        String charsRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomiser = new StringBuilder();
        Random rnd = new Random();
        while (randomiser.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * charsRange.length());
            randomiser.append(charsRange.charAt(index));
        }
        String emailLocalPart = randomiser.toString();
        return emailLocalPart;
    }

}
