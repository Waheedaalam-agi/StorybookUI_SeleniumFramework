package browserProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.Constants;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile extends Constants {

    public static String setBrowser() throws Exception{

        FileInputStream file = new FileInputStream(System.getProperty(("user.dir")) + "\\config\\config.properties");

        Properties prop = new Properties();
        prop.load(file);
        String browserName = prop.getProperty("browser");
        System.out.println("Current Browser: " + browserName);
        return browserName;
    }

    public static String setURL() throws Exception{

        FileInputStream file = new FileInputStream(System.getProperty(("user.dir")) + "\\config\\config.properties");
        Properties prop = new Properties();
        prop.load(file);
        String baseURL = prop.getProperty("baseURL");
        System.out.println("Base URL: " + baseURL);
        return baseURL;
    }
    }
