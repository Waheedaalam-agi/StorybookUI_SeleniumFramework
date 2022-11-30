package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static String getProperty(String propertyName) {

        String propToString = "";

        Properties prop = new Properties();

        FileInputStream file = null;
        try {
            file = new FileInputStream(System.getProperty("user.dir") +"/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //rename to readPropFile
        propToString = prop.getProperty(propertyName);
        return propToString;
    }
}

