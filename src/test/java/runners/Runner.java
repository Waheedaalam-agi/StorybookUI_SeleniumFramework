package runners;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/", glue = ".steps",
        plugin = {"pretty", "html:target/cucumber-report/cucumber-report.html",
                            "json:target/cucumber-report/cucumber-json-report.json",
                            "junit:target/cucumber-report/junit-report.xml",
                            //"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"
        },
        monochrome = true,
        tags = "@test"
)
public class Runner {

        @AfterClass
        public static void generateReport() {
            try {

                File reportOutputDirectory = new File("target");

                List<String> jsonFiles = new ArrayList<>();
                jsonFiles.add("target/cucumber-report/cucumber-json-report.json");
                String projectName = "UI-React";

                Configuration configuration = new Configuration(reportOutputDirectory, projectName);
                // configuration.setBuildNumber("1");
                // optional configuration - check javadoc for details
                configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
                configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
                configuration.addClassifications("Platform", "Windows");
                configuration.addClassifications("Browser", "Chrome");
                configuration.addClassifications("Branch", "release/1.0");
                configuration.setSortingMethod(SortingMethod.NATURAL);
                configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
                configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);

                // optionally add metadata presented on main page via properties file
                List<String> classificationFiles = new ArrayList<>();
                classificationFiles.add("cucumber-reporting.properties");

                configuration.setTrendsStatsFile(new File("target/test-classes/demp-trends.json"));

                ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
                @SuppressWarnings("unused")
                Reportable result = reportBuilder.generateReports();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
//for extent report
//                Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
////Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
//                Reporter.setSystemInfo("User Name", "AJ");
//                Reporter.setSystemInfo("Application Name", "Test App ");
//                Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
//                Reporter.setSystemInfo("Environment", "Production");
//                Reporter.setTestRunnerOutput("Test Execution Cucumber Report");