package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import utils.CommonUI;

public class GooglePage extends CommonUI {

    @FindBy(xpath = "//input[@title='Search']")
    WebElement searchField;

    public GooglePage(){

        PageFactory.initElements(driver, this);
    }

//    public void navigateToGoogle() throws InterruptedException {
//        String url = "https://www.google.com/";
//        navigate(url);
//    }
    public void enterValueToSearchEngine(String value){
        searchField.sendKeys(value);
        searchField.sendKeys(Keys.ENTER);
    }

    public void verifyTextIsDisplayed(String text){
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));

        Assertion softAssert = new Assertion();
        softAssert.assertEquals(element.getText(), text);
        System.out.println( element.getText());
    }
    }