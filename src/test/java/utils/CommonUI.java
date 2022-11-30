package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class CommonUI extends Constants {

    public static String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("driver instance is NULL");
            e.printStackTrace();
            return null;
        }
    }

    public void click(WebElement element) {

        if (isDisplayed(element)) {
            element.click();
        }
    }

    public static String getText(WebElement element) {
        String text = null;

        if (isDisplayed(element)) {
            text = element.getText();
        }
        return text;
    }
    public static void enter(WebElement element, String value) {

        if (isDisplayed(element)) {
            element.clear();
            element.sendKeys(value);
        }
    }

    public static void rightClick(WebElement element){
        try {
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();
        }
        catch (Exception e) {
            System.out.println("Webelement not found.");
            e.printStackTrace();
        }
    }

    public static void takeScreenShot(String saveAsFilePath) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(saveAsFilePath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public void waitForPageLoad(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            // to check if page is in ready state
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }
    //method to apply expcit wait on any given URL
    public void explicitWaitForURL(String strURL) {
        WebDriverWait wdWait = new WebDriverWait(driver, 150);
        wdWait.until(ExpectedConditions.urlContains(strURL));
    }
    public void scrollDown(){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript( "scroll down (-100,0)");
            Assert.assertTrue(true);
        }catch (NoSuchElementException sd){
            sd.printStackTrace();
        }
    }
    //method to apply explicit wait on any given Web driver list of elements
    public void explicitListWait(List<WebElement> ele) {
        waitForPageLoad(driver);
        WebDriverWait wdWait = new WebDriverWait(driver, 150);
        //wdWait.until(exceptedConditions.visiblilityOf(ele));
        wdWait.until(ExpectedConditions.visibilityOf(ele.get(0)));
    }
    }
