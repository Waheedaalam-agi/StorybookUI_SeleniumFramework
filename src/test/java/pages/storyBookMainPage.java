package pages;

import browserProvider.ReadPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import utils.CommonUI;

public class storyBookMainPage extends CommonUI {

    @FindBy(id = "login_field")
    WebElement gitUser;

    @FindBy(id = "password")
    WebElement gitPass;

    @FindBy(id ="storybook-explorer-searchfield")
    WebElement searchField;


    public storyBookMainPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterCreds(){
        gitUser.sendKeys("walam@arisglobal.com");
        gitPass.sendKeys("");
    }
    public void enterValueToSearchField(String value){
        searchField.sendKeys(value);
        searchField.sendKeys(Keys.ENTER);
    }
    public void verifyTextIsDisplayed(String text){
        WebElement element = driver.findElement(By.xpath("//*"));

        Assertion softAssert = new Assertion();
        softAssert.assertEquals(element.getText(), text);
        System.out.println( element.getText());
    }
}

