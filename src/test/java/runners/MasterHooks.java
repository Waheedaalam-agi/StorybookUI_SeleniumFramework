package runners;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonUI;
import utils.ObjInitialize;

public class MasterHooks {

    @Before
    public void setup() throws Exception {
        //CommonUI.navigate();
        //ReadPropertiesFile.setBrowser();
        ObjInitialize.initializeClassObj();
    }
    @After
    public void tearDown(){
        CommonUI.quitBrowser();
    }
}

