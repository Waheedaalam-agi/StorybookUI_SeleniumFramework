package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonUI extends Constants {

    public static void openBrowser(String browser) {

        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
        } catch (Exception e) {
            System.out.println("browser name" + browser);
            e.printStackTrace();
        }
    }


    public static void radioButton(WebElement element) {
        element.click();
    }

    public static void checkBoxes(WebElement radio) {

        radio.click();

    }

    public void moveToElement(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();

        } catch (Exception e) {
            System.out.println("Element does not exists");
            e.printStackTrace();
        }
    }

    public void moveToElementAndClick(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
        } catch (Exception e) {
            System.out.println("Element does not exists");
            e.printStackTrace();
        }
    }

    public void dragAndDrop(WebElement source, WebElement target) {

        try {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).build().perform();

        } catch (Exception e) {
            System.out.println("Element does not exists");
            e.printStackTrace();
        }
    }

}
