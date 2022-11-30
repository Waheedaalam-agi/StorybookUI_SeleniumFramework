package tests;

import utils.CommonUI;

import static utils.ObjInitialize.initializeClassObj;

public class googleTest extends CommonUI {
    public static String url = "https://www.google.com/";

    public static void main(String[] args) {
        openBrowser("chrome");
        navigate(url);
        initializeClassObj();
        verifySearch();
        quitBrowser();

    }

    public static void verifySearch(){
        googlePage.enterValueToSearchEngine("ArisGlobal");
        googlePage.verifyTextIsDisplayed("Miami, FL");
    }

}
