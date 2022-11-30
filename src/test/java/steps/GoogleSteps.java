package steps;
import browserProvider.ReadPropertiesFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;
import utils.CommonUI;
import utils.ObjInitialize;
import utils.PropertyUtils;

public class GoogleSteps extends ObjInitialize {
    String url = PropertyUtils.getProperty("baseURL");

    @Given("User navigates to google home page")
    public void user_navigates_to_google_home_page() {
        CommonUI.openBrowser(PropertyUtils.getProperty("browser"));
        CommonUI.navigate(url);
        ObjInitialize.initializeClassObj();
    }
    @When("User searches for {string}")
    public void user_searches_for(String value) throws InterruptedException {
        googlePage.enterValueToSearchEngine(value);
        Thread.sleep(3000);
    }
    @Then("User verifies {string} is displayed on page")
    public void user_verifies_is_displayed_on_page(String text) {

        googlePage.verifyTextIsDisplayed(text);
        CommonUI.quitBrowser();
    }
}
