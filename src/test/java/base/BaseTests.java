package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class BaseTests {

    public static WebDriver driver = new ChromeDriver();
    public static String browser;
    public static String url;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();

    }

    public void propertiesReader() throws Exception{

        FileInputStream propRead = new FileInputStream("C:\\Users\\danie\\IdeaProjects\\QA-Internship-AutomationPractice-DD\\resources");

        Properties prop = new Properties();

        prop.load(propRead);

        url = prop.getProperty("url");
        browser = prop.getProperty("browser");

    }

    @AfterMethod
    public void closingDown(){

        this.driver.close();
    }
}
