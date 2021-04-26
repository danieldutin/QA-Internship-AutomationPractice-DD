package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    public WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
     public WebDriver createWebDriver() throws Exception{

        FileInputStream propRead = new FileInputStream("C:\\Users\\danie\\IdeaProjects\\QA-Internship-AutomationPractice-DD\\resources");

        Properties prop = new Properties();

        prop.load(propRead);


       String browser = prop.getProperty("browser");
       String url = prop.getProperty("url");

        prop.load(propRead);
        switch (browser){

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

    @AfterClass
    public void closingDown(){

        this.driver.quit();
    }
}
