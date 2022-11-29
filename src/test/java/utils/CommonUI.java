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
    public static void navigate(String url) {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);
        } catch (Exception e) {
            System.out.println(url);
            e.printStackTrace();
        }
    }
    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();

        } catch (Exception e) {

            System.out.println("Element is not displayed:" + element);
            e.printStackTrace();

            return false;
        }
    }

    public static boolean isEnabled(WebElement element) {
        try {

            return element.isEnabled();

        } catch (Exception e) {

            System.out.println("Element is not enabled or does not exists:" + element);
            e.printStackTrace();

            return false;
        }
    }

    public static boolean isSelected(WebElement element) {
        try {

            return element.isSelected();

        } catch (Exception e) {

            System.out.println("Element does not exists:" + element);
            e.printStackTrace();
            return false;
        }
    }
    public static void selectFromDropdown(WebElement element, String methodName, String indexTextValue) {
        try {
            Select obj = new Select(element);
            methodName = methodName.toLowerCase();
            if (methodName.contains("index")) {
                int index = Integer.parseInt(indexTextValue);
                obj.selectByIndex(index);
            } else if (methodName.contains("value")) {
                obj.selectByValue(indexTextValue);
            } else if (methodName.contains("text")) {
                obj.selectByVisibleText(indexTextValue);
            } else {
                System.out.println("Dropdown can be selected only with [index,value, or text] check your parameters.");
            }
        } catch (Exception e) {
            System.out.println("Unable to find dropdown webelement: " + element);
            e.printStackTrace();
        }
    }
    public static boolean isAlertPresent() {
        boolean isAlert = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
                isAlert = true;
            }
        } catch (NoAlertPresentException e) {
            System.out.println("Alert is not present");
            e.printStackTrace();
        }
        return isAlert;
    }

    public static void acceptAlert() {
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public static void dismissAlert() {
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }
    public static void quitBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Driver object is null");
            e.printStackTrace();
        }
    }
}
