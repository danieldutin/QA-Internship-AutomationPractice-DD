package helper;

import org.testng.Assert;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static constants.ConfigFileConstants.*;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        try {
            FileReader reader = new FileReader(propertyFilePath);
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public String getApplicationUrl() {
        String currentUrl = properties.getProperty(url);
        if (currentUrl == null)
            Assert.fail("Application Url not specified in the Configuration.properties file for the Key:url");
        return currentUrl;
    }

    public String getDriverType() {
        String browserType = properties.getProperty(browser);
        if (browserType == null)
            Assert.fail("Browser is not specified in the Configuration.properties file");
        return browserType;
    }
}
