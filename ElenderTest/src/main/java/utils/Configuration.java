package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    public static Properties properties;

    public Configuration() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(("src/test/properties/env.properties"));
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException", e);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }
}
