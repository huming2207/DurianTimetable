package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings
{
    private Properties properties;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static Settings settings = new Settings();

    public static Settings getInstance()
    {
        return settings;
    }

    private Settings()
    {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("app.properties"));
        } catch (IOException exception) {
            logger.error("Cannot load configuration file, reason comes below");
            logger.error(exception.getLocalizedMessage());
        }
    }

    public String getSetting(String key)
    {
        return properties.getProperty(key);
    }
}
