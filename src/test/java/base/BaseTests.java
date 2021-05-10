package base;

import helper.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import page.HomePage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    public WebDriver driver;
    protected HomePage homePage;


    public WebDriver startWebDriver(String browser) throws Exception {

        ConfigFileReader reader = new ConfigFileReader();
        ConfigFileReader fileReader = new ConfigFileReader();
        //String browser = fileReader.getDriverType();
        String url = fileReader.getApplicationUrl();
        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:

                throw new IllegalStateException("Error" + browser);

        }
        driver.get(url);

        homePage = new HomePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getRandomEmail() {
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

    @AfterMethod
    public void closingDown() {

        this.driver.quit();
    }
}
