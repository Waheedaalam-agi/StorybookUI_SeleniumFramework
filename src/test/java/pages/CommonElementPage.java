package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUI;

public class CommonElementPage extends CommonUI {
    @FindBy(xpath="//* ")
    WebElement pageHeader;

    @FindBy(xpath="//* ")
    WebElement click;


public CommonElementPage () {
PageFactory.initElements (driver, this);

}

}

